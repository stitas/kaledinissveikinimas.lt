<script lang="ts">
	import { resolve } from '$app/paths';
	import { Button } from 'flowbite-svelte';
	import InfoTooltip from '$lib/components/common/InfoTooltip.svelte';
	import type { Locale, SantaType } from '$lib/server/payment';
	import type { ActionData } from '../../../routes/$types';
	import { enhance } from '$app/forms';
	import type { SubmitFunction } from '@sveltejs/kit';

	type SantaTemplate = {
		id: string;
		santaType: SantaType;
		name: string;
		image: string;
		alt: string;
	};

	type GreetingTemplate = {
		id: string;
		label: string;
		text: string;
	};

	type Checkpoint = {
		value: number;
		label: string;
	};

	type Props = {
		formId?: string;
		maxCharacters?: number;
		form: ActionData;
	};

	let { formId = 'sukurti-sveikinima', maxCharacters = 1500 }: Props = $props();

	const templates: SantaTemplate[] = [
		{
			id: 'classic-santa',
			santaType: 'CLASSIC',
			name: 'Klasikinis Kalėdų Senelis',
			image: '/images/kaledu-senelis/kaledu-senelis-savo-namuose.webp',
			alt: 'Klasikinis Kalėdų Senelis jaukiame kalėdiniame kambaryje'
		},
		{
			id: 'sleigh-santa',
			santaType: 'SLEIGH',
			name: 'Kalėdų Senelis lauke prie rogių',
			image: '/images/kaledu-senelis/kaledu-senelis-lauke-prie-rogiu.webp',
			alt: 'Kalėdų Senelis lauke žiemos fone prie rogių'
		},
		{
			id: 'chimney-santa',
			santaType: 'CHIMNEY',
			name: 'Kalėdų Senelis ant stogo prie kamino',
			image: '/images/kaledu-senelis/kaledu-senelis-ant-stogo-prie-kamino.webp',
			alt: 'Kalėdų Senelis lauke ant namo stogo prie kamino'
		}
	];

	const greetingTemplates: GreetingTemplate[] = [
		{
			id: 'children',
			label: 'Vaikams',
			text: `Ho ho ho!\n\nSveikas, [vardas]!\n\nČia Kalėdų Senelis. Visus metus stebėjau tavo elgėsį ir turiu pasakyti, kad didžiuojuosi tavimi. Šiais metais buvai labai geras vaikas, todėl turiu tau gerų žinių. Tavo vardą jau užsirašiau į ypatingų dovanų sąrašą. Elfai dirba iš peties, o aš nekantrauju kalėdų nakti aplankyti tavo namus.\n\nNepamiršk ir toliau klausyti mamos bei tėčio, būti mandagus, draugiškas ir padėti kitiems, kad kitais metais vėl atsidurtum mano sąraše.\n\nLinkiu tau daug džiaugsmo, skanių saldainių, o svarbiausia linksmų ir stebuklingų kalėdų.\n\nIki Kalėdų, Rokai!`
		},
		{
			id: 'friends',
			label: 'Draugams',
			text: "Ho ho ho!\n\nSveikas, [vardas]! Čia Kalėdų Senelis. Gavau nemažai informacijos apie tave iš [jūsų vardas], todėl šiemet dovanų negausi. Na, gerai, juokauju - kažką gausi, nors [kažkoks gėdingas draugo momentas] tikrai nebuvo pliusas tavo sąraše.\n\nMetai buvo ilgi, todėl dabar metas pailsėti, gerai pavalgyti ir pasidžiaugti šventėmis... Man. O tau, [draugo vardas], užteks tinginiauti - metas pradėti eiti į sporto salę.\n\nLinkiu tau daug juoko, geros nuotaikos ir kuo mažiau rytų, kai tenka prisiminti, kokias nesąmones darei vakar. Tegul kitais metais netrūksta sėkmės, įdomių nuotykių ir progų pasijuokti iš savęs.\n\nLinksmų Kalėdų ir laimingų Naujųjų metų!"
		},
		{
			id: 'colleagues',
			label: 'Kolegoms',
			text: `Ho ho ho!\n\nSveiki, kolegos!\n\nČia Kalėdų Senelis. Gavau specialų dovanos užsakymą nuo jūsų kolegos [jūsų vardas].\n\nNoriu padėkoti už jūsų darbą, kantrybę ir pastangas šiais metais. Kiekviena diena atneša naujų iššūkių, tačiau būtent jūsų atkaklumas, pagalba vieni kitiems ir gera nuotaika padeda juos įveikti\n\nLinkiu jaukių Kalėdų, ramaus poilsio, daug šventinės nuotaikos ir sėkmingų ateinančių metų. Tegul po švenčių sugrįžta ne tik motyvacija, bet ir pilnai įkrautos baterijos!\n\nLinksmų Kalėdų ir laimingų Naujųjų metų!\n\nSu šilčiausiais linkėjimais,\nKalėdų Senelis`
		}
	];

	function applyGreetingTemplate(text: string) {
		message = text;
	}

	const checkpoints: Checkpoint[] = [
		{ value: 0, label: '0' },
		{ value: 375, label: '375' },
		{ value: 750, label: '750' },
		{ value: 1125, label: '1125' },
		{ value: 1500, label: '1500' }
	];

	let selectedTemplateId = $state(templates[0].id);
	let selectedSantaType = $derived(
		templates.find((template) => template.id === selectedTemplateId)?.santaType ?? 'CLASSIC'
	);
	let selectedLanguage: Locale = $state('LT');
	let message = $state('');
	let email = $state('');
	let hasAcceptedTerms = $state(false);

	let characterCount = $derived(message.length);
	let remainingCharacters = $derived(maxCharacters - characterCount);
	let isMessageTooLong = $derived(remainingCharacters < 0);

	let progressPercent = $derived(Math.min((characterCount / maxCharacters) * 100, 100));

	let currentPrice = $derived.by(() => {
		if (characterCount < 375) return '6,99';
		if (characterCount < 750) return '7,99';
		if (characterCount < 1125) return '8,99';
		return '9,99';
	});

	let canSubmit = $derived(
		message.trim().length > 0 
		&& email.trim().length > 0 
		&& !isMessageTooLong
		&& hasAcceptedTerms
	);

	let btnText = $derived.by(() => {
		if (!message) return 'Užpildykite sveikinimo tekstą';
		if (!email) return 'Įveskite savo el. pašto adresą';
		return `Sukurti Kalėdų Senelio video už ${currentPrice}€`;
	});

	let isSubmitting = $state(false);
	const handleSubmit: SubmitFunction = () => {
		isSubmitting = true;

		return async ({ result, update }) => {
			await update({ reset: false });

			if (result.type === 'failure') {
				isSubmitting = false;
			}
		};
	};
