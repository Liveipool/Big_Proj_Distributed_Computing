package distributedServer.foodstore.dao;

import org.springframework.stereotype.Repository;
import distributedServer.foodstore.model.Info;

@Repository
public class InfoDaoImpl extends AbstractJpaDAO<Info> implements InfoDao {
	
	public InfoDaoImpl() {
        super();

        setClazz(Info.class);
    }

}
