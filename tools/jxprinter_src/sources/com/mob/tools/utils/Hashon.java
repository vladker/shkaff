package com.mob.tools.utils;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class Hashon implements PublicMemberKeeper {
    public String format(String str) {
        return cn.fly.tools.utils.HashonHelper.format(str);
    }

    public <T> String fromHashMap(HashMap<String, T> map) {
        return cn.fly.tools.utils.HashonHelper.fromHashMap(map);
    }

    public <T> HashMap<String, T> fromJson(String str) {
        return cn.fly.tools.utils.HashonHelper.fromJson(str);
    }

    public String fromObject(Object obj) {
        return cn.fly.tools.utils.HashonHelper.fromObject(obj);
    }

    public <T> T fromJson(String str, Class<T> cls) {
        return (T) cn.fly.tools.utils.HashonHelper.fromJson(str, cls);
    }
}
