package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zbtc implements Iterable, Serializable {
    public static final zbtc zbb = new zbtb(zbuo.zbb);
    private int zba = 0;

    static {
        int i5 = zbsm.zba;
    }

    public static int zbh(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(a.i(i5, "Beginning index: ", " < 0"));
        }
        if (i6 < i5) {
            throw new IndexOutOfBoundsException(a.h(i5, i6, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(a.h(i6, i7, "End index: ", " >= "));
    }

    public static zbtc zbj(byte[] bArr, int i5, int i6) {
        zbh(i5, i5 + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        return new zbtb(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZbe = this.zba;
        if (iZbe == 0) {
            int iZbd = zbd();
            iZbe = zbe(iZbd, 0, iZbd);
            if (iZbe == 0) {
                iZbe = 1;
            }
            this.zba = iZbe;
        }
        return iZbe;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zbsu(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZbd = zbd();
        String strZba = zbd() <= 50 ? zbwj.zba(this) : zbwj.zba(zbf(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZbd);
        sb.append(" contents=\"");
        return AbstractC0157z.s(sb, strZba, "\">");
    }

    public abstract byte zba(int i5);

    public abstract byte zbb(int i5);

    public abstract int zbd();

    public abstract int zbe(int i5, int i6, int i7);

    public abstract zbtc zbf(int i5, int i6);

    public abstract void zbg(zbst zbstVar);

    public final int zbi() {
        return this.zba;
    }
}
