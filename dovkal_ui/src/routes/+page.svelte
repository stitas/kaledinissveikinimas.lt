<script lang="ts">
	import { Button } from 'flowbite-svelte';
	import { TextSizeOutline, VolumeUpOutline, ClockOutline } from 'flowbite-svelte-icons';
	import VideoPlayer from '$lib/components/VideoPlayer.svelte';
	import GreetingInput from '$lib/components/GreetingInput.svelte';
	import HowItWorks from '$lib/components/HowItWorks.svelte';
	import GiftIdeas from '$lib/components/GiftIdeas.svelte';
	import Faq from '$lib/components/Faq.svelte';

	let showTopBanner = $state(true);

	function handleScroll() {
		showTopBanner = window.scrollY < 240;
	}
</script>

<svelte:head>
	<title>Kalėdinė dovana | Kalėdų Senelio video sveikinimas nuo 6,99€</title>

	<meta
		name="description"
		content="Sukurkite personalizuotą Kalėdų Senelio video sveikinimą vos per kelias minutes. Originali kalėdinė dovana vaikams, draugams ir kolegoms tik nuo 6,99€"
	/>

	<meta name="robots" content="index, follow, max-image-preview:large" />
	<link rel="canonical" href="https://dovanakaledoms.lt/" />

	<meta property="og:type" content="website" />
	<meta property="og:locale" content="lt_LT" />
	<meta property="og:site_name" content="Dovana Kalėdoms" />
	<meta property="og:url" content="https://dovanakaledoms.lt/" />
	<meta property="og:title" content="Kalėdinė dovana | Unikalus Kalėdų Senelio video sveikinimas" />
	<meta
		property="og:description"
		content="Padovanokite stebuklą! Sukurkite unikalų Kalėdų Senelio video sveikinimą vos per kelias minutes. Nuostabi kalėdinė dovana vaikams, draugams ir kolegoms."
	/>
	<meta property="og:image" content="https://dovanakaledoms.lt/images/og-preview.jpg" />
	<meta property="og:image:alt" content="Kalėdų Senelis sveikina personalizuotame video sveikinime" />
	<meta property="og:image:width" content="1200" />
	<meta property="og:image:height" content="630" />

	<script type="application/ld+json">
		{
			"@context": "https://schema.org",
			"@type": "Product",
			"name": "Kalėdų Senelio video sveikinimas",
			"description": "Personalizuotas Kalėdų Senelio video sveikinimas pagal jūsų parašytą tekstą. Originali kalėdinė dovana vaikams, draugams ir kolegoms.",
			"image": "https://dovanakaledoms.lt/images/og-preview.jpg",
			"brand": {
				"@type": "Brand",
				"name": "Dovana Kalėdoms"
			},
			"url": "https://dovanakaledoms.lt/",
			"offers": {
				"@type": "Offer",
				"url": "https://dovanakaledoms.lt/",
				"priceCurrency": "EUR",
				"price": "6.99",
				"availability": "https://schema.org/InStock"
			}
		}
	</script>
</svelte:head>

<svelte:window onscroll={handleScroll} />

