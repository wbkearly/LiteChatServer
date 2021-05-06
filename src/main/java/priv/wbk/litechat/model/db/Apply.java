package priv.wbk.litechat.model.db;

import lombok.*;
import priv.wbk.litechat.enums.ApplyType;

import javax.persistence.*;

/**
 * Created on 2021/5/6.
 *
 * @author wbk
 * @email 3207264942@qq.com
 *
 * 申请
 */
@Entity
@Table(name = "T_Apply")
@Builder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Apply extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "applicantId")
    private User applicant;
    @Column(updatable = false, insertable = false)
    private String applicantId;

    /**
     * 可以附带图片地址 或者其他
     */
    @Column(columnDefinition = "TEXT")
    private String attach;

    /**
     * 描述部分， 对申请信息做描述
     */
    @Column(nullable = false)
    private String description;

    /**
     * 与type有关 User.id Group.id
     *
     */
    private String targetId;

    /**
     * 申请类型
     */
    @Column(nullable = false)
    private ApplyType type;
}
