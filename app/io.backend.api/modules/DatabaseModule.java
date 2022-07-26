package io.backend.api.modules;

import com.google.inject.AbstractModule;
import com.typesafe.config.Config;

import io.backend.api.mongo.IMongoDB;

import io.backend.api.mongo.InMemoryMongoDB;
import io.backend.api.mongo.MongoDB;
import play.Environment;
import play.Logger;

public class DatabaseModule extends AbstractModule {
    private final Environment environment;
    private final Config config;
  
    public DatabaseModule (Environment environment, Config config) {
      this.environment = environment;
      this.config = config;
    }  

    @Override
    protected void configure() {
		String mode = config.getString("mode");
		Logger.of(this.getClass()).debug("Runnning on mode {}", mode);
        System.out.println("    mode         " + mode);
		if (mode.equalsIgnoreCase("test")) {
            bind(IMongoDB.class).to(InMemoryMongoDB.class).asEagerSingleton();
            return;
		}
        bind(IMongoDB.class).to(MongoDB.class).asEagerSingleton();
    }
}