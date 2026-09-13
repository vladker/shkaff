package p079o;

import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import p050j.a;
import p055k.b;
import p096r.c;
import p096r.d;
import p096r.f;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class Y {
    public static final Y e = new Y();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f6346f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f6347g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f6348h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f6349i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f6350j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6351a;
    public final C1273b b;
    public final String c;
    public final f d;

    public Y() {
        boolean z6 = c.f7883a;
        this.f6351a = !z6;
        this.c = a.c;
        this.d = new f();
        if (!z6) {
            try {
                this.b = new C1273b();
            } catch (Throwable unused) {
                this.f6351a = false;
            }
        }
        c(Boolean.class, C1285n.f6416a);
        c(Character.class, C1288q.f6418a);
        C c = C.f6321a;
        c(Byte.class, c);
        c(Short.class, c);
        c(Integer.class, c);
        c(Long.class, L.f6338a);
        c(Float.class, A.b);
        c(Double.class, C1293w.b);
        c(BigDecimal.class, C1283l.f6414a);
        c(BigInteger.class, C1284m.f6415a);
        c(String.class, d0.f6407a);
        S s6 = S.f6342a;
        c(byte[].class, s6);
        c(short[].class, s6);
        c(int[].class, s6);
        c(long[].class, s6);
        c(float[].class, s6);
        c(double[].class, s6);
        c(boolean[].class, s6);
        c(char[].class, s6);
        c(Object[].class, P.f6341a);
        N n6 = N.f6340a;
        c(Class.class, n6);
        c(SimpleDateFormat.class, n6);
        c(Currency.class, new N());
        c(TimeZone.class, n6);
        c(InetAddress.class, n6);
        c(Inet4Address.class, n6);
        c(Inet6Address.class, n6);
        c(InetSocketAddress.class, n6);
        c(File.class, n6);
        C1276e c1276e = C1276e.f6408a;
        c(Appendable.class, c1276e);
        c(StringBuffer.class, c1276e);
        c(StringBuilder.class, c1276e);
        e0 e0Var = e0.f6409a;
        c(Charset.class, e0Var);
        c(Pattern.class, e0Var);
        c(Locale.class, e0Var);
        c(URI.class, e0Var);
        c(URL.class, e0Var);
        c(UUID.class, e0Var);
        C1278g c1278g = C1278g.f6411a;
        c(AtomicBoolean.class, c1278g);
        c(AtomicInteger.class, c1278g);
        c(AtomicLong.class, c1278g);
        V v6 = V.f6343a;
        c(AtomicReference.class, v6);
        c(AtomicIntegerArray.class, c1278g);
        c(AtomicLongArray.class, c1278g);
        c(WeakReference.class, v6);
        c(SoftReference.class, v6);
    }

    private final H createASMSerializer(X x6) {
        H hCreateJavaBeanSerializer = this.b.createJavaBeanSerializer(x6);
        int i5 = 0;
        while (true) {
            C1296z[] c1296zArr = hCreateJavaBeanSerializer.f6335j;
            if (i5 >= c1296zArr.length) {
                return hCreateJavaBeanSerializer;
            }
            Class cls = c1296zArr[i5].f6425a.e;
            if (cls.isEnum()) {
                b(cls);
            }
            i5++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    public final Q a(Class cls) {
        Method method;
        X xA = j.a(cls);
        d[] dVarArr = xA.c;
        if (dVarArr.length == 0 && Iterable.class.isAssignableFrom(cls)) {
            return N.f6340a;
        }
        Class cls2 = xA.f6345a;
        if (!Modifier.isPublic(cls2.getModifiers())) {
            return new H(xA);
        }
        boolean z6 = this.f6351a;
        boolean z7 = false;
        if (z6) {
            ClassLoader parent = this.b.f6364a;
            parent.getClass();
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader != null) {
                while (true) {
                    if (parent != null) {
                        if (parent != classLoader) {
                            parent = parent.getParent();
                        } else if (cls2 != Serializable.class) {
                        }
                    }
                    z6 = false;
                }
            } else if (cls2 != Serializable.class || cls2 == Object.class) {
                z6 = false;
            }
        } else if (cls2 != Serializable.class) {
            z6 = false;
        } else {
            z6 = false;
        }
        if (z6 && !c.a(cls2.getSimpleName())) {
            z6 = false;
        }
        if (!z6) {
            z7 = z6;
            break;
        }
        int length = dVarArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z7 = z6;
                break;
            }
            d dVar = dVarArr[i5];
            Field field = dVar.c;
            Class cls3 = dVar.e;
            if ((field != null && !field.getType().equals(cls3)) || ((method = dVar.b) != null && !method.getReturnType().equals(cls3))) {
                break;
            }
            b bVarC = dVar.c();
            if (bVarC != null) {
                if (!c.a(bVarC.name()) || bVarC.format().length() != 0 || bVarC.jsonDirect() || bVarC.serializeUsing() != Void.class || bVarC.unwrapped()) {
                    break;
                }
                for (c0 c0Var : bVarC.serialzeFeatures()) {
                    if (c0.WriteNonStringValueAsString == c0Var || c0.WriteEnumUsingToString == c0Var || c0.NotWriteDefaultValue == c0Var) {
                        z6 = false;
                        break;
                    }
                }
            }
            i5++;
        }
        if (z7) {
            try {
                H hCreateASMSerializer = createASMSerializer(xA);
                if (hCreateASMSerializer != null) {
                    return hCreateASMSerializer;
                }
            } catch (ClassCastException | ClassFormatError unused) {
            } catch (Throwable th) {
                throw new p050j.d("create asm serializer error, class " + cls2, th);
            }
        }
        return new H(xA);
    }

    /* JADX WARN: Code duplicated, block: B:123:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:131:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:133:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:147:0x0341  */
    /* JADX WARN: Code duplicated, block: B:148:0x034d  */
    /* JADX WARN: Code duplicated, block: B:172:0x032a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x031d, code lost:
    
        if (r2 != null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0337, code lost:
    
        if (r1 != null) goto L144;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p079o.Q b(java.lang.Class r11) {
        /*
            Method dump skipped, instruction units count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p079o.Y.b(java.lang.Class):o.Q");
    }

    public final void c(Class cls, Q q6) {
        this.d.c(cls, q6);
    }
}
