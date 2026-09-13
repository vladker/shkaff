package p144z0;

import L0.s;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class P {
    public static final Queue d = s.createQueue(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9061a;
    public int b;
    public Object c;

    public static P a(Object obj, int i5, int i6) {
        P p6;
        Queue queue = d;
        synchronized (queue) {
            p6 = (P) queue.poll();
        }
        if (p6 == null) {
            p6 = new P();
        }
        p6.c = obj;
        p6.b = i5;
        p6.f9061a = i6;
        return p6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof P) {
            P p6 = (P) obj;
            if (this.b == p6.b && this.f9061a == p6.f9061a && this.c.equals(p6.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() + (((this.f9061a * 31) + this.b) * 31);
    }
}
