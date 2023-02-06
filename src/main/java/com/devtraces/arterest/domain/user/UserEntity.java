package com.devtraces.arterest.domain.user;

import com.devtraces.arterest.common.domain.BaseEntity;
import com.devtraces.arterest.common.UserSignUpType;
import com.devtraces.arterest.common.UserStatusType;
import com.devtraces.arterest.domain.feed.Feed;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "user_entity")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AuditOverride(forClass = BaseEntity.class)
@Entity
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userEntityId;

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

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<Feed> feedList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<Feed> replyList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<Feed> rereplyList = new ArrayList<>();

}
