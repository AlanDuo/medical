package com.lhd.shop.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 数据表格视图对象
 *
 * @author alan
 * @date 2021/2/18
 */
@Data
public class TableVO<T> implements Serializable {
    private PageInfo pageInfo;
    private List<T> data;
    public TableVO(){
    }
    public TableVO(PageInfo pageInfo, List<T> data){
        this.pageInfo=pageInfo;
        this.data=data;
    }
}
