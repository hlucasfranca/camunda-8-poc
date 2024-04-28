package com.github.hlucasfranca.camunda.simpleworker.controller;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StartController {
    @Autowired
    private ZeebeClient client;

    @PostMapping("/start")
    public String deploy(@RequestParam String id){

        Map<String, Object> variables = Map.of("testVariable", "testValue");
        final ProcessInstanceEvent processInstanceEvent =
                client
                        .newCreateInstanceCommand()
                        .bpmnProcessId(id)
                        .latestVersion()
                        .variables(variables)
                        .send()
                        .join();

        return " started";
    }
}
