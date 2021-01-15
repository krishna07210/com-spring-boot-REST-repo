package com.springboot.jpa.repositories;

import com.springboot.jpa.entities.User;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 
 * @author krish
 *
 *         PagingAndSortingRepository provides additional methods like Paging
 *         and Sorting on top of CrudRepository
 * 
 *         Rest will generate the HATEOAS links for all the data of users
 * 
 *         POSTMAN : services http://localhost:8080/users/1
 *         http://localhost:8080/users/?size=4
 *         http://localhost:8080/users/?sort=name,desc
 *         http://localhost:8080/users/search/findByRole?role=Admin
 * 
 *         JPA-REST are Good for quick prototype! Be cautious about using this in
 *         Big applications!
 */

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {

	List<User> findByRole(@Param("role") String role);

}
