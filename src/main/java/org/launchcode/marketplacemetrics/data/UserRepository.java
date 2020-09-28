package org.launchcode.marketplacemetrics.data;

import org.launchcode.marketplacemetrics.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}