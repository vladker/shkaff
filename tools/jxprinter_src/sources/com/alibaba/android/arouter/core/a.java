package com.alibaba.android.arouter.core;

import com.alibaba.android.arouter.facade.enums.RouteType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2416a;

    static {
        int[] iArr = new int[RouteType.values().length];
        f2416a = iArr;
        try {
            iArr[RouteType.PROVIDER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2416a[RouteType.FRAGMENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
