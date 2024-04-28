package education.education.unit;

import education.education.dtos.*;
import education.education.enums.QuestionType;
import education.education.mappers.*;
import education.education.models.Class;
import education.education.models.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MappersTest {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ControlWorkMapper controlWorkMapper;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ParagraphMapper paragraphMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private UnitMapper unitMapper;

    Image image = Image.builder().name("i1").alt("alt").build();
    Class class1 = Class.builder().name("class").build();
    Subject subject = Subject.builder().name("s").image(image).build();
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
    Unit unit = Unit.builder().name("u")
            .subject(subject)
            .classEntity(Class.builder().name("class1").build())
            .test(test)
            .controlWork(controlWork)
            .paragraphs(new ArrayList<>() {{
                add(paragraph);
            }})
            .build();

    @Test
    @DisplayName("Map class to dto")
    void classToDTO() {
        ClassDTO classDTO = classMapper.toDTO(class1);
        testClass(classDTO, class1);
    }

    @Test
    @DisplayName("Map control work to dto")
    void controlWorkToDTO() {
        ControlWorkDTO controlWorkDTO = controlWorkMapper.toDTO(controlWork);
        QuestionDTO questionDTO = controlWorkDTO.getQuestions().get(0);
        Question question = controlWork.getQuestions().get(0);

        testControlWork(controlWorkDTO, controlWork);
        testQuestion(questionDTO, question);
    }

    @Test
    @DisplayName("Map image to dto")
    void imageToDTO() {
        ImageDTO imageDTO = imageMapper.toDTO(image);
        testImage(imageDTO, image);
    }

    @Test
    @DisplayName("Map paragraph to dto")
    void paragraphToDTO() {
        ParagraphDTO paragraphDTO = paragraphMapper.toDTO(paragraph);
        QuestionDTO questionDTO = paragraphDTO.getQuestions().get(0);
        Question question = paragraph.getQuestions().get(0);
        education.education.models.Test test = paragraph.getTests().get(0);
        TestDTO testDTO = paragraphDTO.getTests().get(0);
        ControlWorkDTO controlWorkDTO = paragraphDTO.getControlWorks().get(0);
        ControlWork controlWork = paragraph.getControlWorks().get(0);

        testParagraph(paragraphDTO, paragraph);
        testQuestion(questionDTO, question);
        testTest(testDTO, test);
        questionDTO = testDTO.getQuestions().get(0);
        question = test.getQuestions().get(0);
        testQuestion(questionDTO, question);
        testControlWork(controlWorkDTO, controlWork);
        questionDTO = controlWorkDTO.getQuestions().get(0);
        question = controlWork.getQuestions().get(0);
        testQuestion(questionDTO, question);
    }

    @Test
    @DisplayName("Map question to dto")
    void questionToDTO() {
        QuestionDTO questionDTO = questionMapper.toDTO(question);
        testQuestion(questionDTO, question);
    }

    @Test
    @DisplayName("Map subject to dto")
    void mapSubjectToDTO() {
        SubjectDTO subjectDTO = subjectMapper.toDTO(subject);
        testSubject(subjectDTO, subject);
    }

    @Test
    @DisplayName("Map test to dto")
    void testToDTO() {
        TestDTO testDTO = testMapper.toDTO(test);
        QuestionDTO questionDTO = testDTO.getQuestions().get(0);
        Question question = test.getQuestions().get(0);
        testTest(testDTO, test);
        testQuestion(questionDTO, question);
    }

    @Test
    @DisplayName("Map unit to dto")
    void mapUnitToDTO() {
        UnitDTO unitDTO = unitMapper.toDTO(unit);

        testUnit(unitDTO, unit);
        testSubject(unitDTO.getSubject(), unit.getSubject());
        testImage(unitDTO.getSubject().getImage(), unit.getSubject().getImage());
        testClass(unitDTO.getClassEntity(), unit.getClassEntity());
        testTest(unitDTO.getTest(), unit.getTest());
        testQuestion(unitDTO.getTest().getQuestions().get(0), unit.getTest().getQuestions().get(0));
        testControlWork(unitDTO.getControlWork(), unit.getControlWork());
        testQuestion(unitDTO.getControlWork().getQuestions().get(0), unit.getControlWork().getQuestions().get(0));

        ParagraphDTO paragraphDTO = unitDTO.getParagraphs().get(0);
        Paragraph paragraph = unit.getParagraphs().get(0);
        testParagraph(paragraphDTO, paragraph);
        testQuestion(paragraphDTO.getQuestions().get(0), paragraph.getQuestions().get(0));

        testTest(paragraphDTO.getTests().get(0), paragraph.getTests().get(0));
        testQuestion(paragraphDTO.getTests().get(0).getQuestions().get(0), paragraph.getTests().get(0).getQuestions().get(0));
        testControlWork(paragraphDTO.getControlWorks().get(0), paragraph.getControlWorks().get(0));
        testQuestion(paragraphDTO.getControlWorks().get(0).getQuestions().get(0), paragraph.getControlWorks().get(0).getQuestions().get(0));
    }

    private void testUnit(UnitDTO unitDTO, Unit unit) {
        Assertions.assertThat(unit).isNotNull();
        Assertions.assertThat(unitDTO).isNotNull();
        Assertions.assertThat(unitDTO.getClass().getDeclaredFields().length).isEqualTo(7);
        Assertions.assertThat(unitDTO.getId()).isEqualTo(unit.getId());
        Assertions.assertThat(unitDTO.getName()).isEqualTo(unit.getName());
    }

    private void testQuestion(QuestionDTO questionDTO, Question question) {
        Assertions.assertThat(question).isNotNull();
        Assertions.assertThat(questionDTO).isNotNull();
        Assertions.assertThat(questionDTO).isInstanceOf(QuestionDTO.class);
        Assertions.assertThat(questionDTO.getClass().getDeclaredFields().length).isEqualTo(6);
        Assertions.assertThat(questionDTO.getId()).isEqualTo(question.getId());
        Assertions.assertThat(questionDTO.getQuestion()).isEqualTo(question.getQuestion());
        Assertions.assertThat(questionDTO.getAnswers()).isEqualTo(question.getAnswers());
        Assertions.assertThat(questionDTO.getCorrectAnswer()).isEqualTo(question.getCorrectAnswer());
        Assertions.assertThat(questionDTO.getExplanation()).isEqualTo(question.getExplanation());
        Assertions.assertThat(questionDTO.getQuestionType()).isEqualTo(question.getQuestionType());
    }

    private void testClass(ClassDTO classDTO, Class aClass) {
        Assertions.assertThat(aClass).isNotNull();
        Assertions.assertThat(classDTO).isNotNull();
        Assertions.assertThat(classDTO).isInstanceOf(ClassDTO.class);
        Assertions.assertThat(classDTO.getClass().getDeclaredFields().length).isEqualTo(2);
        Assertions.assertThat(classDTO.getId()).isEqualTo(aClass.getId());
        Assertions.assertThat(classDTO.getName()).isEqualTo(aClass.getName());
    }

    private void testControlWork(ControlWorkDTO controlWorkDTO, ControlWork controlWork) {
        Assertions.assertThat(controlWork).isNotNull();
        Assertions.assertThat(controlWorkDTO).isNotNull();
        Assertions.assertThat(controlWorkDTO).isInstanceOf(ControlWorkDTO.class);
        Assertions.assertThat(controlWorkDTO.getClass().getDeclaredFields().length).isEqualTo(3);
        Assertions.assertThat(controlWorkDTO.getId()).isEqualTo(controlWork.getId());
        Assertions.assertThat(controlWorkDTO.getName()).isEqualTo(controlWork.getName());
    }

    private void testImage(ImageDTO imageDTO, Image image) {
        Assertions.assertThat(image).isNotNull();
        Assertions.assertThat(imageDTO).isNotNull();
        Assertions.assertThat(imageDTO).isInstanceOf(ImageDTO.class);
        Assertions.assertThat(imageDTO.getClass().getDeclaredFields().length).isEqualTo(3);
        Assertions.assertThat(imageDTO.getId()).isEqualTo(image.getId());
        Assertions.assertThat(imageDTO.getName()).isEqualTo(image.getName());
        Assertions.assertThat(imageDTO.getAlt()).isEqualTo(image.getAlt());
    }

    private void testParagraph(ParagraphDTO paragraphDTO, Paragraph paragraph) {
        Assertions.assertThat(paragraph).isNotNull();
        Assertions.assertThat(paragraphDTO).isNotNull();
        Assertions.assertThat(paragraphDTO).isInstanceOf(ParagraphDTO.class);
        Assertions.assertThat(paragraphDTO.getClass().getDeclaredFields().length).isEqualTo(6);
        Assertions.assertThat(paragraphDTO.getId()).isEqualTo(paragraph.getId());
        Assertions.assertThat(paragraphDTO.getName()).isEqualTo(paragraph.getName());
        Assertions.assertThat(paragraphDTO.getText()).isEqualTo(paragraph.getText());
    }

    private void testTest(TestDTO testDTO, education.education.models.Test test) {
        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(testDTO).isNotNull();
        Assertions.assertThat(testDTO).isInstanceOf(TestDTO.class);
        Assertions.assertThat(testDTO.getClass().getDeclaredFields().length).isEqualTo(4);
        Assertions.assertThat(testDTO.getId()).isEqualTo(test.getId());
        Assertions.assertThat(testDTO.getName()).isEqualTo(test.getName());
        Assertions.assertThat(testDTO.getName()).isEqualTo(test.getName());
        Assertions.assertThat(testDTO.isFinal()).isTrue();
    }

    private void testSubject(SubjectDTO subjectDTO, Subject subject) {
        Assertions.assertThat(subject).isNotNull();
        Assertions.assertThat(subjectDTO).isNotNull();
        Assertions.assertThat(subjectDTO).isInstanceOf(SubjectDTO.class);
        Assertions.assertThat(subjectDTO.getImage()).isInstanceOf(ImageDTO.class);
        Assertions.assertThat(subjectDTO.getClass().getDeclaredFields().length).isEqualTo(3);
        Assertions.assertThat(subjectDTO.getId()).isEqualTo(subject.getId());
        Assertions.assertThat(subjectDTO.getName()).isEqualTo(subject.getName());
    }
}
