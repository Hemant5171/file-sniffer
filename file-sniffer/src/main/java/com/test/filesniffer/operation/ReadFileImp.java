package com.test.filesniffer.operation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.test.filesniffer.dto.FileInfoDto;

public class ReadFileImp implements ReadFile {

	@Override
	public FileInfoDto readFile(String filePath, long position, int size) {
		
		FileInfoDto fileInfoDto=null;
		byte[] byteArr=new byte[size];
		RandomAccessFile raf=null;
		
		try {
			raf=new RandomAccessFile(filePath, "r");
			if(raf.length()>position)
			{
			fileInfoDto=new FileInfoDto();
			raf.seek(position);
            raf.read(byteArr);
            
            fileInfoDto.setByteArr(byteArr);
            fileInfoDto.setFilePointer(raf.getFilePointer());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(null!=raf)
				{
				raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileInfoDto;
	}

}
