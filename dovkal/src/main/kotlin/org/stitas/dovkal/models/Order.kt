package org.stitas.dovkal.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.UpdateTimestamp
import org.stitas.dovkal.enums.Locale
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

    @Column(name = "heygen_video_id", unique = true, length = 255)
    var heyGenVideoId: String? = null,

    @Column(name = "email", nullable = false, length = 255)
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "santa_type", nullable = false, length = 20)
    var santaType: SantaType,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    var status: OrderStatus,

    @Column(name = "script", nullable = false, length = 1500)
    var script: String,

    @Column(name = "script_size", nullable = false)
    var scriptSize: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "locale", nullable = false, length = 2)
    var locale: Locale,

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    var createdAt: Instant? = Instant.now(),

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    var updatedAt: Instant? = Instant.now(),
)