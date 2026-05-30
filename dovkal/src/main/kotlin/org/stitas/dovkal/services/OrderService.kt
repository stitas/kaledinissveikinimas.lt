package org.stitas.dovkal.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.stitas.dovkal.enums.OrderStatus
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

    fun changeOrderStatus(order: Order, orderStatus: OrderStatus): Order {
        order.status = orderStatus
        val savedOrder = save(order)
        log.info("Order status for customer={} changed to {}", savedOrder.email, savedOrder.status)
        return savedOrder
    }

    companion object {
        private val log = LoggerFactory.getLogger(OrderService::class.java)
    }
}