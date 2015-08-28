package com.ebuilder.labmi;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class labmiConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String credentialGroup;

    @NotEmpty
    private String regionCode;

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public String getRegionCode() {
        return regionCode;
    }

    @JsonProperty
    public String getCredentialGroup() {
        return credentialGroup;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

}
