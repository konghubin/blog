package cn.hubindeveloper.multitool.service.impl;

import cn.hubindeveloper.common.Utils.RandomUtils;
import cn.hubindeveloper.multitool.domain.vo.BlogFileConvertVo;
import cn.hubindeveloper.multitool.enums.FileTypeEnum;
import cn.hubindeveloper.multitool.mapper.BlogFileConvertMapper;
import cn.hubindeveloper.multitool.service.FileConvertService;
import cn.hutool.core.lang.UUID;
import com.aspose.words.Document;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class FileConvertServiceImpl extends ServiceImpl<BlogFileConvertMapper, BlogFileConvertVo> implements FileConvertService {
    @Autowired
    private BlogFileConvertMapper blogFileConvertMapper;

    public ResponseEntity<InputStreamResource> word2Pdf(MultipartFile file){
        try (
            // 读取许可证文件
            FileInputStream fis = new FileInputStream("MultiTool/src/main/resources/license/AsposeLicense.xml");
            // 用于存储转换后的 PDF 数据
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            // 创建许可证对象并加载许可证
            com.aspose.words.License license = new com.aspose.words.License();
            license.setLicense(fis);

            // 使用 Aspose 库将 word 文件转换为 PDF
            InputStream inputStream = file.getInputStream();
            Document doc = new Document(inputStream);
            doc.save(baos, com.aspose.words.SaveFormat.PDF);

            // 获取转换后的 PDF 数据的字节数组
            byte[] pdfBytes = baos.toByteArray();

            // 创建 InputStreamResource 对象以包装 PDF 数据
            InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(pdfBytes));

            BlogFileConvertVo blogFileConvertVo = new BlogFileConvertVo();
            blogFileConvertVo.setFileUid(RandomUtils.GetRandomUUid("File"));
            blogFileConvertVo.setName(file.getOriginalFilename());
            blogFileConvertVo.setOriginType(FileTypeEnum.WORD.getCode());
            blogFileConvertVo.setConvertType(FileTypeEnum.PDF.getCode());
            blogFileConvertVo.setDescription("");
            blogFileConvertVo.setSize(file.getSize());
            blogFileConvertVo.setCreatorUid(RandomUtils.GetRandomUUid("User"));
            blogFileConvertVo.setCreateTime(System.currentTimeMillis());

            blogFileConvertMapper.insert(blogFileConvertVo);

            // 创建 HTTP 响应头部
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "pdf", StandardCharsets.UTF_8));
            return ResponseEntity.ok().headers(headers) // 设置响应头
                    .contentLength(pdfBytes.length) // 设置 Content-Length 为 PDF 数据的字节长度
                    .body(inputStreamResource); // 设置响应体;
        } catch (Exception e) {
            // 记录异常信息，并返回 500 Internal Server Error 响应
            e.printStackTrace();
        }
        return null;
    }
}
