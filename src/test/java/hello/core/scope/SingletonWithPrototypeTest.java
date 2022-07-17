package hello.core.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest {

    @Test
    void prototypeFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isNotEqualTo(2);



    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        //클라이언트1 생성
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        //클라이언트1 로직 실행 , count 1
        int count1 = clientBean1.logic();
        //클라이언트2 생성
        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        //클라이언트2 로직 실행, count 2
        // -> 프로토타입빈인 count 변수여도 생성시에만 프로토타입,

        int count2 = clientBean2.logic();

//        Assertions.assertThat(count1).isNotEqualTo(count2);
//        Assertions.assertThat(count2).isEqualTo(2);

    }

//    @Scope("singleton")   //default
//    @RequiredArgsConstructor    //Constructor
    static class ClientBean{
//        private final PrototypeBean prototypeBean;  //생성시점에 주입 되버림
                                                    // 그래서 계속 같은거 씀

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addCount(){
            count++;
        }
        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init" + this);
        }
        @PreDestroy //prototype Scope 이면 호출 되지 않음
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }

    }
}

