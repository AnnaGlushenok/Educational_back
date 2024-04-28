package education.education.unit.services;

import education.education.dtos.ParagraphDTO;
import education.education.mappers.ParagraphMapper;
import education.education.models.Paragraph;
import education.education.repositories.ParagraphRepository;
import education.education.services.ParagraphService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ParagraphServiceTest {
    @Mock
    private ParagraphRepository paragraphRepository;

    @Mock
    private ParagraphMapper paragraphMapper;

    @InjectMocks
    private ParagraphService paragraphService;

    public ParagraphServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById_ExistingId_ReturnsParagraphDTO() {
        // Arrange
        int paragraphId = 1;
        Paragraph paragraph = new Paragraph(); // Create a mock Paragraph object
        paragraph.setId(paragraphId);

        ParagraphDTO expectedParagraphDTO = new ParagraphDTO(); // Create a mock ParagraphDTO object

        // Mocking repository method to return a paragraph when findById is called
        when(paragraphRepository.findById(paragraphId)).thenReturn(Optional.of(paragraph));

        // Mocking mapper method to return a DTO when toDTO is called
        when(paragraphMapper.toDTO(paragraph)).thenReturn(expectedParagraphDTO);

        // Act
        ParagraphDTO actualParagraphDTO = paragraphService.findById(paragraphId);

        // Assert
        assertNotNull(actualParagraphDTO);
        assertEquals(expectedParagraphDTO, actualParagraphDTO);
    }

    @Test
    public void testFindById_NonExistingId_ThrowsRuntimeException() {
        // Arrange
        int nonExistingParagraphId = 100;

        // Mocking repository method to return an empty Optional when findById is called
        when(paragraphRepository.findById(nonExistingParagraphId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> paragraphService.findById(nonExistingParagraphId));
    }
}
