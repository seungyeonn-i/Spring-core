package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread A : a ordered 10000
        int userAPrice = statefulService1.order("userA",10000);

        //Thread B : b ordered 20000
        int userBPrice = statefulService2.order("userB",20000);

        //Thread A : getprice A

        assertThat(userAPrice).isEqualTo(10000);

    }

    static class TestConfig
    {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}