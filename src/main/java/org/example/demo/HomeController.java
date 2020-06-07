import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(path = "/nesto")
public class HomeController
{
	@GetMapping("/nesto")
	public String home()
	{
		return "To je to";
	}
}