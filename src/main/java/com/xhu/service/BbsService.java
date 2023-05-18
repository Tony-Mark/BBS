package com.xhu.service;

import com.xhu.entity.Bbs;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: XJ
 * @CreateTime: 2023-05-16 16:07
 * @Description: TODO
 */
@Transactional
public interface BbsService {
	/**
	*@description: TODO 根据id查找帖子
	*@param: [id]
	*@return: com.xhu.entity.Bbs
	*/
	Bbs getById(Integer id);
	
	/**
	*@description: TODO 随机查找帖子
	*@param: [count]
	*@return: java.util.List<com.xhu.entity.Bbs>
	*/
	List<Bbs> getRandom(Integer count);
	
	/**
	*@description: TODO 保存新帖子
	*@param: [bbs]
	*@return: int
	*/
	int saveBbs(Bbs bbs);
}
