package com.lhd.user.service;

import com.lhd.user.entities.Bill;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/24
 */
public interface WalletService {
    BigDecimal getUserWallet(Long userId);
    List<Bill> getUserBill(Long userId);
    boolean chargeWallet(Long userId,BigDecimal money,String purpose);
}
