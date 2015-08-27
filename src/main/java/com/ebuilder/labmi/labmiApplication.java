package com.ebuilder.labmi;

import com.ebuilder.labmi.resources.AnimalResource;
import com.ebuilder.labmi.health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class labmiApplication extends Application<labmiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new labmiApplication().run(args);
    }

    @Override
    public String getName() {
        return "labmi";
    }

    @Override
    public void initialize(final Bootstrap<labmiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final labmiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        final AnimalResource resource = new AnimalResource(configuration.getTemplate(),configuration.getDefaultName());
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
