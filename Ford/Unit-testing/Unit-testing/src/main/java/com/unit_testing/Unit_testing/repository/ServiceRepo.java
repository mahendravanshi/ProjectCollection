package com.unit_testing.Unit_testing.repository;

import com.unit_testing.Unit_testing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<User, Integer> {
}
