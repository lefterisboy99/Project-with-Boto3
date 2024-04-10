package hy452.ws.rest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
public class ClientRequest {
public static void main(String[] args) {
Client client = ClientBuilder.newClient();
WebTarget webTarget = client.target("https://api.openweathermap.org/data/2.5/weather?id=261745&appid=314e83ebf3c3d15b30e3705831f10b53&mode=xml");
Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN_TYPE);
Response response = invocationBuilder.get();
System.out.println(response.getStatus());
System.out.println(response.readEntity(String.class));
}
}