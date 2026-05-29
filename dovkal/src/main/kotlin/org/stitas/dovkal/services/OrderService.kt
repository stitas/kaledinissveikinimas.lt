package org.stitas.dovkal.services

import org.springframework.stereotype.Service
import org.stitas.dovkal.models.Order
import org.stitas.dovkal.repositories.OrderRepository

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun save(order: Order): Order {
        return orderRepository.save(order)
    }

    fun findByStripeCheckoutId(stripeCheckoutId: String): Order? {
        return orderRepository.findByStripeCheckoutId(stripeCheckoutId)
    }
}