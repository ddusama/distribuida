package com.distribuida.cfg;
import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class HelidonCfg {

    @Produces
    public DbClient getDbClient() {
        Config cfg = Config.create();
        return DbClient.builder(cfg.get("database")).build();
    }

}
