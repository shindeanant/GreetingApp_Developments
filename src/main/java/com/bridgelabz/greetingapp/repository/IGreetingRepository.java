package com.bridgelabz.greetingapp.repository;

import org.springframework.stereotype.Repository;
import com.bridgelabz.greetingapp.model.User;

@Repository
public interface IGreetingRepository extends JpaRepository<User,Long> {
}