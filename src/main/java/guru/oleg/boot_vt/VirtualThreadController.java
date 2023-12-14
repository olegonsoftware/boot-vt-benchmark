package guru.oleg.boot_vt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class VirtualThreadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualThreadController.class);
    public static final int SLEEP_TIME = 300;

    @GetMapping("/")
    public String getResponse(){
        try {
            TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }

        long threadId = Thread.currentThread().threadId() ;
        return  String.valueOf(threadId);
    }
}
