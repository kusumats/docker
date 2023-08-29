package com.example.docker.demo.Resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
@RequestMapping(path = "v1/")
@Validated

public class demoDeocker {

    @Operation(description = "Health Check", tags = {"Health Check"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            },
            extensions = {
                    @Extension(name = "x-amazon-apigateway-integration", properties = {
                            @ExtensionProperty(name = "type", value = "http"),
                            @ExtensionProperty(name = "httpMethod", value = "GET"),
                            @ExtensionProperty(name = "uri", value = "/v1/commons/health"),
                            @ExtensionProperty(name = "passthroughBehavior", value = "when_no_match")
                    })
            })

    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public String health() {
        return "new health1 ";
    }

}
