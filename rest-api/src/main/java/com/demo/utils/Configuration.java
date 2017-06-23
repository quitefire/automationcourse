package com.demo.utils;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("application.properties")
public interface Configuration {

    @Property("rest.endpoint")
    String getRestEndpoint();

    @Property("api.key")
    String getApiKey();

}