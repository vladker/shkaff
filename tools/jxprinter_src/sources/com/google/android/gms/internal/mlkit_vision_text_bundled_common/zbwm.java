package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbwm {
    private static final zbwm zba = new zbwm(0, new int[0], new Object[0], false);
    private int zbb;
    private int[] zbc;
    private Object[] zbd;
    private int zbe;
    private boolean zbf;

    private zbwm(int i5, int[] iArr, Object[] objArr, boolean z6) {
        this.zbe = -1;
        this.zbb = i5;
        this.zbc = iArr;
        this.zbd = objArr;
        this.zbf = z6;
    }

    public static zbwm zbc() {
        return zba;
    }

    public static zbwm zbe(zbwm zbwmVar, zbwm zbwmVar2) {
        int i5 = zbwmVar.zbb + zbwmVar2.zbb;
        int[] iArrCopyOf = Arrays.copyOf(zbwmVar.zbc, i5);
        System.arraycopy(zbwmVar2.zbc, 0, iArrCopyOf, zbwmVar.zbb, zbwmVar2.zbb);
        Object[] objArrCopyOf = Arrays.copyOf(zbwmVar.zbd, i5);
        System.arraycopy(zbwmVar2.zbd, 0, objArrCopyOf, zbwmVar.zbb, zbwmVar2.zbb);
        return new zbwm(i5, iArrCopyOf, objArrCopyOf, true);
    }

    public static zbwm zbf() {
        return new zbwm(0, new int[8], new Object[8], true);
    }

    private final void zbm(int i5) {
        int[] iArr = this.zbc;
        if (i5 > iArr.length) {
            int i6 = this.zbb;
            int i7 = (i6 / 2) + i6;
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.zbc = Arrays.copyOf(iArr, i5);
            this.zbd = Arrays.copyOf(this.zbd, i5);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zbwm)) {
            return false;
        }
        zbwm zbwmVar = (zbwm) obj;
        int i5 = this.zbb;
        if (i5 == zbwmVar.zbb) {
            int[] iArr = this.zbc;
            int[] iArr2 = zbwmVar.zbc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (iArr[i6] == iArr2[i6]) {
                }
            }
            Object[] objArr = this.zbd;
            Object[] objArr2 = zbwmVar.zbd;
            int i7 = this.zbb;
            for (int i8 = 0; i8 < i7; i8++) {
                if (objArr[i8].equals(objArr2[i8])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.zbb;
        int i6 = i5 + 527;
        int[] iArr = this.zbc;
        int iHashCode = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i5; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = ((i6 * 31) + i7) * 31;
        Object[] objArr = this.zbd;
        int i10 = this.zbb;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return i9 + iHashCode;
    }

    public final int zba() {
        int iZbD;
        int iZbE;
        int iZbD2;
        int i5 = this.zbe;
        if (i5 != -1) {
            return i5;
        }
        int iZbD3 = 0;
        for (int i6 = 0; i6 < this.zbb; i6++) {
            int i7 = this.zbc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 == 2) {
                        int i10 = i8 << 3;
                        zbtc zbtcVar = (zbtc) this.zbd[i6];
                        int iZbD4 = zbtk.zbD(i10);
                        int iZbd = zbtcVar.zbd();
                        iZbD3 = zbtk.zbD(iZbd) + iZbd + iZbD4 + iZbD3;
                    } else if (i9 == 3) {
                        int iZbD5 = zbtk.zbD(i8 << 3);
                        iZbD = iZbD5 + iZbD5;
                        iZbE = ((zbwm) this.zbd[i6]).zba();
                    } else {
                        if (i9 != 5) {
                            throw new IllegalStateException(new zbup("Protocol message tag had invalid wire type."));
                        }
                        ((Integer) this.zbd[i6]).getClass();
                        iZbD2 = zbtk.zbD(i8 << 3) + 4;
                    }
                } else {
                    ((Long) this.zbd[i6]).getClass();
                    iZbD2 = zbtk.zbD(i8 << 3) + 8;
                }
                iZbD3 = iZbD2 + iZbD3;
            } else {
                int i11 = i8 << 3;
                long jLongValue = ((Long) this.zbd[i6]).longValue();
                iZbD = zbtk.zbD(i11);
                iZbE = zbtk.zbE(jLongValue);
            }
            iZbD3 = iZbE + iZbD + iZbD3;
        }
        this.zbe = iZbD3;
        return iZbD3;
    }

    public final int zbb() {
        int i5 = this.zbe;
        if (i5 != -1) {
            return i5;
        }
        int iA = 0;
        for (int i6 = 0; i6 < this.zbb; i6++) {
            int i7 = this.zbc[i6] >>> 3;
            zbtc zbtcVar = (zbtc) this.zbd[i6];
            int iZbD = zbtk.zbD(8);
            int iZbD2 = zbtk.zbD(i7) + zbtk.zbD(16);
            int iZbD3 = zbtk.zbD(24);
            int iZbd = zbtcVar.zbd();
            iA += iZbD + iZbD + iZbD2 + a.A(iZbd, iZbd, iZbD3);
        }
        this.zbe = iA;
        return iA;
    }

    public final zbwm zbd(zbwm zbwmVar) {
        if (zbwmVar.equals(zba)) {
            return this;
        }
        zbg();
        int i5 = this.zbb + zbwmVar.zbb;
        zbm(i5);
        System.arraycopy(zbwmVar.zbc, 0, this.zbc, this.zbb, zbwmVar.zbb);
        System.arraycopy(zbwmVar.zbd, 0, this.zbd, this.zbb, zbwmVar.zbb);
        this.zbb = i5;
        return this;
    }

    public final void zbg() {
        if (!this.zbf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zbh() {
        if (this.zbf) {
            this.zbf = false;
        }
    }

    public final void zbi(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.zbb; i6++) {
            zbvo.zbb(sb, i5, String.valueOf(this.zbc[i6] >>> 3), this.zbd[i6]);
        }
    }

    public final void zbj(int i5, Object obj) {
        zbg();
        zbm(this.zbb + 1);
        int[] iArr = this.zbc;
        int i6 = this.zbb;
        iArr[i6] = i5;
        this.zbd[i6] = obj;
        this.zbb = i6 + 1;
    }

    public final void zbk(zbwy zbwyVar) {
        for (int i5 = 0; i5 < this.zbb; i5++) {
            zbwyVar.zbx(this.zbc[i5] >>> 3, this.zbd[i5]);
        }
    }

    public final void zbl(zbwy zbwyVar) {
        if (this.zbb != 0) {
            for (int i5 = 0; i5 < this.zbb; i5++) {
                int i6 = this.zbc[i5];
                Object obj = this.zbd[i5];
                int i7 = i6 & 7;
                int i8 = i6 >>> 3;
                if (i7 == 0) {
                    zbwyVar.zbt(i8, ((Long) obj).longValue());
                } else if (i7 == 1) {
                    zbwyVar.zbm(i8, ((Long) obj).longValue());
                } else if (i7 == 2) {
                    zbwyVar.zbd(i8, (zbtc) obj);
                } else if (i7 == 3) {
                    zbwyVar.zbG(i8);
                    ((zbwm) obj).zbl(zbwyVar);
                    zbwyVar.zbh(i8);
                } else {
                    if (i7 != 5) {
                        throw new RuntimeException(new zbup("Protocol message tag had invalid wire type."));
                    }
                    zbwyVar.zbk(i8, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zbwm() {
        this(0, new int[8], new Object[8], true);
    }
}
