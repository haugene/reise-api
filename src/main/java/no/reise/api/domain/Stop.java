package no.reise.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stop
{
    @JsonProperty(value = "ID")
    private Long id;

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "District")
    private String district;

    @JsonProperty(value = "PlaceType")
    private String placeType;

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDistrict()
    {
        return district;
    }

    public String getPlaceType()
    {
        return placeType;
    }
}
