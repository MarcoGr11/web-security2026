/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 20.10.2026
 * Course: Spring Security
 * Task №7. Access testing
 */

package chnu.pzks.websecurity26.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class AccessingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void anonymousOnHelloAdminIsUnauthorized() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-admin")).andReturn();
        assertEquals(401, result.getResponse().getStatus());
        assertEquals("Unauthorized", result.getResponse().getErrorMessage());
    }

    @Test
    void anonymousOnIndexIsOk() throws Exception {
        MvcResult result = mockMvc.perform(get("/")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("Hello, security!", result.getResponse().getContentAsString());
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void adminOnHelloAdminIsOk() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-admin")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("Hello, admin!", result.getResponse().getContentAsString());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void adminOnHelloUserIsForbidden() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-user")).andReturn();
        assertEquals(403, result.getResponse().getStatus());
        assertEquals("Forbidden", result.getResponse().getErrorMessage());
    }

    @Test
    @WithMockUser(roles = "USER")
    void userOnHelloUserIsOk() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-user")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("Hello, user!", result.getResponse().getContentAsString());
    }

    @Test
    @WithMockUser(roles = "USER")
    void userOnHelloAdminIsForbidden() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-admin")).andReturn();
        assertEquals(403, result.getResponse().getStatus());
    }

    @Test
    @WithMockUser(roles = "USER")
    void userOnHelloManIsOk() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-man")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("Hello, man!", result.getResponse().getContentAsString());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void adminOnHelloManIsOk() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-man")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("Hello, man!", result.getResponse().getContentAsString());
    }

    @Test
    @WithMockUser(roles = "SUPERADMIN")
    void superadminOnHelloAdminIsForbidden() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-admin")).andReturn();
        assertEquals(403, result.getResponse().getStatus());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void adminOnBooksIsOk() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/books")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void anonymousOnBooksIsUnauthorized() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/books")).andReturn();
        assertEquals(401, result.getResponse().getStatus());
    }

    @Test
    @WithMockUser(roles = "SUPERADMIN")
    void superadminOnBooksIsOk() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/books")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    @WithMockUser(roles = "SUPERADMIN")
    void superadminOnHelloManIsForbidden() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-man")).andReturn();
        assertEquals(403, result.getResponse().getStatus());
    }

    @Test
    void anonymousOnHelloManIsUnauthorized() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/access/hello-man")).andReturn();
        assertEquals(401, result.getResponse().getStatus());
    }
}
