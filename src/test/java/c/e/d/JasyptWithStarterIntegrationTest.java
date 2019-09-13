package c.e.d;

import c.e.d.PropertyServiceForJasyptStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptWithStarterIntegrationTest {

    @Autowired
    ApplicationContext appCtx;


/*
    @Test
    public void checkPropValue(){
       PropertyServiceForJasyptStarter service =  appCtx.getBean(PropertyServiceForJasyptStarter.class);
       assertEquals("testPasswrod4maIl",service.getProperty());

    }
*/



    @Test
    public void whenDecryptedPasswordNeeded_GetFromService() {
        System.setProperty("jasypt.encryptor.password", "password");
        PropertyServiceForJasyptStarter service = appCtx.getBean(PropertyServiceForJasyptStarter.class);
      /*  assertEquals("Password@1", service.getProperty());*/
        assertEquals("password2T", service.getProperty());
        Environment environment = appCtx.getBean(Environment.class);
        assertEquals("password2T", service.getPasswordUsingEnvironment(environment));/*assertEquals("Password@1", service.getPasswordUsingEnvironment(environment));*/
    }
}