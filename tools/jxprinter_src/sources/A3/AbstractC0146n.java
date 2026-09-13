package A3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1127c;
import p147z3.C1938s;

/* JADX INFO: renamed from: A3.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0146n extends AbstractC0145m {
    public static final void a(Object[] objArr, StringBuilder sb, ArrayList arrayList) {
        if (arrayList.contains(objArr)) {
            sb.append("[...]");
            return;
        }
        arrayList.add(objArr);
        sb.append('[');
        int length = objArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (i5 != 0) {
                sb.append(", ");
            }
            Object obj = objArr[i5];
            if (obj == null) {
                sb.append(AbstractC1127c.NULL);
            } else if (obj instanceof Object[]) {
                a((Object[]) obj, sb, arrayList);
            } else if (obj instanceof byte[]) {
                String string = Arrays.toString((byte[]) obj);
                kotlin.jvm.internal.E.e(string, "toString(...)");
                sb.append(string);
            } else if (obj instanceof short[]) {
                String string2 = Arrays.toString((short[]) obj);
                kotlin.jvm.internal.E.e(string2, "toString(...)");
                sb.append(string2);
            } else if (obj instanceof int[]) {
                String string3 = Arrays.toString((int[]) obj);
                kotlin.jvm.internal.E.e(string3, "toString(...)");
                sb.append(string3);
            } else if (obj instanceof long[]) {
                String string4 = Arrays.toString((long[]) obj);
                kotlin.jvm.internal.E.e(string4, "toString(...)");
                sb.append(string4);
            } else if (obj instanceof float[]) {
                String string5 = Arrays.toString((float[]) obj);
                kotlin.jvm.internal.E.e(string5, "toString(...)");
                sb.append(string5);
            } else if (obj instanceof double[]) {
                String string6 = Arrays.toString((double[]) obj);
                kotlin.jvm.internal.E.e(string6, "toString(...)");
                sb.append(string6);
            } else if (obj instanceof char[]) {
                String string7 = Arrays.toString((char[]) obj);
                kotlin.jvm.internal.E.e(string7, "toString(...)");
                sb.append(string7);
            } else if (obj instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) obj);
                kotlin.jvm.internal.E.e(string8, "toString(...)");
                sb.append(string8);
            } else if (obj instanceof p147z3.E) {
                sb.append(C3.b.m221contentToString2csIQuQ(((p147z3.E) obj).c()));
            } else if (obj instanceof p147z3.O) {
                sb.append(C3.b.m223contentToStringd6D3K8(((p147z3.O) obj).c()));
            } else if (obj instanceof p147z3.H) {
                sb.append(C3.b.m222contentToStringXUkPCBk(((p147z3.H) obj).c()));
            } else if (obj instanceof p147z3.K) {
                sb.append(C3.b.m224contentToStringuLth9ew(((p147z3.K) obj).c()));
            } else {
                sb.append(obj.toString());
            }
        }
        sb.append(']');
        arrayList.remove(I.getLastIndex(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean contentDeepEquals(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            Object[] objArr = tArr[i5];
            Object[] objArr2 = tArr2[i5];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!contentDeepEquals(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof p147z3.E) && (objArr2 instanceof p147z3.E)) {
                    if (!C3.b.m215contentEqualskV0jMPg(((p147z3.E) objArr).c(), ((p147z3.E) objArr2).c())) {
                        return false;
                    }
                } else if ((objArr instanceof p147z3.O) && (objArr2 instanceof p147z3.O)) {
                    if (!C3.b.m213contentEqualsFGO6Aew(((p147z3.O) objArr).c(), ((p147z3.O) objArr2).c())) {
                        return false;
                    }
                } else if ((objArr instanceof p147z3.H) && (objArr2 instanceof p147z3.H)) {
                    if (!C3.b.m214contentEqualsKJPZfPQ(((p147z3.H) objArr).c(), ((p147z3.H) objArr2).c())) {
                        return false;
                    }
                } else if ((objArr instanceof p147z3.K) && (objArr2 instanceof p147z3.K)) {
                    if (!C3.b.m216contentEqualslec5QzE(((p147z3.K) objArr).c(), ((p147z3.K) objArr2).c())) {
                        return false;
                    }
                } else if (!objArr.equals(objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] tArr) {
        if (tArr == null) {
            return AbstractC1127c.NULL;
        }
        int length = tArr.length;
        if (length > 429496729) {
            length = 429496729;
        }
        StringBuilder sb = new StringBuilder((length * 5) + 2);
        a(tArr, sb, new ArrayList());
        return sb.toString();
    }

    public static final <T> List<T> flatten(T[][] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(length);
        for (T[] tArr3 : tArr) {
            O.addAll(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;LO3/a;)TR; */
    private static final Object ifEmpty(Object[] objArr, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return objArr.length == 0 ? defaultValue.invoke() : objArr;
    }

    private static final boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static final <T, R> C1938s unzip(C1938s[] c1938sArr) {
        kotlin.jvm.internal.E.f(c1938sArr, "<this>");
        ArrayList arrayList = new ArrayList(c1938sArr.length);
        ArrayList arrayList2 = new ArrayList(c1938sArr.length);
        for (C1938s c1938s : c1938sArr) {
            arrayList.add(c1938s.f9134a);
            arrayList2.add(c1938s.b);
        }
        return p147z3.A.to(arrayList, arrayList2);
    }
}
