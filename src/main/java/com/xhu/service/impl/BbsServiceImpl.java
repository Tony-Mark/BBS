package com.xhu.service.impl;

import com.xhu.entity.Bbs;
import com.xhu.mapper.BbsMapper;
import com.xhu.service.BbsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 16:15
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class BbsServiceImpl implements BbsService {
	@Resource
	private BbsMapper bbsMapper;
	
	/**
	 * @description: TODO 根据id查找帖子
	 * @param: [id]
	 * @return: com.xhu.entity.Bbs
	 */
	public Bbs getById(Integer id) {
		return bbsMapper.getById(id);
	}
	
	/**
	 * @description: TODO 随机查找帖子
	 * @param: [count]
	 * @return: java.util.List<com.xhu.entity.Bbs>
	 */
	public List<Bbs> getRandom(Integer count) {
		return bbsMapper.getRandom(count);
	}
	
	/**
	 * @description: TODO 保存新帖子
	 * @param: [bbs]
	 * @return: int
	 */
	public int saveBbs(Bbs bbs) {
		return bbsMapper.saveBbs(bbs);
	}
}
