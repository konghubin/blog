package cn.hubindeveloper.multitool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class MultiApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableEnvironment env = SpringApplication
                .run(MultiApplication.class, args)
                .getEnvironment();
        log.info("server.servlet.context-path: {}",env.getProperty("server.servlet.context-path"));
        log.info("application:Access URLs: \n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }
}
