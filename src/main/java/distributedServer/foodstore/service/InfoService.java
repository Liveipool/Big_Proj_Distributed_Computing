package distributedServer.foodstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import distributedServer.foodstore.dao.InfoDao;
import distributedServer.foodstore.model.Info;

@Service
@Transactional
public class InfoService {
	
	@Autowired
	private InfoDao dao;
	
	public InfoService() {
		super();
	}
	
	public void create(final Info entity) {
		dao.create(entity);
	}
	
	public Info findOne(String name) {
		return dao.findOne(name);
	}
	
	public List<Info> findAll() {
        return dao.findAll();
    }
	
	public Info update(final Info entity) {
		return dao.update(entity);
	}

}
