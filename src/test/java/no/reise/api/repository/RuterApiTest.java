package no.reise.api.repository;

import no.reise.api.application.Application;
import no.reise.api.domain.Departure;
import no.reise.api.domain.Stop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RuterApiTest
{
    @Autowired
    private RuterApi ruterApi;

    @Test
    public void pongResponseFromRuter()
    {
        // When
        String response = ruterApi.heartBeat();

        // Then
        assertTrue(response.contains("Pong"));
    }

    @Test
    public void listNearbyPlaces()
    {
        // When requesting stops near the National Theatre
        List<Stop> nearbyStops = ruterApi.getClosestStops(59.9138862, 10.7344438);

        // Then - Klingenberg should be one of the results
        assertTrue(!nearbyStops.isEmpty());
        Stop klingenberg = getStopById(nearbyStops, 3010040);
        assertEquals("Klingenberg", klingenberg.getName());
        assertEquals("Oslo", klingenberg.getDistrict());
        assertEquals("Stop", klingenberg.getPlaceType());
    }

    @Test
    public void nextDeparturesFromStop()
    {
        // When requesting upcoming departures for a given stop
        List<Departure> nextDepartures = ruterApi.getNextDepartures(3010040L);

        // We should receive a list of StopVisits
        assertTrue(!nextDepartures.isEmpty());
    }

    private Stop getStopById(List<Stop> list, long id) {
        for (Stop stop : list) {
            if (stop.getId() == id) {
                return stop;
            }
        }
        throw new IllegalStateException("Expected stop was not returned by ruter web api");
    }
}
