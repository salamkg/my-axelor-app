package com.axelor.apps.auth.oidc;

import com.axelor.auth.pac4j.ClientListService;
import com.axelor.auth.pac4j.local.AxelorFormClient;
import com.axelor.inject.Beans;
import org.pac4j.oidc.client.OidcClient;

public class MyClientListService extends ClientListService {
    public MyClientListService() {
        logger.info(">>> MyClientListService <<<");
        init();
    }

    @Override
    public String getDefaultClientName() {
        return "AxelorFormClient";
    }

    @Override
    protected void init() {
        super.init();

        clients.add(new AxelorFormClient());
        OidcClient keycloak = Beans.get(OidcClient.class);
        logger.info(
              "OIDC client before register: name={}, config={}, initialized={}",
              keycloak.getName(),
              keycloak.getConfiguration(),
              keycloak.isInitialized()
        );
        clients.add(keycloak);

        logger.info("Added OIDC Keycloak client: {}", keycloak.getName());
    }
}
