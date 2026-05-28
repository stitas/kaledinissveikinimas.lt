<script lang="ts">
	import VideoPlayer from '$lib/components/common/VideoPlayer.svelte';

	export type VideoSlide = {
		id: string;
		posterSrc: string;
		videoSrc: string;
		posterAlt: string;
		videoLabel: string;
		caption: string;
	};

	type Props = {
		videos: VideoSlide[];
	};

	let { videos }: Props = $props();

	let carouselElement = $state<HTMLDivElement | null>(null);
	let activeIndex = $state(0);

	function scrollToSlide(index: number) {
		if (!carouselElement || videos.length === 0) return;

		const nextIndex = (index + videos.length) % videos.length;
		activeIndex = nextIndex;

		carouselElement.scrollTo({
			left: nextIndex * carouselElement.clientWidth,
			behavior: 'smooth'
		});
	}

	function goToPreviousSlide() {
		scrollToSlide(activeIndex - 1);
	}

	function goToNextSlide() {
		scrollToSlide(activeIndex + 1);
	}

	function updateActiveSlideFromScroll() {
		if (!carouselElement) return;

		const nextIndex = Math.round(carouselElement.scrollLeft / carouselElement.clientWidth);
		activeIndex = Math.min(Math.max(nextIndex, 0), videos.length - 1);
	}
</script>

<section aria-label="Pavyzdiniai Kalėdų Senelio video sveikinimai" class="w-full">
	<div class="relative">
		<div
			bind:this={carouselElement}
			onscroll={updateActiveSlideFromScroll}
			class="no-scrollbar flex snap-x snap-mandatory overflow-x-auto scroll-smooth"
		>
			{#each videos as video (video.id)}
				<div class="min-w-full snap-center px-1">
					<VideoPlayer
						posterSrc={video.posterSrc}
						videoSrc={video.videoSrc}
						posterAlt={video.posterAlt}
						videoLabel={video.videoLabel}
						caption={video.caption}
					/>
				</div>
			{/each}
		</div>

		{#if videos.length > 1}
			<div class="mt-5 flex items-center justify-center gap-6">
				<button
					type="button"
					class="flex h-9 w-9 items-center justify-center rounded-full text-3xl font-bold text-red transition hover:bg-red-light hover:text-red-dark focus:outline-none focus:ring-4 focus:ring-red-light"
					onclick={goToPreviousSlide}
					aria-label="Rodyti ankstesnį video"
				>
					‹
				</button>

				<div class="flex items-center justify-center gap-3" aria-label="Video karuselės pozicija">
					{#each videos as video, index (video.id)}
						<button
							type="button"
							class={`h-3 w-3 rounded-full transition ${
								activeIndex === index ? 'bg-red' : 'bg-red-light hover:bg-red'
							}`}
							onclick={() => scrollToSlide(index)}
							aria-label={`Rodyti ${index + 1} video`}
							aria-current={activeIndex === index ? 'true' : undefined}
						></button>
					{/each}
				</div>

				<button
					type="button"
					class="flex h-9 w-9 items-center justify-center rounded-full text-3xl font-bold text-red transition hover:bg-red-light hover:text-red-dark focus:outline-none focus:ring-4 focus:ring-red-light"
					onclick={goToNextSlide}
					aria-label="Rodyti kitą video"
				>
					›
				</button>
			</div>
		{/if}
	</div>
</section>

<style>
	.no-scrollbar {
		scrollbar-width: none;
		-ms-overflow-style: none;
	}

	.no-scrollbar::-webkit-scrollbar {
		display: none;
	}
</style>