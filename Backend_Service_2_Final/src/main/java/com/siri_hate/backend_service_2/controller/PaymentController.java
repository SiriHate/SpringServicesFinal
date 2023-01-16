package com.siri_hate.backend_service_2.controller;

import com.siri_hate.backend_service_2.model.Payment;
import com.siri_hate.backend_service_2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Optional;
import com.siri_hate.backend_service_2.config.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
public class PaymentController {

    public Tracer tracer = jaegerTracer();

    private final RabbitTemplate template;

    @Bean
    public io.opentracing.Tracer jaegerTracer() {
        JaegerTracer.Builder builder = new JaegerTracer.Builder("Service2");
        return builder.build();
    }

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService, RabbitTemplate template) {
        this.paymentService = paymentService;
        this.template = template;
    }

    @GetMapping("/display_payment")
    public Optional<Payment> getPaymentById(@RequestParam Long id){
        Span span = tracer.buildSpan("GET /display_payment").start();
        Optional<Payment> result = paymentService.getPayment(id);
        span.finish();
        return result;
    }

    @GetMapping("/display_all_payments")
    public List<Payment> getAllPayments(){
        Span span = tracer.buildSpan("GET /display_all_payments").start();
        List<Payment> result = paymentService.getAllPayments();
        span.finish();
        return result;
    }

    @PostMapping("/add_payment")
    public Long addOrder(@RequestBody Payment payment){
        Span span = tracer.buildSpan("POST add_payment").start();
        Long result = paymentService.addPayment(payment);
        span.finish();
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, payment.getId().toString());
        return result;
    }

    @GetMapping("/health_check")
    public String healthCheck(){
        return "healthy";
    }

}