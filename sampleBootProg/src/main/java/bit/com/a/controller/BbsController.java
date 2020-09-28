package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParamPage;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {

	@Autowired
	BbsService service;
	
	@RequestMapping(value="/getBbsPageList", method= {RequestMethod.GET, RequestMethod.POST})
	public List<BbsDto> getBbsPageList(BbsParamPage par){
		System.out.println("BbsController getBbsPageList");
		System.out.println(par.toString());
		
		int sn= par.getNowPage() -1; // 0, 1 , 2
		int start = sn * par.getRecordCountPerPage() + 1;	//1, 11, 21
		int end = (sn + 1) * par.getRecordCountPerPage();	//10, 20, 30
		
		par.setStart(start);
		par.setEnd(end);
		
		List<BbsDto> list = service.getBbsPageList(par);
		
		return list;
	}

	@RequestMapping(value="/getBbsCount", method= {RequestMethod.GET, RequestMethod.POST})
	public int getBbsCount(BbsParamPage par) {
		System.out.println("BbsController getBbsCount");
		
		return service.getBbsCount(par);
	}
	
	@RequestMapping(value="/getBbs", method= {RequestMethod.GET, RequestMethod.POST})
	public BbsDto getBbs(int seq) {
		System.out.println("BbsController getBbs()");
		
		return service.getBbs(seq); 
	}
}
