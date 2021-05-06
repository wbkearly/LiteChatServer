package priv.wbk.litechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.wbk.litechat.model.db.User;

/**
 * Created on 2021/5/5.
 *
 * @author wbk
 * @email 3207264942@qq.com
 */
public interface UserRepository extends JpaRepository<User, String> {
}
