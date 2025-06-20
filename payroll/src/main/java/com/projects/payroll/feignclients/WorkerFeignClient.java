package com.projects.payroll.feignclients;

import com.projects.payroll.config.FeignTokenInterceptorConfig;
import com.projects.payroll.entitites.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "worker", path = "/workers", configuration = FeignTokenInterceptorConfig.class)
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
