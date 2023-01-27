package com.acn.learnspringdatarest.learndatarest.projection;

import org.springframework.data.rest.core.config.Projection;

import com.acn.learnspringdatarest.learndatarest.entity.UserEntity;

// NOTE: for expose this data call urio of @RepositoryRestResource class and then concatenate this:
//
// -->  ?projection=<projection-name>
// 
// In this case:
//
// --> <value-uri-repository-rest-resource>?projection=userEmailView

@Projection(name= "userEmailView", types = UserEntity.class)
public interface UserEmailView {
	// In this interface expose only signature of property i want show in the client-response
	// In this case i want to show only id and email property of UserEntity class
	
	String getId();
	String getEmail();
}