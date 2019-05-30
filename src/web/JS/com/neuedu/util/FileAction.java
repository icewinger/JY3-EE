package com.neuedu.util;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;


/*
上传图片的工具类
 */
public class FileAction {

    public static String uploadImg(Part part)
    {

        String submittedFileName = part.getSubmittedFileName();
        InputStream inputStream = null;
        OutputStream os = null;
        //创建UUID
        UUID uuid = UUID.randomUUID();
        String name = uuid + submittedFileName;
        try {
            inputStream = part.getInputStream();
            os = new FileOutputStream("E:\\IDEA SAVE\\imgs\\" + name);
            int a = 0;
            byte[] bs= new byte[1024];
            while ((a = inputStream.read(bs) )!= -1)
            {
                os.write(bs,0,a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
