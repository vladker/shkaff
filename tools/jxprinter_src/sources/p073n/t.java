package p073n;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import p050j.a;
import p050j.d;
import p067m.b;
import p067m.c;
import p067m.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends m {
    private Throwable createException(String str, Throwable th, Class<?> cls) {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(null);
        }
        return null;
    }

    @Override // p073n.m, p073n.p
    public final int a() {
        return 12;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0033  */
    @Override // p073n.m, p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Class clsA;
        Throwable thCreateException;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 8) {
            gVar.m();
            return null;
        }
        if (bVar.f6071j == 2) {
            bVar.f6071j = 0;
        } else if (i5 != 12) {
            throw new d("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsA = null;
        } else {
            clsA = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsA)) {
                clsA = null;
            }
        }
        HashMap map = new HashMap();
        Throwable th = null;
        String strJ = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strE = gVar.E(bVar.f6066a);
            if (strE == null) {
                int i6 = gVar.f6092a;
                if (i6 == 13) {
                    gVar.n(16);
                    break;
                }
                if (i6 != 16 || !gVar.i(c.AllowArbitraryCommas.f6089a)) {
                }
            }
            gVar.o();
            if (a.c.equals(strE)) {
                if (gVar.f6092a != 4) {
                    throw new d("syntax error");
                }
                clsA = bVar.b.a(Throwable.class, gVar.J());
                gVar.n(16);
            } else if (Constants.MESSAGE.equals(strE)) {
                int i7 = gVar.f6092a;
                if (i7 == 8) {
                    strJ = null;
                } else {
                    if (i7 != 4) {
                        throw new d("syntax error");
                    }
                    strJ = gVar.J();
                }
                gVar.m();
            } else if ("cause".equals(strE)) {
                th = (Throwable) b(bVar, null, "cause");
            } else if ("stackTrace".equals(strE)) {
                stackTraceElementArr = (StackTraceElement[]) bVar.l(null, StackTraceElement[].class);
            } else {
                map.put(strE, bVar.h(null));
            }
            if (gVar.f6092a == 13) {
                gVar.n(16);
                break;
            }
        }
        if (clsA == null) {
            thCreateException = new Exception(strJ, th);
        } else {
            if (!Throwable.class.isAssignableFrom(clsA)) {
                throw new d("type not match, not Throwable. ".concat(clsA.getName()));
            }
            try {
                thCreateException = createException(strJ, th, clsA);
                if (thCreateException == null) {
                    thCreateException = new Exception(strJ, th);
                }
            } catch (Exception e) {
                throw new d("create instance error", e);
            }
        }
        if (stackTraceElementArr != null) {
            thCreateException.setStackTrace(stackTraceElementArr);
        }
        return thCreateException;
    }
}
