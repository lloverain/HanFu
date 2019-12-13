package com.yangjiaying.hanfu.modular.LostAndFound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yangjiaying.hanfu.modular.LostAndFound.service.releaseservice;
import com.yangjiaying.hanfu.modular.LostAndFound.util.savaFile;
import com.yangjiaying.hanfu.modular.system.entity.RestResponse;
import com.yangjiaying.hanfu.modular.system.service.UserLoginToken;
import com.yangjiaying.hanfu.modular.system.util.jiexiJSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.controller
 * @ClassName:releaseControl
 * @author:yangjiaying
 * @date 2019/12/12 16:06
 */
@Controller
@RequestMapping(value = "/API")
public class releaseControl {

    @Autowired
    private releaseservice releaseservice;

    @UserLoginToken
    @ResponseBody
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public String submission(HttpServletRequest request, @RequestParam("file") MultipartFile imageFile) throws IOException {
        savaFile savaFile = new savaFile();
        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String contact = request.getParameter("contact");
        String place = request.getParameter("place");
        String time = request.getParameter("time");
        boolean image = false;
        RestResponse response = new RestResponse();
        if (name != null && account != null && title != null && content != null && contact != null && place != null && time != null) {
            if (!imageFile.isEmpty()) {
                image = savaFile.savePic(imageFile.getInputStream(), account, time);
            }
            if(image){
                System.out.println(name + account + title + content + contact + place + time);
                boolean state = releaseservice.release(name, account, title, content, contact, place, time);
                System.out.println(state);
                if (state) {
                    response.setCode(200);
                    response.setMessage("发布成功！");
                } else {
                    response.setCode(500);
                    response.setMessage("发布失败！");

                }
            }

        }
        return JSON.toJSONString(response);
    }
}
