package p067m;

import A3.AbstractC0157z;
import com.android.billingclient.api.C0421m;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzr;
import p050j.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements zzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6115a;
    public Object b;

    public k(int i5) {
        switch (i5) {
            case 1:
                this.f6115a = 0;
                this.b = new Object[2];
                break;
            case 2:
            default:
                this.f6115a = 4095;
                this.b = new String[4096];
                a("$ref", 0, 4, 1185263);
                String str = a.c;
                a(str, 0, str.length(), str.hashCode());
                break;
            case 3:
                this.b = new byte[64];
                break;
        }
    }

    public String a(String str, int i5, int i6, int i7) {
        int i8 = this.f6115a & i7;
        String[] strArr = (String[]) this.b;
        String str2 = strArr[i8];
        if (str2 != null) {
            if (i7 == str2.hashCode() && i6 == str2.length() && str.startsWith(str2, i5)) {
                return str2;
            }
            char[] cArr = new char[i6];
            str.getChars(i5, i6 + i5, cArr, 0);
            return new String(cArr);
        }
        if (i6 != str.length()) {
            char[] cArr2 = new char[i6];
            str.getChars(i5, i6 + i5, cArr2, 0);
            str = new String(cArr2);
        }
        String strIntern = str.intern();
        strArr[i8] = strIntern;
        return strIntern;
    }

    public void b(int i5) {
        byte[] bArr = (byte[]) this.b;
        int length = bArr.length * 2;
        int i6 = this.f6115a;
        int i7 = i5 + i6;
        if (length <= i7) {
            length = i7;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        this.b = bArr2;
    }

    public Object c(int i5) {
        if (i5 >= 0 && i5 < this.f6115a) {
            return ((Object[]) this.b)[i5];
        }
        throw new IllegalArgumentException(AbstractC0157z.l(")", this.f6115a, AbstractC0157z.t(i5, "required: (index >= 0 && index < size) but: (index = ", ", size = ")));
    }

    public void d(int i5, Object obj) {
        int i6;
        if (i5 < 0 || i5 > (i6 = this.f6115a)) {
            throw new IllegalArgumentException(AbstractC0157z.l(")", this.f6115a, AbstractC0157z.t(i5, "required: (index >= 0 && index <= size) but: (index = ", ", size = ")));
        }
        int i7 = i6 + 1;
        Object[] objArr = (Object[]) this.b;
        if (i7 > objArr.length) {
            int length = objArr.length * 2;
            if (length >= i7) {
                i7 = length;
            }
            Object[] objArr2 = new Object[i7];
            for (int i8 = 0; i8 < this.f6115a; i8++) {
                objArr2[i8] = ((Object[]) this.b)[i8];
            }
            this.b = objArr2;
        }
        for (int i9 = this.f6115a; i9 > i5; i9--) {
            Object[] objArr3 = (Object[]) this.b;
            objArr3[i9] = objArr3[i9 - 1];
        }
        ((Object[]) this.b)[i5] = obj;
        this.f6115a++;
    }

    public void e(int i5, int i6) {
        int i7 = this.f6115a;
        int i8 = i7 + 2;
        if (i8 > ((byte[]) this.b).length) {
            b(2);
        }
        byte[] bArr = (byte[]) this.b;
        bArr[i7] = (byte) i5;
        bArr[i7 + 1] = (byte) i6;
        this.f6115a = i8;
    }

    public void f(int i5, int i6) {
        int i7 = this.f6115a;
        int i8 = i7 + 3;
        if (i8 > ((byte[]) this.b).length) {
            b(3);
        }
        byte[] bArr = (byte[]) this.b;
        bArr[i7] = (byte) i5;
        bArr[i7 + 1] = (byte) (i6 >>> 8);
        bArr[i7 + 2] = (byte) i6;
        this.f6115a = i8;
    }

    public void g(int i5) {
        int i6 = this.f6115a;
        int i7 = i6 + 1;
        if (i7 > ((byte[]) this.b).length) {
            b(1);
        }
        ((byte[]) this.b)[i6] = (byte) i5;
        this.f6115a = i7;
    }

    public void h(byte[] bArr, int i5) {
        if (this.f6115a + i5 > ((byte[]) this.b).length) {
            b(i5);
        }
        if (bArr != null) {
            System.arraycopy(bArr, 0, (byte[]) this.b, this.f6115a, i5);
        }
        this.f6115a += i5;
    }

    public void i(int i5) {
        int i6 = this.f6115a;
        int i7 = i6 + 4;
        if (i7 > ((byte[]) this.b).length) {
            b(4);
        }
        byte[] bArr = (byte[]) this.b;
        bArr[i6] = (byte) (i5 >>> 24);
        bArr[i6 + 1] = (byte) (i5 >>> 16);
        bArr[i6 + 2] = (byte) (i5 >>> 8);
        bArr[i6 + 3] = (byte) i5;
        this.f6115a = i7;
    }

    public void j(int i5) {
        int i6 = this.f6115a;
        int i7 = i6 + 2;
        if (i7 > ((byte[]) this.b).length) {
            b(2);
        }
        byte[] bArr = (byte[]) this.b;
        bArr[i6] = (byte) (i5 >>> 8);
        bArr[i6 + 1] = (byte) i5;
        this.f6115a = i7;
    }

    @Override // com.google.android.gms.internal.play_billing.zzr
    public Object zza(zzp zzpVar) {
        C0421m c0421m = (C0421m) this.b;
        c0421m.U(new xyz.doikki.videoplayer.player.k(c0421m, zzpVar, 2), this.f6115a);
        return "reconnectIfNeeded";
    }
}
