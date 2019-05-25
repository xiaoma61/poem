import com.poetry.web.controller.indexcontroller.LoginController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-shiro.xml"})
@WebAppConfiguration
@Rollback
public class LoginTest {
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;


    @Before
    public void setUp(){
        request=new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response=new MockHttpServletResponse();
    }

}
