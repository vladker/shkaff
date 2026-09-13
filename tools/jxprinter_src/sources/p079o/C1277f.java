package p079o;

import java.lang.reflect.Type;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: renamed from: o.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1277f implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f6410a;
    public final Q b;

    public C1277f(Class cls, Q q6) {
        this.f6410a = cls;
        this.b = q6;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002b A[Catch: all -> 0x0023, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:11:0x001f, B:17:0x002b), top: B:39:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0032 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #3 {all -> 0x004a, blocks: (B:7:0x0016, B:15:0x0027, B:19:0x0032, B:21:0x003a), top: B:45:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x003a A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #3 {all -> 0x004a, blocks: (B:7:0x0016, B:15:0x0027, B:19:0x0032, B:21:0x003a), top: B:45:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x004d A[Catch: all -> 0x0047, TRY_LEAVE, TryCatch #2 {all -> 0x0047, blocks: (B:31:0x0061, B:23:0x0043, B:28:0x004d, B:30:0x0058, B:34:0x0069), top: B:43:0x0061 }] */
    @Override // p079o.Q, p079o.InterfaceC1290t
    public final void write(G g6, Object obj, Object obj2, Type type, int i5) throws Throwable {
        G g7;
        Throwable th;
        Object obj3;
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        W w6 = g6.f6331p;
        int i6 = 0;
        g6.g(w6, obj, obj2, 0);
        try {
            b0Var.write(91);
            while (i6 < length) {
                if (i6 != 0) {
                    try {
                        b0Var.write(44);
                        obj3 = objArr[i6];
                        if (obj3 == null) {
                            b0Var.a(AbstractC1127c.NULL);
                            g7 = g6;
                        } else if (obj3.getClass() == this.f6410a) {
                            g7 = g6;
                            this.b.write(g7, obj3, Integer.valueOf(i6), null, 0);
                        } else {
                            g7 = g6;
                            try {
                                g7.f6324i.b(obj3.getClass()).write(g7, obj3, Integer.valueOf(i6), null, 0);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        try {
                            i6++;
                            g6 = g7;
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            g7.f6331p = w6;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        g7 = g6;
                    }
                } else {
                    obj3 = objArr[i6];
                    if (obj3 == null) {
                        b0Var.a(AbstractC1127c.NULL);
                        g7 = g6;
                    } else if (obj3.getClass() == this.f6410a) {
                        g7 = g6;
                        this.b.write(g7, obj3, Integer.valueOf(i6), null, 0);
                    } else {
                        g7 = g6;
                        g7.f6324i.b(obj3.getClass()).write(g7, obj3, Integer.valueOf(i6), null, 0);
                    }
                    i6++;
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
