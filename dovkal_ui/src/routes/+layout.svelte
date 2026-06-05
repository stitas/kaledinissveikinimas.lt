<script lang="ts">
	import { env } from '$env/dynamic/public';
	import './layout.css';
	import appleTouchIcon from '$lib/assets/apple-touch-icon.png';
	import faviconPng from '$lib/assets/favicon-96x96.png';
	import faviconSvg from '$lib/assets/favicon.svg';
	import siteManifest from '$lib/assets/site.webmanifest';
	import { trackInteractions } from '$lib/utils/umami';

	let { children } = $props();

	const umamiWebsiteId = env.PUBLIC_UMAMI_WEBSITE_ID;
	const umamiScriptSrc = env.PUBLIC_UMAMI_SCRIPT_SRC || 'http://localhost:3001/script.js';
</script>

<svelte:head>
	<link rel="icon" type="image/png" href={faviconPng} sizes="96x96" />
	<link rel="icon" type="image/svg+xml" href={faviconSvg} />
	<link rel="apple-touch-icon" sizes="180x180" href={appleTouchIcon} />
	<link rel="manifest" href={siteManifest} />
	{#if umamiWebsiteId}
		<script defer src={umamiScriptSrc} data-website-id={umamiWebsiteId}></script>
	{/if}
</svelte:head>

<div use:trackInteractions class="contents">
	{@render children()}
</div>
