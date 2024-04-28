package com.github.hlucasfranca.camunda.simpleworker.worker;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Worker {

    Logger logger = LoggerFactory.getLogger(Worker.class);

    @Autowired
    private ZeebeClient client;

    @JobWorker(type = "testing")
    public void handleJobFoo(final ActivatedJob job) {
        String variable = String.valueOf(job.getVariable("testVariable"));
        logger.info("testVariable = " + variable);
    }
}
