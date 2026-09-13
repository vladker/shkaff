package cn.fly.tools.utils;

import cn.fly.FlySDK;
import cn.fly.commons.o;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;
import com.google.android.gms.internal.play_billing.zzhm;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.util.Chars;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HashonHelper implements PublicMemberKeeper {

    public interface a {
        Object a();
    }

    private static <T> HashMap<String, T> a(JSONObject jSONObject) {
        zzhm zzhmVar = (HashMap<String, T>) new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (JSONObject.NULL.equals(objOpt)) {
                objOpt = null;
            }
            if (objOpt != null) {
                if (objOpt instanceof JSONObject) {
                    objOpt = a((JSONObject) objOpt);
                } else if (objOpt instanceof JSONArray) {
                    objOpt = a((JSONArray) objOpt);
                }
                zzhmVar.put(next, objOpt);
            }
        }
        return zzhmVar;
    }

    private static ArrayList<?> b(Object obj) {
        int i5 = 0;
        if (obj instanceof byte[]) {
            ArrayList<?> arrayList = new ArrayList<>();
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            while (i5 < length) {
                arrayList.add(Byte.valueOf(bArr[i5]));
                i5++;
            }
            return arrayList;
        }
        if (obj instanceof short[]) {
            ArrayList<?> arrayList2 = new ArrayList<>();
            short[] sArr = (short[]) obj;
            int length2 = sArr.length;
            while (i5 < length2) {
                arrayList2.add(Short.valueOf(sArr[i5]));
                i5++;
            }
            return arrayList2;
        }
        if (obj instanceof int[]) {
            ArrayList<?> arrayList3 = new ArrayList<>();
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i5 < length3) {
                arrayList3.add(Integer.valueOf(iArr[i5]));
                i5++;
            }
            return arrayList3;
        }
        if (obj instanceof long[]) {
            ArrayList<?> arrayList4 = new ArrayList<>();
            long[] jArr = (long[]) obj;
            int length4 = jArr.length;
            while (i5 < length4) {
                arrayList4.add(Long.valueOf(jArr[i5]));
                i5++;
            }
            return arrayList4;
        }
        if (obj instanceof float[]) {
            ArrayList<?> arrayList5 = new ArrayList<>();
            float[] fArr = (float[]) obj;
            int length5 = fArr.length;
            while (i5 < length5) {
                arrayList5.add(Float.valueOf(fArr[i5]));
                i5++;
            }
            return arrayList5;
        }
        if (obj instanceof double[]) {
            ArrayList<?> arrayList6 = new ArrayList<>();
            double[] dArr = (double[]) obj;
            int length6 = dArr.length;
            while (i5 < length6) {
                arrayList6.add(Double.valueOf(dArr[i5]));
                i5++;
            }
            return arrayList6;
        }
        if (obj instanceof char[]) {
            ArrayList<?> arrayList7 = new ArrayList<>();
            char[] cArr = (char[]) obj;
            int length7 = cArr.length;
            while (i5 < length7) {
                arrayList7.add(Character.valueOf(cArr[i5]));
                i5++;
            }
            return arrayList7;
        }
        if (!(obj instanceof boolean[])) {
            if (obj instanceof String[]) {
                return new ArrayList<>(Arrays.asList((String[]) obj));
            }
            return null;
        }
        ArrayList<?> arrayList8 = new ArrayList<>();
        boolean[] zArr = (boolean[]) obj;
        int length8 = zArr.length;
        while (i5 < length8) {
            arrayList8.add(Boolean.valueOf(zArr[i5]));
            i5++;
        }
        return arrayList8;
    }

    private static Object c(Object obj) throws IllegalAccessException {
        if (obj == null || obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean)) {
            return obj;
        }
        if (obj instanceof a) {
            return c(((a) obj).a());
        }
        if (obj instanceof Enum) {
            HashMap map = new HashMap();
            map.put(o.a("004feEdgdf"), ((Enum) obj).name());
            return map;
        }
        int i5 = 0;
        if (obj.getClass().isArray()) {
            ArrayList arrayList = new ArrayList();
            int length = Array.getLength(obj);
            while (i5 < length) {
                arrayList.add(c(Array.get(obj, i5)));
                i5++;
            }
            return arrayList;
        }
        if (obj instanceof Collection) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                arrayList2.add(c(it.next()));
            }
            return arrayList2;
        }
        if (obj instanceof Map) {
            HashMap map2 = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    map2.put((String) key, c(entry.getValue()));
                }
            }
            return map2;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Class<?> superclass = obj.getClass(); !superclass.equals(Object.class); superclass = superclass.getSuperclass()) {
            arrayList3.add(0, superclass);
        }
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList3.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj2 = arrayList3.get(i6);
            i6++;
            for (Field field : ((Class) obj2).getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) && !field.getName().contains("$")) {
                    arrayList4.add(field);
                }
            }
        }
        HashMap map3 = new HashMap();
        int size2 = arrayList4.size();
        while (i5 < size2) {
            Object obj3 = arrayList4.get(i5);
            i5++;
            Field field2 = (Field) obj3;
            field2.setAccessible(true);
            map3.put(field2.getName(), c(field2.get(obj)));
        }
        return map3;
    }

    public static String format(String str) {
        try {
            return a("", (HashMap<String, Object>) fromJson(str));
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return "";
        }
    }

    public static <T> String fromHashMap(HashMap<String, T> map) {
        try {
            JSONObject jSONObjectA = a((HashMap) map);
            return jSONObjectA == null ? "" : jSONObjectA.toString();
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return "";
        }
    }

    public static <T> HashMap<String, T> fromJson(String str) {
        if (str == null || str.isEmpty()) {
            return new HashMap<>();
        }
        try {
            if (str.startsWith("[") && str.endsWith("]")) {
                str = "{\"fakelist\":" + str + VectorFormat.DEFAULT_SUFFIX;
            }
            return a(new JSONObject(str));
        } catch (Throwable th) {
            FlyLog.getInstance().w(str);
            FlyLog.getInstance().w(th);
            return new HashMap<>();
        }
    }

    public static String fromObject(Object obj) {
        Object objC;
        try {
            objC = c(obj);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            objC = null;
        }
        if (objC == null) {
            return "";
        }
        if (!(objC instanceof ArrayList)) {
            return fromHashMap((HashMap) objC);
        }
        HashMap map = new HashMap();
        map.put(o.a("004g?difi,i"), objC);
        String strFromHashMap = fromHashMap(map);
        return strFromHashMap.substring(8, strFromHashMap.length() - 1).trim();
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        HashMap mapFromJson = fromJson(str);
        Object obj = mapFromJson;
        if (str.startsWith("[") && str.endsWith("]")) {
            obj = mapFromJson;
            obj = mapFromJson.get(o.a("008Xef*d@ehYfg=difi?i"));
        }
        obj = mapFromJson;
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            return (T) a(obj, cls, genericSuperclass instanceof ParameterizedType ? ((ParameterizedType) genericSuperclass).getActualTypeArguments() : null);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    private static ArrayList<Object> a(JSONArray jSONArray) {
        ArrayList<Object> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            Object objOpt = jSONArray.opt(i5);
            if (objOpt instanceof JSONObject) {
                objOpt = a((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                objOpt = a((JSONArray) objOpt);
            }
            arrayList.add(objOpt);
        }
        return arrayList;
    }

    private static <T> JSONObject a(HashMap<String, T> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                value = a((HashMap) value);
            } else if (value instanceof ArrayList) {
                value = a((ArrayList<Object>) value);
            } else if (a(value)) {
                value = a((ArrayList<Object>) b(value));
            }
            jSONObject.put(entry.getKey(), value);
        }
        return jSONObject;
    }

    private static boolean a(Object obj) {
        return (obj instanceof byte[]) || (obj instanceof short[]) || (obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof float[]) || (obj instanceof double[]) || (obj instanceof char[]) || (obj instanceof boolean[]) || (obj instanceof String[]);
    }

    private static JSONArray a(ArrayList<Object> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object objA = arrayList.get(i5);
            i5++;
            if (objA instanceof HashMap) {
                objA = a((HashMap) objA);
            } else if (objA instanceof ArrayList) {
                objA = a((ArrayList<Object>) objA);
            }
            jSONArray.put(objA);
        }
        return jSONArray;
    }

    private static String a(String str, HashMap<String, Object> map) {
        StringBuilder sb = new StringBuilder("{\n");
        String strN = androidx.collection.a.n(str, "\t");
        int i5 = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (i5 > 0) {
                sb.append(",\n");
            }
            sb.append(strN);
            sb.append(Chars.DQUOTE);
            sb.append(entry.getKey());
            sb.append("\":");
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                sb.append(a(strN, (HashMap<String, Object>) value));
            } else if (value instanceof ArrayList) {
                sb.append(a(strN, (ArrayList<Object>) value));
            } else if (value instanceof String) {
                sb.append(Chars.DQUOTE);
                sb.append(value);
                sb.append(Chars.DQUOTE);
            } else {
                sb.append(value);
            }
            i5++;
        }
        sb.append('\n');
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    private static String a(String str, ArrayList<Object> arrayList) {
        StringBuilder sb = new StringBuilder("[\n");
        String strN = androidx.collection.a.n(str, "\t");
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            if (i5 > 0) {
                sb.append(",\n");
            }
            sb.append(strN);
            if (obj instanceof HashMap) {
                sb.append(a(strN, (HashMap<String, Object>) obj));
            } else if (obj instanceof ArrayList) {
                sb.append(a(strN, (ArrayList<Object>) obj));
            } else if (obj instanceof String) {
                sb.append(Chars.DQUOTE);
                sb.append(obj);
                sb.append(Chars.DQUOTE);
            } else {
                sb.append(obj);
            }
            i5++;
        }
        sb.append('\n');
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v12, types: [T, java.util.Collection] */
    private static <T> T a(Object obj, Class<T> cls, Type[] typeArr) throws Throwable {
        Field declaredField;
        Type type;
        Type type2;
        Object objA;
        Object objA2;
        int i5 = 0;
        if (!cls.isPrimitive() && !Number.class.isAssignableFrom(cls) && !cls.equals(Character.class)) {
            if (a.class.isAssignableFrom(cls)) {
                try {
                    return (T) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(cls.getName()), o.a("007JddFdgCdg<fGghef"), obj);
                } catch (Throwable unused) {
                    return null;
                }
            }
            if (cls.equals(String.class) || cls.equals(Boolean.class)) {
                return obj;
            }
            if (cls.isEnum()) {
                return (T) Enum.valueOf(cls, String.valueOf(((HashMap) obj).get(o.a("004feJdgdf"))));
            }
            if (cls.isArray()) {
                ArrayList arrayList = (ArrayList) obj;
                Class<?> componentType = cls.getComponentType();
                T t6 = (T) Array.newInstance(componentType, arrayList.size());
                int size = arrayList.size();
                while (i5 < size) {
                    Array.set(t6, i5, a(arrayList.get(i5), componentType, null));
                    i5++;
                }
                return t6;
            }
            if (Collection.class.isAssignableFrom(cls)) {
                ?? r10 = (T) ((Collection) cls.newInstance());
                Type type3 = (typeArr == null || typeArr.length <= 0) ? null : typeArr[0];
                ArrayList arrayList2 = (ArrayList) obj;
                int size2 = arrayList2.size();
                while (i5 < size2) {
                    if (type3 != null && (type3 instanceof Class) && !type3.equals(Object.class)) {
                        r10.add(a(arrayList2.get(i5), (Class) type3, null));
                    } else if (type3 != null && (type3 instanceof ParameterizedType)) {
                        ParameterizedType parameterizedType = (ParameterizedType) type3;
                        r10.add(a(arrayList2.get(i5), (Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments()));
                    } else {
                        r10.add(arrayList2.get(i5));
                    }
                    i5++;
                }
                return r10;
            }
            if (Map.class.isAssignableFrom(cls)) {
                ?? r11 = (T) ((Map) cls.newInstance());
                if (typeArr == null || typeArr.length <= 1) {
                    type = null;
                    type2 = null;
                } else {
                    type2 = typeArr[0];
                    type = typeArr[1];
                }
                HashMap map = (HashMap) obj;
                for (Object obj2 : map.keySet()) {
                    if (type2 != null && (type2 instanceof Class) && !type.equals(Object.class)) {
                        objA = a(obj2, (Class) type2, null);
                    } else if (type2 == null || !(type2 instanceof ParameterizedType)) {
                        objA = obj2;
                    } else {
                        ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                        objA = a(obj2, (Class) parameterizedType2.getRawType(), parameterizedType2.getActualTypeArguments());
                    }
                    if (type != null && (type instanceof Class) && !type.equals(Object.class)) {
                        objA2 = a(map.get(obj2), (Class) type, null);
                    } else if (type != null && (type instanceof ParameterizedType)) {
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        objA2 = a(map.get(obj2), (Class) parameterizedType3.getRawType(), parameterizedType3.getActualTypeArguments());
                    } else {
                        objA2 = map.get(obj2);
                    }
                    r11.put(objA, objA2);
                }
                return r11;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Class<T> superclass = cls; !superclass.equals(Object.class); superclass = superclass.getSuperclass()) {
                arrayList3.add(superclass);
            }
            HashMap map2 = (HashMap) obj;
            HashMap map3 = new HashMap();
            for (String str : map2.keySet()) {
                if (map2.get(str) != null) {
                    int size3 = arrayList3.size();
                    int i6 = 0;
                    while (i6 < size3) {
                        Object obj3 = arrayList3.get(i6);
                        i6++;
                        try {
                            declaredField = ((Class) obj3).getDeclaredField(str);
                        } catch (Throwable unused2) {
                            declaredField = null;
                        }
                        if (declaredField != null) {
                            map3.put(str, declaredField);
                            break;
                        }
                    }
                }
            }
            T t7 = (T) ReflectHelper.newInstance(ReflectHelper.getName(cls), new Object[0]);
            for (String str2 : map3.keySet()) {
                Object obj4 = map2.get(str2);
                Field field = (Field) map3.get(str2);
                Class<?> type4 = field.getType();
                Type genericType = field.getGenericType();
                Type[] actualTypeArguments = genericType instanceof ParameterizedType ? ((ParameterizedType) genericType).getActualTypeArguments() : null;
                field.setAccessible(true);
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && DH.SyncMtd.getOSVersionIntForFly() >= 37 && cn.fly.tools.b.c.a(FlySDK.getContext()).d().ar().targetSdkVersion >= 37) {
                    throw new Throwable("field static final field not allowed in 37");
                }
                field.set(t7, a(obj4, type4, actualTypeArguments));
            }
            return t7;
        }
        if (!cls.equals(Boolean.TYPE) && !cls.equals(Boolean.class)) {
            if (!cls.equals(Character.TYPE) && !cls.equals(Character.class)) {
                if (!cls.equals(Byte.TYPE) && !cls.equals(Byte.class)) {
                    if (!cls.equals(Short.TYPE) && !cls.equals(Short.class)) {
                        if (!cls.equals(Integer.TYPE) && !cls.equals(Integer.class)) {
                            if (!cls.equals(Long.TYPE) && !cls.equals(Long.class)) {
                                if (!cls.equals(Float.TYPE) && !cls.equals(Float.class)) {
                                    return (T) Double.valueOf(String.valueOf(obj));
                                }
                                return (T) Float.valueOf(String.valueOf(obj));
                            }
                            return (T) Long.valueOf(String.valueOf(obj));
                        }
                        return (T) Integer.valueOf(String.valueOf(obj));
                    }
                    return (T) Short.valueOf(String.valueOf(obj));
                }
                return (T) Byte.valueOf(String.valueOf(obj));
            }
            return (T) Character.valueOf(String.valueOf(obj).charAt(0));
        }
        return (T) Boolean.valueOf(o.a("004iKdjdg<f").equals(String.valueOf(obj)));
    }
}
