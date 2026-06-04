<script>
	import { resolve } from '$app/paths';
	import { Button } from 'flowbite-svelte';
</script>

<section aria-labelledby="how-it-works-title" id="kaip-tai-veikia" class="bg-red px-4 py-16 text-white sm:py-20 lg:px-6">
	<div class="mx-auto max-w-7xl">
		<div class="mx-auto max-w-3xl text-center">
			<p class="mb-3 text-sm font-semibold tracking-wide text-red-light uppercase sm:text-base">
				Kaip tai veikia?
			</p>

			<h2 id="how-it-works-title" class="text-3xl font-bold tracking-tight md:text-4xl">
				Kalėdų Senelio video sveikinimas per kelis paprastus žingsnius
			</h2>

			<p class="mx-auto mt-4 max-w-2xl text-base leading-7 text-red-light sm:text-lg">
				Pasirinkite video šabloną, parašykite savo sveikinimo tekstą ir gaukite personalizuotą
				Kalėdų Senelio video el. paštu.
			</p>
		</div>

		<ol class="relative mx-auto mt-16 max-w-5xl">
			<div class="absolute top-0 left-6 h-full w-1 rounded-full bg-white/30 md:left-1/2 md:-translate-x-1/2" aria-hidden="true"></div>

			<li class="relative grid gap-8 pb-20 md:grid-cols-2 md:gap-16">
				<div class="absolute top-8 left-6 z-10 h-6 w-6 -translate-x-1/2 rounded-full border-4 border-white bg-red md:left-1/2" aria-hidden="true"></div>

				<div class="hidden md:block"></div>

				<div class="relative pl-16 md:pl-16">
					<article class="rounded-2xl bg-white p-6 text-gray-950 shadow-xl sm:p-8">
						<p class="mb-3 text-sm font-bold tracking-wide text-red uppercase sm:text-base">
							1 žingsnis
						</p>

						<h3 class="text-xl font-bold md:text-2xl">Pasirinkite Kalėdų Senelio video šabloną</h3>

						<p class="mt-4 text-base leading-7 text-gray-600 md:text-lg">
							Išsirinkite, kaip atrodys jūsų Kalėdų Senelio video sveikinimas.
						</p>
					</article>
				</div>
			</li>

			<li class="relative grid gap-8 pb-20 md:grid-cols-2 md:gap-16">
				<div class="absolute top-8 left-6 z-10 h-6 w-6 -translate-x-1/2 rounded-full border-4 border-white bg-red md:left-1/2" aria-hidden="true"></div>

				<div class="relative pl-16 md:pr-16 md:pl-0">
					<article class="rounded-2xl bg-white p-6 text-gray-950 shadow-xl sm:p-8">
						<p class="mb-3 text-sm font-bold tracking-wide text-red uppercase sm:text-base">
							2 žingsnis
						</p>

						<h3 class="text-xl font-bold md:text-2xl">Parašykite sveikinimo tekstą</h3>

						<p class="mt-4 text-base leading-7 text-gray-600 md:text-lg">
							Įrašykite kalėdinį sveikinimą vaikui, draugui ar kolegai. Arba rinkites iš jau sukurtų
							šablonų.
						</p>
					</article>
				</div>

				<div class="hidden md:block"></div>
			</li>

			<li class="relative grid gap-8 md:grid-cols-2 md:gap-16">
				<div class="absolute top-8 left-6 z-10 h-6 w-6 -translate-x-1/2 rounded-full border-4 border-white bg-red md:left-1/2" aria-hidden="true"></div>

				<div class="hidden md:block"></div>

				<div class="relative pl-16 md:pl-16">
					<article class="rounded-2xl bg-white p-6 text-gray-950 shadow-xl sm:p-8">
						<p class="mb-3 text-sm font-bold tracking-wide text-red uppercase sm:text-base">
							3 žingsnis
						</p>

						<h3 class="text-xl font-bold md:text-2xl">Apmokėkite ir gaukite video el. paštu</h3>

						<p class="mt-4 text-base leading-7 text-gray-600 md:text-lg">
							Po apmokėjimo sukursime personalizuotą Kalėdų Senelio video sveikinimą. Nuorodą
							atsiųsime jūsų nurodytu el. paštu.
						</p>
					</article>
				</div>
			</li>
		</ol>

		<div class="mt-14 flex justify-center">
			<Button
				href={resolve('/#sukurti-sveikinima')}
				size="xl"
				class="bg-white px-6 py-3 text-base font-bold text-red hover:bg-red-light md:text-lg"
			>
				Sukurti sveikinimą
			</Button>
		</div>
	</div>
</section>
