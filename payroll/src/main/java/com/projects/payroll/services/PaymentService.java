package com.projects.payroll.services;

import com.projects.payroll.entitites.Payment;
import com.projects.payroll.entitites.Worker;
import com.projects.payroll.feignclients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
