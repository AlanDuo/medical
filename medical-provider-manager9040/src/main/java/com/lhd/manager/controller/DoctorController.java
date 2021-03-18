package com.lhd.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.common.ResponseData;
import com.lhd.manager.common.TableVO;
import com.lhd.manager.service.DoctorService;
import com.lhd.manager.vo.DoctorListVO;
import com.lhd.manager.vo.DoctorMaterialVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/17
 */
@RestController
@RequestMapping("/manager/doctor")
public class DoctorController {
    private DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    /**
     * 分页查询医生列表
     *
     * @param doctorName
     * @param phone
     * @param hospital
     * @param category
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/doctor_list")
    public TableVO getDoctorList(String doctorName, String phone, String hospital, String category,Byte qualification,
                                 @RequestParam(value = "page",defaultValue = "1")Integer page,
                                 @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        List<DoctorListVO> doctorListVOList=doctorService.getDoctorList(doctorName, phone, hospital, category,qualification);
        PageInfo pageInfo=new PageInfo<>(doctorListVOList);
        return new TableVO(pageInfo,doctorListVOList);
    }

    /**
     * 获取医生材料
     *
     * @param doctorId
     * @return
     */
    @GetMapping("/doctor_material/{doctorId}")
    public ResponseData getDoctorMaterial(@PathVariable("doctorId")Long doctorId){
        DoctorMaterialVO doctorMaterialVO=doctorService.getDoctorMaterial(doctorId);
        return ResponseData.ok().putDataValue(doctorMaterialVO);
    }

    /**
     * 更新医生资质
     *
     * @param doctorId
     * @param qualification
     * @return
     */
    @PutMapping("/doctor_check")
    public ResponseData checkDoctorQualification(Long doctorId,Byte qualification){
        boolean result=doctorService.updateDoctorQualification(doctorId, qualification);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }

}
