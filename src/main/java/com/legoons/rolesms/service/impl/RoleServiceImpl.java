package com.legoons.rolesms.service.impl;

import com.legoons.rolesms.dto.RoleDTO;
import com.legoons.rolesms.dto.SearchRequest;
import com.legoons.rolesms.entity.Role;
import com.legoons.rolesms.mapper.Mapper;
import com.legoons.rolesms.repository.RoleRepository;
import com.legoons.rolesms.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private Mapper mapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, Mapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<RoleDTO> findRoles(SearchRequest searchRequest) {

        Sort sortOrder = createSortOrder(searchRequest);
        PageRequest paging = PageRequest.of(searchRequest.getPageNo(), searchRequest.getPageSize(), sortOrder);
        Page<Role> pageRoles;

        if (searchRequest.getProjectId() == null) {
            pageRoles = roleRepository.findAll(paging);
        } else {
            pageRoles = roleRepository.findByProjectId(searchRequest.getProjectId(), paging);
        }

        List<RoleDTO> rDTOs = new ArrayList<>();

        for (Role r : pageRoles) {
            rDTOs.add(mapper.transform(r));
        }
        return new PageImpl<>(rDTOs, paging, pageRoles.getTotalElements());
    }

    protected Sort createSortOrder(SearchRequest searchRequest) {

        List<Sort.Order> orderList = new ArrayList<>();

        if ((searchRequest == null) || (searchRequest.getSortColumn() == null)) {
            //return default sort column
            orderList.add(createSortOrder(null, null));
        } else {

            for (int i = 0; i < searchRequest.getSortColumn().length; i++) {
                String col = searchRequest.getSortColumn()[i];
                String dir = searchRequest.getSortDirection()[i];
                orderList.add(createSortOrder(col, dir));
            }
        }
        log.debug("sort by list is {}", orderList.toString());

        return Sort.by(orderList);
    }

    private Sort.Order createSortOrder(String column, String direction) {

        log.debug("BEFORE column is {} and direction is {}", column, direction);

        if (StringUtils.isEmpty(column)) {
            column = "startDate";
        }
        if (StringUtils.isEmpty(direction)) {
            direction = "ASC";
        }

        log.debug("AFTER column is {} and direction is {}", column, direction);

        if ("DESC".equalsIgnoreCase(direction)) {
            return Sort.Order.desc(column);
        }
        return Sort.Order.asc(column);
    }
}
