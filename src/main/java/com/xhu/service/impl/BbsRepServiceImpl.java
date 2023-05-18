package com.xhu.service.impl;

import com.xhu.entity.BbsRep;
import com.xhu.mapper.BbsRepMapper;
import com.xhu.service.BbsRepService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 21:00
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class BbsRepServiceImpl implements BbsRepService {
	@Resource
	private BbsRepMapper bbsRepMapper;
	
	/**
	 * @description: TODO 展示该帖子所有评论
	 * @param: [tzid]
	 * @return: java.util.List<com.xhu.entity.BbsRep>
	 */
	public List<BbsRep> getAllByBbsId(Integer tzid) {
		return bbsRepMapper.getAllByBbsId(tzid);
	}
	
	/**
	 * @description: TODO 添加对该帖子的评论或者回复
	 * @param: [bbsRep]
	 * @return: int
	 */
	public int saveRep(BbsRep bbsRep) {
		return bbsRepMapper.saveRep(bbsRep);
	}
	
}
