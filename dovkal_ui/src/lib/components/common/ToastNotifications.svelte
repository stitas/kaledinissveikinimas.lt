<script lang="ts">
	import { Toast, ToastContainer } from 'flowbite-svelte';
	import { fly } from 'svelte/transition';
	import { onDestroy } from 'svelte';

	type ToastColor = 'green' | 'red' | 'yellow' | 'blue';

	type ToastItem = {
		id: number;
		message: string;
		color: ToastColor;
		visible: boolean;
		timeoutId?: ReturnType<typeof setTimeout>;
	};

	type Props = {
		message?: string;
		color?: ToastColor;
		duration?: number;
	};

	let { message, color = 'red', duration = 5000 }: Props = $props();

	let toasts = $state<ToastItem[]>([]);
	let nextToastId = $state(1);
	let lastMessage = $state<string | undefined>(undefined);

	$effect(() => {
		if (message && message !== lastMessage) {
			addToast(message, color);
			lastMessage = message;
		}
	});

	function addToast(message: string, color: ToastColor) {
		const newToast: ToastItem = {
			id: nextToastId,
			message,
			color,
			visible: true
		};

		newToast.timeoutId = setTimeout(() => {
			dismissToast(newToast.id);
		}, duration);

		toasts = [...toasts, newToast];
		nextToastId++;
	}

	function dismissToast(id: number) {
		const toast = toasts.find((toast) => toast.id === id);

		if (toast?.timeoutId) {
			clearTimeout(toast.timeoutId);
		}

		toasts = toasts.map((toast) => (toast.id === id ? { ...toast, visible: false } : toast));

		setTimeout(() => {
			toasts = toasts.filter((toast) => toast.id !== id);
		}, 300);
	}

	function handleClose(id: number) {
		return () => dismissToast(id);
	}

	onDestroy(() => {
		toasts.forEach((toast) => {
			if (toast.timeoutId) {
				clearTimeout(toast.timeoutId);
			}
		});
	});
</script>

<ToastContainer position="bottom-right">
	{#each toasts as toast (toast.id)}
		<Toast
			dismissable={true}
			transition={fly}
			params={{ x: 200, duration: 400 }}
			class="flowbite-toast w-80 border! border-red-light! bg-white! text-gray-950! shadow-xl! dark:border-red-light! dark:bg-white! dark:text-gray-950!"
			onclose={handleClose(toast.id)}
			bind:toastStatus={toast.visible}
		>
			<div class="flex items-start gap-3 bg-white! dark:bg-white!">
				<div class="flex h-8 w-8 shrink-0 items-center justify-center rounded-full bg-red-light text-sm font-bold text-red">
					!
				</div>

				<div class="min-w-0 flex-1">
					<p class="font-bold text-gray-950! dark:text-gray-950!">Klaida</p>
					<p class="mt-1 text-sm text-gray-600! dark:text-gray-600!">
						{toast.message}
					</p>
				</div>
			</div>
		</Toast>
	{/each}
</ToastContainer>

<style>
	:global(.flowbite-toast button) {
		background-color: white !important;
		color: #6b7280 !important;
	}

	:global(.flowbite-toast button:hover) {
		background-color: #fee2e2 !important;
		color: #b91c1c !important;
	}

	:global(.flowbite-toast button svg) {
		color: #6b7280 !important;
	}

	:global(.flowbite-toast button:hover svg) {
		color: #b91c1c !important;
	}
</style>