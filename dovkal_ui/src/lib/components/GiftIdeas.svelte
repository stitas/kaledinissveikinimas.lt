<script lang="ts">
	import { Button } from 'flowbite-svelte';

	type GiftIdea = {
		title: string;
		description: string;
		image: string;
		alt: string;
		imageFirst: boolean;
	};

	const giftIdeas: GiftIdea[] = [
		{
			title: 'Kalėdinė dovana vaikams',
			description:
				'Geras būdas sukurti vaikams jaukią atmosferą Kalėdų belaukiant. Taip pat švelniai pamokyti, paskatinti ar pagirti Kalėdų Senelio vardu.',
			image: '/images/gift-kids.webp',
			alt: 'Vaikas džiaugiasi žiūrėdamas Kalėdų Senelio video sveikinimą',
			imageFirst: true
		},
		{
			title: 'Juokingas Kalėdinis sveikinimas draugams',
			description:
				'Sukurkite linksmą Kalėdų Senelio video sveikinimą draugams su vidiniais juokeliais ir neįprastais palinkėjimais, kurį bus lengva pasidalinti į Messenger, WhatsApp, Viber ar kitą grupę.',
			image: '/images/gift-friends.webp',
			alt: 'Draugai kartu juokiasi žiūrėdami Kalėdinį video sveikinimą',
			imageFirst: false
		},
		{
			title: 'Originali dovana kolegoms',
			description:
				'Padėkokite komandai ar kolegoms už darbingus metus kartu. Personalizuotas Kalėdų Senelio video sveikinimas gali tapti linksma metų pabaigos staigmena, kuri tinka tiek mažai komandai, tiek visam skyriui.',
			image: '/images/gift-colleagues.webp',
			alt: 'Kolegos kartu žiūri Kalėdinį video sveikinimą',
			imageFirst: true
		}
	];
</script>

<section aria-labelledby="gift-ideas-title" class="bg-white px-4 py-16 sm:py-20 lg:px-6">
	<div class="mx-auto max-w-7xl">
		<div class="mx-auto max-w-3xl text-center">
			<p class="mb-3 text-sm font-semibold tracking-wide text-red uppercase sm:text-base">
				Kam tinka ši dovana?
			</p>

			<h2 id="gift-ideas-title" class="text-3xl font-bold tracking-tight text-gray-950 md:text-4xl">
				Viena kalėdinė dovana - daug skirtingų progų
			</h2>

			<p class="mx-auto mt-4 max-w-2xl text-base leading-7 text-gray-600 sm:text-lg">
				Kalėdų Senelio video sveikinimą galite pritaikyti vaikams, draugams ar kolegoms.
			</p>
		</div>

		<div class="mt-16 space-y-20">
			{#each giftIdeas as idea, index (idea.title)}
				<article class="grid items-center gap-8 lg:grid-cols-2 lg:gap-14">
					<div class={idea.imageFirst ? 'lg:order-1' : 'lg:order-2'}>
						<img
							src={idea.image}
							alt={idea.alt}
							width="900"
							height="560"
							loading={index === 0 ? 'eager' : 'lazy'}
							decoding="async"
							class="aspect-16/10 w-full rounded-2xl object-cover"
						/>
					</div>

					<div class={idea.imageFirst ? 'lg:order-2' : 'lg:order-1'}>
						<h3 class="text-2xl font-bold tracking-tight text-gray-950 md:text-3xl">
							{idea.title}
						</h3>

						<p class="mt-4 max-w-xl text-base leading-7 text-gray-600 md:text-lg">
							{idea.description}
						</p>

						<div class="mt-6 flex justify-center lg:justify-start">
							<Button
								href="#create-greeting"
								size="lg"
								class="bg-red px-6 py-3 text-base font-bold hover:bg-red-dark md:text-lg"
							>
								Sukurti sveikinimą
							</Button>
						</div>
					</div>
				</article>
			{/each}
		</div>
	</div>
</section>
