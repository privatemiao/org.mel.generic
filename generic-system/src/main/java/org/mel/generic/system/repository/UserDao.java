package org.mel.generic.system.repository;

import org.mel.generic.system.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

}
