<script lang="ts">
	import { env } from '$env/dynamic/public';
	import './layout.css';
	import favicon from '$lib/assets/favicon.svg';
	import { trackInteractions } from '$lib/utils/umami';

	let { children } = $props();

	const umamiWebsiteId = env.PUBLIC_UMAMI_WEBSITE_ID;
	const umamiScriptSrc = env.PUBLIC_UMAMI_SCRIPT_SRC || 'http://localhost:3001/script.js';
</script>

<svelte:head>
	<link rel="icon" href={favicon} />
	{#if umamiWebsiteId}
		<script defer src={umamiScriptSrc} data-website-id={umamiWebsiteId}></script>
	{/if}
</svelte:head>

<div use:trackInteractions class="contents">
	{@render children()}
</div>
