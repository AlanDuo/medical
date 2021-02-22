package com.lhd.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.shop.common.ResponseData;
import com.lhd.shop.common.TableVO;
import com.lhd.shop.entities.Goods;
import com.lhd.shop.service.GoodsService;
import com.lhd.shop.vo.GoodsListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2020/2/18
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    private GoodsService goodsService;
    @Autowired
    public ShopController(GoodsService goodsService){
        this.goodsService=goodsService;
    }

    @GetMapping("/index")
    public TableVO shopIndex(String searchName, Long userId,
                             @RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "page",defaultValue = "20") Integer limit){
        PageHelper.startPage(page,limit);
        List<GoodsListVO> goodsListVOList=goodsService.indexGoodsList(searchName,userId);
        PageInfo pageInfo=new PageInfo<>(goodsListVOList);
        return new TableVO(pageInfo,goodsListVOList);
    }
    @GetMapping("/goodsInfo/{goodsId}")
    public ResponseData goodsInfo(@PathVariable("goodsId") Long goodsId){
        Goods goods = goodsService.goodsInfo(goodsId);
        return ResponseData.ok().putDataValue(goods);
    }
}
