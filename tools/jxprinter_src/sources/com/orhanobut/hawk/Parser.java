package com.orhanobut.hawk;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface Parser {
    <T> T fromJson(String str, Type type);

    String toJson(Object obj);
}
