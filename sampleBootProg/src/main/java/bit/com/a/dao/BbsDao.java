package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParamPage;

@Mapper
@Repository
public interface BbsDao {

	public List<BbsDto> getBbsPageList(BbsParamPage par);
	
	public int getBbsCount(BbsParamPage par);
	
	public BbsDto getBbs(int seq);
}
