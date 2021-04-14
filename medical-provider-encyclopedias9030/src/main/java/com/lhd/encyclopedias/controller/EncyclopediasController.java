package com.lhd.encyclopedias.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.encyclopedias.common.ResponseData;
import com.lhd.encyclopedias.common.TableVO;
import com.lhd.encyclopedias.entity.RealTimeInfo;
import com.lhd.encyclopedias.service.EncyclopediasService;
import com.lhd.encyclopedias.vo.NewsDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/4/9
 */
@RestController
@RequestMapping("/news")
public class EncyclopediasController {
    private EncyclopediasService encyclopediasService;
    @Autowired
    public EncyclopediasController(EncyclopediasService encyclopediasService){
        this.encyclopediasService=encyclopediasService;
    }

    @GetMapping("/list")
    public TableVO newsList(String type,
                            @RequestParam(value = "page",defaultValue = "1")Integer page,
                            @RequestParam(value = "limit",defaultValue = "20")Integer limit){
        PageHelper.startPage(page,limit);
        Map<String,Object> map=encyclopediasService.searchNewsList(type);
        PageInfo pageInfo=(PageInfo)map.get("pageInfo");
        List<RealTimeInfo> newsList=(List<RealTimeInfo>)map.get("list");
        return new TableVO(pageInfo,newsList);
    }
    @GetMapping("/detail/{infoId}")
    public ResponseData getNewsDetail(@PathVariable("infoId")Long infoId){
        NewsDetailVO newsDetailVO=encyclopediasService.getNewsDetail(infoId);
        return ResponseData.ok().putDataValue(newsDetailVO);
    }
}
