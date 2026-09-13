package p096r;

import androidx.collection.a;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.xmlbeans.XmlErrorCodes;
import p050j.e;
import p055k.b;
import p055k.d;
import p067m.c;
import p067m.g;
import p073n.m;
import p073n.p;
import p079o.C1286o;
import p079o.X;
import p079o.c0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f7921a;
    public static final boolean b;
    public static boolean c = true;
    public static boolean d = false;
    public static Method e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f7922f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f7923g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f7924h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Class f7925i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f7926j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Class f7927k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ConcurrentHashMap f7928l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Class f7929m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f7930n;

    static {
        try {
            f7921a = "true".equals(e.c("fastjson.compatibleWithJavaBean"));
            b = "true".equals(e.c("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16, 0.75f, 1);
        f7928l = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        concurrentHashMap.put("short", Short.TYPE);
        concurrentHashMap.put(XmlErrorCodes.INT, Integer.TYPE);
        concurrentHashMap.put(XmlErrorCodes.LONG, Long.TYPE);
        concurrentHashMap.put("float", Float.TYPE);
        concurrentHashMap.put(XmlErrorCodes.DOUBLE, Double.TYPE);
        concurrentHashMap.put("boolean", Boolean.TYPE);
        concurrentHashMap.put("char", Character.TYPE);
        concurrentHashMap.put("[byte", byte[].class);
        concurrentHashMap.put("[short", short[].class);
        concurrentHashMap.put("[int", int[].class);
        concurrentHashMap.put("[long", long[].class);
        concurrentHashMap.put("[float", float[].class);
        concurrentHashMap.put("[double", double[].class);
        concurrentHashMap.put("[boolean", boolean[].class);
        concurrentHashMap.put("[char", char[].class);
        concurrentHashMap.put("[B", byte[].class);
        concurrentHashMap.put("[S", short[].class);
        concurrentHashMap.put("[I", int[].class);
        concurrentHashMap.put("[J", long[].class);
        concurrentHashMap.put("[F", float[].class);
        concurrentHashMap.put("[D", double[].class);
        concurrentHashMap.put("[C", char[].class);
        concurrentHashMap.put("[Z", boolean[].class);
        Class[] clsArr = {Object.class, Cloneable.class, B("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, TimeUnit.class, ConcurrentHashMap.class, B("java.util.concurrent.ConcurrentSkipListMap"), B("java.util.concurrent.ConcurrentSkipListSet"), AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, e.class, B("java.awt.Rectangle"), B("java.awt.Point"), B("java.awt.Font"), B("java.awt.Color"), B("org.springframework.remoting.support.RemoteInvocation"), B("org.springframework.remoting.support.RemoteInvocationResult")};
        for (int i5 = 0; i5 < 64; i5++) {
            Class cls = clsArr[i5];
            if (cls != null) {
                concurrentHashMap.put(cls.getName(), cls);
            }
        }
        f7930n = false;
    }

    public static boolean A(Class cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            String name = cls2.getName();
            if (name.equals("net.sf.cglib.proxy.Factory") || name.equals("org.springframework.cglib.proxy.Factory") || name.equals("javassist.util.proxy.ProxyObject") || name.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                return true;
            }
        }
        return false;
    }

    public static Class B(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = f7928l;
        Class<?> cls = (Class) concurrentHashMap.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance((Class<?>) B(str.substring(1)), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return B(str.substring(1, str.length() - 1));
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                cls = contextClassLoader.loadClass(str);
                concurrentHashMap.put(str, cls);
                return cls;
            }
        } catch (Throwable unused) {
        }
        try {
            cls = Class.forName(str);
            concurrentHashMap.put(str, cls);
            return cls;
        } catch (Throwable unused2) {
            return cls;
        }
    }

    public static void C(AccessibleObject accessibleObject) {
        if (c && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                c = false;
            }
        }
    }

    public static Locale D(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length == 1) {
            return new Locale(strArrSplit[0]);
        }
        return strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static X a(Class cls) {
        int iA;
        String str;
        ArrayList arrayList;
        d dVar = (d) cls.getAnnotation(d.class);
        HashMap map = new HashMap();
        p067m.j.f(cls, map);
        ArrayList arrayListO = o(cls, map, false);
        d[] dVarArr = new d[arrayListO.size()];
        arrayListO.toArray(dVarArr);
        String[] strArr = null;
        if (dVar != null) {
            String[] strArrOrders = dVar.orders();
            String strTypeName = dVar.typeName();
            String str2 = strTypeName.length() != 0 ? strTypeName : null;
            iA = c0.a(dVar.serialzeFeatures());
            String str3 = str2;
            strArr = strArrOrders;
            str = str3;
        } else {
            iA = 0;
            str = null;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList = new ArrayList(arrayListO);
            Collections.sort(arrayList);
        } else {
            arrayList = o(cls, map, true);
        }
        d[] dVarArr2 = new d[arrayList.size()];
        arrayList.toArray(dVarArr2);
        return new X(cls, dVar, str, iA, dVarArr, Arrays.equals(dVarArr2, dVarArr) ? dVarArr : dVarArr2);
    }

    public static Object b(Object obj, Class cls, p067m.j jVar) {
        Calendar calendar;
        int i5;
        int i6;
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls != obj.getClass()) {
            if (!(obj instanceof Map)) {
                int i7 = 0;
                if (cls.isArray()) {
                    boolean z6 = true;
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        Object objNewInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            Array.set(objNewInstance, i7, b(it.next(), cls.getComponentType(), jVar));
                            i7++;
                        }
                        return objNewInstance;
                    }
                    if (cls == byte[].class) {
                        if (obj instanceof byte[]) {
                            return (byte[]) obj;
                        }
                        if (!(obj instanceof String)) {
                            throw new p050j.d(a.l(obj, "can not cast to int, value : "));
                        }
                        String str = (String) obj;
                        int[] iArr = e.f7910q;
                        int length = str.length();
                        if (length == 0) {
                            return new byte[0];
                        }
                        int i8 = length - 1;
                        int i9 = 0;
                        while (i9 < i8 && iArr[str.charAt(i9) & 255] < 0) {
                            i9++;
                        }
                        while (i8 > 0 && iArr[str.charAt(i8) & 255] < 0) {
                            i8--;
                        }
                        if (str.charAt(i8) == '=') {
                            i5 = str.charAt(i8 + (-1)) == '=' ? 2 : 1;
                        } else {
                            i5 = 0;
                        }
                        int i10 = (i8 - i9) + 1;
                        if (length > 76) {
                            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
                        } else {
                            i6 = 0;
                        }
                        int i11 = (((i10 - i6) * 6) >> 3) - i5;
                        byte[] bArr = new byte[i11];
                        int i12 = (i11 / 3) * 3;
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < i12) {
                            int i15 = i9 + 4;
                            int i16 = (iArr[str.charAt(i9 + 1)] << 12) | (iArr[str.charAt(i9)] << 18) | (iArr[str.charAt(i9 + 2)] << 6) | iArr[str.charAt(i9 + 3)];
                            boolean z7 = z6;
                            bArr[i13] = (byte) (i16 >> 16);
                            int i17 = i13 + 2;
                            bArr[i13 + 1] = (byte) (i16 >> 8);
                            i13 += 3;
                            bArr[i17] = (byte) i16;
                            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                                i9 = i15;
                            } else {
                                i9 += 6;
                                i14 = 0;
                            }
                            z6 = z7;
                        }
                        if (i13 < i11) {
                            int i18 = 0;
                            int i19 = 0;
                            while (i9 <= i8 - i5) {
                                i18 |= iArr[str.charAt(i9)] << (18 - (i19 * 6));
                                i19++;
                                i9++;
                            }
                            int i20 = 16;
                            while (i13 < i11) {
                                bArr[i13] = (byte) (i18 >> i20);
                                i20 -= 8;
                                i13++;
                            }
                        }
                        return bArr;
                    }
                }
                if (!cls.isAssignableFrom(obj.getClass())) {
                    if (cls == Boolean.TYPE || cls == Boolean.class) {
                        return f(obj);
                    }
                    if (cls == Byte.TYPE || cls == Byte.class) {
                        return g(obj);
                    }
                    if (cls == Short.TYPE || cls == Short.class) {
                        return n(obj);
                    }
                    if (cls == Integer.TYPE || cls == Integer.class) {
                        return k(obj);
                    }
                    if (cls == Long.TYPE || cls == Long.class) {
                        return m(obj);
                    }
                    if (cls == Float.TYPE || cls == Float.class) {
                        return j(obj);
                    }
                    if (cls == Double.TYPE || cls == Double.class) {
                        return i(obj);
                    }
                    if (cls == String.class) {
                        return obj.toString();
                    }
                    if (cls == BigDecimal.class) {
                        return d(obj);
                    }
                    if (cls == BigInteger.class) {
                        return e(obj);
                    }
                    if (cls == Date.class) {
                        return h(obj);
                    }
                    if (cls == java.sql.Date.class) {
                        if (obj instanceof java.sql.Date) {
                            return (java.sql.Date) obj;
                        }
                        if (obj instanceof Date) {
                            return new java.sql.Date(((Date) obj).getTime());
                        }
                        if (obj instanceof Calendar) {
                            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
                        }
                        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
                        if (obj instanceof String) {
                            String str2 = (String) obj;
                            if (str2.length() == 0 || AbstractC1127c.NULL.equals(str2) || "NULL".equals(str2)) {
                                return null;
                            }
                            if (z(str2)) {
                                jLongValue = Long.parseLong(str2);
                            } else {
                                g gVar = new g(str2);
                                if (!gVar.Q(false)) {
                                    throw new p050j.d("can not cast to Timestamp, value : ".concat(str2));
                                }
                                jLongValue = gVar.f6097j.getTime().getTime();
                            }
                        }
                        if (jLongValue > 0) {
                            return new java.sql.Date(jLongValue);
                        }
                        throw new p050j.d(a.l(obj, "can not cast to Date, value : "));
                    }
                    if (cls == Timestamp.class) {
                        if (obj instanceof Calendar) {
                            return new Timestamp(((Calendar) obj).getTimeInMillis());
                        }
                        if (obj instanceof Timestamp) {
                            return (Timestamp) obj;
                        }
                        if (obj instanceof Date) {
                            return new Timestamp(((Date) obj).getTime());
                        }
                        long jLongValue2 = obj instanceof Number ? ((Number) obj).longValue() : 0L;
                        if (obj instanceof String) {
                            String str3 = (String) obj;
                            if (str3.length() == 0 || AbstractC1127c.NULL.equals(str3) || "NULL".equals(str3)) {
                                return null;
                            }
                            if (z(str3)) {
                                jLongValue2 = Long.parseLong(str3);
                            } else {
                                g gVar2 = new g(str3);
                                if (!gVar2.Q(false)) {
                                    throw new p050j.d("can not cast to Timestamp, value : ".concat(str3));
                                }
                                jLongValue2 = gVar2.f6097j.getTime().getTime();
                            }
                        }
                        if (jLongValue2 > 0) {
                            return new Timestamp(jLongValue2);
                        }
                        throw new p050j.d(a.l(obj, "can not cast to Timestamp, value : "));
                    }
                    if (cls.isEnum()) {
                        try {
                            if (obj instanceof String) {
                                String str4 = (String) obj;
                                if (str4.length() == 0) {
                                    return null;
                                }
                                return Enum.valueOf(cls, str4);
                            }
                            if (obj instanceof Number) {
                                int iIntValue = ((Number) obj).intValue();
                                Object[] enumConstants = cls.getEnumConstants();
                                if (iIntValue < enumConstants.length) {
                                    return enumConstants[iIntValue];
                                }
                            }
                            throw new p050j.d("can not cast to : ".concat(cls.getName()));
                        } catch (Exception e6) {
                            throw new p050j.d("can not cast to : ".concat(cls.getName()), e6);
                        }
                    }
                    if (Calendar.class.isAssignableFrom(cls)) {
                        Date dateH = h(obj);
                        if (cls == Calendar.class) {
                            calendar = Calendar.getInstance(p050j.a.f5372a, p050j.a.b);
                        } else {
                            try {
                                calendar = (Calendar) cls.newInstance();
                            } catch (Exception e7) {
                                throw new p050j.d("can not cast to : ".concat(cls.getName()), e7);
                            }
                        }
                        calendar.setTime(dateH);
                        return calendar;
                    }
                    if (cls.getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        Date dateH2 = h(obj);
                        Calendar calendar2 = Calendar.getInstance(p050j.a.f5372a, p050j.a.b);
                        calendar2.setTime(dateH2);
                        return C1286o.b.c(calendar2);
                    }
                    if (obj instanceof String) {
                        String str5 = (String) obj;
                        if (str5.length() == 0 || AbstractC1127c.NULL.equals(str5) || "NULL".equals(str5)) {
                            return null;
                        }
                        if (cls == Currency.class) {
                            return Currency.getInstance(str5);
                        }
                        if (cls == Locale.class) {
                            return D(str5);
                        }
                    }
                    throw new p050j.d("can not cast to : ".concat(cls.getName()));
                }
            } else if (cls != Map.class) {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(p050j.a.c)) {
                    return l(map, cls, jVar);
                }
            }
        }
        return obj;
    }

    public static Object c(Object obj, Type type, p067m.j jVar) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return b(obj, (Class) type, jVar);
        }
        if (!(type instanceof ParameterizedType)) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || AbstractC1127c.NULL.equals(str) || "NULL".equals(str)) {
                    return null;
                }
            }
            if (type instanceof TypeVariable) {
                return obj;
            }
            throw new p050j.d("can not cast to : " + type);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                Collection hashSet = (rawType == Set.class || rawType == HashSet.class) ? new HashSet() : rawType == TreeSet.class ? new TreeSet() : new ArrayList();
                Iterator it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    hashSet.add(c(it.next(), type2, jVar));
                }
                return hashSet;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                HashMap map = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    map.put(c(entry.getKey(), type3, jVar), c(entry.getValue(), type4, jVar));
                }
                return map;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return c(obj, rawType, jVar);
        }
        throw new p050j.d("can not cast to : " + parameterizedType);
    }

    public static BigDecimal d(Object obj) {
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String string = obj.toString();
        if (string.length() == 0) {
            return null;
        }
        return new BigDecimal(string);
    }

    public static BigInteger e(Object obj) {
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String string = obj.toString();
        if (string.length() == 0 || AbstractC1127c.NULL.equals(string) || "NULL".equals(string)) {
            return null;
        }
        return new BigInteger(string);
    }

    public static Boolean f(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || AbstractC1127c.NULL.equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new p050j.d(a.l(obj, "can not cast to boolean, value : "));
    }

    public static Byte g(Object obj) {
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (!(obj instanceof String)) {
            throw new p050j.d(a.l(obj, "can not cast to byte, value : "));
        }
        String str = (String) obj;
        if (str.length() == 0 || AbstractC1127c.NULL.equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Byte.valueOf(Byte.parseByte(str));
    }

    public static Date h(Object obj) {
        long j6;
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strG = (String) obj;
            g gVar = new g(strG);
            try {
                if (gVar.Q(false)) {
                    Date time = gVar.f6097j.getTime();
                    gVar.close();
                    return time;
                }
                gVar.close();
                if (strG.startsWith("/Date(") && strG.endsWith(")/")) {
                    strG = a.g(2, 6, strG);
                }
                if (strG.indexOf(45) != -1) {
                    int length = strG.length();
                    String str = p050j.a.e;
                    if (length != str.length()) {
                        if (strG.length() == 10) {
                            str = "yyyy-MM-dd";
                        } else {
                            str = strG.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss.SSS";
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, p050j.a.b);
                    simpleDateFormat.setTimeZone(p050j.a.f5372a);
                    try {
                        return simpleDateFormat.parse(strG);
                    } catch (ParseException unused) {
                        throw new p050j.d("can not cast to Date, value : ".concat(strG));
                    }
                }
                if (strG.length() == 0) {
                    return null;
                }
                j6 = Long.parseLong(strG);
            } catch (Throwable th) {
                gVar.close();
                throw th;
            }
        } else {
            j6 = -1;
        }
        if (j6 >= 0) {
            return new Date(j6);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (e == null && !d) {
                try {
                    e = cls.getMethod("toJdbc", null);
                } catch (NoSuchMethodException unused2) {
                } finally {
                    d = true;
                }
            }
            try {
                return (Date) e.invoke(obj, null);
            } catch (Exception e6) {
                throw new p050j.d("can not cast oracle.sql.TIMESTAMP to Date", e6);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new p050j.d(a.l(obj, "can not cast to Date, value : "));
        }
        if (f7923g == null && !f7922f) {
            try {
                f7923g = cls.getMethod("toJdbc", null);
            } catch (NoSuchMethodException unused3) {
            } finally {
                f7922f = true;
            }
        }
        try {
            return (Date) f7923g.invoke(obj, null);
        } catch (Exception e7) {
            throw new p050j.d("can not cast oracle.sql.DATE to Date", e7);
        }
    }

    public static Double i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            throw new p050j.d(a.l(obj, "can not cast to double, value : "));
        }
        String string = obj.toString();
        if (string.length() == 0 || AbstractC1127c.NULL.equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != 0) {
            string = string.replaceAll(",", "");
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    public static Float j(Object obj) {
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            throw new p050j.d(a.l(obj, "can not cast to float, value : "));
        }
        String string = obj.toString();
        if (string.length() == 0 || AbstractC1127c.NULL.equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != 0) {
            string = string.replaceAll(",", "");
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static Integer k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || AbstractC1127c.NULL.equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != 0) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            return Integer.valueOf(Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return k(it.next());
            }
        }
        throw new p050j.d(a.l(obj, "can not cast to int, value : "));
    }

    public static Object l(Map map, Class cls, p067m.j jVar) {
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                return new StackTraceElement(str, str2, str3, number == null ? 0 : number.intValue());
            }
            Object obj = map.get(p050j.a.c);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (jVar == null) {
                    jVar = p067m.j.f6108l;
                }
                Class clsA = jVar.a(null, str4);
                if (clsA == null) {
                    throw new ClassNotFoundException(str4.concat(" not found"));
                }
                if (!clsA.equals(cls)) {
                    return l(map, clsA, jVar);
                }
            }
            if (cls.isInterface()) {
                return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, map instanceof e ? (e) map : new e(map));
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return new Locale(str5);
                    }
                }
            }
            if (jVar == null) {
                jVar = p067m.j.f6108l;
            }
            p pVarB = jVar.b(cls);
            m mVar = pVarB instanceof m ? (m) pVarB : null;
            if (mVar != null) {
                return mVar.createInstance(map, jVar);
            }
            throw new p050j.d("can not get javaBeanDeserializer. ".concat(cls.getName()));
        } catch (Exception e6) {
            throw new p050j.d(e6.getMessage(), e6);
        }
    }

    public static Long m(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || AbstractC1127c.NULL.equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != 0) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(strReplaceAll));
            } catch (NumberFormatException unused) {
                g gVar = new g(strReplaceAll);
                Calendar calendar = gVar.Q(false) ? gVar.f6097j : null;
                gVar.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return m(it.next());
            }
        }
        throw new p050j.d(a.l(obj, "can not cast to long, value : "));
    }

    public static Short n(Object obj) {
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (!(obj instanceof String)) {
            throw new p050j.d(a.l(obj, "can not cast to short, value : "));
        }
        String str = (String) obj;
        if (str.length() == 0 || AbstractC1127c.NULL.equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Short.valueOf(Short.parseShort(str));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:104:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:159:0x0315  */
    /* JADX WARN: Code duplicated, block: B:210:0x02f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0028  */
    /* JADX WARN: Code duplicated, block: B:80:0x0180  */
    /* JADX WARN: Code duplicated, block: B:82:0x0186  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:92:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:94:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:97:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:99:0x01de  */
    public static ArrayList o(Class cls, HashMap map, boolean z6) {
        String[] strArrOrders;
        int i5;
        int i6;
        int i7;
        String strLabel;
        int i8;
        int i9;
        Method method;
        int iOrdinal;
        int iA;
        int iA2;
        Method method2;
        String str;
        int i10;
        String strSubstring;
        b bVar;
        int i11;
        String strName;
        Field fieldD;
        Method method3;
        int i12;
        b bVar2;
        char cCharAt;
        Class cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Method[] methods = cls2.getMethods();
        int length = methods.length;
        int i13 = 0;
        while (true) {
            b bVar3 = null;
            if (i13 >= length) {
                break;
            }
            Method method4 = methods[i13];
            String name = method4.getName();
            if (Modifier.isStatic(method4.getModifiers()) || method4.getReturnType().equals(Void.TYPE) || method4.getParameterTypes().length != 0 || method4.getReturnType() == ClassLoader.class || (method4.getName().equals("getMetaClass") && method4.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                i9 = i13;
                methods = methods;
                length = length;
            } else {
                b bVarW = (b) method4.getAnnotation(b.class);
                if (bVarW == null) {
                    bVarW = w(cls2, method4);
                }
                b bVar4 = bVarW;
                String strLabel2 = null;
                if (bVar4 != null) {
                    if (bVar4.serialize()) {
                        iOrdinal = bVar4.ordinal();
                        iA = c0.a(bVar4.serialzeFeatures());
                        iA2 = c.a(bVar4.parseFeatures());
                        if (bVar4.name().length() != 0) {
                            String strName2 = bVar4.name();
                            i9 = i13;
                            linkedHashMap.put(strName2, new d(strName2, method4, null, cls2, null, iOrdinal, iA, iA2, bVar4, null, null));
                        } else {
                            i9 = i13;
                            method = method4;
                            if (bVar4.label().length() != 0) {
                                strLabel2 = bVar4.label();
                            }
                        }
                    } else {
                        i9 = i13;
                    }
                    methods = methods;
                    length = length;
                } else {
                    i9 = i13;
                    method = method4;
                    iOrdinal = 0;
                    iA = 0;
                    iA2 = 0;
                }
                boolean zStartsWith = name.startsWith("get");
                boolean z7 = b;
                boolean z8 = f7921a;
                if (zStartsWith) {
                    if (name.length() >= 4 && !name.equals("getClass") && (!name.equals("getDeclaringClass") || !cls2.isEnum())) {
                        char cCharAt2 = name.charAt(3);
                        if (Character.isUpperCase(cCharAt2)) {
                            i11 = 3;
                        } else if (cCharAt2 > 512) {
                            i11 = 3;
                        } else {
                            if (cCharAt2 == '_') {
                                strName = name.substring(4);
                            } else if (cCharAt2 == 'f') {
                                strName = name.substring(3);
                            } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                strName = p(name.substring(3));
                            }
                            if (!y(cls2, strName)) {
                                fieldD = p067m.j.d(strName, map);
                                if (fieldD == null) {
                                    method3 = method;
                                    if (strName.length() <= 1 && (cCharAt = strName.charAt(1)) >= 'A' && cCharAt <= 'Z') {
                                        i12 = 3;
                                        fieldD = p067m.j.d(p(name.substring(3)), map);
                                    }
                                    if (fieldD != null) {
                                        bVar2 = (b) fieldD.getAnnotation(b.class);
                                        if (bVar2 != null) {
                                            if (!bVar2.serialize()) {
                                                iOrdinal = bVar2.ordinal();
                                                iA = c0.a(bVar2.serialzeFeatures());
                                                iA2 = c.a(bVar2.parseFeatures());
                                                if (bVar2.name().length() != 0) {
                                                    strName = bVar2.name();
                                                }
                                                if (bVar2.label().length() != 0) {
                                                    strLabel2 = bVar2.label();
                                                }
                                            }
                                        }
                                    } else {
                                        bVar2 = null;
                                    }
                                    str = name;
                                    method2 = method3;
                                    i10 = i12;
                                    linkedHashMap.put(strName, new d(strName, method2, fieldD, cls2, null, iOrdinal, iA, iA2, bVar4, bVar2, strLabel2));
                                } else {
                                    method3 = method;
                                }
                                i12 = 3;
                                if (fieldD != null) {
                                    bVar2 = (b) fieldD.getAnnotation(b.class);
                                    if (bVar2 != null) {
                                        if (!bVar2.serialize()) {
                                            iOrdinal = bVar2.ordinal();
                                            iA = c0.a(bVar2.serialzeFeatures());
                                            iA2 = c.a(bVar2.parseFeatures());
                                            if (bVar2.name().length() != 0) {
                                                strName = bVar2.name();
                                            }
                                            if (bVar2.label().length() != 0) {
                                                strLabel2 = bVar2.label();
                                            }
                                        }
                                    }
                                } else {
                                    bVar2 = null;
                                }
                                str = name;
                                method2 = method3;
                                i10 = i12;
                                linkedHashMap.put(strName, new d(strName, method2, fieldD, cls2, null, iOrdinal, iA, iA2, bVar4, bVar2, strLabel2));
                            }
                        }
                        strName = z8 ? p(name.substring(i11)) : Character.toLowerCase(name.charAt(i11)) + name.substring(4);
                        if (z7 && !map.containsKey(strName)) {
                            String strSubstring2 = name.substring(3);
                            if (map.containsKey(strSubstring2)) {
                                strName = strSubstring2;
                            }
                        }
                        if (!y(cls2, strName)) {
                            fieldD = p067m.j.d(strName, map);
                            if (fieldD == null) {
                                method3 = method;
                                if (strName.length() <= 1) {
                                }
                                if (fieldD != null) {
                                    bVar2 = (b) fieldD.getAnnotation(b.class);
                                    if (bVar2 != null) {
                                        if (!bVar2.serialize()) {
                                            iOrdinal = bVar2.ordinal();
                                            iA = c0.a(bVar2.serialzeFeatures());
                                            iA2 = c.a(bVar2.parseFeatures());
                                            if (bVar2.name().length() != 0) {
                                                strName = bVar2.name();
                                            }
                                            if (bVar2.label().length() != 0) {
                                                strLabel2 = bVar2.label();
                                            }
                                        }
                                    }
                                } else {
                                    bVar2 = null;
                                }
                                str = name;
                                method2 = method3;
                                i10 = i12;
                                linkedHashMap.put(strName, new d(strName, method2, fieldD, cls2, null, iOrdinal, iA, iA2, bVar4, bVar2, strLabel2));
                            } else {
                                method3 = method;
                            }
                            i12 = 3;
                            if (fieldD != null) {
                                bVar2 = (b) fieldD.getAnnotation(b.class);
                                if (bVar2 != null) {
                                    if (!bVar2.serialize()) {
                                        iOrdinal = bVar2.ordinal();
                                        iA = c0.a(bVar2.serialzeFeatures());
                                        iA2 = c.a(bVar2.parseFeatures());
                                        if (bVar2.name().length() != 0) {
                                            strName = bVar2.name();
                                        }
                                        if (bVar2.label().length() != 0) {
                                            strLabel2 = bVar2.label();
                                        }
                                    }
                                }
                            } else {
                                bVar2 = null;
                            }
                            str = name;
                            method2 = method3;
                            i10 = i12;
                            linkedHashMap.put(strName, new d(strName, method2, fieldD, cls2, null, iOrdinal, iA, iA2, bVar4, bVar2, strLabel2));
                        }
                    }
                    methods = methods;
                    length = length;
                } else {
                    method2 = method;
                    str = name;
                    i10 = 3;
                }
                if (str.startsWith("is") && str.length() >= i10 && (method2.getReturnType() == Boolean.TYPE || method2.getReturnType() == Boolean.class)) {
                    char cCharAt3 = str.charAt(2);
                    if (Character.isUpperCase(cCharAt3)) {
                        strSubstring = z8 ? p(str.substring(2)) : Character.toLowerCase(str.charAt(2)) + str.substring(i10);
                        if (z7 && !map.containsKey(strSubstring)) {
                            String strSubstring3 = str.substring(2);
                            if (map.containsKey(strSubstring3)) {
                                strSubstring = strSubstring3;
                            }
                        }
                    } else if (cCharAt3 == '_') {
                        strSubstring = str.substring(i10);
                    } else if (cCharAt3 == 'f') {
                        strSubstring = str.substring(2);
                    }
                    Field fieldD2 = p067m.j.d(strSubstring, map);
                    if (fieldD2 == null) {
                        fieldD2 = p067m.j.d(str, map);
                    }
                    Field field = fieldD2;
                    if (field == null || (bVar3 = (b) field.getAnnotation(b.class)) == null) {
                        bVar = bVar3;
                        if (linkedHashMap.containsKey(strSubstring)) {
                            linkedHashMap.put(strSubstring, new d(strSubstring, method2, field, cls, null, iOrdinal, iA, iA2, bVar4, bVar, strLabel2));
                        }
                    } else if (bVar3.serialize()) {
                        iOrdinal = bVar3.ordinal();
                        iA = c0.a(bVar3.serialzeFeatures());
                        iA2 = c.a(bVar3.parseFeatures());
                        if (bVar3.name().length() != 0) {
                            strSubstring = bVar3.name();
                        }
                        if (bVar3.label().length() != 0) {
                            strLabel2 = bVar3.label();
                        }
                        bVar = bVar3;
                        if (linkedHashMap.containsKey(strSubstring)) {
                            linkedHashMap.put(strSubstring, new d(strSubstring, method2, field, cls, null, iOrdinal, iA, iA2, bVar4, bVar, strLabel2));
                        }
                    }
                }
            }
            i13 = i9 + 1;
            cls2 = cls;
            length = length;
            methods = methods;
        }
        boolean z9 = true;
        Field[] fields = cls.getFields();
        int length2 = fields.length;
        int i14 = 0;
        while (i14 < length2) {
            Field field2 = fields[i14];
            if (Modifier.isStatic(field2.getModifiers())) {
                i8 = i14;
            } else {
                b bVar5 = (b) field2.getAnnotation(b.class);
                String name2 = field2.getName();
                if (bVar5 == null) {
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    strLabel = null;
                } else if (bVar5.serialize()) {
                    int iOrdinal2 = bVar5.ordinal();
                    int iA3 = c0.a(bVar5.serialzeFeatures());
                    int iA4 = c.a(bVar5.parseFeatures());
                    if (bVar5.name().length() != 0) {
                        name2 = bVar5.name();
                    }
                    if (bVar5.label().length() != 0) {
                        i7 = iA4;
                        strLabel = bVar5.label();
                        i5 = iOrdinal2;
                        i6 = iA3;
                    } else {
                        i6 = iA3;
                        i7 = iA4;
                        strLabel = null;
                        i5 = iOrdinal2;
                    }
                } else {
                    i8 = i14;
                }
                if (linkedHashMap.containsKey(name2)) {
                    i8 = i14;
                } else {
                    int i15 = i14;
                    String str2 = name2;
                    i8 = i15;
                    linkedHashMap.put(str2, new d(str2, null, field2, cls, null, i5, i6, i7, null, bVar5, strLabel));
                }
            }
            i14 = i8 + 1;
            z9 = z9;
        }
        boolean z10 = z9;
        ArrayList arrayList = new ArrayList();
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar != null) {
            strArrOrders = dVar.orders();
            if (strArrOrders == null || strArrOrders.length != linkedHashMap.size()) {
                z10 = false;
                break;
            }
            for (String str3 : strArrOrders) {
                if (!linkedHashMap.containsKey(str3)) {
                    z10 = false;
                    break;
                }
            }
        } else {
            z10 = false;
            strArrOrders = null;
        }
        if (z10) {
            for (String str4 : strArrOrders) {
                arrayList.add((d) linkedHashMap.get(str4));
            }
        } else {
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add((d) it.next());
            }
            if (z6) {
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public static String p(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Class q(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return q(((ParameterizedType) type).getRawType());
        }
        return type instanceof TypeVariable ? (Class) ((TypeVariable) type).getBounds()[0] : Object.class;
    }

    public static Class r(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new p050j.d("can not create ASMParser");
        }
        Class cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new p050j.d("can not create ASMParser");
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    public static Type s(Type type) {
        Type typeS;
        if (type instanceof ParameterizedType) {
            typeS = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (typeS instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) typeS).getUpperBounds();
                if (upperBounds.length == 1) {
                    typeS = upperBounds[0];
                }
            }
        } else if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.getName().startsWith("java.")) {
                typeS = null;
            } else {
                typeS = s(cls.getGenericSuperclass());
            }
        } else {
            typeS = null;
        }
        return typeS == null ? Object.class : typeS;
    }

    public static Field t(Class cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return t(superclass, str, superclass.getDeclaredFields());
    }

    public static Type u(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? u(((Class) type).getGenericSuperclass()) : type;
    }

    public static Class v(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return v(((ParameterizedType) type).getRawType());
        }
        throw new p050j.d("TODO");
    }

    public static b w(Class cls, Method method) {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= parameterTypes.length) {
                                b bVar = (b) method2.getAnnotation(b.class);
                                if (bVar == null) {
                                    break;
                                }
                                return bVar;
                            }
                            if (!parameterTypes2[i5].equals(parameterTypes[i5])) {
                                break;
                            }
                            i5++;
                        }
                    }
                }
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass == null || !Modifier.isAbstract(superclass.getModifiers())) {
            return null;
        }
        Class<?>[] parameterTypes3 = method.getParameterTypes();
        for (Method method3 : superclass.getMethods()) {
            Class<?>[] parameterTypes4 = method3.getParameterTypes();
            if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                int i6 = 0;
                while (true) {
                    if (i6 >= parameterTypes3.length) {
                        b bVar2 = (b) method3.getAnnotation(b.class);
                        if (bVar2 == null) {
                            break;
                        }
                        return bVar2;
                    }
                    if (!parameterTypes4[i6].equals(parameterTypes3[i6])) {
                        break;
                    }
                    i6++;
                }
            }
        }
        return null;
    }

    public static boolean x(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class) || (genericSuperclass = ((Class) type).getGenericSuperclass()) == Object.class) {
            return false;
        }
        return x(genericSuperclass);
    }

    public static boolean y(Class cls, String str) {
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar != null) {
            String[] strArrIncludes = dVar.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : dVar.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !y(cls.getSuperclass(), str)) ? false : true;
    }

    public static boolean z(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i5 != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }
}
