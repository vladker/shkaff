package p079o;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: renamed from: o.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1278g implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1278g f6411a = new C1278g();

    @Override // p073n.p
    public final int a() {
        return 14;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        g gVar = bVar.e;
        if (gVar.f6092a == 8) {
            gVar.n(16);
            return null;
        }
        p050j.b bVar2 = new p050j.b();
        bVar.j(bVar2, null);
        int i5 = 0;
        ArrayList arrayList = bVar2.f5377j;
        if (type == AtomicIntegerArray.class) {
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arrayList.size());
            while (i5 < arrayList.size()) {
                atomicIntegerArray.set(i5, j.k(arrayList.get(i5)).intValue());
                i5++;
            }
            return atomicIntegerArray;
        }
        AtomicLongArray atomicLongArray = new AtomicLongArray(arrayList.size());
        while (i5 < arrayList.size()) {
            atomicLongArray.set(i5, j.m(arrayList.get(i5)).longValue());
            i5++;
        }
        return atomicLongArray;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj instanceof AtomicInteger) {
            b0Var.l(((AtomicInteger) obj).get());
            return;
        }
        if (obj instanceof AtomicLong) {
            b0Var.m(((AtomicLong) obj).get());
            return;
        }
        if (obj instanceof AtomicBoolean) {
            b0Var.a(((AtomicBoolean) obj).get() ? "true" : "false");
            return;
        }
        if (obj == null) {
            b0Var.p(c0.WriteNullListAsEmpty);
            return;
        }
        int i6 = 0;
        if (obj instanceof AtomicIntegerArray) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            int length = atomicIntegerArray.length();
            b0Var.write(91);
            while (i6 < length) {
                int i7 = atomicIntegerArray.get(i6);
                if (i6 != 0) {
                    b0Var.write(44);
                }
                b0Var.l(i7);
                i6++;
            }
            b0Var.write(93);
            return;
        }
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        int length2 = atomicLongArray.length();
        b0Var.write(91);
        while (i6 < length2) {
            long j6 = atomicLongArray.get(i6);
            if (i6 != 0) {
                b0Var.write(44);
            }
            b0Var.m(j6);
            i6++;
        }
        b0Var.write(93);
    }
}
