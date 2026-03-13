package com.axelor.apps.auth.oidc;

import com.axelor.app.AppSettings;
import com.google.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.pac4j.core.config.Config;
import org.pac4j.jee.context.JEEContext;
import org.pac4j.jee.http.adapter.JEEHttpActionAdapter;
import org.pac4j.oidc.client.OidcClient;

@Path("/test/keycloak")
public class KeycloakLoginController {

    @Inject Config pac4jConfig;

    @GET
    @Path("/login")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void login(@Context HttpServletRequest req, @Context HttpServletResponse res) {

        JEEContext ctx = new JEEContext(req, res);

        OidcClient client = (OidcClient) pac4jConfig.getClients().findClient("keycloak").orElseThrow();

        client
            .getRedirectionAction(ctx, pac4jConfig.getSessionStore())
            .ifPresent(a -> JEEHttpActionAdapter.INSTANCE.adapt(a, ctx));
    }
}
