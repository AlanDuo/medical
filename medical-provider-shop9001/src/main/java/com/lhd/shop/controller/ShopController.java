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
import java.util.Map;

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
                             @RequestParam(value = "limit",defaultValue = "20") Integer limit){
        PageHelper.startPage(page,limit);
        Map<String,Object> map=goodsService.indexGoodsList(searchName,userId);
        PageInfo pageInfo=(PageInfo) map.get("pageInfo");
        List<GoodsListVO> goodsList=(List<GoodsListVO>)map.get("list");
        return new TableVO(pageInfo,goodsList);
    }
    @GetMapping("/goodsInfo/{goodsId}")
    public ResponseData<Goods> goodsInfo(@PathVariable("goodsId") Long goodsId){
        Goods goods = goodsService.goodsInfo(goodsId);
        return ResponseData.ok().putDataValue(goods);
    }
}
