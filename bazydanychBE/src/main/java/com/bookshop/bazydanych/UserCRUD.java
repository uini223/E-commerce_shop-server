package com.bookshop.bazydanych;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCRUD extends CrudRepository<User, Long> {
    User getById(long Id);
}
