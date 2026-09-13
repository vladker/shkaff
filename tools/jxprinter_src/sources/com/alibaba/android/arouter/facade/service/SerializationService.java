package com.alibaba.android.arouter.facade.service;

import com.alibaba.android.arouter.facade.template.IProvider;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface SerializationService extends IProvider {
    @Deprecated
    <T> T json2Object(String str, Class<T> cls);

    String object2Json(Object obj);

    <T> T parseObject(String str, Type type);
}
