package create.create;

import create.create.dtos.*;
import create.create.enums.QuestionType;
import create.create.mappers.*;
import create.create.models.Class;
import create.create.models.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MappersToEntityTest {
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

    ImageDTO imageDTO = ImageDTO.builder().name("i1").alt("alt").build();
    ClassDTO classDTO = ClassDTO.builder().name("class").build();
    SubjectDTO subjectDTO = SubjectDTO.builder().name("s").image(imageDTO).build();
    QuestionDTO questionDTO = QuestionDTO.builder().question("q").answers("a").correctAnswer("a").explanation("e").questionType(QuestionType.TEXT).build();
    ControlWorkDTO controlWorkDTO = ControlWorkDTO.builder().name("c1")
            .questions(new ArrayList<>() {{
                add(questionDTO);
            }})
            .build();
    TestDTO testDTO = TestDTO.builder().name("t")
            .questions(new ArrayList<>() {{
                add(questionDTO);
            }})
            .isFinal(true)
            .build();
    ParagraphDTO paragraphDTO = ParagraphDTO.builder().name("p1").text("text")
            .questions(new ArrayList<>() {{
                add(questionDTO);
            }})
            .tests(new ArrayList<>() {{
                add(testDTO);
            }})
            .controlWorks(new ArrayList<>() {{
                add(controlWorkDTO);
            }})
            .build();
    UnitDTO unitDTO = UnitDTO.builder().name("u")
            .subject(subjectDTO)
            .classEntity(classDTO)
            .test(testDTO)
            .controlWork(controlWorkDTO)
            .paragraphs(new ArrayList<>() {{
                add(paragraphDTO);
            }})
            .build();

    @Test
    @DisplayName("Map class to entity")
    void classToDTO() {
        Class aClass = classMapper.toEntity(classDTO);
        testClass(aClass, classDTO);
    }

    @Test
    @DisplayName("Map control work to entity")
    void controlWorkToDTO() {
        ControlWork controlWork = controlWorkMapper.toEntity(controlWorkDTO);
        Question questionDTO = controlWork.getQuestions().get(0);
        QuestionDTO question = controlWorkDTO.getQuestions().get(0);

        testControlWork(controlWork, controlWorkDTO);
        testQuestion(questionDTO, question);
    }

    @Test
    @DisplayName("Map image to entity")
    void imageToDTO() {
        Image image = imageMapper.toEntity(imageDTO);
        testImage(image, imageDTO);
    }

    @Test
    @DisplayName("Map paragraph to entity")
    void paragraphToDTO() {
        Paragraph paragraph = paragraphMapper.toEntity(paragraphDTO);
        Question question = paragraph.getQuestions().get(0);
        QuestionDTO questionDTO = paragraphDTO.getQuestions().get(0);
        TestDTO testDTO = paragraphDTO.getTests().get(0);
        create.create.models.Test test = paragraph.getTests().get(0);
        ControlWork controlWork = paragraph.getControlWorks().get(0);
        ControlWorkDTO controlWorkDTO = paragraphDTO.getControlWorks().get(0);

        testParagraph(paragraph, paragraphDTO);
        testQuestion(question, questionDTO);
        testTest(test, testDTO);
        question = test.getQuestions().get(0);
        questionDTO = testDTO.getQuestions().get(0);
        testQuestion(question, questionDTO);
        testControlWork(controlWork, controlWorkDTO);
        question = controlWork.getQuestions().get(0);
        questionDTO = controlWorkDTO.getQuestions().get(0);
        testQuestion(question, questionDTO);
    }

    @Test
    @DisplayName("Map question to entity")
    void questionToDTO() {
        Question question = questionMapper.toEntity(questionDTO);
        testQuestion(question, questionDTO);
    }

    @Test
    @DisplayName("Map subject to entity")
    void mapSubjectToDTO() {
        Subject subject = subjectMapper.toEntity(subjectDTO);
        testSubject(subject, subjectDTO);
    }

    @Test
    @DisplayName("Map test to entity")
    void testToDTO() {
        create.create.models.Test test = testMapper.toEntity(testDTO);
        Question question = test.getQuestions().get(0);
        QuestionDTO questionDTO = testDTO.getQuestions().get(0);
        testTest(test, testDTO);
        testQuestion(question, questionDTO);
    }

    @Test
    @DisplayName("Map unit to entity")
    void mapUnitToDTO() {
        Unit unit = unitMapper.toEntity(unitDTO);

        testUnit(unit, unitDTO);
        testSubject(unit.getSubject(), unitDTO.getSubject());
        testImage(unit.getSubject().getImage(), unitDTO.getSubject().getImage());
        testClass(unit.getClassEntity(), unitDTO.getClassEntity());
        testTest(unit.getTest(), unitDTO.getTest());
        testQuestion(unit.getTest().getQuestions().get(0), unitDTO.getTest().getQuestions().get(0));
        testControlWork(unit.getControlWork(), unitDTO.getControlWork());
        testQuestion(unit.getControlWork().getQuestions().get(0), unitDTO.getControlWork().getQuestions().get(0));

        Paragraph paragraph = unit.getParagraphs().get(0);
        ParagraphDTO paragraphDTO = unitDTO.getParagraphs().get(0);
        testParagraph(paragraph, paragraphDTO);
        testQuestion(paragraph.getQuestions().get(0), paragraphDTO.getQuestions().get(0));

        testTest(paragraph.getTests().get(0), paragraphDTO.getTests().get(0));
        testQuestion(paragraph.getTests().get(0).getQuestions().get(0), paragraphDTO.getTests().get(0).getQuestions().get(0));
        testControlWork(paragraph.getControlWorks().get(0), paragraphDTO.getControlWorks().get(0));
        testQuestion(paragraph.getControlWorks().get(0).getQuestions().get(0), paragraphDTO.getControlWorks().get(0).getQuestions().get(0));
    }

    private void testUnit(Unit unit, UnitDTO unitDTO) {
        Assertions.assertThat(unit).isNotNull();
        Assertions.assertThat(unitDTO).isNotNull();
        Assertions.assertThat(unitDTO.getClass().getDeclaredFields().length).isEqualTo(7);
        Assertions.assertThat(unitDTO.getId()).isEqualTo(unit.getId());
        Assertions.assertThat(unitDTO.getName()).isEqualTo(unit.getName());
    }

    private void testQuestion(Question question, QuestionDTO questionDTO) {
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

    private void testClass(Class aClass, ClassDTO classDTO) {
        Assertions.assertThat(aClass).isNotNull();
        Assertions.assertThat(classDTO).isNotNull();
        Assertions.assertThat(classDTO).isInstanceOf(ClassDTO.class);
        Assertions.assertThat(classDTO.getClass().getDeclaredFields().length).isEqualTo(2);
        Assertions.assertThat(classDTO.getId()).isEqualTo(aClass.getId());
        Assertions.assertThat(classDTO.getName()).isEqualTo(aClass.getName());
    }

    private void testControlWork(ControlWork controlWork, ControlWorkDTO controlWorkDTO) {
        Assertions.assertThat(controlWork).isNotNull();
        Assertions.assertThat(controlWorkDTO).isNotNull();
        Assertions.assertThat(controlWorkDTO).isInstanceOf(ControlWorkDTO.class);
        Assertions.assertThat(controlWorkDTO.getClass().getDeclaredFields().length).isEqualTo(3);
        Assertions.assertThat(controlWorkDTO.getId()).isEqualTo(controlWork.getId());
        Assertions.assertThat(controlWorkDTO.getName()).isEqualTo(controlWork.getName());
    }

    private void testImage(Image image, ImageDTO imageDTO) {
        Assertions.assertThat(image).isNotNull();
        Assertions.assertThat(imageDTO).isNotNull();
        Assertions.assertThat(imageDTO).isInstanceOf(ImageDTO.class);
        Assertions.assertThat(imageDTO.getClass().getDeclaredFields().length).isEqualTo(3);
        Assertions.assertThat(imageDTO.getId()).isEqualTo(image.getId());
        Assertions.assertThat(imageDTO.getName()).isEqualTo(image.getName());
        Assertions.assertThat(imageDTO.getAlt()).isEqualTo(image.getAlt());
    }

    private void testParagraph(Paragraph paragraph, ParagraphDTO paragraphDTO) {
        Assertions.assertThat(paragraph).isNotNull();
        Assertions.assertThat(paragraphDTO).isNotNull();
        Assertions.assertThat(paragraphDTO).isInstanceOf(ParagraphDTO.class);
        Assertions.assertThat(paragraphDTO.getClass().getDeclaredFields().length).isEqualTo(6);
        Assertions.assertThat(paragraphDTO.getId()).isEqualTo(paragraph.getId());
        Assertions.assertThat(paragraphDTO.getName()).isEqualTo(paragraph.getName());
        Assertions.assertThat(paragraphDTO.getText()).isEqualTo(paragraph.getText());
    }

    private void testTest(create.create.models.Test test, TestDTO testDTO) {
        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(testDTO).isNotNull();
        Assertions.assertThat(testDTO).isInstanceOf(TestDTO.class);
        Assertions.assertThat(testDTO.getClass().getDeclaredFields().length).isEqualTo(4);
        Assertions.assertThat(testDTO.getId()).isEqualTo(test.getId());
        Assertions.assertThat(testDTO.getName()).isEqualTo(test.getName());
        Assertions.assertThat(testDTO.getName()).isEqualTo(test.getName());
        Assertions.assertThat(testDTO.isFinal()).isTrue();
    }

    private void testSubject(Subject subject, SubjectDTO subjectDTO) {
        Assertions.assertThat(subject).isNotNull();
        Assertions.assertThat(subjectDTO).isNotNull();
        Assertions.assertThat(subjectDTO).isInstanceOf(SubjectDTO.class);
        Assertions.assertThat(subjectDTO.getImage()).isInstanceOf(ImageDTO.class);
        Assertions.assertThat(subjectDTO.getClass().getDeclaredFields().length).isEqualTo(3);
        Assertions.assertThat(subjectDTO.getId()).isEqualTo(subject.getId());
        Assertions.assertThat(subjectDTO.getName()).isEqualTo(subject.getName());
    }
}
