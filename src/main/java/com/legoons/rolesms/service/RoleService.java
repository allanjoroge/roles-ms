package com.legoons.rolesms.service;

import com.legoons.rolesms.dto.RoleDTO;
import com.legoons.rolesms.dto.SearchRequest;
import org.springframework.data.domain.Page;

public interface RoleService {

    Page<RoleDTO> findRoles(SearchRequest request);

}
