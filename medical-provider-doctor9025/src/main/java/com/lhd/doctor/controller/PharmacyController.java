package com.lhd.doctor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.doctor.common.ResponseData;
import com.lhd.doctor.common.TableVO;
import com.lhd.doctor.dto.UserDTO;
import com.lhd.doctor.handler.LoginUserHolder;
import com.lhd.doctor.service.PharmacyService;
import com.lhd.doctor.vo.GoodsInfoVO;
import com.lhd.doctor.vo.GoodsListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/4/16
 */
@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {
    private PharmacyService pharmacyService;
    private LoginUserHolder loginUserHolder;
    @Autowired
    public PharmacyController(PharmacyService pharmacyService,LoginUserHolder loginUserHolder){
        this.pharmacyService=pharmacyService;
        this.loginUserHolder=loginUserHolder;
    }

    @GetMapping("/list")
    public TableVO pharmacyList(String searchName,
                                @RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "20")Integer limit){
        PageHelper.startPage(page,limit);
        Map<String,Object> map=pharmacyService.pharmacyList(searchName);
        PageInfo pageInfo=(PageInfo)map.get("pageInfo");
        List<GoodsListVO> goodsList=(List<GoodsListVO>)map.get("list");
        return new TableVO(pageInfo,goodsList);
    }
    @GetMapping("/info/{goodsId}")
    public ResponseData pharmacyInfo(@PathVariable("goodsId") Long goodsId){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        Long doctorId=userDTO.getId();
        GoodsInfoVO goodsInfo=pharmacyService.getPharmacyDetail(goodsId,doctorId);
        return ResponseData.ok().putDataValue(goodsInfo);
    }
    @PostMapping("/agree_goods")
    public ResponseData agreeGoods(Long goodsId,Byte status){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        Long doctorId=userDTO.getId();
        pharmacyService.agreeGoods(goodsId,doctorId,status);
        return ResponseData.ok();
    }

}
