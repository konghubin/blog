package cn.hubindeveloper.multitool.controller;

import cn.hubindeveloper.multitool.service.FileConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file-convert")
public class FileConvertController {
    @Autowired
    private FileConvertService fileConvertService;

    @PostMapping("/word2Pdf")
    public ResponseEntity<InputStreamResource> word2Pdf(@RequestParam("file") MultipartFile file) {
        return fileConvertService.word2Pdf(file);
    }
}
