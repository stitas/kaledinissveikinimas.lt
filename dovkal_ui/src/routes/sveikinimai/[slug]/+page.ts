import { error } from '@sveltejs/kit';
import { getGreetingSeoPageBySlug } from '$lib/data/greeting-seo';
import type { PageLoad } from './$types';

export const load: PageLoad = ({ params }) => {
	const page = getGreetingSeoPageBySlug(params.slug);

	if (!page) {
		throw error(404, 'Page not found');
	}

	return {page};
};