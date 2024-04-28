package education.education.models;

import education.education.enums.QuestionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String answers;
    private String correctAnswer;
    private String explanation;
    private QuestionType questionType;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Test.class)
    @JoinTable(
            name = "tests_questions",
            joinColumns = @JoinColumn(name = "id_question"),
            inverseJoinColumns = @JoinColumn(name = "id_test")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Test> tests;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ControlWork.class)
    @JoinTable(
            name = "control_works_questions",
            inverseJoinColumns = @JoinColumn(name = "id_control_work"),
            joinColumns = @JoinColumn(name = "id_question")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ControlWork> controlWorks;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Paragraph.class)
    @JoinTable(
            name = "paragraphs_questions",
            inverseJoinColumns = @JoinColumn(name = "id_paragraph"),
            joinColumns = @JoinColumn(name = "id_question")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Paragraph> paragraphs;
}
