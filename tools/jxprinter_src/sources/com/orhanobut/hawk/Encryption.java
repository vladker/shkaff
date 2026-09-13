package com.orhanobut.hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
interface Encryption {
    String decrypt(String str, String str2);

    String encrypt(String str, String str2);

    boolean init();
}
