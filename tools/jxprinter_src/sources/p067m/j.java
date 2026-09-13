package p067m;

import A3.AbstractC0157z;
import W1.a;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;
import p050j.d;
import p050j.r;
import p073n.b;
import p073n.h;
import p073n.m;
import p073n.n;
import p073n.o;
import p073n.p;
import p073n.q;
import p073n.s;
import p073n.t;
import p079o.A;
import p079o.C;
import p079o.C1278g;
import p079o.C1280i;
import p079o.C1283l;
import p079o.C1284m;
import p079o.C1285n;
import p079o.C1286o;
import p079o.C1287p;
import p079o.C1288q;
import p079o.C1289s;
import p079o.C1292v;
import p079o.L;
import p079o.N;
import p079o.P;
import p079o.V;
import p079o.d0;
import p096r.c;
import p096r.e;
import p096r.f;
import p096r.g;
import p096r.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f6105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f6106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f6107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final j f6108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f6109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f6110n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f6111a = new f();
    public final boolean b;
    public final k c;
    public final b d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f6112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f6113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6114h;

    static {
        String strC = e.c("fastjson.parser.deny");
        String[] strArrSplit = null;
        f6105i = (strC == null || strC.length() <= 0) ? null : strC.split(",");
        f6107k = "true".equals(e.c("fastjson.parser.autoTypeSupport"));
        String strC2 = e.c("fastjson.parser.autoTypeAccept");
        if (strC2 != null && strC2.length() > 0) {
            strArrSplit = strC2.split(",");
        }
        if (strArrSplit == null) {
            strArrSplit = new String[0];
        }
        f6106j = strArrSplit;
        f6108l = new j();
        f6109m = false;
        f6110n = false;
    }

    public j() {
        b bVar;
        boolean z6 = c.f7883a;
        this.b = !z6;
        this.c = new k(0);
        this.e = f6107k;
        this.f6112f = "bsh,com.mchange,com.sun.,java.lang.Thread,java.net.Socket,java.rmi,javax.xml,org.apache.bcel,org.apache.commons.beanutils,org.apache.commons.collections.Transformer,org.apache.commons.collections.functors,org.apache.commons.collections4.comparators,org.apache.commons.fileupload,org.apache.myfaces.context.servlet,org.apache.tomcat,org.apache.wicket.util,org.codehaus.groovy.runtime,org.hibernate,org.jboss,org.mozilla.javascript,org.python.core,org.springframework".split(",");
        String[] strArr = f6106j;
        this.f6113g = strArr;
        this.f6114h = 256;
        boolean z7 = p096r.j.f7921a;
        if (z6) {
            bVar = null;
        } else {
            try {
                bVar = new b(new p096r.b());
            } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
                bVar = null;
            }
        }
        this.d = bVar;
        if (bVar == null) {
            this.b = false;
        }
        f fVar = this.f6111a;
        N n6 = N.f6340a;
        fVar.c(SimpleDateFormat.class, n6);
        this.f6111a.c(Timestamp.class, s.c);
        this.f6111a.c(Date.class, s.b);
        this.f6111a.c(Time.class, n.f6189f);
        this.f6111a.c(java.util.Date.class, C1292v.f6421a);
        f fVar2 = this.f6111a;
        C1286o c1286o = C1286o.b;
        fVar2.c(Calendar.class, c1286o);
        this.f6111a.c(XMLGregorianCalendar.class, c1286o);
        f fVar3 = this.f6111a;
        n nVar = n.c;
        fVar3.c(p050j.e.class, nVar);
        f fVar4 = this.f6111a;
        C1289s c1289s = C1289s.f6420a;
        fVar4.c(p050j.b.class, c1289s);
        this.f6111a.c(Map.class, nVar);
        this.f6111a.c(HashMap.class, nVar);
        this.f6111a.c(LinkedHashMap.class, nVar);
        this.f6111a.c(TreeMap.class, nVar);
        this.f6111a.c(ConcurrentMap.class, nVar);
        this.f6111a.c(ConcurrentHashMap.class, nVar);
        this.f6111a.c(Collection.class, c1289s);
        this.f6111a.c(List.class, c1289s);
        this.f6111a.c(ArrayList.class, c1289s);
        f fVar5 = this.f6111a;
        n nVar2 = n.b;
        fVar5.c(Object.class, nVar2);
        f fVar6 = this.f6111a;
        d0 d0Var = d0.f6407a;
        fVar6.c(String.class, d0Var);
        this.f6111a.c(StringBuffer.class, d0Var);
        this.f6111a.c(StringBuilder.class, d0Var);
        f fVar7 = this.f6111a;
        Class cls = Character.TYPE;
        C1288q c1288q = C1288q.f6418a;
        fVar7.c(cls, c1288q);
        this.f6111a.c(Character.class, c1288q);
        f fVar8 = this.f6111a;
        n nVar3 = n.d;
        fVar8.c(Byte.TYPE, nVar3);
        this.f6111a.c(Byte.class, nVar3);
        this.f6111a.c(Short.TYPE, nVar3);
        this.f6111a.c(Short.class, nVar3);
        f fVar9 = this.f6111a;
        Class cls2 = Integer.TYPE;
        C c = C.f6321a;
        fVar9.c(cls2, c);
        this.f6111a.c(Integer.class, c);
        f fVar10 = this.f6111a;
        Class cls3 = Long.TYPE;
        L l6 = L.f6338a;
        fVar10.c(cls3, l6);
        this.f6111a.c(Long.class, l6);
        this.f6111a.c(BigInteger.class, C1284m.f6415a);
        this.f6111a.c(BigDecimal.class, C1283l.f6414a);
        f fVar11 = this.f6111a;
        Class cls4 = Float.TYPE;
        A a6 = A.b;
        fVar11.c(cls4, a6);
        this.f6111a.c(Float.class, a6);
        this.f6111a.c(Double.TYPE, nVar3);
        this.f6111a.c(Double.class, nVar3);
        f fVar12 = this.f6111a;
        Class cls5 = Boolean.TYPE;
        C1285n c1285n = C1285n.f6416a;
        fVar12.c(cls5, c1285n);
        this.f6111a.c(Boolean.class, c1285n);
        this.f6111a.c(Class.class, n6);
        this.f6111a.c(char[].class, new C1287p());
        this.f6111a.c(AtomicBoolean.class, c1285n);
        this.f6111a.c(AtomicInteger.class, c);
        this.f6111a.c(AtomicLong.class, l6);
        f fVar13 = this.f6111a;
        V v6 = V.f6343a;
        fVar13.c(AtomicReference.class, v6);
        this.f6111a.c(WeakReference.class, v6);
        this.f6111a.c(SoftReference.class, v6);
        this.f6111a.c(UUID.class, n6);
        this.f6111a.c(TimeZone.class, n6);
        this.f6111a.c(Locale.class, n6);
        this.f6111a.c(Currency.class, n6);
        this.f6111a.c(InetAddress.class, n6);
        this.f6111a.c(Inet4Address.class, n6);
        this.f6111a.c(Inet6Address.class, n6);
        this.f6111a.c(InetSocketAddress.class, n6);
        this.f6111a.c(File.class, n6);
        this.f6111a.c(URI.class, n6);
        this.f6111a.c(URL.class, n6);
        this.f6111a.c(Pattern.class, n6);
        this.f6111a.c(Charset.class, n6);
        this.f6111a.c(r.class, n6);
        this.f6111a.c(Number.class, nVar3);
        f fVar14 = this.f6111a;
        C1278g c1278g = C1278g.f6411a;
        fVar14.c(AtomicIntegerArray.class, c1278g);
        this.f6111a.c(AtomicLongArray.class, c1278g);
        this.f6111a.c(StackTraceElement.class, n.e);
        this.f6111a.c(Serializable.class, nVar2);
        this.f6111a.c(Cloneable.class, nVar2);
        this.f6111a.c(Comparable.class, nVar2);
        this.f6111a.c(Closeable.class, nVar2);
        this.f6111a.c(p050j.f.class, new n(5));
        String[] strArr2 = f6105i;
        if (strArr2 != null) {
            for (String str : strArr2) {
                if (str != null && str.length() != 0) {
                    String[] strArr3 = this.f6112f;
                    int length = strArr3.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            String[] strArr4 = this.f6112f;
                            int length2 = strArr4.length;
                            String[] strArr5 = new String[length2 + 1];
                            System.arraycopy(strArr4, 0, strArr5, 0, strArr4.length);
                            strArr5[length2] = str;
                            this.f6112f = strArr5;
                            break;
                        }
                        if (str.equals(strArr3[i5])) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            }
        }
        if (strArr == null) {
            return;
        }
        for (String str2 : strArr) {
            if (str2 != null && str2.length() != 0) {
                String[] strArr6 = this.f6113g;
                int length3 = strArr6.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length3) {
                        String[] strArr7 = this.f6113g;
                        int length4 = strArr7.length;
                        String[] strArr8 = new String[length4 + 1];
                        System.arraycopy(strArr7, 0, strArr8, 0, strArr7.length);
                        strArr8[length4] = str2;
                        this.f6113g = strArr8;
                        break;
                    }
                    if (str2.equals(strArr6[i6])) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
        }
    }

    public static Field d(String str, HashMap map) {
        char cCharAt;
        Field field = (Field) map.get(str);
        if (field == null) {
            field = (Field) map.get("_" + str);
        }
        if (field == null) {
            field = (Field) map.get("m_" + str);
        }
        if (field != null || (cCharAt = str.charAt(0)) < 'a' || cCharAt > 'z') {
            return field;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = (char) (charArray[0] - ' ');
        return (Field) map.get(new String(charArray));
    }

    public static boolean e(Class cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void f(Class cls, HashMap map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return;
        }
        f(cls.getSuperclass(), map);
    }

    public final Class a(Class cls, String str) {
        Class<?> cls2 = null;
        if (str == null) {
            return null;
        }
        if (str.length() >= this.f6114h) {
            throw new d("autoType is not support. ".concat(str));
        }
        String strReplace = str.replace('$', '.');
        boolean z6 = this.e;
        int i5 = 0;
        if (z6 || cls != null) {
            int i6 = 0;
            while (true) {
                String[] strArr = this.f6113g;
                if (i6 >= strArr.length) {
                    int i7 = 0;
                    while (true) {
                        String[] strArr2 = this.f6112f;
                        if (i7 >= strArr2.length) {
                            break;
                        }
                        if (strReplace.startsWith(strArr2[i7])) {
                            throw new d("autoType is not support. ".concat(str));
                        }
                        i7++;
                    }
                } else {
                    if (strReplace.startsWith(strArr[i6])) {
                        return p096r.j.B(str);
                    }
                    i6++;
                }
            }
        }
        Class<?> clsB = (Class) p096r.j.f7928l.get(str);
        if (clsB == null) {
            loop0: for (a aVar : (a[]) this.f6111a.b) {
                if (aVar != null) {
                    for (a aVar2 = aVar; aVar2 != null; aVar2 = (a) aVar2.b) {
                        Object obj = aVar.c;
                        if (obj instanceof Class) {
                            Class<?> cls3 = (Class) obj;
                            if (cls3.getName().equals(str)) {
                                cls2 = cls3;
                                break loop0;
                            }
                        }
                    }
                }
            }
            clsB = cls2;
        }
        if (clsB != null) {
            if (cls == null || cls.isAssignableFrom(clsB)) {
                return clsB;
            }
            StringBuilder sbY = AbstractC0157z.y("type not match. ", str, " -> ");
            sbY.append(cls.getName());
            throw new d(sbY.toString());
        }
        if (!z6) {
            int i8 = 0;
            while (true) {
                String[] strArr3 = this.f6112f;
                if (i8 >= strArr3.length) {
                    while (true) {
                        String[] strArr4 = this.f6113g;
                        if (i5 >= strArr4.length) {
                            break;
                        }
                        if (strReplace.startsWith(strArr4[i5])) {
                            Class<?> clsB2 = p096r.j.B(str);
                            if (cls == null || !cls.isAssignableFrom(clsB2)) {
                                return clsB2;
                            }
                            StringBuilder sbY2 = AbstractC0157z.y("type not match. ", str, " -> ");
                            sbY2.append(cls.getName());
                            throw new d(sbY2.toString());
                        }
                        i5++;
                    }
                } else {
                    if (strReplace.startsWith(strArr3[i8])) {
                        throw new d("autoType is not support. ".concat(str));
                    }
                    i8++;
                }
            }
        }
        if (z6 || cls != null) {
            clsB = p096r.j.B(str);
        }
        if (clsB != null) {
            if (ClassLoader.class.isAssignableFrom(clsB) || DataSource.class.isAssignableFrom(clsB)) {
                throw new d("autoType is not support. ".concat(str));
            }
            if (cls != null) {
                if (cls.isAssignableFrom(clsB)) {
                    return clsB;
                }
                StringBuilder sbY3 = AbstractC0157z.y("type not match. ", str, " -> ");
                sbY3.append(cls.getName());
                throw new d(sbY3.toString());
            }
        }
        if (z6) {
            return clsB;
        }
        throw new d("autoType is not support. ".concat(str));
    }

    public final p b(Type type) {
        p pVar = (p) this.f6111a.a(type);
        if (pVar != null) {
            return pVar;
        }
        if (type instanceof Class) {
            return c(type, (Class) type);
        }
        if (!(type instanceof ParameterizedType)) {
            return n.b;
        }
        Type rawType = ((ParameterizedType) type).getRawType();
        return rawType instanceof Class ? c(type, (Class) rawType) : b(rawType);
    }

    /* JADX WARN: Code duplicated, block: B:171:0x02c2  */
    public final p c(Type type, Class cls) {
        p pVar;
        p mVar;
        p mVar2;
        p055k.b bVarC;
        Class clsBuilder;
        Class clsMappingTo;
        p pVar2 = C1280i.f6412a;
        f fVar = this.f6111a;
        p pVar3 = (p) fVar.a(type);
        if (pVar3 != null) {
            return pVar3;
        }
        if (type == null) {
            type = cls;
        }
        p pVar4 = (p) fVar.a(type);
        if (pVar4 != null) {
            return pVar4;
        }
        p055k.d dVar = (p055k.d) cls.getAnnotation(p055k.d.class);
        if (dVar != null && (clsMappingTo = dVar.mappingTo()) != Void.class) {
            return c(clsMappingTo, clsMappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            pVar4 = (p) fVar.a(cls);
        }
        if (pVar4 != null) {
            return pVar4;
        }
        String strReplace = cls.getName().replace('$', '.');
        if (strReplace.startsWith("java.awt.") && C1280i.g(cls) && !f6109m) {
            try {
                fVar.c(Class.forName("java.awt.Point"), pVar2);
                fVar.c(Class.forName("java.awt.Font"), pVar2);
                fVar.c(Class.forName("java.awt.Rectangle"), pVar2);
                fVar.c(Class.forName("java.awt.Color"), pVar2);
            } catch (Throwable unused) {
                f6109m = true;
            }
        } else {
            pVar2 = pVar4;
        }
        if (!f6110n) {
            try {
                if (strReplace.startsWith("java.time.")) {
                    Class<?> cls2 = Class.forName("java.time.LocalDateTime");
                    o oVar = o.f6191a;
                    fVar.c(cls2, oVar);
                    fVar.c(Class.forName("java.time.LocalDate"), oVar);
                    fVar.c(Class.forName("java.time.LocalTime"), oVar);
                    fVar.c(Class.forName("java.time.ZonedDateTime"), oVar);
                    fVar.c(Class.forName("java.time.OffsetDateTime"), oVar);
                    fVar.c(Class.forName("java.time.OffsetTime"), oVar);
                    fVar.c(Class.forName("java.time.ZoneOffset"), oVar);
                    fVar.c(Class.forName("java.time.ZoneRegion"), oVar);
                    fVar.c(Class.forName("java.time.ZoneId"), oVar);
                    fVar.c(Class.forName("java.time.Period"), oVar);
                    fVar.c(Class.forName("java.time.Duration"), oVar);
                    fVar.c(Class.forName("java.time.Instant"), oVar);
                    pVar = (p) fVar.a(cls);
                } else if (strReplace.startsWith("java.util.Optional")) {
                    Class<?> cls3 = Class.forName("java.util.Optional");
                    q qVar = q.f6207a;
                    fVar.c(cls3, qVar);
                    fVar.c(Class.forName("java.util.OptionalDouble"), qVar);
                    fVar.c(Class.forName("java.util.OptionalInt"), qVar);
                    fVar.c(Class.forName("java.util.OptionalLong"), qVar);
                    pVar = (p) fVar.a(cls);
                }
                pVar2 = pVar;
            } catch (Throwable unused2) {
                f6110n = true;
            }
        }
        boolean zEquals = strReplace.equals("java.nio.file.Path");
        N n6 = N.f6340a;
        if (zEquals) {
            fVar.c(cls, n6);
        }
        if (cls == Map.Entry.class) {
            fVar.c(cls, n6);
        }
        Class superclass = null;
        try {
            Iterator it = i.a(p073n.e.class, Thread.currentThread().getContextClassLoader()).iterator();
            if (it.hasNext()) {
                if (it.next() == null) {
                    throw null;
                }
                throw new ClassCastException();
            }
            if (pVar2 == null) {
                pVar2 = (p) fVar.a(type);
            }
            if (pVar2 != null) {
                return pVar2;
            }
            if (cls.isEnum()) {
                mVar = new h(cls);
            } else if (cls.isArray()) {
                mVar = P.f6341a;
            } else {
                p pVar5 = C1289s.f6420a;
                if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
                    mVar = pVar5;
                } else if (Map.class.isAssignableFrom(cls)) {
                    mVar = n.c;
                } else if (Throwable.class.isAssignableFrom(cls)) {
                    mVar = new t(this, g.b(cls, cls));
                } else {
                    boolean zA = this.b;
                    if (zA) {
                        p055k.d dVar2 = (p055k.d) cls.getAnnotation(p055k.d.class);
                        if (dVar2 != null) {
                            Class clsDeserializer = dVar2.deserializer();
                            if (clsDeserializer != Void.class) {
                                try {
                                    Object objNewInstance = clsDeserializer.newInstance();
                                    if (objNewInstance instanceof p) {
                                        pVar5 = (p) objNewInstance;
                                        mVar = pVar5;
                                    }
                                } catch (Throwable unused3) {
                                }
                            }
                            zA = dVar2.asm();
                        }
                        if (zA) {
                            if (dVar2 != null && (clsBuilder = dVar2.builder()) != Void.class) {
                                superclass = clsBuilder;
                            }
                            if (superclass == null) {
                                superclass = cls;
                            }
                            do {
                                if (!Modifier.isPublic(superclass.getModifiers())) {
                                    zA = false;
                                    break;
                                }
                                superclass = superclass.getSuperclass();
                                if (superclass == Object.class) {
                                    break;
                                }
                            } while (superclass != null);
                        }
                    }
                    if (cls.getTypeParameters().length != 0) {
                        zA = false;
                    }
                    b bVar = this.d;
                    if (zA && bVar != null) {
                        ClassLoader parent = bVar.f6185a;
                        parent.getClass();
                        ClassLoader classLoader = cls.getClassLoader();
                        if (classLoader != null) {
                            while (true) {
                                if (parent == null) {
                                    zA = false;
                                    break;
                                }
                                if (parent == classLoader) {
                                    break;
                                }
                                parent = parent.getParent();
                            }
                        }
                    }
                    if (zA) {
                        zA = c.a(cls.getSimpleName());
                    }
                    if (zA) {
                        if (cls.isInterface()) {
                            zA = false;
                        }
                        boolean z6 = p096r.j.f7921a;
                        g gVarB = g.b(type, cls);
                        p096r.d[] dVarArr = gVarB.f7915h;
                        if (zA && dVarArr.length > 200) {
                            zA = false;
                        }
                        Constructor constructor = gVarB.c;
                        if (zA && constructor == null && !cls.isInterface()) {
                            zA = false;
                        }
                        int length = dVarArr.length;
                        int i5 = 0;
                        while (i5 < length) {
                            p096r.d dVar3 = dVarArr[i5];
                            boolean z7 = dVar3.f7887h;
                            Member member = dVar3.c;
                            if (!z7) {
                                Class cls4 = dVar3.e;
                                if (Modifier.isPublic(cls4.getModifiers()) && (!cls4.isMemberClass() || Modifier.isStatic(cls4.getModifiers()))) {
                                    Method method = dVar3.b;
                                    if ((method != null ? method : member) == null) {
                                        bVarC = dVar3.c();
                                        if ((bVarC != null || (c.a(bVarC.name()) && bVarC.format().length() == 0 && bVarC.deserializeUsing() == Void.class)) && (!cls4.isEnum() || (b(cls4) instanceof h))) {
                                        }
                                    } else {
                                        if (method != null) {
                                            member = method;
                                        }
                                        if (c.a(member.getName())) {
                                            bVarC = dVar3.c();
                                            i5 = bVarC != null ? i5 + 1 : i5 + 1;
                                        }
                                    }
                                }
                            }
                            zA = false;
                            break;
                        }
                    }
                    if ((zA && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) ? false : zA) {
                        boolean z8 = p096r.j.f7921a;
                        g gVarB2 = g.b(type, cls);
                        try {
                            mVar2 = bVar.createJavaBeanDeserializer(this, gVarB2);
                        } catch (d unused4) {
                            mVar2 = new m(this, gVarB2);
                        } catch (NoSuchMethodException unused5) {
                            mVar = new m(this, g.b(type, cls));
                        } catch (Exception e) {
                            throw new d("create asm deserializer error, ".concat(cls.getName()), e);
                        }
                        mVar = mVar2;
                    } else {
                        mVar = new m(this, g.b(type, cls));
                    }
                }
            }
            fVar.c(type, mVar);
            return mVar;
        } catch (Exception unused6) {
        }
    }
}
