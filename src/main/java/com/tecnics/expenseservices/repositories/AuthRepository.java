package com.tecnics.expenseservices.repositories;

import com.tecnics.expenseservices.models.AuthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */

@Repository
public interface AuthRepository extends JpaRepository<AuthModel, Long> {
  AuthModel findByUsername(String username);
}
