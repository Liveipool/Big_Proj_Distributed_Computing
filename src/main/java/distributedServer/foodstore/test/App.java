package distributedServer.foodstore.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import distributedServer.foodstore.service.*;
import distributedServer.foodstore.dao.*;
import distributedServer.foodstore.model.*;
import distributedServer.foodstore.config.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.register(databaseConfig.class);
    	ctx.refresh();
    	
    	InfoService fs = ctx.getBean(InfoService.class);
    	System.out.println( fs.toString() );
    	
    	Info foo = new Info("test");
    	foo.setaddress("aa");
    	foo.setMenu("aaa");
    	foo.setPass("sss");
    	foo.setPhone("dadsa");
    	foo.setSex("male");
    	foo.setUserName("aaaaa");
    	
    	fs.create(foo);
    	
    	for(Info f:fs.findAll()) {
    		System.out.println(f.getUsername());
    	}
    	
        System.out.println( "Hello World!" );
    }
}
