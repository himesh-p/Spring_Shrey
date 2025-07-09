package com.himesh.data.repository;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.himesh.data.entity.TrainEntity;

@Repository
public class TrainRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public TrainRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final RowMapper<TrainEntity> rowMapper = (rs , rowNum) -> {
		TrainEntity trainEntity = new TrainEntity();
		trainEntity.setId(rs.getInt("id"));
		trainEntity.setName(rs.getString("name"));
		trainEntity.setOrigin(rs.getString("origin"));
		trainEntity.setDestination(rs.getString("destination"));
		return trainEntity;
	};
	
	public List<TrainEntity> findAll(){
		return jdbcTemplate.query("SELECT * FROM trains", rowMapper);
	}
	
	public TrainEntity findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM trains WHERE id = ?", rowMapper, id);
	}
	
	public void save(TrainEntity trainEntity) {
		jdbcTemplate.update("INSERT INTO trains (name , origin , destination) VALUES (? , ? , ?)", trainEntity.getName() , trainEntity.getOrigin() , trainEntity.getDestination());
	}
	
	public void update(TrainEntity trainEntity) {
		jdbcTemplate.update("UPDATE trains SET name = ? , origin = ? , destination = ? WHERE id = ?" , trainEntity.getName() , trainEntity.getOrigin() , trainEntity.getDestination() , trainEntity.getId());
	}
	
	public void deleteById(int id) {
		jdbcTemplate.update("DELETE FROM trains WHERE id = ?" , id);
	}
	
}
