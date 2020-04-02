package com.aws.Awssample.lookup;

import com.aws.Awssample.models.IndiaData;
import com.aws.Awssample.models.StateWise;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class StateWiseLookupServiceImpl implements StateWiseLookupService{
    private final String STATE_WISE_DATA="https://api.covid19india.org/data.json";

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    @Override
    public List<StateWise> get() throws IOException, InterruptedException {
//        HttpClient client=HttpClient.newHttpClient();
//
//        // virus data reported
//        HttpRequest virusDatarequest=HttpRequest.newBuilder()
//                .uri(URI.create(STATE_WISE_DATA))
//                .build();
//        System.out.println("Http Request is "+virusDatarequest.toString());
//        HttpResponse<String> virusDataResponse=client.send(virusDatarequest, HttpResponse.BodyHandlers.ofString());

//        String test= restTemplate.getForObject(
//                STATE_WISE_DATA, String.class);




//        String certificatesTrustStorePath = "/etc/alternatives/jre/lib/security/cacerts";
//        System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
//        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> test=restTemplate.exchange(
                STATE_WISE_DATA,
                HttpMethod.GET,
                entity,
                String.class);

        //String responseBody=virusDataResponse.body();
        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> sampleMap;//=new HashMap<>();
        IndiaData indiaData;
        indiaData=mapper.readValue(test.getBody(), IndiaData.class);
        return indiaData.getStatewise();
    }
}
