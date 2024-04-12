package education.education.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paragraph_tests")
public class ParagraphTestFinal implements Serializable {
    @EmbeddedId
    private ParagraphTestFinalKey id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idParagraph")
    @JoinColumn(name = "id_paragraph")
    private Paragraph paragraph;

    @ManyToOne
    @MapsId("idTest")
    @JoinColumn(name = "id_test")
    private Test test;

    private boolean isFinal;
}
