package education.education.models;

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
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean isFinal;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(
            name = "tests_questions",
            joinColumns = @JoinColumn(name = "id_test"),
            inverseJoinColumns = @JoinColumn(name = "id_question")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Question> questions;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Unit> units;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Paragraph.class)
    @JoinTable(
            name = "paragraphs_tests",
            joinColumns = @JoinColumn(name = "id_test"),
            inverseJoinColumns = @JoinColumn(name = "id_paragraph")
    )
    private List<Paragraph> paragraphs;
}
