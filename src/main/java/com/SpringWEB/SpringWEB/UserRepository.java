package com.SpringWEB.SpringWEB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRecord, Integer> {  
}  