package com.dao;

import com.dao.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by ganluting on 17/1/9.
 */
@RepositoryRestResource(path="user")
public interface UserRepository extends CustomReposittory<Users,Long> {

    List<Users> findFirst10ByNameLike(String name);

    @Query(nativeQuery = true,value = "select id,name from t_users where name=:name")
    List<Users> abc(@Param("name") String name);
}
