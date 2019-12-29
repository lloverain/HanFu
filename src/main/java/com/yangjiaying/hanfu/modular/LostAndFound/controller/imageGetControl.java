package com.yangjiaying.hanfu.modular.LostAndFound.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 通过该类可访问图片
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.controller
 * @ClassName:imageGetControl
 * @author:yangjiaying
 * @date 2019/12/13 10:42
 */
@Controller
public class imageGetControl {

    /**
     * 把本地图片输出到页面
     * @param response
     * @param request
     */
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public void readImg(HttpServletResponse response, HttpServletRequest request) {
        String name = request.getParameter("name");
        String acccount = request.getParameter("account");
        name = name.substring(1, name.length()-1);
        acccount = acccount.substring(1, acccount.length()-1);
        FileInputStream fis = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();

            //ResultStatic.path+prizeid+".jpg"  图片绝对地址

            fis = new FileInputStream(new File("D:\\HanFu\\"+acccount+"\\"+name+".jpg"));
            byte[] buffer = new byte[1024 * 8];
            //读取文件流  
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
