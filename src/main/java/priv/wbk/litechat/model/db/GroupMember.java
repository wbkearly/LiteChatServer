package priv.wbk.litechat.model.db;

import lombok.*;
import priv.wbk.litechat.enums.NotifyLevel;
import priv.wbk.litechat.enums.PermissionType;

import javax.persistence.*;

/**
 * Created on 2021/5/5.
 *
 * @author wbk
 * @email 3207264942@qq.com
 */
@Entity
@Table(name = "T_Group_Member")
@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupMember extends BaseEntity{

    /**
     * 别名
     */
    private String alias;

    @Column(nullable = false)
    private NotifyLevel notifyLevel = NotifyLevel.NONE;

    @Column(nullable = false)
    private PermissionType permissionType = PermissionType.NONE;

    /**
     * 成员对应的用户
     */
    @JoinColumn(name = "userId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    @Column(nullable = false, updatable = false, insertable = false)
    private String userId;

    /**
     * 成员对应的群
     */
    @JoinColumn(name = "groupId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Group group;
    @Column(nullable = false, updatable = false, insertable = false)
    private String groupId;
}
