package create.create.models;

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
@Table(name = "control_works")
public class ControlWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(
            name = "control_works_questions",
            joinColumns = @JoinColumn(name = "id_control_work"),
            inverseJoinColumns = @JoinColumn(name = "id_question")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Question> questions;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Paragraph.class)
    @JoinTable(
            name = "paragraphs_control_works",
            joinColumns = @JoinColumn(name = "id_control_work"),
            inverseJoinColumns = @JoinColumn(name = "id_paragraph")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Paragraph> paragraphs;

    @OneToMany(mappedBy = "controlWork", cascade = CascadeType.ALL)
    private List<Unit> units;
}
