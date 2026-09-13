package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbtl implements zbwy {
    private final zbtk zba;

    private zbtl(zbtk zbtkVar) {
        byte[] bArr = zbuo.zbb;
        this.zba = zbtkVar;
        zbtkVar.zba = this;
    }

    public static zbtl zba(zbtk zbtkVar) {
        zbtl zbtlVar = zbtkVar.zba;
        return zbtlVar != null ? zbtlVar : new zbtl(zbtkVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbA(int i5, long j6) {
        this.zba.zbj(i5, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbB(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbva)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbj(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            this.zba.zbw(i7);
            while (i6 < list.size()) {
                this.zba.zbk(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z6) {
            while (i6 < zbvaVar.size()) {
                this.zba.zbj(i5, zbvaVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zbvaVar.size(); i10++) {
            zbvaVar.zbe(i10);
            i9 += 8;
        }
        this.zba.zbw(i9);
        while (i6 < zbvaVar.size()) {
            this.zba.zbk(zbvaVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbC(int i5, int i6) {
        this.zba.zbv(i5, (i6 >> 31) ^ (i6 + i6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbD(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbug)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zbtk zbtkVar = this.zba;
                    int iIntValue = ((Integer) list.get(i6)).intValue();
                    zbtkVar.zbv(i5, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int iZbD = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int iIntValue2 = ((Integer) list.get(i7)).intValue();
                iZbD += zbtk.zbD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zba.zbw(iZbD);
            while (i6 < list.size()) {
                zbtk zbtkVar2 = this.zba;
                int iIntValue3 = ((Integer) list.get(i6)).intValue();
                zbtkVar2.zbw((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i6++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z6) {
            while (i6 < zbugVar.size()) {
                zbtk zbtkVar3 = this.zba;
                int iZbe = zbugVar.zbe(i6);
                zbtkVar3.zbv(i5, (iZbe >> 31) ^ (iZbe + iZbe));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int iZbD2 = 0;
        for (int i8 = 0; i8 < zbugVar.size(); i8++) {
            int iZbe2 = zbugVar.zbe(i8);
            iZbD2 += zbtk.zbD((iZbe2 >> 31) ^ (iZbe2 + iZbe2));
        }
        this.zba.zbw(iZbD2);
        while (i6 < zbugVar.size()) {
            zbtk zbtkVar4 = this.zba;
            int iZbe3 = zbugVar.zbe(i6);
            zbtkVar4.zbw((iZbe3 >> 31) ^ (iZbe3 + iZbe3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbE(int i5, long j6) {
        this.zba.zbx(i5, (j6 >> 63) ^ (j6 + j6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbF(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbva)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zbtk zbtkVar = this.zba;
                    long jLongValue = ((Long) list.get(i6)).longValue();
                    zbtkVar.zbx(i5, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int iZbE = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long jLongValue2 = ((Long) list.get(i7)).longValue();
                iZbE += zbtk.zbE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zba.zbw(iZbE);
            while (i6 < list.size()) {
                zbtk zbtkVar2 = this.zba;
                long jLongValue3 = ((Long) list.get(i6)).longValue();
                zbtkVar2.zby((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i6++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z6) {
            while (i6 < zbvaVar.size()) {
                zbtk zbtkVar3 = this.zba;
                long jZbe = zbvaVar.zbe(i6);
                zbtkVar3.zbx(i5, (jZbe >> 63) ^ (jZbe + jZbe));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int iZbE2 = 0;
        for (int i8 = 0; i8 < zbvaVar.size(); i8++) {
            long jZbe2 = zbvaVar.zbe(i8);
            iZbE2 += zbtk.zbE((jZbe2 >> 63) ^ (jZbe2 + jZbe2));
        }
        this.zba.zbw(iZbE2);
        while (i6 < zbvaVar.size()) {
            zbtk zbtkVar4 = this.zba;
            long jZbe3 = zbvaVar.zbe(i6);
            zbtkVar4.zby((jZbe3 >> 63) ^ (jZbe3 + jZbe3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    @Deprecated
    public final void zbG(int i5) {
        this.zba.zbu(i5, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbH(int i5, String str) {
        this.zba.zbs(i5, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbI(int i5, List list) {
        int i6 = 0;
        if (!(list instanceof zbux)) {
            while (i6 < list.size()) {
                this.zba.zbs(i5, (String) list.get(i6));
                i6++;
            }
            return;
        }
        zbux zbuxVar = (zbux) list;
        while (i6 < list.size()) {
            Object objZba = zbuxVar.zba();
            if (objZba instanceof String) {
                this.zba.zbs(i5, (String) objZba);
            } else {
                this.zba.zbf(i5, (zbtc) objZba);
            }
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbJ(int i5, int i6) {
        this.zba.zbv(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbK(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbug)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbv(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int iZbD = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZbD += zbtk.zbD(((Integer) list.get(i7)).intValue());
            }
            this.zba.zbw(iZbD);
            while (i6 < list.size()) {
                this.zba.zbw(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z6) {
            while (i6 < zbugVar.size()) {
                this.zba.zbv(i5, zbugVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int iZbD2 = 0;
        for (int i8 = 0; i8 < zbugVar.size(); i8++) {
            iZbD2 += zbtk.zbD(zbugVar.zbe(i8));
        }
        this.zba.zbw(iZbD2);
        while (i6 < zbugVar.size()) {
            this.zba.zbw(zbugVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbL(int i5, long j6) {
        this.zba.zbx(i5, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbM(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbva)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbx(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int iZbE = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZbE += zbtk.zbE(((Long) list.get(i7)).longValue());
            }
            this.zba.zbw(iZbE);
            while (i6 < list.size()) {
                this.zba.zby(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z6) {
            while (i6 < zbvaVar.size()) {
                this.zba.zbx(i5, zbvaVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int iZbE2 = 0;
        for (int i8 = 0; i8 < zbvaVar.size(); i8++) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i8));
        }
        this.zba.zbw(iZbE2);
        while (i6 < zbvaVar.size()) {
            this.zba.zby(zbvaVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbb(int i5, boolean z6) {
        this.zba.zbd(i5, z6);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbc(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbss)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbd(i5, ((Boolean) list.get(i6)).booleanValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Boolean) list.get(i8)).getClass();
                i7++;
            }
            this.zba.zbw(i7);
            while (i6 < list.size()) {
                this.zba.zbb(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
                i6++;
            }
            return;
        }
        zbss zbssVar = (zbss) list;
        if (!z6) {
            while (i6 < zbssVar.size()) {
                this.zba.zbd(i5, zbssVar.zbf(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zbssVar.size(); i10++) {
            zbssVar.zbf(i10);
            i9++;
        }
        this.zba.zbw(i9);
        while (i6 < zbssVar.size()) {
            this.zba.zbb(zbssVar.zbf(i6) ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbd(int i5, zbtc zbtcVar) {
        this.zba.zbf(i5, zbtcVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbe(int i5, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.zba.zbf(i5, (zbtc) list.get(i6));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbf(int i5, double d) {
        this.zba.zbj(i5, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbg(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbtm)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbj(i5, Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Double) list.get(i8)).getClass();
                i7 += 8;
            }
            this.zba.zbw(i7);
            while (i6 < list.size()) {
                this.zba.zbk(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                i6++;
            }
            return;
        }
        zbtm zbtmVar = (zbtm) list;
        if (!z6) {
            while (i6 < zbtmVar.size()) {
                this.zba.zbj(i5, Double.doubleToRawLongBits(zbtmVar.zbe(i6)));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zbtmVar.size(); i10++) {
            zbtmVar.zbe(i10);
            i9 += 8;
        }
        this.zba.zbw(i9);
        while (i6 < zbtmVar.size()) {
            this.zba.zbk(Double.doubleToRawLongBits(zbtmVar.zbe(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    @Deprecated
    public final void zbh(int i5) {
        this.zba.zbu(i5, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbi(int i5, int i6) {
        this.zba.zbl(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbj(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbug)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbl(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int iZbE = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZbE += zbtk.zbE(((Integer) list.get(i7)).intValue());
            }
            this.zba.zbw(iZbE);
            while (i6 < list.size()) {
                this.zba.zbm(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z6) {
            while (i6 < zbugVar.size()) {
                this.zba.zbl(i5, zbugVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int iZbE2 = 0;
        for (int i8 = 0; i8 < zbugVar.size(); i8++) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i8));
        }
        this.zba.zbw(iZbE2);
        while (i6 < zbugVar.size()) {
            this.zba.zbm(zbugVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbk(int i5, int i6) {
        this.zba.zbh(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbl(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbug)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbh(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            this.zba.zbw(i7);
            while (i6 < list.size()) {
                this.zba.zbi(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z6) {
            while (i6 < zbugVar.size()) {
                this.zba.zbh(i5, zbugVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zbugVar.size(); i10++) {
            zbugVar.zbe(i10);
            i9 += 4;
        }
        this.zba.zbw(i9);
        while (i6 < zbugVar.size()) {
            this.zba.zbi(zbugVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbm(int i5, long j6) {
        this.zba.zbj(i5, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbn(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbva)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbj(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            this.zba.zbw(i7);
            while (i6 < list.size()) {
                this.zba.zbk(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z6) {
            while (i6 < zbvaVar.size()) {
                this.zba.zbj(i5, zbvaVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zbvaVar.size(); i10++) {
            zbvaVar.zbe(i10);
            i9 += 8;
        }
        this.zba.zbw(i9);
        while (i6 < zbvaVar.size()) {
            this.zba.zbk(zbvaVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbo(int i5, float f6) {
        this.zba.zbh(i5, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbp(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbtw)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbh(i5, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Float) list.get(i8)).getClass();
                i7 += 4;
            }
            this.zba.zbw(i7);
            while (i6 < list.size()) {
                this.zba.zbi(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        zbtw zbtwVar = (zbtw) list;
        if (!z6) {
            while (i6 < zbtwVar.size()) {
                this.zba.zbh(i5, Float.floatToRawIntBits(zbtwVar.zbe(i6)));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zbtwVar.size(); i10++) {
            zbtwVar.zbe(i10);
            i9 += 4;
        }
        this.zba.zbw(i9);
        while (i6 < zbtwVar.size()) {
            this.zba.zbi(Float.floatToRawIntBits(zbtwVar.zbe(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbq(int i5, Object obj, zbvx zbvxVar) {
        zbtk zbtkVar = this.zba;
        zbtkVar.zbu(i5, 3);
        zbvxVar.zbi((zbvm) obj, zbtkVar.zba);
        zbtkVar.zbu(i5, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbr(int i5, int i6) {
        this.zba.zbl(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbs(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbug)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbl(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int iZbE = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZbE += zbtk.zbE(((Integer) list.get(i7)).intValue());
            }
            this.zba.zbw(iZbE);
            while (i6 < list.size()) {
                this.zba.zbm(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z6) {
            while (i6 < zbugVar.size()) {
                this.zba.zbl(i5, zbugVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int iZbE2 = 0;
        for (int i8 = 0; i8 < zbugVar.size(); i8++) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i8));
        }
        this.zba.zbw(iZbE2);
        while (i6 < zbugVar.size()) {
            this.zba.zbm(zbugVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbt(int i5, long j6) {
        this.zba.zbx(i5, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbu(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbva)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbx(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int iZbE = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZbE += zbtk.zbE(((Long) list.get(i7)).longValue());
            }
            this.zba.zbw(iZbE);
            while (i6 < list.size()) {
                this.zba.zby(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z6) {
            while (i6 < zbvaVar.size()) {
                this.zba.zbx(i5, zbvaVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int iZbE2 = 0;
        for (int i8 = 0; i8 < zbvaVar.size(); i8++) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i8));
        }
        this.zba.zbw(iZbE2);
        while (i6 < zbvaVar.size()) {
            this.zba.zby(zbvaVar.zbe(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbv(int i5, zbve zbveVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.zba.zbu(i5, 2);
            this.zba.zbw(zbvf.zbb(zbveVar, entry.getKey(), entry.getValue()));
            zbvf.zbe(this.zba, zbveVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbw(int i5, Object obj, zbvx zbvxVar) {
        this.zba.zbo(i5, (zbvm) obj, zbvxVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbx(int i5, Object obj) {
        if (obj instanceof zbtc) {
            this.zba.zbr(i5, (zbtc) obj);
        } else {
            this.zba.zbq(i5, (zbvm) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zby(int i5, int i6) {
        this.zba.zbh(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbz(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zbug)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zba.zbh(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zba.zbu(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            this.zba.zbw(i7);
            while (i6 < list.size()) {
                this.zba.zbi(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z6) {
            while (i6 < zbugVar.size()) {
                this.zba.zbh(i5, zbugVar.zbe(i6));
                i6++;
            }
            return;
        }
        this.zba.zbu(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zbugVar.size(); i10++) {
            zbugVar.zbe(i10);
            i9 += 4;
        }
        this.zba.zbw(i9);
        while (i6 < zbugVar.size()) {
            this.zba.zbi(zbugVar.zbe(i6));
            i6++;
        }
    }
}
