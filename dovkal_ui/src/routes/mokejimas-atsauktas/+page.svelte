<script lang="ts">
	import { resolve } from '$app/paths';
	import { Button } from 'flowbite-svelte';
	import { CloseCircleSolid } from 'flowbite-svelte-icons';
	import { SUPPORT_EMAIL } from '$lib/utils/constants';
</script>

<svelte:head>
	<title>Mokėjimas nepavyko</title>
	<meta name="robots" content="noindex, nofollow, noarchive" />
</svelte:head>

<main class="flex min-h-screen items-center justify-center bg-red px-4 py-12 sm:px-6 lg:px-8">
	<section aria-labelledby="payment-cancelled-title" class="mx-auto w-full max-w-2xl rounded-2xl bg-white px-6 py-10 text-center shadow-xl sm:px-10 sm:py-12">
		<div class="mx-auto flex h-16 w-16 items-center justify-center rounded-full bg-red-light text-red sm:h-20 sm:w-20">
			<CloseCircleSolid class="h-10 w-10 sm:h-12 sm:w-12" ariaLabel="Mokėjimas nepavyko" />
		</div>

		<h1 id="payment-cancelled-title" class="mt-6 text-3xl leading-tight font-bold tracking-tight text-gray-950 sm:text-4xl">
			Mokėjimas nepavyko
		</h1>

		<p class="mx-auto mt-4 max-w-xl text-base leading-7 text-gray-600 sm:text-lg">
			Įvyko klaida atsiskaitant už sveikinimą. Jei iš jūsų nuskaičiavo pinigus kreipkites į
			{SUPPORT_EMAIL}
		</p>

		<div class="mt-8 flex justify-center">
			<Button href={resolve('/#sukurti-sveikinima')} class="bg-red px-8 py-3 text-base font-bold hover:bg-red-dark sm:text-lg">
				Bandykite dar kartą
			</Button>
		</div>
	</section>
</main>
