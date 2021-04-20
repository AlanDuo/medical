package com.lhd.manager.controller;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.common.ResponseData;
import com.lhd.manager.common.TableVO;
import com.lhd.manager.dto.NewsAddDTO;
import com.lhd.manager.entity.RealTimeInfo;
import com.lhd.manager.service.NewsService;
import com.lhd.manager.vo.NewsListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/29
 */
@RestController
@RequestMapping("/news")
//@CrossOrigin
public class NewsController {
    private static final Logger LOGGER=LoggerFactory.getLogger(NewsController.class);
    private NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService){
        this.newsService=newsService;
    }

    @PostMapping("/add")
    public ResponseData newAdd(@RequestBody NewsAddDTO newsAddDTO){
        LOGGER.info(newsAddDTO.getInfoContent());
        boolean result=newsService.addNews(newsAddDTO);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }
    @GetMapping("/list")
    public TableVO newsListByPage(String title, String author, String type, @RequestParam(value = "status",defaultValue = "1") Byte status,
                            String start, String end,
                            @RequestParam(value = "page",defaultValue = "1") Integer page,
                            @RequestParam(value = "limit",defaultValue = "20") Integer limit){
        PageHelper.startPage(page,limit);
        Date startTime=null;
        if(null!=start && !"".equals(start.trim())) {
            startTime = Convert.toDate(start);
        }
        Date endTime=null;
        if(null!=end && !"".equals(end.trim())) {
            endTime = Convert.toDate(end);
        }
        Map<String,Object> newsMap = newsService.getNewsList(title,author,type,status,startTime,endTime);
        PageInfo pageInfo=(PageInfo)newsMap.get("pageInfo");
        return new TableVO(pageInfo,(List<NewsListVO>)newsMap.get("list"));
    }
    @GetMapping("/info/{infoId}")
    public ResponseData newsInfo(@PathVariable("infoId")Long infoId){
        RealTimeInfo info=newsService.getNewsInfo(infoId);
        return ResponseData.ok().putDataValue(info);
    }
    @PutMapping("/change_status")
    public ResponseData changeNewsStatus(@RequestParam Long newsId,@RequestParam Byte status){
        boolean result=newsService.changeNewsStatus(newsId, status);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }

}
