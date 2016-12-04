package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    }

	@RequestMapping("/hello")
    public void sayHello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello ,!!!!</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }*/
	
	@RequestMapping("/")
    public String Mainpage() {
        return "index";
    }
	
	@RequestMapping("/layouts/signup.html")
	public String signup() {
		return "layouts/signup";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public String signup(String inputNameSignup, String inputSexSignup, String inputPhoneSignup, String inputAddressSignup, String inputUsernameSignup, String inputPasswordSignup) {
		System.out.println("name: " + inputNameSignup + "sex: " + inputSexSignup +  "phone: " + inputPhoneSignup + "address: " + inputAddressSignup + "username: " + inputUsernameSignup + "password: " + inputPasswordSignup); 
		return "layouts/home";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public String signin(String inputUsernameSignin, String inputPasswordSignin) {
		System.out.println(inputPasswordSignin + "   " + inputUsernameSignin); 
		return "layouts/home";
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
