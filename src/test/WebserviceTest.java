import com.example.webservice.TestWebService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lvxiao on 2018/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-cxf.xml"})
public class WebserviceTest {

    private TestWebService testWebService;

    @Before
    public void init() {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(TestWebService.class);
        factoryBean.setAddress("http://localhost:8080/cxf/test?wsdl");
        testWebService = (TestWebService) factoryBean.create();
    }
    @Test
    public void test1() {
        Assert.assertEquals("返回的结果和我想的一样:",testWebService.say(), "say");
    }
    @Test
    public void test2() {
        testWebService.write();
    }
}
