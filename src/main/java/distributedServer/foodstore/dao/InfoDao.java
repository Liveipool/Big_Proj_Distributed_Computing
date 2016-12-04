package distributedServer.foodstore.dao;

import java.util.List;

import distributedServer.foodstore.model.Info;

public interface InfoDao {
	
	Info findOne(String name);
	
	List<Info> findAll();
	
	void create(Info entity);
	
	Info update(Info entity);
	
	void delete(Info entity);
}
