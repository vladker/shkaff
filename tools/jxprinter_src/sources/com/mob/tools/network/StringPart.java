package com.mob.tools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class StringPart extends HTTPPart {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f3658a = new StringBuilder();

    public StringPart append(String str) {
        this.f3658a.append(str);
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f3658a.toString().getBytes("utf-8"));
    }

    @Override // com.mob.tools.network.HTTPPart
    public long length() {
        return this.f3658a.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.f3658a.toString();
    }
}
