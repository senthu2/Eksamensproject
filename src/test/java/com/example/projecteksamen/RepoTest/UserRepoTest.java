package com.example.projecteksamen.RepoTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.projecteksamen.models.User;
import com.example.projecteksamen.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) //<-- Så kan man bruge den rigtige DB
@Rollback(false)
public class UserRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    // test methods go below
   /* @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("senthu@live.dk");
        user.setPassword("senthu2020");
        user.setFirstName("senthu");
        user.setLastName("annarajah");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
    @Test
    public void testFindUserByEmail(){
        String email = "senthu@live.dk";

        User user = userRepository.findByEmail(email);

        assertThat(user).isNotNull();
    }*/
}