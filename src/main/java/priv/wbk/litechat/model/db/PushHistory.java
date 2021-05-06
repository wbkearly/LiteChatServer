package priv.wbk.litechat.model.db;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import priv.wbk.litechat.enums.EntityType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on 2021/5/6.
 *
 * @author wbk
 * @email 3207264942@qq.com
 * 消息推送记录表
 */
@Entity
@Table(name = "T_Push_History")
@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PushHistory extends BaseEntity {

    /**
     * 一个接收者可以接收很多消息
     * 加载推送消息同时加载用户信息
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiverId")
    private User receiver;
    @Column(nullable = false, updatable = false, insertable = false)
    private String receiverId;

    /**
     * 可能是系统消息 可为空
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "senderId")
    private User sender;
    @Column(updatable = false, insertable = false)
    private String senderId;

    /**
     * 接收者收到消息的设备
     * User 中的PushId 可为null
     */
    @Column
    private String receiverPushId;

    /**
     * 推送实体类型
     */
    private EntityType entityType;

    /**
     * 推送实体
     * 存储JSON字符串
     */
    @Lob
    @Column(nullable = false, columnDefinition = "BLOB")
    private String entity;

    /**
     * 消息送达时间
     */
    @UpdateTimestamp
    private Date arrivalTime;
}
