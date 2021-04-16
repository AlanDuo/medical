package com.lhd.common.controller;

import com.lhd.common.util.ImgUploadUtil;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author alan
 * @date 2021/4/16
 */
@RestController
@RequestMapping("/img")
public class ImageUploadController {


    /**
     * 以文件形式上传
     *
     * @param img
     * @param request
     * @return
     */
    @PostMapping("/upload_mul")
    public String uploadImgMultipart(MultipartFile img, HttpServletRequest request){
        ImgUploadUtil.uploadFile(img,request);
        String url=ImgUploadUtil.getUrl();
        return url;
    }

    /**
     * 以base64上传图片
     *
     * @param img
     * @param request
     * @return
     */
    @PostMapping("/upload_base64")
    public String uploadImgBase64(String img,HttpServletRequest request){
        ImgUploadUtil.uploadFile(img, request);
        String url=ImgUploadUtil.getUrl();
        return url;
    }
}
