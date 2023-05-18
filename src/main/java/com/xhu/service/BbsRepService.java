package com.xhu.service;

import com.xhu.entity.BbsRep;
import com.xhu.mapper.BbsRepMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: XJ
 * @CreateTime: 2023-05-16 20:54
 * @Description: TODO
 */
@Transactional
public interface BbsRepService {
	/**
	 *@description: TODO 展示该帖子所有评论
	 *@param: [tzid]
	 *@return: java.util.List<com.xhu.entity.BbsRep>
	 */
	List<BbsRep> getAllByBbsId(Integer tzid);
	
	/**
	 *@description: TODO 添加对该帖子的评论或者回复
	 *@param: [bbsRep]
	 *@return: int
	 */
	int saveRep(BbsRep bbsRep);
	
}
