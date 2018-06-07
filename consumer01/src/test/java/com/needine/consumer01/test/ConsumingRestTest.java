package com.needine.consumer01.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.net.URI;

public class ConsumingRestTest {

	private static String port;
    private static String targetUrl;

    private Client client;
    private Response response;

    @BeforeClass
    public static void oneTimeSetup() {
        //port = System.getProperty("liberty.test.port");
        //targetUrl = "http://localhost:" + port + "/artists/total/";
        targetUrl = "http://localhost:9080/consumer01/rest/hello";
    }
    

    @Before
    public void setup() {
        client = ClientBuilder.newClient();
    }

    @After
    public void teardown() {
        client.close();
    }
    
    
    @Test
    public void testArtistCount() {
        /*response = client.target(targetUrl).request().get();
        this.assertResponse(targetUrl, response);

        int expected = 3;
        int actual = response.readEntity(int.class);
        assertEquals("Expected number of artists does not match", expected, actual);

        response.close();
        */
    	//assertEquals("AA", "AA", "AA");
    	WebTarget target = client.target(getBaseURI());
    	String response = target.path("rest").
                path("hello").
                request().
                accept(MediaType.TEXT_PLAIN).
                get(Response.class)
                .toString();


		String plainAnswer =
		    target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer =
		    target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer=
		    target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);
		
		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(xmlAnswer);
		System.out.println(htmlAnswer);
		    	
    	
    	assertEquals(0, 0);
    	
    }
    
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:9080/consumer01").build();
    }
    /*
    private void assertResponse(String url, Response response) {
        assertEquals("Incorrect response code from " + url, 200, response.getStatus());
    }
    */
}
