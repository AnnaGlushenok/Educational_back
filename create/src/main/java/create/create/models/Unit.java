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
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class classEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Test test;

    @ManyToOne(fetch = FetchType.EAGER)
    private ControlWork controlWork;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Paragraph.class)
    @JoinTable(
            name = "units_paragraphs",
            joinColumns = @JoinColumn(name = "id_unit"),
            inverseJoinColumns = @JoinColumn(name = "id_paragraph")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Paragraph> paragraphs;
}
