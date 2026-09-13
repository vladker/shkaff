package p079o;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* JADX INFO: renamed from: o.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1295y implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1295y f6424a = new C1295y();

    /* JADX WARN: Code duplicated, block: B:25:0x004a A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:21:0x0040, B:25:0x004a), top: B:44:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x004f A[Catch: all -> 0x0068, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0068, blocks: (B:14:0x002d, B:15:0x0030, B:17:0x0036, B:27:0x004f, B:29:0x0059), top: B:48:0x002d }] */
    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) throws Throwable {
        G g7;
        Throwable th;
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullListAsEmpty);
            return;
        }
        int i6 = 0;
        Type type2 = (b0Var.d(c0.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        W w6 = g6.f6331p;
        g6.g(w6, obj, obj2, 0);
        try {
            b0Var.write(91);
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i7 = i6 + 1;
                if (i6 != 0) {
                    try {
                        b0Var.write(44);
                        if (objNextElement == null) {
                            b0Var.n();
                            g7 = g6;
                        } else {
                            try {
                                g7 = g6;
                                try {
                                    g6.f6324i.b(objNextElement.getClass()).write(g7, objNextElement, Integer.valueOf(i6), type2, 0);
                                } catch (Throwable th2) {
                                    th = th2;
                                    th = th;
                                    g7.f6331p = w6;
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                g7 = g6;
                                th = th3;
                            }
                        }
                        i6 = i7;
                        g6 = g7;
                    } catch (Throwable th4) {
                        th = th4;
                        g7 = g6;
                    }
                } else {
                    if (objNextElement == null) {
                        b0Var.n();
                        g7 = g6;
                    } else {
                        g7 = g6;
                        g6.f6324i.b(objNextElement.getClass()).write(g7, objNextElement, Integer.valueOf(i6), type2, 0);
                    }
                    i6 = i7;
                    g6 = g7;
                }
                g7.f6331p = w6;
                throw th;
            }
            g7 = g6;
            b0Var.write(93);
            g7.f6331p = w6;
        } catch (Throwable th5) {
            th = th5;
            g7 = g6;
        }
    }
}
