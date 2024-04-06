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
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Class aClass;

    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Test test;

    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private ControlWork controlWork;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Paragraph.class)
    @JoinTable(
            name = "units_paragraphs",
            joinColumns = @JoinColumn(name = "id_unit"),
            inverseJoinColumns = @JoinColumn(name = "id_paragraph")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Paragraph> paragraphs;
}
