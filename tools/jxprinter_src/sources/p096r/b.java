package p096r;

import java.security.AccessController;
import java.security.ProtectionDomain;
import java.util.HashMap;
import p050j.a;
import p050j.c;
import p050j.d;
import p050j.e;
import p050j.r;
import p050j.s;
import p050j.t;
import p050j.u;
import p050j.v;
import p050j.w;
import p067m.f;
import p067m.g;
import p067m.h;
import p067m.i;
import p067m.j;
import p067m.k;
import p073n.l;
import p073n.m;
import p073n.p;
import p079o.AbstractC1275d;
import p079o.AbstractC1282k;
import p079o.C1281j;
import p079o.G;
import p079o.H;
import p079o.I;
import p079o.InterfaceC1290t;
import p079o.InterfaceC1291u;
import p079o.J;
import p079o.O;
import p079o.Q;
import p079o.T;
import p079o.U;
import p079o.W;
import p079o.X;
import p079o.Y;
import p079o.Z;
import p079o.a0;
import p079o.b0;
import p079o.c0;
import p079o.f0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ClassLoader {
    public static final HashMap b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtectionDomain f7882a = (ProtectionDomain) AccessController.doPrivileged(new a(0));

    static {
        Class[] clsArr = {a.class, e.class, p050j.b.class, r.class, c.class, d.class, s.class, t.class, u.class, v.class, w.class, d.class, j.class, e.class, f.class, h.class, g.class, Q.class, H.class, a0.class, X.class, G.class, b0.class, Z.class, J.class, I.class, InterfaceC1291u.class, AbstractC1275d.class, AbstractC1282k.class, O.class, T.class, U.class, f0.class, c0.class, InterfaceC1290t.class, W.class, Y.class, m.class, j.class, p067m.b.class, p067m.d.class, p067m.e.class, i.class, h.class, k.class, p067m.c.class, g.class, f.class, p073n.e.class, p.class, p073n.j.class, p073n.i.class, p073n.k.class, C1281j.class, l.class, p073n.g.class};
        for (int i5 = 0; i5 < 56; i5++) {
            Class cls = clsArr[i5];
            b.put(cls.getName(), cls);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(a.class.getName());
            } catch (ClassNotFoundException unused) {
                contextClassLoader = a.class.getClassLoader();
            }
        } else {
            contextClassLoader = a.class.getClassLoader();
        }
        super(contextClassLoader);
    }

    public Class<?> defineClassPublic(String str, byte[] bArr, int i5, int i6) {
        return defineClass(str, bArr, i5, i6, f7882a);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z6) {
        Class<?> cls = (Class) b.get(str);
        return cls != null ? cls : super.loadClass(str, z6);
    }
}
