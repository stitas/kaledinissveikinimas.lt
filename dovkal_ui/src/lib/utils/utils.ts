import { resolve } from '$app/paths';

const resolveUrl = resolve as unknown as (path: string) => string;

export default function capitalize(str: string): string {
  if (!str) return str;
  return str.charAt(0).toUpperCase() + str.slice(1);
}

export function resolvePath(path: string) {
  return resolveUrl(path);
}
