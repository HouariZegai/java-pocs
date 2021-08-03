package com.houarizegai.spirngfxcrud.repository;

import com.houarizegai.spirngfxcrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
