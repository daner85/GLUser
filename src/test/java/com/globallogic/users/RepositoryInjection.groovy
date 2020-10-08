package com.globallogic.users

import javax.validation.constraints.NotNull

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

import com.fasterxml.jackson.annotation.JsonProperty
import com.globallogic.users.domain.Phones
import com.globallogic.users.domain.User
import com.globallogic.users.domain.UserResponse
import com.globallogic.users.domain.repository.UserRepository
import com.globallogic.users.domain.service.DomainUserService
import com.globallogic.users.domain.service.UserService
import com.globallogic.users.infraestructure.HibernateUserRepository

import spock.lang.Shared
import spock.lang.Specification
import spock.mock.DetachedMockFactory

@SpringBootTest
class RepositoryInjection extends Specification {

	@Autowired
	private UserRepository userRepository;

	void 'UserRepository injection'() {
		given: 'a Repository injection'
//		
		
		when: ''
		
		then: 'Service injection ok'
		userRepository != null
	}
	
}