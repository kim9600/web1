package com.bin.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

//persistence 영속성 "영"원히 "계"속되는 "성"질
//ORM ->JAVA(다른언어) Object ->테이블로 매핑해주는 기술

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴!
@Entity //User 클래스가 MySQL에 테이블이 생성된다.
//@DynamicInsert  //insert시 null인 필드를 제외시켜준다.
public class User {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //프로젝트에서 연결된 DB의 넘버링전략을 따라간다.
    private int id; //시퀀스, auto-increment

    @Column(nullable = false,length = 30)
    private String username;

    @Column(nullable = false,length = 100)
    private String password;

    @Column(nullable = false,length = 50)
    private String email;

    //@ColumnDefault("'user'")
    //DB에는 RoleType이란게 없어서 String이라고 알려줘야함.
    @Enumerated(EnumType.STRING)
    private RoleType role; //Enum을 쓰는게좋다. //ADMIN,USER


    @CreationTimestamp //시간 자동으로입력
    private Timestamp creteDate;
}
