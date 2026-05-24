<script lang="ts">
	import { Button } from 'flowbite-svelte';
    import InfoTooltip from '$lib/components/InfoTooltip.svelte';

	type SantaTemplate = {
		id: string;
		name: string;
		image: string;
		alt: string;
	};

    type GreetingTemplate = {
		id: string;
		label: string;
		text: string;
	};

	type Checkpoint = {
		value: number;
		label: string;
	};

    type Props = {
		formId?: string;
		maxCharacters?: number;
	};

	let {
		formId = 'create-greeting',
		maxCharacters = 1500
	}:Props = $props();

	const templates: SantaTemplate[] = [
		{
			id: 'classic-santa',
			name: 'Klasikinis Kalėdų Senelis',
			image: '/images/santa-classic-preview.jpg',
			alt: 'Klasikinis Kalėdų Senelis jaukiame kalėdiniame kambaryje'
		},
		{
			id: 'outdoor-santa',
			name: 'Kalėdų Senelis lauke',
			image: '/images/santa-classic-preview.jpg',
			alt: 'Kalėdų Senelis lauke žiemos fone'
		},
		{
			id: 'modern-santa',
			name: 'Modernus Kalėdų Senelis',
			image: '/images/santa-classic-preview.jpg',
			alt: 'Modernus Kalėdų Senelis šviesiame kambaryje'
		}
	];

    const greetingTemplates: GreetingTemplate[] = [
        {
            id: 'children',
            label: 'Vaikams',
            text: `Labas, [vardas]! Čia Kalėdų Senelis. Girdėjau, kad šiais metais buvai labai šaunus ir stengeisi būti geras. Aš labai tavimi didžiuojuosi! Linkiu tau stebuklingų Kalėdų, daug šypsenų, jaukių akimirkų su šeima ir, žinoma, smagių dovanų po eglute. Linksmų Kalėdų!`
        },
        {
            id: 'friends',
            label: 'Draugams',
            text: `Labas, [vardas]! Čia Kalėdų Senelis. Šiemet ilgai galvojau, ar tave įtraukti į gerų vaikų sąrašą, bet nusprendžiau suteikti dar vieną šansą. Tavo juokeliai gal ir ne visada geri, bet bent jau stengiesi! Linkiu tau linksmų Kalėdų, daug juoko, skanaus maisto ir kuo mažiau keistų sprendimų kitais metais.`
        },
        {
            id: 'colleagues',
            label: 'Kolegoms',
            text: `Sveiki, kolegos! Čia Kalėdų Senelis. Noriu padėkoti už jūsų darbą, kantrybę ir pastangas šiais metais. Linkiu jaukių Kalėdų, ramaus poilsio, daug šventinės nuotaikos ir sėkmingų ateinančių metų. Tegul po švenčių sugrįžta ne tik motyvacija, bet ir pilnai įkrautos baterijos!`
        }
    ];

    function applyGreetingTemplate(text: string) {
        message = text;
    }

	const checkpoints: Checkpoint[] = [
		{ value: 0, label: '0' },
		{ value: 375, label: '375' },
		{ value: 750, label: '750' },
		{ value: 1125, label: '1125' },
		{ value: 1500, label: '1500' }
	];

	let selectedTemplateId = $state(templates[0].id);
	let message = $state('');
	let email = $state('');

	let characterCount = $derived(message.length);
	let remainingCharacters = $derived(maxCharacters - characterCount);
	let isMessageTooLong = $derived(remainingCharacters < 0);

	let progressPercent = $derived(Math.min((characterCount / maxCharacters) * 100, 100));

	let currentPrice = $derived.by(() => {
		if (characterCount < 375) return '6,99';
		if (characterCount < 750) return '7,99';
		if (characterCount < 1125) return '8,99';
		return '9,99';
	});

	let canSubmit = $derived(message.trim().length > 0 && email.trim().length > 0 && !isMessageTooLong);
    let btnText = $derived.by(() => {
        if (!message) return 'Užpildykite sveikinimo tekstą';
        if (!email) return 'Įveskite savo el. pašto adresą';
        return `Sukurti Kalėdų Senelio video už ${currentPrice}€`
    })
</script>

