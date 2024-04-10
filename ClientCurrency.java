package hy452.ws.restspringboot;

import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientCurrency {
	static String s;
	private static final Logger log = LoggerFactory.getLogger(ClientCurrency.class);

	public static void main(String[] args) {
		SpringApplication.run(ClientCurrency.class, args);
		s=s.replace("{", "");
		s=s.replace("}", "");
		s=s.replace(",", " ");
		s=s.replace(":", " ");
		s=s.replace("\"", "");
		//System.out.println(s);
		StringTokenizer st = new StringTokenizer(s," ");  
		String from="null",to="null",amount="null",result="null";
		while(st.hasMoreTokens()) {
			String x=st.nextToken();
			if(x.equals("from")) {
				from=st.nextToken();
			}
			if(x.equals("to")) {
				to=st.nextToken();
			}
			if(x.equals("amount")) {
				amount=st.nextToken();
			}
			
		}
		System.out.println("the "+amount+" "+from+ " are equal to 1 "+to);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String quote = restTemplate.getForObject(
					"http://ec2-54-227-20-198.compute-1.amazonaws.com:8080/currencyrates?from=GBP&to=EUR", String.class);
			s=quote.toString();
		};
		
	}
}