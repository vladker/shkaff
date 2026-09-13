package C3;

import A3.AbstractC0139g;
import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.C;
import A3.C0;
import A3.C0133b0;
import A3.C0135c0;
import A3.C0136d;
import A3.C0153v;
import A3.C0154w;
import A3.C0155x;
import A3.C0156y;
import A3.I;
import A3.Q;
import A3.T;
import A3.j0;
import I3.c;
import O3.l;
import O3.p;
import O3.q;
import S3.f;
import com.google.common.primitives.UnsignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.E;
import kotlinx.serialization.json.internal.AbstractC1127c;
import p147z3.A;
import p147z3.C1938s;
import p147z3.D;
import p147z3.G;
import p147z3.H;
import p147z3.J;
import p147z3.K;
import p147z3.N;
import p147z3.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends a {
    /* JADX INFO: renamed from: all-JOV_ifY, reason: not valid java name */
    private static final boolean m169allJOV_ifY(byte[] all, l predicate) {
        E.f(all, "$this$all");
        E.f(predicate, "predicate");
        for (byte b : all) {
            if (!((Boolean) AbstractC0157z.d(b, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-MShoTSo, reason: not valid java name */
    private static final boolean m170allMShoTSo(long[] all, l predicate) {
        E.f(all, "$this$all");
        E.f(predicate, "predicate");
        for (long j6 : all) {
            if (!((Boolean) AbstractC0157z.g(j6, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-jgv0xPQ, reason: not valid java name */
    private static final boolean m171alljgv0xPQ(int[] all, l predicate) {
        E.f(all, "$this$all");
        E.f(predicate, "predicate");
        for (int i5 : all) {
            if (!((Boolean) AbstractC0157z.e(i5, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: all-xTcfx_M, reason: not valid java name */
    private static final boolean m172allxTcfx_M(short[] all, l predicate) {
        E.f(all, "$this$all");
        E.f(predicate, "predicate");
        for (short s6 : all) {
            if (!((Boolean) AbstractC0157z.i(s6, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: any--ajY-9A, reason: not valid java name */
    private static final boolean m173anyajY9A(int[] any) {
        E.f(any, "$this$any");
        return C.any(any);
    }

    /* JADX INFO: renamed from: any-GBYM_sE, reason: not valid java name */
    private static final boolean m174anyGBYM_sE(byte[] any) {
        E.f(any, "$this$any");
        return C.any(any);
    }

    /* JADX INFO: renamed from: any-JOV_ifY, reason: not valid java name */
    private static final boolean m175anyJOV_ifY(byte[] any, l predicate) {
        E.f(any, "$this$any");
        E.f(predicate, "predicate");
        for (byte b : any) {
            if (((Boolean) AbstractC0157z.d(b, predicate)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-MShoTSo, reason: not valid java name */
    private static final boolean m176anyMShoTSo(long[] any, l predicate) {
        E.f(any, "$this$any");
        E.f(predicate, "predicate");
        for (long j6 : any) {
            if (((Boolean) AbstractC0157z.g(j6, predicate)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-QwZRm1k, reason: not valid java name */
    private static final boolean m177anyQwZRm1k(long[] any) {
        E.f(any, "$this$any");
        return C.any(any);
    }

    /* JADX INFO: renamed from: any-jgv0xPQ, reason: not valid java name */
    private static final boolean m178anyjgv0xPQ(int[] any, l predicate) {
        E.f(any, "$this$any");
        E.f(predicate, "predicate");
        for (int i5 : any) {
            if (((Boolean) AbstractC0157z.e(i5, predicate)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: any-rL5Bavg, reason: not valid java name */
    private static final boolean m179anyrL5Bavg(short[] any) {
        E.f(any, "$this$any");
        return C.any(any);
    }

    /* JADX INFO: renamed from: any-xTcfx_M, reason: not valid java name */
    private static final boolean m180anyxTcfx_M(short[] any, l predicate) {
        E.f(any, "$this$any");
        E.f(predicate, "predicate");
        for (short s6 : any) {
            if (((Boolean) AbstractC0157z.i(s6, predicate)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: asByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m181asByteArrayGBYM_sE(byte[] asByteArray) {
        E.f(asByteArray, "$this$asByteArray");
        return asByteArray;
    }

    /* JADX INFO: renamed from: asIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m182asIntArrayajY9A(int[] asIntArray) {
        E.f(asIntArray, "$this$asIntArray");
        return asIntArray;
    }

    /* JADX INFO: renamed from: asLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m183asLongArrayQwZRm1k(long[] asLongArray) {
        E.f(asLongArray, "$this$asLongArray");
        return asLongArray;
    }

    /* JADX INFO: renamed from: asShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m184asShortArrayrL5Bavg(short[] asShortArray) {
        E.f(asShortArray, "$this$asShortArray");
        return asShortArray;
    }

    private static final byte[] asUByteArray(byte[] bArr) {
        E.f(bArr, "<this>");
        return p147z3.E.m1179constructorimpl(bArr);
    }

    private static final int[] asUIntArray(int[] iArr) {
        E.f(iArr, "<this>");
        return H.m1238constructorimpl(iArr);
    }

    private static final long[] asULongArray(long[] jArr) {
        E.f(jArr, "<this>");
        return K.m1297constructorimpl(jArr);
    }

    private static final short[] asUShortArray(short[] sArr) {
        E.f(sArr, "<this>");
        return O.m1354constructorimpl(sArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-JOV_ifY, reason: not valid java name */
    private static final <V> Map<D, V> m185associateWithJOV_ifY(byte[] associateWith, l valueSelector) {
        E.f(associateWith, "$this$associateWith");
        E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(associateWith.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (byte b : associateWith) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            linkedHashMap.put(D.a(bM1131constructorimpl), valueSelector.invoke(D.a(bM1131constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-MShoTSo, reason: not valid java name */
    private static final <V> Map<J, V> m186associateWithMShoTSo(long[] associateWith, l valueSelector) {
        E.f(associateWith, "$this$associateWith");
        E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(associateWith.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (long j6 : associateWith) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            linkedHashMap.put(J.a(jM1247constructorimpl), valueSelector.invoke(J.a(jM1247constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-jgv0xPQ, reason: not valid java name */
    private static final <V> Map<G, V> m187associateWithjgv0xPQ(int[] associateWith, l valueSelector) {
        E.f(associateWith, "$this$associateWith");
        E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(associateWith.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 : associateWith) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            linkedHashMap.put(G.a(iM1188constructorimpl), valueSelector.invoke(G.a(iM1188constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWith-xTcfx_M, reason: not valid java name */
    private static final <V> Map<N, V> m188associateWithxTcfx_M(short[] associateWith, l valueSelector) {
        E.f(associateWith, "$this$associateWith");
        E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(associateWith.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (short s6 : associateWith) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            linkedHashMap.put(N.a(sM1306constructorimpl), valueSelector.invoke(N.a(sM1306constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-4D70W2E, reason: not valid java name */
    private static final <V, M extends Map<? super G, ? super V>> M m189associateWithTo4D70W2E(int[] associateWithTo, M destination, l valueSelector) {
        E.f(associateWithTo, "$this$associateWithTo");
        E.f(destination, "destination");
        E.f(valueSelector, "valueSelector");
        for (int i5 : associateWithTo) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            destination.put(G.a(iM1188constructorimpl), valueSelector.invoke(G.a(iM1188constructorimpl)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-H21X9dk, reason: not valid java name */
    private static final <V, M extends Map<? super D, ? super V>> M m190associateWithToH21X9dk(byte[] associateWithTo, M destination, l valueSelector) {
        E.f(associateWithTo, "$this$associateWithTo");
        E.f(destination, "destination");
        E.f(valueSelector, "valueSelector");
        for (byte b : associateWithTo) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            destination.put(D.a(bM1131constructorimpl), valueSelector.invoke(D.a(bM1131constructorimpl)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-X6OPwNk, reason: not valid java name */
    private static final <V, M extends Map<? super J, ? super V>> M m191associateWithToX6OPwNk(long[] associateWithTo, M destination, l valueSelector) {
        E.f(associateWithTo, "$this$associateWithTo");
        E.f(destination, "destination");
        E.f(valueSelector, "valueSelector");
        for (long j6 : associateWithTo) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            destination.put(J.a(jM1247constructorimpl), valueSelector.invoke(J.a(jM1247constructorimpl)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: associateWithTo-ciTST-8, reason: not valid java name */
    private static final <V, M extends Map<? super N, ? super V>> M m192associateWithTociTST8(short[] associateWithTo, M destination, l valueSelector) {
        E.f(associateWithTo, "$this$associateWithTo");
        E.f(destination, "destination");
        E.f(valueSelector, "valueSelector");
        for (short s6 : associateWithTo) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            destination.put(N.a(sM1306constructorimpl), valueSelector.invoke(N.a(sM1306constructorimpl)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: component1--ajY-9A, reason: not valid java name */
    private static final int m193component1ajY9A(int[] component1) {
        E.f(component1, "$this$component1");
        return G.m1188constructorimpl(component1[0]);
    }

    /* JADX INFO: renamed from: component1-GBYM_sE, reason: not valid java name */
    private static final byte m194component1GBYM_sE(byte[] component1) {
        E.f(component1, "$this$component1");
        return D.m1131constructorimpl(component1[0]);
    }

    /* JADX INFO: renamed from: component1-QwZRm1k, reason: not valid java name */
    private static final long m195component1QwZRm1k(long[] component1) {
        E.f(component1, "$this$component1");
        return J.m1247constructorimpl(component1[0]);
    }

    /* JADX INFO: renamed from: component1-rL5Bavg, reason: not valid java name */
    private static final short m196component1rL5Bavg(short[] component1) {
        E.f(component1, "$this$component1");
        return N.m1306constructorimpl(component1[0]);
    }

    /* JADX INFO: renamed from: component2--ajY-9A, reason: not valid java name */
    private static final int m197component2ajY9A(int[] component2) {
        E.f(component2, "$this$component2");
        return G.m1188constructorimpl(component2[1]);
    }

    /* JADX INFO: renamed from: component2-GBYM_sE, reason: not valid java name */
    private static final byte m198component2GBYM_sE(byte[] component2) {
        E.f(component2, "$this$component2");
        return D.m1131constructorimpl(component2[1]);
    }

    /* JADX INFO: renamed from: component2-QwZRm1k, reason: not valid java name */
    private static final long m199component2QwZRm1k(long[] component2) {
        E.f(component2, "$this$component2");
        return J.m1247constructorimpl(component2[1]);
    }

    /* JADX INFO: renamed from: component2-rL5Bavg, reason: not valid java name */
    private static final short m200component2rL5Bavg(short[] component2) {
        E.f(component2, "$this$component2");
        return N.m1306constructorimpl(component2[1]);
    }

    /* JADX INFO: renamed from: component3--ajY-9A, reason: not valid java name */
    private static final int m201component3ajY9A(int[] component3) {
        E.f(component3, "$this$component3");
        return G.m1188constructorimpl(component3[2]);
    }

    /* JADX INFO: renamed from: component3-GBYM_sE, reason: not valid java name */
    private static final byte m202component3GBYM_sE(byte[] component3) {
        E.f(component3, "$this$component3");
        return D.m1131constructorimpl(component3[2]);
    }

    /* JADX INFO: renamed from: component3-QwZRm1k, reason: not valid java name */
    private static final long m203component3QwZRm1k(long[] component3) {
        E.f(component3, "$this$component3");
        return J.m1247constructorimpl(component3[2]);
    }

    /* JADX INFO: renamed from: component3-rL5Bavg, reason: not valid java name */
    private static final short m204component3rL5Bavg(short[] component3) {
        E.f(component3, "$this$component3");
        return N.m1306constructorimpl(component3[2]);
    }

    /* JADX INFO: renamed from: component4--ajY-9A, reason: not valid java name */
    private static final int m205component4ajY9A(int[] component4) {
        E.f(component4, "$this$component4");
        return G.m1188constructorimpl(component4[3]);
    }

    /* JADX INFO: renamed from: component4-GBYM_sE, reason: not valid java name */
    private static final byte m206component4GBYM_sE(byte[] component4) {
        E.f(component4, "$this$component4");
        return D.m1131constructorimpl(component4[3]);
    }

    /* JADX INFO: renamed from: component4-QwZRm1k, reason: not valid java name */
    private static final long m207component4QwZRm1k(long[] component4) {
        E.f(component4, "$this$component4");
        return J.m1247constructorimpl(component4[3]);
    }

    /* JADX INFO: renamed from: component4-rL5Bavg, reason: not valid java name */
    private static final short m208component4rL5Bavg(short[] component4) {
        E.f(component4, "$this$component4");
        return N.m1306constructorimpl(component4[3]);
    }

    /* JADX INFO: renamed from: component5--ajY-9A, reason: not valid java name */
    private static final int m209component5ajY9A(int[] component5) {
        E.f(component5, "$this$component5");
        return G.m1188constructorimpl(component5[4]);
    }

    /* JADX INFO: renamed from: component5-GBYM_sE, reason: not valid java name */
    private static final byte m210component5GBYM_sE(byte[] component5) {
        E.f(component5, "$this$component5");
        return D.m1131constructorimpl(component5[4]);
    }

    /* JADX INFO: renamed from: component5-QwZRm1k, reason: not valid java name */
    private static final long m211component5QwZRm1k(long[] component5) {
        E.f(component5, "$this$component5");
        return J.m1247constructorimpl(component5[4]);
    }

    /* JADX INFO: renamed from: component5-rL5Bavg, reason: not valid java name */
    private static final short m212component5rL5Bavg(short[] component5) {
        E.f(component5, "$this$component5");
        return N.m1306constructorimpl(component5[4]);
    }

    /* JADX INFO: renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m213contentEqualsFGO6Aew(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    /* JADX INFO: renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m214contentEqualsKJPZfPQ(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    /* JADX INFO: renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m215contentEqualskV0jMPg(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    /* JADX INFO: renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m216contentEqualslec5QzE(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    /* JADX INFO: renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m217contentHashCode2csIQuQ(byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m218contentHashCodeXUkPCBk(int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m219contentHashCoded6D3K8(short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    /* JADX INFO: renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m220contentHashCodeuLth9ew(long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    /* JADX INFO: renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static String m221contentToString2csIQuQ(byte[] bArr) {
        String strG;
        return (bArr == null || (strG = T.g(p147z3.E.b(bArr), ", ", "[", "]", null, 56)) == null) ? AbstractC1127c.NULL : strG;
    }

    /* JADX INFO: renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static String m222contentToStringXUkPCBk(int[] iArr) {
        String strG;
        return (iArr == null || (strG = T.g(H.b(iArr), ", ", "[", "]", null, 56)) == null) ? AbstractC1127c.NULL : strG;
    }

    /* JADX INFO: renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static String m223contentToStringd6D3K8(short[] sArr) {
        String strG;
        return (sArr == null || (strG = T.g(O.b(sArr), ", ", "[", "]", null, 56)) == null) ? AbstractC1127c.NULL : strG;
    }

    /* JADX INFO: renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static String m224contentToStringuLth9ew(long[] jArr) {
        String strG;
        return (jArr == null || (strG = T.g(K.b(jArr), ", ", "[", "]", null, 56)) == null) ? AbstractC1127c.NULL : strG;
    }

    /* JADX INFO: renamed from: copyInto--B0-L2c, reason: not valid java name */
    private static final long[] m225copyIntoB0L2c(long[] copyInto, long[] destination, int i5, int i6, int i7) {
        E.f(copyInto, "$this$copyInto");
        E.f(destination, "destination");
        AbstractC0151t.copyInto(copyInto, destination, i5, i6, i7);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-9-ak10g, reason: not valid java name */
    private static final short[] m226copyInto9ak10g(short[] copyInto, short[] destination, int i5, int i6, int i7) {
        E.f(copyInto, "$this$copyInto");
        E.f(destination, "destination");
        AbstractC0151t.copyInto(copyInto, destination, i5, i6, i7);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-FUQE5sA, reason: not valid java name */
    private static final byte[] m227copyIntoFUQE5sA(byte[] copyInto, byte[] destination, int i5, int i6, int i7) {
        E.f(copyInto, "$this$copyInto");
        E.f(destination, "destination");
        AbstractC0151t.copyInto(copyInto, destination, i5, i6, i7);
        return destination;
    }

    /* JADX INFO: renamed from: copyInto-sIZ3KeM, reason: not valid java name */
    private static final int[] m228copyIntosIZ3KeM(int[] copyInto, int[] destination, int i5, int i6, int i7) {
        E.f(copyInto, "$this$copyInto");
        E.f(destination, "destination");
        AbstractC0151t.copyInto(copyInto, destination, i5, i6, i7);
        return destination;
    }

    /* JADX INFO: renamed from: copyOf--ajY-9A, reason: not valid java name */
    private static final int[] m229copyOfajY9A(int[] copyOf) {
        E.f(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        E.e(iArrCopyOf, "copyOf(...)");
        return H.m1238constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-GBYM_sE, reason: not valid java name */
    private static final byte[] m230copyOfGBYM_sE(byte[] copyOf) {
        E.f(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        E.e(bArrCopyOf, "copyOf(...)");
        return p147z3.E.m1179constructorimpl(bArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-PpDY95g, reason: not valid java name */
    private static final byte[] m231copyOfPpDY95g(byte[] copyOf, int i5) {
        E.f(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, i5);
        E.e(bArrCopyOf, "copyOf(...)");
        return p147z3.E.m1179constructorimpl(bArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-QwZRm1k, reason: not valid java name */
    private static final long[] m232copyOfQwZRm1k(long[] copyOf) {
        E.f(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        E.e(jArrCopyOf, "copyOf(...)");
        return K.m1297constructorimpl(jArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-nggk6HY, reason: not valid java name */
    private static final short[] m233copyOfnggk6HY(short[] copyOf, int i5) {
        E.f(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, i5);
        E.e(sArrCopyOf, "copyOf(...)");
        return O.m1354constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-qFRl0hI, reason: not valid java name */
    private static final int[] m234copyOfqFRl0hI(int[] copyOf, int i5) {
        E.f(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, i5);
        E.e(iArrCopyOf, "copyOf(...)");
        return H.m1238constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-r7IrZao, reason: not valid java name */
    private static final long[] m235copyOfr7IrZao(long[] copyOf, int i5) {
        E.f(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, i5);
        E.e(jArrCopyOf, "copyOf(...)");
        return K.m1297constructorimpl(jArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOf-rL5Bavg, reason: not valid java name */
    private static final short[] m236copyOfrL5Bavg(short[] copyOf) {
        E.f(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        E.e(sArrCopyOf, "copyOf(...)");
        return O.m1354constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: copyOfRange--nroSd4, reason: not valid java name */
    private static final long[] m237copyOfRangenroSd4(long[] copyOfRange, int i5, int i6) {
        long[] jArrCopyOfRange;
        E.f(copyOfRange, "$this$copyOfRange");
        if (c.apiVersionIsAtLeast(1, 3, 0)) {
            jArrCopyOfRange = AbstractC0151t.copyOfRange(copyOfRange, i5, i6);
        } else {
            if (i6 > copyOfRange.length) {
                StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
                sbT.append(copyOfRange.length);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            jArrCopyOfRange = Arrays.copyOfRange(copyOfRange, i5, i6);
            E.c(jArrCopyOfRange);
        }
        return K.m1297constructorimpl(jArrCopyOfRange);
    }

    /* JADX INFO: renamed from: copyOfRange-4UcCI2c, reason: not valid java name */
    private static final byte[] m238copyOfRange4UcCI2c(byte[] copyOfRange, int i5, int i6) {
        byte[] bArrCopyOfRange;
        E.f(copyOfRange, "$this$copyOfRange");
        if (c.apiVersionIsAtLeast(1, 3, 0)) {
            bArrCopyOfRange = AbstractC0151t.copyOfRange(copyOfRange, i5, i6);
        } else {
            if (i6 > copyOfRange.length) {
                StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
                sbT.append(copyOfRange.length);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            bArrCopyOfRange = Arrays.copyOfRange(copyOfRange, i5, i6);
            E.c(bArrCopyOfRange);
        }
        return p147z3.E.m1179constructorimpl(bArrCopyOfRange);
    }

    /* JADX INFO: renamed from: copyOfRange-Aa5vz7o, reason: not valid java name */
    private static final short[] m239copyOfRangeAa5vz7o(short[] copyOfRange, int i5, int i6) {
        short[] sArrCopyOfRange;
        E.f(copyOfRange, "$this$copyOfRange");
        if (c.apiVersionIsAtLeast(1, 3, 0)) {
            sArrCopyOfRange = AbstractC0151t.copyOfRange(copyOfRange, i5, i6);
        } else {
            if (i6 > copyOfRange.length) {
                StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
                sbT.append(copyOfRange.length);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            sArrCopyOfRange = Arrays.copyOfRange(copyOfRange, i5, i6);
            E.c(sArrCopyOfRange);
        }
        return O.m1354constructorimpl(sArrCopyOfRange);
    }

    /* JADX INFO: renamed from: copyOfRange-oBK06Vg, reason: not valid java name */
    private static final int[] m240copyOfRangeoBK06Vg(int[] copyOfRange, int i5, int i6) {
        int[] iArrCopyOfRange;
        E.f(copyOfRange, "$this$copyOfRange");
        if (c.apiVersionIsAtLeast(1, 3, 0)) {
            iArrCopyOfRange = AbstractC0151t.copyOfRange(copyOfRange, i5, i6);
        } else {
            if (i6 > copyOfRange.length) {
                StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
                sbT.append(copyOfRange.length);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            iArrCopyOfRange = Arrays.copyOfRange(copyOfRange, i5, i6);
            E.c(iArrCopyOfRange);
        }
        return H.m1238constructorimpl(iArrCopyOfRange);
    }

    /* JADX INFO: renamed from: count-JOV_ifY, reason: not valid java name */
    private static final int m241countJOV_ifY(byte[] count, l predicate) {
        E.f(count, "$this$count");
        E.f(predicate, "predicate");
        int i5 = 0;
        for (byte b : count) {
            if (((Boolean) AbstractC0157z.d(b, predicate)).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: count-MShoTSo, reason: not valid java name */
    private static final int m242countMShoTSo(long[] count, l predicate) {
        E.f(count, "$this$count");
        E.f(predicate, "predicate");
        int i5 = 0;
        for (long j6 : count) {
            if (((Boolean) AbstractC0157z.g(j6, predicate)).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: count-jgv0xPQ, reason: not valid java name */
    private static final int m243countjgv0xPQ(int[] count, l predicate) {
        E.f(count, "$this$count");
        E.f(predicate, "predicate");
        int i5 = 0;
        for (int i6 : count) {
            if (((Boolean) AbstractC0157z.e(i6, predicate)).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: count-xTcfx_M, reason: not valid java name */
    private static final int m244countxTcfx_M(short[] count, l predicate) {
        E.f(count, "$this$count");
        E.f(predicate, "predicate");
        int i5 = 0;
        for (short s6 : count) {
            if (((Boolean) AbstractC0157z.i(s6, predicate)).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<D> m245dropPpDY95g(byte[] drop, int i5) {
        E.f(drop, "$this$drop");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = drop.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m765takeLastPpDY95g(drop, length);
    }

    /* JADX INFO: renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<N> m246dropnggk6HY(short[] drop, int i5) {
        E.f(drop, "$this$drop");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = drop.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m766takeLastnggk6HY(drop, length);
    }

    /* JADX INFO: renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<G> m247dropqFRl0hI(int[] drop, int i5) {
        E.f(drop, "$this$drop");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = drop.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m767takeLastqFRl0hI(drop, length);
    }

    /* JADX INFO: renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<J> m248dropr7IrZao(long[] drop, int i5) {
        E.f(drop, "$this$drop");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = drop.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m768takeLastr7IrZao(drop, length);
    }

    /* JADX INFO: renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<D> m249dropLastPpDY95g(byte[] dropLast, int i5) {
        E.f(dropLast, "$this$dropLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = dropLast.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m761takePpDY95g(dropLast, length);
    }

    /* JADX INFO: renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<N> m250dropLastnggk6HY(short[] dropLast, int i5) {
        E.f(dropLast, "$this$dropLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = dropLast.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m762takenggk6HY(dropLast, length);
    }

    /* JADX INFO: renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<G> m251dropLastqFRl0hI(int[] dropLast, int i5) {
        E.f(dropLast, "$this$dropLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = dropLast.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m763takeqFRl0hI(dropLast, length);
    }

    /* JADX INFO: renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<J> m252dropLastr7IrZao(long[] dropLast, int i5) {
        E.f(dropLast, "$this$dropLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = dropLast.length - i5;
        if (length < 0) {
            length = 0;
        }
        return m764taker7IrZao(dropLast, length);
    }

    /* JADX INFO: renamed from: dropLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<D> m253dropLastWhileJOV_ifY(byte[] dropLastWhile, l predicate) {
        E.f(dropLastWhile, "$this$dropLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.d(dropLastWhile[lastIndex], predicate)).booleanValue()) {
                return m761takePpDY95g(dropLastWhile, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-MShoTSo, reason: not valid java name */
    private static final List<J> m254dropLastWhileMShoTSo(long[] dropLastWhile, l predicate) {
        E.f(dropLastWhile, "$this$dropLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.g(dropLastWhile[lastIndex], predicate)).booleanValue()) {
                return m764taker7IrZao(dropLastWhile, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<G> m255dropLastWhilejgv0xPQ(int[] dropLastWhile, l predicate) {
        E.f(dropLastWhile, "$this$dropLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.e(dropLastWhile[lastIndex], predicate)).booleanValue()) {
                return m763takeqFRl0hI(dropLastWhile, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    /* JADX INFO: renamed from: dropLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<N> m256dropLastWhilexTcfx_M(short[] dropLastWhile, l predicate) {
        E.f(dropLastWhile, "$this$dropLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(dropLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.i(dropLastWhile[lastIndex], predicate)).booleanValue()) {
                return m762takenggk6HY(dropLastWhile, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    /* JADX INFO: renamed from: dropWhile-JOV_ifY, reason: not valid java name */
    private static final List<D> m257dropWhileJOV_ifY(byte[] dropWhile, l predicate) {
        E.f(dropWhile, "$this$dropWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (byte b : dropWhile) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (z6) {
                arrayList.add(D.a(bM1131constructorimpl));
            } else if (!((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                arrayList.add(D.a(bM1131constructorimpl));
                z6 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-MShoTSo, reason: not valid java name */
    private static final List<J> m258dropWhileMShoTSo(long[] dropWhile, l predicate) {
        E.f(dropWhile, "$this$dropWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (long j6 : dropWhile) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (z6) {
                arrayList.add(J.a(jM1247constructorimpl));
            } else if (!((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                arrayList.add(J.a(jM1247constructorimpl));
                z6 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-jgv0xPQ, reason: not valid java name */
    private static final List<G> m259dropWhilejgv0xPQ(int[] dropWhile, l predicate) {
        E.f(dropWhile, "$this$dropWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (int i5 : dropWhile) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (z6) {
                arrayList.add(G.a(iM1188constructorimpl));
            } else if (!((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                arrayList.add(G.a(iM1188constructorimpl));
                z6 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: dropWhile-xTcfx_M, reason: not valid java name */
    private static final List<N> m260dropWhilexTcfx_M(short[] dropWhile, l predicate) {
        E.f(dropWhile, "$this$dropWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (short s6 : dropWhile) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (z6) {
                arrayList.add(N.a(sM1306constructorimpl));
            } else if (!((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                arrayList.add(N.a(sM1306constructorimpl));
                z6 = true;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: elementAtOrElse-CVVdw08, reason: not valid java name */
    private static final short m261elementAtOrElseCVVdw08(short[] elementAtOrElse, int i5, l defaultValue) {
        E.f(elementAtOrElse, "$this$elementAtOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= elementAtOrElse.length) ? ((N) defaultValue.invoke(Integer.valueOf(i5))).f9128a : N.m1306constructorimpl(elementAtOrElse[i5]);
    }

    /* JADX INFO: renamed from: elementAtOrElse-QxvSvLU, reason: not valid java name */
    private static final int m262elementAtOrElseQxvSvLU(int[] elementAtOrElse, int i5, l defaultValue) {
        E.f(elementAtOrElse, "$this$elementAtOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= elementAtOrElse.length) ? ((G) defaultValue.invoke(Integer.valueOf(i5))).f9124a : G.m1188constructorimpl(elementAtOrElse[i5]);
    }

    /* JADX INFO: renamed from: elementAtOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m263elementAtOrElseXw8i6dc(long[] elementAtOrElse, int i5, l defaultValue) {
        E.f(elementAtOrElse, "$this$elementAtOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= elementAtOrElse.length) ? ((J) defaultValue.invoke(Integer.valueOf(i5))).f9126a : J.m1247constructorimpl(elementAtOrElse[i5]);
    }

    /* JADX INFO: renamed from: elementAtOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m264elementAtOrElsecOVybQ(byte[] elementAtOrElse, int i5, l defaultValue) {
        E.f(elementAtOrElse, "$this$elementAtOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= elementAtOrElse.length) ? ((D) defaultValue.invoke(Integer.valueOf(i5))).f9122a : D.m1131constructorimpl(elementAtOrElse[i5]);
    }

    /* JADX INFO: renamed from: elementAtOrNull-PpDY95g, reason: not valid java name */
    private static final D m265elementAtOrNullPpDY95g(byte[] elementAtOrNull, int i5) {
        E.f(elementAtOrNull, "$this$elementAtOrNull");
        return m381getOrNullPpDY95g(elementAtOrNull, i5);
    }

    /* JADX INFO: renamed from: elementAtOrNull-nggk6HY, reason: not valid java name */
    private static final N m266elementAtOrNullnggk6HY(short[] elementAtOrNull, int i5) {
        E.f(elementAtOrNull, "$this$elementAtOrNull");
        return m382getOrNullnggk6HY(elementAtOrNull, i5);
    }

    /* JADX INFO: renamed from: elementAtOrNull-qFRl0hI, reason: not valid java name */
    private static final G m267elementAtOrNullqFRl0hI(int[] elementAtOrNull, int i5) {
        E.f(elementAtOrNull, "$this$elementAtOrNull");
        return m383getOrNullqFRl0hI(elementAtOrNull, i5);
    }

    /* JADX INFO: renamed from: elementAtOrNull-r7IrZao, reason: not valid java name */
    private static final J m268elementAtOrNullr7IrZao(long[] elementAtOrNull, int i5) {
        E.f(elementAtOrNull, "$this$elementAtOrNull");
        return m384getOrNullr7IrZao(elementAtOrNull, i5);
    }

    /* JADX INFO: renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m269fill2fe2U9s(int[] fill, int i5, int i6, int i7) {
        E.f(fill, "$this$fill");
        AbstractC0151t.fill(fill, i5, i6, i7);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m270fillEtDCXyQ(short[] fill, short s6, int i5, int i6) {
        E.f(fill, "$this$fill");
        AbstractC0151t.fill(fill, s6, i5, i6);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m271fillK6DWlUc(long[] fill, long j6, int i5, int i6) {
        E.f(fill, "$this$fill");
        AbstractC0151t.fill(fill, j6, i5, i6);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m272fillWpHrYlw(byte[] fill, byte b, int i5, int i6) {
        E.f(fill, "$this$fill");
        AbstractC0151t.fill(fill, b, i5, i6);
    }

    /* JADX INFO: renamed from: filter-JOV_ifY, reason: not valid java name */
    private static final List<D> m273filterJOV_ifY(byte[] filter, l predicate) {
        E.f(filter, "$this$filter");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : filter) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                arrayList.add(D.a(bM1131constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-MShoTSo, reason: not valid java name */
    private static final List<J> m274filterMShoTSo(long[] filter, l predicate) {
        E.f(filter, "$this$filter");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : filter) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                arrayList.add(J.a(jM1247constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-jgv0xPQ, reason: not valid java name */
    private static final List<G> m275filterjgv0xPQ(int[] filter, l predicate) {
        E.f(filter, "$this$filter");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i5 : filter) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                arrayList.add(G.a(iM1188constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filter-xTcfx_M, reason: not valid java name */
    private static final List<N> m276filterxTcfx_M(short[] filter, l predicate) {
        E.f(filter, "$this$filter");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s6 : filter) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                arrayList.add(N.a(sM1306constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-ELGow60, reason: not valid java name */
    private static final List<D> m277filterIndexedELGow60(byte[] filterIndexed, p predicate) {
        E.f(filterIndexed, "$this$filterIndexed");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = filterIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte bM1131constructorimpl = D.m1131constructorimpl(filterIndexed[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), D.a(bM1131constructorimpl))).booleanValue()) {
                arrayList.add(D.a(bM1131constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-WyvcNBI, reason: not valid java name */
    private static final List<G> m278filterIndexedWyvcNBI(int[] filterIndexed, p predicate) {
        E.f(filterIndexed, "$this$filterIndexed");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = filterIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int iM1188constructorimpl = G.m1188constructorimpl(filterIndexed[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), G.a(iM1188constructorimpl))).booleanValue()) {
                arrayList.add(G.a(iM1188constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-s8dVfGU, reason: not valid java name */
    private static final List<J> m279filterIndexeds8dVfGU(long[] filterIndexed, p predicate) {
        E.f(filterIndexed, "$this$filterIndexed");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = filterIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            long jM1247constructorimpl = J.m1247constructorimpl(filterIndexed[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), J.a(jM1247constructorimpl))).booleanValue()) {
                arrayList.add(J.a(jM1247constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexed-xzaTVY8, reason: not valid java name */
    private static final List<N> m280filterIndexedxzaTVY8(short[] filterIndexed, p predicate) {
        E.f(filterIndexed, "$this$filterIndexed");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = filterIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            short sM1306constructorimpl = N.m1306constructorimpl(filterIndexed[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), N.a(sM1306constructorimpl))).booleanValue()) {
                arrayList.add(N.a(sM1306constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterIndexedTo--6EtJGI, reason: not valid java name */
    private static final <C extends Collection<? super G>> C m281filterIndexedTo6EtJGI(int[] filterIndexedTo, C destination, p predicate) {
        E.f(filterIndexedTo, "$this$filterIndexedTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        int length = filterIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int iM1188constructorimpl = G.m1188constructorimpl(filterIndexedTo[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), G.a(iM1188constructorimpl))).booleanValue()) {
                destination.add(G.a(iM1188constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <C extends Collection<? super N>> C m282filterIndexedToQqktQ3k(short[] filterIndexedTo, C destination, p predicate) {
        E.f(filterIndexedTo, "$this$filterIndexedTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        int length = filterIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            short sM1306constructorimpl = N.m1306constructorimpl(filterIndexedTo[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), N.a(sM1306constructorimpl))).booleanValue()) {
                destination.add(N.a(sM1306constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <C extends Collection<? super D>> C m283filterIndexedToeNpIKz8(byte[] filterIndexedTo, C destination, p predicate) {
        E.f(filterIndexedTo, "$this$filterIndexedTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        int length = filterIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte bM1131constructorimpl = D.m1131constructorimpl(filterIndexedTo[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), D.a(bM1131constructorimpl))).booleanValue()) {
                destination.add(D.a(bM1131constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <C extends Collection<? super J>> C m284filterIndexedTope2Q0Dw(long[] filterIndexedTo, C destination, p predicate) {
        E.f(filterIndexedTo, "$this$filterIndexedTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        int length = filterIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            long jM1247constructorimpl = J.m1247constructorimpl(filterIndexedTo[i5]);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), J.a(jM1247constructorimpl))).booleanValue()) {
                destination.add(J.a(jM1247constructorimpl));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNot-JOV_ifY, reason: not valid java name */
    private static final List<D> m285filterNotJOV_ifY(byte[] filterNot, l predicate) {
        E.f(filterNot, "$this$filterNot");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : filterNot) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (!((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                arrayList.add(D.a(bM1131constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-MShoTSo, reason: not valid java name */
    private static final List<J> m286filterNotMShoTSo(long[] filterNot, l predicate) {
        E.f(filterNot, "$this$filterNot");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : filterNot) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (!((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                arrayList.add(J.a(jM1247constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-jgv0xPQ, reason: not valid java name */
    private static final List<G> m287filterNotjgv0xPQ(int[] filterNot, l predicate) {
        E.f(filterNot, "$this$filterNot");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i5 : filterNot) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (!((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                arrayList.add(G.a(iM1188constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNot-xTcfx_M, reason: not valid java name */
    private static final List<N> m288filterNotxTcfx_M(short[] filterNot, l predicate) {
        E.f(filterNot, "$this$filterNot");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s6 : filterNot) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (!((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                arrayList.add(N.a(sM1306constructorimpl));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: filterNotTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super J>> C m289filterNotToHqK1JgA(long[] filterNotTo, C destination, l predicate) {
        E.f(filterNotTo, "$this$filterNotTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (long j6 : filterNotTo) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (!((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                destination.add(J.a(jM1247constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super N>> C m290filterNotTooEOeDjA(short[] filterNotTo, C destination, l predicate) {
        E.f(filterNotTo, "$this$filterNotTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (short s6 : filterNotTo) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (!((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                destination.add(N.a(sM1306constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super G>> C m291filterNotTowU5IKMo(int[] filterNotTo, C destination, l predicate) {
        E.f(filterNotTo, "$this$filterNotTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (int i5 : filterNotTo) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (!((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                destination.add(G.a(iM1188constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterNotTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super D>> C m292filterNotTowzUQCXU(byte[] filterNotTo, C destination, l predicate) {
        E.f(filterNotTo, "$this$filterNotTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (byte b : filterNotTo) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (!((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                destination.add(D.a(bM1131constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super J>> C m293filterToHqK1JgA(long[] filterTo, C destination, l predicate) {
        E.f(filterTo, "$this$filterTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (long j6 : filterTo) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                destination.add(J.a(jM1247constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super N>> C m294filterTooEOeDjA(short[] filterTo, C destination, l predicate) {
        E.f(filterTo, "$this$filterTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (short s6 : filterTo) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                destination.add(N.a(sM1306constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super G>> C m295filterTowU5IKMo(int[] filterTo, C destination, l predicate) {
        E.f(filterTo, "$this$filterTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (int i5 : filterTo) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                destination.add(G.a(iM1188constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: filterTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super D>> C m296filterTowzUQCXU(byte[] filterTo, C destination, l predicate) {
        E.f(filterTo, "$this$filterTo");
        E.f(destination, "destination");
        E.f(predicate, "predicate");
        for (byte b : filterTo) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                destination.add(D.a(bM1131constructorimpl));
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: find-JOV_ifY, reason: not valid java name */
    private static final D m297findJOV_ifY(byte[] find, l predicate) {
        E.f(find, "$this$find");
        E.f(predicate, "predicate");
        for (byte b : find) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                return D.a(bM1131constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-MShoTSo, reason: not valid java name */
    private static final J m298findMShoTSo(long[] find, l predicate) {
        E.f(find, "$this$find");
        E.f(predicate, "predicate");
        for (long j6 : find) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                return J.a(jM1247constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-jgv0xPQ, reason: not valid java name */
    private static final G m299findjgv0xPQ(int[] find, l predicate) {
        E.f(find, "$this$find");
        E.f(predicate, "predicate");
        for (int i5 : find) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                return G.a(iM1188constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: find-xTcfx_M, reason: not valid java name */
    private static final N m300findxTcfx_M(short[] find, l predicate) {
        E.f(find, "$this$find");
        E.f(predicate, "predicate");
        for (short s6 : find) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                return N.a(sM1306constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: findLast-JOV_ifY, reason: not valid java name */
    private static final D m301findLastJOV_ifY(byte[] findLast, l predicate) {
        E.f(findLast, "$this$findLast");
        E.f(predicate, "predicate");
        int length = findLast.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            byte bM1131constructorimpl = D.m1131constructorimpl(findLast[length]);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                return D.a(bM1131constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: findLast-MShoTSo, reason: not valid java name */
    private static final J m302findLastMShoTSo(long[] findLast, l predicate) {
        E.f(findLast, "$this$findLast");
        E.f(predicate, "predicate");
        int length = findLast.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            long jM1247constructorimpl = J.m1247constructorimpl(findLast[length]);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                return J.a(jM1247constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: findLast-jgv0xPQ, reason: not valid java name */
    private static final G m303findLastjgv0xPQ(int[] findLast, l predicate) {
        E.f(findLast, "$this$findLast");
        E.f(predicate, "predicate");
        int length = findLast.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            int iM1188constructorimpl = G.m1188constructorimpl(findLast[length]);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                return G.a(iM1188constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: findLast-xTcfx_M, reason: not valid java name */
    private static final N m304findLastxTcfx_M(short[] findLast, l predicate) {
        E.f(findLast, "$this$findLast");
        E.f(predicate, "predicate");
        int length = findLast.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            short sM1306constructorimpl = N.m1306constructorimpl(findLast[length]);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                return N.a(sM1306constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: first--ajY-9A, reason: not valid java name */
    private static final int m305firstajY9A(int[] first) {
        E.f(first, "$this$first");
        return G.m1188constructorimpl(C.first(first));
    }

    /* JADX INFO: renamed from: first-GBYM_sE, reason: not valid java name */
    private static final byte m306firstGBYM_sE(byte[] first) {
        E.f(first, "$this$first");
        return D.m1131constructorimpl(C.first(first));
    }

    /* JADX INFO: renamed from: first-JOV_ifY, reason: not valid java name */
    private static final byte m307firstJOV_ifY(byte[] first, l predicate) {
        E.f(first, "$this$first");
        E.f(predicate, "predicate");
        for (byte b : first) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                return bM1131constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-MShoTSo, reason: not valid java name */
    private static final long m308firstMShoTSo(long[] first, l predicate) {
        E.f(first, "$this$first");
        E.f(predicate, "predicate");
        for (long j6 : first) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                return jM1247constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-QwZRm1k, reason: not valid java name */
    private static final long m309firstQwZRm1k(long[] first) {
        E.f(first, "$this$first");
        return J.m1247constructorimpl(C.first(first));
    }

    /* JADX INFO: renamed from: first-jgv0xPQ, reason: not valid java name */
    private static final int m310firstjgv0xPQ(int[] first, l predicate) {
        E.f(first, "$this$first");
        E.f(predicate, "predicate");
        for (int i5 : first) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                return iM1188constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: first-rL5Bavg, reason: not valid java name */
    private static final short m311firstrL5Bavg(short[] first) {
        E.f(first, "$this$first");
        return N.m1306constructorimpl(C.first(first));
    }

    /* JADX INFO: renamed from: first-xTcfx_M, reason: not valid java name */
    private static final short m312firstxTcfx_M(short[] first, l predicate) {
        E.f(first, "$this$first");
        E.f(predicate, "predicate");
        for (short s6 : first) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                return sM1306constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final G m313firstOrNullajY9A(int[] firstOrNull) {
        E.f(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.length == 0) {
            return null;
        }
        return G.a(G.m1188constructorimpl(firstOrNull[0]));
    }

    /* JADX INFO: renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final D m314firstOrNullGBYM_sE(byte[] firstOrNull) {
        E.f(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.length == 0) {
            return null;
        }
        return D.a(D.m1131constructorimpl(firstOrNull[0]));
    }

    /* JADX INFO: renamed from: firstOrNull-JOV_ifY, reason: not valid java name */
    private static final D m315firstOrNullJOV_ifY(byte[] firstOrNull, l predicate) {
        E.f(firstOrNull, "$this$firstOrNull");
        E.f(predicate, "predicate");
        for (byte b : firstOrNull) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                return D.a(bM1131constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-MShoTSo, reason: not valid java name */
    private static final J m316firstOrNullMShoTSo(long[] firstOrNull, l predicate) {
        E.f(firstOrNull, "$this$firstOrNull");
        E.f(predicate, "predicate");
        for (long j6 : firstOrNull) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                return J.a(jM1247constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final J m317firstOrNullQwZRm1k(long[] firstOrNull) {
        E.f(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.length == 0) {
            return null;
        }
        return J.a(J.m1247constructorimpl(firstOrNull[0]));
    }

    /* JADX INFO: renamed from: firstOrNull-jgv0xPQ, reason: not valid java name */
    private static final G m318firstOrNulljgv0xPQ(int[] firstOrNull, l predicate) {
        E.f(firstOrNull, "$this$firstOrNull");
        E.f(predicate, "predicate");
        for (int i5 : firstOrNull) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                return G.a(iM1188constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final N m319firstOrNullrL5Bavg(short[] firstOrNull) {
        E.f(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.length == 0) {
            return null;
        }
        return N.a(N.m1306constructorimpl(firstOrNull[0]));
    }

    /* JADX INFO: renamed from: firstOrNull-xTcfx_M, reason: not valid java name */
    private static final N m320firstOrNullxTcfx_M(short[] firstOrNull, l predicate) {
        E.f(firstOrNull, "$this$firstOrNull");
        E.f(predicate, "predicate");
        for (short s6 : firstOrNull) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                return N.a(sM1306constructorimpl);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: flatMap-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m321flatMapJOV_ifY(byte[] flatMap, l transform) {
        E.f(flatMap, "$this$flatMap");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b : flatMap) {
            A3.O.addAll(arrayList, (Iterable) AbstractC0157z.d(b, transform));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m322flatMapMShoTSo(long[] flatMap, l transform) {
        E.f(flatMap, "$this$flatMap");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j6 : flatMap) {
            A3.O.addAll(arrayList, (Iterable) AbstractC0157z.g(j6, transform));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m323flatMapjgv0xPQ(int[] flatMap, l transform) {
        E.f(flatMap, "$this$flatMap");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i5 : flatMap) {
            A3.O.addAll(arrayList, (Iterable) AbstractC0157z.e(i5, transform));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMap-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m324flatMapxTcfx_M(short[] flatMap, l transform) {
        E.f(flatMap, "$this$flatMap");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s6 : flatMap) {
            A3.O.addAll(arrayList, (Iterable) AbstractC0157z.i(s6, transform));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m325flatMapIndexedELGow60(byte[] flatMapIndexed, p transform) {
        E.f(flatMapIndexed, "$this$flatMapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = flatMapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), D.a(D.m1131constructorimpl(flatMapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m326flatMapIndexedWyvcNBI(int[] flatMapIndexed, p transform) {
        E.f(flatMapIndexed, "$this$flatMapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = flatMapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), G.a(G.m1188constructorimpl(flatMapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m327flatMapIndexeds8dVfGU(long[] flatMapIndexed, p transform) {
        E.f(flatMapIndexed, "$this$flatMapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = flatMapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), J.a(J.m1247constructorimpl(flatMapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m328flatMapIndexedxzaTVY8(short[] flatMapIndexed, p transform) {
        E.f(flatMapIndexed, "$this$flatMapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = flatMapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), N.a(N.m1306constructorimpl(flatMapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m329flatMapIndexedTo6EtJGI(int[] flatMapIndexedTo, C destination, p transform) {
        E.f(flatMapIndexedTo, "$this$flatMapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = flatMapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), G.a(G.m1188constructorimpl(flatMapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m330flatMapIndexedToQqktQ3k(short[] flatMapIndexedTo, C destination, p transform) {
        E.f(flatMapIndexedTo, "$this$flatMapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = flatMapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), N.a(N.m1306constructorimpl(flatMapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m331flatMapIndexedToeNpIKz8(byte[] flatMapIndexedTo, C destination, p transform) {
        E.f(flatMapIndexedTo, "$this$flatMapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = flatMapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), D.a(D.m1131constructorimpl(flatMapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m332flatMapIndexedTope2Q0Dw(long[] flatMapIndexedTo, C destination, p transform) {
        E.f(flatMapIndexedTo, "$this$flatMapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = flatMapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            A3.O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), J.a(J.m1247constructorimpl(flatMapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m333flatMapToHqK1JgA(long[] flatMapTo, C destination, l transform) {
        E.f(flatMapTo, "$this$flatMapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (long j6 : flatMapTo) {
            A3.O.addAll(destination, (Iterable) AbstractC0157z.g(j6, transform));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m334flatMapTooEOeDjA(short[] flatMapTo, C destination, l transform) {
        E.f(flatMapTo, "$this$flatMapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (short s6 : flatMapTo) {
            A3.O.addAll(destination, (Iterable) AbstractC0157z.i(s6, transform));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m335flatMapTowU5IKMo(int[] flatMapTo, C destination, l transform) {
        E.f(flatMapTo, "$this$flatMapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (int i5 : flatMapTo) {
            A3.O.addAll(destination, (Iterable) AbstractC0157z.e(i5, transform));
        }
        return destination;
    }

    /* JADX INFO: renamed from: flatMapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m336flatMapTowzUQCXU(byte[] flatMapTo, C destination, l transform) {
        E.f(flatMapTo, "$this$flatMapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (byte b : flatMapTo) {
            A3.O.addAll(destination, (Iterable) AbstractC0157z.d(b, transform));
        }
        return destination;
    }

    /* JADX INFO: renamed from: fold-A8wKCXQ, reason: not valid java name */
    private static final <R> R m337foldA8wKCXQ(long[] fold, R r6, p operation) {
        E.f(fold, "$this$fold");
        E.f(operation, "operation");
        for (long j6 : fold) {
            r6 = (R) operation.invoke(r6, J.a(J.m1247constructorimpl(j6)));
        }
        return r6;
    }

    /* JADX INFO: renamed from: fold-yXmHNn8, reason: not valid java name */
    private static final <R> R m338foldyXmHNn8(byte[] fold, R r6, p operation) {
        E.f(fold, "$this$fold");
        E.f(operation, "operation");
        for (byte b : fold) {
            r6 = (R) operation.invoke(r6, D.a(D.m1131constructorimpl(b)));
        }
        return r6;
    }

    /* JADX INFO: renamed from: fold-zi1B2BA, reason: not valid java name */
    private static final <R> R m339foldzi1B2BA(int[] fold, R r6, p operation) {
        E.f(fold, "$this$fold");
        E.f(operation, "operation");
        for (int i5 : fold) {
            r6 = (R) operation.invoke(r6, G.a(G.m1188constructorimpl(i5)));
        }
        return r6;
    }

    /* JADX INFO: renamed from: fold-zww5nb8, reason: not valid java name */
    private static final <R> R m340foldzww5nb8(short[] fold, R r6, p operation) {
        E.f(fold, "$this$fold");
        E.f(operation, "operation");
        for (short s6 : fold) {
            r6 = (R) operation.invoke(r6, N.a(N.m1306constructorimpl(s6)));
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m341foldIndexed3iWJZGE(byte[] foldIndexed, R r6, q operation) {
        E.f(foldIndexed, "$this$foldIndexed");
        E.f(operation, "operation");
        int length = foldIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, D.a(D.m1131constructorimpl(foldIndexed[i5])));
            i5++;
            i6++;
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m342foldIndexedbzxtMww(short[] foldIndexed, R r6, q operation) {
        E.f(foldIndexed, "$this$foldIndexed");
        E.f(operation, "operation");
        int length = foldIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, N.a(N.m1306constructorimpl(foldIndexed[i5])));
            i5++;
            i6++;
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m343foldIndexedmwnnOCs(long[] foldIndexed, R r6, q operation) {
        E.f(foldIndexed, "$this$foldIndexed");
        E.f(operation, "operation");
        int length = foldIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, J.a(J.m1247constructorimpl(foldIndexed[i5])));
            i5++;
            i6++;
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m344foldIndexedyVwIW0Q(int[] foldIndexed, R r6, q operation) {
        E.f(foldIndexed, "$this$foldIndexed");
        E.f(operation, "operation");
        int length = foldIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, G.a(G.m1188constructorimpl(foldIndexed[i5])));
            i5++;
            i6++;
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRight-A8wKCXQ, reason: not valid java name */
    private static final <R> R m345foldRightA8wKCXQ(long[] foldRight, R r6, p operation) {
        E.f(foldRight, "$this$foldRight");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(J.a(J.m1247constructorimpl(foldRight[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRight-yXmHNn8, reason: not valid java name */
    private static final <R> R m346foldRightyXmHNn8(byte[] foldRight, R r6, p operation) {
        E.f(foldRight, "$this$foldRight");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(D.a(D.m1131constructorimpl(foldRight[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRight-zi1B2BA, reason: not valid java name */
    private static final <R> R m347foldRightzi1B2BA(int[] foldRight, R r6, p operation) {
        E.f(foldRight, "$this$foldRight");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(G.a(G.m1188constructorimpl(foldRight[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRight-zww5nb8, reason: not valid java name */
    private static final <R> R m348foldRightzww5nb8(short[] foldRight, R r6, p operation) {
        E.f(foldRight, "$this$foldRight");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRight); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(N.a(N.m1306constructorimpl(foldRight[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRightIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m349foldRightIndexed3iWJZGE(byte[] foldRightIndexed, R r6, q operation) {
        E.f(foldRightIndexed, "$this$foldRightIndexed");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), D.a(D.m1131constructorimpl(foldRightIndexed[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRightIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m350foldRightIndexedbzxtMww(short[] foldRightIndexed, R r6, q operation) {
        E.f(foldRightIndexed, "$this$foldRightIndexed");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), N.a(N.m1306constructorimpl(foldRightIndexed[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRightIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m351foldRightIndexedmwnnOCs(long[] foldRightIndexed, R r6, q operation) {
        E.f(foldRightIndexed, "$this$foldRightIndexed");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), J.a(J.m1247constructorimpl(foldRightIndexed[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: foldRightIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m352foldRightIndexedyVwIW0Q(int[] foldRightIndexed, R r6, q operation) {
        E.f(foldRightIndexed, "$this$foldRightIndexed");
        E.f(operation, "operation");
        for (int lastIndex = C.getLastIndex(foldRightIndexed); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), G.a(G.m1188constructorimpl(foldRightIndexed[lastIndex])), r6);
        }
        return r6;
    }

    /* JADX INFO: renamed from: forEach-JOV_ifY, reason: not valid java name */
    private static final void m353forEachJOV_ifY(byte[] forEach, l action) {
        E.f(forEach, "$this$forEach");
        E.f(action, "action");
        for (byte b : forEach) {
            action.invoke(D.a(D.m1131constructorimpl(b)));
        }
    }

    /* JADX INFO: renamed from: forEach-MShoTSo, reason: not valid java name */
    private static final void m354forEachMShoTSo(long[] forEach, l action) {
        E.f(forEach, "$this$forEach");
        E.f(action, "action");
        for (long j6 : forEach) {
            action.invoke(J.a(J.m1247constructorimpl(j6)));
        }
    }

    /* JADX INFO: renamed from: forEach-jgv0xPQ, reason: not valid java name */
    private static final void m355forEachjgv0xPQ(int[] forEach, l action) {
        E.f(forEach, "$this$forEach");
        E.f(action, "action");
        for (int i5 : forEach) {
            action.invoke(G.a(G.m1188constructorimpl(i5)));
        }
    }

    /* JADX INFO: renamed from: forEach-xTcfx_M, reason: not valid java name */
    private static final void m356forEachxTcfx_M(short[] forEach, l action) {
        E.f(forEach, "$this$forEach");
        E.f(action, "action");
        for (short s6 : forEach) {
            action.invoke(N.a(N.m1306constructorimpl(s6)));
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-ELGow60, reason: not valid java name */
    private static final void m357forEachIndexedELGow60(byte[] forEachIndexed, p action) {
        E.f(forEachIndexed, "$this$forEachIndexed");
        E.f(action, "action");
        int length = forEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), D.a(D.m1131constructorimpl(forEachIndexed[i5])));
            i5++;
            i6++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-WyvcNBI, reason: not valid java name */
    private static final void m358forEachIndexedWyvcNBI(int[] forEachIndexed, p action) {
        E.f(forEachIndexed, "$this$forEachIndexed");
        E.f(action, "action");
        int length = forEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), G.a(G.m1188constructorimpl(forEachIndexed[i5])));
            i5++;
            i6++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-s8dVfGU, reason: not valid java name */
    private static final void m359forEachIndexeds8dVfGU(long[] forEachIndexed, p action) {
        E.f(forEachIndexed, "$this$forEachIndexed");
        E.f(action, "action");
        int length = forEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), J.a(J.m1247constructorimpl(forEachIndexed[i5])));
            i5++;
            i6++;
        }
    }

    /* JADX INFO: renamed from: forEachIndexed-xzaTVY8, reason: not valid java name */
    private static final void m360forEachIndexedxzaTVY8(short[] forEachIndexed, p action) {
        E.f(forEachIndexed, "$this$forEachIndexed");
        E.f(action, "action");
        int length = forEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), N.a(N.m1306constructorimpl(forEachIndexed[i5])));
            i5++;
            i6++;
        }
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final U3.q m361getIndicesajY9A(int[] indices) {
        E.f(indices, "$this$indices");
        return C.getIndices(indices);
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final U3.q m363getIndicesGBYM_sE(byte[] indices) {
        E.f(indices, "$this$indices");
        return C.getIndices(indices);
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final U3.q m365getIndicesQwZRm1k(long[] indices) {
        E.f(indices, "$this$indices");
        return C.getIndices(indices);
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final U3.q m367getIndicesrL5Bavg(short[] indices) {
        E.f(indices, "$this$indices");
        return C.getIndices(indices);
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m369getLastIndexajY9A(int[] lastIndex) {
        E.f(lastIndex, "$this$lastIndex");
        return C.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m371getLastIndexGBYM_sE(byte[] lastIndex) {
        E.f(lastIndex, "$this$lastIndex");
        return C.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m373getLastIndexQwZRm1k(long[] lastIndex) {
        E.f(lastIndex, "$this$lastIndex");
        return C.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m375getLastIndexrL5Bavg(short[] lastIndex) {
        E.f(lastIndex, "$this$lastIndex");
        return C.getLastIndex(lastIndex);
    }

    /* JADX INFO: renamed from: getOrElse-CVVdw08, reason: not valid java name */
    private static final short m377getOrElseCVVdw08(short[] getOrElse, int i5, l defaultValue) {
        E.f(getOrElse, "$this$getOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= getOrElse.length) ? ((N) defaultValue.invoke(Integer.valueOf(i5))).f9128a : N.m1306constructorimpl(getOrElse[i5]);
    }

    /* JADX INFO: renamed from: getOrElse-QxvSvLU, reason: not valid java name */
    private static final int m378getOrElseQxvSvLU(int[] getOrElse, int i5, l defaultValue) {
        E.f(getOrElse, "$this$getOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= getOrElse.length) ? ((G) defaultValue.invoke(Integer.valueOf(i5))).f9124a : G.m1188constructorimpl(getOrElse[i5]);
    }

    /* JADX INFO: renamed from: getOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m379getOrElseXw8i6dc(long[] getOrElse, int i5, l defaultValue) {
        E.f(getOrElse, "$this$getOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= getOrElse.length) ? ((J) defaultValue.invoke(Integer.valueOf(i5))).f9126a : J.m1247constructorimpl(getOrElse[i5]);
    }

    /* JADX INFO: renamed from: getOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m380getOrElsecOVybQ(byte[] getOrElse, int i5, l defaultValue) {
        E.f(getOrElse, "$this$getOrElse");
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= getOrElse.length) ? ((D) defaultValue.invoke(Integer.valueOf(i5))).f9122a : D.m1131constructorimpl(getOrElse[i5]);
    }

    /* JADX INFO: renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final D m381getOrNullPpDY95g(byte[] getOrNull, int i5) {
        E.f(getOrNull, "$this$getOrNull");
        if (i5 < 0 || i5 >= getOrNull.length) {
            return null;
        }
        return D.a(D.m1131constructorimpl(getOrNull[i5]));
    }

    /* JADX INFO: renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final N m382getOrNullnggk6HY(short[] getOrNull, int i5) {
        E.f(getOrNull, "$this$getOrNull");
        if (i5 < 0 || i5 >= getOrNull.length) {
            return null;
        }
        return N.a(N.m1306constructorimpl(getOrNull[i5]));
    }

    /* JADX INFO: renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final G m383getOrNullqFRl0hI(int[] getOrNull, int i5) {
        E.f(getOrNull, "$this$getOrNull");
        if (i5 < 0 || i5 >= getOrNull.length) {
            return null;
        }
        return G.a(G.m1188constructorimpl(getOrNull[i5]));
    }

    /* JADX INFO: renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final J m384getOrNullr7IrZao(long[] getOrNull, int i5) {
        E.f(getOrNull, "$this$getOrNull");
        if (i5 < 0 || i5 >= getOrNull.length) {
            return null;
        }
        return J.a(J.m1247constructorimpl(getOrNull[i5]));
    }

    /* JADX INFO: renamed from: groupBy--_j2Y-Q, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m385groupBy_j2YQ(long[] groupBy, l keySelector, l valueTransform) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j6 : groupBy) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            Object objInvoke = keySelector.invoke(J.a(jM1247constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(J.a(jM1247constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-3bBvP4M, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m386groupBy3bBvP4M(short[] groupBy, l keySelector, l valueTransform) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s6 : groupBy) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            Object objInvoke = keySelector.invoke(N.a(sM1306constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(N.a(sM1306constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-JOV_ifY, reason: not valid java name */
    private static final <K> Map<K, List<D>> m387groupByJOV_ifY(byte[] groupBy, l keySelector) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : groupBy) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            Object objInvoke = keySelector.invoke(D.a(bM1131constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(D.a(bM1131constructorimpl));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-L4rlFek, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m388groupByL4rlFek(int[] groupBy, l keySelector, l valueTransform) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i5 : groupBy) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            Object objInvoke = keySelector.invoke(G.a(iM1188constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(G.a(iM1188constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-MShoTSo, reason: not valid java name */
    private static final <K> Map<K, List<J>> m389groupByMShoTSo(long[] groupBy, l keySelector) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j6 : groupBy) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            Object objInvoke = keySelector.invoke(J.a(jM1247constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(J.a(jM1247constructorimpl));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-bBsjw1Y, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m390groupBybBsjw1Y(byte[] groupBy, l keySelector, l valueTransform) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : groupBy) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            Object objInvoke = keySelector.invoke(D.a(bM1131constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(D.a(bM1131constructorimpl)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-jgv0xPQ, reason: not valid java name */
    private static final <K> Map<K, List<G>> m391groupByjgv0xPQ(int[] groupBy, l keySelector) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i5 : groupBy) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            Object objInvoke = keySelector.invoke(G.a(iM1188constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(G.a(iM1188constructorimpl));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupBy-xTcfx_M, reason: not valid java name */
    private static final <K> Map<K, List<N>> m392groupByxTcfx_M(short[] groupBy, l keySelector) {
        E.f(groupBy, "$this$groupBy");
        E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s6 : groupBy) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            Object objInvoke = keySelector.invoke(N.a(sM1306constructorimpl));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(N.a(sM1306constructorimpl));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: groupByTo-4D70W2E, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<G>>> M m393groupByTo4D70W2E(int[] groupByTo, M destination, l keySelector) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        for (int i5 : groupByTo) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            Object objInvoke = keySelector.invoke(G.a(iM1188constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(G.a(iM1188constructorimpl));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-H21X9dk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<D>>> M m394groupByToH21X9dk(byte[] groupByTo, M destination, l keySelector) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        for (byte b : groupByTo) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            Object objInvoke = keySelector.invoke(D.a(bM1131constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(D.a(bM1131constructorimpl));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-JM6gNCM, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m395groupByToJM6gNCM(int[] groupByTo, M destination, l keySelector, l valueTransform) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        for (int i5 : groupByTo) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            Object objInvoke = keySelector.invoke(G.a(iM1188constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(G.a(iM1188constructorimpl)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-QxgOkWg, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m396groupByToQxgOkWg(long[] groupByTo, M destination, l keySelector, l valueTransform) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        for (long j6 : groupByTo) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            Object objInvoke = keySelector.invoke(J.a(jM1247constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(J.a(jM1247constructorimpl)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-X6OPwNk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<J>>> M m397groupByToX6OPwNk(long[] groupByTo, M destination, l keySelector) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        for (long j6 : groupByTo) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            Object objInvoke = keySelector.invoke(J.a(jM1247constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(J.a(jM1247constructorimpl));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-ciTST-8, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<N>>> M m398groupByTociTST8(short[] groupByTo, M destination, l keySelector) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        for (short s6 : groupByTo) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            Object objInvoke = keySelector.invoke(N.a(sM1306constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(N.a(sM1306constructorimpl));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-q8RuPII, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m399groupByToq8RuPII(short[] groupByTo, M destination, l keySelector, l valueTransform) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        for (short s6 : groupByTo) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            Object objInvoke = keySelector.invoke(N.a(sM1306constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(N.a(sM1306constructorimpl)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: groupByTo-qOZmbk8, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m400groupByToqOZmbk8(byte[] groupByTo, M destination, l keySelector, l valueTransform) {
        E.f(groupByTo, "$this$groupByTo");
        E.f(destination, "destination");
        E.f(keySelector, "keySelector");
        E.f(valueTransform, "valueTransform");
        for (byte b : groupByTo) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            Object objInvoke = keySelector.invoke(D.a(bM1131constructorimpl));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(D.a(bM1131constructorimpl)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: indexOf-3uqUaXg, reason: not valid java name */
    private static final int m401indexOf3uqUaXg(long[] indexOf, long j6) {
        E.f(indexOf, "$this$indexOf");
        return C.indexOf(indexOf, j6);
    }

    /* JADX INFO: renamed from: indexOf-XzdR7RA, reason: not valid java name */
    private static final int m402indexOfXzdR7RA(short[] indexOf, short s6) {
        E.f(indexOf, "$this$indexOf");
        return C.indexOf(indexOf, s6);
    }

    /* JADX INFO: renamed from: indexOf-gMuBH34, reason: not valid java name */
    private static final int m403indexOfgMuBH34(byte[] indexOf, byte b) {
        E.f(indexOf, "$this$indexOf");
        return C.indexOf(indexOf, b);
    }

    /* JADX INFO: renamed from: indexOf-uWY9BYg, reason: not valid java name */
    private static final int m404indexOfuWY9BYg(int[] indexOf, int i5) {
        E.f(indexOf, "$this$indexOf");
        return C.indexOf(indexOf, i5);
    }

    /* JADX INFO: renamed from: indexOfFirst-JOV_ifY, reason: not valid java name */
    private static final int m405indexOfFirstJOV_ifY(byte[] indexOfFirst, l predicate) {
        E.f(indexOfFirst, "$this$indexOfFirst");
        E.f(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) AbstractC0157z.d(indexOfFirst[i5], predicate)).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-MShoTSo, reason: not valid java name */
    private static final int m406indexOfFirstMShoTSo(long[] indexOfFirst, l predicate) {
        E.f(indexOfFirst, "$this$indexOfFirst");
        E.f(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) AbstractC0157z.g(indexOfFirst[i5], predicate)).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-jgv0xPQ, reason: not valid java name */
    private static final int m407indexOfFirstjgv0xPQ(int[] indexOfFirst, l predicate) {
        E.f(indexOfFirst, "$this$indexOfFirst");
        E.f(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) AbstractC0157z.e(indexOfFirst[i5], predicate)).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfFirst-xTcfx_M, reason: not valid java name */
    private static final int m408indexOfFirstxTcfx_M(short[] indexOfFirst, l predicate) {
        E.f(indexOfFirst, "$this$indexOfFirst");
        E.f(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) AbstractC0157z.i(indexOfFirst[i5], predicate)).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-JOV_ifY, reason: not valid java name */
    private static final int m409indexOfLastJOV_ifY(byte[] indexOfLast, l predicate) {
        E.f(indexOfLast, "$this$indexOfLast");
        E.f(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) AbstractC0157z.d(indexOfLast[length], predicate)).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-MShoTSo, reason: not valid java name */
    private static final int m410indexOfLastMShoTSo(long[] indexOfLast, l predicate) {
        E.f(indexOfLast, "$this$indexOfLast");
        E.f(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) AbstractC0157z.g(indexOfLast[length], predicate)).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-jgv0xPQ, reason: not valid java name */
    private static final int m411indexOfLastjgv0xPQ(int[] indexOfLast, l predicate) {
        E.f(indexOfLast, "$this$indexOfLast");
        E.f(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) AbstractC0157z.e(indexOfLast[length], predicate)).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOfLast-xTcfx_M, reason: not valid java name */
    private static final int m412indexOfLastxTcfx_M(short[] indexOfLast, l predicate) {
        E.f(indexOfLast, "$this$indexOfLast");
        E.f(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) AbstractC0157z.i(indexOfLast[length], predicate)).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: last--ajY-9A, reason: not valid java name */
    private static final int m413lastajY9A(int[] last) {
        E.f(last, "$this$last");
        return G.m1188constructorimpl(C.last(last));
    }

    /* JADX INFO: renamed from: last-GBYM_sE, reason: not valid java name */
    private static final byte m414lastGBYM_sE(byte[] last) {
        E.f(last, "$this$last");
        return D.m1131constructorimpl(C.last(last));
    }

    /* JADX INFO: renamed from: last-JOV_ifY, reason: not valid java name */
    private static final byte m415lastJOV_ifY(byte[] last, l predicate) {
        E.f(last, "$this$last");
        E.f(predicate, "predicate");
        int length = last.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                byte bM1131constructorimpl = D.m1131constructorimpl(last[length]);
                if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                    return bM1131constructorimpl;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-MShoTSo, reason: not valid java name */
    private static final long m416lastMShoTSo(long[] last, l predicate) {
        E.f(last, "$this$last");
        E.f(predicate, "predicate");
        int length = last.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                long jM1247constructorimpl = J.m1247constructorimpl(last[length]);
                if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                    return jM1247constructorimpl;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-QwZRm1k, reason: not valid java name */
    private static final long m417lastQwZRm1k(long[] last) {
        E.f(last, "$this$last");
        return J.m1247constructorimpl(C.last(last));
    }

    /* JADX INFO: renamed from: last-jgv0xPQ, reason: not valid java name */
    private static final int m418lastjgv0xPQ(int[] last, l predicate) {
        E.f(last, "$this$last");
        E.f(predicate, "predicate");
        int length = last.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                int iM1188constructorimpl = G.m1188constructorimpl(last[length]);
                if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                    return iM1188constructorimpl;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: last-rL5Bavg, reason: not valid java name */
    private static final short m419lastrL5Bavg(short[] last) {
        E.f(last, "$this$last");
        return N.m1306constructorimpl(C.last(last));
    }

    /* JADX INFO: renamed from: last-xTcfx_M, reason: not valid java name */
    private static final short m420lastxTcfx_M(short[] last, l predicate) {
        E.f(last, "$this$last");
        E.f(predicate, "predicate");
        int length = last.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                short sM1306constructorimpl = N.m1306constructorimpl(last[length]);
                if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                    return sM1306constructorimpl;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: lastIndexOf-3uqUaXg, reason: not valid java name */
    private static final int m421lastIndexOf3uqUaXg(long[] lastIndexOf, long j6) {
        E.f(lastIndexOf, "$this$lastIndexOf");
        return C.lastIndexOf(lastIndexOf, j6);
    }

    /* JADX INFO: renamed from: lastIndexOf-XzdR7RA, reason: not valid java name */
    private static final int m422lastIndexOfXzdR7RA(short[] lastIndexOf, short s6) {
        E.f(lastIndexOf, "$this$lastIndexOf");
        return C.lastIndexOf(lastIndexOf, s6);
    }

    /* JADX INFO: renamed from: lastIndexOf-gMuBH34, reason: not valid java name */
    private static final int m423lastIndexOfgMuBH34(byte[] lastIndexOf, byte b) {
        E.f(lastIndexOf, "$this$lastIndexOf");
        return C.lastIndexOf(lastIndexOf, b);
    }

    /* JADX INFO: renamed from: lastIndexOf-uWY9BYg, reason: not valid java name */
    private static final int m424lastIndexOfuWY9BYg(int[] lastIndexOf, int i5) {
        E.f(lastIndexOf, "$this$lastIndexOf");
        return C.lastIndexOf(lastIndexOf, i5);
    }

    /* JADX INFO: renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final G m425lastOrNullajY9A(int[] lastOrNull) {
        E.f(lastOrNull, "$this$lastOrNull");
        if (lastOrNull.length == 0) {
            return null;
        }
        return G.a(G.m1188constructorimpl(lastOrNull[lastOrNull.length - 1]));
    }

    /* JADX INFO: renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final D m426lastOrNullGBYM_sE(byte[] lastOrNull) {
        E.f(lastOrNull, "$this$lastOrNull");
        if (lastOrNull.length == 0) {
            return null;
        }
        return D.a(D.m1131constructorimpl(lastOrNull[lastOrNull.length - 1]));
    }

    /* JADX INFO: renamed from: lastOrNull-JOV_ifY, reason: not valid java name */
    private static final D m427lastOrNullJOV_ifY(byte[] lastOrNull, l predicate) {
        E.f(lastOrNull, "$this$lastOrNull");
        E.f(predicate, "predicate");
        int length = lastOrNull.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            byte bM1131constructorimpl = D.m1131constructorimpl(lastOrNull[length]);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                return D.a(bM1131constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-MShoTSo, reason: not valid java name */
    private static final J m428lastOrNullMShoTSo(long[] lastOrNull, l predicate) {
        E.f(lastOrNull, "$this$lastOrNull");
        E.f(predicate, "predicate");
        int length = lastOrNull.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            long jM1247constructorimpl = J.m1247constructorimpl(lastOrNull[length]);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                return J.a(jM1247constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final J m429lastOrNullQwZRm1k(long[] lastOrNull) {
        E.f(lastOrNull, "$this$lastOrNull");
        if (lastOrNull.length == 0) {
            return null;
        }
        return J.a(J.m1247constructorimpl(lastOrNull[lastOrNull.length - 1]));
    }

    /* JADX INFO: renamed from: lastOrNull-jgv0xPQ, reason: not valid java name */
    private static final G m430lastOrNulljgv0xPQ(int[] lastOrNull, l predicate) {
        E.f(lastOrNull, "$this$lastOrNull");
        E.f(predicate, "predicate");
        int length = lastOrNull.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            int iM1188constructorimpl = G.m1188constructorimpl(lastOrNull[length]);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                return G.a(iM1188constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final N m431lastOrNullrL5Bavg(short[] lastOrNull) {
        E.f(lastOrNull, "$this$lastOrNull");
        if (lastOrNull.length == 0) {
            return null;
        }
        return N.a(N.m1306constructorimpl(lastOrNull[lastOrNull.length - 1]));
    }

    /* JADX INFO: renamed from: lastOrNull-xTcfx_M, reason: not valid java name */
    private static final N m432lastOrNullxTcfx_M(short[] lastOrNull, l predicate) {
        E.f(lastOrNull, "$this$lastOrNull");
        E.f(predicate, "predicate");
        int length = lastOrNull.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            short sM1306constructorimpl = N.m1306constructorimpl(lastOrNull[length]);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                return N.a(sM1306constructorimpl);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    /* JADX INFO: renamed from: map-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m433mapJOV_ifY(byte[] map, l transform) {
        E.f(map, "$this$map");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(map.length);
        for (byte b : map) {
            arrayList.add(transform.invoke(D.a(D.m1131constructorimpl(b))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m434mapMShoTSo(long[] map, l transform) {
        E.f(map, "$this$map");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(map.length);
        for (long j6 : map) {
            arrayList.add(transform.invoke(J.a(J.m1247constructorimpl(j6))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m435mapjgv0xPQ(int[] map, l transform) {
        E.f(map, "$this$map");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(map.length);
        for (int i5 : map) {
            arrayList.add(transform.invoke(G.a(G.m1188constructorimpl(i5))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: map-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m436mapxTcfx_M(short[] map, l transform) {
        E.f(map, "$this$map");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(map.length);
        for (short s6 : map) {
            arrayList.add(transform.invoke(N.a(N.m1306constructorimpl(s6))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m437mapIndexedELGow60(byte[] mapIndexed, p transform) {
        E.f(mapIndexed, "$this$mapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(mapIndexed.length);
        int length = mapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), D.a(D.m1131constructorimpl(mapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m438mapIndexedWyvcNBI(int[] mapIndexed, p transform) {
        E.f(mapIndexed, "$this$mapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(mapIndexed.length);
        int length = mapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), G.a(G.m1188constructorimpl(mapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m439mapIndexeds8dVfGU(long[] mapIndexed, p transform) {
        E.f(mapIndexed, "$this$mapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(mapIndexed.length);
        int length = mapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), J.a(J.m1247constructorimpl(mapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m440mapIndexedxzaTVY8(short[] mapIndexed, p transform) {
        E.f(mapIndexed, "$this$mapIndexed");
        E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(mapIndexed.length);
        int length = mapIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), N.a(N.m1306constructorimpl(mapIndexed[i5]))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: mapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m441mapIndexedTo6EtJGI(int[] mapIndexedTo, C destination, p transform) {
        E.f(mapIndexedTo, "$this$mapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = mapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), G.a(G.m1188constructorimpl(mapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m442mapIndexedToQqktQ3k(short[] mapIndexedTo, C destination, p transform) {
        E.f(mapIndexedTo, "$this$mapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = mapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), N.a(N.m1306constructorimpl(mapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m443mapIndexedToeNpIKz8(byte[] mapIndexedTo, C destination, p transform) {
        E.f(mapIndexedTo, "$this$mapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = mapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), D.a(D.m1131constructorimpl(mapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m444mapIndexedTope2Q0Dw(long[] mapIndexedTo, C destination, p transform) {
        E.f(mapIndexedTo, "$this$mapIndexedTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        int length = mapIndexedTo.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), J.a(J.m1247constructorimpl(mapIndexedTo[i5]))));
            i5++;
            i6++;
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m445mapToHqK1JgA(long[] mapTo, C destination, l transform) {
        E.f(mapTo, "$this$mapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (long j6 : mapTo) {
            destination.add(transform.invoke(J.a(J.m1247constructorimpl(j6))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m446mapTooEOeDjA(short[] mapTo, C destination, l transform) {
        E.f(mapTo, "$this$mapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (short s6 : mapTo) {
            destination.add(transform.invoke(N.a(N.m1306constructorimpl(s6))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m447mapTowU5IKMo(int[] mapTo, C destination, l transform) {
        E.f(mapTo, "$this$mapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (int i5 : mapTo) {
            destination.add(transform.invoke(G.a(G.m1188constructorimpl(i5))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: mapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m448mapTowzUQCXU(byte[] mapTo, C destination, l transform) {
        E.f(mapTo, "$this$mapTo");
        E.f(destination, "destination");
        E.f(transform, "transform");
        for (byte b : mapTo) {
            destination.add(transform.invoke(D.a(D.m1131constructorimpl(b))));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> D m449maxByOrNullJOV_ifY(byte[] maxByOrNull, l selector) {
        E.f(maxByOrNull, "$this$maxByOrNull");
        E.f(selector, "selector");
        if (maxByOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(maxByOrNull[0]);
        int lastIndex = C.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return D.a(bM1131constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(D.a(bM1131constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(maxByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(D.a(bM1131constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: maxByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> J m450maxByOrNullMShoTSo(long[] maxByOrNull, l selector) {
        E.f(maxByOrNull, "$this$maxByOrNull");
        E.f(selector, "selector");
        if (maxByOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(maxByOrNull[0]);
        int lastIndex = C.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return J.a(jM1247constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(J.a(jM1247constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(maxByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(J.a(jM1247constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: maxByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> G m451maxByOrNulljgv0xPQ(int[] maxByOrNull, l selector) {
        E.f(maxByOrNull, "$this$maxByOrNull");
        E.f(selector, "selector");
        if (maxByOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(maxByOrNull[0]);
        int lastIndex = C.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return G.a(iM1188constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(G.a(iM1188constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(maxByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(G.a(iM1188constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: maxByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> N m452maxByOrNullxTcfx_M(short[] maxByOrNull, l selector) {
        E.f(maxByOrNull, "$this$maxByOrNull");
        E.f(selector, "selector");
        if (maxByOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(maxByOrNull[0]);
        int lastIndex = C.getLastIndex(maxByOrNull);
        if (lastIndex == 0) {
            return N.a(sM1306constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(N.a(sM1306constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(maxByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(N.a(sM1306constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m453maxByOrThrowU(byte[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length == 0) {
            throw new NoSuchElementException();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(maxBy[0]);
        int lastIndex = C.getLastIndex(maxBy);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(D.a(bM1131constructorimpl));
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM1131constructorimpl2 = D.m1131constructorimpl(maxBy[i5]);
                    Comparable comparable2 = (Comparable) selector.invoke(D.a(bM1131constructorimpl2));
                    if (comparable.compareTo(comparable2) < 0) {
                        bM1131constructorimpl = bM1131constructorimpl2;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final double m457maxOfJOV_ifY(byte[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.d(maxOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.d(maxOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final double m460maxOfMShoTSo(long[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.g(maxOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.g(maxOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final double m463maxOfjgv0xPQ(int[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.e(maxOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.e(maxOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final double m466maxOfxTcfx_M(short[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.i(maxOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.i(maxOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m469maxOfOrNullJOV_ifY(byte[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.d(maxOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.d(maxOfOrNull[i5], selector);
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m472maxOfOrNullMShoTSo(long[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.g(maxOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.g(maxOfOrNull[i5], selector);
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m475maxOfOrNulljgv0xPQ(int[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.e(maxOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.e(maxOfOrNull[i5], selector);
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m478maxOfOrNullxTcfx_M(short[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.i(maxOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.i(maxOfOrNull[i5], selector);
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m481maxOfWith5NtCtWE(long[] maxOfWith, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWith, "$this$maxOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.g(maxOfWith[0], selector);
        int lastIndex = C.getLastIndex(maxOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.g(maxOfWith[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m482maxOfWithLTi4i_s(byte[] maxOfWith, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWith, "$this$maxOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.d(maxOfWith[0], selector);
        int lastIndex = C.getLastIndex(maxOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.d(maxOfWith[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m483maxOfWithl8EHGbQ(short[] maxOfWith, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWith, "$this$maxOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.i(maxOfWith[0], selector);
        int lastIndex = C.getLastIndex(maxOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.i(maxOfWith[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m484maxOfWithmyNOsp4(int[] maxOfWith, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWith, "$this$maxOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.e(maxOfWith[0], selector);
        int lastIndex = C.getLastIndex(maxOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.e(maxOfWith[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m485maxOfWithOrNull5NtCtWE(long[] maxOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWithOrNull, "$this$maxOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.g(maxOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.g(maxOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m486maxOfWithOrNullLTi4i_s(byte[] maxOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWithOrNull, "$this$maxOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.d(maxOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.d(maxOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m487maxOfWithOrNulll8EHGbQ(short[] maxOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWithOrNull, "$this$maxOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.i(maxOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.i(maxOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m488maxOfWithOrNullmyNOsp4(int[] maxOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(maxOfWithOrNull, "$this$maxOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (maxOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.e(maxOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(maxOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.e(maxOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final G m489maxOrNullajY9A(int[] maxOrNull) {
        E.f(maxOrNull, "$this$maxOrNull");
        if (maxOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(maxOrNull[0]);
        int lastIndex = C.getLastIndex(maxOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(maxOrNull[i5]);
                if (Integer.compareUnsigned(iM1188constructorimpl, iM1188constructorimpl2) < 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final D m490maxOrNullGBYM_sE(byte[] maxOrNull) {
        E.f(maxOrNull, "$this$maxOrNull");
        if (maxOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(maxOrNull[0]);
        int lastIndex = C.getLastIndex(maxOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(maxOrNull[i5]);
                if (E.h(bM1131constructorimpl & UnsignedBytes.MAX_VALUE, bM1131constructorimpl2 & UnsignedBytes.MAX_VALUE) < 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final J m491maxOrNullQwZRm1k(long[] maxOrNull) {
        E.f(maxOrNull, "$this$maxOrNull");
        if (maxOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(maxOrNull[0]);
        int lastIndex = C.getLastIndex(maxOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(maxOrNull[i5]);
                if (Long.compareUnsigned(jM1247constructorimpl, jM1247constructorimpl2) < 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final N m492maxOrNullrL5Bavg(short[] maxOrNull) {
        E.f(maxOrNull, "$this$maxOrNull");
        if (maxOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(maxOrNull[0]);
        int lastIndex = C.getLastIndex(maxOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(maxOrNull[i5]);
                if (E.h(sM1306constructorimpl & 65535, 65535 & sM1306constructorimpl2) < 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final byte m493maxOrThrowU(byte[] max) {
        E.f(max, "$this$max");
        if (max.length == 0) {
            throw new NoSuchElementException();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(max[0]);
        int lastIndex = C.getLastIndex(max);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(max[i5]);
                if (E.h(bM1131constructorimpl & UnsignedBytes.MAX_VALUE, bM1131constructorimpl2 & UnsignedBytes.MAX_VALUE) < 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final D m497maxWithOrNullXMRcp5o(byte[] maxWithOrNull, Comparator<? super D> comparator) {
        E.f(maxWithOrNull, "$this$maxWithOrNull");
        E.f(comparator, "comparator");
        if (maxWithOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(maxWithOrNull[0]);
        int lastIndex = C.getLastIndex(maxWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(maxWithOrNull[i5]);
                if (comparator.compare(D.a(bM1131constructorimpl), D.a(bM1131constructorimpl2)) < 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final G m498maxWithOrNullYmdZ_VM(int[] maxWithOrNull, Comparator<? super G> comparator) {
        E.f(maxWithOrNull, "$this$maxWithOrNull");
        E.f(comparator, "comparator");
        if (maxWithOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(maxWithOrNull[0]);
        int lastIndex = C.getLastIndex(maxWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(maxWithOrNull[i5]);
                if (comparator.compare(G.a(iM1188constructorimpl), G.a(iM1188constructorimpl2)) < 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final N m499maxWithOrNulleOHTfZs(short[] maxWithOrNull, Comparator<? super N> comparator) {
        E.f(maxWithOrNull, "$this$maxWithOrNull");
        E.f(comparator, "comparator");
        if (maxWithOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(maxWithOrNull[0]);
        int lastIndex = C.getLastIndex(maxWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(maxWithOrNull[i5]);
                if (comparator.compare(N.a(sM1306constructorimpl), N.a(sM1306constructorimpl2)) < 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final J m500maxWithOrNullzrEWJaI(long[] maxWithOrNull, Comparator<? super J> comparator) {
        E.f(maxWithOrNull, "$this$maxWithOrNull");
        E.f(comparator, "comparator");
        if (maxWithOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(maxWithOrNull[0]);
        int lastIndex = C.getLastIndex(maxWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(maxWithOrNull[i5]);
                if (comparator.compare(J.a(jM1247constructorimpl), J.a(jM1247constructorimpl2)) < 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final byte m501maxWithOrThrowU(byte[] maxWith, Comparator<? super D> comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        if (maxWith.length == 0) {
            throw new NoSuchElementException();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(maxWith[0]);
        int lastIndex = C.getLastIndex(maxWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(maxWith[i5]);
                if (comparator.compare(D.a(bM1131constructorimpl), D.a(bM1131constructorimpl2)) < 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: minByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> D m505minByOrNullJOV_ifY(byte[] minByOrNull, l selector) {
        E.f(minByOrNull, "$this$minByOrNull");
        E.f(selector, "selector");
        if (minByOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(minByOrNull[0]);
        int lastIndex = C.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return D.a(bM1131constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(D.a(bM1131constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(minByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(D.a(bM1131constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: minByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> J m506minByOrNullMShoTSo(long[] minByOrNull, l selector) {
        E.f(minByOrNull, "$this$minByOrNull");
        E.f(selector, "selector");
        if (minByOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(minByOrNull[0]);
        int lastIndex = C.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return J.a(jM1247constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(J.a(jM1247constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(minByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(J.a(jM1247constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: minByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> G m507minByOrNulljgv0xPQ(int[] minByOrNull, l selector) {
        E.f(minByOrNull, "$this$minByOrNull");
        E.f(selector, "selector");
        if (minByOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(minByOrNull[0]);
        int lastIndex = C.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return G.a(iM1188constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(G.a(iM1188constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(minByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(G.a(iM1188constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: minByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> N m508minByOrNullxTcfx_M(short[] minByOrNull, l selector) {
        E.f(minByOrNull, "$this$minByOrNull");
        E.f(selector, "selector");
        if (minByOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(minByOrNull[0]);
        int lastIndex = C.getLastIndex(minByOrNull);
        if (lastIndex == 0) {
            return N.a(sM1306constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(N.a(sM1306constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(minByOrNull[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(N.a(sM1306constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m509minByOrThrowU(byte[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length == 0) {
            throw new NoSuchElementException();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(minBy[0]);
        int lastIndex = C.getLastIndex(minBy);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(D.a(bM1131constructorimpl));
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte bM1131constructorimpl2 = D.m1131constructorimpl(minBy[i5]);
                    Comparable comparable2 = (Comparable) selector.invoke(D.a(bM1131constructorimpl2));
                    if (comparable.compareTo(comparable2) > 0) {
                        bM1131constructorimpl = bM1131constructorimpl2;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final double m513minOfJOV_ifY(byte[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.d(minOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.d(minOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final double m516minOfMShoTSo(long[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.g(minOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.g(minOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final double m519minOfjgv0xPQ(int[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.e(minOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.e(minOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final double m522minOfxTcfx_M(short[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.i(minOf[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOf);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.i(minOf[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m525minOfOrNullJOV_ifY(byte[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.d(minOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.d(minOfOrNull[i5], selector);
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m528minOfOrNullMShoTSo(long[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.g(minOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.g(minOfOrNull[i5], selector);
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m531minOfOrNulljgv0xPQ(int[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.e(minOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.e(minOfOrNull[i5], selector);
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m534minOfOrNullxTcfx_M(short[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.i(minOfOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.i(minOfOrNull[i5], selector);
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m537minOfWith5NtCtWE(long[] minOfWith, Comparator<? super R> comparator, l selector) {
        E.f(minOfWith, "$this$minOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.g(minOfWith[0], selector);
        int lastIndex = C.getLastIndex(minOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.g(minOfWith[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m538minOfWithLTi4i_s(byte[] minOfWith, Comparator<? super R> comparator, l selector) {
        E.f(minOfWith, "$this$minOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.d(minOfWith[0], selector);
        int lastIndex = C.getLastIndex(minOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.d(minOfWith[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m539minOfWithl8EHGbQ(short[] minOfWith, Comparator<? super R> comparator, l selector) {
        E.f(minOfWith, "$this$minOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.i(minOfWith[0], selector);
        int lastIndex = C.getLastIndex(minOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.i(minOfWith[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m540minOfWithmyNOsp4(int[] minOfWith, Comparator<? super R> comparator, l selector) {
        E.f(minOfWith, "$this$minOfWith");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWith.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.e(minOfWith[0], selector);
        int lastIndex = C.getLastIndex(minOfWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.e(minOfWith[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m541minOfWithOrNull5NtCtWE(long[] minOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(minOfWithOrNull, "$this$minOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.g(minOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.g(minOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m542minOfWithOrNullLTi4i_s(byte[] minOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(minOfWithOrNull, "$this$minOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.d(minOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.d(minOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m543minOfWithOrNulll8EHGbQ(short[] minOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(minOfWithOrNull, "$this$minOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.i(minOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.i(minOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m544minOfWithOrNullmyNOsp4(int[] minOfWithOrNull, Comparator<? super R> comparator, l selector) {
        E.f(minOfWithOrNull, "$this$minOfWithOrNull");
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        if (minOfWithOrNull.length == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.e(minOfWithOrNull[0], selector);
        int lastIndex = C.getLastIndex(minOfWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.e(minOfWithOrNull[i5], selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final G m545minOrNullajY9A(int[] minOrNull) {
        E.f(minOrNull, "$this$minOrNull");
        if (minOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(minOrNull[0]);
        int lastIndex = C.getLastIndex(minOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(minOrNull[i5]);
                if (Integer.compareUnsigned(iM1188constructorimpl, iM1188constructorimpl2) > 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final D m546minOrNullGBYM_sE(byte[] minOrNull) {
        E.f(minOrNull, "$this$minOrNull");
        if (minOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(minOrNull[0]);
        int lastIndex = C.getLastIndex(minOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(minOrNull[i5]);
                if (E.h(bM1131constructorimpl & UnsignedBytes.MAX_VALUE, bM1131constructorimpl2 & UnsignedBytes.MAX_VALUE) > 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final J m547minOrNullQwZRm1k(long[] minOrNull) {
        E.f(minOrNull, "$this$minOrNull");
        if (minOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(minOrNull[0]);
        int lastIndex = C.getLastIndex(minOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(minOrNull[i5]);
                if (Long.compareUnsigned(jM1247constructorimpl, jM1247constructorimpl2) > 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final N m548minOrNullrL5Bavg(short[] minOrNull) {
        E.f(minOrNull, "$this$minOrNull");
        if (minOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(minOrNull[0]);
        int lastIndex = C.getLastIndex(minOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(minOrNull[i5]);
                if (E.h(sM1306constructorimpl & 65535, 65535 & sM1306constructorimpl2) > 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final byte m549minOrThrowU(byte[] min) {
        E.f(min, "$this$min");
        if (min.length == 0) {
            throw new NoSuchElementException();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(min[0]);
        int lastIndex = C.getLastIndex(min);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(min[i5]);
                if (E.h(bM1131constructorimpl & UnsignedBytes.MAX_VALUE, bM1131constructorimpl2 & UnsignedBytes.MAX_VALUE) > 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final D m553minWithOrNullXMRcp5o(byte[] minWithOrNull, Comparator<? super D> comparator) {
        E.f(minWithOrNull, "$this$minWithOrNull");
        E.f(comparator, "comparator");
        if (minWithOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(minWithOrNull[0]);
        int lastIndex = C.getLastIndex(minWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(minWithOrNull[i5]);
                if (comparator.compare(D.a(bM1131constructorimpl), D.a(bM1131constructorimpl2)) > 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final G m554minWithOrNullYmdZ_VM(int[] minWithOrNull, Comparator<? super G> comparator) {
        E.f(minWithOrNull, "$this$minWithOrNull");
        E.f(comparator, "comparator");
        if (minWithOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(minWithOrNull[0]);
        int lastIndex = C.getLastIndex(minWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(minWithOrNull[i5]);
                if (comparator.compare(G.a(iM1188constructorimpl), G.a(iM1188constructorimpl2)) > 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final N m555minWithOrNulleOHTfZs(short[] minWithOrNull, Comparator<? super N> comparator) {
        E.f(minWithOrNull, "$this$minWithOrNull");
        E.f(comparator, "comparator");
        if (minWithOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(minWithOrNull[0]);
        int lastIndex = C.getLastIndex(minWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(minWithOrNull[i5]);
                if (comparator.compare(N.a(sM1306constructorimpl), N.a(sM1306constructorimpl2)) > 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final J m556minWithOrNullzrEWJaI(long[] minWithOrNull, Comparator<? super J> comparator) {
        E.f(minWithOrNull, "$this$minWithOrNull");
        E.f(comparator, "comparator");
        if (minWithOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(minWithOrNull[0]);
        int lastIndex = C.getLastIndex(minWithOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(minWithOrNull[i5]);
                if (comparator.compare(J.a(jM1247constructorimpl), J.a(jM1247constructorimpl2)) > 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final byte m557minWithOrThrowU(byte[] minWith, Comparator<? super D> comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        if (minWith.length == 0) {
            throw new NoSuchElementException();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(minWith[0]);
        int lastIndex = C.getLastIndex(minWith);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(minWith[i5]);
                if (comparator.compare(D.a(bM1131constructorimpl), D.a(bM1131constructorimpl2)) > 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: none--ajY-9A, reason: not valid java name */
    private static final boolean m561noneajY9A(int[] none) {
        E.f(none, "$this$none");
        return none.length == 0;
    }

    /* JADX INFO: renamed from: none-GBYM_sE, reason: not valid java name */
    private static final boolean m562noneGBYM_sE(byte[] none) {
        E.f(none, "$this$none");
        return none.length == 0;
    }

    /* JADX INFO: renamed from: none-JOV_ifY, reason: not valid java name */
    private static final boolean m563noneJOV_ifY(byte[] none, l predicate) {
        E.f(none, "$this$none");
        E.f(predicate, "predicate");
        for (byte b : none) {
            if (((Boolean) AbstractC0157z.d(b, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-MShoTSo, reason: not valid java name */
    private static final boolean m564noneMShoTSo(long[] none, l predicate) {
        E.f(none, "$this$none");
        E.f(predicate, "predicate");
        for (long j6 : none) {
            if (((Boolean) AbstractC0157z.g(j6, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-QwZRm1k, reason: not valid java name */
    private static final boolean m565noneQwZRm1k(long[] none) {
        E.f(none, "$this$none");
        return none.length == 0;
    }

    /* JADX INFO: renamed from: none-jgv0xPQ, reason: not valid java name */
    private static final boolean m566nonejgv0xPQ(int[] none, l predicate) {
        E.f(none, "$this$none");
        E.f(predicate, "predicate");
        for (int i5 : none) {
            if (((Boolean) AbstractC0157z.e(i5, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: none-rL5Bavg, reason: not valid java name */
    private static final boolean m567nonerL5Bavg(short[] none) {
        E.f(none, "$this$none");
        return none.length == 0;
    }

    /* JADX INFO: renamed from: none-xTcfx_M, reason: not valid java name */
    private static final boolean m568nonexTcfx_M(short[] none, l predicate) {
        E.f(none, "$this$none");
        E.f(predicate, "predicate");
        for (short s6 : none) {
            if (((Boolean) AbstractC0157z.i(s6, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: onEach-JOV_ifY, reason: not valid java name */
    private static final byte[] m569onEachJOV_ifY(byte[] onEach, l action) {
        E.f(onEach, "$this$onEach");
        E.f(action, "action");
        for (byte b : onEach) {
            action.invoke(D.a(D.m1131constructorimpl(b)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEach-MShoTSo, reason: not valid java name */
    private static final long[] m570onEachMShoTSo(long[] onEach, l action) {
        E.f(onEach, "$this$onEach");
        E.f(action, "action");
        for (long j6 : onEach) {
            action.invoke(J.a(J.m1247constructorimpl(j6)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEach-jgv0xPQ, reason: not valid java name */
    private static final int[] m571onEachjgv0xPQ(int[] onEach, l action) {
        E.f(onEach, "$this$onEach");
        E.f(action, "action");
        for (int i5 : onEach) {
            action.invoke(G.a(G.m1188constructorimpl(i5)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEach-xTcfx_M, reason: not valid java name */
    private static final short[] m572onEachxTcfx_M(short[] onEach, l action) {
        E.f(onEach, "$this$onEach");
        E.f(action, "action");
        for (short s6 : onEach) {
            action.invoke(N.a(N.m1306constructorimpl(s6)));
        }
        return onEach;
    }

    /* JADX INFO: renamed from: onEachIndexed-ELGow60, reason: not valid java name */
    private static final byte[] m573onEachIndexedELGow60(byte[] onEachIndexed, p action) {
        E.f(onEachIndexed, "$this$onEachIndexed");
        E.f(action, "action");
        int length = onEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), D.a(D.m1131constructorimpl(onEachIndexed[i5])));
            i5++;
            i6++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: onEachIndexed-WyvcNBI, reason: not valid java name */
    private static final int[] m574onEachIndexedWyvcNBI(int[] onEachIndexed, p action) {
        E.f(onEachIndexed, "$this$onEachIndexed");
        E.f(action, "action");
        int length = onEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), G.a(G.m1188constructorimpl(onEachIndexed[i5])));
            i5++;
            i6++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: onEachIndexed-s8dVfGU, reason: not valid java name */
    private static final long[] m575onEachIndexeds8dVfGU(long[] onEachIndexed, p action) {
        E.f(onEachIndexed, "$this$onEachIndexed");
        E.f(action, "action");
        int length = onEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), J.a(J.m1247constructorimpl(onEachIndexed[i5])));
            i5++;
            i6++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: onEachIndexed-xzaTVY8, reason: not valid java name */
    private static final short[] m576onEachIndexedxzaTVY8(short[] onEachIndexed, p action) {
        E.f(onEachIndexed, "$this$onEachIndexed");
        E.f(action, "action");
        int length = onEachIndexed.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), N.a(N.m1306constructorimpl(onEachIndexed[i5])));
            i5++;
            i6++;
        }
        return onEachIndexed;
    }

    /* JADX INFO: renamed from: plus-3uqUaXg, reason: not valid java name */
    private static final long[] m577plus3uqUaXg(long[] plus, long j6) {
        E.f(plus, "$this$plus");
        return K.m1297constructorimpl(AbstractC0151t.plus(plus, j6));
    }

    /* JADX INFO: renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m578plusCFIt9YE(int[] plus, Collection<G> elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        int length = plus.length;
        int[] iArrCopyOf = Arrays.copyOf(plus, elements.size() + plus.length);
        E.e(iArrCopyOf, "copyOf(...)");
        Iterator<G> it = elements.iterator();
        while (it.hasNext()) {
            iArrCopyOf[length] = it.next().f9124a;
            length++;
        }
        return H.m1238constructorimpl(iArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-XzdR7RA, reason: not valid java name */
    private static final short[] m579plusXzdR7RA(short[] plus, short s6) {
        E.f(plus, "$this$plus");
        return O.m1354constructorimpl(AbstractC0151t.plus(plus, s6));
    }

    /* JADX INFO: renamed from: plus-ctEhBpI, reason: not valid java name */
    private static final int[] m580plusctEhBpI(int[] plus, int[] elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        return H.m1238constructorimpl(AbstractC0151t.plus(plus, elements));
    }

    /* JADX INFO: renamed from: plus-gMuBH34, reason: not valid java name */
    private static final byte[] m581plusgMuBH34(byte[] plus, byte b) {
        E.f(plus, "$this$plus");
        return p147z3.E.m1179constructorimpl(AbstractC0151t.plus(plus, b));
    }

    /* JADX INFO: renamed from: plus-kdPth3s, reason: not valid java name */
    private static final byte[] m582pluskdPth3s(byte[] plus, byte[] elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        return p147z3.E.m1179constructorimpl(AbstractC0151t.plus(plus, elements));
    }

    /* JADX INFO: renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m583pluskzHmqpY(long[] plus, Collection<J> elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        int length = plus.length;
        long[] jArrCopyOf = Arrays.copyOf(plus, elements.size() + plus.length);
        E.e(jArrCopyOf, "copyOf(...)");
        Iterator<J> it = elements.iterator();
        while (it.hasNext()) {
            jArrCopyOf[length] = it.next().f9126a;
            length++;
        }
        return K.m1297constructorimpl(jArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-mazbYpA, reason: not valid java name */
    private static final short[] m584plusmazbYpA(short[] plus, short[] elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        return O.m1354constructorimpl(AbstractC0151t.plus(plus, elements));
    }

    /* JADX INFO: renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m585plusojwP5H8(short[] plus, Collection<N> elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        int length = plus.length;
        short[] sArrCopyOf = Arrays.copyOf(plus, elements.size() + plus.length);
        E.e(sArrCopyOf, "copyOf(...)");
        Iterator<N> it = elements.iterator();
        while (it.hasNext()) {
            sArrCopyOf[length] = it.next().f9128a;
            length++;
        }
        return O.m1354constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: plus-uWY9BYg, reason: not valid java name */
    private static final int[] m586plusuWY9BYg(int[] plus, int i5) {
        E.f(plus, "$this$plus");
        return H.m1238constructorimpl(AbstractC0151t.plus(plus, i5));
    }

    /* JADX INFO: renamed from: plus-us8wMrg, reason: not valid java name */
    private static final long[] m587plusus8wMrg(long[] plus, long[] elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        return K.m1297constructorimpl(AbstractC0151t.plus(plus, elements));
    }

    /* JADX INFO: renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m588plusxo_DsdI(byte[] plus, Collection<D> elements) {
        E.f(plus, "$this$plus");
        E.f(elements, "elements");
        int length = plus.length;
        byte[] bArrCopyOf = Arrays.copyOf(plus, elements.size() + plus.length);
        E.e(bArrCopyOf, "copyOf(...)");
        Iterator<D> it = elements.iterator();
        while (it.hasNext()) {
            bArrCopyOf[length] = it.next().f9122a;
            length++;
        }
        return p147z3.E.m1179constructorimpl(bArrCopyOf);
    }

    /* JADX INFO: renamed from: random--ajY-9A, reason: not valid java name */
    private static final int m589randomajY9A(int[] random) {
        E.f(random, "$this$random");
        return m590random2D5oskM(random, f.Default);
    }

    /* JADX INFO: renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m590random2D5oskM(int[] random, f random2) {
        E.f(random, "$this$random");
        E.f(random2, "random");
        if (random.length != 0) {
            return G.m1188constructorimpl(random[random2.d(random.length)]);
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX INFO: renamed from: random-GBYM_sE, reason: not valid java name */
    private static final byte m591randomGBYM_sE(byte[] random) {
        E.f(random, "$this$random");
        return m594randomoSF2wD8(random, f.Default);
    }

    /* JADX INFO: renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m592randomJzugnMA(long[] random, f random2) {
        E.f(random, "$this$random");
        E.f(random2, "random");
        if (random.length != 0) {
            return J.m1247constructorimpl(random[random2.d(random.length)]);
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX INFO: renamed from: random-QwZRm1k, reason: not valid java name */
    private static final long m593randomQwZRm1k(long[] random) {
        E.f(random, "$this$random");
        return m592randomJzugnMA(random, f.Default);
    }

    /* JADX INFO: renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m594randomoSF2wD8(byte[] random, f random2) {
        E.f(random, "$this$random");
        E.f(random2, "random");
        if (random.length != 0) {
            return D.m1131constructorimpl(random[random2.d(random.length)]);
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX INFO: renamed from: random-rL5Bavg, reason: not valid java name */
    private static final short m595randomrL5Bavg(short[] random) {
        E.f(random, "$this$random");
        return m596randoms5X_as8(random, f.Default);
    }

    /* JADX INFO: renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m596randoms5X_as8(short[] random, f random2) {
        E.f(random, "$this$random");
        E.f(random2, "random");
        if (random.length != 0) {
            return N.m1306constructorimpl(random[random2.d(random.length)]);
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX INFO: renamed from: randomOrNull--ajY-9A, reason: not valid java name */
    private static final G m597randomOrNullajY9A(int[] randomOrNull) {
        E.f(randomOrNull, "$this$randomOrNull");
        return m598randomOrNull2D5oskM(randomOrNull, f.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final G m598randomOrNull2D5oskM(int[] randomOrNull, f random) {
        E.f(randomOrNull, "$this$randomOrNull");
        E.f(random, "random");
        if (randomOrNull.length == 0) {
            return null;
        }
        return G.a(G.m1188constructorimpl(randomOrNull[random.d(randomOrNull.length)]));
    }

    /* JADX INFO: renamed from: randomOrNull-GBYM_sE, reason: not valid java name */
    private static final D m599randomOrNullGBYM_sE(byte[] randomOrNull) {
        E.f(randomOrNull, "$this$randomOrNull");
        return m602randomOrNulloSF2wD8(randomOrNull, f.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final J m600randomOrNullJzugnMA(long[] randomOrNull, f random) {
        E.f(randomOrNull, "$this$randomOrNull");
        E.f(random, "random");
        if (randomOrNull.length == 0) {
            return null;
        }
        return J.a(J.m1247constructorimpl(randomOrNull[random.d(randomOrNull.length)]));
    }

    /* JADX INFO: renamed from: randomOrNull-QwZRm1k, reason: not valid java name */
    private static final J m601randomOrNullQwZRm1k(long[] randomOrNull) {
        E.f(randomOrNull, "$this$randomOrNull");
        return m600randomOrNullJzugnMA(randomOrNull, f.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final D m602randomOrNulloSF2wD8(byte[] randomOrNull, f random) {
        E.f(randomOrNull, "$this$randomOrNull");
        E.f(random, "random");
        if (randomOrNull.length == 0) {
            return null;
        }
        return D.a(D.m1131constructorimpl(randomOrNull[random.d(randomOrNull.length)]));
    }

    /* JADX INFO: renamed from: randomOrNull-rL5Bavg, reason: not valid java name */
    private static final N m603randomOrNullrL5Bavg(short[] randomOrNull) {
        E.f(randomOrNull, "$this$randomOrNull");
        return m604randomOrNulls5X_as8(randomOrNull, f.Default);
    }

    /* JADX INFO: renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final N m604randomOrNulls5X_as8(short[] randomOrNull, f random) {
        E.f(randomOrNull, "$this$randomOrNull");
        E.f(random, "random");
        if (randomOrNull.length == 0) {
            return null;
        }
        return N.a(N.m1306constructorimpl(randomOrNull[random.d(randomOrNull.length)]));
    }

    /* JADX INFO: renamed from: reduce-ELGow60, reason: not valid java name */
    private static final byte m605reduceELGow60(byte[] reduce, p operation) {
        E.f(reduce, "$this$reduce");
        E.f(operation, "operation");
        if (reduce.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduce[0]);
        int lastIndex = C.getLastIndex(reduce);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM1131constructorimpl = ((D) operation.invoke(D.a(bM1131constructorimpl), D.a(D.m1131constructorimpl(reduce[i5])))).f9122a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: reduce-WyvcNBI, reason: not valid java name */
    private static final int m606reduceWyvcNBI(int[] reduce, p operation) {
        E.f(reduce, "$this$reduce");
        E.f(operation, "operation");
        if (reduce.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduce[0]);
        int lastIndex = C.getLastIndex(reduce);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM1188constructorimpl = ((G) operation.invoke(G.a(iM1188constructorimpl), G.a(G.m1188constructorimpl(reduce[i5])))).f9124a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: reduce-s8dVfGU, reason: not valid java name */
    private static final long m607reduces8dVfGU(long[] reduce, p operation) {
        E.f(reduce, "$this$reduce");
        E.f(operation, "operation");
        if (reduce.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduce[0]);
        int lastIndex = C.getLastIndex(reduce);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM1247constructorimpl = ((J) operation.invoke(J.a(jM1247constructorimpl), J.a(J.m1247constructorimpl(reduce[i5])))).f9126a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return jM1247constructorimpl;
    }

    /* JADX INFO: renamed from: reduce-xzaTVY8, reason: not valid java name */
    private static final short m608reducexzaTVY8(short[] reduce, p operation) {
        E.f(reduce, "$this$reduce");
        E.f(operation, "operation");
        if (reduce.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduce[0]);
        int lastIndex = C.getLastIndex(reduce);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM1306constructorimpl = ((N) operation.invoke(N.a(sM1306constructorimpl), N.a(N.m1306constructorimpl(reduce[i5])))).f9128a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return sM1306constructorimpl;
    }

    /* JADX INFO: renamed from: reduceIndexed-D40WMg8, reason: not valid java name */
    private static final int m609reduceIndexedD40WMg8(int[] reduceIndexed, q operation) {
        E.f(reduceIndexed, "$this$reduceIndexed");
        E.f(operation, "operation");
        if (reduceIndexed.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduceIndexed[0]);
        int lastIndex = C.getLastIndex(reduceIndexed);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM1188constructorimpl = ((G) operation.invoke(Integer.valueOf(i5), G.a(iM1188constructorimpl), G.a(G.m1188constructorimpl(reduceIndexed[i5])))).f9124a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: reduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m610reduceIndexedEOyYB1Y(byte[] reduceIndexed, q operation) {
        E.f(reduceIndexed, "$this$reduceIndexed");
        E.f(operation, "operation");
        if (reduceIndexed.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduceIndexed[0]);
        int lastIndex = C.getLastIndex(reduceIndexed);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM1131constructorimpl = ((D) operation.invoke(Integer.valueOf(i5), D.a(bM1131constructorimpl), D.a(D.m1131constructorimpl(reduceIndexed[i5])))).f9122a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: reduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m611reduceIndexedaLgx1Fo(short[] reduceIndexed, q operation) {
        E.f(reduceIndexed, "$this$reduceIndexed");
        E.f(operation, "operation");
        if (reduceIndexed.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduceIndexed[0]);
        int lastIndex = C.getLastIndex(reduceIndexed);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM1306constructorimpl = ((N) operation.invoke(Integer.valueOf(i5), N.a(sM1306constructorimpl), N.a(N.m1306constructorimpl(reduceIndexed[i5])))).f9128a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return sM1306constructorimpl;
    }

    /* JADX INFO: renamed from: reduceIndexed-z1zDJgo, reason: not valid java name */
    private static final long m612reduceIndexedz1zDJgo(long[] reduceIndexed, q operation) {
        E.f(reduceIndexed, "$this$reduceIndexed");
        E.f(operation, "operation");
        if (reduceIndexed.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduceIndexed[0]);
        int lastIndex = C.getLastIndex(reduceIndexed);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM1247constructorimpl = ((J) operation.invoke(Integer.valueOf(i5), J.a(jM1247constructorimpl), J.a(J.m1247constructorimpl(reduceIndexed[i5])))).f9126a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return jM1247constructorimpl;
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final G m613reduceIndexedOrNullD40WMg8(int[] reduceIndexedOrNull, q operation) {
        E.f(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        E.f(operation, "operation");
        if (reduceIndexedOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduceIndexedOrNull[0]);
        int lastIndex = C.getLastIndex(reduceIndexedOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM1188constructorimpl = ((G) operation.invoke(Integer.valueOf(i5), G.a(iM1188constructorimpl), G.a(G.m1188constructorimpl(reduceIndexedOrNull[i5])))).f9124a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final D m614reduceIndexedOrNullEOyYB1Y(byte[] reduceIndexedOrNull, q operation) {
        E.f(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        E.f(operation, "operation");
        if (reduceIndexedOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduceIndexedOrNull[0]);
        int lastIndex = C.getLastIndex(reduceIndexedOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM1131constructorimpl = ((D) operation.invoke(Integer.valueOf(i5), D.a(bM1131constructorimpl), D.a(D.m1131constructorimpl(reduceIndexedOrNull[i5])))).f9122a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final N m615reduceIndexedOrNullaLgx1Fo(short[] reduceIndexedOrNull, q operation) {
        E.f(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        E.f(operation, "operation");
        if (reduceIndexedOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduceIndexedOrNull[0]);
        int lastIndex = C.getLastIndex(reduceIndexedOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM1306constructorimpl = ((N) operation.invoke(Integer.valueOf(i5), N.a(sM1306constructorimpl), N.a(N.m1306constructorimpl(reduceIndexedOrNull[i5])))).f9128a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: reduceIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final J m616reduceIndexedOrNullz1zDJgo(long[] reduceIndexedOrNull, q operation) {
        E.f(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        E.f(operation, "operation");
        if (reduceIndexedOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduceIndexedOrNull[0]);
        int lastIndex = C.getLastIndex(reduceIndexedOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM1247constructorimpl = ((J) operation.invoke(Integer.valueOf(i5), J.a(jM1247constructorimpl), J.a(J.m1247constructorimpl(reduceIndexedOrNull[i5])))).f9126a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: reduceOrNull-ELGow60, reason: not valid java name */
    private static final D m617reduceOrNullELGow60(byte[] reduceOrNull, p operation) {
        E.f(reduceOrNull, "$this$reduceOrNull");
        E.f(operation, "operation");
        if (reduceOrNull.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduceOrNull[0]);
        int lastIndex = C.getLastIndex(reduceOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bM1131constructorimpl = ((D) operation.invoke(D.a(bM1131constructorimpl), D.a(D.m1131constructorimpl(reduceOrNull[i5])))).f9122a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: reduceOrNull-WyvcNBI, reason: not valid java name */
    private static final G m618reduceOrNullWyvcNBI(int[] reduceOrNull, p operation) {
        E.f(reduceOrNull, "$this$reduceOrNull");
        E.f(operation, "operation");
        if (reduceOrNull.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduceOrNull[0]);
        int lastIndex = C.getLastIndex(reduceOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iM1188constructorimpl = ((G) operation.invoke(G.a(iM1188constructorimpl), G.a(G.m1188constructorimpl(reduceOrNull[i5])))).f9124a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: reduceOrNull-s8dVfGU, reason: not valid java name */
    private static final J m619reduceOrNulls8dVfGU(long[] reduceOrNull, p operation) {
        E.f(reduceOrNull, "$this$reduceOrNull");
        E.f(operation, "operation");
        if (reduceOrNull.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduceOrNull[0]);
        int lastIndex = C.getLastIndex(reduceOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jM1247constructorimpl = ((J) operation.invoke(J.a(jM1247constructorimpl), J.a(J.m1247constructorimpl(reduceOrNull[i5])))).f9126a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: reduceOrNull-xzaTVY8, reason: not valid java name */
    private static final N m620reduceOrNullxzaTVY8(short[] reduceOrNull, p operation) {
        E.f(reduceOrNull, "$this$reduceOrNull");
        E.f(operation, "operation");
        if (reduceOrNull.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduceOrNull[0]);
        int lastIndex = C.getLastIndex(reduceOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sM1306constructorimpl = ((N) operation.invoke(N.a(sM1306constructorimpl), N.a(N.m1306constructorimpl(reduceOrNull[i5])))).f9128a;
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRight-ELGow60, reason: not valid java name */
    private static final byte m621reduceRightELGow60(byte[] reduceRight, p operation) {
        E.f(reduceRight, "$this$reduceRight");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduceRight[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            bM1131constructorimpl = ((D) operation.invoke(D.a(D.m1131constructorimpl(reduceRight[i5])), D.a(bM1131constructorimpl))).f9122a;
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRight-WyvcNBI, reason: not valid java name */
    private static final int m622reduceRightWyvcNBI(int[] reduceRight, p operation) {
        E.f(reduceRight, "$this$reduceRight");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduceRight[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            iM1188constructorimpl = ((G) operation.invoke(G.a(G.m1188constructorimpl(reduceRight[i5])), G.a(iM1188constructorimpl))).f9124a;
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRight-s8dVfGU, reason: not valid java name */
    private static final long m623reduceRights8dVfGU(long[] reduceRight, p operation) {
        E.f(reduceRight, "$this$reduceRight");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduceRight[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            jM1247constructorimpl = ((J) operation.invoke(J.a(J.m1247constructorimpl(reduceRight[i5])), J.a(jM1247constructorimpl))).f9126a;
        }
        return jM1247constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRight-xzaTVY8, reason: not valid java name */
    private static final short m624reduceRightxzaTVY8(short[] reduceRight, p operation) {
        E.f(reduceRight, "$this$reduceRight");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRight);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduceRight[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            sM1306constructorimpl = ((N) operation.invoke(N.a(N.m1306constructorimpl(reduceRight[i5])), N.a(sM1306constructorimpl))).f9128a;
        }
        return sM1306constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-D40WMg8, reason: not valid java name */
    private static final int m625reduceRightIndexedD40WMg8(int[] reduceRightIndexed, q operation) {
        E.f(reduceRightIndexed, "$this$reduceRightIndexed");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduceRightIndexed[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            iM1188constructorimpl = ((G) operation.invoke(Integer.valueOf(i5), G.a(G.m1188constructorimpl(reduceRightIndexed[i5])), G.a(iM1188constructorimpl))).f9124a;
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m626reduceRightIndexedEOyYB1Y(byte[] reduceRightIndexed, q operation) {
        E.f(reduceRightIndexed, "$this$reduceRightIndexed");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduceRightIndexed[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            bM1131constructorimpl = ((D) operation.invoke(Integer.valueOf(i5), D.a(D.m1131constructorimpl(reduceRightIndexed[i5])), D.a(bM1131constructorimpl))).f9122a;
        }
        return bM1131constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m627reduceRightIndexedaLgx1Fo(short[] reduceRightIndexed, q operation) {
        E.f(reduceRightIndexed, "$this$reduceRightIndexed");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduceRightIndexed[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            sM1306constructorimpl = ((N) operation.invoke(Integer.valueOf(i5), N.a(N.m1306constructorimpl(reduceRightIndexed[i5])), N.a(sM1306constructorimpl))).f9128a;
        }
        return sM1306constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRightIndexed-z1zDJgo, reason: not valid java name */
    private static final long m628reduceRightIndexedz1zDJgo(long[] reduceRightIndexed, q operation) {
        E.f(reduceRightIndexed, "$this$reduceRightIndexed");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexed);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduceRightIndexed[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            jM1247constructorimpl = ((J) operation.invoke(Integer.valueOf(i5), J.a(J.m1247constructorimpl(reduceRightIndexed[i5])), J.a(jM1247constructorimpl))).f9126a;
        }
        return jM1247constructorimpl;
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final G m629reduceRightIndexedOrNullD40WMg8(int[] reduceRightIndexedOrNull, q operation) {
        E.f(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduceRightIndexedOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            iM1188constructorimpl = ((G) operation.invoke(Integer.valueOf(i5), G.a(G.m1188constructorimpl(reduceRightIndexedOrNull[i5])), G.a(iM1188constructorimpl))).f9124a;
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final D m630reduceRightIndexedOrNullEOyYB1Y(byte[] reduceRightIndexedOrNull, q operation) {
        E.f(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduceRightIndexedOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            bM1131constructorimpl = ((D) operation.invoke(Integer.valueOf(i5), D.a(D.m1131constructorimpl(reduceRightIndexedOrNull[i5])), D.a(bM1131constructorimpl))).f9122a;
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final N m631reduceRightIndexedOrNullaLgx1Fo(short[] reduceRightIndexedOrNull, q operation) {
        E.f(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduceRightIndexedOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            sM1306constructorimpl = ((N) operation.invoke(Integer.valueOf(i5), N.a(N.m1306constructorimpl(reduceRightIndexedOrNull[i5])), N.a(sM1306constructorimpl))).f9128a;
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRightIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final J m632reduceRightIndexedOrNullz1zDJgo(long[] reduceRightIndexedOrNull, q operation) {
        E.f(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightIndexedOrNull);
        if (lastIndex < 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduceRightIndexedOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            jM1247constructorimpl = ((J) operation.invoke(Integer.valueOf(i5), J.a(J.m1247constructorimpl(reduceRightIndexedOrNull[i5])), J.a(jM1247constructorimpl))).f9126a;
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-ELGow60, reason: not valid java name */
    private static final D m633reduceRightOrNullELGow60(byte[] reduceRightOrNull, p operation) {
        E.f(reduceRightOrNull, "$this$reduceRightOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(reduceRightOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            bM1131constructorimpl = ((D) operation.invoke(D.a(D.m1131constructorimpl(reduceRightOrNull[i5])), D.a(bM1131constructorimpl))).f9122a;
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-WyvcNBI, reason: not valid java name */
    private static final G m634reduceRightOrNullWyvcNBI(int[] reduceRightOrNull, p operation) {
        E.f(reduceRightOrNull, "$this$reduceRightOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(reduceRightOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            iM1188constructorimpl = ((G) operation.invoke(G.a(G.m1188constructorimpl(reduceRightOrNull[i5])), G.a(iM1188constructorimpl))).f9124a;
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-s8dVfGU, reason: not valid java name */
    private static final J m635reduceRightOrNulls8dVfGU(long[] reduceRightOrNull, p operation) {
        E.f(reduceRightOrNull, "$this$reduceRightOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(reduceRightOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            jM1247constructorimpl = ((J) operation.invoke(J.a(J.m1247constructorimpl(reduceRightOrNull[i5])), J.a(jM1247constructorimpl))).f9126a;
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: reduceRightOrNull-xzaTVY8, reason: not valid java name */
    private static final N m636reduceRightOrNullxzaTVY8(short[] reduceRightOrNull, p operation) {
        E.f(reduceRightOrNull, "$this$reduceRightOrNull");
        E.f(operation, "operation");
        int lastIndex = C.getLastIndex(reduceRightOrNull);
        if (lastIndex < 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(reduceRightOrNull[lastIndex]);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            sM1306constructorimpl = ((N) operation.invoke(N.a(N.m1306constructorimpl(reduceRightOrNull[i5])), N.a(sM1306constructorimpl))).f9128a;
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: reverse--ajY-9A, reason: not valid java name */
    private static final void m637reverseajY9A(int[] reverse) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse);
    }

    /* JADX INFO: renamed from: reverse--nroSd4, reason: not valid java name */
    private static final void m638reversenroSd4(long[] reverse, int i5, int i6) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse, i5, i6);
    }

    /* JADX INFO: renamed from: reverse-4UcCI2c, reason: not valid java name */
    private static final void m639reverse4UcCI2c(byte[] reverse, int i5, int i6) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse, i5, i6);
    }

    /* JADX INFO: renamed from: reverse-Aa5vz7o, reason: not valid java name */
    private static final void m640reverseAa5vz7o(short[] reverse, int i5, int i6) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse, i5, i6);
    }

    /* JADX INFO: renamed from: reverse-GBYM_sE, reason: not valid java name */
    private static final void m641reverseGBYM_sE(byte[] reverse) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse);
    }

    /* JADX INFO: renamed from: reverse-QwZRm1k, reason: not valid java name */
    private static final void m642reverseQwZRm1k(long[] reverse) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse);
    }

    /* JADX INFO: renamed from: reverse-oBK06Vg, reason: not valid java name */
    private static final void m643reverseoBK06Vg(int[] reverse, int i5, int i6) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse, i5, i6);
    }

    /* JADX INFO: renamed from: reverse-rL5Bavg, reason: not valid java name */
    private static final void m644reverserL5Bavg(short[] reverse) {
        E.f(reverse, "$this$reverse");
        C.reverse(reverse);
    }

    /* JADX INFO: renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<G> m645reversedajY9A(int[] reversed) {
        E.f(reversed, "$this$reversed");
        if (reversed.length == 0) {
            return I.emptyList();
        }
        List<G> mutableList = T.toMutableList((Collection) H.b(reversed));
        Q.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<D> m646reversedGBYM_sE(byte[] reversed) {
        E.f(reversed, "$this$reversed");
        if (reversed.length == 0) {
            return I.emptyList();
        }
        List<D> mutableList = T.toMutableList((Collection) p147z3.E.b(reversed));
        Q.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<J> m647reversedQwZRm1k(long[] reversed) {
        E.f(reversed, "$this$reversed");
        if (reversed.length == 0) {
            return I.emptyList();
        }
        List<J> mutableList = T.toMutableList((Collection) K.b(reversed));
        Q.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<N> m648reversedrL5Bavg(short[] reversed) {
        E.f(reversed, "$this$reversed");
        if (reversed.length == 0) {
            return I.emptyList();
        }
        List<N> mutableList = T.toMutableList((Collection) O.b(reversed));
        Q.reverse(mutableList);
        return mutableList;
    }

    /* JADX INFO: renamed from: reversedArray--ajY-9A, reason: not valid java name */
    private static final int[] m649reversedArrayajY9A(int[] reversedArray) {
        E.f(reversedArray, "$this$reversedArray");
        return H.m1238constructorimpl(C.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: reversedArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m650reversedArrayGBYM_sE(byte[] reversedArray) {
        E.f(reversedArray, "$this$reversedArray");
        return p147z3.E.m1179constructorimpl(C.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: reversedArray-QwZRm1k, reason: not valid java name */
    private static final long[] m651reversedArrayQwZRm1k(long[] reversedArray) {
        E.f(reversedArray, "$this$reversedArray");
        return K.m1297constructorimpl(C.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: reversedArray-rL5Bavg, reason: not valid java name */
    private static final short[] m652reversedArrayrL5Bavg(short[] reversedArray) {
        E.f(reversedArray, "$this$reversedArray");
        return O.m1354constructorimpl(C.reversedArray(reversedArray));
    }

    /* JADX INFO: renamed from: runningFold-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m653runningFoldA8wKCXQ(long[] runningFold, R r6, p operation) {
        E.f(runningFold, "$this$runningFold");
        E.f(operation, "operation");
        if (runningFold.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFold.length + 1);
        arrayList.add(r6);
        for (long j6 : runningFold) {
            r6 = (R) operation.invoke(r6, J.a(J.m1247constructorimpl(j6)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m654runningFoldyXmHNn8(byte[] runningFold, R r6, p operation) {
        E.f(runningFold, "$this$runningFold");
        E.f(operation, "operation");
        if (runningFold.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFold.length + 1);
        arrayList.add(r6);
        for (byte b : runningFold) {
            r6 = (R) operation.invoke(r6, D.a(D.m1131constructorimpl(b)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m655runningFoldzi1B2BA(int[] runningFold, R r6, p operation) {
        E.f(runningFold, "$this$runningFold");
        E.f(operation, "operation");
        if (runningFold.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFold.length + 1);
        arrayList.add(r6);
        for (int i5 : runningFold) {
            r6 = (R) operation.invoke(r6, G.a(G.m1188constructorimpl(i5)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFold-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m656runningFoldzww5nb8(short[] runningFold, R r6, p operation) {
        E.f(runningFold, "$this$runningFold");
        E.f(operation, "operation");
        if (runningFold.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFold.length + 1);
        arrayList.add(r6);
        for (short s6 : runningFold) {
            r6 = (R) operation.invoke(r6, N.a(N.m1306constructorimpl(s6)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m657runningFoldIndexed3iWJZGE(byte[] runningFoldIndexed, R r6, q operation) {
        E.f(runningFoldIndexed, "$this$runningFoldIndexed");
        E.f(operation, "operation");
        if (runningFoldIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFoldIndexed.length + 1);
        arrayList.add(r6);
        int length = runningFoldIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, D.a(D.m1131constructorimpl(runningFoldIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m658runningFoldIndexedbzxtMww(short[] runningFoldIndexed, R r6, q operation) {
        E.f(runningFoldIndexed, "$this$runningFoldIndexed");
        E.f(operation, "operation");
        if (runningFoldIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFoldIndexed.length + 1);
        arrayList.add(r6);
        int length = runningFoldIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, N.a(N.m1306constructorimpl(runningFoldIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m659runningFoldIndexedmwnnOCs(long[] runningFoldIndexed, R r6, q operation) {
        E.f(runningFoldIndexed, "$this$runningFoldIndexed");
        E.f(operation, "operation");
        if (runningFoldIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFoldIndexed.length + 1);
        arrayList.add(r6);
        int length = runningFoldIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, J.a(J.m1247constructorimpl(runningFoldIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningFoldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m660runningFoldIndexedyVwIW0Q(int[] runningFoldIndexed, R r6, q operation) {
        E.f(runningFoldIndexed, "$this$runningFoldIndexed");
        E.f(operation, "operation");
        if (runningFoldIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(runningFoldIndexed.length + 1);
        arrayList.add(r6);
        int length = runningFoldIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, G.a(G.m1188constructorimpl(runningFoldIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-ELGow60, reason: not valid java name */
    private static final List<D> m661runningReduceELGow60(byte[] runningReduce, p operation) {
        E.f(runningReduce, "$this$runningReduce");
        E.f(operation, "operation");
        if (runningReduce.length == 0) {
            return I.emptyList();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(runningReduce[0]);
        ArrayList arrayList = new ArrayList(runningReduce.length);
        arrayList.add(D.a(bM1131constructorimpl));
        int length = runningReduce.length;
        for (int i5 = 1; i5 < length; i5++) {
            bM1131constructorimpl = ((D) operation.invoke(D.a(bM1131constructorimpl), D.a(D.m1131constructorimpl(runningReduce[i5])))).f9122a;
            arrayList.add(D.a(bM1131constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-WyvcNBI, reason: not valid java name */
    private static final List<G> m662runningReduceWyvcNBI(int[] runningReduce, p operation) {
        E.f(runningReduce, "$this$runningReduce");
        E.f(operation, "operation");
        if (runningReduce.length == 0) {
            return I.emptyList();
        }
        int iM1188constructorimpl = G.m1188constructorimpl(runningReduce[0]);
        ArrayList arrayList = new ArrayList(runningReduce.length);
        arrayList.add(G.a(iM1188constructorimpl));
        int length = runningReduce.length;
        for (int i5 = 1; i5 < length; i5++) {
            iM1188constructorimpl = ((G) operation.invoke(G.a(iM1188constructorimpl), G.a(G.m1188constructorimpl(runningReduce[i5])))).f9124a;
            arrayList.add(G.a(iM1188constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-s8dVfGU, reason: not valid java name */
    private static final List<J> m663runningReduces8dVfGU(long[] runningReduce, p operation) {
        E.f(runningReduce, "$this$runningReduce");
        E.f(operation, "operation");
        if (runningReduce.length == 0) {
            return I.emptyList();
        }
        long jM1247constructorimpl = J.m1247constructorimpl(runningReduce[0]);
        ArrayList arrayList = new ArrayList(runningReduce.length);
        arrayList.add(J.a(jM1247constructorimpl));
        int length = runningReduce.length;
        for (int i5 = 1; i5 < length; i5++) {
            jM1247constructorimpl = ((J) operation.invoke(J.a(jM1247constructorimpl), J.a(J.m1247constructorimpl(runningReduce[i5])))).f9126a;
            arrayList.add(J.a(jM1247constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduce-xzaTVY8, reason: not valid java name */
    private static final List<N> m664runningReducexzaTVY8(short[] runningReduce, p operation) {
        E.f(runningReduce, "$this$runningReduce");
        E.f(operation, "operation");
        if (runningReduce.length == 0) {
            return I.emptyList();
        }
        short sM1306constructorimpl = N.m1306constructorimpl(runningReduce[0]);
        ArrayList arrayList = new ArrayList(runningReduce.length);
        arrayList.add(N.a(sM1306constructorimpl));
        int length = runningReduce.length;
        for (int i5 = 1; i5 < length; i5++) {
            sM1306constructorimpl = ((N) operation.invoke(N.a(sM1306constructorimpl), N.a(N.m1306constructorimpl(runningReduce[i5])))).f9128a;
            arrayList.add(N.a(sM1306constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-D40WMg8, reason: not valid java name */
    private static final List<G> m665runningReduceIndexedD40WMg8(int[] runningReduceIndexed, q operation) {
        E.f(runningReduceIndexed, "$this$runningReduceIndexed");
        E.f(operation, "operation");
        if (runningReduceIndexed.length == 0) {
            return I.emptyList();
        }
        int iM1188constructorimpl = G.m1188constructorimpl(runningReduceIndexed[0]);
        ArrayList arrayList = new ArrayList(runningReduceIndexed.length);
        arrayList.add(G.a(iM1188constructorimpl));
        int length = runningReduceIndexed.length;
        for (int i5 = 1; i5 < length; i5++) {
            iM1188constructorimpl = ((G) operation.invoke(Integer.valueOf(i5), G.a(iM1188constructorimpl), G.a(G.m1188constructorimpl(runningReduceIndexed[i5])))).f9124a;
            arrayList.add(G.a(iM1188constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final List<D> m666runningReduceIndexedEOyYB1Y(byte[] runningReduceIndexed, q operation) {
        E.f(runningReduceIndexed, "$this$runningReduceIndexed");
        E.f(operation, "operation");
        if (runningReduceIndexed.length == 0) {
            return I.emptyList();
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(runningReduceIndexed[0]);
        ArrayList arrayList = new ArrayList(runningReduceIndexed.length);
        arrayList.add(D.a(bM1131constructorimpl));
        int length = runningReduceIndexed.length;
        for (int i5 = 1; i5 < length; i5++) {
            bM1131constructorimpl = ((D) operation.invoke(Integer.valueOf(i5), D.a(bM1131constructorimpl), D.a(D.m1131constructorimpl(runningReduceIndexed[i5])))).f9122a;
            arrayList.add(D.a(bM1131constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final List<N> m667runningReduceIndexedaLgx1Fo(short[] runningReduceIndexed, q operation) {
        E.f(runningReduceIndexed, "$this$runningReduceIndexed");
        E.f(operation, "operation");
        if (runningReduceIndexed.length == 0) {
            return I.emptyList();
        }
        short sM1306constructorimpl = N.m1306constructorimpl(runningReduceIndexed[0]);
        ArrayList arrayList = new ArrayList(runningReduceIndexed.length);
        arrayList.add(N.a(sM1306constructorimpl));
        int length = runningReduceIndexed.length;
        for (int i5 = 1; i5 < length; i5++) {
            sM1306constructorimpl = ((N) operation.invoke(Integer.valueOf(i5), N.a(sM1306constructorimpl), N.a(N.m1306constructorimpl(runningReduceIndexed[i5])))).f9128a;
            arrayList.add(N.a(sM1306constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: runningReduceIndexed-z1zDJgo, reason: not valid java name */
    private static final List<J> m668runningReduceIndexedz1zDJgo(long[] runningReduceIndexed, q operation) {
        E.f(runningReduceIndexed, "$this$runningReduceIndexed");
        E.f(operation, "operation");
        if (runningReduceIndexed.length == 0) {
            return I.emptyList();
        }
        long jM1247constructorimpl = J.m1247constructorimpl(runningReduceIndexed[0]);
        ArrayList arrayList = new ArrayList(runningReduceIndexed.length);
        arrayList.add(J.a(jM1247constructorimpl));
        int length = runningReduceIndexed.length;
        for (int i5 = 1; i5 < length; i5++) {
            jM1247constructorimpl = ((J) operation.invoke(Integer.valueOf(i5), J.a(jM1247constructorimpl), J.a(J.m1247constructorimpl(runningReduceIndexed[i5])))).f9126a;
            arrayList.add(J.a(jM1247constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m669scanA8wKCXQ(long[] scan, R r6, p operation) {
        E.f(scan, "$this$scan");
        E.f(operation, "operation");
        if (scan.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scan.length + 1);
        arrayList.add(r6);
        for (long j6 : scan) {
            r6 = (R) operation.invoke(r6, J.a(J.m1247constructorimpl(j6)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m670scanyXmHNn8(byte[] scan, R r6, p operation) {
        E.f(scan, "$this$scan");
        E.f(operation, "operation");
        if (scan.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scan.length + 1);
        arrayList.add(r6);
        for (byte b : scan) {
            r6 = (R) operation.invoke(r6, D.a(D.m1131constructorimpl(b)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m671scanzi1B2BA(int[] scan, R r6, p operation) {
        E.f(scan, "$this$scan");
        E.f(operation, "operation");
        if (scan.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scan.length + 1);
        arrayList.add(r6);
        for (int i5 : scan) {
            r6 = (R) operation.invoke(r6, G.a(G.m1188constructorimpl(i5)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scan-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m672scanzww5nb8(short[] scan, R r6, p operation) {
        E.f(scan, "$this$scan");
        E.f(operation, "operation");
        if (scan.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scan.length + 1);
        arrayList.add(r6);
        for (short s6 : scan) {
            r6 = (R) operation.invoke(r6, N.a(N.m1306constructorimpl(s6)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m673scanIndexed3iWJZGE(byte[] scanIndexed, R r6, q operation) {
        E.f(scanIndexed, "$this$scanIndexed");
        E.f(operation, "operation");
        if (scanIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scanIndexed.length + 1);
        arrayList.add(r6);
        int length = scanIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, D.a(D.m1131constructorimpl(scanIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m674scanIndexedbzxtMww(short[] scanIndexed, R r6, q operation) {
        E.f(scanIndexed, "$this$scanIndexed");
        E.f(operation, "operation");
        if (scanIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scanIndexed.length + 1);
        arrayList.add(r6);
        int length = scanIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, N.a(N.m1306constructorimpl(scanIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m675scanIndexedmwnnOCs(long[] scanIndexed, R r6, q operation) {
        E.f(scanIndexed, "$this$scanIndexed");
        E.f(operation, "operation");
        if (scanIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scanIndexed.length + 1);
        arrayList.add(r6);
        int length = scanIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, J.a(J.m1247constructorimpl(scanIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: scanIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m676scanIndexedyVwIW0Q(int[] scanIndexed, R r6, q operation) {
        E.f(scanIndexed, "$this$scanIndexed");
        E.f(operation, "operation");
        if (scanIndexed.length == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(scanIndexed.length + 1);
        arrayList.add(r6);
        int length = scanIndexed.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, G.a(G.m1188constructorimpl(scanIndexed[i5])));
            arrayList.add(r6);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m677shuffleajY9A(int[] shuffle) {
        E.f(shuffle, "$this$shuffle");
        m678shuffle2D5oskM(shuffle, f.Default);
    }

    /* JADX INFO: renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m678shuffle2D5oskM(int[] shuffle, f random) {
        E.f(shuffle, "$this$shuffle");
        E.f(random, "random");
        for (int lastIndex = C.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            int iM1188constructorimpl = G.m1188constructorimpl(shuffle[lastIndex]);
            shuffle[lastIndex] = G.m1188constructorimpl(shuffle[iD]);
            shuffle[iD] = iM1188constructorimpl;
        }
    }

    /* JADX INFO: renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m679shuffleGBYM_sE(byte[] shuffle) {
        E.f(shuffle, "$this$shuffle");
        m682shuffleoSF2wD8(shuffle, f.Default);
    }

    /* JADX INFO: renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m680shuffleJzugnMA(long[] shuffle, f random) {
        E.f(shuffle, "$this$shuffle");
        E.f(random, "random");
        for (int lastIndex = C.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            long jM1247constructorimpl = J.m1247constructorimpl(shuffle[lastIndex]);
            shuffle[lastIndex] = J.m1247constructorimpl(shuffle[iD]);
            shuffle[iD] = jM1247constructorimpl;
        }
    }

    /* JADX INFO: renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m681shuffleQwZRm1k(long[] shuffle) {
        E.f(shuffle, "$this$shuffle");
        m680shuffleJzugnMA(shuffle, f.Default);
    }

    /* JADX INFO: renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m682shuffleoSF2wD8(byte[] shuffle, f random) {
        E.f(shuffle, "$this$shuffle");
        E.f(random, "random");
        for (int lastIndex = C.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            byte bM1131constructorimpl = D.m1131constructorimpl(shuffle[lastIndex]);
            shuffle[lastIndex] = D.m1131constructorimpl(shuffle[iD]);
            shuffle[iD] = bM1131constructorimpl;
        }
    }

    /* JADX INFO: renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m683shufflerL5Bavg(short[] shuffle) {
        E.f(shuffle, "$this$shuffle");
        m684shuffles5X_as8(shuffle, f.Default);
    }

    /* JADX INFO: renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m684shuffles5X_as8(short[] shuffle, f random) {
        E.f(shuffle, "$this$shuffle");
        E.f(random, "random");
        for (int lastIndex = C.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            short sM1306constructorimpl = N.m1306constructorimpl(shuffle[lastIndex]);
            shuffle[lastIndex] = N.m1306constructorimpl(shuffle[iD]);
            shuffle[iD] = sM1306constructorimpl;
        }
    }

    /* JADX INFO: renamed from: single--ajY-9A, reason: not valid java name */
    private static final int m685singleajY9A(int[] single) {
        E.f(single, "$this$single");
        return G.m1188constructorimpl(C.single(single));
    }

    /* JADX INFO: renamed from: single-GBYM_sE, reason: not valid java name */
    private static final byte m686singleGBYM_sE(byte[] single) {
        E.f(single, "$this$single");
        return D.m1131constructorimpl(C.single(single));
    }

    /* JADX INFO: renamed from: single-JOV_ifY, reason: not valid java name */
    private static final byte m687singleJOV_ifY(byte[] single, l predicate) {
        E.f(single, "$this$single");
        E.f(predicate, "predicate");
        D dA = null;
        boolean z6 = false;
        for (byte b : single) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                if (z6) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                dA = D.a(bM1131constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return dA.f9122a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: single-MShoTSo, reason: not valid java name */
    private static final long m688singleMShoTSo(long[] single, l predicate) {
        E.f(single, "$this$single");
        E.f(predicate, "predicate");
        J jA = null;
        boolean z6 = false;
        for (long j6 : single) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                if (z6) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                jA = J.a(jM1247constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return jA.f9126a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: single-QwZRm1k, reason: not valid java name */
    private static final long m689singleQwZRm1k(long[] single) {
        E.f(single, "$this$single");
        return J.m1247constructorimpl(C.single(single));
    }

    /* JADX INFO: renamed from: single-jgv0xPQ, reason: not valid java name */
    private static final int m690singlejgv0xPQ(int[] single, l predicate) {
        E.f(single, "$this$single");
        E.f(predicate, "predicate");
        G gA = null;
        boolean z6 = false;
        for (int i5 : single) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                if (z6) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                gA = G.a(iM1188constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return gA.f9124a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: single-rL5Bavg, reason: not valid java name */
    private static final short m691singlerL5Bavg(short[] single) {
        E.f(single, "$this$single");
        return N.m1306constructorimpl(C.single(single));
    }

    /* JADX INFO: renamed from: single-xTcfx_M, reason: not valid java name */
    private static final short m692singlexTcfx_M(short[] single, l predicate) {
        E.f(single, "$this$single");
        E.f(predicate, "predicate");
        N nA = null;
        boolean z6 = false;
        for (short s6 : single) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                if (z6) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                nA = N.a(sM1306constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return nA.f9128a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final G m693singleOrNullajY9A(int[] singleOrNull) {
        E.f(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length == 1) {
            return G.a(G.m1188constructorimpl(singleOrNull[0]));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final D m694singleOrNullGBYM_sE(byte[] singleOrNull) {
        E.f(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length == 1) {
            return D.a(D.m1131constructorimpl(singleOrNull[0]));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-JOV_ifY, reason: not valid java name */
    private static final D m695singleOrNullJOV_ifY(byte[] singleOrNull, l predicate) {
        E.f(singleOrNull, "$this$singleOrNull");
        E.f(predicate, "predicate");
        D dA = null;
        boolean z6 = false;
        for (byte b : singleOrNull) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                if (z6) {
                    return null;
                }
                dA = D.a(bM1131constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return dA;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-MShoTSo, reason: not valid java name */
    private static final J m696singleOrNullMShoTSo(long[] singleOrNull, l predicate) {
        E.f(singleOrNull, "$this$singleOrNull");
        E.f(predicate, "predicate");
        J jA = null;
        boolean z6 = false;
        for (long j6 : singleOrNull) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                if (z6) {
                    return null;
                }
                jA = J.a(jM1247constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return jA;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final J m697singleOrNullQwZRm1k(long[] singleOrNull) {
        E.f(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length == 1) {
            return J.a(J.m1247constructorimpl(singleOrNull[0]));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-jgv0xPQ, reason: not valid java name */
    private static final G m698singleOrNulljgv0xPQ(int[] singleOrNull, l predicate) {
        E.f(singleOrNull, "$this$singleOrNull");
        E.f(predicate, "predicate");
        G gA = null;
        boolean z6 = false;
        for (int i5 : singleOrNull) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                if (z6) {
                    return null;
                }
                gA = G.a(iM1188constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return gA;
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final N m699singleOrNullrL5Bavg(short[] singleOrNull) {
        E.f(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length == 1) {
            return N.a(N.m1306constructorimpl(singleOrNull[0]));
        }
        return null;
    }

    /* JADX INFO: renamed from: singleOrNull-xTcfx_M, reason: not valid java name */
    private static final N m700singleOrNullxTcfx_M(short[] singleOrNull, l predicate) {
        E.f(singleOrNull, "$this$singleOrNull");
        E.f(predicate, "predicate");
        N nA = null;
        boolean z6 = false;
        for (short s6 : singleOrNull) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                if (z6) {
                    return null;
                }
                nA = N.a(sM1306constructorimpl);
                z6 = true;
            }
        }
        if (z6) {
            return nA;
        }
        return null;
    }

    /* JADX INFO: renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<J> m701sliceF7u83W8(long[] slice, Iterable<Integer> indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        int iCollectionSizeOrDefault = A3.J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(J.a(J.m1247constructorimpl(slice[it.next().intValue()])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<G> m702sliceHwE9HBo(int[] slice, Iterable<Integer> indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        int iCollectionSizeOrDefault = A3.J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(G.a(G.m1188constructorimpl(slice[it.next().intValue()])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<N> m703sliceJGPC0M(short[] slice, Iterable<Integer> indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        int iCollectionSizeOrDefault = A3.J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(N.a(N.m1306constructorimpl(slice[it.next().intValue()])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<D> m704sliceJQknh5Q(byte[] slice, Iterable<Integer> indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        int iCollectionSizeOrDefault = A3.J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(D.a(D.m1131constructorimpl(slice[it.next().intValue()])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<N> m705sliceQ6IL4kU(short[] slice, U3.q indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : a.m136asListrL5Bavg(O.m1354constructorimpl(AbstractC0151t.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<J> m706sliceZRhS8yI(long[] slice, U3.q indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : a.m135asListQwZRm1k(K.m1297constructorimpl(AbstractC0151t.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<D> m707slicec0bezYM(byte[] slice, U3.q indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : a.m134asListGBYM_sE(p147z3.E.m1179constructorimpl(AbstractC0151t.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<G> m708slicetAntMlw(int[] slice, U3.q indices) {
        E.f(slice, "$this$slice");
        E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : a.m133asListajY9A(H.m1238constructorimpl(AbstractC0151t.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    /* JADX INFO: renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m709sliceArrayCFIt9YE(int[] sliceArray, Collection<Integer> indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return H.m1238constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m710sliceArrayQ6IL4kU(short[] sliceArray, U3.q indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return O.m1354constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m711sliceArrayZRhS8yI(long[] sliceArray, U3.q indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return K.m1297constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m712sliceArrayc0bezYM(byte[] sliceArray, U3.q indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return p147z3.E.m1179constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m713sliceArraykzHmqpY(long[] sliceArray, Collection<Integer> indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return K.m1297constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m714sliceArrayojwP5H8(short[] sliceArray, Collection<Integer> indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return O.m1354constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m715sliceArraytAntMlw(int[] sliceArray, U3.q indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return H.m1238constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m716sliceArrayxo_DsdI(byte[] sliceArray, Collection<Integer> indices) {
        E.f(sliceArray, "$this$sliceArray");
        E.f(indices, "indices");
        return p147z3.E.m1179constructorimpl(C.sliceArray(sliceArray, indices));
    }

    /* JADX INFO: renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m717sortajY9A(int[] sort) {
        E.f(sort, "$this$sort");
        if (sort.length > 1) {
            C0.m85sortArrayoBK06Vg(sort, 0, sort.length);
        }
    }

    /* JADX INFO: renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m718sortnroSd4(long[] sort, int i5, int i6) {
        E.f(sort, "$this$sort");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = sort.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        if (i5 < i6 - 1) {
            C0.m82sortArraynroSd4(sort, i5, i6);
        }
    }

    /* JADX INFO: renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m719sort4UcCI2c(byte[] sort, int i5, int i6) {
        E.f(sort, "$this$sort");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = sort.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        if (i5 < i6 - 1) {
            C0.m83sortArray4UcCI2c(sort, i5, i6);
        }
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m720sortAa5vz7o(short[] sort, int i5, int i6) {
        E.f(sort, "$this$sort");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = sort.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        if (i5 < i6 - 1) {
            C0.m84sortArrayAa5vz7o(sort, i5, i6);
        }
    }

    /* JADX INFO: renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m721sortGBYM_sE(byte[] sort) {
        E.f(sort, "$this$sort");
        if (sort.length > 1) {
            C0.m83sortArray4UcCI2c(sort, 0, sort.length);
        }
    }

    /* JADX INFO: renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m722sortQwZRm1k(long[] sort) {
        E.f(sort, "$this$sort");
        if (sort.length > 1) {
            C0.m82sortArraynroSd4(sort, 0, sort.length);
        }
    }

    /* JADX INFO: renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m723sortoBK06Vg(int[] sort, int i5, int i6) {
        E.f(sort, "$this$sort");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = sort.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        if (i5 < i6 - 1) {
            C0.m85sortArrayoBK06Vg(sort, i5, i6);
        }
    }

    /* JADX INFO: renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m724sortrL5Bavg(short[] sort) {
        E.f(sort, "$this$sort");
        if (sort.length > 1) {
            C0.m84sortArrayAa5vz7o(sort, 0, sort.length);
        }
    }

    /* JADX INFO: renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m725sortDescendingajY9A(int[] sortDescending) {
        E.f(sortDescending, "$this$sortDescending");
        if (sortDescending.length > 1) {
            m717sortajY9A(sortDescending);
            C.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m726sortDescendingnroSd4(long[] sortDescending, int i5, int i6) {
        E.f(sortDescending, "$this$sortDescending");
        m718sortnroSd4(sortDescending, i5, i6);
        C.reverse(sortDescending, i5, i6);
    }

    /* JADX INFO: renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m727sortDescending4UcCI2c(byte[] sortDescending, int i5, int i6) {
        E.f(sortDescending, "$this$sortDescending");
        m719sort4UcCI2c(sortDescending, i5, i6);
        C.reverse(sortDescending, i5, i6);
    }

    /* JADX INFO: renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m728sortDescendingAa5vz7o(short[] sortDescending, int i5, int i6) {
        E.f(sortDescending, "$this$sortDescending");
        m720sortAa5vz7o(sortDescending, i5, i6);
        C.reverse(sortDescending, i5, i6);
    }

    /* JADX INFO: renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m729sortDescendingGBYM_sE(byte[] sortDescending) {
        E.f(sortDescending, "$this$sortDescending");
        if (sortDescending.length > 1) {
            m721sortGBYM_sE(sortDescending);
            C.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m730sortDescendingQwZRm1k(long[] sortDescending) {
        E.f(sortDescending, "$this$sortDescending");
        if (sortDescending.length > 1) {
            m722sortQwZRm1k(sortDescending);
            C.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m731sortDescendingoBK06Vg(int[] sortDescending, int i5, int i6) {
        E.f(sortDescending, "$this$sortDescending");
        m723sortoBK06Vg(sortDescending, i5, i6);
        C.reverse(sortDescending, i5, i6);
    }

    /* JADX INFO: renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m732sortDescendingrL5Bavg(short[] sortDescending) {
        E.f(sortDescending, "$this$sortDescending");
        if (sortDescending.length > 1) {
            m724sortrL5Bavg(sortDescending);
            C.reverse(sortDescending);
        }
    }

    /* JADX INFO: renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<G> m733sortedajY9A(int[] sorted) {
        E.f(sorted, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        E.e(iArrCopyOf, "copyOf(...)");
        int[] iArrM1238constructorimpl = H.m1238constructorimpl(iArrCopyOf);
        m717sortajY9A(iArrM1238constructorimpl);
        return a.m133asListajY9A(iArrM1238constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<D> m734sortedGBYM_sE(byte[] sorted) {
        E.f(sorted, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        E.e(bArrCopyOf, "copyOf(...)");
        byte[] bArrM1179constructorimpl = p147z3.E.m1179constructorimpl(bArrCopyOf);
        m721sortGBYM_sE(bArrM1179constructorimpl);
        return a.m134asListGBYM_sE(bArrM1179constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<J> m735sortedQwZRm1k(long[] sorted) {
        E.f(sorted, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        E.e(jArrCopyOf, "copyOf(...)");
        long[] jArrM1297constructorimpl = K.m1297constructorimpl(jArrCopyOf);
        m722sortQwZRm1k(jArrM1297constructorimpl);
        return a.m135asListQwZRm1k(jArrM1297constructorimpl);
    }

    /* JADX INFO: renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<N> m736sortedrL5Bavg(short[] sorted) {
        E.f(sorted, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        E.e(sArrCopyOf, "copyOf(...)");
        short[] sArrM1354constructorimpl = O.m1354constructorimpl(sArrCopyOf);
        m724sortrL5Bavg(sArrM1354constructorimpl);
        return a.m136asListrL5Bavg(sArrM1354constructorimpl);
    }

    /* JADX INFO: renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m737sortedArrayajY9A(int[] sortedArray) {
        E.f(sortedArray, "$this$sortedArray");
        if (sortedArray.length == 0) {
            return sortedArray;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        E.e(iArrCopyOf, "copyOf(...)");
        int[] iArrM1238constructorimpl = H.m1238constructorimpl(iArrCopyOf);
        m717sortajY9A(iArrM1238constructorimpl);
        return iArrM1238constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m738sortedArrayGBYM_sE(byte[] sortedArray) {
        E.f(sortedArray, "$this$sortedArray");
        if (sortedArray.length == 0) {
            return sortedArray;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        E.e(bArrCopyOf, "copyOf(...)");
        byte[] bArrM1179constructorimpl = p147z3.E.m1179constructorimpl(bArrCopyOf);
        m721sortGBYM_sE(bArrM1179constructorimpl);
        return bArrM1179constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m739sortedArrayQwZRm1k(long[] sortedArray) {
        E.f(sortedArray, "$this$sortedArray");
        if (sortedArray.length == 0) {
            return sortedArray;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        E.e(jArrCopyOf, "copyOf(...)");
        long[] jArrM1297constructorimpl = K.m1297constructorimpl(jArrCopyOf);
        m722sortQwZRm1k(jArrM1297constructorimpl);
        return jArrM1297constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m740sortedArrayrL5Bavg(short[] sortedArray) {
        E.f(sortedArray, "$this$sortedArray");
        if (sortedArray.length == 0) {
            return sortedArray;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        E.e(sArrCopyOf, "copyOf(...)");
        short[] sArrM1354constructorimpl = O.m1354constructorimpl(sArrCopyOf);
        m724sortrL5Bavg(sArrM1354constructorimpl);
        return sArrM1354constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m741sortedArrayDescendingajY9A(int[] sortedArrayDescending) {
        E.f(sortedArrayDescending, "$this$sortedArrayDescending");
        if (sortedArrayDescending.length == 0) {
            return sortedArrayDescending;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        E.e(iArrCopyOf, "copyOf(...)");
        int[] iArrM1238constructorimpl = H.m1238constructorimpl(iArrCopyOf);
        m725sortDescendingajY9A(iArrM1238constructorimpl);
        return iArrM1238constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m742sortedArrayDescendingGBYM_sE(byte[] sortedArrayDescending) {
        E.f(sortedArrayDescending, "$this$sortedArrayDescending");
        if (sortedArrayDescending.length == 0) {
            return sortedArrayDescending;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        E.e(bArrCopyOf, "copyOf(...)");
        byte[] bArrM1179constructorimpl = p147z3.E.m1179constructorimpl(bArrCopyOf);
        m729sortDescendingGBYM_sE(bArrM1179constructorimpl);
        return bArrM1179constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m743sortedArrayDescendingQwZRm1k(long[] sortedArrayDescending) {
        E.f(sortedArrayDescending, "$this$sortedArrayDescending");
        if (sortedArrayDescending.length == 0) {
            return sortedArrayDescending;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        E.e(jArrCopyOf, "copyOf(...)");
        long[] jArrM1297constructorimpl = K.m1297constructorimpl(jArrCopyOf);
        m730sortDescendingQwZRm1k(jArrM1297constructorimpl);
        return jArrM1297constructorimpl;
    }

    /* JADX INFO: renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m744sortedArrayDescendingrL5Bavg(short[] sortedArrayDescending) {
        E.f(sortedArrayDescending, "$this$sortedArrayDescending");
        if (sortedArrayDescending.length == 0) {
            return sortedArrayDescending;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        E.e(sArrCopyOf, "copyOf(...)");
        short[] sArrM1354constructorimpl = O.m1354constructorimpl(sArrCopyOf);
        m732sortDescendingrL5Bavg(sArrM1354constructorimpl);
        return sArrM1354constructorimpl;
    }

    /* JADX INFO: renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<G> m745sortedDescendingajY9A(int[] sortedDescending) {
        E.f(sortedDescending, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        E.e(iArrCopyOf, "copyOf(...)");
        int[] iArrM1238constructorimpl = H.m1238constructorimpl(iArrCopyOf);
        m717sortajY9A(iArrM1238constructorimpl);
        return m645reversedajY9A(iArrM1238constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<D> m746sortedDescendingGBYM_sE(byte[] sortedDescending) {
        E.f(sortedDescending, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        E.e(bArrCopyOf, "copyOf(...)");
        byte[] bArrM1179constructorimpl = p147z3.E.m1179constructorimpl(bArrCopyOf);
        m721sortGBYM_sE(bArrM1179constructorimpl);
        return m646reversedGBYM_sE(bArrM1179constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<J> m747sortedDescendingQwZRm1k(long[] sortedDescending) {
        E.f(sortedDescending, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        E.e(jArrCopyOf, "copyOf(...)");
        long[] jArrM1297constructorimpl = K.m1297constructorimpl(jArrCopyOf);
        m722sortQwZRm1k(jArrM1297constructorimpl);
        return m647reversedQwZRm1k(jArrM1297constructorimpl);
    }

    /* JADX INFO: renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<N> m748sortedDescendingrL5Bavg(short[] sortedDescending) {
        E.f(sortedDescending, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        E.e(sArrCopyOf, "copyOf(...)");
        short[] sArrM1354constructorimpl = O.m1354constructorimpl(sArrCopyOf);
        m724sortrL5Bavg(sArrM1354constructorimpl);
        return m648reversedrL5Bavg(sArrM1354constructorimpl);
    }

    /* JADX INFO: renamed from: sum--ajY-9A, reason: not valid java name */
    private static final int m749sumajY9A(int[] sum) {
        E.f(sum, "$this$sum");
        return G.m1188constructorimpl(C.sum(sum));
    }

    /* JADX INFO: renamed from: sum-GBYM_sE, reason: not valid java name */
    private static final int m750sumGBYM_sE(byte[] sum) {
        E.f(sum, "$this$sum");
        int iM1188constructorimpl = G.m1188constructorimpl(0);
        for (byte b : sum) {
            iM1188constructorimpl = G.m1188constructorimpl(G.m1188constructorimpl(D.m1131constructorimpl(b) & UnsignedBytes.MAX_VALUE) + iM1188constructorimpl);
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: sum-QwZRm1k, reason: not valid java name */
    private static final long m751sumQwZRm1k(long[] sum) {
        E.f(sum, "$this$sum");
        return J.m1247constructorimpl(C.sum(sum));
    }

    /* JADX INFO: renamed from: sum-rL5Bavg, reason: not valid java name */
    private static final int m752sumrL5Bavg(short[] sum) {
        E.f(sum, "$this$sum");
        int iM1188constructorimpl = G.m1188constructorimpl(0);
        for (short s6 : sum) {
            iM1188constructorimpl = G.m1188constructorimpl(G.m1188constructorimpl(N.m1306constructorimpl(s6) & 65535) + iM1188constructorimpl);
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: sumBy-JOV_ifY, reason: not valid java name */
    private static final int m753sumByJOV_ifY(byte[] sumBy, l selector) {
        E.f(sumBy, "$this$sumBy");
        E.f(selector, "selector");
        int iM1188constructorimpl = 0;
        for (byte b : sumBy) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.d(b, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: sumBy-MShoTSo, reason: not valid java name */
    private static final int m754sumByMShoTSo(long[] sumBy, l selector) {
        E.f(sumBy, "$this$sumBy");
        E.f(selector, "selector");
        int iM1188constructorimpl = 0;
        for (long j6 : sumBy) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.g(j6, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: sumBy-jgv0xPQ, reason: not valid java name */
    private static final int m755sumByjgv0xPQ(int[] sumBy, l selector) {
        E.f(sumBy, "$this$sumBy");
        E.f(selector, "selector");
        int iM1188constructorimpl = 0;
        for (int i5 : sumBy) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.e(i5, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: sumBy-xTcfx_M, reason: not valid java name */
    private static final int m756sumByxTcfx_M(short[] sumBy, l selector) {
        E.f(sumBy, "$this$sumBy");
        E.f(selector, "selector");
        int iM1188constructorimpl = 0;
        for (short s6 : sumBy) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.i(s6, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: sumByDouble-JOV_ifY, reason: not valid java name */
    private static final double m757sumByDoubleJOV_ifY(byte[] sumByDouble, l selector) {
        E.f(sumByDouble, "$this$sumByDouble");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b : sumByDouble) {
            dDoubleValue += ((Number) AbstractC0157z.d(b, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: sumByDouble-MShoTSo, reason: not valid java name */
    private static final double m758sumByDoubleMShoTSo(long[] sumByDouble, l selector) {
        E.f(sumByDouble, "$this$sumByDouble");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j6 : sumByDouble) {
            dDoubleValue += ((Number) AbstractC0157z.g(j6, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: sumByDouble-jgv0xPQ, reason: not valid java name */
    private static final double m759sumByDoublejgv0xPQ(int[] sumByDouble, l selector) {
        E.f(sumByDouble, "$this$sumByDouble");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i5 : sumByDouble) {
            dDoubleValue += ((Number) AbstractC0157z.e(i5, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: sumByDouble-xTcfx_M, reason: not valid java name */
    private static final double m760sumByDoublexTcfx_M(short[] sumByDouble, l selector) {
        E.f(sumByDouble, "$this$sumByDouble");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s6 : sumByDouble) {
            dDoubleValue += ((Number) AbstractC0157z.i(s6, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(byte[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b : sumOf) {
            dDoubleValue += ((Number) AbstractC0157z.d(b, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(byte[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iIntValue = 0;
        for (byte b : sumOf) {
            iIntValue += ((Number) AbstractC0157z.d(b, selector)).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(byte[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jLongValue = 0;
        for (byte b : sumOf) {
            jLongValue += ((Number) AbstractC0157z.d(b, selector)).longValue();
        }
        return jLongValue;
    }

    public static final int sumOfUByte(D[] dArr) {
        E.f(dArr, "<this>");
        int iM1188constructorimpl = 0;
        for (D d : dArr) {
            iM1188constructorimpl = G.m1188constructorimpl(G.m1188constructorimpl(d.f9122a & UnsignedBytes.MAX_VALUE) + iM1188constructorimpl);
        }
        return iM1188constructorimpl;
    }

    private static final int sumOfUInt(int[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iM1188constructorimpl = G.m1188constructorimpl(0);
        for (int i5 : sumOf) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.e(i5, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(int[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jM1247constructorimpl = J.m1247constructorimpl(0L);
        for (int i5 : sumOf) {
            jM1247constructorimpl = J.m1247constructorimpl(jM1247constructorimpl + ((J) AbstractC0157z.e(i5, selector)).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final int sumOfUShort(N[] nArr) {
        E.f(nArr, "<this>");
        int iM1188constructorimpl = 0;
        for (N n6 : nArr) {
            iM1188constructorimpl = G.m1188constructorimpl(G.m1188constructorimpl(n6.f9128a & 65535) + iM1188constructorimpl);
        }
        return iM1188constructorimpl;
    }

    /* JADX INFO: renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<D> m761takePpDY95g(byte[] take, int i5) {
        E.f(take, "$this$take");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= take.length) {
            return T.toList(p147z3.E.b(take));
        }
        if (i5 == 1) {
            return A3.G.listOf(D.a(D.m1131constructorimpl(take[0])));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (byte b : take) {
            arrayList.add(D.a(D.m1131constructorimpl(b)));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<N> m762takenggk6HY(short[] take, int i5) {
        E.f(take, "$this$take");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= take.length) {
            return T.toList(O.b(take));
        }
        if (i5 == 1) {
            return A3.G.listOf(N.a(N.m1306constructorimpl(take[0])));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (short s6 : take) {
            arrayList.add(N.a(N.m1306constructorimpl(s6)));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<G> m763takeqFRl0hI(int[] take, int i5) {
        E.f(take, "$this$take");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= take.length) {
            return T.toList(H.b(take));
        }
        if (i5 == 1) {
            return A3.G.listOf(G.a(G.m1188constructorimpl(take[0])));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (int i7 : take) {
            arrayList.add(G.a(G.m1188constructorimpl(i7)));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<J> m764taker7IrZao(long[] take, int i5) {
        E.f(take, "$this$take");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= take.length) {
            return T.toList(K.b(take));
        }
        if (i5 == 1) {
            return A3.G.listOf(J.a(J.m1247constructorimpl(take[0])));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (long j6 : take) {
            arrayList.add(J.a(J.m1247constructorimpl(j6)));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<D> m765takeLastPpDY95g(byte[] takeLast, int i5) {
        E.f(takeLast, "$this$takeLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = takeLast.length;
        if (i5 >= length) {
            return T.toList(p147z3.E.b(takeLast));
        }
        if (i5 == 1) {
            return A3.G.listOf(D.a(D.m1131constructorimpl(takeLast[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(D.a(D.m1131constructorimpl(takeLast[i6])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<N> m766takeLastnggk6HY(short[] takeLast, int i5) {
        E.f(takeLast, "$this$takeLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = takeLast.length;
        if (i5 >= length) {
            return T.toList(O.b(takeLast));
        }
        if (i5 == 1) {
            return A3.G.listOf(N.a(N.m1306constructorimpl(takeLast[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(N.a(N.m1306constructorimpl(takeLast[i6])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<G> m767takeLastqFRl0hI(int[] takeLast, int i5) {
        E.f(takeLast, "$this$takeLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = takeLast.length;
        if (i5 >= length) {
            return T.toList(H.b(takeLast));
        }
        if (i5 == 1) {
            return A3.G.listOf(G.a(G.m1188constructorimpl(takeLast[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(G.a(G.m1188constructorimpl(takeLast[i6])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<J> m768takeLastr7IrZao(long[] takeLast, int i5) {
        E.f(takeLast, "$this$takeLast");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = takeLast.length;
        if (i5 >= length) {
            return T.toList(K.b(takeLast));
        }
        if (i5 == 1) {
            return A3.G.listOf(J.a(J.m1247constructorimpl(takeLast[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(J.a(J.m1247constructorimpl(takeLast[i6])));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<D> m769takeLastWhileJOV_ifY(byte[] takeLastWhile, l predicate) {
        E.f(takeLastWhile, "$this$takeLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.d(takeLastWhile[lastIndex], predicate)).booleanValue()) {
                return m245dropPpDY95g(takeLastWhile, lastIndex + 1);
            }
        }
        return T.toList(p147z3.E.b(takeLastWhile));
    }

    /* JADX INFO: renamed from: takeLastWhile-MShoTSo, reason: not valid java name */
    private static final List<J> m770takeLastWhileMShoTSo(long[] takeLastWhile, l predicate) {
        E.f(takeLastWhile, "$this$takeLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.g(takeLastWhile[lastIndex], predicate)).booleanValue()) {
                return m248dropr7IrZao(takeLastWhile, lastIndex + 1);
            }
        }
        return T.toList(K.b(takeLastWhile));
    }

    /* JADX INFO: renamed from: takeLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<G> m771takeLastWhilejgv0xPQ(int[] takeLastWhile, l predicate) {
        E.f(takeLastWhile, "$this$takeLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.e(takeLastWhile[lastIndex], predicate)).booleanValue()) {
                return m247dropqFRl0hI(takeLastWhile, lastIndex + 1);
            }
        }
        return T.toList(H.b(takeLastWhile));
    }

    /* JADX INFO: renamed from: takeLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<N> m772takeLastWhilexTcfx_M(short[] takeLastWhile, l predicate) {
        E.f(takeLastWhile, "$this$takeLastWhile");
        E.f(predicate, "predicate");
        for (int lastIndex = C.getLastIndex(takeLastWhile); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.i(takeLastWhile[lastIndex], predicate)).booleanValue()) {
                return m246dropnggk6HY(takeLastWhile, lastIndex + 1);
            }
        }
        return T.toList(O.b(takeLastWhile));
    }

    /* JADX INFO: renamed from: takeWhile-JOV_ifY, reason: not valid java name */
    private static final List<D> m773takeWhileJOV_ifY(byte[] takeWhile, l predicate) {
        E.f(takeWhile, "$this$takeWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : takeWhile) {
            byte bM1131constructorimpl = D.m1131constructorimpl(b);
            if (!((Boolean) predicate.invoke(D.a(bM1131constructorimpl))).booleanValue()) {
                break;
            }
            arrayList.add(D.a(bM1131constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-MShoTSo, reason: not valid java name */
    private static final List<J> m774takeWhileMShoTSo(long[] takeWhile, l predicate) {
        E.f(takeWhile, "$this$takeWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : takeWhile) {
            long jM1247constructorimpl = J.m1247constructorimpl(j6);
            if (!((Boolean) predicate.invoke(J.a(jM1247constructorimpl))).booleanValue()) {
                break;
            }
            arrayList.add(J.a(jM1247constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-jgv0xPQ, reason: not valid java name */
    private static final List<G> m775takeWhilejgv0xPQ(int[] takeWhile, l predicate) {
        E.f(takeWhile, "$this$takeWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i5 : takeWhile) {
            int iM1188constructorimpl = G.m1188constructorimpl(i5);
            if (!((Boolean) predicate.invoke(G.a(iM1188constructorimpl))).booleanValue()) {
                break;
            }
            arrayList.add(G.a(iM1188constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: takeWhile-xTcfx_M, reason: not valid java name */
    private static final List<N> m776takeWhilexTcfx_M(short[] takeWhile, l predicate) {
        E.f(takeWhile, "$this$takeWhile");
        E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s6 : takeWhile) {
            short sM1306constructorimpl = N.m1306constructorimpl(s6);
            if (!((Boolean) predicate.invoke(N.a(sM1306constructorimpl))).booleanValue()) {
                break;
            }
            arrayList.add(N.a(sM1306constructorimpl));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: toByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m777toByteArrayGBYM_sE(byte[] toByteArray) {
        E.f(toByteArray, "$this$toByteArray");
        byte[] bArrCopyOf = Arrays.copyOf(toByteArray, toByteArray.length);
        E.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    /* JADX INFO: renamed from: toIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m778toIntArrayajY9A(int[] toIntArray) {
        E.f(toIntArray, "$this$toIntArray");
        int[] iArrCopyOf = Arrays.copyOf(toIntArray, toIntArray.length);
        E.e(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    /* JADX INFO: renamed from: toLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m779toLongArrayQwZRm1k(long[] toLongArray) {
        E.f(toLongArray, "$this$toLongArray");
        long[] jArrCopyOf = Arrays.copyOf(toLongArray, toLongArray.length);
        E.e(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    /* JADX INFO: renamed from: toShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m780toShortArrayrL5Bavg(short[] toShortArray) {
        E.f(toShortArray, "$this$toShortArray");
        short[] sArrCopyOf = Arrays.copyOf(toShortArray, toShortArray.length);
        E.e(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    /* JADX INFO: renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final G[] m781toTypedArrayajY9A(int[] toTypedArray) {
        E.f(toTypedArray, "$this$toTypedArray");
        int length = toTypedArray.length;
        G[] gArr = new G[length];
        for (int i5 = 0; i5 < length; i5++) {
            gArr[i5] = G.a(G.m1188constructorimpl(toTypedArray[i5]));
        }
        return gArr;
    }

    /* JADX INFO: renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final D[] m782toTypedArrayGBYM_sE(byte[] toTypedArray) {
        E.f(toTypedArray, "$this$toTypedArray");
        int length = toTypedArray.length;
        D[] dArr = new D[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = D.a(D.m1131constructorimpl(toTypedArray[i5]));
        }
        return dArr;
    }

    /* JADX INFO: renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final J[] m783toTypedArrayQwZRm1k(long[] toTypedArray) {
        E.f(toTypedArray, "$this$toTypedArray");
        int length = toTypedArray.length;
        J[] jArr = new J[length];
        for (int i5 = 0; i5 < length; i5++) {
            jArr[i5] = J.a(J.m1247constructorimpl(toTypedArray[i5]));
        }
        return jArr;
    }

    /* JADX INFO: renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final N[] m784toTypedArrayrL5Bavg(short[] toTypedArray) {
        E.f(toTypedArray, "$this$toTypedArray");
        int length = toTypedArray.length;
        N[] nArr = new N[length];
        for (int i5 = 0; i5 < length; i5++) {
            nArr[i5] = N.a(N.m1306constructorimpl(toTypedArray[i5]));
        }
        return nArr;
    }

    public static final byte[] toUByteArray(D[] dArr) {
        E.f(dArr, "<this>");
        int length = dArr.length;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = dArr[i5].f9122a;
        }
        return p147z3.E.m1179constructorimpl(bArr);
    }

    public static final int[] toUIntArray(G[] gArr) {
        E.f(gArr, "<this>");
        int length = gArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = gArr[i5].f9124a;
        }
        return H.m1238constructorimpl(iArr);
    }

    public static final long[] toULongArray(J[] jArr) {
        E.f(jArr, "<this>");
        int length = jArr.length;
        long[] jArr2 = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            jArr2[i5] = jArr[i5].f9126a;
        }
        return K.m1297constructorimpl(jArr2);
    }

    public static final short[] toUShortArray(N[] nArr) {
        E.f(nArr, "<this>");
        int length = nArr.length;
        short[] sArr = new short[length];
        for (int i5 = 0; i5 < length; i5++) {
            sArr[i5] = nArr[i5].f9128a;
        }
        return O.m1354constructorimpl(sArr);
    }

    /* JADX INFO: renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<C0133b0> m785withIndexajY9A(int[] withIndex) {
        E.f(withIndex, "$this$withIndex");
        return new C0135c0(new C0156y(withIndex, 1));
    }

    /* JADX INFO: renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<C0133b0> m786withIndexGBYM_sE(byte[] withIndex) {
        E.f(withIndex, "$this$withIndex");
        return new C0135c0(new C0155x(withIndex, 1));
    }

    /* JADX INFO: renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<C0133b0> m787withIndexQwZRm1k(long[] withIndex) {
        E.f(withIndex, "$this$withIndex");
        return new C0135c0(new C0154w(withIndex, 1));
    }

    /* JADX INFO: renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<C0133b0> m788withIndexrL5Bavg(short[] withIndex) {
        E.f(withIndex, "$this$withIndex");
        return new C0135c0(new C0153v(withIndex, 1));
    }

    /* JADX INFO: renamed from: zip-7znnbtw, reason: not valid java name */
    private static final <R, V> List<V> m789zip7znnbtw(int[] zip, Iterable<? extends R> other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(G.a(G.m1188constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-8LME4QE, reason: not valid java name */
    private static final <R, V> List<V> m790zip8LME4QE(long[] zip, R[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(J.a(J.m1247constructorimpl(zip[i5])), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<C1938s> m791zipCE_24M(int[] zip, R[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            int iM1188constructorimpl = G.m1188constructorimpl(zip[i5]);
            arrayList.add(A.to(G.a(iM1188constructorimpl), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<C1938s> m792zipF7u83W8(long[] zip, Iterable<? extends R> other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(A.to(J.a(J.m1247constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<C1938s> m793zipHwE9HBo(int[] zip, Iterable<? extends R> other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(A.to(G.a(G.m1188constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JAKpvQM, reason: not valid java name */
    private static final <V> List<V> m794zipJAKpvQM(byte[] zip, byte[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(D.a(D.m1131constructorimpl(zip[i5])), D.a(D.m1131constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<C1938s> m795zipJGPC0M(short[] zip, Iterable<? extends R> other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(A.to(N.a(N.m1306constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<C1938s> m796zipJQknh5Q(byte[] zip, Iterable<? extends R> other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(A.to(D.a(D.m1131constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-L83TJbI, reason: not valid java name */
    private static final <V> List<V> m797zipL83TJbI(int[] zip, int[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(G.a(G.m1188constructorimpl(zip[i5])), G.a(G.m1188constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-LuipOMY, reason: not valid java name */
    private static final <R, V> List<V> m798zipLuipOMY(byte[] zip, R[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(D.a(D.m1131constructorimpl(zip[i5])), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-PabeH-Q, reason: not valid java name */
    private static final <V> List<V> m799zipPabeHQ(long[] zip, long[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(J.a(J.m1247constructorimpl(zip[i5])), J.a(J.m1247constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-TUPTUsU, reason: not valid java name */
    private static final <R, V> List<V> m800zipTUPTUsU(long[] zip, Iterable<? extends R> other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(J.a(J.m1247constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-UCnP4_w, reason: not valid java name */
    private static final <R, V> List<V> m801zipUCnP4_w(byte[] zip, Iterable<? extends R> other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(D.a(D.m1131constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ZjwqOic, reason: not valid java name */
    private static final <R, V> List<V> m802zipZjwqOic(int[] zip, R[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(G.a(G.m1188constructorimpl(zip[i5])), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<C1938s> m803zipctEhBpI(int[] zip, int[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(A.to(G.a(G.m1188constructorimpl(zip[i5])), G.a(G.m1188constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-ePBmRWY, reason: not valid java name */
    private static final <R, V> List<V> m804zipePBmRWY(short[] zip, R[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(N.a(N.m1306constructorimpl(zip[i5])), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<C1938s> m805zipf7H3mmw(long[] zip, R[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            long jM1247constructorimpl = J.m1247constructorimpl(zip[i5]);
            arrayList.add(A.to(J.a(jM1247constructorimpl), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-gVVukQo, reason: not valid java name */
    private static final <V> List<V> m806zipgVVukQo(short[] zip, short[] other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(N.a(N.m1306constructorimpl(zip[i5])), N.a(N.m1306constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-kBb4a-s, reason: not valid java name */
    private static final <R, V> List<V> m807zipkBb4as(short[] zip, Iterable<? extends R> other, p transform) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        E.f(transform, "transform");
        int length = zip.length;
        ArrayList arrayList = new ArrayList(Math.min(A3.J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(N.a(N.m1306constructorimpl(zip[i5])), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<C1938s> m808zipkdPth3s(byte[] zip, byte[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(A.to(D.a(D.m1131constructorimpl(zip[i5])), D.a(D.m1131constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<C1938s> m809zipmazbYpA(short[] zip, short[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(A.to(N.a(N.m1306constructorimpl(zip[i5])), N.a(N.m1306constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<C1938s> m810zipnl983wc(byte[] zip, R[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            byte bM1131constructorimpl = D.m1131constructorimpl(zip[i5]);
            arrayList.add(A.to(D.a(bM1131constructorimpl), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<C1938s> m811zipuaTIQ5s(short[] zip, R[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            short sM1306constructorimpl = N.m1306constructorimpl(zip[i5]);
            arrayList.add(A.to(N.a(sM1306constructorimpl), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<C1938s> m812zipus8wMrg(long[] zip, long[] other) {
        E.f(zip, "$this$zip");
        E.f(other, "other");
        int iMin = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(A.to(J.a(J.m1247constructorimpl(zip[i5])), J.a(J.m1247constructorimpl(other[i5]))));
        }
        return arrayList;
    }

    private static final byte[] toUByteArray(byte[] bArr) {
        E.f(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        E.e(bArrCopyOf, "copyOf(...)");
        return p147z3.E.m1179constructorimpl(bArrCopyOf);
    }

    private static final int[] toUIntArray(int[] iArr) {
        E.f(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        E.e(iArrCopyOf, "copyOf(...)");
        return H.m1238constructorimpl(iArrCopyOf);
    }

    private static final long[] toULongArray(long[] jArr) {
        E.f(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        E.e(jArrCopyOf, "copyOf(...)");
        return K.m1297constructorimpl(jArrCopyOf);
    }

    private static final short[] toUShortArray(short[] sArr) {
        E.f(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        E.e(sArrCopyOf, "copyOf(...)");
        return O.m1354constructorimpl(sArrCopyOf);
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final int m494maxOrThrowU(int[] max) {
        E.f(max, "$this$max");
        if (max.length != 0) {
            int iM1188constructorimpl = G.m1188constructorimpl(max[0]);
            int lastIndex = C.getLastIndex(max);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM1188constructorimpl2 = G.m1188constructorimpl(max[i5]);
                    if (Integer.compareUnsigned(iM1188constructorimpl, iM1188constructorimpl2) < 0) {
                        iM1188constructorimpl = iM1188constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return iM1188constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final int m502maxWithOrThrowU(int[] maxWith, Comparator<? super G> comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        if (maxWith.length != 0) {
            int iM1188constructorimpl = G.m1188constructorimpl(maxWith[0]);
            int lastIndex = C.getLastIndex(maxWith);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM1188constructorimpl2 = G.m1188constructorimpl(maxWith[i5]);
                    if (comparator.compare(G.a(iM1188constructorimpl), G.a(iM1188constructorimpl2)) < 0) {
                        iM1188constructorimpl = iM1188constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return iM1188constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final int m550minOrThrowU(int[] min) {
        E.f(min, "$this$min");
        if (min.length != 0) {
            int iM1188constructorimpl = G.m1188constructorimpl(min[0]);
            int lastIndex = C.getLastIndex(min);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM1188constructorimpl2 = G.m1188constructorimpl(min[i5]);
                    if (Integer.compareUnsigned(iM1188constructorimpl, iM1188constructorimpl2) > 0) {
                        iM1188constructorimpl = iM1188constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return iM1188constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final int m558minWithOrThrowU(int[] minWith, Comparator<? super G> comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        if (minWith.length != 0) {
            int iM1188constructorimpl = G.m1188constructorimpl(minWith[0]);
            int lastIndex = C.getLastIndex(minWith);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int iM1188constructorimpl2 = G.m1188constructorimpl(minWith[i5]);
                    if (comparator.compare(G.a(iM1188constructorimpl), G.a(iM1188constructorimpl2)) > 0) {
                        iM1188constructorimpl = iM1188constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return iM1188constructorimpl;
        }
        throw new NoSuchElementException();
    }

    private static final double sumOfDouble(int[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i5 : sumOf) {
            dDoubleValue += ((Number) AbstractC0157z.e(i5, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(int[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iIntValue = 0;
        for (int i5 : sumOf) {
            iIntValue += ((Number) AbstractC0157z.e(i5, selector)).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(int[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jLongValue = 0;
        for (int i5 : sumOf) {
            jLongValue += ((Number) AbstractC0157z.e(i5, selector)).longValue();
        }
        return jLongValue;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m454maxByOrThrowU(int[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length != 0) {
            int iM1188constructorimpl = G.m1188constructorimpl(maxBy[0]);
            int lastIndex = C.getLastIndex(maxBy);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(G.a(iM1188constructorimpl));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        int iM1188constructorimpl2 = G.m1188constructorimpl(maxBy[i5]);
                        Comparable comparable2 = (Comparable) selector.invoke(G.a(iM1188constructorimpl2));
                        if (comparable.compareTo(comparable2) < 0) {
                            iM1188constructorimpl = iM1188constructorimpl2;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return iM1188constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m510minByOrThrowU(int[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length != 0) {
            int iM1188constructorimpl = G.m1188constructorimpl(minBy[0]);
            int lastIndex = C.getLastIndex(minBy);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(G.a(iM1188constructorimpl));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        int iM1188constructorimpl2 = G.m1188constructorimpl(minBy[i5]);
                        Comparable comparable2 = (Comparable) selector.invoke(G.a(iM1188constructorimpl2));
                        if (comparable.compareTo(comparable2) > 0) {
                            iM1188constructorimpl = iM1188constructorimpl2;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return iM1188constructorimpl;
        }
        throw new NoSuchElementException();
    }

    private static final int sumOfUInt(long[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iM1188constructorimpl = G.m1188constructorimpl(0);
        for (long j6 : sumOf) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.g(j6, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(long[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jM1247constructorimpl = J.m1247constructorimpl(0L);
        for (long j6 : sumOf) {
            jM1247constructorimpl = J.m1247constructorimpl(jM1247constructorimpl + ((J) AbstractC0157z.g(j6, selector)).f9126a);
        }
        return jM1247constructorimpl;
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final long m495maxOrThrowU(long[] max) {
        E.f(max, "$this$max");
        if (max.length != 0) {
            long jM1247constructorimpl = J.m1247constructorimpl(max[0]);
            int lastIndex = C.getLastIndex(max);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM1247constructorimpl2 = J.m1247constructorimpl(max[i5]);
                    if (Long.compareUnsigned(jM1247constructorimpl, jM1247constructorimpl2) < 0) {
                        jM1247constructorimpl = jM1247constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return jM1247constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final long m503maxWithOrThrowU(long[] maxWith, Comparator<? super J> comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        if (maxWith.length != 0) {
            long jM1247constructorimpl = J.m1247constructorimpl(maxWith[0]);
            int lastIndex = C.getLastIndex(maxWith);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM1247constructorimpl2 = J.m1247constructorimpl(maxWith[i5]);
                    if (comparator.compare(J.a(jM1247constructorimpl), J.a(jM1247constructorimpl2)) < 0) {
                        jM1247constructorimpl = jM1247constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return jM1247constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final long m551minOrThrowU(long[] min) {
        E.f(min, "$this$min");
        if (min.length != 0) {
            long jM1247constructorimpl = J.m1247constructorimpl(min[0]);
            int lastIndex = C.getLastIndex(min);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM1247constructorimpl2 = J.m1247constructorimpl(min[i5]);
                    if (Long.compareUnsigned(jM1247constructorimpl, jM1247constructorimpl2) > 0) {
                        jM1247constructorimpl = jM1247constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return jM1247constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final long m559minWithOrThrowU(long[] minWith, Comparator<? super J> comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        if (minWith.length != 0) {
            long jM1247constructorimpl = J.m1247constructorimpl(minWith[0]);
            int lastIndex = C.getLastIndex(minWith);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long jM1247constructorimpl2 = J.m1247constructorimpl(minWith[i5]);
                    if (comparator.compare(J.a(jM1247constructorimpl), J.a(jM1247constructorimpl2)) > 0) {
                        jM1247constructorimpl = jM1247constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return jM1247constructorimpl;
        }
        throw new NoSuchElementException();
    }

    private static final double sumOfDouble(long[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j6 : sumOf) {
            dDoubleValue += ((Number) AbstractC0157z.g(j6, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(long[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iIntValue = 0;
        for (long j6 : sumOf) {
            iIntValue += ((Number) AbstractC0157z.g(j6, selector)).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(long[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jLongValue = 0;
        for (long j6 : sumOf) {
            jLongValue += ((Number) AbstractC0157z.g(j6, selector)).longValue();
        }
        return jLongValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m470maxOfOrNullJOV_ifY(byte[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.d(maxOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.d(maxOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m473maxOfOrNullMShoTSo(long[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.g(maxOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.g(maxOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m476maxOfOrNulljgv0xPQ(int[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.e(maxOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.e(maxOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m479maxOfOrNullxTcfx_M(short[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.i(maxOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.i(maxOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m526minOfOrNullJOV_ifY(byte[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.d(minOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.d(minOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m529minOfOrNullMShoTSo(long[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.g(minOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.g(minOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m532minOfOrNulljgv0xPQ(int[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.e(minOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.e(minOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m535minOfOrNullxTcfx_M(short[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.i(minOfOrNull[0], selector)).doubleValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.i(minOfOrNull[i5], selector)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m455maxByOrThrowU(long[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length != 0) {
            long jM1247constructorimpl = J.m1247constructorimpl(maxBy[0]);
            int lastIndex = C.getLastIndex(maxBy);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(J.a(jM1247constructorimpl));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long jM1247constructorimpl2 = J.m1247constructorimpl(maxBy[i5]);
                        Comparable comparable2 = (Comparable) selector.invoke(J.a(jM1247constructorimpl2));
                        if (comparable.compareTo(comparable2) < 0) {
                            jM1247constructorimpl = jM1247constructorimpl2;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return jM1247constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final float m458maxOfJOV_ifY(byte[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.d(maxOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.d(maxOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final float m461maxOfMShoTSo(long[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.g(maxOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.g(maxOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final float m464maxOfjgv0xPQ(int[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.e(maxOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.e(maxOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final float m467maxOfxTcfx_M(short[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.i(maxOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.i(maxOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m511minByOrThrowU(long[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length != 0) {
            long jM1247constructorimpl = J.m1247constructorimpl(minBy[0]);
            int lastIndex = C.getLastIndex(minBy);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(J.a(jM1247constructorimpl));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long jM1247constructorimpl2 = J.m1247constructorimpl(minBy[i5]);
                        Comparable comparable2 = (Comparable) selector.invoke(J.a(jM1247constructorimpl2));
                        if (comparable.compareTo(comparable2) > 0) {
                            jM1247constructorimpl = jM1247constructorimpl2;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return jM1247constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final float m514minOfJOV_ifY(byte[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.d(minOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.d(minOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final float m517minOfMShoTSo(long[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.g(minOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.g(minOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final float m520minOfjgv0xPQ(int[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.e(minOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.e(minOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final float m523minOfxTcfx_M(short[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            float fFloatValue = ((Number) AbstractC0157z.i(minOf[0], selector)).floatValue();
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.i(minOf[i5], selector)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final short m496maxOrThrowU(short[] max) {
        E.f(max, "$this$max");
        if (max.length != 0) {
            short sM1306constructorimpl = N.m1306constructorimpl(max[0]);
            int lastIndex = C.getLastIndex(max);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM1306constructorimpl2 = N.m1306constructorimpl(max[i5]);
                    if (E.h(sM1306constructorimpl & 65535, 65535 & sM1306constructorimpl2) < 0) {
                        sM1306constructorimpl = sM1306constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return sM1306constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final short m504maxWithOrThrowU(short[] maxWith, Comparator<? super N> comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        if (maxWith.length != 0) {
            short sM1306constructorimpl = N.m1306constructorimpl(maxWith[0]);
            int lastIndex = C.getLastIndex(maxWith);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM1306constructorimpl2 = N.m1306constructorimpl(maxWith[i5]);
                    if (comparator.compare(N.a(sM1306constructorimpl), N.a(sM1306constructorimpl2)) < 0) {
                        sM1306constructorimpl = sM1306constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return sM1306constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final short m552minOrThrowU(short[] min) {
        E.f(min, "$this$min");
        if (min.length != 0) {
            short sM1306constructorimpl = N.m1306constructorimpl(min[0]);
            int lastIndex = C.getLastIndex(min);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM1306constructorimpl2 = N.m1306constructorimpl(min[i5]);
                    if (E.h(sM1306constructorimpl & 65535, 65535 & sM1306constructorimpl2) > 0) {
                        sM1306constructorimpl = sM1306constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return sM1306constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final short m560minWithOrThrowU(short[] minWith, Comparator<? super N> comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        if (minWith.length != 0) {
            short sM1306constructorimpl = N.m1306constructorimpl(minWith[0]);
            int lastIndex = C.getLastIndex(minWith);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short sM1306constructorimpl2 = N.m1306constructorimpl(minWith[i5]);
                    if (comparator.compare(N.a(sM1306constructorimpl), N.a(sM1306constructorimpl2)) > 0) {
                        sM1306constructorimpl = sM1306constructorimpl2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return sM1306constructorimpl;
        }
        throw new NoSuchElementException();
    }

    private static final int sumOfUInt(byte[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iM1188constructorimpl = G.m1188constructorimpl(0);
        for (byte b : sumOf) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.d(b, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(byte[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jM1247constructorimpl = J.m1247constructorimpl(0L);
        for (byte b : sumOf) {
            jM1247constructorimpl = J.m1247constructorimpl(jM1247constructorimpl + ((J) AbstractC0157z.d(b, selector)).f9126a);
        }
        return jM1247constructorimpl;
    }

    private static final double sumOfDouble(short[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s6 : sumOf) {
            dDoubleValue += ((Number) AbstractC0157z.i(s6, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(short[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iIntValue = 0;
        for (short s6 : sumOf) {
            iIntValue += ((Number) AbstractC0157z.i(s6, selector)).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(short[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jLongValue = 0;
        for (short s6 : sumOf) {
            jLongValue += ((Number) AbstractC0157z.i(s6, selector)).longValue();
        }
        return jLongValue;
    }

    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m456maxByOrThrowU(short[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length != 0) {
            short sM1306constructorimpl = N.m1306constructorimpl(maxBy[0]);
            int lastIndex = C.getLastIndex(maxBy);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(N.a(sM1306constructorimpl));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short sM1306constructorimpl2 = N.m1306constructorimpl(maxBy[i5]);
                        Comparable comparable2 = (Comparable) selector.invoke(N.a(sM1306constructorimpl2));
                        if (comparable.compareTo(comparable2) < 0) {
                            sM1306constructorimpl = sM1306constructorimpl2;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return sM1306constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m512minByOrThrowU(short[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length != 0) {
            short sM1306constructorimpl = N.m1306constructorimpl(minBy[0]);
            int lastIndex = C.getLastIndex(minBy);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(N.a(sM1306constructorimpl));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short sM1306constructorimpl2 = N.m1306constructorimpl(minBy[i5]);
                        Comparable comparable2 = (Comparable) selector.invoke(N.a(sM1306constructorimpl2));
                        if (comparable.compareTo(comparable2) > 0) {
                            sM1306constructorimpl = sM1306constructorimpl2;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return sM1306constructorimpl;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m362getIndicesajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m364getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m366getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m368getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m370getLastIndexajY9A$annotations(int[] iArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m372getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m374getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m376getLastIndexrL5Bavg$annotations(short[] sArr) {
    }

    private static final int sumOfUInt(short[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        int iM1188constructorimpl = G.m1188constructorimpl(0);
        for (short s6 : sumOf) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + ((G) AbstractC0157z.i(s6, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(short[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        long jM1247constructorimpl = J.m1247constructorimpl(0L);
        for (short s6 : sumOf) {
            jM1247constructorimpl = J.m1247constructorimpl(jM1247constructorimpl + ((J) AbstractC0157z.i(s6, selector)).f9126a);
        }
        return jM1247constructorimpl;
    }

    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m471maxOfOrNullJOV_ifY(byte[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.d(maxOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.d(maxOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m474maxOfOrNullMShoTSo(long[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.g(maxOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.g(maxOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m477maxOfOrNulljgv0xPQ(int[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.e(maxOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.e(maxOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m480maxOfOrNullxTcfx_M(short[] maxOfOrNull, l selector) {
        E.f(maxOfOrNull, "$this$maxOfOrNull");
        E.f(selector, "selector");
        if (maxOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.i(maxOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(maxOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.i(maxOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m527minOfOrNullJOV_ifY(byte[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.d(minOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.d(minOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m530minOfOrNullMShoTSo(long[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.g(minOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.g(minOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m533minOfOrNulljgv0xPQ(int[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.e(minOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.e(minOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m536minOfOrNullxTcfx_M(short[] minOfOrNull, l selector) {
        E.f(minOfOrNull, "$this$minOfOrNull");
        E.f(selector, "selector");
        if (minOfOrNull.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.i(minOfOrNull[0], selector)).floatValue();
        int lastIndex = C.getLastIndex(minOfOrNull);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.i(minOfOrNull[i5], selector)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m459maxOfJOV_ifY(byte[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            R r6 = (R) AbstractC0157z.d(maxOf[0], selector);
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.d(maxOf[i5], selector);
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m462maxOfMShoTSo(long[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            R r6 = (R) AbstractC0157z.g(maxOf[0], selector);
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.g(maxOf[i5], selector);
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m465maxOfjgv0xPQ(int[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            R r6 = (R) AbstractC0157z.e(maxOf[0], selector);
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.e(maxOf[i5], selector);
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m468maxOfxTcfx_M(short[] maxOf, l selector) {
        E.f(maxOf, "$this$maxOf");
        E.f(selector, "selector");
        if (maxOf.length != 0) {
            R r6 = (R) AbstractC0157z.i(maxOf[0], selector);
            int lastIndex = C.getLastIndex(maxOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.i(maxOf[i5], selector);
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m515minOfJOV_ifY(byte[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            R r6 = (R) AbstractC0157z.d(minOf[0], selector);
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.d(minOf[i5], selector);
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m518minOfMShoTSo(long[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            R r6 = (R) AbstractC0157z.g(minOf[0], selector);
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.g(minOf[i5], selector);
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m521minOfjgv0xPQ(int[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            R r6 = (R) AbstractC0157z.e(minOf[0], selector);
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.e(minOf[i5], selector);
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m524minOfxTcfx_M(short[] minOf, l selector) {
        E.f(minOf, "$this$minOf");
        E.f(selector, "selector");
        if (minOf.length != 0) {
            R r6 = (R) AbstractC0157z.i(minOf[0], selector);
            int lastIndex = C.getLastIndex(minOf);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.i(minOf[i5], selector);
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final int sumOfUInt(G[] gArr) {
        E.f(gArr, "<this>");
        int iM1188constructorimpl = 0;
        for (G g6 : gArr) {
            iM1188constructorimpl = G.m1188constructorimpl(iM1188constructorimpl + g6.f9124a);
        }
        return iM1188constructorimpl;
    }

    public static final long sumOfULong(J[] jArr) {
        E.f(jArr, "<this>");
        long jM1247constructorimpl = 0;
        for (J j6 : jArr) {
            jM1247constructorimpl = J.m1247constructorimpl(jM1247constructorimpl + j6.f9126a);
        }
        return jM1247constructorimpl;
    }
}
