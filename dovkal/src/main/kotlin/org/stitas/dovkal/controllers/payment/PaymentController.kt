package org.stitas.dovkal.controllers.payment

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.stitas.dovkal.controllers.payment.dto.CheckoutRequestDto
import org.stitas.dovkal.controllers.payment.dto.CheckoutResponseDto
import org.stitas.dovkal.integrations.stripe.StripeService

@RestController
@RequestMapping("/api/v1/payment")
class PaymentController(
    private val stripeService: StripeService
) {

    @PostMapping("/")
    fun createCheckoutSession(@Valid @RequestBody requestDto: CheckoutRequestDto): CheckoutResponseDto {
        val checkoutUrl = stripeService.createCheckoutSession(requestDto)
        return CheckoutResponseDto(checkoutUrl)
    }

    @PostMapping("/hook")
    fun stripeWebhook(@RequestBody payload: String, @RequestHeader("Stripe-Signature") stripeSignature: String): ResponseEntity<Void> {
        stripeService.handleWebhook(payload, stripeSignature)
        return ResponseEntity.ok().build()
    }
}