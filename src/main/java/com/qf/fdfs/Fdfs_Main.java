package com.qf.fdfs;

import java.io.IOException;
import java.util.Arrays;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import com.qf.utils.FdfsUtils;

public class Fdfs_Main {
public static void main(String[] args) throws IOException, MyException {
	 String url="http://47.95.236.30/";
     System.out.println(url+new FdfsUtils("classpath:fdfs_client.conf").
             uploadFile("E:/java资料/第四阶段/Java_1715/SSS_Quartz/pom.xml","xml"));
	
	
}

private static void test1() throws IOException, MyException {
    //初始化配置文件，加载
    ClientGlobal.init("SSS_Quartz/src/main/resources/fdfs_client.conf");
    //创建跟踪服务器的客户端
    TrackerClient trackerClient=new TrackerClient();
    //连接跟踪服务器
    TrackerServer trackerServer=trackerClient.getConnection();
    //声明存储服务器
    StorageServer storageServer=null;
    //创建存储客户端
    StorageClient storageClient=new StorageClient(trackerServer,storageServer);
    //上传文件
    String[] strs=storageClient.upload_file("SSS_Quartz/课堂笔记.txt","txt",null);
    System.out.println("上传结果："+ Arrays.toString(strs));
}
}
