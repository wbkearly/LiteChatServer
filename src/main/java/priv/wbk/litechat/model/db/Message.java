package priv.wbk.litechat.model.db;

import lombok.*;
import priv.wbk.litechat.enums.MessageType;

import javax.persistence.*;

/**
 * Created on 2021/5/5.
 *
 * @author wbk
 * @email 3207264942@qq.com
 * 消息模型
 */
@Entity
@Table(name = "T_Message")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    /**
     * Id由代码写入 由客户端负责生成
     * 避免复杂映射关系
     */
    @Id
    private String id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private String attach;

    /**
     * 消息类型
     */
    @Column(nullable = false)
    private MessageType type;

    /**
     * 多个消息对应一个发送者
     */
    @JoinColumn(name = "senderId")
    @ManyToOne(optional = false)
    private User sender;
    @Column(updatable = false, insertable = false)
    private String senderId;

    /**
     * 可为群聊 可为空
     */
    @JoinColumn(name = "receiverId")
    @ManyToOne
    private User receiver;
    @Column(updatable = false, insertable = false)
    private String receiverId;

    @JoinColumn(name = "groupId")
    @ManyToOne
    private Group group;
    @Column(updatable = false, insertable = false)
    private String groupId;
}
