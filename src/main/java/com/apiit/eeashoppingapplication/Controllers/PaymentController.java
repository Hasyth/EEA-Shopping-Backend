/*
package com.apiit.eeashoppingapplication.Controllers;

import com.apiit.eeashoppingapplication.Models.Payment;
import com.apiit.eeashoppingapplication.Models.Promotions;
import com.apiit.eeashoppingapplication.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/{payment_id}")
    public Payment getPayment(@PathVariable String payment_id) {
        return paymentRepository.findById(payment_id).get();
    }

    @PostMapping(path = "/new")
    public Payment newPayment(@RequestBody Payment payment) {

        Payment newpayment;

        newpayment = paymentRepository.save(payment);
        System.out.println(newpayment.getPaymentName() + "done payment");

        return newpayment;
    }



        @PutMapping
    public Payment updatePromotions(@RequestBody Payment payment) {

        paymentRepository.save(payment);

        return payment;
    }

    @DeleteMapping(path = "/{payment_id}")
    public boolean deletePayment(@PathVariable String payment_id) {
        boolean flag;
        Payment payment = getPayment(payment_id);
        if (payment != null) {
            paymentRepository.deleteById(payment_id);
            flag = true;
        } else {
            flag = false;

        }
        return flag;
    }

}
*/
