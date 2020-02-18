package rs.xpath;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class XpathReaderController {
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		return "home";
	}

	@RequestMapping("/loadurl")
	public String loadUrl(@RequestParam("enteredurl") String enteredurl, Map<String, Object> model) {
		model.put("enteredurl", enteredurl);
		return "home";
	}

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		return "login";
	}

}
