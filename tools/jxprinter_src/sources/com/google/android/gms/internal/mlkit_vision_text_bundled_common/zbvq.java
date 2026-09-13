package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbvq implements zbvx {
    private final zbvm zba;
    private final zbwl zbb;
    private final boolean zbc;
    private final zbtq zbd;

    private zbvq(zbwl zbwlVar, zbtq zbtqVar, zbvm zbvmVar) {
        this.zbb = zbwlVar;
        this.zbc = zbvmVar instanceof zbub;
        this.zbd = zbtqVar;
        this.zba = zbvmVar;
    }

    public static zbvq zbc(zbwl zbwlVar, zbtq zbtqVar, zbvm zbvmVar) {
        return new zbvq(zbwlVar, zbtqVar, zbvmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zba(Object obj) {
        int iZbb = ((zbuf) obj).zbc.zbb();
        return this.zbc ? iZbb + ((zbub) obj).zbb.zbc() : iZbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zbb(Object obj) {
        int iHashCode = ((zbuf) obj).zbc.hashCode();
        return this.zbc ? (iHashCode * 53) + ((zbub) obj).zbb.zba.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final Object zbe() {
        zbvm zbvmVar = this.zba;
        return zbvmVar instanceof zbuf ? ((zbuf) zbvmVar).zbt() : zbvmVar.zbJ().zbl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbf(Object obj) {
        this.zbb.zbb(obj);
        this.zbd.zba(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbg(Object obj, Object obj2) {
        zbvz.zbp(this.zbb, obj, obj2);
        if (this.zbc) {
            zbvz.zbo(this.zbd, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8 A[EDGE_INSN: B:61:0x00b8->B:33:0x00b8 BREAK  A[LOOP:1: B:17:0x0064->B:64:0x0064], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbh(Object obj, byte[] bArr, int i5, int i6, zbsq zbsqVar) throws zbuq {
        int iZbk;
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVarZbf = zbufVar.zbc;
        if (zbwmVarZbf == zbwm.zbc()) {
            zbwmVarZbf = zbwm.zbf();
            zbufVar.zbc = zbwmVarZbf;
        }
        zbwm zbwmVar = zbwmVarZbf;
        zbtu zbtuVarZbg = ((zbub) obj).zbg();
        zbud zbudVarZbc = null;
        while (i5 < i6) {
            int iZbk2 = zbsr.zbk(bArr, i5, zbsqVar);
            int i7 = zbsqVar.zba;
            if (i7 == 11) {
                int i8 = i6;
                zbsq zbsqVar2 = zbsqVar;
                int i9 = 0;
                zbtc zbtcVar = null;
                while (true) {
                    if (iZbk2 >= i8) {
                        iZbk = iZbk2;
                        break;
                    }
                    iZbk = zbsr.zbk(bArr, iZbk2, zbsqVar2);
                    int i10 = zbsqVar2.zba;
                    int i11 = i10 >>> 3;
                    int i12 = i10 & 7;
                    if (i11 == 2) {
                        if (i12 != 0) {
                            if (i10 != 12) {
                                break;
                                break;
                            }
                            iZbk2 = zbsr.zbq(i10, bArr, iZbk, i8, zbsqVar2);
                        } else {
                            iZbk2 = zbsr.zbk(bArr, iZbk, zbsqVar2);
                            i9 = zbsqVar2.zba;
                            zbudVarZbc = zbsqVar2.zbd.zbc(this.zba, i9);
                        }
                    } else {
                        if (i11 == 3) {
                            if (zbudVarZbc != null) {
                                iZbk2 = zbsr.zbe(zbvu.zba().zbb(zbudVarZbc.zba.getClass()), bArr, iZbk, i8, zbsqVar2);
                                zbtuVarZbg.zbj(zbudVarZbc.zbb, zbsqVar2.zbc);
                            } else if (i12 == 2) {
                                iZbk2 = zbsr.zba(bArr, iZbk, zbsqVar2);
                                zbtcVar = (zbtc) zbsqVar2.zbc;
                            }
                        }
                        if (i10 != 12) {
                            break;
                        } else {
                            iZbk2 = zbsr.zbq(i10, bArr, iZbk, i8, zbsqVar2);
                        }
                    }
                }
                if (zbtcVar != null) {
                    zbwmVar.zbj((i9 << 3) | 2, zbtcVar);
                }
                i5 = iZbk;
                i6 = i8;
                zbsqVar = zbsqVar2;
            } else if ((i7 & 7) == 2) {
                zbudVarZbc = zbsqVar.zbd.zbc(this.zba, i7 >>> 3);
                if (zbudVarZbc != null) {
                    i5 = zbsr.zbe(zbvu.zba().zbb(zbudVarZbc.zba.getClass()), bArr, iZbk2, i6, zbsqVar);
                    zbtuVarZbg.zbj(zbudVarZbc.zbb, zbsqVar.zbc);
                } else {
                    i5 = zbsr.zbj(i7, bArr, iZbk2, i6, zbwmVar, zbsqVar);
                }
            } else {
                i5 = zbsr.zbq(i7, bArr, iZbk2, i6, zbsqVar);
            }
        }
        if (i5 != i6) {
            throw new zbuq("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbi(Object obj, zbwy zbwyVar) {
        Iterator itZbg = ((zbub) obj).zbb.zbg();
        while (itZbg.hasNext()) {
            Map.Entry entry = (Map.Entry) itZbg.next();
            zbtt zbttVar = (zbtt) entry.getKey();
            if (zbttVar.zbe() != zbwx.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zbttVar.zbg();
            zbttVar.zbf();
            if (entry instanceof zbut) {
                zbttVar.zba();
                zbwyVar.zbx(32149011, ((zbut) entry).zba().zbb());
            } else {
                zbttVar.zba();
                zbwyVar.zbx(32149011, entry.getValue());
            }
        }
        ((zbuf) obj).zbc.zbk(zbwyVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbj(Object obj, Object obj2) {
        if (!((zbuf) obj).zbc.equals(((zbuf) obj2).zbc)) {
            return false;
        }
        if (this.zbc) {
            return ((zbub) obj).zbb.equals(((zbub) obj2).zbb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbk(Object obj) {
        return ((zbub) obj).zbb.zbm();
    }
}
