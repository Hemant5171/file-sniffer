package com.test.filesniffer.operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFileImp implements WriteFile {

	@Override
	public void writeByte(byte[] byteArr, String fileName, String path) {

		File file=new File(path.concat("/").concat(fileName));
		try {
			Files.write(Paths.get(file.toString()), byteArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
