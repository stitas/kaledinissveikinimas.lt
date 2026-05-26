<script lang="ts">
	import { Button } from "flowbite-svelte";

	type FaqItem = {
		question: string;
		answer: string;
	};

	const faqs: FaqItem[] = [
		{
			question: 'Kas yra Kalėdų Senelio video sveikinimas?',
			answer:
				'Tai personalizuotas kalėdinis video, kuriame Kalėdų Senelis pasako jūsų parašytą sveikinimo tekstą. Galite sukurti sveikinimą vaikui, draugui, šeimos nariui ar kolegai.'
		},
		{
			question: 'Kiek kainuoja personalizuotas Kalėdų Senelio video?',
			answer:
				'Kaina priklauso nuo sveikinimo teksto ilgio. Trumpiausias Kalėdų Senelio video sveikinimas kainuoja nuo 6,99 €, o ilgesni tekstai kainuoja daugiau pagal simbolių kiekį.'
		},
		{
			question: 'Ar galiu parašyti sveikinimą lietuviškai?',
			answer:
				'Taip. Galite rašyti sveikinimą lietuviškai. Taip pat palaikomos anglų, lenkų ir kitos kalbos, todėl sveikinimą galite pritaikyti skirtingiems žmonėms.'
		},
		{
			question: 'Kam tinka tokia kalėdinė dovana?',
			answer:
				'Kalėdų Senelio video sveikinimas tinka vaikams, draugams, šeimos nariams, kolegoms ar komandai. Tai gera dovana, kai norite kažko asmeniško, linksmo ir greitai sukuriamo.'
		},
		{
			question: 'Kaip gausiu sugeneruotą video?',
			answer:
				'Įveskite savo el. paštą užsakymo formoje. Kai Kalėdų Senelio video bus sugeneruotas, nuorodą į jį atsiųsime jūsų nurodytu el. pašto adresu.'
		},
		{
			question: 'Kiek laiko užtrunka sukurti video?',
			answer:
				'Dažniausiai Kalėdų Senelio video sukuriamas per kelias minutes. Kai kuriais atvejais, priklausomai nuo apkrovos, tai gali užtrukti šiek tiek ilgiau.'
		},
		{
			question: 'Ar galiu naudoti savo tekstą?',
			answer:
				'Taip. Galite parašyti savo sveikinimo tekstą nuo nulio arba pasirinkti vieną iš paruoštų šablonų vaikams, draugams ar kolegoms ir jį pakoreguoti.'
		},
		{
			question: 'Kas nutiks po apmokėjimo?',
			answer:
				'Po apmokėjimo jūsų sveikinimo tekstas ir pasirinktas Kalėdų Senelio šablonas bus perduoti video generavimui. Sugeneruotas video bus išsiųstas el. paštu.'
		}
	];
</script>

<section id="faq" aria-labelledby="faq-title" class="bg-white px-6 py-24 sm:py-32">
	<div class="mx-auto max-w-496">
		<div class="mx-auto max-w-4xl text-center">
			<p class="mb-4 text-sm font-semibold uppercase tracking-wide text-red sm:text-base">
				Dažniausiai užduodami klausimai
			</p>

			<h2 id="faq-title" class="text-3xl font-bold tracking-tight text-gray-950 md:text-4xl">
				Klausimai apie Kalėdų Senelio video sveikinimą
			</h2>

			<p class="mx-auto mt-6 max-w-3xl text-base leading-8 text-gray-600 sm:text-lg">
				Čia rasite svarbiausią informaciją apie kainą, video sukūrimą, kalbas, el. pašto
				pristatymą ir tai, kam tinka ši personalizuota kalėdinė dovana.
			</p>
		</div>

		<div class="mx-auto mt-16 max-w-5xl divide-y divide-red-light rounded-3xl border border-red-light bg-white">
			{#each faqs as faq (faq.question)}
				<details class="group px-6 py-6 open:bg-red-light/30 sm:px-8">
					<summary class="flex cursor-pointer list-none items-center justify-between gap-6">
						<h3 class="text-lg font-bold text-gray-950 sm:text-xl">
							{faq.question}
						</h3>

						<span
							class="flex h-10 w-10 shrink-0 items-center justify-center rounded-full bg-red-light text-2xl font-bold text-red transition group-open:rotate-45"
							aria-hidden="true"
						>
							+
						</span>
					</summary>

					<p class="mt-5 max-w-4xl text-base sm:text-lg leading-8 text-gray-600">
						{faq.answer}
					</p>
				</details>
			{/each}
		</div>

		<div class="mt-14 flex justify-center">
			<Button
				href="#create-greeting"
				size="xl"
				class="bg-red px-6 py-3 text-base font-bold hover:bg-red-dark md:text-lg"
			>
				Sukurti sveikinimą
			</Button>
		</div>
	</div>
</section>