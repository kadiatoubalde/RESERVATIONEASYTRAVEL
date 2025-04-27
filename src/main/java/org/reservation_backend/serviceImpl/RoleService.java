package org.reservation_backend.serviceImpl;

import org.reservation_backend.dto.RoleDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Role;
import org.reservation_backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;


    public RoleDto create(RoleDto roleDto) {
        Role roleEntity = Mapper.toRole(roleDto);
        roleEntity.setCode("ROLE_"+roleEntity.getCode());
        Role roleSaved= repository.save(roleEntity);
        return Mapper.toRoleDto(roleSaved);
    }

    public List<RoleDto> all(){

        List<Role> roles = repository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        roles.forEach(role -> roleDtos.add(Mapper.toRoleDto(role)));
        return roleDtos;
    }
}
