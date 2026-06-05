type UmamiEventData = Record<string, string | number | boolean | undefined>;

type UmamiClient = {
	track: (eventName?: string, data?: UmamiEventData) => void;
};

type TrackableElement =
	| HTMLAnchorElement
	| HTMLButtonElement
	| HTMLInputElement
	| HTMLSelectElement
	| HTMLTextAreaElement
	| HTMLVideoElement;

const INPUT_SELECTOR = 'input:not([type="hidden"]), select, textarea';
const CLICK_SELECTOR = 'a[href], button';

function getUmami() {
	return window.umami;
}

function getElementName(element: Element) {
	if (
		element instanceof HTMLInputElement ||
		element instanceof HTMLSelectElement ||
		element instanceof HTMLTextAreaElement
	) {
		return (
			element.dataset.analyticsLabel ||
			element.getAttribute('aria-label') ||
			element.name ||
			element.id ||
			element.type ||
			element.tagName.toLowerCase()
		);
	}

	return (
		element.getAttribute('data-analytics-label') ||
		element.getAttribute('aria-label') ||
		element.textContent?.trim().replace(/\s+/g, ' ').slice(0, 80) ||
		element.id ||
		element.tagName.toLowerCase()
	);
}

function getPagePath() {
	return `${window.location.pathname}${window.location.search}${window.location.hash}`;
}

function getInputType(element: HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement) {
	if (element instanceof HTMLInputElement) return element.type;
	return element.tagName.toLowerCase();
}

function track(eventName: string, data: UmamiEventData) {
	getUmami()?.track(eventName, {
		page: getPagePath(),
		...data
	});
}

function getClickElement(target: EventTarget | null) {
	return target instanceof Element
		? target.closest<HTMLAnchorElement | HTMLButtonElement>(CLICK_SELECTOR)
		: null;
}

function getInputElement(target: EventTarget | null) {
	return target instanceof Element
		? target.closest<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>(INPUT_SELECTOR)
		: null;
}

export function trackInteractions(node: HTMLElement) {
	const usedInputs = new WeakSet<TrackableElement>();

	function handleClick(event: MouseEvent) {
		const element = getClickElement(event.target);
		if (!element || !node.contains(element)) return;

		const eventName =
			element.dataset.analyticsEvent ||
			(element instanceof HTMLAnchorElement ? 'link_click' : 'button_click');
		const href = element instanceof HTMLAnchorElement ? element.href : undefined;
		const targetPath =
			element instanceof HTMLAnchorElement
				? `${element.pathname}${element.search}${element.hash}`
				: undefined;
		const isAnchorLink = element instanceof HTMLAnchorElement && Boolean(element.hash);

		track(isAnchorLink ? 'anchor_click' : eventName, {
			element: getElementName(element),
			href,
			targetPath,
			text: element.textContent?.trim().replace(/\s+/g, ' ').slice(0, 80)
		});
	}

	function handleInput(event: Event) {
		const element = getInputElement(event.target);
		if (!element || !node.contains(element) || usedInputs.has(element)) return;

		usedInputs.add(element);

		track('input_used', {
			element: getElementName(element),
			field: element.name || element.id,
			inputType: getInputType(element)
		});
	}

	function handleVideoPlay(event: Event) {
		const element = event.target;
		if (!(element instanceof HTMLVideoElement) || !node.contains(element)) return;

		track('video_play', {
			element: getElementName(element),
			src: element.currentSrc || element.querySelector('source')?.src
		});
	}

	node.addEventListener('click', handleClick);
	node.addEventListener('focusin', handleInput);
	node.addEventListener('change', handleInput);
	node.addEventListener('play', handleVideoPlay, true);

	return {
		destroy() {
			node.removeEventListener('click', handleClick);
			node.removeEventListener('focusin', handleInput);
			node.removeEventListener('change', handleInput);
			node.removeEventListener('play', handleVideoPlay, true);
		}
	};
}

declare global {
	interface Window {
		umami?: UmamiClient;
	}
}
