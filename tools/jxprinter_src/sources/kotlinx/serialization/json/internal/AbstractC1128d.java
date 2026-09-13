package kotlinx.serialization.json.internal;

import A3.AbstractC0157z;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.XmlErrorCodes;
import p072m4.AbstractC1246f;
import p084o4.AbstractC1299b;
import p084o4.AbstractC1333s0;
import p089p4.AbstractC1519d;
import p089p4.C1521f;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC1128d extends AbstractC1333s0 implements p089p4.k {
    protected final p089p4.j configuration = getJson().getConfiguration();
    private final AbstractC1519d json;
    private final String polymorphicDiscriminator;
    private final p089p4.m value;

    public AbstractC1128d(AbstractC1519d abstractC1519d, p089p4.m mVar, String str) {
        this.json = abstractC1519d;
        this.value = mVar;
        this.polymorphicDiscriminator = str;
    }

    @Override // p084o4.W0, p078n4.j, p089p4.k
    public p078n4.f beginStructure(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        p089p4.m mVarCurrentObject = currentObject();
        p072m4.z kind = descriptor.getKind();
        if (kotlin.jvm.internal.E.a(kind, p072m4.B.INSTANCE) || (kind instanceof AbstractC1246f)) {
            AbstractC1519d json = getJson();
            String serialName = descriptor.getSerialName();
            if (mVarCurrentObject instanceof C1521f) {
                return new S(json, (C1521f) mVarCurrentObject);
            }
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(C1521f.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(), mVarCurrentObject.toString());
        }
        if (!kotlin.jvm.internal.E.a(kind, p072m4.C.INSTANCE)) {
            AbstractC1519d json2 = getJson();
            String serialName2 = descriptor.getSerialName();
            if (mVarCurrentObject instanceof p089p4.A) {
                return new P(json2, (p089p4.A) mVarCurrentObject, this.polymorphicDiscriminator, 8);
            }
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.A.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName2 + " at element: " + renderTagStack(), mVarCurrentObject.toString());
        }
        AbstractC1519d json3 = getJson();
        p072m4.r rVarCarrierDescriptor = n0.carrierDescriptor(descriptor.getElementDescriptor(0), json3.getSerializersModule());
        p072m4.z kind2 = rVarCarrierDescriptor.getKind();
        if ((kind2 instanceof p072m4.p) || kotlin.jvm.internal.E.a(kind2, p072m4.y.INSTANCE)) {
            AbstractC1519d json4 = getJson();
            String serialName3 = descriptor.getSerialName();
            if (mVarCurrentObject instanceof p089p4.A) {
                return new U(json4, (p089p4.A) mVarCurrentObject);
            }
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.A.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName3 + " at element: " + renderTagStack(), mVarCurrentObject.toString());
        }
        if (!json3.getConfiguration().d) {
            throw E.InvalidKeyKindException(rVarCarrierDescriptor);
        }
        AbstractC1519d json5 = getJson();
        String serialName4 = descriptor.getSerialName();
        if (mVarCurrentObject instanceof C1521f) {
            return new S(json5, (C1521f) mVarCurrentObject);
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(C1521f.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName4 + " at element: " + renderTagStack(), mVarCurrentObject.toString());
    }

    @Override // p084o4.AbstractC1333s0
    public String composeName(String parentName, String childName) {
        kotlin.jvm.internal.E.f(parentName, "parentName");
        kotlin.jvm.internal.E.f(childName, "childName");
        return childName;
    }

    public abstract p089p4.m currentElement(String str);

    public final p089p4.m currentObject() {
        p089p4.m mVarCurrentElement;
        String str = (String) getCurrentTagOrNull();
        return (str == null || (mVarCurrentElement = currentElement(str)) == null) ? getValue() : mVarCurrentElement;
    }

    @Override // p084o4.AbstractC1333s0, p084o4.W0, p078n4.f, p089p4.k
    public abstract /* synthetic */ int decodeElementIndex(p072m4.r rVar);

    @Override // p084o4.W0, p078n4.j, p089p4.k
    public p078n4.j decodeInline(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return getCurrentTagOrNull() != null ? super.decodeInline(descriptor) : new L(getJson(), getValue(), this.polymorphicDiscriminator).decodeInline(descriptor);
    }

    @Override // p089p4.k
    public p089p4.m decodeJsonElement() {
        return currentObject();
    }

    @Override // p078n4.j, p089p4.k
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof p089p4.x);
    }

    @Override // p084o4.W0, p078n4.j, p089p4.k
    public <T> T decodeSerializableValue(p060k4.a deserializer) {
        p089p4.E jsonPrimitive;
        kotlin.jvm.internal.E.f(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractC1299b) || getJson().getConfiguration().f7761h) {
            return (T) deserializer.deserialize(this);
        }
        AbstractC1299b abstractC1299b = (AbstractC1299b) deserializer;
        String strClassDiscriminator = Z.classDiscriminator(abstractC1299b.getDescriptor(), getJson());
        p089p4.m mVarDecodeJsonElement = decodeJsonElement();
        String serialName = abstractC1299b.getDescriptor().getSerialName();
        if (mVarDecodeJsonElement instanceof p089p4.A) {
            p089p4.A a6 = (p089p4.A) mVarDecodeJsonElement;
            p089p4.m mVar = (p089p4.m) a6.get((Object) strClassDiscriminator);
            try {
                p060k4.a aVarFindPolymorphicSerializer = p060k4.f.findPolymorphicSerializer((AbstractC1299b) deserializer, this, (mVar == null || (jsonPrimitive = p089p4.n.getJsonPrimitive(mVar)) == null) ? null : p089p4.n.getContentOrNull(jsonPrimitive));
                kotlin.jvm.internal.E.d(aVarFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return (T) k0.readPolymorphicJson(getJson(), strClassDiscriminator, a6, aVarFindPolymorphicSerializer);
            } catch (p060k4.l e) {
                String message = e.getMessage();
                kotlin.jvm.internal.E.c(message);
                throw E.JsonDecodingException(-1, message, a6.toString());
            }
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.A.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(), mVarDecodeJsonElement.toString());
    }

    public boolean decodeTaggedBoolean(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (!(mVarCurrentElement instanceof p089p4.E)) {
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of boolean at element: " + renderTagStack(tag), mVarCurrentElement.toString());
        }
        p089p4.E e = (p089p4.E) mVarCurrentElement;
        try {
            Boolean booleanOrNull = p089p4.n.getBooleanOrNull(e);
            if (booleanOrNull != null) {
                return booleanOrNull.booleanValue();
            }
            k(e, "boolean", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            k(e, "boolean", tag);
            throw null;
        }
    }

    public byte decodeTaggedByte(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (!(mVarCurrentElement instanceof p089p4.E)) {
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of byte at element: " + renderTagStack(tag), mVarCurrentElement.toString());
        }
        p089p4.E e = (p089p4.E) mVarCurrentElement;
        try {
            int i5 = p089p4.n.getInt(e);
            Byte bValueOf = (-128 > i5 || i5 > 127) ? null : Byte.valueOf((byte) i5);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            k(e, "byte", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            k(e, "byte", tag);
            throw null;
        }
    }

    public char decodeTaggedChar(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (mVarCurrentElement instanceof p089p4.E) {
            p089p4.E e = (p089p4.E) mVarCurrentElement;
            try {
                return X3.e0.single(e.getContent());
            } catch (IllegalArgumentException unused) {
                k(e, "char", tag);
                throw null;
            }
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of char at element: " + renderTagStack(tag), mVarCurrentElement.toString());
    }

    public double decodeTaggedDouble(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (!(mVarCurrentElement instanceof p089p4.E)) {
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of double at element: " + renderTagStack(tag), mVarCurrentElement.toString());
        }
        p089p4.E e = (p089p4.E) mVarCurrentElement;
        try {
            double d = p089p4.n.getDouble(e);
            if (getJson().getConfiguration().f7762i || !(Double.isInfinite(d) || Double.isNaN(d))) {
                return d;
            }
            throw E.InvalidFloatingPointDecoded(Double.valueOf(d), tag, currentObject().toString());
        } catch (IllegalArgumentException unused) {
            k(e, XmlErrorCodes.DOUBLE, tag);
            throw null;
        }
    }

    public float decodeTaggedFloat(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (!(mVarCurrentElement instanceof p089p4.E)) {
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of float at element: " + renderTagStack(tag), mVarCurrentElement.toString());
        }
        p089p4.E e = (p089p4.E) mVarCurrentElement;
        try {
            float f6 = p089p4.n.getFloat(e);
            if (getJson().getConfiguration().f7762i || !(Float.isInfinite(f6) || Float.isNaN(f6))) {
                return f6;
            }
            throw E.InvalidFloatingPointDecoded(Float.valueOf(f6), tag, currentObject().toString());
        } catch (IllegalArgumentException unused) {
            k(e, "float", tag);
            throw null;
        }
    }

    public int decodeTaggedInt(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (mVarCurrentElement instanceof p089p4.E) {
            p089p4.E e = (p089p4.E) mVarCurrentElement;
            try {
                return p089p4.n.getInt(e);
            } catch (IllegalArgumentException unused) {
                k(e, XmlErrorCodes.INT, tag);
                throw null;
            }
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of int at element: " + renderTagStack(tag), mVarCurrentElement.toString());
    }

    public long decodeTaggedLong(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (mVarCurrentElement instanceof p089p4.E) {
            p089p4.E e = (p089p4.E) mVarCurrentElement;
            try {
                return p089p4.n.getLong(e);
            } catch (IllegalArgumentException unused) {
                k(e, XmlErrorCodes.LONG, tag);
                throw null;
            }
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of long at element: " + renderTagStack(tag), mVarCurrentElement.toString());
    }

    public boolean decodeTaggedNotNullMark(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        return currentElement(tag) != p089p4.x.INSTANCE;
    }

    @Override // p084o4.W0
    public Void decodeTaggedNull(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        return null;
    }

    public short decodeTaggedShort(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (!(mVarCurrentElement instanceof p089p4.E)) {
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of short at element: " + renderTagStack(tag), mVarCurrentElement.toString());
        }
        p089p4.E e = (p089p4.E) mVarCurrentElement;
        try {
            int i5 = p089p4.n.getInt(e);
            Short shValueOf = (-32768 > i5 || i5 > 32767) ? null : Short.valueOf((short) i5);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            k(e, "short", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            k(e, "short", tag);
            throw null;
        }
    }

    @Override // p084o4.W0, p078n4.f, p089p4.k
    public void endStructure(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
    }

    @Override // p089p4.k
    public AbstractC1519d getJson() {
        return this.json;
    }

    public final String getPolymorphicDiscriminator() {
        return this.polymorphicDiscriminator;
    }

    public final p089p4.E getPrimitiveValue(String tag, p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(tag, "tag");
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        p089p4.m mVarCurrentElement = currentElement(tag);
        String serialName = descriptor.getSerialName();
        if (mVarCurrentElement instanceof p089p4.E) {
            return (p089p4.E) mVarCurrentElement;
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(tag), mVarCurrentElement.toString());
    }

    @Override // p084o4.W0, p078n4.j, p078n4.f, p089p4.k
    public p095q4.g getSerializersModule() {
        return getJson().getSerializersModule();
    }

    public p089p4.m getValue() {
        return this.value;
    }

    public final void k(p089p4.E e, String str, String str2) {
        throw E.JsonDecodingException(-1, "Failed to parse literal '" + e + "' as " + (X3.W.startsWith(str, Complex.DEFAULT_SUFFIX, false) ? "an " : "a ").concat(str) + " value at element: " + renderTagStack(str2), currentObject().toString());
    }

    public final String renderTagStack(String currentTag) {
        kotlin.jvm.internal.E.f(currentTag, "currentTag");
        return renderTagStack() + '.' + currentTag;
    }

    @Override // p084o4.W0
    public int decodeTaggedEnum(String tag, p072m4.r enumDescriptor) {
        kotlin.jvm.internal.E.f(tag, "tag");
        kotlin.jvm.internal.E.f(enumDescriptor, "enumDescriptor");
        AbstractC1519d json = getJson();
        p089p4.m mVarCurrentElement = currentElement(tag);
        String serialName = enumDescriptor.getSerialName();
        if (mVarCurrentElement instanceof p089p4.E) {
            return I.getJsonNameIndexOrThrow(enumDescriptor, json, ((p089p4.E) mVarCurrentElement).getContent(), "");
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(tag), mVarCurrentElement.toString());
    }

    @Override // p084o4.W0
    public p078n4.j decodeTaggedInline(String tag, p072m4.r inlineDescriptor) {
        kotlin.jvm.internal.E.f(tag, "tag");
        kotlin.jvm.internal.E.f(inlineDescriptor, "inlineDescriptor");
        if (!f0.isUnsignedNumber(inlineDescriptor)) {
            return super.decodeTaggedInline((Object) tag, inlineDescriptor);
        }
        AbstractC1519d json = getJson();
        p089p4.m mVarCurrentElement = currentElement(tag);
        String serialName = inlineDescriptor.getSerialName();
        if (mVarCurrentElement instanceof p089p4.E) {
            return new C1148y(h0.StringJsonLexer(json, ((p089p4.E) mVarCurrentElement).getContent()), getJson());
        }
        throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + renderTagStack(tag), mVarCurrentElement.toString());
    }

    @Override // p084o4.W0
    public String decodeTaggedString(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        p089p4.m mVarCurrentElement = currentElement(tag);
        if (!(mVarCurrentElement instanceof p089p4.E)) {
            throw E.JsonDecodingException(-1, "Expected " + kotlin.jvm.internal.U.a(p089p4.E.class).getSimpleName() + ", but had " + kotlin.jvm.internal.U.a(mVarCurrentElement.getClass()).getSimpleName() + " as the serialized body of string at element: " + renderTagStack(tag), mVarCurrentElement.toString());
        }
        p089p4.E e = (p089p4.E) mVarCurrentElement;
        if (!(e instanceof p089p4.s)) {
            StringBuilder sbY = AbstractC0157z.y("Expected string value for a non-null key '", tag, "', got null literal instead at element: ");
            sbY.append(renderTagStack(tag));
            throw E.JsonDecodingException(-1, sbY.toString(), currentObject().toString());
        }
        p089p4.s sVar = (p089p4.s) e;
        if (sVar.f7768a || getJson().getConfiguration().c) {
            return sVar.getContent();
        }
        StringBuilder sbY2 = AbstractC0157z.y("String literal for key '", tag, "' should be quoted at element: ");
        sbY2.append(renderTagStack(tag));
        sbY2.append(".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.");
        throw E.JsonDecodingException(-1, sbY2.toString(), currentObject().toString());
    }
}
