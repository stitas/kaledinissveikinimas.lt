<script lang="ts">
	import { resolve } from '$app/paths';
	import { Button } from 'flowbite-svelte';
	import { CheckCircleSolid } from 'flowbite-svelte-icons';
</script>

<svelte:head>
	<title>Mokėjimas sėkmingas</title>
	<meta name="robots" content="noindex, nofollow, noarchive" />
</svelte:head>

<main class="flex min-h-screen items-center justify-center bg-red px-4 py-12 sm:px-6 lg:px-8">
	<section aria-labelledby="payment-success-title" class="mx-auto w-full max-w-2xl rounded-2xl bg-white px-6 py-10 text-center shadow-xl sm:px-10 sm:py-12">
		<div class="mx-auto flex h-16 w-16 items-center justify-center rounded-full bg-green-100 text-green-600 sm:h-20 sm:w-20">
			<CheckCircleSolid class="h-10 w-10 sm:h-12 sm:w-12" ariaLabel="Mokėjimas sėkmingas" />
		</div>

		<h1 id="payment-success-title" class="mt-6 text-3xl leading-tight font-bold tracking-tight text-gray-950 sm:text-4xl">
			Mokėjimas sėkmingas
		</h1>

		<p class="mx-auto mt-4 max-w-xl text-base leading-7 text-gray-600 sm:text-lg">
			Ačiū jums už užsakymą. Jau netrukus gausite savo sveikinimą į el. paštą
		</p>

		<div class="mt-8 flex justify-center">
			<Button href={resolve('/#sukurti-sveikinima')} class="bg-red px-8 py-3 text-base font-bold hover:bg-red-dark sm:text-lg">
				Užsakyti dar vieną
			</Button>
		</div>
	</section>
</main>
