package com.bin.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    @Column(nullable = false, length = 100) //null이 되면안되므로 false
    private String title;

    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 사용예정(<html>태그가 섞여서 디자인)

    @ColumnDefault("0")
    private int count;  //조회수

    @ManyToOne(fetch = FetchType.EAGER)
    //Many =Board , One =User //연관관계 설정
    //FetchType.EAGER -> Board테이블 셀렉트하면
    // ManyToOne 기본전략 one이라 한건밖에 없으니까 바로가져올거다.
    @JoinColumn(name = "userId") //테이블 필드값이 userId로 저장한다.
    private User user; //DB는 오브젝트를 저장할수없다.FK,자바는 오브젝트를 저장할수있다.
                        //하지만 ORM을 이용하면 오브젝트를 저장할수있다.@조인칼럼

    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER) //mappedBy :연관관계의 주인이아니다(난 FK가 아니에요)
                                //DB에 컬럼을 만들지마세요. 값을얻기위해서만 필요한거에요.
    //그리고 OneToMany 이므로 reply값이 여러개잖아요 그래서 필요할때만 불러올게요 LAZY 기본전략
    //아니에요 그래도 다가져올게요 EAGER전략
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}

