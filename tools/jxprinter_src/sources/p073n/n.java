package p073n;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.logging.log4j.util.Chars;
import p050j.a;
import p050j.d;
import p050j.e;
import p050j.f;
import p067m.b;
import p067m.c;
import p067m.g;
import p067m.h;
import p067m.i;
import p067m.j;
import p067m.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements p {
    public static final n b = new n(0);
    public static final n c = new n(1);
    public static final n d = new n(2);
    public static final n e = new n(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f6189f = new n(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6190a;

    public /* synthetic */ n(int i5) {
        this.f6190a = i5;
    }

    public static Map c(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : c(rawType);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new d("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e6) {
            throw new d("unsupport type " + type, e6);
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0271 A[Catch: all -> 0x01ed, TRY_LEAVE, TryCatch #0 {all -> 0x01ed, blocks: (B:99:0x01de, B:101:0x01e4, B:108:0x01f3, B:111:0x01f9, B:113:0x0204, B:115:0x0210, B:117:0x021c, B:119:0x0227, B:121:0x0231, B:123:0x0238, B:125:0x0244, B:135:0x026a, B:137:0x0271, B:140:0x027a, B:141:0x0281, B:127:0x024b, B:130:0x0254, B:133:0x025a, B:134:0x025d, B:142:0x0282, B:143:0x029e, B:145:0x02a0, B:147:0x02a6, B:149:0x02aa, B:151:0x02b6, B:153:0x02c0, B:155:0x02ce, B:158:0x02d5, B:161:0x02e1, B:163:0x02eb, B:165:0x0302, B:166:0x030b, B:167:0x0323), top: B:172:0x01de }] */
    /* JADX WARN: Code duplicated, block: B:140:0x027a A[Catch: all -> 0x01ed, TRY_ENTER, TryCatch #0 {all -> 0x01ed, blocks: (B:99:0x01de, B:101:0x01e4, B:108:0x01f3, B:111:0x01f9, B:113:0x0204, B:115:0x0210, B:117:0x021c, B:119:0x0227, B:121:0x0231, B:123:0x0238, B:125:0x0244, B:135:0x026a, B:137:0x0271, B:140:0x027a, B:141:0x0281, B:127:0x024b, B:130:0x0254, B:133:0x025a, B:134:0x025d, B:142:0x0282, B:143:0x029e, B:145:0x02a0, B:147:0x02a6, B:149:0x02aa, B:151:0x02b6, B:153:0x02c0, B:155:0x02ce, B:158:0x02d5, B:161:0x02e1, B:163:0x02eb, B:165:0x0302, B:166:0x030b, B:167:0x0323), top: B:172:0x01de }] */
    public static Object d(Object obj, Type type, Map map, b bVar) {
        int i5;
        Object obj2;
        String strG;
        Object objL;
        j jVar = bVar.b;
        g gVar = bVar.e;
        if (!(type instanceof ParameterizedType)) {
            return bVar.m(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = parameterizedType.getActualTypeArguments()[1];
        int i6 = 16;
        if (String.class == type2) {
            k kVar = bVar.f6066a;
            if (gVar.f6092a != 12) {
                throw new d("syntax error, expect {, actual " + gVar.f6092a);
            }
            i iVar = bVar.f6067f;
            int i7 = 0;
            while (true) {
                try {
                    gVar.I();
                    char c6 = gVar.d;
                    if (gVar.i(c.AllowArbitraryCommas.f6089a)) {
                        while (c6 == ',') {
                            gVar.l();
                            gVar.I();
                            c6 = gVar.d;
                        }
                    }
                    if (c6 == '\"') {
                        strG = gVar.F(kVar, Chars.DQUOTE);
                        gVar.I();
                        if (gVar.d != ':') {
                            throw new d("expect ':' at " + gVar.b);
                        }
                    } else {
                        if (c6 == '}') {
                            gVar.l();
                            gVar.f6094g = 0;
                            gVar.n(i6);
                            bVar.r(iVar);
                            return map;
                        }
                        if (c6 == '\'') {
                            if (!gVar.i(c.AllowSingleQuotes.f6089a)) {
                                throw new d("syntax error");
                            }
                            strG = gVar.F(kVar, Chars.QUOTE);
                            gVar.I();
                            if (gVar.d != ':') {
                                throw new d("expect ':' at " + gVar.b);
                            }
                        } else {
                            if (!gVar.i(c.AllowUnQuotedFieldNames.f6089a)) {
                                throw new d("syntax error");
                            }
                            strG = gVar.G(kVar);
                            gVar.I();
                            char c7 = gVar.d;
                            if (c7 != ':') {
                                throw new d("expect ':' at " + gVar.b + ", actual " + c7);
                            }
                        }
                    }
                    gVar.l();
                    gVar.I();
                    gVar.f6094g = 0;
                    if (strG != a.c || gVar.i(c.DisableSpecialKeyDetect.f6089a)) {
                        gVar.m();
                        if (i7 != 0) {
                            bVar.r(iVar);
                        }
                        if (gVar.f6092a == 8) {
                            gVar.m();
                            objL = null;
                        } else {
                            objL = bVar.l(strG, type3);
                        }
                        map.put(strG, objL);
                        bVar.d(map, strG);
                        bVar.q(iVar, objL, strG);
                        bVar.r(iVar);
                        int i8 = gVar.f6092a;
                        if (i8 != 20 && i8 != 15) {
                            if (i8 == 13) {
                                gVar.m();
                                bVar.r(iVar);
                                return map;
                            }
                        }
                        bVar.r(iVar);
                        return map;
                    }
                    Class clsA = jVar.a(null, gVar.F(kVar, Chars.DQUOTE));
                    if (!Map.class.isAssignableFrom(clsA)) {
                        p pVarB = jVar.b(clsA);
                        gVar.n(16);
                        bVar.f6071j = 2;
                        if (iVar != null && !(obj instanceof Integer)) {
                            bVar.o();
                        }
                        Map map2 = (Map) pVarB.b(bVar, clsA, obj);
                        bVar.r(iVar);
                        return map2;
                    }
                    gVar.n(16);
                    if (gVar.f6092a == 13) {
                        gVar.n(16);
                        bVar.r(iVar);
                        return map;
                    }
                    i7++;
                    i6 = 16;
                } catch (Throwable th) {
                    bVar.r(iVar);
                    throw th;
                }
            }
        } else {
            int i9 = gVar.f6092a;
            if (i9 != 12 && i9 != 16) {
                throw new d("syntax error, expect {, actual ".concat(h.a(gVar.f6092a)));
            }
            p pVarB2 = jVar.b(type2);
            p pVarB3 = jVar.b(type3);
            gVar.n(pVarB2.a());
            i iVar2 = bVar.f6067f;
            while (true) {
                try {
                    int i10 = gVar.f6092a;
                    if (i10 == 13) {
                        gVar.n(16);
                        bVar.r(iVar2);
                        return map;
                    }
                    if (i10 == 4 && gVar.f6094g == 4 && gVar.b(gVar.f6095h + 1) == '$') {
                        if (gVar.b(gVar.f6095h + 2) == 'r' && gVar.b(gVar.f6095h + 3) == 'e' && gVar.b(gVar.f6095h + 4) == 'f' && !gVar.i(c.DisableSpecialKeyDetect.f6089a)) {
                            gVar.o();
                            if (gVar.f6092a != 4) {
                                throw new d("illegal ref, " + h.a(gVar.f6092a));
                            }
                            String strJ = gVar.J();
                            if (!"..".equals(strJ)) {
                                if ("$".equals(strJ)) {
                                    i iVar3 = iVar2;
                                    while (true) {
                                        i iVar4 = iVar3.b;
                                        if (iVar4 == null) {
                                            break;
                                        }
                                        iVar3 = iVar4;
                                    }
                                    obj2 = iVar3.f6104a;
                                } else {
                                    bVar.b(new p067m.a(iVar2, strJ));
                                    bVar.f6071j = 1;
                                    i5 = 13;
                                    obj2 = null;
                                }
                                gVar.n(i5);
                                if (gVar.f6092a == i5) {
                                    throw new d("illegal ref");
                                }
                                gVar.n(16);
                                bVar.r(iVar2);
                                return obj2;
                            }
                            obj2 = iVar2.b.f6104a;
                            i5 = 13;
                            gVar.n(i5);
                            if (gVar.f6092a == i5) {
                                throw new d("illegal ref");
                            }
                            gVar.n(16);
                            bVar.r(iVar2);
                            return obj2;
                        }
                    }
                    if (map.size() == 0 && gVar.f6092a == 4 && a.c.equals(gVar.J()) && !gVar.i(c.DisableSpecialKeyDetect.f6089a)) {
                        gVar.o();
                        gVar.n(16);
                        if (gVar.f6092a == 13) {
                            gVar.m();
                            bVar.r(iVar2);
                            return map;
                        }
                        gVar.n(pVarB2.a());
                    }
                    Object objB = pVarB2.b(bVar, type2, null);
                    if (gVar.f6092a != 17) {
                        throw new d("syntax error, expect :, actual " + gVar.f6092a);
                    }
                    gVar.n(pVarB3.a());
                    Object objB2 = pVarB3.b(bVar, type3, objB);
                    bVar.d(map, objB);
                    map.put(objB, objB2);
                    if (gVar.f6092a == 16) {
                        gVar.n(pVarB2.a());
                    }
                } catch (Throwable th2) {
                    bVar.r(iVar2);
                    throw th2;
                }
            }
        }
    }

    @Override // p073n.p
    public final int a() {
        switch (this.f6190a) {
            case 0:
                return 12;
            case 1:
                return 12;
            case 2:
                return 2;
            case 3:
                return 12;
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        long timeInMillis;
        switch (this.f6190a) {
            case 0:
                if (!(type instanceof GenericArrayType)) {
                    return (!(type instanceof Class) || type == Object.class || type == Serializable.class) ? bVar.h(obj) : bVar.l(null, type);
                }
                Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                if (genericComponentType instanceof TypeVariable) {
                    genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
                }
                ArrayList arrayList = new ArrayList();
                bVar.i(genericComponentType, arrayList, null);
                if (!(genericComponentType instanceof Class)) {
                    return arrayList.toArray();
                }
                Object[] objArr = (Object[]) Array.newInstance((Class<?>) genericComponentType, arrayList.size());
                arrayList.toArray(objArr);
                return objArr;
            case 1:
                g gVar = bVar.e;
                if (type == e.class) {
                    c cVar = c.OrderedField;
                    gVar.getClass();
                    return (e) bVar.m(new e(gVar.i(cVar.f6089a), 0), null);
                }
                if (gVar.f6092a == 8) {
                    gVar.n(16);
                    return null;
                }
                Map mapC = c(type);
                i iVar = bVar.f6067f;
                try {
                    bVar.q(iVar, mapC, obj);
                    return d(obj, type, mapC, bVar);
                } finally {
                    bVar.r(iVar);
                }
            case 2:
                g gVar2 = bVar.e;
                int i5 = gVar2.f6092a;
                Class cls = Byte.TYPE;
                Class cls2 = Short.TYPE;
                Class cls3 = Double.TYPE;
                if (i5 == 2) {
                    if (type == cls3 || type == Double.class) {
                        String strP = gVar2.p();
                        gVar2.n(16);
                        return Double.valueOf(Double.parseDouble(strP));
                    }
                    long jLongValue = gVar2.longValue();
                    gVar2.n(16);
                    if (type == cls2 || type == Short.class) {
                        if (jLongValue > 32767 || jLongValue < -32768) {
                            throw new d(androidx.collection.a.j(jLongValue, "short overflow : "));
                        }
                        return Short.valueOf((short) jLongValue);
                    }
                    if (type != cls && type != Byte.class) {
                        return (jLongValue < -2147483648L || jLongValue > 2147483647L) ? Long.valueOf(jLongValue) : Integer.valueOf((int) jLongValue);
                    }
                    if (jLongValue > 127 || jLongValue < -128) {
                        throw new d(androidx.collection.a.j(jLongValue, "short overflow : "));
                    }
                    return Byte.valueOf((byte) jLongValue);
                }
                if (i5 != 3) {
                    Object objH = bVar.h(null);
                    if (objH == null) {
                        return null;
                    }
                    if (type == cls3 || type == Double.class) {
                        return p096r.j.i(objH);
                    }
                    if (type == cls2 || type == Short.class) {
                        return p096r.j.n(objH);
                    }
                    return (type == cls || type == Byte.class) ? p096r.j.g(objH) : p096r.j.d(objH);
                }
                if (type == cls3 || type == Double.class) {
                    String strP2 = gVar2.p();
                    gVar2.n(16);
                    return Double.valueOf(Double.parseDouble(strP2));
                }
                BigDecimal bigDecimalD = gVar2.d();
                gVar2.n(16);
                if (type != cls2 && type != Short.class) {
                    return (type == cls || type == Byte.class) ? Byte.valueOf(bigDecimalD.byteValue()) : bigDecimalD;
                }
                if (bigDecimalD.compareTo(BigDecimal.valueOf(32767L)) <= 0 && bigDecimalD.compareTo(BigDecimal.valueOf(-32768L)) >= 0) {
                    return Short.valueOf(bigDecimalD.shortValue());
                }
                throw new d("short overflow : " + bigDecimalD);
            case 3:
                g gVar3 = bVar.e;
                int i6 = gVar3.f6092a;
                if (i6 == 8) {
                    gVar3.m();
                    return null;
                }
                if (i6 != 12 && i6 != 16) {
                    throw new d("syntax error: ".concat(h.a(gVar3.f6092a)));
                }
                String strJ = null;
                String strJ2 = null;
                String strJ3 = null;
                int iG = 0;
                while (true) {
                    String strE = gVar3.E(bVar.f6066a);
                    if (strE == null) {
                        int i7 = gVar3.f6092a;
                        if (i7 == 13) {
                            gVar3.n(16);
                        } else if (i7 != 16 || !gVar3.i(c.AllowArbitraryCommas.f6089a)) {
                        }
                        return new StackTraceElement(strJ, strJ2, strJ3, iG);
                    }
                    gVar3.o();
                    if ("className".equals(strE)) {
                        int i8 = gVar3.f6092a;
                        if (i8 == 8) {
                            strJ = null;
                        } else {
                            if (i8 != 4) {
                                throw new d("syntax error");
                            }
                            strJ = gVar3.J();
                        }
                    } else if ("methodName".equals(strE)) {
                        int i9 = gVar3.f6092a;
                        if (i9 == 8) {
                            strJ2 = null;
                        } else {
                            if (i9 != 4) {
                                throw new d("syntax error");
                            }
                            strJ2 = gVar3.J();
                        }
                    } else if ("fileName".equals(strE)) {
                        int i10 = gVar3.f6092a;
                        if (i10 == 8) {
                            strJ3 = null;
                        } else {
                            if (i10 != 4) {
                                throw new d("syntax error");
                            }
                            strJ3 = gVar3.J();
                        }
                    } else if ("lineNumber".equals(strE)) {
                        int i11 = gVar3.f6092a;
                        if (i11 == 8) {
                            iG = 0;
                        } else {
                            if (i11 != 2) {
                                throw new d("syntax error");
                            }
                            iG = gVar3.g();
                        }
                    } else if ("nativeMethod".equals(strE)) {
                        int i12 = gVar3.f6092a;
                        if (i12 != 8 && i12 != 6 && i12 != 7) {
                            throw new d("syntax error");
                        }
                        gVar3.n(16);
                    } else if (strE == a.c) {
                        int i13 = gVar3.f6092a;
                        if (i13 == 4) {
                            String strJ4 = gVar3.J();
                            if (!strJ4.equals("java.lang.StackTraceElement")) {
                                throw new d("syntax error : ".concat(strJ4));
                            }
                        } else if (i13 != 8) {
                            throw new d("syntax error");
                        }
                    } else if ("moduleName".equals(strE)) {
                        int i14 = gVar3.f6092a;
                        if (i14 != 8) {
                            if (i14 != 4) {
                                throw new d("syntax error");
                            }
                            gVar3.J();
                        }
                    } else {
                        if (!"moduleVersion".equals(strE)) {
                            throw new d(AbstractC0157z.n("syntax error : ", strE));
                        }
                        int i15 = gVar3.f6092a;
                        if (i15 != 8) {
                            if (i15 != 4) {
                                throw new d("syntax error");
                            }
                            gVar3.J();
                        }
                    }
                    if (gVar3.f6092a == 13) {
                        gVar3.n(16);
                        return new StackTraceElement(strJ, strJ2, strJ3, iG);
                    }
                }
                break;
            case 4:
                g gVar4 = bVar.e;
                if (gVar4.f6092a == 16) {
                    gVar4.n(4);
                    if (gVar4.f6092a != 4) {
                        throw new d("syntax error");
                    }
                    gVar4.o();
                    if (gVar4.f6092a != 2) {
                        throw new d("syntax error");
                    }
                    long jLongValue2 = gVar4.longValue();
                    gVar4.n(13);
                    if (gVar4.f6092a != 13) {
                        throw new d("syntax error");
                    }
                    gVar4.n(16);
                    return new Time(jLongValue2);
                }
                Object objH2 = bVar.h(null);
                if (objH2 == null) {
                    return null;
                }
                if (objH2 instanceof Time) {
                    return objH2;
                }
                if (objH2 instanceof Number) {
                    return new Time(((Number) objH2).longValue());
                }
                if (!(objH2 instanceof String)) {
                    throw new d("parse error");
                }
                String str = (String) objH2;
                if (str.length() == 0) {
                    return null;
                }
                g gVar5 = new g(str);
                if (gVar5.Q(true)) {
                    timeInMillis = gVar5.f6097j.getTimeInMillis();
                } else {
                    for (int i16 = 0; i16 < str.length(); i16++) {
                        char cCharAt = str.charAt(i16);
                        if (cCharAt < '0' || cCharAt > '9') {
                            gVar5.close();
                            return Time.valueOf(str);
                        }
                    }
                    timeInMillis = Long.parseLong(str);
                }
                gVar5.close();
                return new Time(timeInMillis);
            default:
                g gVar6 = bVar.e;
                k kVar = bVar.f6066a;
                String strG = gVar6.G(kVar);
                gVar6.m();
                int i17 = gVar6.f6092a;
                if (i17 == 25) {
                    String strG2 = gVar6.G(kVar);
                    strG = androidx.collection.a.n(strG, Consts.DOT) + strG2;
                    gVar6.m();
                    i17 = gVar6.f6092a;
                }
                f fVar = new f(strG);
                if (i17 != 10) {
                    throw new d("illegal jsonp : " + gVar6.f());
                }
                gVar6.m();
                while (true) {
                    fVar.b.add(bVar.h(null));
                    int i18 = gVar6.f6092a;
                    if (i18 != 16) {
                        if (i18 != 11) {
                            throw new d("illegal jsonp : " + gVar6.f());
                        }
                        gVar6.m();
                        if (gVar6.f6092a == 24) {
                            gVar6.m();
                        }
                        return fVar;
                    }
                    gVar6.m();
                }
                break;
        }
    }
}
