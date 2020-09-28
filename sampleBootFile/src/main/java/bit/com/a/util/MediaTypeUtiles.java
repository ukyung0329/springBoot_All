package bit.com.a.util;

import javax.servlet.ServletContext;

import org.springframework.http.MediaType;

public class MediaTypeUtiles {

	public static MediaType getMediaTypeForFileName(ServletContext servletContext, String filename) {
		
		String mineType = servletContext.getMimeType(filename);
		
		try {
			MediaType mediaType = MediaType.parseMediaType(mineType);
			return mediaType;
		}catch (Exception e) {
			return MediaType.APPLICATION_OCTET_STREAM;
		}		
	}
}
