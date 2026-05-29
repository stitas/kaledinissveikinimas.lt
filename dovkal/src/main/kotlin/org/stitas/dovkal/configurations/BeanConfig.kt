package org.stitas.dovkal.configurations

import com.stripe.StripeClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.stitas.dovkal.properties.StripeProperties

@Configuration
class BeanConfig {

    @Bean
    fun stripeClient(stripeProperties: StripeProperties): StripeClient {
        return StripeClient(stripeProperties.secret)
    }
}