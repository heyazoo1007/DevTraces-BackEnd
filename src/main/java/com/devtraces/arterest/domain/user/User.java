package com.devtraces.arterest.domain.user;

import com.devtraces.arterest.common.domain.BaseEntity;
import com.devtraces.arterest.common.UserSignUpType;
import com.devtraces.arterest.common.UserStatusType;
import com.devtraces.arterest.domain.feed.Feed;
import com.devtraces.arterest.domain.reply.Reply;
import com.devtraces.arterest.domain.rereply.Rereply;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditOverride;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AuditOverride(forClass = BaseEntity.class)
@Table(name = "user")
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String nickname;
    private String email;
    private String description;

    private String password; // 암호화 필요.

    private LocalDateTime withdrawAt;

    @Enumerated(EnumType.STRING)
    private UserSignUpType signupType;

    private String profileImageLink;

    @Enumerated(EnumType.STRING)
    private UserStatusType userStatus;

    //1:N mapping
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Feed> feedList = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Reply> replyList = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Rereply> rereplyList = new ArrayList<>();

    public void setUsername(String username){ this.username = username; }

    public void setNickname(String nickname){ this.nickname = nickname; }

    // 이메일 수정의 경우 추후 필요없으면 제거
    public void setEmail(String email){ this.email = email; }

    public void setDescription(String description){ this.description = description; }

    public void setPassword(String password){ this.password = password; }

    public void setProfileImageLink(String profileImageLink){ this.profileImageLink = profileImageLink; }

    public void setWithdrawAt(LocalDateTime withdrawAt){ this.withdrawAt = withdrawAt; }

}
