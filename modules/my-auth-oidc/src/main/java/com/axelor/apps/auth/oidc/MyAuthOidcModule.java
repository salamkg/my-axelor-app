package com.axelor.apps.auth.oidc;

import com.axelor.app.AxelorModule;
import com.axelor.auth.pac4j.AuthPac4jUserService;
import org.pac4j.oidc.client.OidcClient;

public class MyAuthOidcModule extends AxelorModule {
    @Override
    protected void configure() {
        bind(OidcClient.class)
                .toProvider(KeycloakOidcClientProvider.class)
                .asEagerSingleton();

        bind(KeycloakLoginController.class);
    }
}
