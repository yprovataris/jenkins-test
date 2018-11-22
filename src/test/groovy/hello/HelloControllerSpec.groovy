package hello

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@WebMvcTest(controllers = HelloController)
class HelloControllerSpec extends Specification {
    @Autowired
    MockMvc mockMvc

    def shouldReturnDefaultMessage() {
        given:
        def expectedResponseBody = "Greetings from Spring Boot!"

        expect:
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(expectedResponseBody))
    }
}
