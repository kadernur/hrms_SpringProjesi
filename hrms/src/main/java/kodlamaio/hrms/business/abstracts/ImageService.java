package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	
	
	//MultipartFile :Çok parçalı bir istekte alınan karşıya yüklenen bir dosyanın gösterimi.
	//Dosya içeriği bellekte veya geçici olarak diskte depolanır. Her iki durumda da,
	//kullanıcı dosya içeriğinin istendikçe ve istenirse oturum düzeyinde veya kalıcı bir depoya kopyalanmasıyla sorumludur.
	//Geçici depolama,istek işleme sonunda temizlenecektir.
	
	
	
	
    Result add(Image image,  MultipartFile imageFile);
	
	DataResult<Image> getByCandidateId(int candidateId);
	
	DataResult<List<Image>> getAll();
	
	DataResult<Image> getById(int id);
	Result update(Image image);
	
	Result delete(Image image);
	
}


