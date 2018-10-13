package pl.harpi.commons.demo.address.repository.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class DemoContextResolver implements ContextResolver<ObjectMapper> {
    private final ObjectMapper mapper;

    public DemoContextResolver() {
        mapper = new ObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }
}
