<script>
	import { Button } from "flowbite-svelte";

</script>
<section
	aria-labelledby="how-it-works-title"
	class="bg-red px-6 py-24 text-white sm:py-32"
>
	<div class="mx-auto max-w-496">
		<div class="mx-auto max-w-4xl text-center">
			<p class="mb-4 text-base font-semibold uppercase tracking-wide text-red-light">
				Kaip tai veikia?
			</p>

			<h2 id="how-it-works-title" class="text-4xl font-bold tracking-tight sm:text-5xl">
				Kalėdų Senelio video sveikinimas per kelis paprastus žingsnius
			</h2>

			<p class="mx-auto mt-6 max-w-3xl text-lg leading-8 text-red-light sm:text-xl">
				Pasirinkite video šabloną, parašykite savo sveikinimo tekstą ir gaukite
				personalizuotą Kalėdų Senelio video el. paštu.
			</p>
		</div>

		<ol class="relative mx-auto mt-28 max-w-7xl">
			<div
				class="absolute left-6 top-0 h-full w-1 rounded-full bg-white/30 md:left-1/2 md:-translate-x-1/2"
				aria-hidden="true"
			></div>

			<li class="relative grid gap-10 pb-32 md:grid-cols-2 md:gap-28">
				<div
					class="absolute left-6 top-10 z-10 h-7 w-7 -translate-x-1/2 rounded-full border-4 border-white bg-red md:left-1/2"
					aria-hidden="true"
				></div>

				<div class="hidden md:block"></div>

				<div class="relative pl-16 md:pl-16">
					<article class="rounded-3xl bg-white p-10 text-gray-950 shadow-xl sm:p-12">
						<p class="mb-4 text-base font-bold uppercase tracking-wide text-red">
							1 žingsnis
						</p>

						<h3 class="text-3xl font-bold">
							Pasirinkite Kalėdų Senelio video šabloną
						</h3>

						<p class="mt-5 text-xl leading-9 text-gray-600">
							Išsirinkite, kaip atrodys jūsų Kalėdų Senelio video sveikinimas.
						</p>
					</article>
				</div>
			</li>

			<li class="relative grid gap-10 pb-32 md:grid-cols-2 md:gap-28">
				<div
					class="absolute left-6 top-10 z-10 h-7 w-7 -translate-x-1/2 rounded-full border-4 border-white bg-red md:left-1/2"
					aria-hidden="true"
				></div>

				<div class="relative pl-16 md:pl-0 md:pr-16">
					<article class="rounded-3xl bg-white p-10 text-gray-950 shadow-xl sm:p-12">
						<p class="mb-4 text-base font-bold uppercase tracking-wide text-red">
							2 žingsnis
						</p>

						<h3 class="text-3xl font-bold">
							Parašykite sveikinimo tekstą
						</h3>

						<p class="mt-5 text-xl leading-9 text-gray-600">
							Įrašykite kalėdinį sveikinimą vaikui, draugui ar kolegai. Arba rinkites iš jau sukurtų šablonų.
							Kalėdų Senelis viską įgarsins video sveikinime.
						</p>
					</article>
				</div>

				<div class="hidden md:block"></div>
			</li>

			<li class="relative grid gap-10 md:grid-cols-2 md:gap-28">
				<div
					class="absolute left-6 top-10 z-10 h-7 w-7 -translate-x-1/2 rounded-full border-4 border-white bg-red md:left-1/2"
					aria-hidden="true"
				></div>

				<div class="hidden md:block"></div>

				<div class="relative pl-16 md:pl-16">
					<article class="rounded-3xl bg-white p-10 text-gray-950 shadow-xl sm:p-12">
						<p class="mb-4 text-base font-bold uppercase tracking-wide text-red">
							3 žingsnis
						</p>

						<h3 class="text-3xl font-bold">
							Apmokėkite ir gaukite video el. paštu
						</h3>

						<p class="mt-5 text-xl leading-9 text-gray-600">
							Po apmokėjimo sukursime personalizuotą Kalėdų Senelio video sveikinimą.
							Nuorodą atsiųsime jūsų nurodytu el. paštu.
						</p>
					</article>
				</div>
			</li>
		</ol>

        <div class="mt-20 flex justify-center">
            <Button
                href="#create-greeting"
                size="xl"
                class="bg-white px-12 py-6 text-2xl font-bold text-red hover:bg-red-light"
            >
                Sukurti sveikinimą
            </Button>
        </div>
	</div>
</section>