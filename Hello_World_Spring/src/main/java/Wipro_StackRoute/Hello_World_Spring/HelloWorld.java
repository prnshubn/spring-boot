package Wipro_StackRoute.Hello_World_Spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld
{
	@RequestMapping("/hello")
	public String helloworld()
	{
		return "Hello World!";
	}
}