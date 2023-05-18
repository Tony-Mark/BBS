package com.xhu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xhu.entity.BbsRep;
import com.xhu.service.BbsRepService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 21:03
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/reply")
public class BbsRepController {
	@Resource
	private BbsRepService bbsRepService;
	
	/**
	*@description: TODO 获取该帖子所有的评论
	*@param: [tzid]
	*@return: com.alibaba.fastjson.JSONArray
	*/
	@GetMapping("/{tzid}")
	public JSONArray getAllByBbsId(@PathVariable Integer tzid){
		List<BbsRep> bbsReps = bbsRepService.getAllByBbsId(tzid);
		return JSONArray.parseArray(JSON.toJSONString(bbsReps));
	}
	
	/**
	*@description: TODO 添加对该帖子的评论
	*@param: [bbsRep, request]
	*@return: boolean
	*/
	@PostMapping
	public boolean saveRep(BbsRep bbsRep, HttpServletRequest request){
		bbsRep.setRepl(request.getSession().getAttribute("userName").toString());
		bbsRep.setRepDate(new Date());
		return bbsRepService.saveRep(bbsRep) > 0;
	}
	
	/**
	*@description: TODO 对评论该贴的用户进行回复
	*@param: [bbsRep, request]
	*@return: boolean
	*/
	@GetMapping
	public boolean saveRepToUser(BbsRep bbsRep, HttpServletRequest request){
		bbsRep.setRepl(request.getSession().getAttribute("userName").toString());
		bbsRep.setRepDate(new Date());
		/*对回复内容添加需要回复的用户*/
		String content0 = bbsRep.getContent();
		bbsRep.setContent("回复 "+request.getParameter("replyUser")+":"+content0);
		return bbsRepService.saveRep(bbsRep) > 0;
	}
}
