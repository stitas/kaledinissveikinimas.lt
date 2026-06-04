import { env } from "$env/dynamic/private"

export async function createCheckoutSession(
    payload: CheckoutRequest, 
    fetch: typeof globalThis.fetch
): Promise<CheckoutResponse> {
    const response = await fetch(`${env.PRIVATE_BACKEND_URL}/api/v1/payment/`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(payload)
	});

    if (!response.ok) {
        throw new Error('Nepavyko sukurti mokėjimo sesijos');
    }

    const data = await response.json();
    return data;
}

export type CheckoutRequest = {
    santaType: SantaType;
    script: string;
    email: string;
    locale: Locale;
    hasAcceptedTerms: boolean;
}

export type CheckoutResponse = {
    checkoutUrl: string;
}

export type SantaType = "CLASSIC" | "SLEIGH" | "CHIMNEY";

export type Locale = "LT" | "PL" | "EN";