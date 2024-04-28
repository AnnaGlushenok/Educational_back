package create.create.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "paragraphs")
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String text;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(
            name = "paragraphs_questions",
            joinColumns = @JoinColumn(name = "id_paragraph"),
            inverseJoinColumns = @JoinColumn(name = "id_question")
    )
    private List<Question> questions;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ControlWork.class)
    @JoinTable(
            name = "paragraphs_control_works",
            inverseJoinColumns = @JoinColumn(name = "id_control_work"),
            joinColumns = @JoinColumn(name = "id_paragraph")
    )
    private List<ControlWork> controlWorks;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Test.class)
    @JoinTable(
            name = "paragraphs_tests",
            inverseJoinColumns = @JoinColumn(name = "id_test"),
            joinColumns = @JoinColumn(name = "id_paragraph")
    )
    private List<Test> tests;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Unit.class)
    @JoinTable(
            name = "units_paragraphs",
            inverseJoinColumns = @JoinColumn(name = "id_unit"),
            joinColumns = @JoinColumn(name = "id_paragraph")
    )
    private List<Unit> units;
}
