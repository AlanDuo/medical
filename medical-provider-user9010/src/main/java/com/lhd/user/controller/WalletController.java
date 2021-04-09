package com.lhd.user.controller;

import com.lhd.user.common.ResponseData;
import com.lhd.user.entities.Bill;
import com.lhd.user.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/24
 */
@RestController
@RequestMapping("wallet")
public class WalletController {
    private WalletService walletService;
    @Autowired
    public WalletController(WalletService walletService){
        this.walletService=walletService;
    }

    @GetMapping("/balance")
    public ResponseData userWallet(Long userId){

        BigDecimal wallet=walletService.getUserWallet(userId);
        return ResponseData.ok().putDataValue(wallet);
    }
    @GetMapping("/bill")
    public ResponseData userBill(Long userId){
        List<Bill> billList=walletService.getUserBill(userId);
        return ResponseData.ok().putDataValue(billList);
    }
    @PostMapping("/chargeWallet")
    public ResponseData chargeWallet(Long userId,BigDecimal money,String purpose){
        walletService.chargeWallet(userId,money,purpose);
        return ResponseData.ok();
    }
}
