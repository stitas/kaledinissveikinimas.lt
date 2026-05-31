package org.stitas.dovkal.services

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.stitas.dovkal.enums.OrderStatus
import org.stitas.dovkal.models.Order
import org.stitas.dovkal.repositories.OrderRepository
import java.util.UUID

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

    fun changeOrderStatus(order: Order, orderStatus: OrderStatus) {
        order.status = orderStatus
        log.info("Order status for customer={} changed to {}", order.email, order.status)
    }

    fun findByHeyGenVideoId(heyGenVideoId: String): Order? {
        return orderRepository.findByHeyGenVideoId(heyGenVideoId)
    }

    fun findByOrderId(orderId: UUID): Order? {
        return orderRepository.findById(orderId).orElse(null)
    }

    companion object {
        private val log = LoggerFactory.getLogger(OrderService::class.java)
    }
}