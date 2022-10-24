package mx.tirio.app.multiservice.common.application;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Utility for testing controllers.
 * 
 * @author Gerardo Corsan
 *
 */
public class ControllerTestUtil {

    /**
     * Attribute mockMvc.
     */
    private MockMvc mockMvc;

    /**
     * Constructor using mock MVC.
     * 
     * @param mockMvc the mockMvc.
     */
    public ControllerTestUtil(final MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    /**
     * Executes MVC Mock.
     * 
     * @param method HTTP method.
     * @param uri    the uri.
     * @param body   request body.
     * @param params query parameters.
     * @return the call result.
     * @throws Exception if an error ocurrs.
     */
    public MockHttpServletResponse runMvcMock(final HttpMethod method, final String uri, final String body,
            final Map<String, String> params)
            throws Exception {

        MockHttpServletRequestBuilder requestBuilder = (method.equals(HttpMethod.GET))
                ? MockMvcRequestBuilders.get(uri)
                : MockMvcRequestBuilders.post(uri);

        requestBuilder = (method.equals(HttpMethod.POST))
                ? MockMvcRequestBuilders.get(uri)
                : MockMvcRequestBuilders.put(uri);

        MockHttpServletRequestBuilder mvcBuilder = requestBuilder
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE);

        if (body != null) {
            mvcBuilder = mvcBuilder.content(body);
        }

        if (params != null) {
            MultiValueMap<String, String> multiMap = new LinkedMultiValueMap<>();
            params.forEach((name, values) -> {
                multiMap.add(name, params.get(name));
            });
            mvcBuilder = mvcBuilder.params(multiMap);
        }

        MvcResult mvcResult = mockMvc
                .perform(mvcBuilder)
                .andReturn();

        return mvcResult.getResponse();
    }

}
