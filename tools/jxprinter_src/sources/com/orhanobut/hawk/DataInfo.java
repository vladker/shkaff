package com.orhanobut.hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class DataInfo {
    static final char TYPE_LIST = '1';
    static final char TYPE_MAP = '2';
    static final char TYPE_OBJECT = '0';
    static final char TYPE_SET = '3';
    final String cipherText;
    final char dataType;
    final Class keyClazz;
    final Class valueClazz;

    public DataInfo(char c, String str, Class cls, Class cls2) {
        this.cipherText = str;
        this.keyClazz = cls;
        this.valueClazz = cls2;
        this.dataType = c;
    }
}
