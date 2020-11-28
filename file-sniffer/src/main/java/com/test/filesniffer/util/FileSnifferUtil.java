package com.test.filesniffer.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSnifferUtil {

	public  Supplier<LocalDateTime> getLocalDateTime=()-> LocalDateTime.now();
	public  DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	
	@Value("${file.sniffer.ouput.file.extension}")
	private String filePostfix;
	
	@Value("${file.sniffer.ouput.file.prefix}")
	private String prefix;
	
	public  String getFileName()
	{
		String fileName= prefix.concat(getLocalDateTime.get().format(df).concat(filePostfix));
		log.info("file-name -->{}",fileName);
		return fileName;
	}
}
