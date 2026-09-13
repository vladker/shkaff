package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class l0 extends m0 {
    @Override // retrofit2.m0
    public final String a(Method method, int i5) {
        Parameter parameter = method.getParameters()[i5];
        if (!parameter.isNamePresent()) {
            return super.a(method, i5);
        }
        return "parameter '" + parameter.getName() + Chars.QUOTE;
    }

    @Override // retrofit2.m0
    public final boolean b(Method method) {
        return method.isDefault();
    }

    @Override // retrofit2.m0
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) {
        return AbstractC1624w.invoke(method, cls, obj, objArr);
    }
}
