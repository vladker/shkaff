package p079o;

import A3.AbstractC0157z;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p055k.b;
import p096r.d;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class H extends a0 implements Q {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C1296z[] f6334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C1296z[] f6335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final X f6336k;

    public H(X x6) {
        C1296z[] c1296zArr;
        this.f6336k = x6;
        d[] dVarArr = x6.d;
        d[] dVarArr2 = x6.c;
        this.f6335j = new C1296z[dVarArr.length];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            c1296zArr = this.f6335j;
            if (i6 >= c1296zArr.length) {
                break;
            }
            c1296zArr[i6] = new C1296z(dVarArr[i6]);
            i6++;
        }
        if (dVarArr2 == dVarArr) {
            this.f6334i = c1296zArr;
            return;
        }
        this.f6334i = new C1296z[dVarArr2.length];
        while (true) {
            C1296z[] c1296zArr2 = this.f6334i;
            if (i5 >= c1296zArr2.length) {
                return;
            }
            c1296zArr2[i5] = f(dVarArr2[i5].f7884a);
            i5++;
        }
    }

    public final void e(G g6) {
        ArrayList arrayList = g6.f6357g;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        ArrayList arrayList2 = this.f6357g;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
    }

    public final C1296z f(String str) {
        if (str == null) {
            return null;
        }
        C1296z[] c1296zArr = this.f6335j;
        int length = c1296zArr.length - 1;
        int i5 = 0;
        while (i5 <= length) {
            int i6 = (i5 + length) >>> 1;
            int iCompareTo = c1296zArr[i6].f6425a.f7884a.compareTo(str);
            if (iCompareTo < 0) {
                i5 = i6 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return c1296zArr[i6];
                }
                length = i6 - 1;
            }
        }
        return null;
    }

    public final Object g(Object obj, String str) {
        C1296z c1296zF = f(str);
        if (c1296zF == null) {
            throw new p050j.d(AbstractC0157z.n("field not found. ", str));
        }
        try {
            return c1296zF.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new p050j.d(AbstractC0157z.n("getFieldValue error.", str), e);
        } catch (InvocationTargetException e6) {
            throw new p050j.d(AbstractC0157z.n("getFieldValue error.", str), e6);
        }
    }

    public List<Object> getFieldValues(Object obj) {
        C1296z[] c1296zArr = this.f6335j;
        ArrayList arrayList = new ArrayList(c1296zArr.length);
        for (C1296z c1296z : c1296zArr) {
            arrayList.add(c1296z.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) {
        C1296z[] c1296zArr = this.f6335j;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c1296zArr.length);
        for (C1296z c1296z : c1296zArr) {
            linkedHashMap.put(c1296z.f6425a.f7884a, c1296z.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    public int getSize(Object obj) {
        int i5 = 0;
        for (C1296z c1296z : this.f6335j) {
            if (c1296z.getPropertyValueDirect(obj) != null) {
                i5++;
            }
        }
        return i5;
    }

    public final void h(G g6, char c) {
        ArrayList arrayList = g6.b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        ArrayList arrayList2 = this.b;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
    }

    public final void i(G g6, char c) {
        ArrayList arrayList = g6.f6355a;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        ArrayList arrayList2 = this.f6355a;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
    }

    public final void j(G g6, Object obj) {
        g6.f6325j.g(g6.f6324i.c);
        String name = this.f6336k.b;
        if (name == null) {
            Class<?> superclass = obj.getClass();
            if (j.A(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        g6.i(name);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        write(g6, obj, obj2, type, i5, false);
    }

    public void writeAsArray(G g6, Object obj, Object obj2, Type type, int i5) {
        write(g6, obj, obj2, type, i5);
    }

    public void writeAsArrayNonContext(G g6, Object obj, Object obj2, Type type, int i5) {
        write(g6, obj, obj2, type, i5);
    }

    public void writeDirectNonContext(G g6, Object obj, Object obj2, Type type, int i5) {
        write(g6, obj, obj2, type, i5);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0157  */
    public void write(G g6, Object obj, Object obj2, Type type, int i5, boolean z6) {
        char c;
        Object propertyValueDirect;
        X x6;
        IdentityHashMap identityHashMap;
        Object obj3 = obj;
        b0 b0Var = g6.f6325j;
        if (obj3 == null) {
            b0Var.n();
            return;
        }
        W w6 = g6.f6331p;
        int i6 = c0.DisableCircularReferenceDetect.f6406a;
        if (w6 != null && (w6.d & i6) == 0 && (i5 & i6) == 0 && (identityHashMap = g6.f6330o) != null && identityHashMap.containsKey(obj3)) {
            g6.j(obj);
            return;
        }
        C1296z[] c1296zArr = b0Var.f6370f ? this.f6335j : this.f6334i;
        W w7 = g6.f6331p;
        X x7 = this.f6336k;
        g6.g(w7, obj3, obj2, x7.e);
        int i7 = c0.BeanToArray.f6406a;
        boolean z7 = ((x7.e & i7) == 0 && !b0Var.f6372h && (i5 & i7) == 0) ? false : true;
        int i8 = z7 ? 91 : 123;
        int i9 = z7 ? 93 : 125;
        try {
            if (!z6) {
                try {
                    b0Var.write(i8);
                } catch (Exception e) {
                    String str = "write javaBean error, class " + obj.getClass().getName();
                    if (obj2 != null) {
                        str = str + ", fieldName : " + obj2;
                    }
                    if (e.getMessage() != null) {
                        str = str + ", " + e.getMessage();
                    }
                    throw new p050j.d(str, e);
                }
            }
            if (c1296zArr.length > 0 && b0Var.d(c0.PrettyFormat)) {
                g6.f6326k++;
                g6.f();
            }
            int i10 = x7.e;
            c0 c0Var = c0.WriteClassName;
            if (((i10 & c0Var.f6406a) != 0 || (b0Var.d(c0Var) && !(type == null && b0Var.d(c0.NotWriteRootClassName) && g6.f6331p.f6344a == null))) && obj3.getClass() != type) {
                j(g6, obj);
                c = ',';
            } else {
                c = 0;
            }
            boolean z8 = b0Var.e && !b0Var.d;
            i(g6, c);
            boolean z9 = c == ',';
            boolean zD = b0Var.d(c0.SkipTransientField);
            boolean zD2 = b0Var.d(c0.IgnoreNonFieldGetter);
            boolean z10 = z9;
            int i11 = 0;
            while (i11 < c1296zArr.length) {
                C1296z c1296z = c1296zArr[i11];
                boolean z11 = z7;
                d dVar = c1296z.f6425a;
                Field field = dVar.c;
                boolean z12 = z8;
                String str2 = dVar.f7884a;
                boolean z13 = zD2;
                Class cls = dVar.e;
                if (zD && field != null) {
                    if (dVar.f7891l) {
                        x6 = x7;
                    }
                    i11++;
                    obj3 = obj;
                    z8 = z12;
                    z7 = z11;
                    zD2 = z13;
                    x7 = x6;
                }
                if (!z13 || field != null) {
                    b(g6);
                    e(g6);
                    try {
                        propertyValueDirect = c1296z.getPropertyValueDirect(obj3);
                    } catch (InvocationTargetException e6) {
                        if (!b0Var.d(c0.IgnoreErrorGetter)) {
                            throw e6;
                        }
                        propertyValueDirect = null;
                    }
                    a(g6);
                    c(g6, str2);
                    Object objD = d(g6, propertyValueDirect, c1296z.f6427g);
                    if (objD == null && !z11 && !c1296z.b) {
                        if (!((b0Var.c & c0.f6383G) != 0)) {
                        }
                        i11++;
                        obj3 = obj;
                        z8 = z12;
                        z7 = z11;
                        zD2 = z13;
                        x7 = x6;
                    }
                    if (objD == null) {
                        x6 = x7;
                    } else {
                        if (!b0Var.f6374j) {
                            int i12 = dVar.f7888i;
                            int i13 = c0.NotWriteDefaultValue.f6406a;
                            if ((i12 & i13) == 0 && (x7.e & i13) == 0) {
                                x6 = x7;
                            }
                        }
                        Class cls2 = dVar.e;
                        x6 = x7;
                        if ((cls2 != Byte.TYPE || !(objD instanceof Byte) || ((Byte) objD).byteValue() != 0) && ((cls2 != Short.TYPE || !(objD instanceof Short) || ((Short) objD).shortValue() != 0) && ((cls2 != Integer.TYPE || !(objD instanceof Integer) || ((Integer) objD).intValue() != 0) && ((cls2 != Long.TYPE || !(objD instanceof Long) || ((Long) objD).longValue() != 0) && ((cls2 != Float.TYPE || !(objD instanceof Float) || ((Float) objD).floatValue() != 0.0f) && ((cls2 != Double.TYPE || !(objD instanceof Double) || ((Double) objD).doubleValue() != 0.0d) && (cls2 != Boolean.TYPE || !(objD instanceof Boolean) || ((Boolean) objD).booleanValue()))))))) {
                        }
                        i11++;
                        obj3 = obj;
                        z8 = z12;
                        z7 = z11;
                        zD2 = z13;
                        x7 = x6;
                    }
                    if (z10) {
                        b0Var.write(44);
                        if (b0Var.d(c0.PrettyFormat)) {
                            g6.f();
                        }
                    }
                    if (propertyValueDirect != objD) {
                        if (!z11) {
                            c1296z.writePrefix(g6);
                        }
                        g6.h(objD);
                    } else {
                        if (!z11 && !dVar.f7895p) {
                            if (z12) {
                                char[] cArr = dVar.f7892m;
                                b0Var.write(cArr, 0, cArr.length);
                            } else {
                                c1296z.writePrefix(g6);
                            }
                        }
                        if (z11) {
                            c1296z.writeValue(g6, objD);
                        } else {
                            b bVarC = dVar.c();
                            if (cls != String.class || (bVarC != null && bVarC.serializeUsing() != Void.class)) {
                                c1296z.writeValue(g6, objD);
                            } else if (objD == null) {
                                int i14 = b0Var.c;
                                int i15 = c0.WriteNullStringAsEmpty.f6406a;
                                if ((i14 & i15) == 0 && (c1296z.c & i15) == 0) {
                                    b0Var.n();
                                } else {
                                    b0Var.q("");
                                }
                            } else {
                                String str3 = (String) objD;
                                if (b0Var.d) {
                                    b0Var.s(str3);
                                } else {
                                    b0Var.r(str3, (char) 0);
                                }
                            }
                        }
                        z10 = true;
                        i11++;
                        obj3 = obj;
                        z8 = z12;
                        z7 = z11;
                        zD2 = z13;
                        x7 = x6;
                    }
                    z10 = true;
                    i11++;
                    obj3 = obj;
                    z8 = z12;
                    z7 = z11;
                    zD2 = z13;
                    x7 = x6;
                }
                x6 = x7;
                i11++;
                obj3 = obj;
                z8 = z12;
                z7 = z11;
                zD2 = z13;
                x7 = x6;
            }
            h(g6, z10 ? ',' : (char) 0);
            if (c1296zArr.length > 0 && b0Var.d(c0.PrettyFormat)) {
                g6.f6326k--;
                g6.f();
            }
            if (!z6) {
                b0Var.write(i9);
            }
            g6.f6331p = w7;
        } catch (Throwable th) {
            g6.f6331p = w7;
            throw th;
        }
    }
}
