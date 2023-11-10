package com.example.ior.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MyMapper {
    private final ModelMapper mapper;

    public MyMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public <T, U> U mapper(T source, Class<U> destinationType) {
        return mapper.map(source, destinationType);
    }
}
