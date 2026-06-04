import { env } from '$env/dynamic/private';

export async function getVideoData(
	uuid: string,
	fetch: typeof globalThis.fetch
): Promise<VideoData> {
	const response = await fetch(`${env.PRIVATE_BACKEND_URL}/api/v1/video/${encodeURIComponent(uuid)}`);

	if (!response.ok) {
		throw new Error('Nepavyko rasti video');
	}

	const data = (await response.json()) as VideoData;

	if (!data.videoUrl || !data.thumbnailUrl) {
		throw new Error('Nepavyko rasti video');
	}

	return data;
}

export type VideoData = {
	videoUrl: string;
	thumbnailUrl: string;
};