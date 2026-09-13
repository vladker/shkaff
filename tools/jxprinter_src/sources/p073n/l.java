package p073n;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p067m.b;
import p096r.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f6187a;
    public final Class b;

    public l(Class cls, d dVar) {
        this.b = cls;
        this.f6187a = dVar;
    }

    public int a() {
        return 0;
    }

    public abstract void b(Object obj, Type type, Map map, b bVar);

    public void c(Object obj, Object obj2) {
        d dVar = this.f6187a;
        if (obj2 == null && dVar.e.isPrimitive()) {
            return;
        }
        try {
            Method method = dVar.b;
            if (method != null) {
                if (!dVar.f7887h) {
                    method.invoke(obj, obj2);
                    return;
                }
                Class cls = dVar.e;
                if (cls == AtomicInteger.class) {
                    AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, null);
                    if (atomicInteger != null) {
                        atomicInteger.set(((AtomicInteger) obj2).get());
                        return;
                    }
                    return;
                }
                if (cls == AtomicLong.class) {
                    AtomicLong atomicLong = (AtomicLong) method.invoke(obj, null);
                    if (atomicLong != null) {
                        atomicLong.set(((AtomicLong) obj2).get());
                        return;
                    }
                    return;
                }
                if (cls == AtomicBoolean.class) {
                    AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, null);
                    if (atomicBoolean != null) {
                        atomicBoolean.set(((AtomicBoolean) obj2).get());
                        return;
                    }
                    return;
                }
                if (Map.class.isAssignableFrom(method.getReturnType())) {
                    Map map = (Map) method.invoke(obj, null);
                    if (map != null) {
                        map.putAll((Map) obj2);
                        return;
                    }
                    return;
                }
                Collection collection = (Collection) method.invoke(obj, null);
                if (collection == null || obj2 == null) {
                    return;
                }
                collection.clear();
                collection.addAll((Collection) obj2);
                return;
            }
            Field field = dVar.c;
            if (!dVar.f7887h) {
                if (field != null) {
                    field.set(obj, obj2);
                    return;
                }
                return;
            }
            Class cls2 = dVar.e;
            if (cls2 == AtomicInteger.class) {
                AtomicInteger atomicInteger2 = (AtomicInteger) field.get(obj);
                if (atomicInteger2 != null) {
                    atomicInteger2.set(((AtomicInteger) obj2).get());
                    return;
                }
                return;
            }
            if (cls2 == AtomicLong.class) {
                AtomicLong atomicLong2 = (AtomicLong) field.get(obj);
                if (atomicLong2 != null) {
                    atomicLong2.set(((AtomicLong) obj2).get());
                    return;
                }
                return;
            }
            if (cls2 == AtomicBoolean.class) {
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) field.get(obj);
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(((AtomicBoolean) obj2).get());
                    return;
                }
                return;
            }
            if (Map.class.isAssignableFrom(cls2)) {
                Map map2 = (Map) field.get(obj);
                if (map2 != null) {
                    map2.putAll((Map) obj2);
                    return;
                }
                return;
            }
            Collection collection2 = (Collection) field.get(obj);
            if (collection2 == null || obj2 == null) {
                return;
            }
            collection2.clear();
            collection2.addAll((Collection) obj2);
        } catch (Exception e) {
            throw new p050j.d("set property error, " + dVar.f7884a, e);
        }
    }
}
