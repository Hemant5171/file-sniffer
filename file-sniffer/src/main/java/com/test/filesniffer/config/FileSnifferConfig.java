package com.test.filesniffer.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.filesniffer.client.FileSnifferClient;
import com.test.filesniffer.operation.ReadFile;
import com.test.filesniffer.operation.ReadFileImp;
import com.test.filesniffer.operation.WriteFile;
import com.test.filesniffer.operation.WriteFileImp;
import com.test.filesniffer.scheduler.FileSnifferScheduler;
import com.test.filesniffer.util.FileSnifferUtil;

import net.openhft.chronicle.map.ChronicleMap;

@Configuration
public class FileSnifferConfig {

	public @Bean ReadFile readFile() {
		return new ReadFileImp();
	}

	public @Bean WriteFile writeFile() {
		return new WriteFileImp();
	}

	public @Bean FileSnifferClient fileSnifferClient() {
		return new FileSnifferClient();
	}
	
	public @Bean FileSnifferScheduler fileSnifferScheduler() {
		return new FileSnifferScheduler();
	}
	
	public @Bean FileSnifferUtil fileSnifferUtil() {
		return new FileSnifferUtil();
	}
	
	public @Bean Map<String,Long> filePointerMap() throws IOException
	{
	return	 ChronicleMap
				  .of(String.class, Long.class)
				  .name("filePointerMap")
				  .entries(50)
				  .averageKeySize(10000d)
				 /// .averageValueSize(1000000000000000000000d)
				  .createPersistedTo(new File("C:\\\\Users\\\\Suraj\\\\.ssh\\\\Desktop\\\\file-sniffer\\file-pointer-map.dat"));

	}

}
