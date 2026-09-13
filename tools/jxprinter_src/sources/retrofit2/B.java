package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8091a;
    public final Method b;
    public final List c;
    private final Object instance;

    public B(Class<?> cls, Object obj, Method method, List<?> list) {
        this.f8091a = cls;
        this.instance = obj;
        this.b = method;
        this.c = Collections.unmodifiableList(list);
    }

    @Deprecated
    public static B of(Method method, List<?> list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new B(method.getDeclaringClass(), null, method, new ArrayList(list));
    }

    public Object instance() {
        return this.instance;
    }

    public final String toString() {
        return String.format("%s.%s() %s", this.f8091a.getName(), this.b.getName(), this.c);
    }
}
