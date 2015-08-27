package com.ebuilder.labmi.resources;
import com.ebuilder.labmi.db.AnimalDAO;
import com.ebuilder.labmi.model.Animal;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/animal")
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {
    private final AnimalDAO animalDAO;

    public AnimalResource(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    @GET
    @Timed
    public Animal getAnimal(@QueryParam("name") String name) {
        Animal animal = animalDAO.getByName(name);
        return animal;
    }
}
