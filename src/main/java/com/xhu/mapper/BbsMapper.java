package com.xhu.mapper;

import com.xhu.entity.Bbs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: XJ
 * @CreateTime: 2023-05-16 15:46
 * @Description: TODO
 */
@Mapper
public interface BbsMapper {
	/**
	*@description: TODO 根据id获取帖子
	*@param: [id]
	*@return: com.xhu.entity.Bbs
	*/
	@Select("select * from bbs where id = #{id}")
	Bbs getById(Integer id);
	
	/**
	*@description: TODO 随机获取数据库中的帖子用于展示在主界面
	*@param: `[count]`
	*@return: java.util.List<com.xhu.entity.Bbs>
	*/
	@Select("SELECT sh1.id,title,content,auth,fbDate,pic,greatNo,dropNo,repNo FROM bbs AS sh1 " +
			"JOIN (SELECT ROUND(RAND() * ((SELECT MAX(id) FROM bbs)-(SELECT MIN(id) FROM bbs)) " +
			" + (SELECT MIN(id) FROM bbs) ) AS id) AS sh2 WHERE sh1.id>=sh2.id ORDER BY sh1.id LIMIT #{count}")
	List<Bbs> getRandom(Integer count);
	
	/**
	*@description: TODO 添加新帖子
	*@param: [bbs]
	*@return: int
	*/
	@Insert("insert into bbs (title,content,auth,pic,greatNo,dropNo,repNo,fbDate) values(#{title},#{content},#{auth},#{pic},0,0,0,#{fbDate})")
	int saveBbs(Bbs bbs);
}
