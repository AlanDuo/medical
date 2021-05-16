package com.lhd.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.common.ResponseData;
import com.lhd.manager.common.TableVO;
import com.lhd.manager.dto.GoodsAddDTO;
import com.lhd.manager.entity.Goods;
import com.lhd.manager.service.GoodsService;
import com.lhd.manager.vo.GoodsInfoVO;
import com.lhd.manager.vo.GoodsListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/19
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger LOGGER=LoggerFactory.getLogger(GoodsController.class);
    private GoodsService goodsService;
    @Autowired
    public GoodsController(GoodsService goodsService){
        this.goodsService=goodsService;
    }

    @GetMapping("/goods_list")
    public TableVO getGoodsList(String goodsName, String goodsDesc, String goodsType, String goodsPurpose, String goodsSource,Byte status,
                                @RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        Map<String,Object> map=goodsService.getGoodsList(goodsName, goodsDesc, goodsType, goodsPurpose, goodsSource,status);
        PageInfo pageInfo=(PageInfo) map.get("pageInfo");
        return new TableVO(pageInfo,(List<GoodsListVO>)map.get("list"));
    }

    @GetMapping("/goods_info/{goodsId}")
    public ResponseData getGoodsInfo(@PathVariable("goodsId")Long goodsId){
        GoodsInfoVO goodsInfoVO=goodsService.getGoodsInfo(goodsId);
        return ResponseData.ok().putDataValue(goodsInfoVO);
    }
    /**
     * 收购商品
     *
     * @param goodsAddDTO
     * @return
     */
    @PostMapping("/goods_add")
    public ResponseData goodsAdd(@RequestBody GoodsAddDTO goodsAddDTO){
        boolean result=goodsService.addGoods(goodsAddDTO);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }

    /**
     * 发布商品
     *
     * @param goodsId
     * @param price
     * @return
     */
    @PostMapping("/publish")
    public ResponseData goodsPublish(Long goodsId,String price){
        System.out.println("goodsId: "+goodsId+",price: "+price);
        boolean result=goodsService.publishGoods(goodsId,price);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }

    /**
     * 改变商品状态，0下架，1上架
     *
     * @param goodsId
     * @param status
     * @return
     */
    @PutMapping("/change_status")
    public ResponseData changeGoodsStatus(@RequestParam Long goodsId,@RequestParam Byte status){
        LOGGER.info(goodsId+","+status);
        boolean result=goodsService.changeGoodsStatus(goodsId, status);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }

}
