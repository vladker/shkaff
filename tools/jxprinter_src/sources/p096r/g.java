package p096r;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p055k.a;
import p055k.b;
import p055k.d;
import p067m.c;
import p079o.c0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f7912a;
    public final Class b;
    public final Constructor c;
    public final Constructor d;
    public final Method e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f7913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d[] f7915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d[] f7916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f7917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f7918k;

    public g(Class cls, Class cls2, Constructor constructor, Constructor constructor2, Method method, Method method2, d dVar, ArrayList arrayList) {
        this.f7912a = cls;
        this.b = cls2;
        this.c = constructor;
        this.d = constructor2;
        this.e = method;
        boolean z6 = j.f7921a;
        d dVar2 = (d) cls.getAnnotation(d.class);
        this.f7917j = dVar2 == null ? 0 : c.a(dVar2.parseFeatures());
        this.f7913f = method2;
        if (dVar != null) {
            String strTypeName = dVar.typeName();
            if (strTypeName.length() != 0) {
                this.f7918k = strTypeName;
            } else {
                this.f7918k = cls.getName();
            }
        } else {
            this.f7918k = cls.getName();
        }
        int size = arrayList.size();
        d[] dVarArr = new d[size];
        this.f7915h = dVarArr;
        arrayList.toArray(dVarArr);
        d[] dVarArr2 = new d[size];
        System.arraycopy(dVarArr, 0, dVarArr2, 0, size);
        Arrays.sort(dVarArr2);
        this.f7916i = Arrays.equals(dVarArr, dVarArr2) ? dVarArr : dVarArr2;
        if (constructor != null) {
            this.f7914g = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.f7914g = method.getParameterTypes().length;
        } else {
            this.f7914g = 0;
        }
    }

    public static void a(ArrayList arrayList, d dVar) {
        int size = arrayList.size() - 1;
        while (size >= 0) {
            d dVar2 = (d) arrayList.get(size);
            if (dVar2.f7884a.equals(dVar.f7884a) && (!dVar2.f7887h || dVar.f7887h)) {
                if (dVar2.e.isAssignableFrom(dVar.e) || dVar2.compareTo(dVar) < 0) {
                    arrayList.remove(size);
                    break;
                }
                return;
            }
            size--;
        }
        arrayList.add(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x024f  */
    /* JADX WARN: Code duplicated, block: B:148:0x02d2 A[PHI: r12 r13 r14 r15 r21 r22 r23 r24 r25 r28
  0x02d2: PHI (r12v11 java.lang.Class) = (r1v44 java.lang.Class), (r1v44 java.lang.Class), (r1v44 java.lang.Class), (r12v14 java.lang.Class) binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r13v17 java.lang.String) = (r3v49 java.lang.String), (r3v49 java.lang.String), (r3v49 java.lang.String), (r13v19 java.lang.String) binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r14v10 java.lang.Class<k.c>) = (r9v19 java.lang.Class<k.c>), (r9v19 java.lang.Class<k.c>), (r9v19 java.lang.Class<k.c>), (r14v12 java.lang.Class<k.c>) binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r15v10 java.util.ArrayList) = (r8v48 java.util.ArrayList), (r8v48 java.util.ArrayList), (r8v48 java.util.ArrayList), (r15v12 java.util.ArrayList) binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r21v21 java.lang.reflect.Field[]) = 
  (r13v13 java.lang.reflect.Field[])
  (r13v13 java.lang.reflect.Field[])
  (r13v13 java.lang.reflect.Field[])
  (r21v25 java.lang.reflect.Field[])
 binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r22v4 java.lang.reflect.Method[]) = 
  (r5v39 java.lang.reflect.Method[])
  (r5v39 java.lang.reflect.Method[])
  (r5v39 java.lang.reflect.Method[])
  (r22v9 java.lang.reflect.Method[])
 binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r23v16 int) = (r7v62 int), (r7v62 int), (r7v62 int), (r23v19 int) binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r24v16 java.lang.reflect.Method[]) = 
  (r14v5 java.lang.reflect.Method[])
  (r14v5 java.lang.reflect.Method[])
  (r14v5 java.lang.reflect.Method[])
  (r24v19 java.lang.reflect.Method[])
 binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r25v10 int) = (r25v9 int), (r25v9 int), (r25v9 int), (r25v12 int) binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]
  0x02d2: PHI (r28v8 java.lang.Class<k.b>) = (r0v48 java.lang.Class<k.b>), (r0v48 java.lang.Class<k.b>), (r0v48 java.lang.Class<k.b>), (r28v10 java.lang.Class<k.b>) binds: [B:152:0x0308, B:155:0x0313, B:158:0x0322, B:147:0x02a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:261:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:274:0x0610  */
    /* JADX WARN: Code duplicated, block: B:276:0x0618  */
    /* JADX WARN: Code duplicated, block: B:281:0x063c  */
    /* JADX WARN: Code duplicated, block: B:284:0x0643  */
    /* JADX WARN: Code duplicated, block: B:286:0x0661  */
    /* JADX WARN: Code duplicated, block: B:288:0x0667  */
    /* JADX WARN: Code duplicated, block: B:305:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:365:0x062d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:366:0x05d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:? A[LOOP:3: B:275:0x0616->B:367:?, LOOP_END, SYNTHETIC] */
    public static g b(Type type, Class cls) {
        Class clsBuilder;
        Constructor<?> constructor;
        Constructor<?> constructor2;
        Class cls2;
        Method method;
        b bVar;
        b bVar2;
        Class<b> cls3;
        Class cls4;
        ArrayList arrayList;
        Field[] fieldArr;
        Method[] methodArr;
        Method method2;
        int i5;
        Method[] methodArr2;
        int i6;
        b bVar3;
        d dVar;
        Field field;
        int size;
        int i7;
        String name;
        b bVar4;
        int iOrdinal;
        int iA;
        int iA2;
        Object obj;
        Class<b> cls5;
        int i8;
        int i9;
        int i10;
        int i11;
        String strP;
        boolean z6;
        Field field2;
        int i12;
        int i13;
        int iOrdinal2;
        b bVar5;
        Method method3;
        int i14;
        int iOrdinal3;
        int i15;
        int i16;
        Class cls6 = cls;
        d dVar2 = (d) cls6.getAnnotation(d.class);
        Class cls7 = (dVar2 == null || (clsBuilder = dVar2.builder()) == Void.class) ? null : clsBuilder;
        Field[] declaredFields = cls6.getDeclaredFields();
        Method[] methods = cls6.getMethods();
        Class cls8 = cls7 == null ? cls6 : cls7;
        int i17 = 0;
        if (!Modifier.isAbstract(cls8.getModifiers())) {
            Constructor<?>[] declaredConstructors = cls8.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i18 = 0;
            while (true) {
                if (i18 >= length) {
                    constructor = null;
                    break;
                }
                constructor = declaredConstructors[i18];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                }
                i18++;
            }
            if (constructor != null || !cls8.isMemberClass() || Modifier.isStatic(cls8.getModifiers())) {
                constructor2 = constructor;
                break;
            }
            int length2 = declaredConstructors.length;
            int i19 = 0;
            while (true) {
                if (i19 >= length2) {
                    constructor2 = constructor;
                    break;
                }
                Constructor<?> constructor3 = declaredConstructors[i19];
                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls8.getDeclaringClass())) {
                    constructor2 = constructor3;
                    break;
                }
                i19++;
            }
        } else {
            constructor2 = null;
        }
        ArrayList arrayList2 = new ArrayList();
        boolean z7 = cls6.isInterface() || Modifier.isAbstract(cls6.getModifiers());
        if (constructor2 == null || z7) {
            Constructor<?> constructor4 = null;
            for (Constructor<?> constructor5 : cls6.getDeclaredConstructors()) {
                if (((a) constructor5.getAnnotation(a.class)) != null) {
                    if (constructor4 != null) {
                        throw new p050j.d("multi-JSONCreator");
                    }
                    constructor4 = constructor5;
                }
            }
            String str = "illegal json creator";
            if (constructor4 != null && !z7) {
                j.C(constructor4);
                Class<?>[] parameterTypes2 = constructor4.getParameterTypes();
                if (parameterTypes2.length > 0) {
                    Annotation[][] parameterAnnotations = constructor4.getParameterAnnotations();
                    int i20 = 0;
                    while (i20 < parameterTypes2.length) {
                        Annotation[] annotationArr = parameterAnnotations[i20];
                        int length3 = annotationArr.length;
                        int i21 = i17;
                        while (true) {
                            if (i21 >= length3) {
                                bVar2 = null;
                                break;
                            }
                            Annotation annotation = annotationArr[i21];
                            if (annotation instanceof b) {
                                bVar2 = (b) annotation;
                                break;
                            }
                            i21++;
                        }
                        if (bVar2 == null) {
                            throw new p050j.d(str);
                        }
                        Class<?> cls9 = parameterTypes2[i20];
                        Type type2 = constructor4.getGenericParameterTypes()[i20];
                        Field fieldT = j.t(cls6, bVar2.name(), declaredFields);
                        b bVar6 = bVar2;
                        int iOrdinal4 = bVar6.ordinal();
                        int iA3 = c0.a(bVar6.serialzeFeatures());
                        c.a(bVar6.parseFeatures());
                        a(arrayList2, new d(bVar6.name(), cls6, cls9, type2, fieldT, iOrdinal4, iA3));
                        i20++;
                        cls6 = cls;
                        str = str;
                        i17 = 0;
                    }
                }
                return new g(cls, cls7, null, constructor4, null, null, dVar2, arrayList2);
            }
            Class cls10 = cls7;
            arrayList2 = arrayList2;
            cls2 = cls10;
            Method method4 = null;
            for (Method method5 : methods) {
                if (Modifier.isStatic(method5.getModifiers()) && cls6.isAssignableFrom(method5.getReturnType()) && ((a) method5.getAnnotation(a.class)) != null) {
                    if (method4 != null) {
                        throw new p050j.d("multi-JSONCreator");
                    }
                    method4 = method5;
                }
            }
            if (method4 != null) {
                j.C(method4);
                Class<?>[] parameterTypes3 = method4.getParameterTypes();
                if (parameterTypes3.length > 0) {
                    Annotation[][] parameterAnnotations2 = method4.getParameterAnnotations();
                    int i22 = 0;
                    while (i22 < parameterTypes3.length) {
                        Annotation[] annotationArr2 = parameterAnnotations2[i22];
                        int length4 = annotationArr2.length;
                        int i23 = 0;
                        while (true) {
                            if (i23 >= length4) {
                                bVar = null;
                                break;
                            }
                            Annotation annotation2 = annotationArr2[i23];
                            if (annotation2 instanceof b) {
                                bVar = (b) annotation2;
                                break;
                            }
                            i23++;
                        }
                        if (bVar == null) {
                            throw new p050j.d("illegal json creator");
                        }
                        Class<?> cls11 = parameterTypes3[i22];
                        Type type3 = method4.getGenericParameterTypes()[i22];
                        Field fieldT2 = j.t(cls6, bVar.name(), declaredFields);
                        int iOrdinal5 = bVar.ordinal();
                        int iA4 = c0.a(bVar.serialzeFeatures());
                        c.a(bVar.parseFeatures());
                        a(arrayList2, new d(bVar.name(), cls6, cls11, type3, fieldT2, iOrdinal5, iA4));
                        i22++;
                        cls6 = cls;
                        parameterTypes3 = parameterTypes3;
                    }
                    return new g(cls, cls2, null, null, method4, null, dVar2, arrayList2);
                }
            } else if (!z7) {
                throw new p050j.d("default constructor not found. " + cls6);
            }
            method = method4;
        } else {
            cls2 = cls7;
            dVar2 = dVar2;
            method = null;
        }
        if (constructor2 != null) {
            j.C(constructor2);
        }
        Class<b> cls12 = b.class;
        if (cls2 != null) {
            Class<p055k.c> cls13 = p055k.c.class;
            p055k.c cVar = (p055k.c) cls2.getAnnotation(cls13);
            String strWithPrefix = cVar != null ? cVar.withPrefix() : null;
            if (strWithPrefix == null || strWithPrefix.length() == 0) {
                strWithPrefix = "with";
            }
            Method[] methods2 = cls2.getMethods();
            int length5 = methods2.length;
            int i24 = 0;
            while (i24 < length5) {
                Class<p055k.c> cls14 = cls13;
                Method method6 = methods2[i24];
                if (!Modifier.isStatic(method6.getModifiers()) && method6.getReturnType().equals(cls2)) {
                    b bVarW = (b) method6.getAnnotation(cls12);
                    if (bVarW == null) {
                        bVarW = j.w(cls6, method6);
                    }
                    if (bVarW == null) {
                        i14 = length5;
                        iOrdinal3 = 0;
                        i15 = 0;
                        i16 = 0;
                    } else if (bVarW.deserialize()) {
                        int i25 = length5;
                        iOrdinal3 = bVarW.ordinal();
                        int iA5 = c0.a(bVarW.serialzeFeatures());
                        int iA6 = c.a(bVarW.parseFeatures());
                        if (bVarW.name().length() != 0) {
                            i14 = i25;
                            methods = methods;
                            cls14 = cls14;
                            arrayList2 = arrayList2;
                            cls2 = cls2;
                            cls12 = cls12;
                            methods2 = methods2;
                            i24 = i24;
                            declaredFields = declaredFields;
                            strWithPrefix = strWithPrefix;
                            a(arrayList2, new d(bVarW.name(), method6, null, cls6, type, iOrdinal3, iA5, iA6, bVarW, null, null));
                        } else {
                            i14 = i25;
                            i15 = iA5;
                            i16 = iA6;
                        }
                        cls6 = cls;
                    } else {
                        cls12 = cls12;
                        cls2 = cls2;
                        methods2 = methods2;
                        i14 = length5;
                        i24 = i24;
                        arrayList2 = arrayList2;
                        declaredFields = declaredFields;
                        methods = methods;
                        strWithPrefix = strWithPrefix;
                        cls14 = cls14;
                    }
                    String name2 = method6.getName();
                    if (name2.startsWith(strWithPrefix) && name2.length() > strWithPrefix.length()) {
                        char cCharAt = name2.charAt(strWithPrefix.length());
                        if (Character.isUpperCase(cCharAt)) {
                            StringBuilder sb = new StringBuilder(name2.substring(strWithPrefix.length()));
                            sb.setCharAt(0, Character.toLowerCase(cCharAt));
                            cls6 = cls;
                            a(arrayList2, new d(sb.toString(), method6, null, cls6, type, iOrdinal3, i15, i16, bVarW, null, null));
                        } else {
                            cls6 = cls;
                        }
                    } else {
                        cls6 = cls;
                    }
                } else {
                    cls12 = cls12;
                    cls2 = cls2;
                    methods2 = methods2;
                    i14 = length5;
                    i24 = i24;
                    arrayList2 = arrayList2;
                    declaredFields = declaredFields;
                    methods = methods;
                    strWithPrefix = strWithPrefix;
                    cls14 = cls14;
                }
                i24++;
                cls2 = cls2;
                strWithPrefix = strWithPrefix;
                cls13 = cls14;
                arrayList2 = arrayList2;
                declaredFields = declaredFields;
                methods2 = methods2;
                methods = methods;
                length5 = i14;
                cls12 = cls12;
            }
            cls3 = cls12;
            cls4 = cls2;
            arrayList = arrayList2;
            fieldArr = declaredFields;
            Method[] methodArr3 = methods;
            p055k.c cVar2 = (p055k.c) cls4.getAnnotation(cls13);
            String strBuildMethod = cVar2 != null ? cVar2.buildMethod() : null;
            if (strBuildMethod == null || strBuildMethod.length() == 0) {
                strBuildMethod = "build";
            }
            try {
                method3 = cls4.getMethod(strBuildMethod, null);
            } catch (NoSuchMethodException | SecurityException unused) {
                method3 = null;
            }
            if (method3 == null) {
                try {
                    method3 = cls4.getMethod("create", null);
                } catch (NoSuchMethodException | SecurityException unused2) {
                }
            }
            if (method3 == null) {
                throw new p050j.d("buildMethod not found.");
            }
            j.C(method3);
            method2 = method3;
            methodArr = methodArr3;
        } else {
            cls3 = cls12;
            cls4 = cls2;
            arrayList = arrayList2;
            fieldArr = declaredFields;
            methodArr = methods;
            method2 = null;
        }
        int length6 = methodArr.length;
        int i26 = 0;
        while (true) {
            i5 = 4;
            if (i26 >= length6) {
                break;
            }
            int i27 = i26;
            Method method7 = methodArr[i27];
            String name3 = method7.getName();
            if (name3.length() >= 4 && !Modifier.isStatic(method7.getModifiers()) && (method7.getReturnType().equals(Void.TYPE) || method7.getReturnType().equals(method7.getDeclaringClass()))) {
                Class<?>[] parameterTypes4 = method7.getParameterTypes();
                if (parameterTypes4.length != 1) {
                    methodArr = methodArr;
                    length6 = length6;
                    i8 = i27;
                    cls5 = cls3;
                } else {
                    cls5 = cls3;
                    b bVarW2 = (b) method7.getAnnotation(cls5);
                    if (bVarW2 == null) {
                        bVarW2 = j.w(cls6, method7);
                    }
                    if (bVarW2 == null) {
                        i8 = i27;
                        i9 = 0;
                        i10 = 0;
                        i11 = 0;
                    } else if (bVarW2.deserialize()) {
                        int iOrdinal6 = bVarW2.ordinal();
                        int iA7 = c0.a(bVarW2.serialzeFeatures());
                        int iA8 = c.a(bVarW2.parseFeatures());
                        if (bVarW2.name().length() != 0) {
                            length6 = length6;
                            methodArr = methodArr;
                            cls5 = cls5;
                            i8 = i27;
                            a(arrayList, new d(bVarW2.name(), method7, null, cls6, type, iOrdinal6, iA7, iA8, bVarW2, null, null));
                        } else {
                            i8 = i27;
                            i10 = iA8;
                            i9 = iA7;
                            i11 = iOrdinal6;
                        }
                    } else {
                        methodArr = methodArr;
                        length6 = length6;
                        i8 = i27;
                        cls5 = cls5;
                    }
                    if (name3.startsWith("set")) {
                        char cCharAt2 = name3.charAt(3);
                        if (Character.isUpperCase(cCharAt2) || cCharAt2 > 512) {
                            strP = j.f7921a ? j.p(name3.substring(3)) : Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                        } else if (cCharAt2 == '_') {
                            strP = name3.substring(4);
                        } else if (cCharAt2 == 'f') {
                            strP = name3.substring(3);
                        } else if (name3.length() >= 5 && Character.isUpperCase(name3.charAt(4))) {
                            strP = j.p(name3.substring(3));
                        }
                        fieldArr = fieldArr;
                        Field fieldT3 = j.t(cls6, strP, fieldArr);
                        if (fieldT3 == null && parameterTypes4[0] == Boolean.TYPE) {
                            StringBuilder sb2 = new StringBuilder("is");
                            sb2.append(Character.toUpperCase(strP.charAt(0)));
                            z6 = true;
                            sb2.append(strP.substring(1));
                            fieldT3 = j.t(cls6, sb2.toString(), fieldArr);
                        } else {
                            z6 = true;
                        }
                        if (fieldT3 != null) {
                            b bVar7 = (b) fieldT3.getAnnotation(cls5);
                            if (bVar7 == null) {
                                field2 = fieldT3;
                                i12 = i9;
                                i13 = i10;
                                iOrdinal2 = i11;
                            } else if (bVar7.deserialize()) {
                                field2 = fieldT3;
                                iOrdinal2 = bVar7.ordinal();
                                int iA9 = c0.a(bVar7.serialzeFeatures());
                                int iA10 = c.a(bVar7.parseFeatures());
                                if (bVar7.name().length() != 0) {
                                    fieldArr = fieldArr;
                                    a(arrayList, new d(bVar7.name(), method7, field2, cls6, type, iOrdinal2, iA9, iA10, bVarW2, bVar7, null));
                                } else {
                                    i12 = iA9;
                                    i13 = iA10;
                                }
                            } else {
                                fieldArr = fieldArr;
                            }
                            bVar5 = bVar7;
                        } else {
                            strP = strP;
                            fieldArr = fieldArr;
                            field2 = fieldT3;
                            i12 = i9;
                            i13 = i10;
                            iOrdinal2 = i11;
                            bVar5 = null;
                        }
                        a(arrayList, new d(strP, method7, field2, cls, type, iOrdinal2, i12, i13, bVarW2, bVar5, null));
                    }
                }
                i26 = i8 + 1;
                cls6 = cls;
                cls3 = cls5;
                length6 = length6;
                methodArr = methodArr;
            } else {
                methodArr = methodArr;
                length6 = length6;
                i8 = i27;
                cls5 = cls3;
            }
            i26 = i8 + 1;
            cls6 = cls;
            cls3 = cls5;
            length6 = length6;
            methodArr = methodArr;
        }
        Class<b> cls15 = cls3;
        Field[] fields = cls.getFields();
        int length7 = fields.length;
        int i28 = 0;
        while (i28 < length7) {
            int i29 = i5;
            Field field3 = fields[i28];
            int modifiers = field3.getModifiers();
            if ((modifiers & 8) != 0) {
                break;
                break;
            }
            if ((modifiers & 16) != 0) {
                Class<?> type4 = field3.getType();
                if (!Map.class.isAssignableFrom(type4) && !Collection.class.isAssignableFrom(type4) && !AtomicLong.class.equals(type4) && !AtomicInteger.class.equals(type4) && !AtomicBoolean.class.equals(type4)) {
                    break;
                    break;
                }
                size = arrayList.size();
                i7 = 0;
                while (true) {
                    if (i7 < size) {
                        name = field3.getName();
                        bVar4 = (b) field3.getAnnotation(b.class);
                        if (bVar4 != null) {
                            iOrdinal = 0;
                            iA = 0;
                            iA2 = 0;
                        } else if (!bVar4.deserialize()) {
                            iOrdinal = bVar4.ordinal();
                            iA = c0.a(bVar4.serialzeFeatures());
                            iA2 = c.a(bVar4.parseFeatures());
                            if (bVar4.name().length() != 0) {
                                name = bVar4.name();
                            }
                        }
                        a(arrayList, new d(name, null, field3, cls, type, iOrdinal, iA, iA2, null, bVar4, null));
                        break;
                    }
                    obj = arrayList.get(i7);
                    i7++;
                    if (((d) obj).f7884a.equals(field3.getName())) {
                    }
                    break;
                }
            } else {
                size = arrayList.size();
                i7 = 0;
                while (true) {
                    if (i7 < size) {
                        name = field3.getName();
                        bVar4 = (b) field3.getAnnotation(b.class);
                        if (bVar4 != null) {
                            iOrdinal = 0;
                            iA = 0;
                            iA2 = 0;
                        } else if (!bVar4.deserialize()) {
                            iOrdinal = bVar4.ordinal();
                            iA = c0.a(bVar4.serialzeFeatures());
                            iA2 = c.a(bVar4.parseFeatures());
                            if (bVar4.name().length() != 0) {
                                name = bVar4.name();
                            }
                        }
                        a(arrayList, new d(name, null, field3, cls, type, iOrdinal, iA, iA2, null, bVar4, null));
                        break;
                        break;
                    }
                    obj = arrayList.get(i7);
                    i7++;
                    if (((d) obj).f7884a.equals(field3.getName())) {
                    }
                    break;
                    break;
                }
            }
            i28++;
            i5 = i29;
            length7 = length7;
            fields = fields;
            cls4 = cls4;
        }
        Class cls16 = cls4;
        int i30 = i5;
        Method[] methods3 = cls.getMethods();
        int length8 = methods3.length;
        int i31 = 0;
        while (i31 < length8) {
            int i32 = i31;
            Method method8 = methods3[i32];
            String name4 = method8.getName();
            if (name4.length() < i30 || Modifier.isStatic(method8.getModifiers()) || !name4.startsWith("get")) {
                methodArr2 = methods3;
                i6 = i32;
            } else if (Character.isUpperCase(name4.charAt(3)) && method8.getParameterTypes().length == 0 && ((Collection.class.isAssignableFrom(method8.getReturnType()) || Map.class.isAssignableFrom(method8.getReturnType()) || AtomicBoolean.class == method8.getReturnType() || AtomicInteger.class == method8.getReturnType() || AtomicLong.class == method8.getReturnType()) && ((bVar3 = (b) method8.getAnnotation(cls15)) == null || !bVar3.deserialize()))) {
                String strName = (bVar3 == null || bVar3.name().length() <= 0) ? Character.toLowerCase(name4.charAt(3)) + name4.substring(i30) : bVar3.name();
                int size2 = arrayList.size();
                int i33 = 0;
                while (true) {
                    if (i33 >= size2) {
                        dVar = null;
                        break;
                    }
                    Object obj2 = arrayList.get(i33);
                    i33++;
                    dVar = (d) obj2;
                    if (dVar.f7884a.equals(strName) || ((field = dVar.c) != null && dVar.c() != null && field.getName().equals(strName))) {
                        break;
                    }
                }
                if (dVar != null) {
                    methodArr2 = methods3;
                    i6 = i32;
                } else {
                    methodArr2 = methods3;
                    i6 = i32;
                    a(arrayList, new d(strName, method8, null, cls, type, 0, 0, 0, bVar3, null, null));
                }
            } else {
                methodArr2 = methods3;
                i6 = i32;
            }
            i31 = i6 + 1;
            length8 = length8;
            methods3 = methodArr2;
        }
        return new g(cls, cls16, constructor2, null, method, method2, dVar2, arrayList);
    }
}
