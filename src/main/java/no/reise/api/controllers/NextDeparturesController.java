package no.reise.api.controllers;

import no.reise.api.domain.Departure;
import no.reise.api.domain.dto.StopVisit;
import no.reise.api.repository.RuterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departures")
public class NextDeparturesController
{

    @Autowired
    private RuterApi ruterApi;
    
    @RequestMapping("/{stopId}")
    public List<Departure> departures(@PathVariable("stopId") Long id)
    {
        return ruterApi.getNextDepartures(id);
    }
    
}
