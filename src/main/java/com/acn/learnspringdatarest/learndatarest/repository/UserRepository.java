package com.acn.learnspringdatarest.learndatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.acn.learnspringdatarest.learndatarest.entity.UserEntity;

// ATTENTION:
// IF NOT SPECIFY ANY PATH ATTRIBUTE with @RepositoryRestResource OR
// NOT SPECIFY ANY ANNOTATION @RepositoryRestResource,
// 
// THEN the name of default path of resource will be:
//  ---> the name of class Entity with first letter lowercase and plural.
// Example in this case without @RepositoryRestResource(path = "/users") the path will be:
// 	---> userEntities

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	// Path for trigger this Resource is:
	//   --> http://localhost:<port>/<base_uri>/users
	// 			and then concatenated this: /search/findByFirstname?fname=<vaòue>
	//
	//  So the complete path is:
	//   --> http://localhost:<port>/<base_uri>/users/search/findByFirstname?fname=<value>
	@Query(value = "SELECT u FROM UserEntity u WHERE u.firstname = :fname")
	List<UserEntity> findByFirstname(@Param(value = "fname") String firstname);

	// Path for trigger this Resource is:
	//   --> http://localhost:<port>/<base_uri>/users
	// 			and then concatenated this: /search/findByLastname?lname=<value>
	//
	//  So the complete path is:
	//   --> http://localhost:<port>/<base_uri>/users/findByFirstname?lname=<value>
	@Query(value = "SELECT u FROM UserEntity u WHERE u.lastname = :lname")
	List<UserEntity> findByLastname(@Param(value = "lname") String lastname);
	

	// Path for trigger this Resource is:
	//   --> http://localhost:<port>/<base_uri>/users
	// 			and then concatenated this: /search/findByEmail?email=<value>
	//
	//  So the complete path is:
	//   --> http://localhost:<port>/<base_uri>/users/findByEmail?email=<value>
	@Query(value = "SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity findByEmail(@Param(value = "email") String email);

	// Path for trigger this Resource is:
	//   --> http://localhost:<port>/<base_uri>/users
	// 			and then concatenated this: /search/findByFirstnameAndLastname?fname=<value>&lname=<value>
	//
	//  So the complete path is:
	//   --> http://localhost:<port>/<base_uri>/users/search/findByFirstnameAndLastname?fname=<value>&lname=<value>
	@Query(value = "SELECT u FROM UserEntity u WHERE u.firstname = :fname AND u.lastname = :lname")
	UserEntity findByFirstnameAndLastname(
		@Param(value = "fname") String firstname,
		@Param(value = "lname") String lastname
	);
}