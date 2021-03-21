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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/19
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private GoodsService goodsService;
    @Autowired
    public GoodsController(GoodsService goodsService){
        this.goodsService=goodsService;
    }

    @GetMapping("/goods_list")
    public TableVO getGoodsList(String goodsName, String goodsDesc, String goodsType, String goodsPurpose, String goodsSource,
                                @RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        List<GoodsListVO> goodsList=goodsService.getGoodsList(goodsName, goodsDesc, goodsType, goodsPurpose, goodsSource);
        PageInfo pageInfo=new PageInfo<>(goodsList);
        return new TableVO(pageInfo,goodsList);
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
     * 改变商品状态，0下架，1上架
     *
     * @param goodsId
     * @param status
     * @return
     */
    @PutMapping("/change_status")
    public ResponseData changeGoodsStatus(Long goodsId,Byte status){
        boolean result=goodsService.changeGoodsStatus(goodsId, status);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }

}
