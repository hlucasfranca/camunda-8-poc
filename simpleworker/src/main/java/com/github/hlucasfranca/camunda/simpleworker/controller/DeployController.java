package com.github.hlucasfranca.camunda.simpleworker.controller;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.DeploymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeployController {
    @Autowired
    private ZeebeClient client;

    @PostMapping("/deploy")
    public String deploy(@RequestParam String bpmnName){

        final DeploymentEvent deploymentEvent =
                client.newDeployResourceCommand()
                        .addResourceFromClasspath(bpmnName)
                        .send()
                        .join();

        return bpmnName + " deployed";
    }
}
