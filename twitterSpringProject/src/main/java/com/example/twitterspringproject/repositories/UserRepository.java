package com.example.twitterspringproject.repositories;

import com.example.twitterspringproject.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
   @Query(value = "select * from public.users", nativeQuery = true)
   List<UserEntity> receiveAllUsers();

   UserEntity findByLogin(String login);

}