</script>

<section id={formId} aria-labelledby="creator-title" class="mx-auto mb-14 max-w-6xl px-4 pb-8 lg:px-6">
	<form method="POST" action="?/createCheckout" use:enhance={handleSubmit} class="space-y-9">
		<input type="hidden" name="santaType" value={selectedSantaType} />

		<fieldset>
			<div class="mb-4 flex items-center gap-2">
				<span class="text-xl font-bold text-red md:text-2xl">1</span>
				<legend class="text-xl font-bold tracking-tight text-gray-950 md:text-2xl">
					Pasirinkite Kalėdų Senelio video šabloną
				</legend>
				<InfoTooltip text="Pasirinkite, kaip atrodys Kalėdų Senelis jūsų personalizuotame video sveikinime." />
			</div>

			<div class="grid grid-cols-1 gap-4 sm:grid-cols-3">
				{#each templates as template (template.id)}
					<button
						type="button"
						class={`relative overflow-hidden rounded-xl border-3 transition ${
							selectedTemplateId === template.id
								? 'border-red bg-red-light'
								: 'border-transparent hover:border-red-light'
						}`}
						aria-pressed={selectedTemplateId === template.id}
						aria-label={`Pasirinkti šabloną: ${template.name}`}
						onclick={() => (selectedTemplateId = template.id)}
					>
						<img
							src={template.image}
							alt={template.alt}
							width="480"
							height="270"
							class="aspect-video w-full object-cover"
							loading="lazy"
							decoding="async"
						/>

						{#if selectedTemplateId === template.id}
							<span class="absolute bottom-2 left-1/2 -translate-x-1/2 rounded-full bg-white px-3 py-1.5 text-xs font-bold text-red">
								Pasirinkta ✓
							</span>
						{/if}
					</button>
				{/each}
			</div>
		</fieldset>

		<div>
			<div class="mb-4 flex flex-wrap items-center justify-between gap-3">
				<div class="flex flex-wrap items-center gap-2">
					<span class="text-xl font-bold text-red md:text-2xl">2</span>
					<label for="greeting-text" class="text-xl font-bold tracking-tight text-gray-950 md:text-2xl">
						Parašykite sveikinimo tekstą
					</label>

					<InfoTooltip text="Jūsų parašytas tekstas bus įgarsintas Kalėdų Senelio balsu." />
				</div>

				<div class="flex items-center gap-2">
					<label for="greeting-language" class="text-sm font-medium text-gray-600 sm:text-base">
						Pasirinkite kalbą:
					</label>
					<select
						id="greeting-language"
						name="locale"
						bind:value={selectedLanguage}
						required
						class="w-36 rounded-xl border border-gray-300 bg-gray-50 py-2 pr-9 pl-4 text-sm font-medium text-gray-700 focus:border-red focus:ring-red sm:w-40 sm:text-base"
					>
						<option value='LT'>🇱🇹 Lietuvių</option>
						<option value='PL'>🇵🇱 Lenkų</option>
						<option value='EN'>🇬🇧 Anglų</option>
					</select>
				</div>
			</div>

			<textarea
				id="greeting-text"
				name="script"
				bind:value={message}
				maxlength={maxCharacters}
				rows="8"
				required
				spellcheck="false"
				class="w-full resize-none rounded-xl border border-gray-300 bg-gray-50 p-4 text-base text-gray-950 focus:border-red focus:ring-red sm:text-lg"
				placeholder="Pvz.: Labas, Rokai! Kalėdų Senelis labai tavimi didžiuojasi..."
			></textarea>

			<div class="mt-3 flex flex-wrap gap-2">
				{#each greetingTemplates as template (template.id)}
					<button
						type="button"
						class="rounded-full border border-red px-4 py-1.5 text-sm font-semibold text-red transition hover:bg-red hover:text-white"
						onclick={() => applyGreetingTemplate(template.text)}
					>
						{template.label}
					</button>
				{/each}
			</div>

			<div class="mt-4 grid gap-3 lg:grid-cols-[auto_1fr_auto] lg:items-center lg:gap-x-8 lg:gap-y-2">
				<p class={`w-36 shrink-0 text-sm font-medium tabular-nums sm:text-base ${isMessageTooLong ? 'text-red' : 'text-gray-700'}`}>
					Liko {remainingCharacters} simbolių
				</p>

				<div class="relative h-3 rounded-full bg-red-light">
					<div
						class="h-3 rounded-full bg-red transition-all duration-300"
						style={`width: ${progressPercent}%`}
					></div>

					{#each checkpoints as checkpoint (checkpoint.value)}
						<span
							class={`absolute top-1/2 h-4 w-4 -translate-x-1/2 -translate-y-1/2 rounded-full border-2 ${
								characterCount >= checkpoint.value ? 'border-red bg-red' : 'border-red bg-white'
							}`}
							style={`left: ${(checkpoint.value / maxCharacters) * 100}%`}
							aria-hidden="true"
						></span>
					{/each}
				</div>

				<div class="relative h-4 text-xs text-gray-500 lg:col-start-2">
					{#each checkpoints as checkpoint (checkpoint.value)}
						<span
							class="absolute -translate-x-1/2"
							style={`left: ${(checkpoint.value / maxCharacters) * 100}%`}
						>
							{checkpoint.label}
						</span>
					{/each}
				</div>

				<div class="flex h-9 items-center rounded-xl bg-red-light px-4 text-base font-bold text-red lg:col-start-3 lg:row-start-1">
					Kaina: {currentPrice} €
				</div>
			</div>
		</div>

		<div>
			<div class="mb-4 flex flex-wrap items-center gap-2">
				<span class="text-xl font-bold text-red md:text-2xl">3</span>
				<label for="email" class="text-xl font-bold tracking-tight text-gray-950 md:text-2xl">
					Įveskite el. paštą
				</label>
				<InfoTooltip text="Į šį el. paštą gausite nuorodą į video, kai jis bus sugeneruotas" />
			</div>

			<input
				id="email"
				name="email"
				type="email"
				autocomplete="email"
				bind:value={email}
				required
				class="w-full rounded-xl border border-gray-300 bg-gray-50 p-4 text-base text-gray-950 focus:border-red focus:ring-red sm:text-lg"
				placeholder="jusu@email.lt"
			/>
		</div>

		<label class="flex items-center gap-3 text-sm leading-6 text-gray-700 sm:text-base">
			<input
				type="checkbox"
				name="hasAcceptedTerms"
				value="true"
				bind:checked={hasAcceptedTerms}
				required
				class="h-5 w-5 shrink-0 rounded border-gray-300 text-red focus:ring-red"
			/>
			<span class="inline">
				Susipažinau ir sutinku su
				<a href={resolve('/naudojimo-taisykles')} class="font-semibold text-red underline-offset-4 hover:underline">
					naudojimo taisyklėmis
				</a>.
			</span>
		</label>

		<Button
			type="submit"
			disabled={!canSubmit || isSubmitting}
			class="w-full cursor-pointer bg-red px-6 py-4 text-lg font-bold hover:bg-red-dark disabled:cursor-not-allowed disabled:opacity-60"
		>
			{isSubmitting ? 'Nukreipiame į apmokėjimą...' : btnText}
		</Button>
	</form>
</section>
