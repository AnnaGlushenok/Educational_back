package education.education.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ParagraphTestFinalKey implements Serializable {
    @Column(name = "id_paragraph")
    int idParagraph;
    @Column(name = "id_test")
    int idTest;
}
