package com.axelor.apps.auth.oidc;

import com.google.inject.Provider;
import com.nimbusds.oauth2.sdk.auth.ClientAuthenticationMethod;
import org.pac4j.oidc.client.OidcClient;
import org.pac4j.oidc.config.OidcConfiguration;

public class KeycloakOidcClientProvider implements Provider<OidcClient> {

    @Override
    public OidcClient get() {
        OidcConfiguration config = new OidcConfiguration();

        config.setClientId("axelor-erp");
        config.setSecret("b7NcPxRZYH4eVjpJG61j72j1vxYOaUfB");
        config.setDiscoveryURI(
            "http://10.12.94.13:8080/realms/gts/.well-known/openid-configuration");

        config.setScope("openid profile email");
        config.setUseNonce(true);
        config.setResponseType("code");
        config.setClientAuthenticationMethod(
                ClientAuthenticationMethod.CLIENT_SECRET_BASIC
        );

        OidcClient client = new OidcClient(config);
        client.setName("keycloak");
        client.setCallbackUrl("http://localhost:8082/axelor-erp/callback");
        return client;
    }
}
