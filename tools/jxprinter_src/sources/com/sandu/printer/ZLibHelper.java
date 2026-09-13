package com.sandu.printer;

import p134x2.d1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ZLibHelper {
    public static final d1 Companion = new d1();

    static {
        System.loadLibrary("printer_zlib");
    }

    public final native byte[] compress(byte[] bArr, int i5);
}
