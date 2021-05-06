package priv.wbk.litechat.model.db;

import lombok.*;
import priv.wbk.litechat.enums.RequestStatus;

import javax.persistence.*;

/**
 * Created on 2021/5/5.
 *
 * @author wbk
 * @email 3207264942@qq.com
 *
 * 朋友请求关系表
 */
@Entity
@Table(name = "T_Friend_Request")
@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest extends BaseEntity {

    /**
     * 定义一个发起人
     * 你可以向很多人加好友
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "senderId")
    private User sender;
    @Column(nullable = false, updatable = false, insertable = false)
    private String senderId;

    /**
     * 可以被很多人加好友
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "receiverId")
    private User receiver;
    @Column(nullable = false, updatable = false, insertable = false)
    private String receiverId;

    @Column(nullable = false)
    private RequestStatus requestStatus;
}
