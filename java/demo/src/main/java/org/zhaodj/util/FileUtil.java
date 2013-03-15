package org.zhaodj.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	/**
	 * 获取目录下的所有文件名字，包含子文件夹
	 * 
	 * @param folderPath
	 * @return
	 * @throws IOException 
	 */
	
	public static String read(String filepath) throws IOException{
		return read(filepath,"UTF-8");
	}
	
	public static String read(String filepath,String encoding) throws IOException{
		InputStreamReader isReader = new InputStreamReader(
				new FileInputStream(filepath), encoding);
		BufferedReader reader = new BufferedReader(isReader);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			sb.append(line);
		}
		isReader.close();
		reader.close();
		return sb.toString();
	}
	
	public static List<String> findAllFiles(String folderPath, String fileext) {
		File folder = new File(folderPath);
		if (folder.isDirectory()) {
			List<String> filespath = new ArrayList<String>();
			recurFile(folder, filespath, fileext);
			return filespath;
		}
		return null;
	}

	private static void recurFile(File folder, List<String> filespath,
			String fileext) {
		String[] files = folder.list();
		for (String filename : files) {
			File file = new File(folder.getAbsolutePath() + File.separator
					+ filename);
			if (file.isDirectory()) {
				recurFile(file, filespath, fileext);
			} else {
				if(fileext.equals("*")){
					filespath.add(file.getAbsolutePath());
				}
				else if (file.getName().endsWith(fileext)) {
					filespath.add(file.getAbsolutePath());
				}
			}
		}
	}

}
