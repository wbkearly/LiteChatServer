package priv.wbk.litechat.model;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2021/5/5.
 *
 * @author wbk
 * @email 3207264942@qq.com
 */
@Entity
@Table(name = "T_User")
@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(length = 64)
    private String phone;

    @Column(length = 20)
    private String username;

    @Column(length = 20)
    private String nickname;

    @Column(length = 64)
    private String password;

    private String faceImg;

    private String faceImgBig;

    private String description;

    private int gender;

    private String qrcode;

    @Column(length = 64)
    private String clientId;

    private String token;

    /**
     * 我有很多朋友，我是origin
     * 懒加载 只有当遍历集合才加载
     */
    @JoinColumn(name = "originId")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserFriend> myFriends = new HashSet<>();

    /**
     * 用户创建的群
     */
    @JoinColumn(name = "ownerId")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Group> groups= new HashSet<>();

    /**
     * 我可以有很多朋友的请求
     */
    @JoinColumn(name = "receiverId")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FriendRequest> friendRequests = new HashSet<>();

}
