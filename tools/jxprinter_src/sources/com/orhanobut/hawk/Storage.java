package com.orhanobut.hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface Storage {
    boolean contains(String str);

    long count();

    boolean delete(String str);

    boolean deleteAll();

    <T> T get(String str);

    <T> boolean put(String str, T t6);
}
