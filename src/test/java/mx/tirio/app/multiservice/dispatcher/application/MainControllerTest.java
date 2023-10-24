package mx.tirio.app.multiservice.dispatcher.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import mx.tirio.app.multiservice.MultiserviceApplication;
import mx.tirio.app.multiservice.common.application.ControllerTestUtil;
import mx.tirio.app.multiservice.dispatcher.domain.core.GenericService;
import mx.tirio.app.multiservice.dispatcher.domain.output.ServiceStorePort;

/**
 * Unit tests for MainController.
 * 
 * @author Gerardo Corsan
 *
 */
@SpringBootTest(classes = { MultiserviceApplication.class })
public class MainControllerTest {

    /**
     * Instancie for mockMvc.
     */
    private MockMvc mockMvc;

    /**
     * Mock mainController.
     */
    @InjectMocks
    private MainController mainController;

    /**
     * Mock genericService.
     */
    @Mock
    private GenericService genericService;

    /**
     * Mock serviceStorePort.
     */
    @Mock
    private ServiceStorePort serviceStorePort;

    /**
     * Utillty for testing controllers.
     */
    private ControllerTestUtil controllerTestUtil;

    /**
     * Inicialización de pruebas unitarias.
     * 
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
        controllerTestUtil = new ControllerTestUtil(mockMvc);
    }

    /**
     * Unit test for method executeGetService.
     * 
     * @throws Exception en caso de error
     */
    @Test
    void executeGetServiceTest() throws Exception {
        String uri = "/multiservice/service/simplex";

        MockHttpServletResponse responseResult = controllerTestUtil.runMvcMock(HttpMethod.GET, uri, null, null);

        assertEquals(HttpStatus.OK.value(), responseResult.getStatus());
    }

    /**
     * Unit test for method executePostService.
     * 
     * @throws Exception en caso de error
     */
    @Test
    void executePostServiceTest() throws Exception {
        String uri = "/multiservice/service/simplex";

        MockHttpServletResponse responseResult = controllerTestUtil.runMvcMock(HttpMethod.POST, uri, null, null);

        assertEquals(HttpStatus.OK.value(), responseResult.getStatus());
    }

    /**
     * Unit test for method executePutService.
     * 
     * @throws Exception en caso de error
     */
    @Test
    void executePutServiceTest() throws Exception {
        String uri = "/multiservice/service/simplex";

        MockHttpServletResponse responseResult = controllerTestUtil.runMvcMock(HttpMethod.PUT, uri, null, null);

        assertEquals(HttpStatus.OK.value(), responseResult.getStatus());
    }
}
