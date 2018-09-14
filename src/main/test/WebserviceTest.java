import com.example.webservice.TestWebService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lvxiao on 2018/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class WebserviceTest {

    private TestWebService testWebService;

    @Before
    public void init() {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(TestWebService.class);
        factoryBean.setAddress("http://localhost:8888/cxf/test?wsdl");
        testWebService = (TestWebService) factoryBean.create();

    }
    @Test
    public void test1() {
        System.out.println(testWebService.say());
    }
    @Test
    public void test2() {
        testWebService.write();
    }
}
