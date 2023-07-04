package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> roleList() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Role> getRoleById(long id) {
        return roleRepository.findById(id);
    }
}
