package V3;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface b extends a {
    Object call(Object... objArr);

    Object callBy(Map<Object, ? extends Object> map);

    @Override // V3.a
    /* synthetic */ List getAnnotations();

    String getName();

    List<Object> getParameters();

    p getReturnType();

    List<q> getTypeParameters();

    v getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
