package hy452.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("inch_to_cm") //set your service url path to <base_url>/hello
// the <base_url> is based on your application name, the servlet
// and the URL pattern from the web.xml configuration file
public class inch_to_cm {
// This method is called if TEXT_PLAIN is requested
@GET
@Produces(MediaType.TEXT_PLAIN) //defines which MIME type is delivered by a method annotated with @GET
public String sayHelloInPlainText() {
return "Hello world!\n";
}
// This method is called if HTML is requested
@GET
@Produces(MediaType.TEXT_HTML)
public String sayHelloNameInPlainText(@QueryParam("x") int x) {
return "cm: " + x/0.393700787 + "!\n";
}


}