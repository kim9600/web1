package com.bin.blog.repository;

import com.bin.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//DAO(Data access Object) db에 접근가능한 객체
//자동으로 bean등록이된다.
//@Repository 생략가능하다.
public interface UserRepository extends JpaRepository<User,Integer> {

}
