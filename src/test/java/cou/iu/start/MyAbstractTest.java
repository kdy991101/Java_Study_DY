package cou.iu.start;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class MyAbstractTest {
	
	
	//abstract를 넣었기 때문에 다른 클래스에 이 클래스를 상속받으면(extends 클래스명) 
	//위의 어노테이션 두개가 자동으로 새로 생성된 클래스에 적용된다

	

}
