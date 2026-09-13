package S4;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f693a;
    public final ThreadMode b;
    public final Class c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f694f;

    public m(Method method, Class cls, ThreadMode threadMode, int i5, boolean z6) {
        this.f693a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i5;
        this.e = z6;
    }

    public final synchronized void a() {
        if (this.f694f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f693a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f693a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f694f = sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        a();
        m mVar = (m) obj;
        mVar.a();
        return this.f694f.equals(mVar.f694f);
    }

    public final int hashCode() {
        return this.f693a.hashCode();
    }
}
