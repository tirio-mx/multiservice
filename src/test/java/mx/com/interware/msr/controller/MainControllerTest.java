package mx.com.interware.msr.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mx.tirio.app.multiservice.MultiserviceApplication;
import mx.tirio.app.multiservice.dispatcher.application.MainController;
import mx.tirio.app.multiservice.dispatcher.application.model.HttpStatus;

@SpringBootTest(classes = { MultiserviceApplication.class })
public class MainControllerTest {

    @Autowired
    private MainController controller;

    @SuppressWarnings("deprecation")
    @Test
    public final void privateConstructorHttpStatus() throws Exception {
        Constructor<HttpStatus> constructor = HttpStatus.class.getDeclaredConstructor();
        assertEquals(false, constructor.isAccessible());
        constructor.setAccessible(true);
        constructor.newInstance((Object[]) null);
    }

}
