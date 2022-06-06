package com.example.proyectingesoftback.repository;

import com.example.proyectingesoftback.model.Cuestionario;
import com.example.proyectingesoftback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
