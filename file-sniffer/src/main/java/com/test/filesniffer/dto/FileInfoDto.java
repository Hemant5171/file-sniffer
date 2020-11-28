package com.test.filesniffer.dto;

import lombok.Data;

@Data
public class FileInfoDto {

  private byte[] byteArr;
  private long filePointer;
	
}
