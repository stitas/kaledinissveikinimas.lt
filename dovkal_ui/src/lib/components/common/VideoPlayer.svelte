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

<div class="relative mx-auto w-full max-w-4xl justify-self-center xl:mx-0 xl:max-w-3xl xl:justify-self-end 2xl:max-w-4xl">
	<div class="rounded-2xl bg-red-light/80 p-3 sm:p-4">
		<div class="overflow-hidden rounded-xl bg-white">
			{#if showVideo}
				<video
					class="aspect-video w-full bg-black"
					controls
					autoplay
					preload="metadata"
					aria-label={videoLabel}
					data-analytics-label={videoLabel || 'Video peržiūra'}
				>
					<source src={videoSrc} type="video/mp4" />
					Jūsų naršyklė nepalaiko video atkūrimo.
				</video>
			{:else}
				<button
					type="button"
					class="group relative block w-full"
					aria-label="Peržiūrėti pavyzdinį Kalėdų Senelio video"
					data-analytics-label={videoLabel || 'Peržiūrėti video'}
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

					<span class="absolute inset-0 flex items-center justify-center bg-black/25 transition group-hover:bg-black/35">
						<span class="flex h-14 w-14 items-center justify-center rounded-full bg-white text-2xl text-red shadow-lg sm:h-18 sm:w-18 sm:text-3xl">
							▶
						</span>
					</span>
				</button>
			{/if}
		</div>
	</div>

	{#if caption}
		<p class="mt-3 text-center text-sm text-gray-600 sm:text-base">
			{caption}
		</p>
	{/if}
</div>
