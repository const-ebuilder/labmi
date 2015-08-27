package com.ebuilder.labmi.resources;
import com.ebuilder.labmi.db.AnimalDAO;
import com.ebuilder.labmi.model.Animal;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.google.common.base.Optional;

@Path("/animal")
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {
    private final String template;
    private final String defaultName;

   /* public AnimalResource(String template, String defaultName, AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }*/

    public AnimalResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Timed
    public Animal getAnimal(@QueryParam("name") String name) {
        return new Animal("test", name, "yellow", "4");
    }
}
