package in.nareshit.raghu.util;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class UserUtil {

    public String genPwd() {
        return UUID.randomUUID()
                .toString()
                .replaceAll("-", "")
                .substring(0, 8);
    }

    public String getOtp() {
        return String.format(
                "%04d",
                new Random().nextInt(10000)
        );
    }
}
