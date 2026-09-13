package com.mob.tools.network.wrapper;

import cn.fly.tools.network.HTTPPart;
import cn.fly.tools.network.OnReadListener;
import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class a extends HTTPPart {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mob.tools.network.HTTPPart f3660a;

    private a(final com.mob.tools.network.HTTPPart hTTPPart) {
        this.f3660a = hTTPPart;
        if (hTTPPart.getListener() != null) {
            new OnReadListener() { // from class: com.mob.tools.network.wrapper.a.1
                @Override // cn.fly.tools.network.OnReadListener
                public void onRead(long j6) {
                    hTTPPart.getListener().onRead(j6);
                }
            };
        }
    }

    public static a a(com.mob.tools.network.HTTPPart hTTPPart) {
        if (hTTPPart == null) {
            return null;
        }
        return new a(hTTPPart);
    }

    @Override // cn.fly.tools.network.HTTPPart
    public InputStream getInputStream() {
        return (InputStream) ReflectHelper.invokeInstanceMethod(this.f3660a, "getInputStream", new Object[0]);
    }

    @Override // cn.fly.tools.network.HTTPPart
    public long length() {
        return ((Long) ReflectHelper.invokeInstanceMethod(this.f3660a, "length", new Object[0])).longValue();
    }
}
