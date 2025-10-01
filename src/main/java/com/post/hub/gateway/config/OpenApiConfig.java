package com.post.hub.gateway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.core.customizers.SpringDocCustomizers;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.service.AbstractRequestService;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OpenAPIService;
import org.springdoc.core.service.OperationService;
import org.springdoc.webflux.api.MultipleOpenApiWebFluxResource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.List;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "POST_HUB REST API",
                version = "1.0",
                description = "Gateway-service REST API "
        ),
        security = {@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)}
)
public class OpenApiConfig {

    @Bean
    public MultipleOpenApiWebFluxResource multipleOpenApiResource(
            List<GroupedOpenApi> groupedOpenApis,
            ObjectFactory<OpenAPIService> defaultOpenAPIBuilder,
            AbstractRequestService requestBuilder,
            GenericResponseService responseBuilder,
            OperationService operationParser,
            SpringDocConfigProperties springDocConfigProperties,
            SpringDocProviders springDocProviders,
            SpringDocCustomizers springDocCustomizers
    ) {
        return new MultipleOpenApiWebFluxResource(
                groupedOpenApis,
                defaultOpenAPIBuilder,
                requestBuilder,
                responseBuilder,
                operationParser,
                springDocConfigProperties,
                springDocProviders,
                springDocCustomizers
        );
    }
}
