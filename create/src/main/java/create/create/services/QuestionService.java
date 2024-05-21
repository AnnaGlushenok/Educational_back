package create.create.services;

import create.create.dtos.QuestionDTO;
import create.create.mappers.QuestionMapper;
import create.create.models.Question;
import create.create.repositories.QuestionRepository;
import create.create.services.interfaces.QuestionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class implementing the {@link QuestionProvider} interface.
 */
@Service
public class QuestionService implements QuestionProvider {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * Overridden method to add a new Question entity based on data provided in the QuestionDTO.
     * This method performs the save operation of the Question entity to the database.
     *
     * @param questionDTO The QuestionDTO object containing data to create a new Question entity.
     * @return The Question object representing the newly created Question entity after saving it to the database.
     * @throws IllegalArgumentException if no Question exists with the given name.
     */
    @Override
    public QuestionDTO create(QuestionDTO questionDTO) throws IllegalArgumentException {
        if (questionRepository.existsByQuestion(questionDTO.getQuestion()))
            throw new IllegalArgumentException("Question with the same question already exists: " + questionDTO.getQuestion());

        return questionMapper.toDTO(questionRepository.save(questionMapper.toEntity(questionDTO)));
    }
//userDao.findUserById(userId)
//            .ifPresentOrElse(user -> {
//        userDao.updateUser(user.withPassword(password));
//    }, () -> {
//        throw new NoSuchElementException();
//    });

    /**
     * Overridden method to edit a new Question entity based on data provided in the QuestionDTO.
     * This method performs the save operation of the Question entity to the database.
     *
     * @param questionDTO The QuestionDTO object containing data to create a new Question entity.
     * @return The Question object representing the newly created Question entity after saving it to the database.
     * @throws IllegalArgumentException if no Question exists with the given id.
     */
    @Override
    public QuestionDTO update(QuestionDTO questionDTO) throws IllegalArgumentException {
        Question question = questionRepository.findById(questionDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Question not found id: " + questionDTO.getId()));
        Question entity = questionMapper.toEntity(questionDTO);
        question.setQuestion(entity.getQuestion());
        question.setAnswers(entity.getAnswers());
        question.setCorrectAnswer(entity.getCorrectAnswer());
        question.setExplanation(entity.getExplanation());
        question.setQuestionType(entity.getQuestionType());
        question.setParagraphs(entity.getParagraphs());
        return questionMapper.toDTO(questionRepository.save(question));
    }

    /**
     * Deletes a Question entity from the database by its identifier.
     *
     * @param id The identifier of the Question to delete.
     * @throws IllegalArgumentException if no Question exists with the given id.
     */
    @Override
    public void delete(int id) throws IllegalArgumentException {
        if (questionRepository.existsById(id))
            questionRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Question not found with id: " + id);
    }

    /**
     * Retrieves a QuestionDTO object by its ID.
     *
     * @param id The ID of the unit to retrieve.
     * @return The QuestionDTO object corresponding to the specified ID.
     * @throws RuntimeException if the unit with the given ID is not found.
     */
    @Override
    public QuestionDTO findById(int id) throws RuntimeException {
        return questionMapper.toDTO(questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id)));
    }
}
