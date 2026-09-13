package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdf implements Iterable, Serializable {
    public static final zzdf zzb = new zzde(zzep.zzb);
    private int zza = 0;

    static {
        int i5 = zzct.zza;
    }

    private static zzdf zzc(Iterator it, int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException(a.i(i5, "length (", ") must be >= 1"));
        }
        if (i5 == 1) {
            return (zzdf) it.next();
        }
        int i6 = i5 >>> 1;
        zzdf zzdfVarZzc = zzc(it, i6);
        zzdf zzdfVarZzc2 = zzc(it, i5 - i6);
        if (Integer.MAX_VALUE - zzdfVarZzc.zzd() >= zzdfVarZzc2.zzd()) {
            return zzgd.zzy(zzdfVarZzc, zzdfVarZzc2);
        }
        throw new IllegalArgumentException(a.h(zzdfVarZzc.zzd(), zzdfVarZzc2.zzd(), "ByteString would be too long: ", "+"));
    }

    public static int zzo(int i5, int i6, int i7) {
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

    public static zzdf zzr(byte[] bArr, int i5, int i6) {
        zzo(i5, i5 + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        return new zzde(bArr2);
    }

    public static zzdf zzs(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i5 = 0;
            while (i5 < iMin) {
                int i6 = inputStream.read(bArr, i5, iMin - i5);
                if (i6 == -1) {
                    break;
                }
                i5 += i6;
            }
            zzdf zzdfVarZzr = i5 == 0 ? null : zzr(bArr, 0, i5);
            if (zzdfVarZzr == null) {
                break;
            }
            arrayList.add(zzdfVarZzr);
            iMin = Math.min(iMin + iMin, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : zzc(arrayList.iterator(), size);
    }

    public static void zzu(int i5, int i6) {
        if (((i6 - (i5 + 1)) | i5) < 0) {
            if (i5 >= 0) {
                throw new ArrayIndexOutOfBoundsException(a.h(i5, i6, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.k(i5, "Index < 0: "));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zza;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zza = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strZza = zzd() <= 50 ? zzgq.zza(this) : zzgq.zza(zzk(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzd);
        sb.append(" contents=\"");
        return AbstractC0157z.s(sb, strZza, "\">");
    }

    public abstract byte zza(int i5);

    public abstract byte zzb(int i5);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i5, int i6, int i7);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i5, int i6, int i7);

    public abstract int zzj(int i5, int i6, int i7);

    public abstract zzdf zzk(int i5, int i6);

    public abstract String zzl(Charset charset);

    public abstract void zzm(zzcx zzcxVar);

    public abstract boolean zzn();

    public final int zzp() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzdb iterator() {
        return new zzcy(this);
    }

    public final String zzt() {
        return zzd() == 0 ? "" : zzl(zzep.zza);
    }

    @Deprecated
    public final void zzv(byte[] bArr, int i5, int i6, int i7) {
        zzo(0, i7, zzd());
        zzo(i6, i6 + i7, bArr.length);
        if (i7 > 0) {
            zze(bArr, 0, i6, i7);
        }
    }

    public final byte[] zzw() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzep.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
