package cn.hubindeveloper.multitool.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("blog_file_convert")
@Data
public class BlogFileConvertVo {
    private Long id;

    private String fileUid;

    private String name;

    private Integer originType;

    private Integer convertType;

    private String description;

    private Long size;

    private String creatorUid;

    private Long createTime;

    private Long updateTime;

    private Long deleteTime;
}
