package com.test.filesniffer.operation;

import com.test.filesniffer.dto.FileInfoDto;

public interface ReadFile {

	public FileInfoDto readFile(String filePath,long position,int size);
}
