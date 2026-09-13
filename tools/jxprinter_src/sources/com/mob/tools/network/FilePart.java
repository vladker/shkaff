package com.mob.tools.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FilePart extends HTTPPart {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f3648a;

    public File getFile() {
        return this.f3648a;
    }

    @Override // com.mob.tools.network.HTTPPart
    public InputStream getInputStream() {
        return new FileInputStream(this.f3648a);
    }

    @Override // com.mob.tools.network.HTTPPart
    public long length() {
        return this.f3648a.length();
    }

    public void setFile(File file) {
        this.f3648a = file;
    }

    public String toString() {
        return this.f3648a.toString();
    }

    public void setFile(String str) {
        this.f3648a = new File(str);
    }
}
