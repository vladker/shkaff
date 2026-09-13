package kotlinx.serialization.json.internal;

import A3.C0130a;
import io.flutter.plugins.firebase.crashlytics.Constants;
import p072m4.AbstractC1246f;
import p084o4.AbstractC1299b;
import p084o4.AbstractC1335t0;
import p089p4.AbstractC1519d;
import p089p4.EnumC1516a;
import p147z3.C1929i;
import p147z3.C1937q;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC1131g extends AbstractC1335t0 implements p089p4.r {
    protected final p089p4.j configuration;
    private final AbstractC1519d json;
    private final O3.l nodeConsumer;
    private String polymorphicDiscriminator;
    private String polymorphicSerialName;

    public AbstractC1131g(AbstractC1519d abstractC1519d, O3.l lVar) {
        this.json = abstractC1519d;
        this.nodeConsumer = lVar;
        this.configuration = abstractC1519d.getConfiguration();
    }

    private final C1130f inlineUnsignedNumberEncoder(String str) {
        return new C1130f(this, str);
    }

    @Override // p084o4.X0, p078n4.l, p089p4.r
    public p078n4.h beginStructure(p072m4.r descriptor) {
        AbstractC1131g t6;
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        O3.l c0130a = getCurrentTagOrNull() == null ? this.nodeConsumer : new C0130a(this, 16);
        p072m4.z kind = descriptor.getKind();
        if (kotlin.jvm.internal.E.a(kind, p072m4.B.INSTANCE) || (kind instanceof AbstractC1246f)) {
            t6 = new T(this.json, c0130a);
        } else if (kotlin.jvm.internal.E.a(kind, p072m4.C.INSTANCE)) {
            AbstractC1519d abstractC1519d = this.json;
            p072m4.r rVarCarrierDescriptor = n0.carrierDescriptor(descriptor.getElementDescriptor(0), abstractC1519d.getSerializersModule());
            p072m4.z kind2 = rVarCarrierDescriptor.getKind();
            if ((kind2 instanceof p072m4.p) || kotlin.jvm.internal.E.a(kind2, p072m4.y.INSTANCE)) {
                t6 = new V(this.json, c0130a);
            } else {
                if (!abstractC1519d.getConfiguration().d) {
                    throw E.InvalidKeyKindException(rVarCarrierDescriptor);
                }
                t6 = new T(this.json, c0130a);
            }
        } else {
            t6 = new Q(this.json, c0130a);
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            if (t6 instanceof V) {
                V v6 = (V) t6;
                v6.putElement(Constants.KEY, p089p4.n.JsonPrimitive(str));
                String serialName = this.polymorphicSerialName;
                if (serialName == null) {
                    serialName = descriptor.getSerialName();
                }
                v6.putElement("value", p089p4.n.JsonPrimitive(serialName));
            } else {
                String serialName2 = this.polymorphicSerialName;
                if (serialName2 == null) {
                    serialName2 = descriptor.getSerialName();
                }
                t6.putElement(str, p089p4.n.JsonPrimitive(serialName2));
            }
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        return t6;
    }

    @Override // p084o4.AbstractC1335t0
    public String composeName(String parentName, String childName) {
        kotlin.jvm.internal.E.f(parentName, "parentName");
        kotlin.jvm.internal.E.f(childName, "childName");
        return childName;
    }

    @Override // p084o4.AbstractC1335t0
    public String elementName(p072m4.r descriptor, int i5) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return I.getJsonElementName(descriptor, this.json, i5);
    }

    @Override // p084o4.X0, p078n4.l, p089p4.r
    public p078n4.l encodeInline(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        if (getCurrentTagOrNull() == null) {
            return new M(this.json, this.nodeConsumer).encodeInline(descriptor);
        }
        if (this.polymorphicDiscriminator != null) {
            this.polymorphicSerialName = descriptor.getSerialName();
        }
        return super.encodeInline(descriptor);
    }

    @Override // p089p4.r
    public void encodeJsonElement(p089p4.m element) {
        kotlin.jvm.internal.E.f(element, "element");
        if (this.polymorphicDiscriminator == null || (element instanceof p089p4.A)) {
            encodeSerializableValue(p089p4.o.INSTANCE, element);
        } else {
            Z.throwJsonElementPolymorphicException(this.polymorphicSerialName, element);
            throw new C1929i();
        }
    }

    @Override // p078n4.l, p089p4.r
    public final void encodeNull() {
        String str = (String) getCurrentTagOrNull();
        if (str == null) {
            this.nodeConsumer.invoke(p089p4.x.INSTANCE);
        } else {
            encodeTaggedNull(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    @Override // p084o4.X0, p078n4.l, p089p4.r
    public <T> void encodeSerializableValue(p060k4.m serializer, T t6) {
        String strClassDiscriminator;
        kotlin.jvm.internal.E.f(serializer, "serializer");
        if (getCurrentTagOrNull() == null) {
            p072m4.r rVarCarrierDescriptor = n0.carrierDescriptor(serializer.getDescriptor(), getSerializersModule());
            if ((rVarCarrierDescriptor.getKind() instanceof p072m4.p) || rVarCarrierDescriptor.getKind() == p072m4.y.INSTANCE) {
                new M(this.json, this.nodeConsumer).encodeSerializableValue(serializer, t6);
                return;
            }
        }
        if (getJson().getConfiguration().f7761h) {
            serializer.serialize(this, t6);
            return;
        }
        boolean z6 = serializer instanceof AbstractC1299b;
        if (!z6) {
            int iOrdinal = getJson().getConfiguration().getClassDiscriminatorMode().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    p072m4.z kind = serializer.getDescriptor().getKind();
                    strClassDiscriminator = (kotlin.jvm.internal.E.a(kind, p072m4.A.INSTANCE) || kotlin.jvm.internal.E.a(kind, p072m4.D.INSTANCE)) ? Z.classDiscriminator(serializer.getDescriptor(), getJson()) : null;
                } else if (iOrdinal != 2) {
                    throw new C1937q();
                }
            }
        } else if (getJson().getConfiguration().getClassDiscriminatorMode() != EnumC1516a.f7755a) {
        }
        if (z6) {
            AbstractC1299b abstractC1299b = (AbstractC1299b) serializer;
            if (t6 == null) {
                throw new IllegalArgumentException(("Value for serializer " + abstractC1299b.getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
            }
            p060k4.m mVarFindPolymorphicSerializer = p060k4.f.findPolymorphicSerializer(abstractC1299b, this, t6);
            if (strClassDiscriminator != null) {
                Z.a(serializer, mVarFindPolymorphicSerializer, strClassDiscriminator);
            }
            Z.checkKind(mVarFindPolymorphicSerializer.getDescriptor().getKind());
            serializer = mVarFindPolymorphicSerializer;
        }
        if (strClassDiscriminator != null) {
            String serialName = serializer.getDescriptor().getSerialName();
            this.polymorphicDiscriminator = strClassDiscriminator;
            this.polymorphicSerialName = serialName;
        }
        serializer.serialize(this, t6);
    }

    public void encodeTaggedBoolean(String tag, boolean z6) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(Boolean.valueOf(z6)));
    }

    public void encodeTaggedByte(String tag, byte b) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(Byte.valueOf(b)));
    }

    public void encodeTaggedChar(String tag, char c) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(String.valueOf(c)));
    }

    public void encodeTaggedDouble(String tag, double d) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(Double.valueOf(d)));
        if (this.configuration.f7762i) {
            return;
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw E.InvalidFloatingPointEncoded(Double.valueOf(d), tag, getCurrent().toString());
        }
    }

    public void encodeTaggedFloat(String tag, float f6) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(Float.valueOf(f6)));
        if (this.configuration.f7762i) {
            return;
        }
        if (Float.isInfinite(f6) || Float.isNaN(f6)) {
            throw E.InvalidFloatingPointEncoded(Float.valueOf(f6), tag, getCurrent().toString());
        }
    }

    public void encodeTaggedInt(String tag, int i5) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(Integer.valueOf(i5)));
    }

    public void encodeTaggedLong(String tag, long j6) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(Long.valueOf(j6)));
    }

    public void encodeTaggedNull(String tag) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.x.INSTANCE);
    }

    public void encodeTaggedShort(String tag, short s6) {
        kotlin.jvm.internal.E.f(tag, "tag");
        putElement(tag, p089p4.n.JsonPrimitive(Short.valueOf(s6)));
    }

    @Override // p084o4.X0
    public void endEncode(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        this.nodeConsumer.invoke(getCurrent());
    }

    public abstract p089p4.m getCurrent();

    @Override // p089p4.r
    public final AbstractC1519d getJson() {
        return this.json;
    }

    public final O3.l getNodeConsumer() {
        return this.nodeConsumer;
    }

    @Override // p084o4.X0, p078n4.l, p078n4.h
    public final p095q4.g getSerializersModule() {
        return this.json.getSerializersModule();
    }

    public abstract void putElement(String str, p089p4.m mVar);

    @Override // p084o4.X0, p078n4.h, p089p4.r
    public boolean shouldEncodeElementDefault(p072m4.r descriptor, int i5) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return this.configuration.f7758a;
    }

    @Override // p084o4.X0
    public void encodeTaggedEnum(String tag, p072m4.r enumDescriptor, int i5) {
        kotlin.jvm.internal.E.f(tag, "tag");
        kotlin.jvm.internal.E.f(enumDescriptor, "enumDescriptor");
        putElement(tag, p089p4.n.JsonPrimitive(enumDescriptor.getElementName(i5)));
    }

    @Override // p084o4.X0
    public p078n4.l encodeTaggedInline(String tag, p072m4.r inlineDescriptor) {
        kotlin.jvm.internal.E.f(tag, "tag");
        kotlin.jvm.internal.E.f(inlineDescriptor, "inlineDescriptor");
        if (f0.isUnsignedNumber(inlineDescriptor)) {
            return inlineUnsignedNumberEncoder(tag);
        }
        return f0.isUnquotedLiteral(inlineDescriptor) ? new C1129e(this, tag, inlineDescriptor) : super.encodeTaggedInline((Object) tag, inlineDescriptor);
    }

    @Override // p084o4.X0
    public void encodeTaggedString(String tag, String value) {
        kotlin.jvm.internal.E.f(tag, "tag");
        kotlin.jvm.internal.E.f(value, "value");
        putElement(tag, p089p4.n.JsonPrimitive(value));
    }

    @Override // p084o4.X0
    public void encodeTaggedValue(String tag, Object value) {
        kotlin.jvm.internal.E.f(tag, "tag");
        kotlin.jvm.internal.E.f(value, "value");
        putElement(tag, p089p4.n.JsonPrimitive(value.toString()));
    }

    @Override // p078n4.l, p089p4.r
    public final void encodeNotNullMark() {
    }
}
