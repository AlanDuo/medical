package com.lhd.manager.controller;

import com.lhd.manager.common.ResponseData;
import com.lhd.manager.utils.ImgUploadUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片上传
 *
 * @author alan
 * @date 2021/3/26
 */
@RestController
public class ImageUploadController {
    @PostMapping("/upload_img")
    public ResponseData uploadImg(MultipartFile img, HttpServletRequest request){
        ImgUploadUtil.uploadFile(img, request);
        String url=ImgUploadUtil.getUrl();
        return ResponseData.ok().putDataValue(url);
    }
}
