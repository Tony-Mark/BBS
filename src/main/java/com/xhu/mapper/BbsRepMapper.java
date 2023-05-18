package com.xhu.mapper;

import com.xhu.entity.BbsRep;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: XJ
 * @CreateTime: 2023-05-16 20:45
 * @Description: TODO
 */
@Mapper
public interface BbsRepMapper {
	/**
	*@description: TODO 展示该帖子所有评论
	*@param: [tzid]
	*@return: java.util.List<com.xhu.entity.BbsRep>
	*/
	@Select("SELECT id,tzid,content,repl,repDate,clickNo FROM bbsrep WHERE tzid = #{tzid} ORDER BY repDate DESC")
	List<BbsRep> getAllByBbsId(Integer tzid);
	/**
	*@description: TODO 添加对该帖子的评论或者是回复
	*@param: [bbsRep]
	*@return: int
	*/
	@Insert("INSERT INTO bbsrep (tzid,content,repl,repDate,clickNo) values(#{tzid},#{content},#{repl},#{repDate},0)")
	int saveRep(BbsRep bbsRep);
	
}
