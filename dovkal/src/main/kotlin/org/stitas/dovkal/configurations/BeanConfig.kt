package org.stitas.dovkal.configurations

import com.stripe.StripeClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient
import org.stitas.dovkal.properties.HeyGenProperties
import org.stitas.dovkal.properties.StripeProperties
import tools.jackson.module.kotlin.KotlinModule

@Configuration
class BeanConfig {

    @Bean
    fun stripeClient(stripeProperties: StripeProperties): StripeClient {
        return StripeClient(stripeProperties.secret)
    }

    @Bean
    fun heyGenRestClient(
        builder: RestClient.Builder,
        heyGenProperties: HeyGenProperties,
    ): RestClient {
        return builder
            .baseUrl(heyGenProperties.baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader("x-api-key", heyGenProperties.apiKey)
            .build()
    }

    @Bean
    fun kotlinModule(): KotlinModule {
        return KotlinModule.Builder().build()
    }
}