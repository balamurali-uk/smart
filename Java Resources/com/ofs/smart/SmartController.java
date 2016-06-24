/**
 * 
 */
package com.ofs.smart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofs.core.MediaInfoUtil;
import com.ofs.model.AdvertisedInfo;

/**
 * @author balamuralik
 *
 */
@RestController
public class SmartController {
	
	@RequestMapping(value = "/get-ad-info/{uuid}/{min}/{max}",method = RequestMethod.GET)
    public AdvertisedInfo getAdInfo(@PathVariable String uuid, @PathVariable String min, @PathVariable String max) throws IOException {
		AdvertisedInfo advertisedInfo = new AdvertisedInfo();
		advertisedInfo.setMax(max);
		advertisedInfo.setMin(min);
		advertisedInfo.setUuid(uuid);
		advertisedInfo.setMediaData(getMediaDataBasedOnMinValue(min));
		return advertisedInfo;
    }
	
	private byte [] getMediaDataBasedOnMinValue(String min) throws IOException {
		
		List<File> files = MediaInfoUtil.getFileNamesFromLocation("D://smart/", "png");
		
		int index = files.indexOf(new Object() {
		    public boolean equals(Object obj) {
		    	File file = (File) obj;
		        return file.getName().startsWith(min + "-");
		    }
		});
		
		File file = index >= 0 ? files.get(index) : null;
		return Files.readAllBytes(file.toPath());
	}
}
