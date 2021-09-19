package minio;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-03-03
 **/

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class FileUploader {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://10.8.4.121:9000", "minioadmin", "minioadmin");
            log.info("get minio client ok");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("asiatrip");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("asiatrip");
                log.info("after create bucket '{}'", "asiatrip");
            }

            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject("asiatrip","a.txt", "H:\\java_project_study\\myproj\\a.txt");
            System.out.println("H:\\java_project_study\\myproj\\a.txt is successfully uploaded as a.txt to `asiatrip` bucket.");
        } catch(MinioException e) {
            System.out.println("Error occurred: " + e);
        }

        File f = new File("aa");

    }
}
