package com.hjq.permissions;

import android.os.Build;

/* JADX INFO: renamed from: com.hjq.permissions.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0550c {
    public static final int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3549a;
    public int b;
    public int c;

    static {
        if (Build.VERSION.SDK_INT >= 31) {
            d = 65536;
        } else {
            d = 65536;
        }
    }
}
