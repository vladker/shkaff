package p079o;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f6344a;
    public final Object b;
    public final Object c;
    public final int d;

    public W(W w6, Object obj, Object obj2, int i5) {
        this.f6344a = w6;
        this.b = obj;
        this.c = obj2;
        this.d = i5;
    }

    public final String toString() {
        W w6 = this.f6344a;
        if (w6 == null) {
            return "$";
        }
        Object obj = this.c;
        if (!(obj instanceof Integer)) {
            return w6.toString() + Consts.DOT + obj;
        }
        return w6.toString() + "[" + obj + "]";
    }
}
