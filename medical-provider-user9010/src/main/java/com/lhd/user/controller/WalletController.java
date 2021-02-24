package com.lhd.user.controller;

import com.lhd.user.common.ResponseData;
import com.lhd.user.dto.UserDTO;
import com.lhd.user.entities.Bill;
import com.lhd.user.handler.LoginUserHolder;
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
    private LoginUserHolder loginUserHolder;
    @Autowired
    public WalletController(WalletService walletService,LoginUserHolder loginUserHolder){
        this.walletService=walletService;
    }

    @GetMapping("/balance")
    public ResponseData userWallet(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        BigDecimal wallet=walletService.getUserWallet(userDTO.getId());
        return ResponseData.ok().putDataValue(wallet);
    }
    @GetMapping("/bill")
    public ResponseData userBill(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        List<Bill> billList=walletService.getUserBill(userDTO.getId());
        return ResponseData.ok().putDataValue(billList);
    }
    @PostMapping("/chargeWallet")
    public ResponseData chargeWallet(BigDecimal money,String purpose){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        walletService.chargeWallet(userDTO.getId(),money,purpose);
        return ResponseData.ok();
    }
}