{#if showTopBanner}
	<div class="fixed inset-x-0 top-0 z-50 bg-red text-white shadow-md">
		<div class="mx-auto max-w-7xl px-4 py-2 text-center text-sm leading-5 font-semibold sm:py-3 md:text-base">
			Kalėdinis sveikinimas tik nuo 6,99 €. Nepraleiskite progos pralinksminti artimuosius!
		</div>
	</div>
{/if}

<main class="bg-white">
	<section aria-labelledby="hero-title" class="mx-auto mt-16 flex min-h-screen max-w-7xl flex-col justify-center px-4 py-12 sm:px-6 xl:mt-6 xl:px-8">
		<div class="grid items-center gap-10 xl:grid-cols-[minmax(0,34rem)_minmax(0,48rem)] xl:gap-16 2xl:gap-20">
			<div class="mx-auto max-w-2xl text-center xl:mx-0 xl:text-left">
				<p class="mb-3 text-sm font-semibold tracking-wide text-red uppercase sm:text-base">
					Personalizuota kalėdinė dovana
				</p>

				<h1
					id="hero-title"
					class="text-3xl leading-tight font-bold tracking-tight text-gray-950 sm:text-4xl xl:text-5xl"
				>
					Kalėdinis sveikinimas, kurį pasakys pats Kalėdų Senelis
				</h1>

				<p class="mx-auto mt-5 max-w-xl text-base leading-7 text-gray-700 sm:text-lg sm:leading-8 xl:mx-0">
					Sukurkite unikalų Kalėdų Senelio video sveikinimą pagal savo tekstą. Parašykite žinutę,
					įveskite el. paštą ir gaukite asmeniškai pritaikytą šventinę dovaną.
				</p>

				<div class="mt-6 flex flex-col items-center gap-3 sm:flex-row sm:justify-center xl:justify-start">
					<Button
						href="#create-greeting"
						size="lg"
						class="bg-red px-6 py-3 text-base hover:bg-red-dark"
					>
						Sukurti sveikinimą
					</Button>

					<p class="text-sm text-gray-600 sm:text-base">
						Kaina nuo <span class="font-semibold text-gray-950">6,99 €</span>
					</p>
				</div>

				<ul class="mx-auto mt-7 grid max-w-2xl gap-4 text-sm text-gray-700 sm:grid-cols-3 sm:text-base xl:mx-0 xl:max-w-none">
					<li class="flex items-center justify-center gap-2 xl:justify-start">
						<span class="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-red-light text-red">
							<TextSizeOutline size="md" ariaLabel="Simbolių kiekis" />
						</span>
						<span>Iki 1500 simbolių</span>
					</li>

					<li class="flex items-center justify-center gap-2 xl:justify-start">
						<span class="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-red-light text-red">
							<VolumeUpOutline size="md" ariaLabel="Lietuviškas įgarsinimas" />
						</span>
						<span>Lietuviškas įgarsinimas</span>
					</li>

					<li class="flex items-center justify-center gap-2 xl:justify-start">
						<span class="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-red-light text-red">
							<ClockOutline size="md" ariaLabel="Užtrukimo laikas" />
						</span>
						<span>Užtrunka iki 10 min.</span>
					</li>
				</ul>
			</div>

			<VideoPlayer
				posterSrc="/images/santa-classic-preview.jpg"
				videoSrc="/videos/santa-demo.mp4"
				posterAlt="Pavyzdinis personalizuotas Kalėdų Senelio video sveikinimas"
				videoLabel="Pavyzdinis Kalėdų Senelio video sveikinimas"
				caption="Peržiūrėkite, kaip gali atrodyti jūsų sukurtas sveikinimas."
			/>
		</div>

		<a
			href="#create-greeting"
			class="mx-auto mt-8 flex items-center justify-center gap-2 text-xl font-bold text-red transition hover:text-red-dark sm:gap-3 sm:text-2xl md:text-3xl xl:mt-24"
			aria-label="Eiti į sveikinimo kūrimo formą"
		>
			<span>Sukurkite dabar!</span>

			<svg
				width="80"
				height="52"
				viewBox="0 0 96 64"
				fill="none"
				xmlns="http://www.w3.org/2000/svg"
				aria-hidden="true"
				class="w-10 translate-y-1 sm:w-14 sm:translate-y-1"
			>
				<path
					d="M5 14C28 4 61 10 76 32"
					stroke="currentColor"
					stroke-width="5"
					stroke-linecap="round"
				/>
				<path
					d="M66 31L80 39L82 23"
					stroke="currentColor"
					stroke-width="5"
					stroke-linecap="round"
					stroke-linejoin="round"
				/>
			</svg>
		</a>
	</section>

	<GreetingInput />

	<!-- Update home screen with video carousel of different santas -->
	<HowItWorks />
	<GiftIdeas />
	<Faq />
	<GreetingInput />
	<!-- Footer -->
</main>
