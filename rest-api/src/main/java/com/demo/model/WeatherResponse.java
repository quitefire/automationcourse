
package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private Coord coord;
    private List<Weather> weather = new ArrayList<>();
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Integer dt;
    private Sys sys;
    private Integer id;
    private String name;
    private Integer cod;
}
