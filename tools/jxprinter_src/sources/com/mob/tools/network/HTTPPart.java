package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HTTPPart implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3649a;
    private OnReadListener b;

    public abstract InputStream getInputStream();

    public Object getInputStreamEntity() {
        InputStream inputStream = toInputStream();
        long length = length() - this.f3649a;
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        return ReflectHelper.newInstance("InputStreamEntity", inputStream, Long.valueOf(length));
    }

    public OnReadListener getListener() {
        return this.b;
    }

    public abstract long length();

    public void setOffset(long j6) {
        this.f3649a = j6;
    }

    public void setOnReadListener(OnReadListener onReadListener) {
        this.b = onReadListener;
    }

    public InputStream toInputStream() {
        return new ByteCounterInputStream(getInputStream());
    }
}
