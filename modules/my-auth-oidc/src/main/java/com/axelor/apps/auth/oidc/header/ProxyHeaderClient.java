package com.axelor.apps.auth.oidc.header;

import org.pac4j.core.client.IndirectClient;

public class ProxyHeaderClient extends IndirectClient {

    public ProxyHeaderClient() {
//        super();
        setName("proxy-header");
    }

    @Override
    public IndirectClient clone() throws CloneNotSupportedException {
        IndirectClient indirectClient = (IndirectClient) super.clone();
        return indirectClient;
    }

    @Override
    protected void internalInit(boolean forceReinit) {

    }
}
