package com.billboard.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@MultipartConfig
@RequestMapping("/billboard")
public class UploadFile {

	@RequestMapping(method = RequestMethod.POST, value = "ckeditorUpload")
    public String imageUpload(@RequestParam("upload") MultipartFile file,
                            @RequestParam("CKEditorFuncNum") String CKEditorFuncNum,
                            HttpServletResponse response,
                            HttpServletRequest request) throws IOException {
        System.out.println("有文件想要上傳");
        PrintWriter out = response.getWriter();
        //取得上傳的檔案名稱
        String name = null;
        name = new String(file.getOriginalFilename().getBytes("iso-8859-1"), "UTF-8");
        
        //取得上傳的檔案格式
        String uploadContentType = file.getContentType();
        //處理文件的副檔名
        String expandedName = "";
        if (uploadContentType.equals("image/pjpeg")
                || uploadContentType.equals("image/jpeg")) {
        	// IE6上傳jpg圖片的headimageContentType是image/pjpeg，而IE9以及火狐上傳的jpg圖片是image/jpeg
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png")
                || uploadContentType.equals("image/x-png")) {
        	// IE6上傳的png圖片的headimageContentType是"image/x-png"
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        } else {
            //文件格式不符合，返回錯誤信息
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                    + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            out.println("</script>");
            return null;
        }
        
        //文件命名並保存到服務器
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); //檔案名稱為年月日時分秒
        DateFormat folderdate = new SimpleDateFormat("yyyyMMdd"); //檔案名稱為年月日時分秒
        name = df.format(new Date()) +expandedName;             //存入伺服器檔案名稱為年月日時分秒+副檔名 
        try {
        	
            File file1 = new File(request.getServletContext().getRealPath("/resources/upload/" + folderdate.format(new Date())),name); 
            //判斷路徑是否存在，不存在就建立路徑
            File savepath = new File(request.getServletContext().getRealPath("/resources/upload/" + folderdate.format(new Date())));
            if(!savepath.exists()){
            	savepath.mkdirs();
            }
            System.out.println(file1.getPath());
            file.transferTo(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String fileURL =request.getContextPath() + "/resources/upload/" + folderdate.format(new Date())+"/" +name;
        // 返回"图像"选项卡和图像在服务器的地址并显示图片
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" +fileURL+"','')");
        out.println("</script>");
        out.close();
        return null;
    }
}
