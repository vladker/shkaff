package cn.fly.tools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StringPart extends HTTPPart {
    private StringBuilder sb = new StringBuilder();

    public StringPart append(String str) {
        this.sb.append(str);
        return this;
    }

    @Override // cn.fly.tools.network.HTTPPart
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.sb.toString().getBytes("utf-8"));
    }

    @Override // cn.fly.tools.network.HTTPPart
    public long length() {
        return this.sb.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.sb.toString();
    }
}
