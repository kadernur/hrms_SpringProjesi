package kodlamaio.hrms.core.utilities.image;

import java.io.IOException;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;


@Service
public class ImageUploadManager implements ImageUploadService {

	
	private Cloudinary cloudinary;

	@Autowired
	public ImageUploadManager(Cloudinary cloudinary) {
         
		this.cloudinary =cloudinary;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        
		try {
			@SuppressWarnings("unchecked")
			Map<String,String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return new ErrorDataResult<Map>("Cannot added !");
	}
	

}
