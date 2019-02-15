package com.cyq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadFileWriter;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDfsTest {

	@Autowired
	private FastFileStorageClient storageClient;
	
	@Test
	public void testUpload() throws FileNotFoundException {
		File file = new File("D:\\sqzip\\de786f39ae5966df--jldiao6--1549938563922.zip");
		StorePath path = storageClient.uploadFile(new FileInputStream(file), file.length(), "zip", null);
		System.out.println(path.getFullPath());
	}
	
	@Test
	public void testDelete() {
		storageClient.deleteFile("group1/M00/00/00/rB_tl1xmb5uANwp2AAAA5lfI6CE067.zip");
	}
	
	@Test
	public void testDownLoad() {
		DownloadFileWriter callback = new DownloadFileWriter("D:\\sqzip\\test.zip");
        storageClient.downloadFile("group1", "M00/00/00/rB_tl1xmb5uANwp2AAAA5lfI6CE067.zip", callback);
	}

}
