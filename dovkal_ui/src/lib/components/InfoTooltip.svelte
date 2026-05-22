<script lang="ts">
    type Props = {
		text: string;
		label?: string;
	};

	let {
		text,
		label = 'Daugiau informacijos'
	}:Props = $props();
</script>

<span class="group relative inline-flex align-middle">
	<button
		type="button"
		aria-label={label}
		class="flex h-6 w-6 items-center justify-center rounded-full bg-red-light text-sm font-bold text-red transition hover:bg-red hover:text-white focus:bg-red focus:text-white focus:outline-none"
	>
		i
	</button>

	<span
		role="tooltip"
		class="pointer-events-none absolute left-1/2 top-full z-30 mt-3 w-72 -translate-x-1/2 rounded-2xl bg-gray-950 px-4 py-3 text-sm font-medium leading-6 text-white opacity-0 shadow-xl transition group-hover:opacity-100 group-focus-within:opacity-100"
	>
		{text}
		<span class="absolute bottom-full left-1/2 h-3 w-3 -translate-x-1/2 translate-y-1/2 rotate-45 bg-gray-950"></span>
	</span>
</span>