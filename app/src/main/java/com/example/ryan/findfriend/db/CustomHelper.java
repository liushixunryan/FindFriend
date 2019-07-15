package com.example.ryan.findfriend.db;

import android.net.Uri;
import android.os.Environment;
import android.view.View;


import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;

import org.devio.takephoto.model.TakePhotoOptions;

import java.io.File;
import com.example.ryan.findfriend.R;

/**
 * - 支持通过相机拍照获取图片
 * - 支持从相册选择图片
 * - 支持从文件选择图片
 * - 支持多图选择
 * - 支持批量图片裁切
 * - 支持批量图片压缩
 * - 支持对图片进行压缩
 * - 支持对图片进行裁剪
 * - 支持对裁剪及压缩参数自定义
 * - 提供自带裁剪工具(可选)
 * - 支持智能选取及裁剪异常处理
 * - 支持因拍照Activity被回收后的自动恢复
 * Author: crazycodeboy
 * Date: 2016/9/21 0007 20:10
 * Version:4.0.0
 * 技术博文：http://www.devio.org
 * GitHub:https://github.com/crazycodeboy
 * Email:crazycodeboy@gmail.com
 */
public class CustomHelper {


    public void onClick(boolean bpaizhao, TakePhoto takePhoto) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);

        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        if(bpaizhao){
            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
        }else{
            takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
        }

    }

    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();

        builder.setWithOwnGallery(true);


          //  builder.setCorrectImage(true);

        takePhoto.setTakePhotoOptions(builder.create());

    }

    private void configCompress(TakePhoto takePhoto) {


        int width = 800;
        int height = 800;


        CompressConfig config;

            config = new CompressConfig.Builder().setMaxSize(102400)
                .setMaxPixel(width >= height ? width : height)
                .enableReserveRaw(true)
                .create();

        takePhoto.onEnableCompress(config, true);


    }

    private CropOptions getCropOptions() {

        int height = 800;
        int width = 800;


        CropOptions.Builder builder = new CropOptions.Builder();


        builder.setOutputX(width).setOutputY(height);

        builder.setWithOwnCrop(false);
        return builder.create();
    }

}
