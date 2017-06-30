package com.demo.utils;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("application.properties")
public interface Configuration {

    @Property("base.uri")
    String getBaseURI();

    @Property("api.key")
    String getApiKey();

}