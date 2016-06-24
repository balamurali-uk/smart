/**
 * 
 */
package com.ofs.core;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author balamuralik
 *
 */
public class MediaInfoUtil {
	
	/**
	 * Pass the location and file extension to get
	 * list of files
	 * 
	 * @param location
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	public static List<File> getFileNamesFromLocation(String location, final String extension) throws IOException {
		
		File directory = new File(location);
		File [] inputFiles = directory.listFiles(new FilenameFilter() {			
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(extension);
			}
		}); 
		
		List<File> files = Arrays.asList(inputFiles);
		Collections.sort(files);
		return files;
	}
}
