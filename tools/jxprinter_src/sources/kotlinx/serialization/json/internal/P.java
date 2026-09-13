package kotlinx.serialization.json.internal;

import A3.w0;
import A3.x0;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p072m4.AbstractC1246f;
import p084o4.AbstractC1298a0;
import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class P extends AbstractC1128d {
    public int b;
    public boolean c;
    private final p072m4.r polyDescriptor;
    private final p089p4.A value;

    public /* synthetic */ P(AbstractC1519d abstractC1519d, p089p4.A a6, String str, int i5) {
        this(abstractC1519d, a6, (i5 & 4) != 0 ? null : str, (p072m4.r) null);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d, p084o4.W0, p078n4.j, p089p4.k
    public p078n4.f beginStructure(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        if (descriptor != this.polyDescriptor) {
            return super.beginStructure(descriptor);
        }
        AbstractC1519d json = getJson();
        p089p4.m mVarCurrentObject = currentObject();
        String serialName = this.polyDescriptor.getSerialName();
        if (mVarCurrentObject instanceof p089p4.A) {
            return new P(json, (p089p4.A) mVarCurrentObject, getPolymorphicDiscriminator(), this.polyDescriptor);
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.A.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(), mVarCurrentObject.toString());
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d
    public p089p4.m currentElement(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        return (p089p4.m) A3.k0.getValue(getValue(), tag);
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d, p084o4.AbstractC1333s0, p084o4.W0, p078n4.f, p089p4.k
    public int decodeElementIndex(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        while (this.b < descriptor.b()) {
            int i5 = this.b;
            this.b = i5 + 1;
            String tag = getTag(descriptor, i5);
            int i6 = this.b - 1;
            this.c = false;
            if (!getValue().containsKey((Object) tag)) {
                boolean z6 = (getJson().getConfiguration().f7759f || descriptor.isElementOptional(i6) || !descriptor.getElementDescriptor(i6).a()) ? false : true;
                this.c = z6;
                if (!z6) {
                    continue;
                }
            }
            if (this.configuration.f7760g) {
                AbstractC1519d json = getJson();
                boolean zIsElementOptional = descriptor.isElementOptional(i6);
                p072m4.r elementDescriptor = descriptor.getElementDescriptor(i6);
                if (!zIsElementOptional || elementDescriptor.a() || !(currentElement(tag) instanceof p089p4.x)) {
                    if (kotlin.jvm.internal.E.a(elementDescriptor.getKind(), p072m4.y.INSTANCE) && (!elementDescriptor.a() || !(currentElement(tag) instanceof p089p4.x))) {
                        p089p4.m mVarCurrentElement = currentElement(tag);
                        p089p4.E e = mVarCurrentElement instanceof p089p4.E ? (p089p4.E) mVarCurrentElement : null;
                        String contentOrNull = e != null ? p089p4.n.getContentOrNull(e) : null;
                        if (contentOrNull != null) {
                            int jsonNameIndex = I.getJsonNameIndex(elementDescriptor, json, contentOrNull);
                            boolean z7 = !json.getConfiguration().f7759f && elementDescriptor.a();
                            if (jsonNameIndex != -3 || (!zIsElementOptional && !z7)) {
                            }
                        }
                    }
                }
            }
            return i6;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d, p078n4.j, p089p4.k
    public final boolean decodeNotNullMark() {
        return !this.c && super.decodeNotNullMark();
    }

    @Override // p084o4.AbstractC1333s0
    public String elementName(p072m4.r descriptor, int i5) {
        Object next;
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        p089p4.w wVarNamingStrategy = I.namingStrategy(descriptor, getJson());
        String elementName = descriptor.getElementName(i5);
        if (wVarNamingStrategy != null || (this.configuration.f7763j && !getValue().getKeys().contains(elementName))) {
            Map<String, Integer> mapDeserializationNamesMap = I.deserializationNamesMap(getJson(), descriptor);
            Iterator<T> it = getValue().getKeys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Integer num = mapDeserializationNamesMap.get((String) next);
                if (num != null && num.intValue() == i5) {
                    break;
                }
            }
            String str = (String) next;
            if (str != null) {
                return str;
            }
            String strSerialNameForJson = wVarNamingStrategy != null ? wVarNamingStrategy.serialNameForJson(descriptor, i5, elementName) : null;
            if (strSerialNameForJson != null) {
                return strSerialNameForJson;
            }
        }
        return elementName;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d, p084o4.W0, p078n4.f, p089p4.k
    public void endStructure(p072m4.r descriptor) {
        Set<String> setPlus;
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        if (this.configuration.b || (descriptor.getKind() instanceof AbstractC1246f)) {
            return;
        }
        p089p4.w wVarNamingStrategy = I.namingStrategy(descriptor, getJson());
        if (wVarNamingStrategy == null && !this.configuration.f7763j) {
            setPlus = AbstractC1298a0.jsonCachedSerialNames(descriptor);
        } else if (wVarNamingStrategy != null) {
            setPlus = I.deserializationNamesMap(getJson(), descriptor).keySet();
        } else {
            Set<String> setJsonCachedSerialNames = AbstractC1298a0.jsonCachedSerialNames(descriptor);
            Map map = (Map) p089p4.G.getSchemaCache(getJson()).get(descriptor, I.getJsonDeserializationNamesKey());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = w0.emptySet();
            }
            setPlus = x0.plus((Set) setJsonCachedSerialNames, (Iterable) setKeySet);
        }
        for (String str : getValue().getKeys()) {
            if (!setPlus.contains(str) && !kotlin.jvm.internal.E.a(str, getPolymorphicDiscriminator())) {
                throw E.UnknownKeyException(str, getValue().toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(AbstractC1519d json, p089p4.A value, String str, p072m4.r rVar) {
        super(json, value, str);
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(value, "value");
        this.value = value;
        this.polyDescriptor = rVar;
    }

    @Override // kotlinx.serialization.json.internal.AbstractC1128d
    public p089p4.A getValue() {
        return this.value;
    }
}
