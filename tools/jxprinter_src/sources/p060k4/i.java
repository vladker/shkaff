package p060k4;

import A3.AbstractC0151t;
import A3.C;
import A3.I;
import A3.j0;
import A3.k0;
import O3.a;
import V3.c;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import kotlin.jvm.internal.X;
import org.apache.logging.log4j.util.Chars;
import p072m4.C1241a;
import p072m4.r;
import p072m4.w;
import p072m4.x;
import p078n4.f;
import p078n4.l;
import p084o4.AbstractC1299b;
import p147z3.AbstractC1935o;
import p147z3.EnumC1936p;
import p147z3.InterfaceC1934n;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends AbstractC1299b {
    private List<? extends Annotation> _annotations;
    private final c baseClass;
    private final Map<c, b> class2Serializer;
    private final InterfaceC1934n descriptor$delegate;
    private final Map<String, b> serialName2Serializer;

    public i(String serialName, c baseClass, c[] subclasses, b[] subclassSerializers) {
        E.f(serialName, "serialName");
        E.f(baseClass, "baseClass");
        E.f(subclasses, "subclasses");
        E.f(subclassSerializers, "subclassSerializers");
        this.baseClass = baseClass;
        this._annotations = I.emptyList();
        this.descriptor$delegate = AbstractC1935o.lazy(EnumC1936p.f9133a, (a) new g(serialName, this, 0));
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + getBaseClass().getSimpleName() + " should be marked @Serializable");
        }
        Map<c, b> map = k0.toMap(C.zip(subclasses, subclassSerializers));
        this.class2Serializer = map;
        Set<Map.Entry<c, b>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String serialName2 = ((b) entry.getValue()).getDescriptor().getSerialName();
            Object obj = linkedHashMap.get(serialName2);
            if (obj == null) {
                linkedHashMap.containsKey(serialName2);
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + getBaseClass() + "' have the same serial name '" + serialName2 + "': '" + entry2.getKey() + "', '" + entry.getKey() + Chars.QUOTE).toString());
            }
            linkedHashMap.put(serialName2, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j0.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (b) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.serialName2Serializer = linkedHashMap2;
    }

    public static Q a(i iVar, C1241a buildSerialDescriptor) {
        E.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        buildSerialDescriptor.element("type", p066l4.a.serializer(X.INSTANCE).getDescriptor(), I.emptyList(), false);
        buildSerialDescriptor.element("value", w.buildSerialDescriptor("kotlinx.serialization.Sealed<" + iVar.getBaseClass().getSimpleName() + '>', x.INSTANCE, new r[0], new h(iVar, 1)), I.emptyList(), false);
        buildSerialDescriptor.setAnnotations(iVar._annotations);
        return Q.INSTANCE;
    }

    public static Q b(i iVar, C1241a buildSerialDescriptor) {
        E.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        for (Map.Entry<String, b> entry : iVar.serialName2Serializer.entrySet()) {
            buildSerialDescriptor.element(entry.getKey(), entry.getValue().getDescriptor(), I.emptyList(), false);
        }
        return Q.INSTANCE;
    }

    @Override // p084o4.AbstractC1299b
    public a findPolymorphicSerializerOrNull(f decoder, String str) {
        E.f(decoder, "decoder");
        b bVar = this.serialName2Serializer.get(str);
        return bVar != null ? bVar : super.findPolymorphicSerializerOrNull(decoder, str);
    }

    @Override // p084o4.AbstractC1299b
    public c getBaseClass() {
        return this.baseClass;
    }

    @Override // p084o4.AbstractC1299b, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return (r) this.descriptor$delegate.getValue();
    }

    @Override // p084o4.AbstractC1299b
    public m findPolymorphicSerializerOrNull(l encoder, Object value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        b bVarFindPolymorphicSerializerOrNull = this.class2Serializer.get(U.a(value.getClass()));
        if (bVarFindPolymorphicSerializerOrNull == null) {
            bVarFindPolymorphicSerializerOrNull = super.findPolymorphicSerializerOrNull(encoder, value);
        }
        if (bVarFindPolymorphicSerializerOrNull != null) {
            return bVarFindPolymorphicSerializerOrNull;
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(String serialName, c baseClass, c[] subclasses, b[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        E.f(serialName, "serialName");
        E.f(baseClass, "baseClass");
        E.f(subclasses, "subclasses");
        E.f(subclassSerializers, "subclassSerializers");
        E.f(classAnnotations, "classAnnotations");
        this._annotations = AbstractC0151t.asList(classAnnotations);
    }
}
