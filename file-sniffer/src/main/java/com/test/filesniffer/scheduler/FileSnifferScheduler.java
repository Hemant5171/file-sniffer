package com.test.filesniffer.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.test.filesniffer.client.FileSnifferClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSnifferScheduler {

	
	@Autowired
	private FileSnifferClient fileSnifferClient;
	
	@Scheduled(cron = "${file.sniffer.schedule}")
	public void executeFileSniffer()
	{
		log.info("file-sniffer -->started");
		fileSnifferClient.startFileSniffing();
		log.info("file-sniffer -->completed");
	}
	
}
