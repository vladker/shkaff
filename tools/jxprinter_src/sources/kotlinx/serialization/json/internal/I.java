package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.logging.log4j.util.Chars;
import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class I {
    private static final C1143t JsonDeserializationNamesKey = new C1143t();
    private static final C1143t JsonSerializationNamesKey = new C1143t();

    public static final void a(LinkedHashMap linkedHashMap, p072m4.r rVar, String str, int i5) {
        String str2 = kotlin.jvm.internal.E.a(rVar.getKind(), p072m4.y.INSTANCE) ? "enum value" : "property";
        if (!linkedHashMap.containsKey(str)) {
            linkedHashMap.put(str, Integer.valueOf(i5));
            return;
        }
        throw new D("The suggested name '" + str + "' for " + str2 + Chars.SPACE + rVar.getElementName(i5) + " is already one of the names for " + str2 + Chars.SPACE + rVar.getElementName(((Number) A3.k0.getValue(linkedHashMap, str)).intValue()) + " in " + rVar);
    }

    public static final Map<String, Integer> deserializationNamesMap(AbstractC1519d abstractC1519d, p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(abstractC1519d, "<this>");
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return (Map) p089p4.G.getSchemaCache(abstractC1519d).getOrPut(descriptor, JsonDeserializationNamesKey, new p060k4.g(descriptor, abstractC1519d, 1));
    }

    public static final C1143t getJsonDeserializationNamesKey() {
        return JsonDeserializationNamesKey;
    }

    public static final String getJsonElementName(p072m4.r rVar, AbstractC1519d json, int i5) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(json, "json");
        p089p4.w wVarNamingStrategy = namingStrategy(rVar, json);
        return wVarNamingStrategy == null ? rVar.getElementName(i5) : serializationNamesIndices(rVar, json, wVarNamingStrategy)[i5];
    }

    public static final int getJsonNameIndex(p072m4.r rVar, AbstractC1519d json, String name) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(name, "name");
        if (json.getConfiguration().f7764k && kotlin.jvm.internal.E.a(rVar.getKind(), p072m4.y.INSTANCE)) {
            String lowerCase = name.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
            Integer num = deserializationNamesMap(json, rVar).get(lowerCase);
            if (num != null) {
                return num.intValue();
            }
            return -3;
        }
        if (namingStrategy(rVar, json) != null) {
            Integer num2 = deserializationNamesMap(json, rVar).get(name);
            if (num2 != null) {
                return num2.intValue();
            }
            return -3;
        }
        int elementIndex = rVar.getElementIndex(name);
        if (elementIndex != -3 || !json.getConfiguration().f7763j) {
            return elementIndex;
        }
        Integer num3 = deserializationNamesMap(json, rVar).get(name);
        if (num3 != null) {
            return num3.intValue();
        }
        return -3;
    }

    public static final int getJsonNameIndexOrThrow(p072m4.r rVar, AbstractC1519d json, String name, String suffix) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(name, "name");
        kotlin.jvm.internal.E.f(suffix, "suffix");
        int jsonNameIndex = getJsonNameIndex(rVar, json, name);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new p060k4.l(rVar.getSerialName() + " does not contain element with name '" + name + Chars.QUOTE + suffix);
    }

    public static final C1143t getJsonSerializationNamesKey() {
        return JsonSerializationNamesKey;
    }

    public static final p089p4.w namingStrategy(p072m4.r rVar, AbstractC1519d json) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(json, "json");
        if (kotlin.jvm.internal.E.a(rVar.getKind(), p072m4.A.INSTANCE)) {
            return json.getConfiguration().getNamingStrategy();
        }
        return null;
    }

    public static final String[] serializationNamesIndices(p072m4.r rVar, AbstractC1519d json, p089p4.w strategy) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(strategy, "strategy");
        return (String[]) p089p4.G.getSchemaCache(json).getOrPut(rVar, JsonSerializationNamesKey, new p060k4.g(rVar, strategy, 2));
    }

    public static final boolean tryCoerceValue(AbstractC1519d abstractC1519d, p072m4.r descriptor, int i5, O3.l peekNull, O3.a peekString, O3.a onEnumCoercing) {
        String str;
        kotlin.jvm.internal.E.f(abstractC1519d, "<this>");
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        kotlin.jvm.internal.E.f(peekNull, "peekNull");
        kotlin.jvm.internal.E.f(peekString, "peekString");
        kotlin.jvm.internal.E.f(onEnumCoercing, "onEnumCoercing");
        boolean zIsElementOptional = descriptor.isElementOptional(i5);
        p072m4.r elementDescriptor = descriptor.getElementDescriptor(i5);
        if (zIsElementOptional && !elementDescriptor.a() && ((Boolean) peekNull.invoke(Boolean.TRUE)).booleanValue()) {
            return true;
        }
        if (!kotlin.jvm.internal.E.a(elementDescriptor.getKind(), p072m4.y.INSTANCE) || ((elementDescriptor.a() && ((Boolean) peekNull.invoke(Boolean.FALSE)).booleanValue()) || (str = (String) peekString.invoke()) == null)) {
            return false;
        }
        int jsonNameIndex = getJsonNameIndex(elementDescriptor, abstractC1519d, str);
        boolean z6 = !abstractC1519d.getConfiguration().f7759f && elementDescriptor.a();
        if (jsonNameIndex == -3 && (zIsElementOptional || z6)) {
            onEnumCoercing.invoke();
            return true;
        }
        return false;
    }
}
