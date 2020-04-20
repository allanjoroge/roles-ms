package com.legoons.rolesms.controller;

import com.legoons.rolesms.dto.RoleDTO;
import com.legoons.rolesms.dto.SearchRequest;
import com.legoons.rolesms.service.RoleService;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleGetService) {
        this.roleService = roleGetService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<RoleDTO> findRoles(@Nullable SearchRequest request) {

        return roleService.findRoles(request);
    }
}
