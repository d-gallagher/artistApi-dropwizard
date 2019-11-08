package ie.gmit.ds;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
public class ArtistApiResource {

    private HashMap<Integer, Artist> artistsMap = new HashMap<>();

    public ArtistApiResource() {
        Artist testArtist = new Artist(1, "The GZA", "HipHop", 2);
        Artist testArtist1 = new Artist(2, "The GZA", "HipHop", 2);
        Artist testArtist2 = new Artist(3, "The GZA", "HipHop", 2);
        artistsMap.put(testArtist.getArtistId(), testArtist);
        artistsMap.put(testArtist1.getArtistId(), testArtist1);
        artistsMap.put(testArtist2.getArtistId(), testArtist2);
    }

    @GET
    public Collection<Artist> getArtists() {
        // artistsMap.values() returns Collection<Artist>
        // Collection is the interface implemented by Java collections like ArrayList, LinkedList etc.
        // it's basically a generic list.
        // https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html

        return artistsMap.values();
    }

    @GET
    @Path("{artistId}")
    public Artist getArtistsById(@PathParam("artistId") int artistId){

        return artistsMap.get(artistId);
    }

    // @POST
    // public void postArtist(){

    // }
}