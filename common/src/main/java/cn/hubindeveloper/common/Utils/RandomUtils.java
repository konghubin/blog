package cn.hubindeveloper.common.Utils;

import cn.hutool.core.lang.UUID;

public class RandomUtils {
    public static String GetRandomUUid(String pre){
        return pre + "_" + UUID.randomUUID();
    }
}
