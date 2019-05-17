package com.poetry.commom;

import org.apache.commons.io.FileUtils;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static com.poetry.commom.ConfigConsts.ConfigConsts.FILE_PATH;

/**
 * @author myl
 * @description 文件上传
 * @date 2019/5/4
 */
public class FileUploadUtil {



    /**
     * @description
     * @author myl
     * @date 2019/5/4
     * @param partFile
     * @return [partFile] 返回值只返回虚拟路径
     */
    public static String fileUpload(CommonsMultipartFile partFile) throws IOException {
        String filename= UUID.randomUUID().toString()+partFile.getOriginalFilename();//上传时候的文件名
        String path=FILE_PATH;
        File file = new File(path+"/"+filename);
        InputStream inputStream = partFile.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream, file);
        String filepath="/upload/"+filename;
        inputStream.close();
        return filepath;
    }
}
