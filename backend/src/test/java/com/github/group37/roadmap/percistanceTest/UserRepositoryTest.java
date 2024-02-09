package com.github.group37.roadmap.percistanceTest;

import com.github.group37.roadmap.percistance.models.User;
import com.github.group37.roadmap.percistance.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)

@DataJpaTest
public class UserRepositoryTest {
   @Autowired
   private TestEntityManager entityManager;
   @Autowired
   private UserRepository userRepository;

   User user = new User(UUID.fromString("6598bb36-1de4-4e06-99fa-555c80f12781"),"user1","user1");

   @DisplayName("should get all users from the database")
   @Test
   public void whenCalled_returnListOfUsers(){
      List<User> testList = List.of(user);
      List<User> foundUsers = userRepository.findAll();
      assertTrue(testList.size()==foundUsers.size());
   }
   @DisplayName("Should save to database")
   @Test
   public void whenGivenUser_shouldSave() {
      User user = new User(UUID.randomUUID(),"Ross","Geller");
      userRepository.save(user);
      User isUserFound = userRepository.findById(user.getId()).get();
      assertEquals(user.getId(), isUserFound.getId());
   }

   @DisplayName("should get user by ID")
   @Test
   public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject()
   {

      User getUser = userRepository.findById(user.getId()).get();

      assertEquals(getUser.getId(), UUID.fromString("6598bb36-1de4-4e06-99fa-555c80f12781"));
      assertEquals(getUser.getUsername(), "user1");
      assertEquals(getUser.getPassword(), "user1");
   }

   @DisplayName("testing update")
   @Test
   public void givenEmployeeUpdateDetails_whenUpdateCalled_shouldUpdateChosenUser(){
      User createdUser = new User(UUID.randomUUID(),"Pheobe","Buffay");
      userRepository.save(createdUser);

      //update like this:
      Optional<User> userToUpdateOptional = userRepository.findById(createdUser.getId());
      User userToUpdate = userToUpdateOptional.get();

      userToUpdate.setUsername("David");
      userToUpdate.setPassword("Goggins");
      userRepository.save(userToUpdate);

      //update complete, now check if update worked properly

      Optional<User> checkUser = userRepository.findById(createdUser.getId());
      assertEquals(checkUser.get().getUsername(), "David");
      assertEquals(checkUser.get().getPassword(), "Goggins");
   }

   @DisplayName("Should delete usere")
   @Test
   public void whenGivenIdOfUserToDelete_shouldDelete_checkDbIfStillThere(){
      User userToDelete = new User(UUID.randomUUID(),"Mo","Farah");
      userRepository.save(userToDelete);
      userRepository.deleteById(userToDelete.getId());

      Optional<User> getUser = userRepository.findById(userToDelete.getId());
      Optional<User> emptyOptional = Optional.empty();
      assertEquals(getUser, emptyOptional);
   }

}
