package priv.wbk.litechat.service;

import org.springframework.stereotype.Service;
import priv.wbk.litechat.model.db.User;
import priv.wbk.litechat.repository.UserRepository;

import java.util.Optional;

/**
 * Created on 2021/5/5.
 *
 * @author wbk
 * @email 3207264942@qq.com
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
