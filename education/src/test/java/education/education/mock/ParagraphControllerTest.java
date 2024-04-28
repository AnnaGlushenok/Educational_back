package education.education.mock;

import education.education.controllres.ParagraphController;
import education.education.dtos.ParagraphDTO;
import education.education.enums.QuestionType;
import education.education.mappers.ParagraphMapper;
import education.education.models.ControlWork;
import education.education.models.Paragraph;
import education.education.models.Question;
import education.education.services.ParagraphService;
import jakarta.ws.rs.core.MediaType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
@WebMvcTest(ParagraphController.class)
@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParagraphControllerTest {
    @MockBean
    private ParagraphService paragraphService;

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;
    @Autowired
    private ParagraphMapper paragraphMapper;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetById_ExistingId_ReturnsOk() throws Exception {
        // Arrange
        int paragraphId = 1;
        ParagraphDTO paragraphDTO = new ParagraphDTO();
        paragraphDTO.setId(paragraphId);

        // Mocking service method to return a paragraphDTO when findById is called
        Mockito.when(paragraphService.findById(paragraphId)).thenReturn(paragraphDTO);

        // Act & Assert
        mockMvc.perform(get("/paragraph/get/{id}", paragraphId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(paragraphId));
    }

    @Test
    public void testGetById_NonExistingId_ReturnsNotFound() throws Exception {
        // Arrange
        int nonExistingParagraphId = 100;

        // Mocking service method to throw RuntimeException when findById is called
        Mockito.when(paragraphService.findById(nonExistingParagraphId)).thenThrow(new RuntimeException("Paragraph could not be found id=" + nonExistingParagraphId));

        // Act & Assert
        mockMvc.perform(get("/paragraph/get/{id}", nonExistingParagraphId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Paragraph could not be found id=" + nonExistingParagraphId));
    }

    @Test
    public void testParagraphController() throws Exception {
        Question question = Question.builder().question("q").answers("a").correctAnswer("a").explanation("e").questionType(QuestionType.TEXT).build();
        ControlWork controlWork = ControlWork.builder().name("c1")
                .questions(new ArrayList<>() {{
                    add(question);
                }})
                .build();
        education.education.models.Test test = education.education.models.Test.builder().name("t")
                .questions(new ArrayList<>() {{
                    add(question);
                }})
                .isFinal(true)
                .build();
        Paragraph paragraph = Paragraph.builder().name("p1").text("text")
                .questions(new ArrayList<>() {{
                    add(question);
                }})
                .tests(new ArrayList<>() {{
                    add(test);
                }})
                .controlWorks(new ArrayList<>() {{
                    add(controlWork);
                }})
                .build();

//        when(paragraphService.findById(1)).thenReturn(paragraph);
//        mockMvc.perform(post)
    }

    @Test
    void test() {
        Assertions.assertThat(restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("");
    }

    @Test
    void test1() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<p>")));

        Mockito.when(paragraphService.findById(1)).thenReturn(null);
        mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Mock")));
    }
}
