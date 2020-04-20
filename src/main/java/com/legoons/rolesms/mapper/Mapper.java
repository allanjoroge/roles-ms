package com.legoons.rolesms.mapper;

import com.legoons.rolesms.dto.RoleDTO;
import com.legoons.rolesms.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private ModelMapper modelMapper;

    @Autowired
    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO transform(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }

    public Role reverseTransform(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }
}