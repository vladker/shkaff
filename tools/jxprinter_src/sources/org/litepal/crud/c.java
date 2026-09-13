package org.litepal.crud;

import A3.AbstractC0157z;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.location.LocationRequestCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.XmlErrorCodes;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends Z4.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SQLiteDatabase f7678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f7679h;

    private boolean isFieldWithDefaultValue(f fVar, Field field) {
        f fVarU = u(fVar);
        Object fieldValue = getFieldValue(fVar, field);
        Object fieldValue2 = getFieldValue(fVarU, field);
        if (fieldValue == null || fieldValue2 == null) {
            return fieldValue == fieldValue2;
        }
        return fieldValue.toString().equals(fieldValue2.toString());
    }

    public static void n(f fVar, Collection collection) {
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                p019c5.a aVar = (p019c5.a) it.next();
                int i5 = aVar.f1192f;
                if (i5 == 2) {
                    new h().analyze(fVar, aVar);
                } else if (i5 == 1) {
                    new i().analyze(fVar, aVar);
                } else if (i5 == 3) {
                    new g().analyze(fVar, aVar);
                }
            }
        } catch (Exception e) {
            throw new p024d5.e(e.getMessage(), e);
        }
    }

    public static Object o(Class cls) {
        try {
            Constructor constructorR = r(cls);
            return constructorR.newInstance(s(cls, constructorR));
        } catch (Exception e) {
            throw new p024d5.e(e.getMessage(), e);
        }
    }

    public static Object p(Object obj, String str) {
        if (str == null || obj == null || !"AES".equalsIgnoreCase(str)) {
            return obj;
        }
        String str2 = (String) obj;
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            return j5.a.decrypt("LitePalKey", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void putFieldsValueDependsOnSaveOrUpdate(f fVar, Field field, ContentValues contentValues) {
        if (k.class.getName().equals(getClass().getName())) {
            if (isFieldWithDefaultValue(fVar, field)) {
                return;
            }
            putContentValuesForUpdate(fVar, field, contentValues);
        } else if (j.class.getName().equals(getClass().getName())) {
            putContentValuesForSave(fVar, field, contentValues);
        }
    }

    public static Object q(Object obj, String str) {
        if (str == null || obj == null) {
            return obj;
        }
        if ("AES".equalsIgnoreCase(str)) {
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str2)) {
                return str2;
            }
            try {
                return j5.a.encrypt("LitePalKey", str2);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (!MessageDigestAlgorithms.MD5.equalsIgnoreCase(str)) {
            return obj;
        }
        String str3 = (String) obj;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str3.getBytes(Charset.defaultCharset()));
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr = j5.b.f5463a;
            char[] cArr2 = new char[bArrDigest.length << 1];
            int i5 = 0;
            for (byte b : bArrDigest) {
                int i6 = i5 + 1;
                cArr2[i5] = cArr[(b & 240) >>> 4];
                i5 += 2;
                cArr2[i6] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static Constructor r(Class cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors.length == 0) {
            throw new p024d5.e(cls.getName().concat(" has no constructor. LitePal could not handle it"));
        }
        Constructor<?> constructor = null;
        int length = Integer.MAX_VALUE;
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            int length2 = parameterTypes.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    if (parameterTypes.length >= length) {
                        break;
                    }
                    length = parameterTypes.length;
                    constructor = constructor2;
                    break;
                }
                Class<?> cls2 = parameterTypes[i5];
                if (cls2 == cls || (cls2.getName().startsWith("com.android") && cls2.getName().endsWith("InstantReloadException"))) {
                    break;
                }
                i5++;
            }
        }
        if (constructor != null) {
            constructor.setAccessible(true);
            return constructor;
        }
        StringBuilder sb = new StringBuilder(cls.getName());
        sb.append(" has no suited constructor to new instance. Constructors defined in class:");
        for (Constructor<?> constructor3 : declaredConstructors) {
            sb.append("\n");
            sb.append(constructor3.toString());
        }
        throw new p024d5.e(sb.toString());
    }

    public static Object[] s(Class cls, Constructor constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i5 = 0; i5 < parameterTypes.length; i5++) {
            Class<?> cls2 = parameterTypes[i5];
            Object objValueOf = 0;
            String name = cls2.getName();
            if ("boolean".equals(name) || "java.lang.Boolean".equals(name)) {
                objValueOf = Boolean.FALSE;
            } else if ("float".equals(name) || "java.lang.Float".equals(name)) {
                objValueOf = Float.valueOf(0.0f);
            } else if (XmlErrorCodes.DOUBLE.equals(name) || "java.lang.Double".equals(name)) {
                objValueOf = Double.valueOf(0.0d);
            } else if (!XmlErrorCodes.INT.equals(name) && !"java.lang.Integer".equals(name)) {
                if (XmlErrorCodes.LONG.equals(name) || "java.lang.Long".equals(name)) {
                    objValueOf = 0L;
                } else if (!"short".equals(name) && !"java.lang.Short".equals(name)) {
                    if ("char".equals(name) || "java.lang.Character".equals(name)) {
                        objValueOf = Character.valueOf(Chars.SPACE);
                    } else if ("[B".equals(name) || "[Ljava.lang.Byte;".equals(name)) {
                        objValueOf = new byte[0];
                    } else if ("java.lang.String".equals(name)) {
                        objValueOf = "";
                    } else {
                        objValueOf = cls == cls2 ? null : o(cls2);
                    }
                }
            }
            objArr[i5] = objValueOf;
        }
        return objArr;
    }

    private void setToModelByReflection(Object obj, Field field, int i5, String str, Cursor cursor) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = cursor.getClass().getMethod(str, Integer.TYPE).invoke(cursor, Integer.valueOf(i5));
        if (field.getType() == Boolean.TYPE || field.getType() == Boolean.class) {
            if ("0".equals(String.valueOf(objInvoke))) {
                objInvoke = Boolean.FALSE;
            } else if ("1".equals(String.valueOf(objInvoke))) {
                objInvoke = Boolean.TRUE;
            }
        } else if (field.getType() == Character.TYPE || field.getType() == Character.class) {
            objInvoke = Character.valueOf(((String) objInvoke).charAt(0));
        } else if (field.getType() == Date.class) {
            long jLongValue = ((Long) objInvoke).longValue();
            objInvoke = jLongValue == LocationRequestCompat.PASSIVE_INTERVAL ? null : new Date(jLongValue);
        }
        if (!Z4.a.j(field.getType())) {
            p008a5.b bVar = (p008a5.b) field.getAnnotation(p008a5.b.class);
            if (bVar != null && "java.lang.String".equals(field.getType().getName())) {
                objInvoke = p(objInvoke, bVar.algorithm());
            }
            e.setField(obj, field.getName(), objInvoke, obj.getClass());
            return;
        }
        Collection arrayList = (Collection) e.getField(obj, field.getName(), obj.getClass());
        if (arrayList == null) {
            arrayList = List.class.isAssignableFrom(field.getType()) ? new ArrayList() : new HashSet();
            e.setField(obj, field.getName(), arrayList, obj.getClass());
        }
        Class clsF = Z4.a.f(field);
        String name = clsF != null ? clsF.getName() : null;
        if ("java.lang.String".equals(name)) {
            p008a5.b bVar2 = (p008a5.b) field.getAnnotation(p008a5.b.class);
            if (bVar2 != null) {
                objInvoke = p(objInvoke, bVar2.algorithm());
            }
        } else if (obj.getClass().getName().equals(name) && ((objInvoke instanceof Long) || (objInvoke instanceof Integer))) {
            objInvoke = Z4.b.a(obj.getClass(), ((Long) objInvoke).longValue());
        }
        arrayList.add(objInvoke);
    }

    public static String[] t(String[] strArr, List list, List list2) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Field) it.next()).getName());
        }
        boolean z6 = false;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            String str = (String) arrayList.get(i5);
            if (AbstractC1282k.c(str, arrayList2)) {
                arrayList3.add(Integer.valueOf(i5));
            } else if (Z4.a.k(str)) {
                if ("_id".equalsIgnoreCase(str)) {
                    arrayList.set(i5, AbstractC1282k.a("id"));
                }
                z6 = true;
            }
        }
        for (int size = arrayList3.size() - 1; size >= 0; size--) {
            arrayList4.add((String) arrayList.remove(((Integer) arrayList3.get(size)).intValue()));
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Field field = (Field) it2.next();
            if (AbstractC1282k.c(field.getName(), arrayList4)) {
                arrayList5.add(field);
            }
        }
        list.clear();
        list.addAll(arrayList5);
        if (list2 != null && list2.size() > 0) {
            for (int i6 = 0; i6 < list2.size(); i6++) {
                arrayList.add(Z4.a.e(J.k(((p019c5.a) list2.get(i6)).b)));
            }
        }
        if (!z6) {
            arrayList.add(AbstractC1282k.a("id"));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    public static Class[] v(Field field, Object obj, Object[] objArr) {
        String name = field.getType().getName();
        if (name.equals("char") || name.endsWith("Character")) {
            objArr[1] = String.valueOf(obj);
            return new Class[]{String.class, String.class};
        }
        Class cls = Long.class;
        if (!field.getType().isPrimitive()) {
            return "java.util.Date".equals(field.getType().getName()) ? new Class[]{String.class, cls} : new Class[]{String.class, field.getType()};
        }
        Class<?> type = field.getType();
        if (type == null || !type.isPrimitive()) {
            cls = null;
        } else {
            String name2 = type.getName();
            if (XmlErrorCodes.INT.equals(name2)) {
                cls = Integer.class;
            } else if ("short".equals(name2)) {
                cls = Short.class;
            } else if (!XmlErrorCodes.LONG.equals(name2)) {
                if ("float".equals(name2)) {
                    cls = Float.class;
                } else if (XmlErrorCodes.DOUBLE.equals(name2)) {
                    cls = Double.class;
                } else if ("boolean".equals(name2)) {
                    cls = Boolean.class;
                } else if ("char".equals(name2)) {
                    cls = Character.class;
                } else {
                    cls = null;
                }
            }
        }
        return new Class[]{String.class, cls};
    }

    public static String[] w(String... strArr) {
        if (strArr == null || strArr.length <= 1) {
            return null;
        }
        String[] strArr2 = new String[strArr.length - 1];
        System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        return strArr2;
    }

    public static String x(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    public f getAssociatedModel(f fVar, p019c5.a aVar) {
        return (f) getFieldValue(fVar, aVar.d);
    }

    public Collection<f> getAssociatedModels(f fVar, p019c5.a aVar) {
        return (Collection) getFieldValue(fVar, aVar.d);
    }

    public Object getFieldValue(f fVar, Field field) {
        if (fVar == null || field == null) {
            return null;
        }
        return e.getField(fVar, field.getName(), fVar.getClass());
    }

    public void giveBaseObjIdValue(f fVar, long j6) {
        if (j6 > 0) {
            e.set(fVar, "baseObjId", Long.valueOf(j6), f.class);
        }
    }

    public void putContentValuesForSave(f fVar, Field field, ContentValues contentValues) {
        Object fieldValue = getFieldValue(fVar, field);
        if ("java.util.Date".equals(field.getType().getName())) {
            if (fieldValue != null) {
                fieldValue = Long.valueOf(((Date) fieldValue).getTime());
            } else {
                p008a5.a aVar = (p008a5.a) field.getAnnotation(p008a5.a.class);
                if (aVar != null) {
                    String strDefaultValue = aVar.defaultValue();
                    if (!strDefaultValue.isEmpty()) {
                        try {
                            fieldValue = Long.valueOf(Long.parseLong(strDefaultValue));
                        } catch (NumberFormatException unused) {
                            Log.w("DataHandler", field + " in " + fVar.getClass() + " with invalid defaultValue. So we use null instead");
                        }
                    }
                }
                if (fieldValue == null) {
                    fieldValue = Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
                }
            }
        }
        if (fieldValue != null) {
            p008a5.b bVar = (p008a5.b) field.getAnnotation(p008a5.b.class);
            if (bVar != null && "java.lang.String".equals(field.getType().getName())) {
                fieldValue = q(fieldValue, bVar.algorithm());
            }
            Object[] objArr = {AbstractC1282k.a(J.b(field.getName())), fieldValue};
            e.send(contentValues, "put", objArr, contentValues.getClass(), v(field, fieldValue, objArr));
        }
    }

    public void putContentValuesForUpdate(f fVar, Field field, ContentValues contentValues) {
        Object fieldValue = getFieldValue(fVar, field);
        if ("java.util.Date".equals(field.getType().getName())) {
            fieldValue = fieldValue != null ? Long.valueOf(((Date) fieldValue).getTime()) : Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
        }
        p008a5.b bVar = (p008a5.b) field.getAnnotation(p008a5.b.class);
        if (bVar != null && "java.lang.String".equals(field.getType().getName())) {
            fieldValue = q(fieldValue, bVar.algorithm());
        }
        Object[] objArr = {AbstractC1282k.a(J.b(field.getName())), fieldValue};
        e.send(contentValues, "put", objArr, contentValues.getClass(), v(field, fieldValue, objArr));
    }

    public void putFieldsValue(f fVar, List<Field> list, ContentValues contentValues) {
        for (Field field : list) {
            if (!Z4.a.k(field.getName())) {
                putFieldsValueDependsOnSaveOrUpdate(fVar, field, contentValues);
            }
        }
    }

    public void setFieldValue(f fVar, Field field, Object obj) {
        if (fVar == null || field == null) {
            return;
        }
        e.setField(fVar, field.getName(), obj, fVar.getClass());
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00bd  */
    public void setGenericValueToModel(f fVar, List<Field> list, Map<Field, g5.c> map) throws Throwable {
        String strF;
        String str;
        String str2;
        String strB;
        Cursor cursor;
        String simpleName;
        for (Field field : list) {
            g5.c cVar = map.get(field);
            if (cVar == null) {
                Class clsF = Z4.a.f(field);
                String str3 = "getLong";
                if (fVar.getClassName().equals(clsF != null ? clsF.getName() : null)) {
                    strB = J.j(field);
                } else {
                    strB = J.b(field.getName());
                    Class<?> clsF2 = Z4.a.j(field.getType()) ? Z4.a.f(field) : field.getType();
                    if (clsF2.isPrimitive()) {
                        String name = clsF2.getName();
                        simpleName = TextUtils.isEmpty(name) ? "" : name.substring(0, 1).toUpperCase(Locale.US) + name.substring(1);
                    } else {
                        simpleName = clsF2.getSimpleName();
                    }
                    String strN = AbstractC0157z.n("get", simpleName);
                    if ("getBoolean".equals(strN)) {
                        str3 = "getInt";
                    } else if ("getChar".equals(strN) || "getCharacter".equals(strN)) {
                        str3 = "getString";
                    } else if (!"getDate".equals(strN)) {
                        if ("getInteger".equals(strN)) {
                            str3 = "getInt";
                        } else {
                            str3 = strN;
                        }
                    }
                }
                strF = J.f(fVar.getClassName(), field.getName());
                String strG = J.g(fVar.getClassName());
                g5.c cVar2 = new g5.c();
                cVar2.f4025a = strF;
                cVar2.b = strB;
                cVar2.d = strG;
                cVar2.e = str3;
                map.put(field, cVar2);
                str = strG;
                str2 = str3;
            } else {
                strF = cVar.f4025a;
                String str4 = cVar.b;
                str = cVar.d;
                str2 = cVar.e;
                strB = str4;
            }
            String str5 = str;
            c cVar3 = this;
            try {
                Cursor cursorQuery = cVar3.f7678g.query(strF, null, str5 + " = ?", new String[]{String.valueOf(fVar.getBaseObjId())}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            int columnIndex = cursorQuery.getColumnIndex(AbstractC1282k.a(strB));
                            if (columnIndex != -1) {
                                cVar3.setToModelByReflection(fVar, field, columnIndex, str2, cursorQuery);
                            }
                            if (!cursorQuery.moveToNext()) {
                                break;
                            } else {
                                cVar3 = this;
                            }
                        }
                    }
                    cursorQuery.close();
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    public void setValueToModel(Object obj, List<Field> list, List<p019c5.a> list2, Cursor cursor, SparseArray<b> sparseArray) throws IllegalAccessException, InvocationTargetException {
        String simpleName;
        int size = sparseArray.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = sparseArray.keyAt(i5);
                b bVar = sparseArray.get(iKeyAt);
                setToModelByReflection(obj, bVar.b, iKeyAt, bVar.f7677a, cursor);
            }
        } else {
            for (Field field : list) {
                Class<?> clsF = Z4.a.j(field.getType()) ? Z4.a.f(field) : field.getType();
                if (clsF.isPrimitive()) {
                    String name = clsF.getName();
                    simpleName = TextUtils.isEmpty(name) ? "" : name.substring(0, 1).toUpperCase(Locale.US) + name.substring(1);
                } else {
                    simpleName = clsF.getSimpleName();
                }
                String strN = AbstractC0157z.n("get", simpleName);
                if ("getBoolean".equals(strN)) {
                    strN = "getInt";
                } else if ("getChar".equals(strN) || "getCharacter".equals(strN)) {
                    strN = "getString";
                } else if ("getDate".equals(strN)) {
                    strN = "getLong";
                } else if ("getInteger".equals(strN)) {
                    strN = "getInt";
                }
                String str = strN;
                int columnIndex = cursor.getColumnIndex(AbstractC1282k.a(Z4.a.k(field.getName()) ? "id" : J.b(field.getName())));
                if (columnIndex != -1) {
                    setToModelByReflection(obj, field, columnIndex, str, cursor);
                    b bVar2 = new b();
                    bVar2.f7677a = str;
                    bVar2.b = field;
                    sparseArray.put(columnIndex, bVar2);
                }
            }
        }
        if (list2 != null) {
            for (p019c5.a aVar : list2) {
                int columnIndex2 = cursor.getColumnIndex(Z4.a.e(J.k(aVar.b)));
                if (columnIndex2 != -1) {
                    try {
                        f fVar = (f) Z4.b.a(Class.forName(aVar.b), cursor.getLong(columnIndex2));
                        if (fVar != null) {
                            setFieldValue((f) obj, aVar.d, fVar);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final f u(f fVar) {
        f fVar2 = this.f7679h;
        if (fVar2 != null) {
            return fVar2;
        }
        String className = null;
        try {
            className = fVar.getClassName();
            f fVar3 = (f) Class.forName(className).newInstance();
            this.f7679h = fVar3;
            return fVar3;
        } catch (ClassNotFoundException unused) {
            throw new p024d5.b(AbstractC0157z.n("can not find a class named ", className));
        } catch (InstantiationException e) {
            throw new p024d5.e(androidx.collection.a.n(className, " needs a default constructor."), e);
        } catch (Exception e6) {
            throw new p024d5.e(e6.getMessage(), e6);
        }
    }

    public final ArrayList y(Class cls, String[] strArr, String str, String[] strArr2, String str2, String str3, ArrayList arrayList) throws Throwable {
        String[] strArr3;
        List<p019c5.a> list = arrayList;
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                List listG = g(cls.getName());
                List listH = h(cls.getName());
                String[] strArrT = t(strArr, listH, list);
                if (strArrT == null || strArrT.length <= 0) {
                    strArr3 = null;
                } else {
                    String[] strArr4 = new String[strArrT.length];
                    for (int i5 = 0; i5 < strArrT.length; i5++) {
                        strArr4[i5] = J.b(strArrT[i5]);
                    }
                    strArr3 = strArr4;
                }
                Cursor cursorQuery = this.f7678g.query(AbstractC1282k.a(J.k(cls.getName())), strArr3, str, strArr2, null, null, str2, str3);
                try {
                    if (cursorQuery.moveToFirst()) {
                        SparseArray<b> sparseArray = new SparseArray<>();
                        HashMap map = new HashMap();
                        while (true) {
                            Object objO = o(cls);
                            giveBaseObjIdValue((f) objO, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("id")));
                            setValueToModel(objO, listG, list, cursorQuery, sparseArray);
                            setGenericValueToModel((f) objO, listH, map);
                            if (arrayList != null) {
                            }
                            arrayList2.add(objO);
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            list = arrayList;
                        }
                        sparseArray.clear();
                        map.clear();
                    }
                    cursorQuery.close();
                    return arrayList2;
                } catch (Exception e) {
                    e = e;
                    throw new p024d5.e(e.getMessage(), e);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }
}
