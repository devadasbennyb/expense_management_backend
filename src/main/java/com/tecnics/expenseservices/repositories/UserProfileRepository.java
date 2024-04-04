package com.tecnics.expenseservices.repositories;

import com.tecnics.expenseservices.models.UserProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */

@Repository
public interface UserProfileRepository
  extends JpaRepository<UserProfileModel, Long> {
  UserProfileModel findByEmail(String email);
}
