package com.yangjiaying.hanfu.modular.LostAndFound.util;

import java.io.*;

/**
 * @PackageName:com.yangjiaying.hanfu.modular.LostAndFound.util
 * @ClassName:savaFile
 * @author:yangjiaying
 * @date 2019/12/12 16:35
 */
public class savaFile {
    /**
     * 存文件
     *
     * @param inputStream
     * @return
     */
    public boolean savePic(InputStream inputStream, String account,String name) {
        String path = null;
        OutputStream os = null;
        try {
            path = "D:\\HanFu\\" + account +"\\";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + name + ".jpg");
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
