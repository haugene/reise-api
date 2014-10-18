package no.reise.api.controllers;

import no.reise.api.domain.Stop;
import no.reise.api.repository.RuterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/stops")
public class StopsController
{

    @Autowired
    private RuterApi ruterApi;
    
    @RequestMapping("/nearme")
    public List<Stop> stopsNearMe(@QueryParam(value = "lat") Double lat, @QueryParam(value = "lon") Double lon)
    {
        return ruterApi.getClosestStops(lat, lon);
    }
    
}
