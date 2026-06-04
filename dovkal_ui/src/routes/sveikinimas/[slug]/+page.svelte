<script lang="ts">
	import { Button } from 'flowbite-svelte';
	import type { PageProps } from './$types';
	import VideoPlayer from '$lib/components/common/VideoPlayer.svelte';
	import { SUPPORT_EMAIL } from '$lib/constants/contact';

	let { data }: PageProps = $props();
</script>

<svelte:head>
	<title>Ačiū, kad perkate</title>
	<meta name="robots" content="noindex, nofollow, noarchive" />
</svelte:head>

<main class="relative min-h-screen overflow-hidden bg-red px-4 py-12 sm:px-6 lg:px-8">
	<div class="snow-layer" aria-hidden="true"></div>

	<section aria-labelledby="greeting-title" class="relative z-10 mx-auto flex min-h-[calc(100vh-6rem)] max-w-5xl flex-col items-center justify-center">
		{#if data.video}
			<h1 id="greeting-title" class="mb-2 text-center text-3xl leading-tight font-bold tracking-tight text-white sm:text-4xl xl:text-5xl">
				Ačiū, kad perkate!
			</h1>

			<p class="mb-8 text-center text-base leading-7 text-red-light sm:text-lg">
				Atsisiųskite savo sveikinimą
			</p>

			<VideoPlayer
				posterSrc={data.video.thumbnailUrl}
				videoSrc={data.video.videoUrl}
				posterAlt="Kalėdų Senelio video sveikinimo peržiūra"
				videoLabel="Kalėdų Senelio video sveikinimas"
			/>

			<div class="mt-8 flex justify-center">
				<Button
					href={`/sveikinimas/${data.orderId}/atsisiusti`}
					class="min-w-56 cursor-pointer bg-white px-12 py-4 text-lg font-bold text-red hover:bg-red-light md:min-w-72 md:text-xl"
				>
					Atsisiųsti
				</Button>
			</div>
		{:else}
			<h1 id="greeting-title" class="max-w-3xl text-center text-3xl leading-tight font-bold tracking-tight text-white sm:text-4xl xl:text-5xl">
				Mums nepavyko rasti jūsų video.
			</h1>

			<h3 class="mt-4 max-w-3xl text-center text-base leading-7 font-semibold text-red-light sm:text-lg">
				Jei esate įsitikinę, kad čia turėtų būti jūsų sveikinimas susisiekite:
				{SUPPORT_EMAIL}. Laiške pridėkite savo užsakymo numerį
			</h3>
		{/if}
	</section>
</main>

<style>
	.snow-layer,
	.snow-layer::before,
	.snow-layer::after {
		content: '';
		pointer-events: none;
		position: absolute;
		top: 0;
		left: 0;
		border-radius: 9999px;
		background: rgba(255, 255, 255, 0.9);
	}

	.snow-layer {
		width: 4px;
		height: 4px;
		box-shadow:
			3vw -92vh 0 rgba(255, 255, 255, 0.62),
			13vw -78vh 0 rgba(255, 255, 255, 0.78),
			27vw -64vh 0 rgba(255, 255, 255, 0.52),
			41vw -88vh 0 rgba(255, 255, 255, 0.72),
			56vw -42vh 0 rgba(255, 255, 255, 0.58),
			72vw -70vh 0 rgba(255, 255, 255, 0.8),
			88vw -54vh 0 rgba(255, 255, 255, 0.5),
			96vw -96vh 0 rgba(255, 255, 255, 0.7),
			4vw 12vh 0 rgba(255, 255, 255, 0.75),
			11vw 38vh 0 rgba(255, 255, 255, 0.5),
			18vw 7vh 0 rgba(255, 255, 255, 0.85),
			23vw 68vh 0 rgba(255, 255, 255, 0.45),
			31vw 25vh 0 rgba(255, 255, 255, 0.7),
			39vw 82vh 0 rgba(255, 255, 255, 0.55),
			46vw 15vh 0 rgba(255, 255, 255, 0.8),
			53vw 58vh 0 rgba(255, 255, 255, 0.48),
			61vw 34vh 0 rgba(255, 255, 255, 0.72),
			67vw 91vh 0 rgba(255, 255, 255, 0.52),
			74vw 21vh 0 rgba(255, 255, 255, 0.82),
			82vw 63vh 0 rgba(255, 255, 255, 0.44),
			89vw 42vh 0 rgba(255, 255, 255, 0.78),
			97vw 76vh 0 rgba(255, 255, 255, 0.55),
			8vw 104vh 0 rgba(255, 255, 255, 0.6),
			36vw 116vh 0 rgba(255, 255, 255, 0.46),
			58vw 109vh 0 rgba(255, 255, 255, 0.68),
			81vw 121vh 0 rgba(255, 255, 255, 0.5),
			15vw 118vh 0 rgba(255, 255, 255, 0.58),
			44vw 104vh 0 rgba(255, 255, 255, 0.66),
			70vw 112vh 0 rgba(255, 255, 255, 0.55),
			92vw 101vh 0 rgba(255, 255, 255, 0.7);
		animation: snow-fall 9s linear infinite;
	}

	.snow-layer::before {
		width: 3px;
		height: 3px;
		box-shadow:
			5vw -84vh 0 rgba(255, 255, 255, 0.48),
			19vw -58vh 0 rgba(255, 255, 255, 0.7),
			24vw -95vh 0 rgba(255, 255, 255, 0.42),
			38vw -23vh 0 rgba(255, 255, 255, 0.62),
			54vw -76vh 0 rgba(255, 255, 255, 0.78),
			63vw -47vh 0 rgba(255, 255, 255, 0.5),
			80vw -89vh 0 rgba(255, 255, 255, 0.66),
			95vw -31vh 0 rgba(255, 255, 255, 0.56),
			2vw 53vh 0 rgba(255, 255, 255, 0.55),
			9vw 19vh 0 rgba(255, 255, 255, 0.8),
			16vw 87vh 0 rgba(255, 255, 255, 0.45),
			27vw 44vh 0 rgba(255, 255, 255, 0.65),
			34vw 4vh 0 rgba(255, 255, 255, 0.75),
			42vw 71vh 0 rgba(255, 255, 255, 0.5),
			49vw 29vh 0 rgba(255, 255, 255, 0.82),
			57vw 96vh 0 rgba(255, 255, 255, 0.48),
			65vw 11vh 0 rgba(255, 255, 255, 0.72),
			71vw 49vh 0 rgba(255, 255, 255, 0.5),
			78vw 83vh 0 rgba(255, 255, 255, 0.68),
			86vw 27vh 0 rgba(255, 255, 255, 0.78),
			93vw 59vh 0 rgba(255, 255, 255, 0.45),
			12vw 113vh 0 rgba(255, 255, 255, 0.5),
			33vw 107vh 0 rgba(255, 255, 255, 0.7),
			69vw 119vh 0 rgba(255, 255, 255, 0.54),
			90vw 106vh 0 rgba(255, 255, 255, 0.62),
			6vw 121vh 0 rgba(255, 255, 255, 0.48),
			45vw 114vh 0 rgba(255, 255, 255, 0.72),
			60vw 105vh 0 rgba(255, 255, 255, 0.5),
			83vw 116vh 0 rgba(255, 255, 255, 0.68);
		animation: snow-fall-drift 12s linear infinite;
	}

	.snow-layer::after {
		width: 5px;
		height: 5px;
		box-shadow:
			7vw -39vh 0 rgba(255, 255, 255, 0.46),
			17vw -91vh 0 rgba(255, 255, 255, 0.58),
			32vw -69vh 0 rgba(255, 255, 255, 0.42),
			47vw -18vh 0 rgba(255, 255, 255, 0.7),
			62vw -83vh 0 rgba(255, 255, 255, 0.48),
			73vw -51vh 0 rgba(255, 255, 255, 0.64),
			87vw -27vh 0 rgba(255, 255, 255, 0.44),
			98vw -73vh 0 rgba(255, 255, 255, 0.62),
			6vw 78vh 0 rgba(255, 255, 255, 0.45),
			14vw 31vh 0 rgba(255, 255, 255, 0.72),
			21vw 92vh 0 rgba(255, 255, 255, 0.38),
			29vw 14vh 0 rgba(255, 255, 255, 0.68),
			36vw 61vh 0 rgba(255, 255, 255, 0.42),
			44vw 39vh 0 rgba(255, 255, 255, 0.62),
			52vw 88vh 0 rgba(255, 255, 255, 0.4),
			59vw 18vh 0 rgba(255, 255, 255, 0.7),
			69vw 72vh 0 rgba(255, 255, 255, 0.44),
			76vw 36vh 0 rgba(255, 255, 255, 0.66),
			84vw 9vh 0 rgba(255, 255, 255, 0.74),
			91vw 67vh 0 rgba(255, 255, 255, 0.43),
			99vw 24vh 0 rgba(255, 255, 255, 0.65),
			25vw 111vh 0 rgba(255, 255, 255, 0.5),
			51vw 122vh 0 rgba(255, 255, 255, 0.38),
			75vw 108vh 0 rgba(255, 255, 255, 0.6),
			94vw 118vh 0 rgba(255, 255, 255, 0.42),
			10vw 105vh 0 rgba(255, 255, 255, 0.52),
			39vw 119vh 0 rgba(255, 255, 255, 0.46),
			66vw 114vh 0 rgba(255, 255, 255, 0.58),
			88vw 109vh 0 rgba(255, 255, 255, 0.5);
		animation: snow-fall-wide 15s linear infinite;
	}

	@keyframes snow-fall {
		to {
			transform: translate3d(0.75rem, 100vh, 0);
		}
	}

	@keyframes snow-fall-drift {
		to {
			transform: translate3d(-1.25rem, 100vh, 0);
		}
	}

	@keyframes snow-fall-wide {
		to {
			transform: translate3d(1.75rem, 100vh, 0);
		}
	}

	@media (prefers-reduced-motion: reduce) {
		.snow-layer,
		.snow-layer::before,
		.snow-layer::after {
			animation: none;
		}
	}
</style>
