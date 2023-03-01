package com.example.demoServer1.config;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.Duration;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "auth")
public class AuthProps {

    @Valid
    private Mfa mfa;

    @Valid
    @NotNull
    private Jwt jwt;

    @NotEmpty
    private Map<String, Client> clients;

    @NotNull
    private Duration emailTokenValidity  = Duration.ofHours(1);

    public enum MfaType{
        constant, random
    }
    public enum MfaSend{
        mail, sms
    }

    @Getter
    @Setter
    public static class Jwt{

        @NotEmpty
        private String kid;
        @NotNull
        private Resource resource;
        @NotEmpty
        private String keyStorePassword;
        @NotEmpty
        private String keyAlias;
    }

    @Getter
    @Setter
    public static class Mfa{
        private Duration ttl = Duration.ofMinutes(5);
        private MfaType mfaType = MfaType.constant;
        private MfaSend mfaSend = MfaSend.sms;

    }

    @Getter
    @Setter
    public static class Client {

        @NotEmpty
        private String clientSecret;
        @NotEmpty
        private String[] scopes;
        @NotEmpty
        private String[] authorizedGrantTypes;
        @NonNull
        private Duration accessTokenValidity = Duration.ofHours(1);
        @NonNull
        private Duration refreshTokenValidity = Duration.ofDays(30);


    }

}
