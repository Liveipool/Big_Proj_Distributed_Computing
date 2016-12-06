package hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import distributedServer.foodstore.config.databaseConfig;
import distributedServer.foodstore.model.Info;
import distributedServer.foodstore.service.InfoService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GreetingController {

    /*@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/

	/*@RequestMapping("/hello")
    public void sayHello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_CONFLICT);
        //response.getWriter().println("<h1>Hello ,!!!!</h1>");
        //response.getWriter().println("session=" + request.getSession(true).getId());
    }*/
	
	@RequestMapping("/")
    public String Mainpage(HttpServletRequest request, HttpServletResponse response) {
    	response.setContentType("text/html;charset=UTF-8");
        return "index";
    }
	
	@RequestMapping("/home")
    public String Home() {
        return "layouts/home";
    }
	
	@RequestMapping("/layouts/signup.html")
	public String signup() {
		return "layouts/signup";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public void signup(String inputNameSignup, String inputSexSignup, String inputPhoneSignup, String inputAddressSignup, String inputUsernameSignup, String inputPasswordSignup, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("name: " + inputNameSignup + " sex: " + inputSexSignup +  " phone: " + inputPhoneSignup + " address: " + inputAddressSignup + " username: " + inputUsernameSignup + " password: " + inputPasswordSignup); 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.register(databaseConfig.class);
    	ctx.refresh();
    	
    	InfoService fs = ctx.getBean(InfoService.class);
    	Info temp = fs.findOne(inputUsernameSignup);
    	if (temp != null) {
    		response.setStatus(HttpServletResponse.SC_CONFLICT);
    		return;
    	}
    	Info info = new Info(inputNameSignup);
    	info.setaddress(inputAddressSignup);
    	info.setPass(inputPasswordSignup);
    	info.setPhone(inputPhoneSignup);
    	info.setSex(inputSexSignup);
    	info.setUserName(inputUsernameSignup);
    	fs.create(info);
		response.sendRedirect("/home");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public void signin(String inputUsernameSignin, String inputPasswordSignin, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println(inputPasswordSignin + "   " + inputUsernameSignin); 
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.register(databaseConfig.class);
    	ctx.refresh();
    	
    	InfoService fs = ctx.getBean(InfoService.class);
    	Info temp = fs.findOne(inputUsernameSignin);
    	if (temp != null) {
    		System.out.println(temp.getPass());
    		if (temp.getPass().equals(inputPasswordSignin)) {
    			response.sendRedirect("/home");
    		} else {
    			response.setStatus(HttpServletResponse.SC_CONFLICT);
    			System.out.println("ok....");
    		}
    	} else {
    		response.setStatus(HttpServletResponse.SC_CONFLICT);
    		System.out.println("ok....2");
    	}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/pay")
	public String paystr(@RequestBody String str) {
		System.out.println(str); 
		return "layouts/home";
	}
	
	@RequestMapping("/pay.html")
	public String pay() {
		return "layouts/pay";
	}
	
	@RequestMapping("/store.html")
	public String store() {
		return "layouts/store";
	}
	
	@RequestMapping("/index.html")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/home.html")
	public String home() {
		return "layouts/home";
	}
	
}
