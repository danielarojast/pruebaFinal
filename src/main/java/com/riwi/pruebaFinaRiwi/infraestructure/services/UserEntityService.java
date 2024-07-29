package com.riwi.pruebaFinaRiwi.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.pruebaFinaRiwi.api.dto.requests.UserEntityRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.UserEntityResponse;
import com.riwi.pruebaFinaRiwi.domain.Repositories.UserEntityRepository;
import com.riwi.pruebaFinaRiwi.domain.entities.UserEntity;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IUserEntityService;
import com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserEntityService implements IUserEntityService{
    
    @Autowired
    private final UserEntityRepository repository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserEntityResponse create(UserEntityRequest request) {
        UserEntity userEntity = userMapper.requestToEntity(request);
        return userMapper.entityToResponse(repository.save(userEntity));
    }

    @Override
    public UserEntityResponse update(String id, UserEntityRequest request) {
        UserEntity userEntity = repository.findById(id).orElseThrow();

        UserEntity toUpdate = userMapper.requestToEntity(request);
        toUpdate.setId(userEntity.getId());
        toUpdate.setRedeemeVouchers(userEntity.getRedeemeVouchers());

        return userMapper.entityToResponse(repository.save(toUpdate));
    }

    @Override
    public void delete(String id) {
        UserEntity userEntity = repository.findById(id).orElseThrow();
        repository.delete(userEntity);
    }

    @Override
    public Page<UserEntityResponse> findAll(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest).map(userMapper::entityToResponse);
    }

    @Override
    public UserEntityResponse findById(String id) {
        return userMapper.entityToResponse(repository.findById(id).orElseThrow());
    }
    
}
