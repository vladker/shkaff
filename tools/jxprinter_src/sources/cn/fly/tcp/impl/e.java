package cn.fly.tcp.impl;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1552a;
    public final int b;
    public long c;
    public String d;

    public e(int i5) {
        this(i5, null);
    }

    public static e b(ByteBuffer byteBuffer) {
        int i5;
        e eVarC = c(byteBuffer);
        if (eVarC != null && (i5 = eVarC.f1552a) > 0) {
            if (i5 > byteBuffer.remaining()) {
                return null;
            }
            byte[] bArr = new byte[eVarC.f1552a];
            byteBuffer.get(bArr);
            eVarC.d = new String(bArr);
        }
        return eVarC;
    }

    public static e c(ByteBuffer byteBuffer) {
        if (byteBuffer.get() != 1) {
            return null;
        }
        int i5 = byteBuffer.getInt();
        int i6 = byteBuffer.getInt();
        if (i6 > 9999) {
            return null;
        }
        return new e(i5, i6, byteBuffer.getLong(), null);
    }

    public byte[] a() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(b());
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.putInt(this.f1552a);
        byteBufferAllocate.putInt(this.b);
        byteBufferAllocate.putLong(this.c);
        String str = this.d;
        if (str != null) {
            byteBufferAllocate.put(str.getBytes(Charset.forName("UTF-8")));
        }
        return byteBufferAllocate.array();
    }

    public e(int i5, String str) {
        this(str != null ? str.length() : 0, i5, 0L, str);
    }

    public e(int i5, int i6, long j6, String str) {
        this.f1552a = i5;
        this.b = i6;
        this.c = j6;
        this.d = str;
    }

    public int b() {
        return this.f1552a + 17;
    }

    public static List<e> a(ByteBuffer byteBuffer) {
        e eVarB;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.remaining() >= 17 && (eVarB = b(byteBuffer)) != null) {
            arrayList.add(eVarB);
        }
        return arrayList;
    }
}
