package com.ebuilder.labmi.resources;
import com.ebuilder.labmi.db.AnimalDAO;
import com.ebuilder.labmi.model.Animal;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.common.base.Optional;
import com.wordnik.swagger.annotations.ApiParam;

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
        return new Animal("test", name, "yellow", "4");
    }

    @POST
    @Timed
    public Animal addAnimal(@ApiParam(value = "Animal to save", required = true) @Valid Animal animal) {
        Animal animalSaved = animalDAO.save(animal);
        return animalSaved;
    }
}
