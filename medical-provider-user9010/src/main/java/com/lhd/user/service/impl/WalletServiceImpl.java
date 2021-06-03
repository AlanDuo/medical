package com.lhd.user.service.impl;

import com.lhd.user.dao.BillMapper;
import com.lhd.user.dao.UserMapper;
import com.lhd.user.entities.Bill;
import com.lhd.user.entities.BillExample;
import com.lhd.user.entities.User;
import com.lhd.user.service.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/24
 */
@Service
public class WalletServiceImpl implements WalletService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BillMapper billMapper;

    @Override
    public BigDecimal getUserWallet(Long userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        if(null!=user){
            return user.getWallet();
        }
        return null;
    }

    @Override
    public List<Bill> getUserBill(Long userId) {
        BillExample billExample=new BillExample();
        BillExample.Criteria billCriteria=billExample.createCriteria();
        billCriteria.andUserIdEqualTo(userId);
        List<Bill> billList=billMapper.selectByExample(billExample);
        if(billList.size()!=0){
            return billList;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BigDecimal chargeWallet(Long userId, BigDecimal money, String purpose) {
        User user=userMapper.selectByPrimaryKey(userId);
        BigDecimal wallet=user.getWallet().add(money);
        user.setWallet(wallet);
        userMapper.updateByPrimaryKeySelective(user);

        Bill bill=new Bill();
        bill.setUserId(userId);
        bill.setPurpose(purpose);
        bill.setMoney(money);
        bill.setBillTime(new Date());
        byte flag=1;
        bill.setIntOrOut(flag);
        billMapper.insertSelective(bill);

        return wallet;
    }

}
