package p079o;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import p050j.d;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: renamed from: o.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1289s implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1289s f6420a = new C1289s();

    @Override // p073n.p
    public final int a() {
        return 14;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Collection arrayList;
        g gVar = bVar.e;
        if (gVar.f6092a == 8) {
            gVar.n(16);
            return null;
        }
        if (type == p050j.b.class) {
            p050j.b bVar2 = new p050j.b();
            bVar.j(bVar2, null);
            return bVar2;
        }
        Class clsV = j.v(type);
        if (clsV == AbstractCollection.class || clsV == Collection.class) {
            arrayList = new ArrayList();
        } else if (clsV.isAssignableFrom(HashSet.class)) {
            arrayList = new HashSet();
        } else if (clsV.isAssignableFrom(LinkedHashSet.class)) {
            arrayList = new LinkedHashSet();
        } else if (clsV.isAssignableFrom(TreeSet.class)) {
            arrayList = new TreeSet();
        } else if (clsV.isAssignableFrom(ArrayList.class)) {
            arrayList = new ArrayList();
        } else if (clsV.isAssignableFrom(EnumSet.class)) {
            arrayList = EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        } else {
            try {
                arrayList = (Collection) clsV.newInstance();
            } catch (Exception unused) {
                throw new d("create instance error, class ".concat(clsV.getName()));
            }
        }
        bVar.i(j.s(type), arrayList, obj);
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0068 A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #1 {all -> 0x0061, blocks: (B:27:0x005d, B:31:0x0068, B:35:0x0075, B:39:0x0083, B:41:0x0094), top: B:61:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:33:0x006d A[Catch: all -> 0x00b0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:20:0x0046, B:21:0x004d, B:23:0x0053, B:33:0x006d, B:44:0x00a0), top: B:59:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0075 A[Catch: all -> 0x0061, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0061, blocks: (B:27:0x005d, B:31:0x0068, B:35:0x0075, B:39:0x0083, B:41:0x0094), top: B:61:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0083 A[Catch: all -> 0x0061, TRY_ENTER, TryCatch #1 {all -> 0x0061, blocks: (B:27:0x005d, B:31:0x0068, B:35:0x0075, B:39:0x0083, B:41:0x0094), top: B:61:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0094 A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #1 {all -> 0x0061, blocks: (B:27:0x005d, B:31:0x0068, B:35:0x0075, B:39:0x0083, B:41:0x0094), top: B:61:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:63:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) throws Throwable {
        G g7;
        Throwable th;
        Class<?> cls;
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullListAsEmpty);
            return;
        }
        c0 c0Var = c0.WriteClassName;
        Type typeS = b0Var.d(c0Var) ? j.s(type) : null;
        Collection collection = (Collection) obj;
        W w6 = g6.f6331p;
        int i6 = 0;
        g6.g(w6, obj, obj2, 0);
        if (b0Var.d(c0Var)) {
            if (HashSet.class == collection.getClass()) {
                b0Var.a("Set");
            } else if (TreeSet.class == collection.getClass()) {
                b0Var.a("TreeSet");
            }
        }
        try {
            b0Var.write(91);
            for (Object obj3 : collection) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    try {
                        b0Var.write(44);
                        if (obj3 == null) {
                            b0Var.n();
                        } else {
                            cls = obj3.getClass();
                            if (cls == Integer.class) {
                                b0Var.l(((Integer) obj3).intValue());
                            } else {
                                if (cls == Long.class) {
                                    b0Var.m(((Long) obj3).longValue());
                                    if (b0Var.d(c0.WriteClassName)) {
                                        b0Var.write(76);
                                    }
                                } else {
                                    try {
                                        g7 = g6;
                                        try {
                                            g6.f6324i.b(cls).write(g7, obj3, Integer.valueOf(i6), typeS, 0);
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
                            }
                        }
                        g7 = g6;
                        i6 = i7;
                        g6 = g7;
                    } catch (Throwable th4) {
                        th = th4;
                        g7 = g6;
                    }
                } else {
                    if (obj3 == null) {
                        b0Var.n();
                    } else {
                        cls = obj3.getClass();
                        if (cls == Integer.class) {
                            b0Var.l(((Integer) obj3).intValue());
                        } else {
                            if (cls == Long.class) {
                                b0Var.m(((Long) obj3).longValue());
                                if (b0Var.d(c0.WriteClassName)) {
                                    b0Var.write(76);
                                }
                            } else {
                                g7 = g6;
                                g6.f6324i.b(cls).write(g7, obj3, Integer.valueOf(i6), typeS, 0);
                            }
                            i6 = i7;
                            g6 = g7;
                        }
                    }
                    g7 = g6;
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
