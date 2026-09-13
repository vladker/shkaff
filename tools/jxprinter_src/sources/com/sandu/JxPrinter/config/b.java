package com.sandu.JxPrinter.config;

import S4.d;
import p137y.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements p037g0.a {
    @Override // p037g0.a
    public final void activateDeviceFailed(int i5, String str) {
        p051j0.a.d("VIP激活", "激活请求失败: " + str + " (code: " + i5 + ")");
    }

    @Override // p037g0.a
    public final void activateDeviceSuccess(int i5) {
        p051j0.a.c("VIP激活", "激活流程完成，结果码: " + i5);
        d.b().f(new u(i5));
    }
}
