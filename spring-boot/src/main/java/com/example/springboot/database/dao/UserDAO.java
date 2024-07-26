package com.example.springboot.database.dao;

import com.example.springboot.database.entity.*;
import org.springframework.data.jpa.repository.*;

public interface UserDAO extends JpaRepository<User, Long> {




}
