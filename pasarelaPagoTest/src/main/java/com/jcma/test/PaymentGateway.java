package com.jcma.test;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);

}
