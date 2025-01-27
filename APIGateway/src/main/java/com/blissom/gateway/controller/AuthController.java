package com.blissom.gateway.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.blissom.gateway.model.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final String GITHUB_API_EMAILS_URL = "https://api.github.com/user/emails";
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    private final WebClient webClient;

    public AuthController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("github") OAuth2AuthorizedClient githubClient,
            @AuthenticationPrincipal OAuth2User user
    ) {
    	logger.info("Received login request");
        // Log user attributes for debugging
        Map<String, Object> userAttributes = user.getAttributes();
        logger.info("GitHub User Attributes: {}", userAttributes);

        String username = (String) userAttributes.get("login");
        String userId = String.valueOf(userAttributes.get("id"));

        // Log resolved information
        logger.info("Resolved Username: {}", username);
        logger.info("Resolved User ID: {}", userId);

        // Create AuthResponse object
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUserId(userId);
        authResponse.setUsername(username);
        authResponse.setAccessToken(githubClient.getAccessToken().getTokenValue());
        authResponse.setExpireAt(githubClient.getAccessToken().getExpiresAt().getEpochSecond());
        List<String> authorities = user.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.toList());
        authResponse.setAuthorities(authorities);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}

