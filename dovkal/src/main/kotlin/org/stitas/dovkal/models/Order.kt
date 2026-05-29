package org.stitas.dovkal.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.stitas.dovkal.enums.OrderStatus
import org.stitas.dovkal.enums.SantaType
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "orders")
class Order(

    @Id
    @Column(name = "id", nullable = false)
    var id: UUID = UUID.randomUUID(),

    @Column(name = "stripe_checkout_id", nullable = false, unique = true, length = 255)
    var stripeCheckoutId: String,

    @Column(name = "email", nullable = false, length = 255)
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "santa_type", nullable = false, length = 20)
    var santaType: SantaType,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    var status: OrderStatus,

    @Column(name = "message", nullable = false, length = 1500)
    var message: String,

    @Column(name = "message_size", nullable = false)
    var messageSize: Int,

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    var createdAt: Instant? = Instant.now()
)