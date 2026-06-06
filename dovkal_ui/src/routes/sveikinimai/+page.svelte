<script lang="ts">
	import { resolvePath } from '$lib/utils/utils';
	import { Button } from 'flowbite-svelte';
	import Footer from '$lib/components/common/Footer.svelte';
	import TopBanner from '$lib/components/common/TopBanner.svelte';
	import type { PageData } from './$types';
	import { SITE_NAME, SITE_URL } from '$lib/utils/constants';

	let { data }: { data: PageData } = $props();

	const pages = $derived(data.pages);
	const canonicalUrl = `${SITE_URL}/sveikinimai/`;
</script>

<svelte:head>
	<title>Kalėdiniai sveikinimai | {SITE_NAME}</title>
	<meta
		name="description"
		content="Kalėdiniai sveikinimai vaikams, mamai, tėvams, draugams, kolegoms ir mokytojai. Sukurkite personalizuotą Kalėdų Senelio video sveikinimą vos per kelias minutes."
	/>
	<meta name="robots" content="index, follow, max-image-preview:large" />
	<link rel="canonical" href={canonicalUrl} />

	<meta property="og:locale" content="lt_LT" />
	<meta property="og:type" content="website" />
	<meta property="og:site_name" content={SITE_NAME} />
	<meta property="og:title" content={`Kalėdiniai sveikinimai | ${SITE_NAME}`} />
	<meta
		property="og:description"
		content="Raskite kam skirtą Kalėdų Senelio video sveikinimą norite sukurti ir užsisakykite personalizuotą sveikinimą internetu."
	/>
	<meta property="og:url" content={canonicalUrl} />
</svelte:head>

<TopBanner
	text="Kalėdinis sveikinimas tik nuo 8,99 €. Nepraleiskite progos pralinksminti artimuosius!"
	homeLinkText="Sužinokite daugiau"
	height={120}
/>

<main class="bg-white">
	<section class="mx-auto mt-15 max-w-5xl px-4 py-16 text-center sm:px-6 lg:px-8 lg:py-20">
		<p class="mb-3 text-sm font-semibold tracking-wide text-red uppercase">
			Kalėdų Senelio video sveikinimai
		</p>

		<h1 class="text-3xl leading-tight font-bold tracking-tight text-gray-950 sm:text-4xl xl:text-5xl">
			Kalėdiniai sveikinimai skirtingiems žmonėms
		</h1>

		<p class="mx-auto mt-5 max-w-3xl text-base leading-7 text-gray-700 sm:text-lg">
			Pasirinkite, kam norite sukurti personalizuotą Kalėdų Senelio video sveikinimą.
			Sveikinimą galite pritaikyti vaikams, draugams, šeimos nariams, kolegoms ar mokytojai.
		</p>
	</section>

	<section class="mx-auto max-w-7xl px-4 pb-16 sm:px-6 lg:px-8">
		<div class="grid gap-6 sm:grid-cols-2 lg:grid-cols-3">
			{#each pages as page (page.slug)}
				<a
					href={resolvePath(`/sveikinimai/${page.slug}/`)}
					class="group flex h-full flex-col rounded-2xl border border-gray-200 bg-white p-6 shadow-sm transition hover:-translate-y-1 hover:border-red-light hover:shadow-lg"
				>
					<h2 class="text-xl font-bold tracking-tight text-gray-950 group-hover:text-red">
						{page.title}
					</h2>

					<p class="mt-3 flex-1 text-base leading-7 text-gray-700">
						{page.description}
					</p>

					<span class="mt-5 text-sm font-bold text-red">
						Skaityti daugiau →
					</span>
				</a>
			{/each}
		</div>
	</section>

	<hr class="mx-auto max-w-3xl border-gray-200" />

	<section class="px-4 py-12 text-center sm:px-6 lg:px-8">
		<h2 class="text-2xl font-bold tracking-tight text-gray-950 md:text-3xl">
			Norite sukurti sveikinimą dabar?
		</h2>

		<p class="mx-auto mt-4 max-w-2xl text-base leading-7 text-gray-700 sm:text-lg">
			Parašykite savo tekstą, pasirinkite Kalėdų Senelio šabloną ir gaukite video sveikinimą vos per kelias minutes.
		</p>

		<div class="mt-7">
			<Button
				href={resolvePath('/#sukurti-sveikinima')}
				class="bg-red px-12 py-4 text-lg font-bold hover:bg-red-dark sm:min-w-72 sm:text-xl"
			>
				Sukurti sveikinimą
			</Button>
		</div>
	</section>

	<Footer />
</main>