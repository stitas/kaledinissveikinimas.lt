<script lang="ts">
	import { resolve } from '$app/paths';

	type Props = {
		text: string;
		homeLinkText?: string;
		height?: number;
	};

	let { text, homeLinkText, height = 240 }: Props = $props();

	let showTopBanner = $state(true);

	function handleScroll() {
		showTopBanner = window.scrollY < height;
	}
</script>

<svelte:window onscroll={handleScroll} />

{#if showTopBanner}
	<div class="fixed inset-x-0 top-0 z-50 bg-red text-white shadow-md">
		<div class="mx-auto max-w-7xl px-4 py-2 text-center text-sm leading-5 font-semibold sm:py-3 md:text-base">
			{text}
			{#if homeLinkText}
				<a href={resolve('/')} class="ml-2 inline-block text-white underline underline-offset-4 hover:text-red-light">
					{homeLinkText}
				</a>
			{/if}
		</div>
	</div>
{/if}
