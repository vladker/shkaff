package S4;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f695a = new ArrayList();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final StringBuilder d = new StringBuilder(128);
    public Class e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f696f;

    public final boolean a(Class cls, Method method) {
        StringBuilder sb = this.d;
        sb.setLength(0);
        sb.append(method.getName());
        sb.append('>');
        sb.append(cls.getName());
        String string = sb.toString();
        Class<?> declaringClass = method.getDeclaringClass();
        HashMap map = this.c;
        Class cls2 = (Class) map.put(string, declaringClass);
        if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
            return true;
        }
        map.put(string, cls2);
        return false;
    }
}
