package com.mob.tools.network;

import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ByteArrayPart extends HTTPPart {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteArrayOutputStream f3646a;

    public ByteArrayPart append(byte[] bArr) throws IOException {
        if (this.f3646a == null) {
            this.f3646a = new ByteArrayOutputStream(bArr.length);
        }
        this.f3646a.write(bArr);
        this.f3646a.flush();
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    public InputStream getInputStream() {
        ByteArrayOutputStream byteArrayOutputStream = this.f3646a;
        if (byteArrayOutputStream == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return (byteArray == null || this.f3646a.size() <= 0) ? new ByteArrayInputStream(new byte[0]) : new ByteArrayInputStream(byteArray, 0, this.f3646a.size());
    }

    @Override // com.mob.tools.network.HTTPPart
    public long length() {
        ByteArrayOutputStream byteArrayOutputStream = this.f3646a;
        if (byteArrayOutputStream == null) {
            return 0L;
        }
        return byteArrayOutputStream.size();
    }

    public String toString() {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = this.f3646a;
        if (byteArrayOutputStream == null || (byteArray = byteArrayOutputStream.toByteArray()) == null) {
            return null;
        }
        return Data.byteToHex(byteArray, 0, this.f3646a.size());
    }
}
