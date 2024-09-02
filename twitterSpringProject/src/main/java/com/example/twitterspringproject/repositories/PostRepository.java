package com.example.twitterspringproject.repositories;

import com.example.twitterspringproject.entities.PostEntity;
import com.example.twitterspringproject.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByUserEntity(UserEntity userEntity);
}
