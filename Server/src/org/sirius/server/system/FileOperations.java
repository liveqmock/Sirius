/**
 * 
 */
package org.sirius.server.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.jws.WebService;

/**
 * @author KaNoN
 * 
 */
@WebService
public class FileOperations {

	/**
	 * 
	 * @param path
	 * @param content
	 * @return
	 */
	public boolean Append(String path, byte[] content) {
		return false;
	}

	/**
	 * 
	 * @param path
	 * @param text
	 * @return
	 */
	public boolean AppendEx(String path, String text) {
		return false;
	}

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 * @throws IOException
	 */
	public boolean Copy(String origin, String destination) throws IOException {
		return CopyEx(origin, destination, false);
	}

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @param overwrite
	 * @return
	 */
	public boolean CopyEx(String origin, String destination, boolean overwrite)
			throws IOException {
		File source = new File(origin);
		File dest = new File(destination);

		if (!source.getAbsoluteFile().exists()) {
			return false;
		}
		if (source.getAbsoluteFile().isDirectory()) {
			return false;
		}

		if(dest.getAbsoluteFile().exists()){
			if (dest.getAbsoluteFile().isFile()) {
				if(overwrite){
					dest.delete();
				}
				else {
					return false;
				}
			}
		}
		else {
			dest.getAbsoluteFile().mkdirs();
			dest = new File(dest.getAbsoluteFile() + File.separator + source.getName() );
		}
		/*
		 * if (!dest.getAbsoluteFile().getParentFile().mkdirs()) { return false;
		 * }
		 */

		if (dest.getAbsolutePath().length() > 255) {
			return false;
		}
		/*
		 * try { dest.getAbsoluteFile().createNewFile(); } catch(Exception
		 * e){return false;}
		 */
		try {
			Files.copy(source.toPath(), dest.toPath());
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean createFile(String fileName) {
		return createFileEx(fileName, false);
	}

	/**
	 * 
	 * @param fileName
	 * @param overwrite
	 * @return
	 * @throws IOException
	 */
	public boolean createFileEx(String fileName, boolean overwrite) {
		File dest = new File(fileName);

		if (dest.exists()) {
			if (!overwrite) {
				return false;
			}

			dest.delete();
		}

		try {
			dest.getAbsoluteFile().getParentFile().mkdirs();
			return dest.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean Delete(String fileName) {
		File file = new File(fileName);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
		return !file.exists() || !file.isFile();
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean Exists(String fileName) {
		File file = new File(fileName);
		return file.exists() && file.isFile();
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public byte[] GetAllBytes(String fileName) {
		return null;
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public String[] GetContents(String path) throws IOException {
		return GetContentsEx2(path, 0, Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @param path
	 * @param start
	 * @return
	 * @throws IOException
	 */
	public String[] GetContentsEx(String path, int start) throws IOException {
		return GetContentsEx2(path, start, Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @param path
	 * @param start
	 * @param number
	 * @return
	 * @throws IOException
	 */
	public String[] GetContentsEx2(String path, int start, int number)
			throws IOException {
		File file = new File(path);

		if (!file.exists() || !file.isFile()) {
			return null;
		}

		ArrayList<String> content = new ArrayList<String>();

		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String line;
		int counter = 0;

		while ((line = br.readLine()) != null) {
			if ((long) counter >= (long) start
					&& (long) counter < ((long) start + (long) number)) {
				content.add(line);
			}
			counter++;
		}

		String result[] = new String[content.size()];

		result = content.toArray(result);
		return result;
	}

	/**
	 * 
	 * @param path
	 * @param lines
	 * @return
	 * @throws IOException
	 */
	public String[] Head(String path, int lines) throws IOException {
		return GetContentsEx2(path, 0, lines);
	}

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 * @throws IOException
	 */
	public boolean Move(String origin, String destination) throws IOException {
		return MoveEx(origin, destination, false);
	}

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @param overwrite
	 * @return
	 * @throws IOException
	 */
	public boolean MoveEx(String origin, String destination, boolean overwrite)
			throws IOException {
		File source = new File(origin);
		File dest = new File(destination);

		if (dest.getAbsolutePath().length() > 255) {
			return false;
		}

		if (dest.exists() && dest.isFile()) {
			if (!overwrite) {
				return false;
			} else {
				dest.delete();
			}
		}

		dest.getAbsoluteFile().mkdirs();
		dest.delete();

		try {
			Files.move(source.toPath(), dest.toPath());
		} catch (FileSystemException e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public long Size(String fileName) {
		File file = new File(fileName);
		if (!file.exists() || !file.isFile()) {
			return -1;
		}
		return file.length();
	}

	/**
	 * 
	 * @param path
	 * @param lines
	 * @return
	 * @throws IOException
	 */
	public String[] Tail(String path, int lines) throws IOException {

		File file = new File(path);

		if (!file.exists() || !file.isFile()) {
			return null;
		}

		ArrayList<String> content = new ArrayList<String>();

		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String line;

		while ((line = br.readLine()) != null) {
			content.add(line);
			if (content.size() > lines) {
				content.remove(0);
			}
		}

		String result[] = new String[content.size()];

		result = content.toArray(result);
		return result;

	}

	/**
	 * 
	 * @param path
	 * @param content
	 * @return
	 */
	public boolean Write(String path, byte[] content) {
		return false;
	}

	/**
	 * 
	 * @param path
	 * @param text
	 * @return
	 */
	public boolean WriteEx(String path, String text) {
		return false;
	}
}
