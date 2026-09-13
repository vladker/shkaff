package p050j;

import androidx.exifinterface.media.a;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p067m.j;
import p079o.C1296z;
import p079o.H;
import p079o.Q;
import p079o.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements c {
    public static final ConcurrentHashMap d = new ConcurrentHashMap(128, 0.75f, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5392a;
    public p[] b;
    public final Y c;

    public r(String str) {
        Y y6 = Y.e;
        String[] strArr = j.f6105i;
        if (str == null || str.length() == 0) {
            throw new s("json-path can not be null or empty");
        }
        this.f5392a = str;
        this.c = y6;
    }

    public static Object b(int i5, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i5 >= 0) {
                if (i5 < list.size()) {
                    return list.get(i5);
                }
                return null;
            }
            if (Math.abs(i5) <= list.size()) {
                return list.get(list.size() + i5);
            }
            return null;
        }
        if (!obj.getClass().isArray()) {
            if (!(obj instanceof Map)) {
                throw new UnsupportedOperationException();
            }
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i5));
            return obj2 == null ? map.get(Integer.toString(i5)) : obj2;
        }
        int length = Array.getLength(obj);
        if (i5 >= 0) {
            if (i5 < length) {
                return Array.get(obj, i5);
            }
            return null;
        }
        if (Math.abs(i5) <= length) {
            return Array.get(obj, length + i5);
        }
        return null;
    }

    public final void a(Object obj, String str, ArrayList arrayList) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                arrayList.add(map.get(str));
                return;
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                a(it.next(), str, arrayList);
            }
            return;
        }
        H hC = c(obj.getClass());
        if (hC == null) {
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    a(list.get(i5), str, arrayList);
                }
                return;
            }
            return;
        }
        try {
            C1296z c1296zF = hC.f(str);
            if (c1296zF == null) {
                Iterator<Object> it2 = hC.getFieldValues(obj).iterator();
                while (it2.hasNext()) {
                    a(it2.next(), str, arrayList);
                }
                return;
            }
            try {
                try {
                    arrayList.add(c1296zF.getPropertyValueDirect(obj));
                } catch (InvocationTargetException e) {
                    throw new d("getFieldValue error." + str, e);
                }
            } catch (IllegalAccessException e6) {
                throw new d("getFieldValue error." + str, e6);
            }
        } catch (Exception e7) {
            throw new s(a.r(new StringBuilder("jsonpath error, path "), this.f5392a, ", segement ", str), e7);
        }
    }

    public final H c(Class cls) {
        Q qB = this.c.b(cls);
        if (qB instanceof H) {
            return (H) qB;
        }
        return null;
    }

    public final Object d(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            return (obj2 == null && "size".equals(str)) ? Integer.valueOf(map.size()) : obj2;
        }
        H hC = c(obj.getClass());
        String str2 = this.f5392a;
        if (hC != null) {
            try {
                return hC.g(obj, str);
            } catch (Exception e) {
                throw new s(a.m("jsonpath error, path ", str2, ", segement ", str), e);
            }
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if ("size".equals(str)) {
                return Integer.valueOf(list.size());
            }
            b bVar = new b(list.size());
            for (int i5 = 0; i5 < list.size(); i5++) {
                Object objD = d(list.get(i5), str);
                if (objD instanceof Collection) {
                    bVar.addAll((Collection) objD);
                } else {
                    bVar.add(objD);
                }
            }
            return bVar;
        }
        if (obj instanceof Enum) {
            Enum r6 = (Enum) obj;
            if ("name".equals(str)) {
                return r6.name();
            }
            if ("ordinal".equals(str)) {
                return Integer.valueOf(r6.ordinal());
            }
        }
        if (obj instanceof Calendar) {
            Calendar calendar = (Calendar) obj;
            if ("year".equals(str)) {
                return Integer.valueOf(calendar.get(1));
            }
            if ("month".equals(str)) {
                return Integer.valueOf(calendar.get(2));
            }
            if ("day".equals(str)) {
                return Integer.valueOf(calendar.get(5));
            }
            if ("hour".equals(str)) {
                return Integer.valueOf(calendar.get(11));
            }
            if ("minute".equals(str)) {
                return Integer.valueOf(calendar.get(12));
            }
            if ("second".equals(str)) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        throw new s(a.m("jsonpath error, path ", str2, ", segement ", str));
    }

    @Override // p050j.c
    public final String e() {
        return a.g(this.f5392a);
    }
}
