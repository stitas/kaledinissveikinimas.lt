package org.stitas.dovkal.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.stitas.dovkal.models.Order
import java.util.UUID

@Repository
interface OrderRepository : JpaRepository<Order, UUID> {
    fun findByStripeCheckoutId(stripeCheckoutId: String): Order?

    fun findByHeyGenVideoId(heyGenVideoId: String): Order?
}