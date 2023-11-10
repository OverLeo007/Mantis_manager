package ru.paskal.MantisManager.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {
  ModelMapper modelMapper;

  @Autowired
  public Converter(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public <D> D convert(Object source, Class<D> destinationType) {
    return modelMapper.map(source, destinationType);
  }

}
