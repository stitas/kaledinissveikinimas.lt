package org.stitas.dovkal.controllers.payment

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.stitas.dovkal.controllers.payment.dto.CheckoutRequestDto
import org.stitas.dovkal.enums.OrderStatus
import org.stitas.dovkal.integrations.stripe.StripeService
import org.stitas.dovkal.models.Order
import org.stitas.dovkal.services.OrderService

@Service
class PaymentControllerService(
    private val stripeService: StripeService,
    private val orderService: OrderService,
) {
    fun getCheckoutUrlAndCreateOrder(requestDto: CheckoutRequestDto): String {
        log.info("Checkout session request by user={}", requestDto.email)
        val checkoutSession = stripeService.createCheckoutSession(requestDto.email, requestDto.message.length)

        val order = Order(
            stripeCheckoutId = checkoutSession.stripeCheckoutId,
            email = requestDto.email,
            santaType = requestDto.santaType,
            status = OrderStatus.WAITING_PAYMENT,
            message = requestDto.message,
            messageSize = requestDto.message.length,
        )
        orderService.save(order)

        log.info("Checkout session created for user={}", requestDto.email)
        return checkoutSession.stripeCheckoutUrl
    }

    companion object {
        private val log = LoggerFactory.getLogger(PaymentControllerService::class.java)
    }
}