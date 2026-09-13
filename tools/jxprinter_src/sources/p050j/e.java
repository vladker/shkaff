package p050j;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p055k.b;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends a implements Map, Cloneable, Serializable, InvocationHandler {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f5380j;

    public e(Map map) {
        this.f5380j = map;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f5380j.clear();
    }

    public final Object clone() {
        Map map = this.f5380j;
        return new e(map instanceof LinkedHashMap ? new LinkedHashMap(map) : new HashMap(map));
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f5380j.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f5380j.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return this.f5380j.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return this.f5380j.equals(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f5380j.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f5380j.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        Class<?> cls = Void.TYPE;
        String strName = null;
        Map map = this.f5380j;
        if (length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(map.equals(objArr[0]));
            }
            if (method.getReturnType() != cls) {
                throw new d("illegal setter");
            }
            b bVar = (b) method.getAnnotation(b.class);
            String strName2 = (bVar == null || bVar.name().length() == 0) ? null : bVar.name();
            if (strName2 == null) {
                String name = method.getName();
                if (!name.startsWith("set")) {
                    throw new d("illegal setter");
                }
                String strSubstring = name.substring(3);
                if (strSubstring.length() == 0) {
                    throw new d("illegal setter");
                }
                strName2 = Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
            }
            map.put(strName2, objArr[0]);
            return null;
        }
        if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        }
        if (method.getReturnType() == cls) {
            throw new d("illegal getter");
        }
        b bVar2 = (b) method.getAnnotation(b.class);
        if (bVar2 != null && bVar2.name().length() != 0) {
            strName = bVar2.name();
        }
        if (strName == null) {
            String name2 = method.getName();
            if (name2.startsWith("get")) {
                String strSubstring2 = name2.substring(3);
                if (strSubstring2.length() == 0) {
                    throw new d("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring2.charAt(0)) + strSubstring2.substring(1);
            } else {
                if (!name2.startsWith("is")) {
                    if (name2.startsWith("hashCode")) {
                        return Integer.valueOf(map.hashCode());
                    }
                    if (name2.startsWith("toString")) {
                        return e();
                    }
                    throw new d("illegal getter");
                }
                String strSubstring3 = name2.substring(2);
                if (strSubstring3.length() == 0) {
                    throw new d("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring3.charAt(0)) + strSubstring3.substring(1);
            }
        }
        return j.c(map.get(strName), method.getGenericReturnType(), p067m.j.f6108l);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f5380j.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return this.f5380j.keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f5380j.put((String) obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f5380j.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f5380j.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f5380j.size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f5380j.values();
    }

    public e(boolean z6, int i5) {
        if (z6) {
            this.f5380j = new LinkedHashMap(16);
        } else {
            this.f5380j = new HashMap(16);
        }
    }
}
