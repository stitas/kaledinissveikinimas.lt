import type { PageLoad } from './$types';
import { seoPages } from '$lib/data/greeting-seo';

export const prerender = true;

export const load: PageLoad = () => {
	return {
		pages: seoPages
	};
};