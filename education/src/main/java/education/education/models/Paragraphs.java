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
@Table(name = "paragraphs")
public class Paragraphs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String text;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(
            name = "paragraphs_questions",
            joinColumns = @JoinColumn(name = "id_paragraph"),
            inverseJoinColumns = @JoinColumn(name = "id_question"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Question> questions;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ControlWork.class)
    @JoinTable(
            name = "paragraphs_controlWorks",
            inverseJoinColumns = @JoinColumn(name = "id_controlWork"),
            joinColumns = @JoinColumn(name = "id_paragraph"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ControlWork> controlWorks;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Test.class)
    @JoinTable(
            name = "paragraphs_tests",
            inverseJoinColumns = @JoinColumn(name = "id_test"),
            joinColumns = @JoinColumn(name = "id_paragraph"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Test> tests;
}
