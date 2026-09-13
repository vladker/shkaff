package kotlinx.serialization.json.internal;

import A3.AbstractC0157z;
import java.lang.annotation.Annotation;
import p072m4.AbstractC1246f;
import p084o4.AbstractC1298a0;
import p084o4.AbstractC1299b;
import p089p4.AbstractC1519d;
import p089p4.EnumC1516a;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Z {
    public static final void a(p060k4.m mVar, p060k4.m mVar2, String str) {
        if ((mVar instanceof p060k4.i) && AbstractC1298a0.jsonCachedSerialNames(mVar2.getDescriptor()).contains(str)) {
            StringBuilder sbU = androidx.collection.a.u("Sealed class '", mVar2.getDescriptor().getSerialName(), "' cannot be serialized as base class '", ((p060k4.i) mVar).getDescriptor().getSerialName(), "' because it has property name that conflicts with JSON class discriminator '");
            sbU.append(str);
            sbU.append("'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            throw new IllegalStateException(sbU.toString().toString());
        }
    }

    public static final void checkKind(p072m4.z kind) {
        kotlin.jvm.internal.E.f(kind, "kind");
        if (kind instanceof p072m4.y) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof p072m4.p) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof AbstractC1246f) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String classDiscriminator(p072m4.r rVar, AbstractC1519d json) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(json, "json");
        for (Annotation annotation : rVar.getAnnotations()) {
            if (annotation instanceof p089p4.i) {
                return ((p089p4.i) annotation).discriminator();
            }
        }
        return json.getConfiguration().getClassDiscriminator();
    }

    public static final <T> T decodeSerializableValuePolymorphic(p089p4.k kVar, p060k4.a deserializer, O3.a path) {
        p089p4.E jsonPrimitive;
        kotlin.jvm.internal.E.f(kVar, "<this>");
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        kotlin.jvm.internal.E.f(path, "path");
        if (!(deserializer instanceof AbstractC1299b) || kVar.getJson().getConfiguration().f7761h) {
            return (T) deserializer.deserialize(kVar);
        }
        AbstractC1299b abstractC1299b = (AbstractC1299b) deserializer;
        String strClassDiscriminator = classDiscriminator(abstractC1299b.getDescriptor(), kVar.getJson());
        p089p4.m mVarDecodeJsonElement = kVar.decodeJsonElement();
        String serialName = abstractC1299b.getDescriptor().getSerialName();
        if (mVarDecodeJsonElement instanceof p089p4.A) {
            p089p4.A a6 = (p089p4.A) mVarDecodeJsonElement;
            p089p4.m mVar = (p089p4.m) a6.get((Object) strClassDiscriminator);
            try {
                p060k4.a aVarFindPolymorphicSerializer = p060k4.f.findPolymorphicSerializer((AbstractC1299b) deserializer, kVar, (mVar == null || (jsonPrimitive = p089p4.n.getJsonPrimitive(mVar)) == null) ? null : p089p4.n.getContentOrNull(jsonPrimitive));
                kotlin.jvm.internal.E.d(aVarFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return (T) k0.readPolymorphicJson(kVar.getJson(), strClassDiscriminator, a6, aVarFindPolymorphicSerializer);
            } catch (p060k4.l e) {
                String message = e.getMessage();
                kotlin.jvm.internal.E.c(message);
                throw E.JsonDecodingException(-1, message, a6.toString());
            }
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.A.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + ((String) path.invoke()), mVarDecodeJsonElement.toString());
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006b  */
    public static final <T> void encodePolymorphically(p089p4.r rVar, p060k4.m serializer, T t6, O3.p ifPolymorphic) {
        String strClassDiscriminator;
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(serializer, "serializer");
        kotlin.jvm.internal.E.f(ifPolymorphic, "ifPolymorphic");
        if (rVar.getJson().getConfiguration().f7761h) {
            serializer.serialize(rVar, t6);
            return;
        }
        boolean z6 = serializer instanceof AbstractC1299b;
        if (!z6) {
            int iOrdinal = rVar.getJson().getConfiguration().getClassDiscriminatorMode().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    p072m4.z kind = serializer.getDescriptor().getKind();
                    strClassDiscriminator = (kotlin.jvm.internal.E.a(kind, p072m4.A.INSTANCE) || kotlin.jvm.internal.E.a(kind, p072m4.D.INSTANCE)) ? classDiscriminator(serializer.getDescriptor(), rVar.getJson()) : null;
                } else if (iOrdinal != 2) {
                    throw new C1937q();
                }
            }
        } else if (rVar.getJson().getConfiguration().getClassDiscriminatorMode() != EnumC1516a.f7755a) {
        }
        if (z6) {
            AbstractC1299b abstractC1299b = (AbstractC1299b) serializer;
            if (t6 == null) {
                throw new IllegalArgumentException(("Value for serializer " + abstractC1299b.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
            }
            p060k4.m mVarFindPolymorphicSerializer = p060k4.f.findPolymorphicSerializer(abstractC1299b, rVar, t6);
            if (strClassDiscriminator != null) {
                a(serializer, mVarFindPolymorphicSerializer, strClassDiscriminator);
            }
            checkKind(mVarFindPolymorphicSerializer.getDescriptor().getKind());
            serializer = mVarFindPolymorphicSerializer;
        }
        if (strClassDiscriminator != null) {
            ifPolymorphic.invoke(strClassDiscriminator, serializer.getDescriptor().getSerialName());
        }
        serializer.serialize(rVar, t6);
    }

    public static final Void throwJsonElementPolymorphicException(String str, p089p4.m element) {
        kotlin.jvm.internal.E.f(element, "element");
        StringBuilder sbY = AbstractC0157z.y("Class with serial name ", str, " cannot be serialized polymorphically because it is represented as ");
        sbY.append(kotlin.jvm.internal.U.a(element.getClass()).getSimpleName());
        sbY.append(". Make sure that its JsonTransformingSerializer returns JsonObject, so class discriminator can be added to it.");
        throw new C(sbY.toString());
    }
}
