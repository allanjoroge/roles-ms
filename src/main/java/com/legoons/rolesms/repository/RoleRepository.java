package com.legoons.rolesms.repository;


import com.legoons.rolesms.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, String>{

    Page<Role> findByProjectId(Long projectId, PageRequest paging);
}
