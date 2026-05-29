package org.stitas.dovkal.controllers.payment

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.stitas.dovkal.controllers.payment.dto.CheckoutRequestDto
import org.stitas.dovkal.controllers.payment.dto.CheckoutResponseDto

@RestController
@RequestMapping("/api/v1/payment")
class PaymentController(
    private val paymentControllerService: PaymentControllerService
) {

    @PostMapping("/")
    fun createCheckoutSession(@Valid @RequestBody requestDto: CheckoutRequestDto): CheckoutResponseDto {
        val checkoutUrl = paymentControllerService.getCheckoutUrlAndCreateOrder(requestDto)
        return CheckoutResponseDto(checkoutUrl)
    }
}