package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberDao dao;
	
	public int getId(String id) {
		return dao.getId(id);
	}
	
	public boolean addmember(MemberDto dto) {
		int len = dao.addmember(dto);
		return len>0?true:false;
	}
	
	public MemberDto login(MemberDto dto) {
		MemberDto mem = dao.login(dto);
		return mem;
	}
}
