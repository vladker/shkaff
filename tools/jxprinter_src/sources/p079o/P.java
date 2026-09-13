package p079o;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import p050j.d;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class P implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P f6341a = new P();

    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    public static Object c(b bVar, Class cls, p050j.b bVar2) {
        Object objB;
        if (bVar2 == null) {
            return null;
        }
        ArrayList arrayList = bVar2.f5377j;
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i5 = 0; i5 < size; i5++) {
            Object objC = arrayList.get(i5);
            if (objC == bVar2) {
                Array.set(objNewInstance, i5, objNewInstance);
            } else if (cls.isArray()) {
                if (!cls.isInstance(objC)) {
                    objC = c(bVar, cls, (p050j.b) objC);
                }
                Array.set(objNewInstance, i5, objC);
            } else {
                if (objC instanceof p050j.b) {
                    p050j.b bVar3 = (p050j.b) objC;
                    ArrayList arrayList2 = bVar3.f5377j;
                    int size2 = arrayList2.size();
                    boolean z6 = false;
                    for (int i6 = 0; i6 < size2; i6++) {
                        if (arrayList2.get(i6) == bVar2) {
                            bVar3.set(i5, objNewInstance);
                            z6 = true;
                        }
                    }
                    if (z6) {
                        objB = arrayList2.toArray();
                    } else {
                        objB = null;
                    }
                } else {
                    objB = null;
                }
                if (objB == null) {
                    objB = j.b(objC, cls, bVar.b);
                }
                Array.set(objNewInstance, i5, objB);
            }
        }
        bVar2.f5378k = objNewInstance;
        bVar2.f5379l = cls;
        return objNewInstance;
    }

    @Override // p073n.p
    public final int a() {
        return 14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Type componentType;
        Class clsQ;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        Type type2 = null;
        if (i5 == 8) {
            gVar.n(16);
            return null;
        }
        if (i5 == 4) {
            byte[] bArrM = gVar.M();
            gVar.n(16);
            return bArrM;
        }
        if (type instanceof GenericArrayType) {
            componentType = ((GenericArrayType) type).getGenericComponentType();
            if (componentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) componentType;
                ParameterizedType parameterizedType = bVar.f6067f.d;
                if (parameterizedType != null) {
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        TypeVariable[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i6 = 0; i6 < typeParameters.length; i6++) {
                            if (typeParameters[i6].getName().equals(typeVariable.getName())) {
                                type2 = parameterizedType.getActualTypeArguments()[i6];
                            }
                        }
                    }
                    clsQ = type2 instanceof Class ? (Class) type2 : Object.class;
                } else {
                    clsQ = j.q(typeVariable.getBounds()[0]);
                }
            } else {
                clsQ = j.q(componentType);
            }
        } else {
            componentType = ((Class) type).getComponentType();
            clsQ = componentType;
        }
        p050j.b bVar2 = new p050j.b();
        bVar.i(componentType, bVar2, obj);
        return c(bVar, clsQ, bVar2);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public final void write(G g6, Object obj, Object obj2, Type type, int i5) throws Throwable {
        G g7 = g6;
        b0 b0Var = g7.f6325j;
        Y y6 = g7.f6324i;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            b0Var.p(c0.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i6 = length - 1;
        if (i6 == -1) {
            b0Var.a("[]");
            return;
        }
        W w6 = g7.f6331p;
        g7.g(w6, obj, obj2, 0);
        try {
            b0Var.write(91);
            if (b0Var.d(c0.PrettyFormat)) {
                g7.f6326k++;
                g7.f();
                for (int i7 = 0; i7 < length; i7++) {
                    if (i7 != 0) {
                        b0Var.write(44);
                        g7.f();
                    }
                    g7.h(objArr[i7]);
                }
                g7.f6326k--;
                g7.f();
                b0Var.write(93);
                g7.f6331p = w6;
                return;
            }
            Q qB = null;
            Class<?> cls = null;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj3 = objArr[i8];
                if (obj3 == null) {
                    b0Var.a("null,");
                } else {
                    if (g7.e(obj3)) {
                        g7.j(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            try {
                                qB.write(g7, obj3, null, null, 0);
                            } catch (Throwable th) {
                                th = th;
                                g7 = g6;
                                g7.f6331p = w6;
                                throw th;
                            }
                        } else {
                            qB = y6.b(cls2);
                            g7 = g6;
                            qB.write(g7, obj3, null, null, 0);
                            cls = cls2;
                        }
                        b0Var.write(44);
                    }
                    g7 = g6;
                    b0Var.write(44);
                }
            }
            Object obj4 = objArr[i6];
            if (obj4 == null) {
                b0Var.a("null]");
            } else {
                if (g7.e(obj4)) {
                    g7.j(obj4);
                } else {
                    try {
                        y6.b(obj4.getClass()).write(g7, obj4, Integer.valueOf(i6), null, 0);
                    } catch (IOException e) {
                        throw new d(e.getMessage(), e);
                    }
                }
                b0Var.write(93);
            }
            g7.f6331p = w6;
        } catch (Throwable th2) {
            th = th2;
            g7.f6331p = w6;
            throw th;
        }
    }
}
