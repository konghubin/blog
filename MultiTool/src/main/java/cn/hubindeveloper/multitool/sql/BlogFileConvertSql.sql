CREATE TABLE `blog_file_convert` (
    `ID` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `FILE_UID` varchar(64) NOT NULL COMMENT '文件UID',
    `NAME` varchar(512) NOT NULL DEFAULT '' COMMENT '文件名称',
    `ORIGIN_TYPE` varchar(128) NOT NULL DEFAULT '' COMMENT '原来文件类型',
    `CONVERT_TYPE` varchar(128) NOT NULL DEFAULT '' COMMENT '转换后文件类型',
    `DESCRIPTION` varchar(2048) NOT NULL DEFAULT '' COMMENT '备注',
    `SIZE` bigint NOT NULL DEFAULT '0' COMMENT '文件大小',
    `CREATOR_UID` varchar(64) NOT NULL DEFAULT '' COMMENT '创建者UID',
    `CREATE_TIME` bigint NOT NULL DEFAULT '0' COMMENT '创建时间',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `UN_FILE_UID` (`FILE_UID`) USING BTREE,
    KEY `NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='文件转换记录表'