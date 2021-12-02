package org.moDgo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "users")
@Getter
public class User {
    @Id
    @Column(name = "user_id")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(length = 500, nullable = false)
    private String imgUrl;

    private int totalGoodScore;

    private int totalBadScore;

    private int totalNormalScore;

    @OneToMany(mappedBy = "user")//내가 만든 모임들
    private List<Club> clubs = new ArrayList<Club>();

    @OneToMany(mappedBy = "user")//내가 참여가능한 모임에 대한 멤버
    private List<Member> members = new ArrayList<Member>();

    @Builder //생성자에 @Builder 를 설정하게되면 해당 생성자를 사용하는 Builder 가 생성되어 의미있는 객체만 생성할 수 있음
    public User(final String id, final String name,
                final String email, final String imgUrl,
                int totalBadScore,int totalGoodScore, int totalNormalScore) { //변수에 final -> 이 변수는 수정 불가
        this.id = id;
        this.email = email;
        this.name = name;
        this.imgUrl = imgUrl;
        this.totalBadScore = totalBadScore;
        this.totalGoodScore = totalGoodScore;
        this.totalNormalScore = totalNormalScore;
    }

    public void changeTotalNum(int good,int bad,int normal) {
        this.totalNormalScore = normal;
        this.totalGoodScore = good;
        this.totalBadScore = bad;
    }
}
