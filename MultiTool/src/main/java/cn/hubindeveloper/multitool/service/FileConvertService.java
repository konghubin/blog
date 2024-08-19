package cn.hubindeveloper.multitool.service;

import cn.hubindeveloper.multitool.domain.vo.BlogFileConvertVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileConvertService extends IService<BlogFileConvertVo> {
    ResponseEntity<InputStreamResource> word2Pdf(MultipartFile file);
}
