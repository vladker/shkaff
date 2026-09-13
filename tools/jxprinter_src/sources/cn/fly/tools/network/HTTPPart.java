package cn.fly.tools.network;

import cn.fly.tools.proguard.EverythingKeeper;
import cn.fly.tools.utils.ReflectHelper;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class HTTPPart implements EverythingKeeper {
    private OnReadListener listener;
    private long offset;

    public abstract InputStream getInputStream();

    public Object getInputStreamEntity() {
        InputStream inputStream = toInputStream();
        long length = length() - this.offset;
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        return ReflectHelper.newInstance("InputStreamEntity", inputStream, Long.valueOf(length));
    }

    public abstract long length();

    public void setOffset(long j6) {
        this.offset = j6;
    }

    public void setOnReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }

    public InputStream toInputStream() {
        return new ByteCounterInputStream(getInputStream());
    }
}
