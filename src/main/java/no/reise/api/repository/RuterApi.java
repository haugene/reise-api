package no.reise.api.repository;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import no.reise.api.domain.Stop;
import no.reise.api.geolocation.ConverterService;
import no.reise.api.geolocation.GeographicPoint;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Repository
public class RuterApi
{
    private static final String ruter_api_url = "http://reisapi.ruter.no";
    private static final String heartbeat_path = "heartbeat/index";
    private static final String closest_stops_path = "place/getcloseststops";

    @Autowired
    private ConverterService converterService;

    private Client client;
    public RuterApi()
    {
        JacksonJsonProvider jacksonJsonProvider =
                new JacksonJaxbJsonProvider()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        client = ClientBuilder.newClient(new ClientConfig());
        client.register(jacksonJsonProvider);
    }

    public String heartBeat()
    {
        return client.target(ruter_api_url)
                .path(heartbeat_path)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(String.class);
    }


    public List<Stop> getClosestStops(Double lat, Double lon)
    {
        GeographicPoint point = converterService.LatLonToUTMXY(lat, lon, 32);
        String xCoord = Long.toString(Math.round(point.getLatitude()));
        String yCoord = Long.toString(Math.round(point.getLongitude()));

        return client.target(ruter_api_url)
                .path(closest_stops_path)
                .queryParam("coordinates", "X=" + xCoord + ",Y=" + yCoord)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Stop>>() {});
    }
}
