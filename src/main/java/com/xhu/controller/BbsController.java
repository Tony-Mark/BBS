package com.xhu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhu.entity.Bbs;
import com.xhu.service.BbsService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 16:19
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/bbs")
public class BbsController {
	@Resource
	private BbsService bbsService;
	
	@Value("${image.path}")
	private String filePath;
	
	@GetMapping("/{id}")
	public JSONArray getById( @PathVariable Integer id){
		JSONObject jsonObject = (JSONObject) JSONObject.toJSON(bbsService.getById(id));
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		return jsonArray;
	}
	
	@PostMapping
	public boolean saveBbs(HttpServletRequest request, @RequestParam("pic")MultipartFile[] file){
		Bbs bbs = new Bbs();
		bbs.setAuth(request.getParameter("auth"));
		bbs.setTitle(request.getParameter("title"));
		bbs.setContent(request.getParameter("content"));
		bbs.setFbDate(new Date());
		/*存在上传的文件*/
		if (file.length > 0){
			/*用于保存多个文件名*/
			StringBuilder picValue = new StringBuilder();
			/*默认多个文件上传*/
			for (MultipartFile f:file){
				String originalFilename = f.getOriginalFilename();
				/*添加文件名前的临时名*/
				String temp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
				String fileName ="bbs/"+ temp + "_" + originalFilename;
				/*暂时保存文件名*/
				picValue.append(fileName).append("*");
				/*写文件*/
				try {
					f.transferTo(new File(filePath+fileName));
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			/*去除最后一个*,并添加进实体类*/
			bbs.setPic(picValue.substring(0, picValue.length()-1));
		}
		return bbsService.saveBbs(bbs) > 0;
	}
	
	@GetMapping
	public JSONArray getRandom(@RequestParam("count") Integer count){
		List<Bbs> bbsList = bbsService.getRandom(count);
		return JSONArray.parseArray(JSON.toJSONString(bbsList));
	}
}
