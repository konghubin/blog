package cn.hubindeveloper.multitool.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileTypeEnum {
    WORD(0, "word"),
    PDF(1, "pdf"),
    EXCEL(2, "excel"),
    PPT(3, "ppt");

    private final Integer code;
    private final String fileType;
}
