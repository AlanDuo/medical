package com.lhd.user.service.impl;

import com.lhd.user.dao.BillMapper;
import com.lhd.user.dao.UserMapper;
import com.lhd.user.entities.Bill;
import com.lhd.user.entities.BillExample;
import com.lhd.user.entities.User;
import com.lhd.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BillMapper billMapper;

    @Override
    public User getUserById(Long userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        if(null!=user){
            return user;
        }
        return null;
    }

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
    public boolean chargeWallet(Long userId, BigDecimal money, String purpose) {
        Bill bill=new Bill();
        bill.setUserId(userId);
        bill.setPurpose(purpose);
        bill.setMoney(money);
        bill.setBillTime(new Date());
        byte flag=1;
        bill.setIntOrOut(flag);
        return billMapper.insertSelective(bill)>0;
    }
}
