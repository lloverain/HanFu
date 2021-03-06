package com.yangjiaying.hanfu.modular.system.util;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 工具类
 * 获取前台传的值并转为json数据
 * @PackageName:com.yangjiaying.hanfu.modular.login.util
 * @ClassName:jiexiJSON
 * @author:yangjiaying
 * @date 2019/11/26 12:08
 */
public class jiexiJSON {

    public static String jiexi(HttpServletRequest request) throws IOException {
        String json = "";
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"UTF-8");
        char [] buff=new char[1024];
        int length=0;
        while((length=reader.read(buff))!=-1){
            json=new String(buff,0,length);
            System.out.println("得到的字符串是:"+json);
        }
        return json;
    }

}
