package com.test.filesniffer.client;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.test.filesniffer.dto.FileInfoDto;
import com.test.filesniffer.operation.ReadFile;
import com.test.filesniffer.operation.WriteFile;
import com.test.filesniffer.util.FileSnifferUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSnifferClient {
	
	@Value("${file.sniff.path.input}")
	private String sniffPathInput;
	
	@Value("${file.sniff.path.ouput}")
	private String sniffPathOutput;
	
	@Value("${file.sniff.block.size}")
	private int size;
	
	@Autowired
	private FileSnifferUtil fileSnifferUtil;
	
	@Autowired
	private ReadFile readFile;
	
	@Autowired
	private WriteFile writeFile;
	
	@Autowired
    private Map<String,Long> filePointerMap;
	
	private String key="A";
	
	@PostConstruct
	private void loadMap()
	{
		Long pointer=filePointerMap.get(key);
		if(null==pointer)
		{
			filePointerMap.put("A", 0L);
		}
	}
	
	public void startFileSniffing()
	{
		
		FileInfoDto fileInfoDto=null;
		fileInfoDto=readFile.readFile(sniffPathInput, filePointerMap.get(key), size);
		
		if(null!=fileInfoDto)
		{
		writeFile.writeByte(fileInfoDto.getByteArr(), fileSnifferUtil.getFileName(), sniffPathOutput.toString());
		long pointer=fileInfoDto.getFilePointer();
		filePointerMap.put(key,pointer);
		}
		else
		{
			log.info("no updation in the input file");
		}
		
	}

}
