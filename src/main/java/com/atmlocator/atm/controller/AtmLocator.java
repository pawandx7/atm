package com.atmlocator.atm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import com.atmlocator.atm.domain.AtmLocationDetails;


@RestController
public class AtmLocator {
	
	
	private  WebClient webClient ;
	
	AtmLocator(){
		webClient = WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
	            .codecs(configurer -> configurer
	                      .defaultCodecs()
	                      .maxInMemorySize(16 * 1024 * 1024))
	                    .build())
	                  .build();
	}
	
	@GetMapping(path = {"/getAtms"},produces = "application/json")
	public List<AtmLocationDetails> getAtms() {
		
		ParameterizedTypeReference<List<AtmLocationDetails>> typeRef = new ParameterizedTypeReference<List<AtmLocationDetails>>() {
			
		};
		List<AtmLocationDetails> atmList = webClient.get().uri("http://localhost:8080/getAtmString").
				accept(org.springframework.http.MediaType.APPLICATION_JSON).retrieve().bodyToMono(typeRef).block();
		
		return atmList;
		
	}
	@GetMapping(path = "/getAtmString",produces = "application/json")
	public String getAtmDetailsAsString() {
		
		String atmDetails = null;
		
		atmDetails = webClient.get().uri("https://www.ing.nl/api/locator/atms/").
				accept(org.springframework.http.MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
		String[] str2  = atmDetails.split(",", 2);
		
		
		return str2[1];
		
	}
	
	@GetMapping(path = "/getAtmsByCity",produces = "application/json")
	
	public List<AtmLocationDetails> getAtmByCity(@RequestParam String city) {
		
		ParameterizedTypeReference<List<AtmLocationDetails>> typeRef = new ParameterizedTypeReference<List<AtmLocationDetails>>() {
			
		};
		List<AtmLocationDetails> atmDetails = webClient.get().uri("http://localhost:8080/getAtmString").
				accept(org.springframework.http.MediaType.APPLICATION_JSON).retrieve().bodyToMono(typeRef).block();
		
		Map<String,List<AtmLocationDetails>> mapByCity = new HashMap<String,List<AtmLocationDetails>>();
		mapByCity = atmDetails.stream().collect(Collectors.groupingBy(AtmLocationDetails::getCountryCD));

		return mapByCity.get(city);
		
	}
	

}
