import com.spring.tx.annotation.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// 使用@RunWith注解替换原来的运行器
@RunWith(SpringJUnit4ClassRunner.class)
// 使用@ContextConfiguration指定配置文件或配置类
@ContextConfiguration(value = {"classpath:spring-transaction.xml"})		// 指定配置文件
// @ContextConfiguration(classes = {SpringConfig.class})				// 指定配置类
public class TxByAnnotationTest {

  @Autowired
    private BookController bookController;
  @Test
    public void testBuyBook(){

      bookController.buyBook(1,1);


  }
}
