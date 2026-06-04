import { error, type RequestHandler } from '@sveltejs/kit';
import { getVideoData } from '$lib/server/video';

export const GET: RequestHandler = async ({ params, fetch }) => {
	const orderId = params.slug;

	if (!orderId) {
		throw error(400, 'Missing order id');
	}

	const video = await getVideoData(orderId, fetch);

	const videoResponse = await fetch(video.videoUrl);

	if (!videoResponse.ok || !videoResponse.body) {
		throw error(502, 'Could not download video');
	}

	return new Response(videoResponse.body, {
		status: 200,
		headers: {
			'Content-Type': videoResponse.headers.get('content-type') ?? 'video/mp4',
			'Content-Disposition': `attachment; filename="kaledu-senelio-sveikinimas-${orderId}.mp4"`,
			'Cache-Control': 'no-store'
		}
	});
};