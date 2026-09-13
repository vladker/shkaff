package p079o;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import p050j.a;
import p050j.d;
import p050j.e;
import p050j.r;
import p050j.u;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class N implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final N f6340a = new N();
    public static Method b = null;
    public static boolean c = false;

    public static void c(G g6, b0 b0Var, Iterator it) {
        b0Var.write(91);
        int i5 = 0;
        while (it.hasNext()) {
            if (i5 != 0) {
                b0Var.write(44);
            }
            g6.h(it.next());
            i5++;
        }
        b0Var.write(93);
    }

    @Override // p073n.p
    public final int a() {
        return 4;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Object objH;
        String str;
        g gVar = bVar.e;
        int i5 = 0;
        if (type != InetSocketAddress.class) {
            if (bVar.f6071j == 2) {
                bVar.f6071j = 0;
                bVar.a(16);
                if (gVar.f6092a != 4) {
                    throw new d("syntax error");
                }
                if (!"val".equals(gVar.J())) {
                    throw new d("syntax error");
                }
                gVar.m();
                bVar.a(17);
                objH = bVar.h(null);
                bVar.a(13);
            } else {
                objH = bVar.h(null);
            }
            if (objH == null) {
                str = null;
            } else {
                if (!(objH instanceof String)) {
                    if (objH instanceof e) {
                        Map map = ((e) objH).f5380j;
                        if (type == Currency.class) {
                            Object obj2 = map.get(FirebaseAnalytics.Param.CURRENCY);
                            String string = obj2 == null ? null : obj2.toString();
                            if (string != null) {
                                return Currency.getInstance(string);
                            }
                            Object obj3 = map.get("symbol");
                            String string2 = obj3 != null ? obj3.toString() : null;
                            if (string2 != null) {
                                return Currency.getInstance(string2);
                            }
                        }
                        if (type == Map.Entry.class) {
                            return map.entrySet().iterator().next();
                        }
                    }
                    throw new d("expect string");
                }
                str = (String) objH;
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return UUID.fromString(str);
            }
            if (type == URI.class) {
                return URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return new URL(str);
                } catch (MalformedURLException e) {
                    throw new d("create url error", e);
                }
            }
            if (type == Pattern.class) {
                return Pattern.compile(str);
            }
            if (type == Locale.class) {
                return j.D(str);
            }
            if (type == SimpleDateFormat.class) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, gVar.f6099l);
                simpleDateFormat.setTimeZone(gVar.f6098k);
                return simpleDateFormat;
            }
            if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                try {
                    return InetAddress.getByName(str);
                } catch (UnknownHostException e6) {
                    throw new d("deserialize inet adress error", e6);
                }
            }
            if (type == File.class) {
                return new File(str);
            }
            if (type == TimeZone.class) {
                return TimeZone.getTimeZone(str);
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            }
            if (type == Class.class) {
                bVar.b.getClass();
                return j.B(str);
            }
            if (type == Charset.class) {
                return Charset.forName(str);
            }
            if (type == Currency.class) {
                return Currency.getInstance(str);
            }
            if (type == r.class) {
                return new r(str);
            }
            if (!(type instanceof Class)) {
                throw new d("MiscCodec not support " + type.toString());
            }
            String name = ((Class) type).getName();
            if (name.equals("java.nio.file.Path")) {
                try {
                    if (b == null && !c) {
                        b = j.B("java.nio.file.Paths").getMethod("get", String.class, String[].class);
                    }
                    Method method = b;
                    if (method != null) {
                        return method.invoke(null, str, new String[0]);
                    }
                    throw new d("Path deserialize erorr");
                } catch (IllegalAccessException e7) {
                    throw new d("Path deserialize erorr", e7);
                } catch (NoSuchMethodException unused) {
                    c = true;
                } catch (InvocationTargetException e8) {
                    throw new d("Path deserialize erorr", e8);
                }
            }
            throw new d("MiscCodec not support ".concat(name));
        }
        if (gVar.f6092a == 8) {
            gVar.m();
            return null;
        }
        bVar.a(12);
        InetAddress inetAddress = null;
        while (true) {
            String strJ = gVar.J();
            gVar.n(17);
            if (strJ.equals("address")) {
                bVar.a(17);
                inetAddress = (InetAddress) bVar.l(null, InetAddress.class);
            } else if (strJ.equals("port")) {
                bVar.a(17);
                if (gVar.f6092a != 2) {
                    throw new d("port is not int");
                }
                int iG = gVar.g();
                gVar.m();
                i5 = iG;
            } else {
                bVar.a(17);
                bVar.h(null);
            }
            if (gVar.f6092a != 16) {
                bVar.a(13);
                return new InetSocketAddress(inetAddress, i5);
            }
            gVar.m();
        }
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        String currencyCode;
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.n();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            currencyCode = ((SimpleDateFormat) obj).toPattern();
            if (b0Var.d(c0.WriteClassName) && obj.getClass() != type) {
                b0Var.write(123);
                b0Var.g(a.c);
                g6.i(obj.getClass().getName());
                b0Var.j("val", ',', currencyCode);
                b0Var.write(125);
                return;
            }
        } else if (cls == Class.class) {
            currencyCode = ((Class) obj).getName();
        } else {
            if (cls == InetSocketAddress.class) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetAddress address = inetSocketAddress.getAddress();
                b0Var.write(123);
                if (address != null) {
                    b0Var.g("address");
                    g6.h(address);
                    b0Var.write(44);
                }
                b0Var.g("port");
                b0Var.l(inetSocketAddress.getPort());
                b0Var.write(125);
                return;
            }
            if (obj instanceof File) {
                currencyCode = ((File) obj).getPath();
            } else if (obj instanceof InetAddress) {
                currencyCode = ((InetAddress) obj).getHostAddress();
            } else if (obj instanceof TimeZone) {
                currencyCode = ((TimeZone) obj).getID();
            } else {
                if (!(obj instanceof Currency)) {
                    if (obj instanceof u) {
                        ((a) ((u) obj)).writeJSONString(b0Var);
                        return;
                    }
                    if (obj instanceof Iterator) {
                        c(g6, b0Var, (Iterator) obj);
                        return;
                    }
                    if (obj instanceof Iterable) {
                        c(g6, b0Var, ((Iterable) obj).iterator());
                        return;
                    }
                    if (!(obj instanceof Map.Entry)) {
                        if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
                            b0Var.n();
                            return;
                        } else {
                            throw new d("not support class : " + cls);
                        }
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key instanceof String) {
                        String str = (String) key;
                        if (value instanceof String) {
                            b0Var.k(str, '{', (String) value);
                        } else {
                            b0Var.write(123);
                            b0Var.g(str);
                            g6.h(value);
                        }
                    } else {
                        b0Var.write(123);
                        g6.h(key);
                        b0Var.write(58);
                        g6.h(value);
                    }
                    b0Var.write(125);
                    return;
                }
                currencyCode = ((Currency) obj).getCurrencyCode();
            }
        }
        b0Var.q(currencyCode);
    }
}
