<script lang="ts">
	import { resolve } from '$app/paths';

	import {
		Footer,
		FooterLinkGroup,
		FooterLink,
		FooterIcon,
		FooterCopyright
	} from 'flowbite-svelte';

	import { FacebookSolid, InstagramSolid } from 'flowbite-svelte-icons';
	import { SUPPORT_EMAIL } from '$lib/utils/constants';

	const currentYear = new Date().getFullYear();
</script>

<Footer footerType="sitemap" class="bg-red!">
	<div class="w-full b!g-red text-white">
		<div class="mx-auto max-w-496 px-6 py-14">
			<div class="grid gap-12 md:grid-cols-[1.4fr_1fr_1fr_1fr]">
				<div>
					<a href={resolve('/')} class="text-3xl font-bold tracking-tight text-white">
						KaledinisSveikinimas.lt
					</a>

					<p class="mt-5 max-w-md text-base leading-7 text-red-light">
						Sukurkite personalizuotą Kalėdų Senelio video sveikinimą pagal savo tekstą.
						Originali kalėdinė dovana vaikams, draugams, šeimai ir kolegoms.
					</p>

					<!-- TODO Create social media channels -->
					<!-- <div class="mt-6 flex gap-5">
						<FooterIcon
							href="https://www.facebook.com/"
							aria-label="KaledinisSveikinimas.lt Facebook paskyra"
							class="text-white hover:text-white!"
						>
							<FacebookSolid class="h-6 w-6" />
						</FooterIcon>

						<FooterIcon
							href="https://www.instagram.com/"
							aria-label="KaledinisSveikinimas.lt Instagram paskyra"
							class="text-white hover:text-white!"
						>
							<InstagramSolid class="h-6 w-6" />
						</FooterIcon>

						<FooterIcon
							href="https://www.tiktok.com/"
							aria-label="KaledinisSveikinimas.lt TikTok paskyra"
							class="text-white hover:text-white!"
						>
							<svg
								class="h-6 w-6"
								viewBox="0 0 24 24"
								fill="currentColor"
								aria-hidden="true"
								xmlns="http://www.w3.org/2000/svg"
							>
								<path
									d="M19.59 6.69a4.83 4.83 0 0 1-3.77-4.25V2h-3.45v13.67a2.89 2.89 0 1 1-2-2.75v-3.5a6.34 6.34 0 1 0 5.45 6.27V8.73a8.16 8.16 0 0 0 4.77 1.52V6.8c-.34 0-.67-.04-1-.11Z"
								/>
							</svg>
						</FooterIcon>
					</div> -->
				</div>

				<nav aria-label="Pagrindinės svetainės nuorodos">
					<h2 class="mb-6 text-sm font-bold uppercase tracking-wide text-red-light">
						Svetainė
					</h2>

					<FooterLinkGroup>
						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={resolve('/')}>
							Pagrindinis
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={resolve('/#sukurti-sveikinima')}>
							Sukurti sveikinimą
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={resolve('/#kaip-tai-veikia')}>
							Kaip tai veikia?
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={resolve('/#kam-tinka-si-dovana')}>
							Kam tinka ši dovana?
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={resolve('/#duk')}>
							DUK
						</FooterLink>

						<!-- TODO add blog -->
						<!-- <FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/blog')}>
							Blogas
						</FooterLink> -->
					</FooterLinkGroup>
				</nav>

				<nav aria-label="Kalėdinių dovanų kategorijos">
					<h2 class="mb-6 text-sm font-bold uppercase tracking-wide text-red-light">
						Kam tinka?
					</h2>

					<FooterLinkGroup>
						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/sveikinimai/')}>
							Visi kalėdiniai sveikinimai
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/sveikinimai/kaledinis-sveikinimas-vaikams/')}>
							Kalėdinis sveikinimas vaikams
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/sveikinimai/kaledinis-sveikinimas-kolegoms/')}>
							Kalėdinis sveikinimas kolegoms
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/sveikinimai/kaledinis-sveikinimas-mokytojai/')}>
							Kalėdinis sveikinimas mokytojai
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/sveikinimai/kaledinis-sveikinimas-draugams/')}>
							Kalėdinis sveikinimas draugams
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/sveikinimai/kaledinis-sveikinimas-mamai/')}>
							Kalėdinis sveikinimas mamai
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/sveikinimai/kaledinis-sveikinimas-tevams/')}>
							Kalėdinis sveikinimas tėvams
						</FooterLink>
					</FooterLinkGroup>
				</nav>

				<nav aria-label="Teisinė informacija">
					<h2 class="mb-6 text-sm font-bold uppercase tracking-wide text-red-light">
						Informacija
					</h2>

					<FooterLinkGroup>
						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/privatumo-politika')}>
							Privatumo politika
						</FooterLink>

						<FooterLink class="mb-4 text-white! hover:text-red-light!" href={(resolve as (path: string) => string)('/naudojimo-taisykles')}>
							Naudojimosi taisyklės
						</FooterLink>
					</FooterLinkGroup>
				</nav>
			</div>
		</div>
	</div>

	<div class="w-full bg-red px-6 py-6">
		<div class="mx-auto flex max-w-496 flex-col gap-4 text-center md:flex-row md:items-center md:justify-between md:text-left">
			<FooterCopyright
				class="text-sm text-red-light!"
				href={resolve('/')}
				by="KaledinisSveikinimas.lt"
				year={currentYear}
				copyrightMessage="Visos teisės saugomos"
			/>

			<p class="text-sm text-red-light">
				Susisiekite: {SUPPORT_EMAIL}
			</p>
		</div>
	</div>
</Footer>
