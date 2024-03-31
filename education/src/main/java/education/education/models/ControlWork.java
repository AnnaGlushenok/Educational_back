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
@Table(name = "controlWorks")
public class ControlWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(
            name = "control_works_questions",
            joinColumns = @JoinColumn(name = "id_controlWork"),
            inverseJoinColumns = @JoinColumn(name = "id_question"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Question> questions;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Paragraphs.class)
    @JoinTable(
            name = "paragraphs_controlWorks",
            joinColumns = @JoinColumn(name = "id_controlWork"),
            inverseJoinColumns = @JoinColumn(name = "id_paragraph"),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Paragraphs> paragraphs;
}
