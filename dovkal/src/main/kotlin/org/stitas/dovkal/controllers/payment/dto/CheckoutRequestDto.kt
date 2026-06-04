package org.stitas.dovkal.controllers.payment.dto

import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.stitas.dovkal.enums.Locale
import org.stitas.dovkal.enums.SantaType

data class CheckoutRequestDto(

    val santaType: SantaType,

    @field:NotBlank(message = "Žinutė privaloma")
    @field:Size(min = 1, max = 1500, message = "Žinutė turi būti tarp 1 ir 1500 simbolių")
    val script: String,

    @field:NotBlank(message = "El. paštas privalomas")
    @field:Email(message = "Blogas el. pašto formatas")
    @field:Size(max = 255, message = "El. paštas turi būti tarp 1 ir 255 simbolių")
    val email: String,

    val locale: Locale,

    @field:AssertTrue(message = "Turite sutikti su naudojimo taisyklėmis")
    val hasAcceptedTerms: Boolean,
)