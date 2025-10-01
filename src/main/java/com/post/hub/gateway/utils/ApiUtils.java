package com.post.hub.gateway.utils;

import com.post.hub.gateway.model.constants.ApiConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.server.ServerWebExchange;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiUtils {

    public static String getMethodName() {
        try {
            return new Throwable().getStackTrace()[1].getMethodName();
        } catch (Exception cause) {
            return ApiConstants.UNDEFINED;
        }
    }

    public static ServerWebExchange addHeader(ServerWebExchange exchange, String headerName, String value) {
        return exchange.mutate()
                .request(
                        exchange.getRequest()
                                .mutate()
                                .header(headerName, value)
                                .build()
                ).build();
    }

    public static ResponseCookie blockAuthCookie() {

        return ResponseCookie.from(HttpHeaders.AUTHORIZATION, StringUtils.EMPTY).maxAge(0).build();
    }

}
