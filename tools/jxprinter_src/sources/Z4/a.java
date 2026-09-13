package Z4;

import A3.AbstractC0157z;
import g5.c;
import g5.d;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.xmlbeans.XmlErrorCodes;
import org.litepal.crud.f;
import p067m.h;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h[] f901a = {new h5.a(4), new h5.a(5), new h5.a(1), new h5.a(3), new h5.a(2), new h5.a(0)};
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public HashSet d;
    public HashSet e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashSet f902f;

    public static String e(String str) {
        return AbstractC1282k.a(str + "_id");
    }

    public static Class f(Field field) {
        Type genericType = field.getGenericType();
        if (genericType == null || !(genericType instanceof ParameterizedType)) {
            return null;
        }
        return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
    }

    public static boolean j(Class cls) {
        return List.class.isAssignableFrom(cls) || Set.class.isAssignableFrom(cls);
    }

    public static boolean k(String str) {
        return "_id".equalsIgnoreCase(str) || "id".equalsIgnoreCase(str);
    }

    public static void l(Class cls, ArrayList arrayList) {
        if (cls == f.class || cls == Object.class) {
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                p008a5.a aVar = (p008a5.a) field.getAnnotation(p008a5.a.class);
                if ((aVar == null || !aVar.ignore()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getType().getName();
                    if ("boolean".equals(name) || "java.lang.Boolean".equals(name) || "float".equals(name) || "java.lang.Float".equals(name) || XmlErrorCodes.DOUBLE.equals(name) || "java.lang.Double".equals(name) || XmlErrorCodes.INT.equals(name) || "java.lang.Integer".equals(name) || XmlErrorCodes.LONG.equals(name) || "java.lang.Long".equals(name) || "short".equals(name) || "java.lang.Short".equals(name) || "char".equals(name) || "java.lang.Character".equals(name) || "java.lang.String".equals(name) || "java.util.Date".equals(name)) {
                        arrayList.add(field);
                    }
                }
            }
        }
        l(cls.getSuperclass(), arrayList);
    }

    public static void m(Class cls, ArrayList arrayList) {
        if (cls == f.class || cls == Object.class) {
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                p008a5.a aVar = (p008a5.a) field.getAnnotation(p008a5.a.class);
                if ((aVar == null || !aVar.ignore()) && !Modifier.isStatic(field.getModifiers()) && j(field.getType())) {
                    Class clsF = f(field);
                    String name = clsF != null ? clsF.getName() : null;
                    if (AbstractC1282k.d(name) || cls.getName().equalsIgnoreCase(name)) {
                        arrayList.add(field);
                    }
                }
            }
        }
        m(cls.getSuperclass(), arrayList);
    }

    private void manyToAnyConditions(String str, Field field, int i5) {
        Field field2;
        String str2;
        if (j(field.getType())) {
            Class clsF = f(field);
            String str3 = null;
            String name = clsF != null ? clsF.getName() : null;
            int i6 = 0;
            if (!p029e5.a.b().a().contains(name)) {
                if (AbstractC1282k.d(name) && i5 == 1) {
                    c cVar = new c();
                    cVar.f4025a = J.f(str, field.getName());
                    cVar.b = J.b(field.getName());
                    h[] hVarArr = this.f901a;
                    int length = hVarArr.length;
                    while (i6 < length) {
                        String strB = hVarArr[i6].b(name);
                        if (strB != null) {
                            str3 = strB;
                            break;
                        }
                        i6++;
                    }
                    cVar.c = str3;
                    cVar.d = J.g(str);
                    this.f902f.add(cVar);
                    return;
                }
                return;
            }
            Field[] declaredFields = Class.forName(name).getDeclaredFields();
            int length2 = declaredFields.length;
            int i7 = 0;
            while (i7 < length2) {
                Field field3 = declaredFields[i7];
                if (Modifier.isStatic(field3.getModifiers())) {
                    field2 = field;
                    str2 = str;
                } else {
                    Class<?> type = field3.getType();
                    if (str.equals(type.getName())) {
                        if (i5 == 1) {
                            b(2, str, name, name);
                        } else if (i5 == 2) {
                            String str4 = str;
                            field2 = field;
                            a(str4, name, name, field2, field3, 2);
                            str2 = str4;
                        }
                        field2 = field;
                        str2 = str;
                    } else {
                        field2 = field;
                        str2 = str;
                        if (j(type)) {
                            Class clsF2 = f(field3);
                            if (str2.equals(clsF2 != null ? clsF2.getName() : null)) {
                                if (i5 == 1) {
                                    if (str2.equalsIgnoreCase(name)) {
                                        c cVar2 = new c();
                                        cVar2.f4025a = J.f(str2, field2.getName());
                                        cVar2.b = J.j(field2);
                                        cVar2.c = "integer";
                                        cVar2.d = J.g(str2);
                                        this.f902f.add(cVar2);
                                    } else {
                                        b(3, str2, name, null);
                                    }
                                } else if (i5 == 2 && !str2.equalsIgnoreCase(name)) {
                                    a(str2, name, null, field2, field3, 3);
                                }
                            }
                        }
                    }
                    i6 = 1;
                }
                i7++;
                str = str2;
                field = field2;
            }
            Field field4 = field;
            String str5 = str;
            if (i6 == 0) {
                if (i5 == 1) {
                    b(2, str5, name, name);
                } else if (i5 == 2) {
                    a(str5, name, name, field4, null, 2);
                }
            }
        }
    }

    private void oneToAnyConditions(String str, Field field, int i5) {
        Class<?> type = field.getType();
        if (p029e5.a.b().a().contains(type.getName())) {
            boolean z6 = false;
            for (Field field2 : Class.forName(type.getName()).getDeclaredFields()) {
                if (!Modifier.isStatic(field2.getModifiers())) {
                    Class<?> type2 = field2.getType();
                    if (str.equals(type2.getName())) {
                        if (i5 == 1) {
                            b(1, str, type.getName(), type.getName());
                        } else if (i5 == 2) {
                            a(str, type.getName(), type.getName(), field, field2, 1);
                        }
                    } else if (j(type2)) {
                        Class clsF = f(field2);
                        if (str.equals(clsF != null ? clsF.getName() : null)) {
                            if (i5 == 1) {
                                b(2, str, type.getName(), str);
                            } else if (i5 == 2) {
                                a(str, type.getName(), str, field, field2, 2);
                            }
                        }
                    }
                    z6 = true;
                }
            }
            if (z6) {
                return;
            }
            if (i5 == 1) {
                b(1, str, type.getName(), type.getName());
            } else if (i5 == 2) {
                a(str, type.getName(), type.getName(), field, null, 1);
            }
        }
    }

    public final void a(String str, String str2, String str3, Field field, Field field2, int i5) {
        p019c5.a aVar = new p019c5.a();
        aVar.f1191a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.d = field;
        aVar.e = field2;
        aVar.f1192f = i5;
        this.e.add(aVar);
    }

    public final void b(int i5, String str, String str2, String str3) {
        g5.a aVar = new g5.a();
        aVar.f4023a = J.k(str);
        aVar.b = J.k(str2);
        aVar.c = J.k(str3);
        aVar.d = i5;
        this.d.add(aVar);
    }

    public final void c(int i5, String str) {
        p008a5.a aVar;
        try {
            for (Field field : Class.forName(str).getDeclaredFields()) {
                if (!field.getType().isPrimitive() && ((aVar = (p008a5.a) field.getAnnotation(p008a5.a.class)) == null || !aVar.ignore())) {
                    oneToAnyConditions(str, field, i5);
                    manyToAnyConditions(str, field, i5);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new p024d5.b(AbstractC0157z.n("can not find a class named ", str));
        }
    }

    public final Collection d(String str) {
        if (this.e == null) {
            this.e = new HashSet();
        }
        this.e.clear();
        c(2, str);
        return this.e;
    }

    public final List g(String str) {
        HashMap map = this.b;
        List list = (List) map.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        try {
            l(Class.forName(str), arrayList);
            map.put(str, arrayList);
            return arrayList;
        } catch (ClassNotFoundException unused) {
            throw new p024d5.b(AbstractC0157z.n("can not find a class named ", str));
        }
    }

    public final List h(String str) {
        HashMap map = this.c;
        List list = (List) map.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        try {
            m(Class.forName(str), arrayList);
            map.put(str, arrayList);
            return arrayList;
        } catch (ClassNotFoundException unused) {
            throw new p024d5.b(AbstractC0157z.n("can not find a class named ", str));
        }
    }

    public final d i(String str) {
        String strB;
        boolean zNullable;
        String strDefaultValue;
        String strK = J.k(str);
        d dVar = new d();
        dVar.f4026a = strK;
        dVar.c = str;
        for (Field field : g(str)) {
            String name = field.getType().getName();
            h[] hVarArr = this.f901a;
            int length = hVarArr.length;
            boolean zUnique = false;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    strB = null;
                    break;
                }
                strB = hVarArr[i5].b(name);
                if (strB != null) {
                    break;
                }
                i5++;
            }
            p008a5.a aVar = (p008a5.a) field.getAnnotation(p008a5.a.class);
            if (aVar != null) {
                zNullable = aVar.nullable();
                zUnique = aVar.unique();
                strDefaultValue = aVar.defaultValue();
            } else {
                zNullable = true;
                strDefaultValue = "";
            }
            g5.b bVar = new g5.b();
            bVar.f4024a = J.b(field.getName());
            bVar.b = strB;
            bVar.c = zNullable;
            bVar.d = zUnique;
            bVar.b(strDefaultValue);
            dVar.b.put(AbstractC1282k.a(bVar.f4024a), bVar);
        }
        return dVar;
    }
}
