package com.himesh.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.himesh.data.entity.TrainEntity;
import com.himesh.data.repository.TrainRepository;

@Service
public class TrainService {
	private final TrainRepository trainRepository;
	
	public TrainService(TrainRepository trainRepository){
		this.trainRepository = trainRepository;
	}
	
	public List<TrainEntity> getAll(){
		return trainRepository.findAll();
	}
	
	public TrainEntity getById(int id) {
		return trainRepository.findById(id);
	}
	
	public void save(TrainEntity trainEntity) {
		trainRepository.save(trainEntity);
	}
	
	public void update(TrainEntity trainEntity) {
		trainRepository.update(trainEntity);
	}
	
	public void deleteById(int id) {
		trainRepository.deleteById(id);
	}
	
}
