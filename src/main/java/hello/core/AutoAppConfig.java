package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //basePackages 지정하지 않으면 ComponentScan 붙은 위치부터 하위 == 지금 패키지 다

        basePackages = "hello.core", //여기서부터 찾아서 시작
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {

}
