<script lang="ts">
	import { resolvePath } from '$lib/utils/utils';
	import { Button } from 'flowbite-svelte';
</script>

<svelte:head>
	<title>404 | Puslapis nerastas</title>
	<meta name="robots" content="noindex, nofollow" />
</svelte:head>

<main class="flex min-h-screen items-center justify-center bg-red px-4 py-12 sm:px-6 lg:px-8">
	<section aria-labelledby="not-found-title" class="text-center">
		<h1 id="not-found-title" class="text-8xl leading-none font-bold tracking-tight text-white sm:text-9xl">
			404
		</h1>

		<p class="mt-5 text-lg leading-8 font-semibold text-red-light sm:text-xl">
			Šis puslapis neegzituoja
		</p>

		<div class="mt-8 flex justify-center">
			<Button href={resolvePath('/')} class="bg-white px-8 py-3 text-base font-bold text-red hover:bg-red-light sm:text-lg">
				Grįžti į pradžią
			</Button>
		</div>
	</section>
</main>
