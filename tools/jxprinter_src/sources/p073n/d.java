package p073n;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;
import p067m.b;
import p067m.c;
import p067m.g;
import p067m.i;
import p067m.j;
import p096r.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends l {
    public final Type c;
    public int d;
    public p e;

    public d(Class cls, p096r.d dVar) {
        super(cls, dVar);
        Type type = dVar.f7885f;
        if (!(type instanceof ParameterizedType)) {
            this.c = Object.class;
            return;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        this.c = type2;
    }

    @Override // p073n.l
    public final int a() {
        return 14;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0077  */
    /* JADX WARN: Code duplicated, block: B:26:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e7  */
    @Override // p073n.l
    public final void b(Object obj, Type type, Map map, b bVar) {
        int i5;
        Class cls;
        ParameterizedType parameterizedType;
        int i6;
        ParameterizedType parameterizedType2;
        int i7;
        Type type2;
        g gVar = bVar.e;
        j jVar = bVar.b;
        if (gVar.f6092a == 8) {
            c(obj, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        i iVar = bVar.f6067f;
        p096r.d dVar = this.f6187a;
        bVar.q(iVar, obj, dVar.f7884a);
        p pVarB = this.e;
        boolean z6 = type instanceof ParameterizedType;
        Type hVar = this.c;
        if (!z6) {
            i5 = 0;
        } else if (hVar instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) hVar;
            ParameterizedType parameterizedType3 = (ParameterizedType) type;
            cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
            if (cls != null) {
                int length = cls.getTypeParameters().length;
                i7 = 0;
                i5 = 0;
                while (true) {
                    if (i7 < length) {
                        parameterizedType2 = parameterizedType3;
                        if (!cls.getTypeParameters()[i7].getName().equals(typeVariable.getName())) {
                            i7++;
                            parameterizedType3 = parameterizedType2;
                        }
                    }
                    if (i7 != -1) {
                        type2 = parameterizedType2.getActualTypeArguments()[i7];
                        if (!type2.equals(hVar)) {
                            pVarB = jVar.b(type2);
                        }
                        hVar = type2;
                    }
                }
            } else {
                i5 = 0;
            }
            parameterizedType2 = parameterizedType3;
            i7 = -1;
            if (i7 != -1) {
                type2 = parameterizedType2.getActualTypeArguments()[i7];
                if (!type2.equals(hVar)) {
                    pVarB = jVar.b(type2);
                }
                hVar = type2;
            }
        } else {
            i5 = 0;
            if (hVar instanceof ParameterizedType) {
                ParameterizedType parameterizedType4 = (ParameterizedType) hVar;
                Type[] actualTypeArguments = parameterizedType4.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type3 = actualTypeArguments[0];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        ParameterizedType parameterizedType5 = (ParameterizedType) type;
                        cls = parameterizedType5.getRawType() instanceof Class ? (Class) parameterizedType5.getRawType() : null;
                        if (cls != null) {
                            int length2 = cls.getTypeParameters().length;
                            parameterizedType = parameterizedType5;
                            int i8 = 0;
                            while (true) {
                                if (i8 < length2) {
                                    int i9 = i8;
                                    Class cls2 = cls;
                                    if (cls.getTypeParameters()[i8].getName().equals(typeVariable2.getName())) {
                                        i6 = i9;
                                        break;
                                    } else {
                                        i8 = i9 + 1;
                                        cls = cls2;
                                    }
                                }
                            }
                            if (i6 != -1) {
                                actualTypeArguments[0] = parameterizedType.getActualTypeArguments()[i6];
                                hVar = new h(parameterizedType4.getOwnerType(), parameterizedType4.getRawType(), actualTypeArguments);
                            }
                        } else {
                            parameterizedType = parameterizedType5;
                        }
                        i6 = -1;
                        if (i6 != -1) {
                            actualTypeArguments[0] = parameterizedType.getActualTypeArguments()[i6];
                            hVar = new h(parameterizedType4.getOwnerType(), parameterizedType4.getRawType(), actualTypeArguments);
                        }
                    }
                }
            }
        }
        if (gVar.f6092a == 14) {
            if (pVarB == null) {
                pVarB = jVar.b(hVar);
                this.e = pVarB;
                this.d = pVarB.a();
            }
            p pVar = pVarB;
            gVar.n(this.d);
            int i10 = i5;
            while (true) {
                if (gVar.i(c.AllowArbitraryCommas.f6089a)) {
                    while (gVar.f6092a == 16) {
                        gVar.m();
                    }
                }
                if (gVar.f6092a == 15) {
                    break;
                }
                arrayList.add(pVar.b(bVar, hVar, Integer.valueOf(i10)));
                bVar.c(arrayList);
                if (gVar.f6092a == 16) {
                    gVar.n(this.d);
                }
                i10++;
            }
            gVar.n(16);
        } else {
            if (pVarB == null) {
                pVarB = jVar.b(hVar);
                this.e = pVarB;
            }
            arrayList.add(pVarB.b(bVar, hVar, Integer.valueOf(i5)));
            bVar.c(arrayList);
        }
        bVar.r(iVar);
        if (obj == null) {
            map.put(dVar.f7884a, arrayList);
        } else {
            c(obj, arrayList);
        }
    }
}
