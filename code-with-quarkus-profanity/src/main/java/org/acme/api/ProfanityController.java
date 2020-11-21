package org.acme.api;

import org.acme.models.Response;
import org.acme.services.ProfanityService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api/profanity")
public class ProfanityController {

    @Inject
    ProfanityService profanityService;

    @GET
    @Path("/isProfanity/{word}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response isProfanity(@PathParam("word") String word) {
        boolean isProfanity = profanityService.isProfanity(word);
        return new Response(word, isProfanity);
    }
}
