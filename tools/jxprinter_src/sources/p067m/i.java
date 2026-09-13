package p067m;

import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.ParameterizedType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6104a;
    public final i b;
    public final Object c;
    public ParameterizedType d;
    public transient String e;

    public i(i iVar, Object obj, Object obj2) {
        this.b = iVar;
        this.f6104a = obj;
        this.c = obj2;
    }

    public final String toString() {
        if (this.e == null) {
            i iVar = this.b;
            if (iVar == null) {
                this.e = "$";
            } else {
                Object obj = this.c;
                if (obj instanceof Integer) {
                    this.e = iVar.toString() + "[" + obj + "]";
                } else {
                    this.e = iVar.toString() + Consts.DOT + obj;
                }
            }
        }
        return this.e;
    }
}
