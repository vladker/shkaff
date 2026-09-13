package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ boolean a(Unsafe unsafe, AbstractFuture abstractFuture, long j6, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(abstractFuture, j6, obj, obj2)) {
            if (unsafe.getObject(abstractFuture, j6) != obj) {
                return false;
            }
        }
        return true;
    }
}
