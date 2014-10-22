package no.reise.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class StopVisit
{
    @JsonProperty(value = "RecordedAtTime")
    private DateTime recordedAtTime;

    @JsonProperty(value = "MonitoredVehicleJourney")
    private MonitoredVehicleJourney monitoredVehicleJourney;

    public DateTime getRecordedAtTime()
    {
        return recordedAtTime;
    }

    public void setRecordedAtTime(String recordedAtTime)
    {
        this.recordedAtTime = DateTime.parse(recordedAtTime);
    }

    public MonitoredVehicleJourney getMonitoredVehicleJourney()
    {
        return monitoredVehicleJourney;
    }
}
