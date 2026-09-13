package kotlin.jvm.internal;

import A3.j0;
import A3.k0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;
import p147z3.C1938s;
import p147z3.InterfaceC1927g;

/* JADX INFO: renamed from: kotlin.jvm.internal.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1105t implements V3.c, r {
    public static final C1104s Companion = new C1104s();
    private static final Map<Class<? extends InterfaceC1927g>, Integer> FUNCTION_CLASSES;
    private static final HashMap<String, String> classFqNames;
    private static final HashMap<String, String> primitiveFqNames;
    private static final HashMap<String, String> primitiveWrapperFqNames;
    private static final Map<String, String> simpleNames;
    private final Class<?> jClass;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List listListOf = A3.I.listOf((Object[]) new Class[]{O3.a.class, O3.l.class, O3.p.class, O3.q.class, O3.r.class, O3.s.class, O3.t.class, O3.u.class, O3.v.class, O3.w.class, O3.b.class, O3.c.class, O3.d.class, O3.e.class, O3.f.class, O3.g.class, O3.h.class, O3.i.class, O3.j.class, O3.k.class, O3.m.class, O3.n.class, O3.o.class});
        ArrayList arrayList = new ArrayList(A3.J.collectionSizeOrDefault(listListOf, 10));
        int i5 = 0;
        for (Object obj : listListOf) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                A3.I.throwIndexOverflow();
            }
            arrayList.add(p147z3.A.to((Class) obj, Integer.valueOf(i5)));
            i5 = i6;
        }
        FUNCTION_CLASSES = k0.toMap(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put(XmlErrorCodes.INT, "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put(XmlErrorCodes.LONG, "kotlin.Long");
        map.put(XmlErrorCodes.DOUBLE, "kotlin.Double");
        primitiveFqNames = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        E.e(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            E.c(str);
            sb.append(X3.b0.substringAfterLast(str, '.', str));
            sb.append("CompanionObject");
            C1938s c1938s = p147z3.A.to(sb.toString(), str + ".Companion");
            map3.put(c1938s.f9134a, c1938s.b);
        }
        for (Map.Entry<Class<? extends InterfaceC1927g>, Integer> entry : FUNCTION_CLASSES.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        classFqNames = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.mapCapacity(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            E.c(str2);
            linkedHashMap.put(key, X3.b0.substringAfterLast(str2, '.', str2));
        }
        simpleNames = linkedHashMap;
    }

    public C1105t(Class<?> jClass) {
        E.f(jClass, "jClass");
        this.jClass = jClass;
    }

    public static void e() {
        throw new N3.b();
    }

    @Override // V3.c
    public boolean equals(Object obj) {
        return (obj instanceof C1105t) && E.a(N3.a.getJavaObjectType(this), N3.a.getJavaObjectType((V3.c) obj));
    }

    @Override // V3.c, V3.a
    public List<Annotation> getAnnotations() {
        e();
        throw null;
    }

    @Override // V3.c
    public Collection<V3.g> getConstructors() {
        e();
        throw null;
    }

    @Override // kotlin.jvm.internal.r
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // V3.c, V3.f
    public Collection<V3.b> getMembers() {
        e();
        throw null;
    }

    @Override // V3.c
    public Collection<V3.c> getNestedClasses() {
        e();
        throw null;
    }

    @Override // V3.c
    public Object getObjectInstance() {
        e();
        throw null;
    }

    @Override // V3.c
    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    @Override // V3.c
    public List<V3.c> getSealedSubclasses() {
        e();
        throw null;
    }

    @Override // V3.c
    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    @Override // V3.c
    public List<V3.p> getSupertypes() {
        e();
        throw null;
    }

    @Override // V3.c
    public List<V3.q> getTypeParameters() {
        e();
        throw null;
    }

    @Override // V3.c
    public V3.v getVisibility() {
        e();
        throw null;
    }

    @Override // V3.c
    public final int hashCode() {
        return N3.a.getJavaObjectType(this).hashCode();
    }

    @Override // V3.c
    public boolean isInstance(Object obj) {
        return Companion.isInstance(obj, getJClass());
    }

    public String toString() {
        return getJClass() + " (Kotlin reflection is not available)";
    }

    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    public static /* synthetic */ void getSupertypes$annotations() {
    }

    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isFun$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void isValue$annotations() {
    }
}
