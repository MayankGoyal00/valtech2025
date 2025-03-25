package com.valtech.training.question.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.entities.QuestionWrapper;
import com.valtech.training.question.entities.Response;
import com.valtech.training.question.repos.QuestionRepo;
import com.valtech.training.question.vos.QuestionVO; 

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO getQuestion(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
		
	}
	
	@Override
	public List<QuestionVO> getAllQuestion(){
		return questionRepo.findAll().stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());
	}
	
	@Override
	public QuestionVO saveQuestion(QuestionVO q) {
		Question ques=q.to();
		return QuestionVO.from(questionRepo.save(ques));
	}
	
	@Override
	public QuestionVO updateQuestion(QuestionVO q, long id) {
		Question q1=questionRepo.getReferenceById(id);
		Question q2=q.to();
		q1.setOption1(q2.getOption1());
		q1.setOption2(q2.getOption2());
		q1.setOption3(q2.getOption3());
		q1.setOption4(q2.getOption4());
		q1.setCorrectAnswer(q2.getCorrectAnswer());
		q1.setTopic(q2.getTopic());
		return QuestionVO.from(q1);
		
	}
	
	@Override
	public List<QuestionVO> getQuestionByTopic(String topic){
		List<Question> ques= questionRepo.findByTopic(topic);
		return ques.stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());
	}

	@Override
	public List<Long> getQuestionForQuiz(String topic, long num) {
		return questionRepo.findRandomQuestionsByTopic(topic, num);
	}

	@Override
	public List<QuestionWrapper> getQuestionsFromId(List<Long> questionId){
		return questionRepo.findAllById(questionId).stream().map(q->new QuestionWrapper(
				q.getId(),
				q.getTitle(),
				q.getOption1(),
				q.getOption2(),
				q.getOption3(),
				q.getOption4()
				)).collect(Collectors.toList());
	}
	
	@Override
	public int getScoreForQuiz(List<Response> responses) {
		int score=0;
		
		for(Response response: responses) {
			Question question=questionRepo.findById(response.getId()).orElse(null);
			
			if(question != null && question.getCorrectAnswer().equals(response.getResponse())) {
				score++;
			}
		}
		return score;
	}

}
