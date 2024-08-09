package com.tidz.registrationTuto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.tidz.registrationTuto.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("test@mail.com");
		user.setPassword("password");
		user.setFirstName("Mano");
		user.setLastName("Dahora");

		User savedUser = this.repo.save(user);

		User existUser = this.entityManager.find(User.class, savedUser.getId());

		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	}
}
