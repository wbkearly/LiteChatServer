package priv.wbk.litechat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import priv.wbk.litechat.model.User;
import priv.wbk.litechat.service.UserService;

@SpringBootApplication
@Slf4j
public class LiteChatApplication implements ApplicationRunner {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(LiteChatApplication.class, args);
    }

    public LiteChatApplication(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
