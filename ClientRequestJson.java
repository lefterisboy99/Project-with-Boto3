package hy452.ws.rest;
import java.util.StringTokenizer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
public class ClientRequestJson {
public static void main(String[] args) {
Client client = ClientBuilder.newClient();
WebTarget webTarget = client.target("https://api.openweathermap.org/data/2.5/weather?id=261745&appid=314e83ebf3c3d15b30e3705831f10b53");
Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN_TYPE);
Response response = invocationBuilder.get();
System.out.println(response.getStatus());
String s=response.readEntity(String.class);
System.out.println(s);
s=s.replace("}", " ");
s=s.replace("{", " ");
s=s.replace("[", " ");
s=s.replace("]", " ");
s=s.replace(",", " ");
s=s.replace("\"", " ");
//System.out.println(s);
String name;
String humidity;
String x;
StringTokenizer st = new StringTokenizer(s,":");  
while (st.hasMoreTokens()) {  
    x=st.nextToken();
    //System.out.println(x);
    if(x.indexOf("name")!=-1) {
    	System.out.print("name: ");
    	name=st.nextToken();
    	StringTokenizer st1 = new StringTokenizer(name," ");  
    	System.out.println(st1.nextToken());
    }
    if(x.indexOf("humidity")!=-1) {
    	System.out.print("humidity: ");
    	humidity=st.nextToken();
    	StringTokenizer st1 = new StringTokenizer(humidity," ");  
    	System.out.println(st1.nextToken());
    }
} 



}
}