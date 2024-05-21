package education.education.integration;

import education.education.models.Question;
import education.education.repositories.QuestionRepository;
import education.education.repositories.TestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class QuestionTestRelationTest {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestRepository testRepository;

    @Test
    @DisplayName("Set questions to test")
    public void setQuestions() {
        List<Question> questions = new ArrayList<>() {{
            add(Question.builder().question("question1").answers("1").correctAnswer("1").explanation("1").build());
            add(Question.builder().question("question2").answers("2").correctAnswer("2").explanation("2").build());
            add(Question.builder().question("question3").answers("3").correctAnswer("3").explanation("3").build());
            add(Question.builder().question("question4").answers("4").correctAnswer("4").explanation("4").build());
        }};
        List<education.education.models.Test> tests = new ArrayList<>() {{
            add(education.education.models.Test.builder().name("test1").questions(questions).build());
            add(education.education.models.Test.builder().name("test2").questions(questions.subList(0, 1)).build());
        }};

        Assertions.assertThat(tests.get(0).getQuestions()).isEqualTo(questions);
        Assertions.assertThat(tests.get(1).getQuestions()).isEqualTo(questions.subList(0, 1));
    }

    @Test
    @DisplayName("Delete question")
    public void deleteQuestion() {
        final List<Question> questions = new ArrayList<>() {{
            add(Question.builder().question("question1").answers("1").correctAnswer("1").explanation("1").build());
            add(Question.builder().question("question2").answers("2").correctAnswer("2").explanation("2").build());
            add(Question.builder().question("question3").answers("3").correctAnswer("3").explanation("3").build());
            add(Question.builder().question("question4").answers("4").correctAnswer("4").explanation("4").build());
        }};
        final List<education.education.models.Test> tests = new ArrayList<>() {{
            add(education.education.models.Test.builder().name("test1").questions(questions).build());
            add(education.education.models.Test.builder().name("test2").questions(questions.subList(0, 2)).build());
        }};
        questionRepository.saveAll(questions);
        testRepository.saveAll(tests);

//        questionRepository.deleteById(questions.get(0).getId());
        testRepository.deleteById(tests.get(0).getId());
        List<Question> newQuestions = questionRepository.findAll();
        List<education.education.models.Test> newTests = testRepository.findAll();

        Assertions.assertThat(newTests.get(0).getQuestions()).isEqualTo(questions.subList(1, 3));
    }
}
