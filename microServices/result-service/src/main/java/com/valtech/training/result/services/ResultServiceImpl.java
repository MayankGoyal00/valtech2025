package com.valtech.training.result.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.result.entities.Result;
import com.valtech.training.result.repos.ResultRepo;
import com.valtech.training.result.vos.ResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ResultServiceImpl implements ResultService{

	@Autowired
	private ResultRepo resultRepo;
	
	@Override
    public ResultVO saveResult(Long quizId, String name, int score) {
        Result result = new Result(quizId, name, score);
        return ResultVO.from(resultRepo.save(result));
    }
    @Override
    public List<ResultVO> getResultsByUser(String name) {
        return resultRepo.findByName(name)
                .stream()
                .map(ResultVO::from)
                .collect(Collectors.toList());
    }
    @Override
    public List<ResultVO> getResultsByQuiz(Long quizId) {
        return resultRepo.findByQuizId(quizId)
                .stream()
                .map(ResultVO::from)
                .collect(Collectors.toList());
    }
}
