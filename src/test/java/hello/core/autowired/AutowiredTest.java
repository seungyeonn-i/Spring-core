package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){

            //지금, 자동 주입 할 대상이 없는 상태 !!
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {


        @Autowired(required = false)    //호출이 안됨
        public void setNoBean1(Member nobean1){
            System.out.println("nobean1 = " + nobean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member nobean2){
            System.out.println("nobean2 = " + nobean2);
        }

        @Autowired
        public void setNoBean2(Optional<Member> nobean3 ){
            System.out.println("nobean3 = " + nobean3);
        }


    }
    }
