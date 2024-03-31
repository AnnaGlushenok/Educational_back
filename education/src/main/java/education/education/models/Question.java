package education.education.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String answers;
    private String correctAnswer;
    private String explanation;
//    private String marker; чё это???

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Test.class)
    @JoinTable(
            name = "tests_questions",
            joinColumns = @JoinColumn(name = "id_question"),
            inverseJoinColumns = @JoinColumn(name = "id_test"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Test> tests;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ControlWork.class)
    @JoinTable(
            name = "control_works_questions",
            inverseJoinColumns = @JoinColumn(name = "id_controlWork"),
            joinColumns = @JoinColumn(name = "id_question"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ControlWork> controlWorks;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Paragraphs.class)
    @JoinTable(
            name = "paragraphs_questions",
            inverseJoinColumns = @JoinColumn(name = "id_paragraph"),
            joinColumns = @JoinColumn(name = "id_question"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Paragraphs> paragraphs;
}
