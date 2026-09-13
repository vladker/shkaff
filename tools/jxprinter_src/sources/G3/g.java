package G3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final void a(int i5) {
        if (i5 <= 1) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + i5 + ". Please update the Kotlin standard library.").toString());
    }

    public static final int b(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final String[] getSpilledVariableFieldMapping(a aVar) {
        E.f(aVar, "<this>");
        f fVar = (f) aVar.getClass().getAnnotation(f.class);
        if (fVar == null) {
            return null;
        }
        a(fVar.v());
        ArrayList arrayList = new ArrayList();
        int iB = b(aVar);
        int[] iArrI = fVar.i();
        int length = iArrI.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArrI[i5] == iB) {
                arrayList.add(fVar.s()[i5]);
                arrayList.add(fVar.n()[i5]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final StackTraceElement getStackTraceElement(a aVar) {
        String strC;
        E.f(aVar, "<this>");
        f fVar = (f) aVar.getClass().getAnnotation(f.class);
        if (fVar == null) {
            return null;
        }
        a(fVar.v());
        int iB = b(aVar);
        int i5 = iB < 0 ? -1 : fVar.l()[iB];
        String moduleName = j.INSTANCE.getModuleName(aVar);
        if (moduleName == null) {
            strC = fVar.c();
        } else {
            strC = moduleName + '/' + fVar.c();
        }
        return new StackTraceElement(strC, fVar.m(), fVar.f(), i5);
    }
}
