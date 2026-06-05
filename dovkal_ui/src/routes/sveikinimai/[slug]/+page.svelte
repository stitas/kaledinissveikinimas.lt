<script lang="ts">
	import { resolve } from '$app/paths';
	import { Button } from 'flowbite-svelte';
	import Footer from '$lib/components/common/Footer.svelte';
	import TopBanner from '$lib/components/common/TopBanner.svelte';
	import type { PageData } from './$types';
	import { SITE_NAME, SITE_URL } from '$lib/utils/constants';


	let { data }: { data: PageData } = $props();

	const page = $derived(data.page);
	const canonicalUrl = $derived(`${SITE_URL}/sveikinimai/${page.slug}/`);

	const primaryImage = '/images/kaledu-senelis/kaledu-senelis-savo-namuose.webp';
	const secondaryImage = $derived(page.secondImage)
	const thirdImage = '/images/sveikinimai/sveikinimai_moteris-kuria-kaledinio-sveikinimo-uzsakyma.webp';
	const fourthImage = $derived(page.fourthImage)
</script>

<svelte:head>
	<title>{page.title} | {SITE_NAME}</title>
	<meta name="description" content={page.description} />
	<meta name="robots" content="index, follow, max-image-preview:large" />
	<link rel="canonical" href={canonicalUrl} />

	<meta property="og:locale" content="lt_LT" />
	<meta property="og:type" content="website" />
	<meta property="og:site_name" content={SITE_NAME} />
	<meta property="og:title" content={`${page.title} | ${SITE_NAME}`} />
	<meta property="og:description" content={page.description} />
	<meta property="og:url" content={canonicalUrl} />
</svelte:head>

<TopBanner
	text="Kalėdinis sveikinimas tik nuo 6,99 €. Nepraleiskite progos pralinksminti artimuosius!"
	homeLinkText="Sužinokite daugiau"
	height={125}
/>

<main class="bg-white">
	<section class="mx-auto mt-15 grid max-w-7xl items-center gap-10 px-4 py-16 sm:px-6 lg:grid-cols-2 lg:px-8 lg:py-20">
		<div>
			<h1 class="text-3xl leading-tight font-bold tracking-tight text-gray-950 sm:text-4xl xl:text-5xl">
				{page.title}
			</h1>

			<p class="mt-5 text-base leading-7 text-gray-700 sm:text-lg">
				{page.heroIntro}
			</p>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.heroSecondParagraph}
			</p>

			<div class="mt-7">
				<Button
					href={resolve('/#sukurti-sveikinima')}
					class="bg-red px-8 py-3 text-base font-bold hover:bg-red-dark sm:text-lg"
				>
					Sukurti sveikinimą dabar
				</Button>
			</div>
		</div>

		<img
			src={primaryImage}
			alt="Kalėdų Senelis sėdi jaukiame kambaryje prie Kalėdų eglutės"
			class="aspect-video w-full rounded-2xl object-cover"
			width="900"
			height="506"
			loading="eager"
		/>
	</section>

	<hr class="mx-auto max-w-3xl border-gray-200" />

	<section class="mx-auto max-w-6xl px-4 py-12 sm:px-6 lg:px-8">
		<h2 class="text-center text-2xl font-bold tracking-tight text-gray-950 md:text-3xl">
			{page.giftTitle}
		</h2>

		<p class="pt-3 text-base leading-8 text-gray-700 sm:text-lg">
			{page.giftParagraphOne}
		</p>

		<p class="pt-3 text-base leading-8 text-gray-700 sm:text-lg">
			{page.giftParagraphTwo}
		</p>
	</section>

	<hr class="mx-auto max-w-3xl border-gray-200" />

	<section class="mx-auto grid max-w-7xl items-center gap-10 px-4 py-14 sm:px-6 lg:grid-cols-2 lg:px-8">
		<div class="lg:order-2">
			<h2 class="text-2xl font-bold tracking-tight text-gray-950 md:text-3xl">
				{page.personalTitle}
			</h2>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.personalParagraphOne}
			</p>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.personalParagraphTwo}
			</p>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.personalParagraphThree}
			</p>
		</div>

		<img
			src={secondaryImage}
			alt={page.secondImageAlt}
			class="aspect-16/10 w-full rounded-2xl object-cover lg:order-1"
			width="900"
			height="560"
			loading="lazy"
		/>
	</section>

	<hr class="mx-auto max-w-3xl border-gray-200" />

	<section class="mx-auto max-w-6xl px-4 py-12 sm:px-6 lg:px-8">
		<h2 class="text-center text-2xl font-bold tracking-tight text-gray-950 md:text-3xl">
			Pavyzdinis sveikinimo tekstas
		</h2>

		<p class="pt-3 text-base leading-8 text-gray-700 sm:text-lg">
			{page.exampleGreeting}
		</p>
	</section>

	<hr class="mx-auto max-w-3xl border-gray-200" />

	<section class="mx-auto grid max-w-7xl items-center gap-10 px-4 py-14 sm:px-6 lg:grid-cols-2 lg:px-8">
		<div>
			<h2 class="text-2xl font-bold tracking-tight text-gray-950 md:text-3xl">
				Sukurti sveikinimą paprasta ir greita
			</h2>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.processParagraph}
			</p>

			<ol class="mt-6 list-decimal space-y-4 pl-6 text-base leading-7 text-gray-700 sm:text-lg">
				<li>
					<span class="font-bold text-gray-950">Pasirinkite šabloną.</span>
					Išsirinkite, kaip atrodys Kalėdų Senelis jūsų personalizuotame video sveikinime.
				</li>

				<li>
					<span class="font-bold text-gray-950">Parašykite tekstą.</span>
					Įveskite savo sveikinimą arba pasinaudokite paruoštais teksto šablonais ir juos
					pakoreguokite pagal save.
				</li>

				<li>
					<span class="font-bold text-gray-950">Apmokėkite užsakymą.</span>
					Po apmokėjimo video pradedamas generuoti, o paruoštą sveikinimą gausite per
					individualią nuorodą.
				</li>
			</ol>
		</div>

		<img
			src={thirdImage}
			alt="Moteris kuria Kalėdų Senelio video sveikinimo užsakymą kompiuteryje"
			class="aspect-16/10 w-full rounded-2xl object-cover"
			width="900"
			height="560"
			loading="lazy"
		/>
	</section>

	<hr class="mx-auto max-w-3xl border-gray-200" />

	<section class="mx-auto grid max-w-7xl items-center gap-10 px-4 py-14 sm:px-6 lg:grid-cols-2 lg:px-8">
		<div class="lg:order-2">
			<h2 class="text-2xl font-bold tracking-tight text-gray-950 md:text-3xl">
				{page.shareTitle}
			</h2>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.shareParagraphOne}
			</p>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.shareParagraphTwo}
			</p>

			<p class="mt-4 text-base leading-7 text-gray-700 sm:text-lg">
				{page.shareParagraphThree}
			</p>
		</div>

		<img
			src={fourthImage}
			alt={page.fourthImageAlt}
			class="aspect-16/10 w-full rounded-2xl object-cover lg:order-1"
			width="900"
			height="560"
			loading="lazy"
		/>
	</section>

	<hr class="mx-auto max-w-3xl border-gray-200" />

	<section class="px-4 py-12 text-center sm:px-6 lg:px-8">
		<Button
			href={resolve('/#sukurti-sveikinima')}
			class="bg-red px-12 py-4 text-lg font-bold hover:bg-red-dark sm:min-w-72 sm:text-xl"
		>
			Sukurti sveikinimą
		</Button>
	</section>

	<Footer />
</main>