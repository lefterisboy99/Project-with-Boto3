package hy452.ws.restspringboot;

import org.springframework.boot.SpringApplication;
import java.util.HashMap;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "example-API", version = "1.0", description = "convertions about coins"))
@RestController
public class currencyconvertion {
    public static void main(String[] args) {
        SpringApplication.run(currencyconvertion.class, args);
    }
    @Operation(summary = "currency convertor")
    @GetMapping("/currencyconvert")
    public result hello(@RequestParam(value="from") String from, 
    		@RequestParam(value="to") String to,
    		@RequestParam(value="amount") double amount) {
    	
    	//EUR,GBP,USD,EGP,PKR
    	
    	HashMap<String, Double> currency = new HashMap<String, Double>();
    	currency.put("EUR", 1.00);
    	currency.put("GBP", 0.87);
    	currency.put("USD", 1.03);
    	currency.put("EGP", 25.30);
    	currency.put("PKR", 229.60);
    	result a=new result();
    	
    	if(currency.containsKey(from)&&currency.containsKey(to)) {
    		double xiasti=(currency.get(to)*amount)/currency.get(from) ;
    		a.from=from;
    		a.to=to;
    		a.amount=amount;
    		a.results=xiasti;
    		return a;
    	}else {
    		
    		return new result();
    	}
    	

    }
    @Operation(summary = "currency rate")
    @GetMapping("/currencyrates")
    public rates hello1(@RequestParam(value="from") String from, 
    		@RequestParam(value="to") String to) {
    	
    	//EUR,GBP,USD,EGP,PKR
    	
    	HashMap<String, Double> currency = new HashMap<String, Double>();
    	currency.put("EUR", 1.00);
    	currency.put("GBP", 0.87);
    	currency.put("USD", 1.03);
    	currency.put("EGP", 25.30);
    	currency.put("PKR", 229.60);
    	if(currency.containsKey(from)&&currency.containsKey(to)) {
    		double xiasti=(currency.get(to)*1)/currency.get(from) ;
    		rates a=new rates();
    		a.from=from;
    		a.to=to;
    		a.amount=xiasti;
    		return a;
    		
    	}else {
    		return new rates();
    	}
    	
    	
    	

    }
}