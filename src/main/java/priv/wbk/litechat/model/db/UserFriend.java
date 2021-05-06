package priv.wbk.litechat.model.db;

import lombok.*;

import javax.persistence.*;

/**
 * Created on 2021/5/5.
 *
 * @author wbk
 * @email 3207264942@qq.com
 *
 * 用户关系的Model
 */
@Entity
@Table(name = "T_User_Friend")
@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserFriend extends BaseEntity {

    /**
     * 我作为发起方，可以有很多朋友
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "originId")
    private User origin;
    @Column(nullable = false, updatable = false, insertable = false)
    private String originId;

    /**
     * 我作为朋友一方，可以是很多人的朋友
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "targetId")
    private User target;
    @Column(nullable = false, updatable = false, insertable = false)
    private String targetId;

    /**
     * 别名 可为null
     */
    private String alias;
}
