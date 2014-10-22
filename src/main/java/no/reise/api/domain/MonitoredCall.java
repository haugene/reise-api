package no.reise.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class MonitoredCall
{
    @JsonProperty(value = "ExpectedDepartureTime")
    private DateTime expectedDepartureTime;

    public DateTime getExpectedDepartureTime()
    {
        return expectedDepartureTime;
    }

    public void setExpectedDepartureTime(String expectedDepartureTime)
    {
        this.expectedDepartureTime = DateTime.parse(expectedDepartureTime);
    }
}
