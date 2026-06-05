import type { PageServerLoad } from './$types';
import { getVideoData, type VideoData } from '$lib/server/video';

export const load: PageServerLoad = async ({ params, fetch }): Promise<CompletedOrderData> => {
	try {
		const video = await getVideoData(params.slug, fetch);

		return {
			orderId: params.slug,
			video,
		};
	} catch {
		return {
			orderId: params.slug,
			video: null,
		};
	}
};

export type CompletedOrderData = {
	orderId: string,
	video: VideoData | null,
}