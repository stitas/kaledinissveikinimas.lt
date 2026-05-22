<script lang="ts">
    type Props = {
		posterSrc?: string;
		videoSrc?: string;
		posterAlt?: string;
		videoLabel?: string;
		caption?: string;
	};

	let { posterSrc, videoSrc, posterAlt, videoLabel, caption }: Props = $props();

	let showVideo = $state(false);
</script>

<div class="relative mx-auto w-full max-w-6xl justify-self-center xl:mx-0 xl:max-w-264 xl:justify-self-end">
	<div class="rounded-3xl bg-red-light p-4 shadow-xl sm:p-5">
		<div class="overflow-hidden rounded-2xl bg-white">
			{#if showVideo}
				<video
					class="aspect-video w-full bg-black"
					controls
					autoplay
					preload="metadata"
					aria-label={videoLabel}
				>
					<source src={videoSrc} type="video/mp4" />
					Jūsų naršyklė nepalaiko video atkūrimo.
				</video>
			{:else}
				<button
					type="button"
					class="group relative block w-full"
					aria-label="Peržiūrėti pavyzdinį Kalėdų Senelio video"
					onclick={() => (showVideo = true)}
				>
					<img
						src={posterSrc}
						alt={posterAlt}
						width="1200"
						height="675"
						class="aspect-video w-full object-cover"
						loading="eager"
						decoding="async"
						fetchpriority="high"
					/>

					<span
						class="absolute inset-0 flex items-center justify-center bg-black/25 transition group-hover:bg-black/35"
					>
						<span
							class="flex h-20 w-20 items-center justify-center rounded-full bg-white text-3xl text-red shadow-lg sm:h-24 sm:w-24 sm:text-4xl"
						>
							▶
						</span>
					</span>
				</button>
			{/if}
		</div>
	</div>

	<p class="mt-4 text-center text-base text-gray-600 sm:text-lg">
		{caption}
	</p>
</div>