<section id={formId} aria-labelledby="creator-title" class="mx-auto max-w-512 px-6 pb-12 mb-20">
	<form method="POST" class="space-y-12">
		<input type="hidden" name="templateId" value={selectedTemplateId} />

		<fieldset>
			<div class="mb-6 flex items-center gap-3">
                <span class="text-3xl font-bold text-red">1</span>
                <legend class="text-2xl font-bold tracking-tight text-gray-950 sm:text-3xl">
                    Pasirinkite Kalėdų Senelio video šabloną
                </legend>
                <InfoTooltip text="Pasirinkite, kaip atrodys Kalėdų Senelis jūsų personalizuotame video sveikinime." />
            </div>

			<div class="grid grid-cols-1 gap-5 sm:grid-cols-3">
				{#each templates as template (template.id)}
					<button
						type="button"
						class={`relative overflow-hidden rounded-2xl border-4 transition ${
							selectedTemplateId === template.id
								? 'border-red bg-red-light'
								: 'border-transparent hover:border-red-light'
						}`}
						aria-pressed={selectedTemplateId === template.id}
						aria-label={`Pasirinkti šabloną: ${template.name}`}
						onclick={() => (selectedTemplateId = template.id)}
					>
						<img
							src={template.image}
							alt={template.alt}
							width="480"
							height="270"
							class="aspect-video w-full object-cover"
							loading="lazy"
							decoding="async"
						/>

						{#if selectedTemplateId === template.id}
							<span class="absolute bottom-3 left-1/2 -translate-x-1/2 rounded-full bg-white px-4 py-2 text-sm font-bold text-red">
								Pasirinkta ✓
							</span>
						{/if}
					</button>
				{/each}
			</div>
		</fieldset>

		<div>
			<div class="mb-6 flex flex-wrap items-center justify-between gap-3">
                <div class="flex flex-wrap items-center gap-3">
                    <span class="text-3xl font-bold text-red">2</span>
                    <label for="greeting-text" class="text-2xl font-bold tracking-tight text-gray-950 sm:text-3xl">
                        Parašykite sveikinimo tekstą
                    </label>

                    <InfoTooltip text="Jūsų parašytas tekstas bus įgarsintas Kalėdų Senelio balsu." />
                </div>

                <p class="text-base font-medium text-gray-500 sm:text-lg">
                    Palaikomos anglų, lenkų ir kitos kalbos
                </p>
            </div>

			<textarea
				id="greeting-text"
				name="greeting-text"
				bind:value={message}
				maxlength={maxCharacters}
				rows="8"
				required
				class="w-full resize-none rounded-2xl border border-gray-300 bg-gray-50 p-5 text-lg text-gray-950 focus:border-red focus:ring-red sm:text-xl"
				placeholder="Pvz.: Labas, Rokai! Kalėdų Senelis labai tavimi didžiuojasi..."
			></textarea>

            <div class="mt-4 flex flex-wrap gap-3">
                {#each greetingTemplates as template (template.id)}
                    <button
                        type="button"
                        class="rounded-full border border-red px-5 py-2 text-base font-semibold text-red transition hover:bg-red hover:text-white"
                        onclick={() => applyGreetingTemplate(template.text)}
                    >
                        {template.label}
                    </button>
                {/each}
            </div>

			<div class="mt-5 grid gap-6 lg:grid-cols-[auto_1fr_auto] lg:items-center lg:gap-x-10 lg:gap-y-3">
                <p class={`w-44 shrink-0 text-lg font-medium tabular-nums ${isMessageTooLong ? 'text-red' : 'text-gray-700'}`}>
                    Liko {remainingCharacters} simbolių
                </p>

                <div class="relative h-4 rounded-full bg-red-light">
                    <div
                        class="h-4 rounded-full bg-red transition-all duration-300"
                        style={`width: ${progressPercent}%`}
                    ></div>

                    {#each checkpoints as checkpoint (checkpoint.value)}
                        <span
                            class={`absolute top-1/2 h-5 w-5 -translate-x-1/2 -translate-y-1/2 rounded-full border-2 ${
                                characterCount >= checkpoint.value ? 'border-red bg-red' : 'border-red bg-white'
                            }`}
                            style={`left: ${(checkpoint.value / maxCharacters) * 100}%`}
                            aria-hidden="true"
                        ></span>
                    {/each}
                </div>

                <div class="flex h-10 items-center rounded-2xl bg-red-light px-5 text-lg font-bold text-red">
                    Kaina: {currentPrice} €
                </div>

                <div class="hidden lg:block"></div>

                <div class="relative h-5 text-sm text-gray-500">
                    {#each checkpoints as checkpoint (checkpoint.value)}
                        <span
                            class="absolute -translate-x-1/2"
                            style={`left: ${(checkpoint.value / maxCharacters) * 100}%`}
                        >
                            {checkpoint.label}
                        </span>
                    {/each}
                </div>

                <div class="hidden lg:block"></div>
            </div>
		</div>

		<div>
            <div class="mb-6 flex flex-wrap items-center gap-3">
                <span class="text-3xl font-bold text-red">3</span>
                <label for="email" class="text-2xl font-bold tracking-tight text-gray-950 sm:text-3xl">
                    Įveskite el. paštą
                </label>
                <InfoTooltip text="Į šį el. paštą gausite nuorodą į video, kai jis bus sugeneruotas" />
            </div>

			<input
				id="email"
				name="email"
				type="email"
                autocomplete="email"
				bind:value={email}
				required
				class="w-full rounded-2xl border border-gray-300 bg-gray-50 p-5 text-lg text-gray-950 focus:border-red focus:ring-red sm:text-xl"
				placeholder="jusu@email.lt"
			/>
		</div>

		<Button
			type="submit"
			disabled={!canSubmit}
			class="w-full bg-red px-8 py-5 text-xl font-bold hover:bg-red-dark disabled:cursor-not-allowed disabled:opacity-60"
		>
			{btnText}
		</Button>
	</form>
</section>