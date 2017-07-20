package com;

/**
 * Created by Big_Boss on 2017/7/18.
 */
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import Dao.Dao;
import bases.ImgEntity;

public class updata extends ActionSupport{
    private String path;
    private File uploadImage; //得到上传的文件
    private String uploadImageContentType; //得到文件的类型
    private String uploadImageFileName; //得到文件的名称

    public String getPath() {
        return path;
    }

    public String getUploadImageContentType() {
        return uploadImageContentType;
    }

    public String getUploadImageFileName() {
        return uploadImageFileName;
    }

    public File getUploadImage() {
        return uploadImage;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUploadImage(File uploadImage) {
        this.uploadImage = uploadImage;
    }

    public void setUploadImageContentType(String uploadImageContentType) {
        this.uploadImageContentType = uploadImageContentType;
    }

    public void setUploadImageFileName(String uploadImageFileName) {
        this.uploadImageFileName = uploadImageFileName;
    }

    public String execute(){
        String path="http://localhost:8080/gallery/img/";
        ImgEntity img=new ImgEntity();
        Dao dao=new Dao();
        //获取要保存文件夹的物理路径(绝对路径)
        String realPath=ServletActionContext.getServletContext().getRealPath("/img");
        File file = new File(realPath);
        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())file.mkdirs();
        try {
            //保存文件
            FileUtils.copyFile(uploadImage, new File(file,uploadImageFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return Action.ERROR;
        }
        img.setPath(path+uploadImageFileName);
        dao.insert(img);
        return Action.SUCCESS;
    }
}
