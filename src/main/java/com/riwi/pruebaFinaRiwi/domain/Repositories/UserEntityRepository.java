package com.riwi.pruebaFinaRiwi.domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.pruebaFinaRiwi.domain.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
    
}
