package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

//@Controller
@RestController	//controller + responseBody 
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/getId", method = {RequestMethod.POST, RequestMethod.GET})
	public String getId(String id) {
		System.out.println("MemberController getId()");
		
		int count = service.getId(id);
		if (count > 0) {
			return "NO";
		}else {
			return "YES";
		}
	}
	
	
	@RequestMapping(value = "/account", method = {RequestMethod.POST, RequestMethod.GET})
	public String account(MemberDto dto) {
		System.out.println("Membercontroller account()");
		
		boolean b = service.addmember(dto);
		if (b) {
			return "YES";
		}
		return "NO";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	public MemberDto login(String id, String pwd) {
		System.out.println("Membercontroller login()");
		
		MemberDto dto = service.login(new MemberDto(id, pwd, null, null, 0));
		return dto;
	}
	
}
