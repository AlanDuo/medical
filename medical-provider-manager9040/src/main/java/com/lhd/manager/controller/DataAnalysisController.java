package com.lhd.manager.controller;

import com.lhd.manager.common.ResponseData;
import com.lhd.manager.service.DataAnalysisService;
import com.lhd.manager.vo.OrderSalesAndQuantityVO;
import com.lhd.manager.vo.ProfitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author alan
 * @date 2021/5/16
 */
@RestController
@RequestMapping("/analysis")
public class DataAnalysisController {
    private DataAnalysisService dataAnalysisService;
    @Autowired
    public DataAnalysisController(DataAnalysisService dataAnalysisService){
        this.dataAnalysisService=dataAnalysisService;
    }

    /**
     * 该年每个月的销售额与订单数量
     *
     * @param year
     * @return
     */
    @GetMapping("/monthlySales/{year}")
    public ResponseData eachYearSales(@PathVariable("year")Integer year){
        Map<Integer, OrderSalesAndQuantityVO> map=dataAnalysisService.monthlySales(year);
        return ResponseData.ok().putDataValue(map);
    }

    /**
     * 该年每月利润
     *
     * @param year
     * @return
     */
    @GetMapping("/monthProfit/{year}")
    public ResponseData monthProfit(@PathVariable("year")Integer year){
        Map<Integer, ProfitVO> map=dataAnalysisService.getEachMonthProfit(year);
        return ResponseData.ok().putDataValue(map);
    }
}
