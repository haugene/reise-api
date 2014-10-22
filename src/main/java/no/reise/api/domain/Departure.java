package no.reise.api.domain;

import no.reise.api.domain.dto.StopVisit;
import org.joda.time.DateTime;

public class Departure
{
    private final String destinationName;
    private final String lineName;
    private final String departsIn;

    public Departure(StopVisit stopVisit)
    {
        this.destinationName = stopVisit.getMonitoredVehicleJourney().getDestinationName();
        this.lineName = stopVisit.getMonitoredVehicleJourney().getPublishedLineName();
        this.departsIn = calculateTimeToDeparture(stopVisit);
    }

    private String calculateTimeToDeparture(StopVisit stopVisit)
    {
        DateTime current = stopVisit.getRecordedAtTime();
        DateTime expectedDeparture = stopVisit.getMonitoredVehicleJourney().getMonitoredCall().getExpectedDepartureTime();

        Long millisToDeparture = expectedDeparture.getMillis() - current.getMillis();
        Long secondsToDeparture = millisToDeparture/1000;
        return secondsToDeparture + " seconds";
    }

    public String getDestinationName()
    {
        return destinationName;
    }

    public String getLineName()
    {
        return lineName;
    }

    public String getDepartsIn()
    {
        return departsIn;
    }
}
