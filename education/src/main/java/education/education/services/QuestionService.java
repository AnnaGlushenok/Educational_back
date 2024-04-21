package education.education.services;

import education.education.dtos.QuestionDTO;
import education.education.mappers.QuestionMapper;
import education.education.models.Question;
import education.education.repositories.QuestionRepository;
import education.education.services.interfaces.DataProvider;
import education.education.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements DataProvider<QuestionDTO>, Mapper<QuestionDTO, Question> {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionDTO> findAll() {
        return listToDTO(questionRepository.findAll());
    }

    @Override
    public QuestionDTO findById(int id) {
        QuestionDTO question = toDTO(questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question could not be found id=" + id)));
        return question;
    }

    @Override
    public QuestionDTO toDTO(Question question) {
        return questionMapper.toDTO(question);
    }

    @Override
    public List<QuestionDTO> listToDTO(List<Question> list) {
        return questionMapper.listToDTO(list);
    }
}
