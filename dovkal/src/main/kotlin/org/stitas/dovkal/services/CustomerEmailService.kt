package org.stitas.dovkal.services

import jakarta.mail.internet.InternetAddress
import org.slf4j.LoggerFactory
import org.springframework.core.io.ResourceLoader
import org.springframework.mail.MailException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.stitas.dovkal.exceptions.EmailSendingException
import org.stitas.dovkal.properties.EmailProperties
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import java.nio.charset.StandardCharsets
import java.util.UUID

@Service
class CustomerEmailService(
    private val mailSender: JavaMailSender,
    private val emailProperties: EmailProperties,
    private val templateEngine: TemplateEngine,
    private val resourceLoader: ResourceLoader,
) {

    fun sendOrderReceivedEmail(to: String, orderId: UUID) {
        val html = renderTemplate(
            "order-received",
            mapOf("orderId" to orderId.toString())
        )

        sendHtmlEmail(to, "Gavome jūsų Kalėdų Senelio video užsakymą", html)
    }

    fun sendVideoReadyEmail(to: String, orderId: UUID) {
        val videoPageUrl = emailProperties.frontendDownloadUrl.format(orderId)

        val html = renderTemplate(
            "video-ready",
            mapOf(
                "orderId" to orderId.toString(),
                "videoPageUrl" to videoPageUrl
            )
        )

        sendHtmlEmail(to, "Jūsų Kalėdų Senelio video sveikinimas paruoštas", html)
    }

    private fun sendHtmlEmail(to: String, subject: String, html: String) {
        try {
            val message = mailSender.createMimeMessage()
            val helper = MimeMessageHelper(message, false, StandardCharsets.UTF_8.name())

            helper.setFrom(
                InternetAddress(
                    emailProperties.from,
                    emailProperties.fromName,
                    StandardCharsets.UTF_8.name()
                )
            )

            helper.setTo(to)
            helper.setSubject(subject)
            helper.setText(html, true)

            mailSender.send(message)

            log.info("Email sent successfully. to={}, subject={}", to, subject)
        } catch (e: MailException) {
            log.error("Failed to send email. to={}, subject={}", to, subject, e)
            throw EmailSendingException("Failed to send email", e)
        }
    }

    fun renderTemplate(
        templateName: String,
        variables: Map<String, Any?>
    ): String {
        val context = Context().apply {
            setVariables(variables + mapOf("emailCss" to loadEmailCss()))
        }

        return templateEngine.process("emails/$templateName", context)
    }

    private fun loadEmailCss(): String {
        val resource = resourceLoader.getResource("classpath:templates/emails/styles/email.css")

        return resource.inputStream.use { inputStream ->
            inputStream.readBytes().toString(StandardCharsets.UTF_8)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(CustomerEmailService::class.java)
    }
}