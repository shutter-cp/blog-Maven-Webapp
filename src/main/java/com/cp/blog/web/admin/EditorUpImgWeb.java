/**
 * chenPeng
 * com.cp.blog.web.admin
 * EditorUpImgWeb.java
 * 创建人:chenpeng
 * 时间：2018年12月22日-上午12:49:05 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web.admin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * EditorUpImgWeb
 * 创建人:chenPeng
 * 时间：2018年12月22日-上午12:49:05 
 * @version 1.0.0
 * 
 */
@Controller
public class EditorUpImgWeb {
	/**
	 * 富文本编辑的图片上传功能
	 * 方法名：upload
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午3:46:44 
	 * 手机:17673111810
	 * @param photo
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException Map<String,String>
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/admin/write/upimg",method=RequestMethod.POST,produces = "application/String; charset=utf-8")
    @ResponseBody
    public String upload(@RequestPart("upload") MultipartFile upload) throws IllegalStateException, IOException {
        
		String url = null;
		String bol = null;
        try {
        	 //存储文件夹
            String holder = "fileUpload/";
            if (upload == null) {
                return null;
            }
            String orgginalFileName = upload.getOriginalFilename();
            //新文件名称
            //String newFileName = UUID.randomUUID().toString() + orgginalFileName;
            //String newFileName =  DigestUtils.md5Digest(upload.getBytes()).toString() + orgginalFileName;
            String newFileName = UUID.randomUUID().toString() + orgginalFileName;
            //保存路径
            String serverPath = getRealPath() + holder;
 
            upload.transferTo(new File(serverPath, newFileName));
            url =  holder + newFileName;
            bol = "true";
		} catch (Exception e) {
			// TODO: handle exception
			 bol = "false";
		}
        System.out.println(url);
        return "{\"uploaded\": "+bol+",\"url\": \""+ url+"\"}";
    }
	
    /**
     * 服务器地址
     * @return
     */
    public String getServerPath() {
        HttpServletRequest request = getRequest();
        return request.getScheme() 
        		+ "://" + request.getServerName() 
        		+ ":" + request.getServerPort() 
        		+ "/" + request.getContextPath() 
        		+ "/";
 
    }
    /**
     * 获取项目根目录
     * @return
     */
    public String getRealPath() {
        HttpServletRequest request = getRequest();
        return request.getServletContext().getRealPath("/");
    }
    /**
     * 
     * @return
     */
    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
    }
   
}
