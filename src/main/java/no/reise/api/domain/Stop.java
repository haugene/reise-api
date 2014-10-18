package no.reise.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kristian on 18.10.14.
 */
public class Stop
{
    private Long id;
    private String name;
    private String district;
    private String placeType;

    @JsonProperty(value = "ID")
    public Long getId()
    {
        return id;
    }

    @JsonProperty(value = "Name")
    public String getName()
    {
        return name;
    }

    @JsonProperty(value = "District")
    public String getDistrict()
    {
        return district;
    }

    @JsonProperty(value = "PlaceType")
    public String getPlaceType()
    {
        return placeType;
    }
}
