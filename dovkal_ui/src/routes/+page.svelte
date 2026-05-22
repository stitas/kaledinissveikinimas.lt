<script lang="ts">
	import { Button } from 'flowbite-svelte';
	import { TextSizeOutline, VolumeUpOutline, ClockOutline } from 'flowbite-svelte-icons';
	import VideoPlayer from '$lib/components/VideoPlayer.svelte';

	let showTopBanner = $state(true);

	function handleScroll() {
		showTopBanner = window.scrollY < 240;
	}
</script>

<svelte:head>
	<title>Kalėdinė dovana | Unikalus Kalėdų Senelio video sveikinimas</title>

	<meta
		name="description"
		content="Padovanokite stebuklą! Sukurkite unikalų Kalėdų Senelio video sveikinimą vos per kelias minutes. Nuostabi kalėdinė dovana vaikams, draugams ir kolegoms."
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
	<div class="fixed left-0 top-0 z-50 w-full bg-red px-4 py-4 text-center text-lg font-semibold text-white shadow-md sm:text-xl">
		Kalėdinis sveikinimas tik nuo 6,99 €. Nepraleiskite progos pralinksminti artimuosius!
	</div>
{/if}

<main class="bg-white">
	<section
		aria-labelledby="hero-title"
		class="mx-auto mt-24 flex min-h-screen max-w-496 flex-col justify-center px-6 py-16 xl:px-10 xl:mt-0"
	>
		<div class="grid items-center gap-16 xl:grid-cols-[minmax(0,52rem)_minmax(0,66rem)] xl:gap-28 2xl:gap-36">
			<div class="mx-auto max-w-216 text-center xl:mx-0 xl:text-left">
				<p class="mb-5 text-base font-semibold uppercase tracking-wide text-red sm:text-lg">
					Personalizuota kalėdinė dovana
				</p>

				<h1 id="hero-title" class="max-w-216 text-5xl font-bold leading-tight tracking-tight text-gray-950 sm:text-6xl md:text-6xl 2xl:text-7xl">
					Kalėdinis sveikinimas, kurį pasakys pats Kalėdų Senelis
				</h1>

				<p class="mx-auto mt-7 max-w-184 text-xl leading-9 text-gray-700 sm:text-2xl sm:leading-10 xl:mx-0">
					Sukurkite unikalų Kalėdų Senelio video sveikinimą pagal savo tekstą. Parašykite
					žinutę, įveskite el. paštą ir gaukite asmeniškai pritaikytą šventinę dovaną.
				</p>

				<div class="mt-8 flex flex-col items-center gap-4 sm:flex-row sm:justify-center xl:justify-start">
					<Button
						href="#sukurti-sveikinima"
						size="lg"
						class="bg-red px-8 py-4 text-lg hover:bg-red-dark"
					>
						Sukurti sveikinimą
					</Button>

					<p class="text-base text-gray-600 sm:text-lg">
						Kaina nuo <span class="font-semibold text-gray-950">6,99 €</span>
					</p>
				</div>

				<ul	class="mx-auto mt-9 grid max-w-2xl gap-5 text-base text-gray-700 sm:grid-cols-3 sm:text-lg xl:mx-0 xl:max-w-none">
					<li class="flex items-center justify-center gap-3 xl:justify-start">
						<span class="flex h-12 w-12 shrink-0 items-center justify-center rounded-full bg-red-light text-red">
							<TextSizeOutline size="lg" ariaLabel="Simbolių kiekis" />
						</span>
						<span>Iki 1500 simbolių</span>
					</li>

					<li class="flex items-center justify-center gap-3 xl:justify-start">
						<span class="flex h-12 w-12 shrink-0 items-center justify-center rounded-full bg-red-light text-red">
							<VolumeUpOutline size="lg" ariaLabel="Lietuviškas įgarsinimas" />
						</span>
						<span>Lietuviškas įgarsinimas</span>
					</li>

					<li class="flex items-center justify-center gap-3 xl:justify-start">
						<span class="flex h-12 w-12 shrink-0 items-center justify-center rounded-full bg-red-light text-red">
							<ClockOutline size="lg" ariaLabel="Užtrukimo laikas" />
						</span>
						<span>Užtrunka iki 10 min.</span>
					</li>
				</ul>
			</div>

			<VideoPlayer 
				posterSrc="/images/santa-video-preview.jpg"
				videoSrc="/videos/santa-demo.mp4"
				posterAlt="Pavyzdinis personalizuotas Kalėdų Senelio video sveikinimas"
				videoLabel="Pavyzdinis Kalėdų Senelio video sveikinimas"
				caption="Peržiūrėkite, kaip gali atrodyti jūsų sukurtas sveikinimas."
			/>
		</div>

	
		<a
            href="#sukurti-sveikinima"
            class="mx-auto mt-8 flex items-center justify-center gap-3 text-5xl font-bold text-red transition hover:text-red-dark xl:mt-48 sm:gap-5"
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
                class="w-14 translate-y-1 sm:w-24 sm:translate-y-2"
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
</main>