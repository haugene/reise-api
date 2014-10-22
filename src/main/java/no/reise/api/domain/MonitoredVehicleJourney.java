package no.reise.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonitoredVehicleJourney
{
    @JsonProperty(value = "PublishedLineName")
    private String publishedLineName;

    @JsonProperty(value = "DestinationName")
    private String destinationName;

    @JsonProperty(value = "MonitoredCall")
    private MonitoredCall monitoredCall;

    public String getPublishedLineName()
    {
        return publishedLineName;
    }

    public String getDestinationName()
    {
        return destinationName;
    }

    public MonitoredCall getMonitoredCall()
    {
        return monitoredCall;
    }
}
