package com.example.hotel.mappers;


import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class DozerConfig {

    @Bean
    public Mapper userEntityToDtoMapper(){
        List<String> list = new ArrayList<String>();
        list.add("dozer_user_converter.xml");
        return new DozerBeanMapper(list);
       // return DozerBeanMapperBuilder.create()
      //          .withMappingFiles()
       //         .build();
    }
}
