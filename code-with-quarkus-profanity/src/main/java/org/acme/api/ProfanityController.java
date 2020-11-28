package org.acme.api;

import org.acme.models.CommentRequest;
import org.acme.models.WordResponse;
import org.acme.services.ProfanityService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/profanity")
public class ProfanityController {

    @Inject
    ProfanityService profanityService;

    @GET
    @Path("/isProfanity/{word}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response isProfanity(@PathParam("word") String word) {

        if (word == null) {
            return Response.serverError().entity("commentRequest cannot be null").build();
        }
        boolean isProfanity = profanityService.isProfanityWord(word);
        return  Response.ok(new WordResponse(word, isProfanity)).build();
    }

    @POST
    @Path("/analyseComment")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response analyseComment(CommentRequest commentRequest) {
        if (commentRequest == null) {
            return Response.serverError().entity("commentRequest cannot be null").build();
        }

        var res = profanityService.analyse(commentRequest.getComment().toLowerCase());
        return Response.ok(res).build();

    }
}
