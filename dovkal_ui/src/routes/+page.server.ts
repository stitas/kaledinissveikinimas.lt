import { fail, redirect, type Actions } from "@sveltejs/kit";
import { createCheckoutSession, type CheckoutRequest, type Locale, type SantaType } from "$lib/server/payment";

export const actions: Actions = {
    createCheckout: async ({ request, fetch }) => {
        const formData = await request.formData();

        const santaType = (formData.get('santaType') ?? 'CLASSIC') as SantaType;
        const script = String(formData.get('script') ?? '');
		const email = String(formData.get('email') ?? '');
		const locale = (formData.get('locale') ?? 'LT') as Locale;

        let checkoutUrl: string;

        try {
            const requestDto: CheckoutRequest = { santaType, script, email, locale };
            const checkoutData = await createCheckoutSession(requestDto, fetch);
            checkoutUrl = checkoutData.checkoutUrl
        } catch (error) {
            return fail(400, {
                error: 'Nepavyko sukurti mokėjimo sesijos',
                values: {
                    santaType,
                    script,
                    email,
                    locale
                }
            });
        }

        throw redirect(303, checkoutUrl);
    }
}