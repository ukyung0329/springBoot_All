package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParamPage;

@Service
@Transactional
public class BbsService {

	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getBbsPageList(BbsParamPage par){
		return dao.getBbsPageList(par);
	}

	public int getBbsCount(BbsParamPage par) {
		int count = dao.getBbsCount(par);
		return count;
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
}
