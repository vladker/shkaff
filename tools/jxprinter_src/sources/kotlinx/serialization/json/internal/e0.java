package kotlinx.serialization.json.internal;

import org.apache.xmlbeans.impl.common.NameUtil;
import p084o4.AbstractC1299b;
import p089p4.AbstractC1519d;
import p089p4.EnumC1516a;
import p147z3.C1929i;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 extends p078n4.b implements p089p4.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5737a;
    private final C1138n composer;
    private final p089p4.j configuration;
    private final AbstractC1519d json;
    private final m0 mode;
    private final p089p4.r[] modeReuseCache;
    private String polymorphicDiscriminator;
    private String polymorphicSerialName;
    private final p095q4.g serializersModule;

    public e0(C1138n composer, AbstractC1519d json, m0 mode, p089p4.r[] rVarArr) {
        kotlin.jvm.internal.E.f(composer, "composer");
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(mode, "mode");
        this.composer = composer;
        this.json = json;
        this.mode = mode;
        this.modeReuseCache = rVarArr;
        this.serializersModule = getJson().getSerializersModule();
        this.configuration = getJson().getConfiguration();
        int iOrdinal = mode.ordinal();
        if (rVarArr != null) {
            p089p4.r rVar = rVarArr[iOrdinal];
            if (rVar == null && rVar == this) {
                return;
            }
            rVarArr[iOrdinal] = this;
        }
    }

    @Override // p078n4.b, p078n4.l
    public final void a(short s6) {
        if (this.f5737a) {
            encodeString(String.valueOf((int) s6));
        } else {
            this.composer.h(s6);
        }
    }

    @Override // p078n4.b, p078n4.l
    public final void b(boolean z6) {
        if (this.f5737a) {
            encodeString(String.valueOf(z6));
            return;
        }
        ((O) this.composer.writer).write(String.valueOf(z6));
    }

    @Override // p078n4.b, p078n4.l, p089p4.r
    public p078n4.h beginStructure(p072m4.r descriptor) {
        p089p4.r rVar;
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        m0 m0VarSwitchMode = n0.switchMode(getJson(), descriptor);
        char c = m0VarSwitchMode.begin;
        if (c != 0) {
            this.composer.e(c);
            this.composer.a();
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            String serialName = this.polymorphicSerialName;
            if (serialName == null) {
                serialName = descriptor.getSerialName();
            }
            this.composer.b();
            encodeString(str);
            this.composer.e(NameUtil.COLON);
            this.composer.i();
            encodeString(serialName);
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        if (this.mode == m0VarSwitchMode) {
            return this;
        }
        p089p4.r[] rVarArr = this.modeReuseCache;
        return (rVarArr == null || (rVar = rVarArr[m0VarSwitchMode.ordinal()]) == null) ? new e0(this.composer, getJson(), m0VarSwitchMode, this.modeReuseCache) : rVar;
    }

    @Override // p078n4.b, p078n4.l
    public final void c(int i5) {
        if (this.f5737a) {
            encodeString(String.valueOf(i5));
        } else {
            this.composer.f(i5);
        }
    }

    @Override // p078n4.b, p078n4.l
    public final void d(long j6) {
        if (this.f5737a) {
            encodeString(String.valueOf(j6));
        } else {
            this.composer.g(j6);
        }
    }

    @Override // p078n4.b, p078n4.l
    public final void e(char c) {
        encodeString(String.valueOf(c));
    }

    @Override // p078n4.b
    public boolean encodeElement(p072m4.r descriptor, int i5) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        int iOrdinal = this.mode.ordinal();
        if (iOrdinal == 1) {
            C1138n c1138n = this.composer;
            if (!c1138n.f5744a) {
                c1138n.e(',');
            }
            this.composer.b();
            return true;
        }
        boolean z6 = false;
        if (iOrdinal == 2) {
            C1138n c1138n2 = this.composer;
            if (c1138n2.f5744a) {
                this.f5737a = true;
                c1138n2.b();
                return true;
            }
            if (i5 % 2 == 0) {
                c1138n2.e(',');
                this.composer.b();
                z6 = true;
            } else {
                c1138n2.e(NameUtil.COLON);
                this.composer.i();
            }
            this.f5737a = z6;
            return true;
        }
        if (iOrdinal == 3) {
            if (i5 == 0) {
                this.f5737a = true;
            }
            if (i5 == 1) {
                this.composer.e(',');
                this.composer.i();
                this.f5737a = false;
            }
            return true;
        }
        C1138n c1138n3 = this.composer;
        if (!c1138n3.f5744a) {
            c1138n3.e(',');
        }
        this.composer.b();
        encodeString(I.getJsonElementName(descriptor, getJson(), i5));
        this.composer.e(NameUtil.COLON);
        this.composer.i();
        return true;
    }

    @Override // p078n4.b, p078n4.l, p089p4.r
    public void encodeEnum(p072m4.r enumDescriptor, int i5) {
        kotlin.jvm.internal.E.f(enumDescriptor, "enumDescriptor");
        encodeString(enumDescriptor.getElementName(i5));
    }

    @Override // p078n4.b, p078n4.l, p089p4.r
    public p078n4.l encodeInline(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        if (f0.isUnsignedNumber(descriptor)) {
            C1138n c1140p = this.composer;
            if (!(c1140p instanceof C1140p)) {
                c1140p = new C1140p(c1140p.writer, this.f5737a);
            }
            return new e0(c1140p, getJson(), this.mode, (p089p4.r[]) null);
        }
        if (f0.isUnquotedLiteral(descriptor)) {
            C1138n c1139o = this.composer;
            if (!(c1139o instanceof C1139o)) {
                c1139o = new C1139o(c1139o.writer, this.f5737a);
            }
            return new e0(c1139o, getJson(), this.mode, (p089p4.r[]) null);
        }
        if (this.polymorphicDiscriminator == null) {
            return super.encodeInline(descriptor);
        }
        this.polymorphicSerialName = descriptor.getSerialName();
        return this;
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

    @Override // p078n4.b, p078n4.l, p089p4.r
    public final void encodeNull() {
        this.composer.print(AbstractC1127c.NULL);
    }

    @Override // p078n4.b, p078n4.h, p089p4.r
    public <T> void encodeNullableSerializableElement(p072m4.r descriptor, int i5, p060k4.m serializer, T t6) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        kotlin.jvm.internal.E.f(serializer, "serializer");
        if (t6 != null || this.configuration.f7759f) {
            super.encodeNullableSerializableElement(descriptor, i5, serializer, t6);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0061  */
    @Override // p078n4.b, p078n4.l, p089p4.r
    public <T> void encodeSerializableValue(p060k4.m serializer, T t6) {
        String strClassDiscriminator;
        kotlin.jvm.internal.E.f(serializer, "serializer");
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

    @Override // p078n4.b, p078n4.l
    public void encodeString(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        this.composer.printQuoted(value);
    }

    @Override // p078n4.b, p078n4.h, p089p4.r
    public void endStructure(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        if (this.mode.end != 0) {
            this.composer.j();
            this.composer.c();
            this.composer.e(this.mode.end);
        }
    }

    @Override // p078n4.b, p078n4.l
    public final void f(byte b) {
        if (this.f5737a) {
            encodeString(String.valueOf((int) b));
        } else {
            this.composer.d(b);
        }
    }

    @Override // p078n4.b, p078n4.l
    public final void g(float f6) {
        if (this.f5737a) {
            encodeString(String.valueOf(f6));
        } else {
            ((O) this.composer.writer).write(String.valueOf(f6));
        }
        if (this.configuration.f7762i) {
            return;
        }
        if (Float.isInfinite(f6) || Float.isNaN(f6)) {
            throw E.InvalidFloatingPointEncoded(Float.valueOf(f6), this.composer.writer.toString());
        }
    }

    @Override // p089p4.r
    public AbstractC1519d getJson() {
        return this.json;
    }

    @Override // p078n4.b, p078n4.l, p078n4.h
    public p095q4.g getSerializersModule() {
        return this.serializersModule;
    }

    @Override // p078n4.b, p078n4.l
    public final void h(double d) {
        if (this.f5737a) {
            encodeString(String.valueOf(d));
        } else {
            ((O) this.composer.writer).write(String.valueOf(d));
        }
        if (this.configuration.f7762i) {
            return;
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw E.InvalidFloatingPointEncoded(Double.valueOf(d), this.composer.writer.toString());
        }
    }

    @Override // p078n4.b, p078n4.h, p089p4.r
    public boolean shouldEncodeElementDefault(p072m4.r descriptor, int i5) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        return this.configuration.f7758a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0(InterfaceC1147x output, AbstractC1519d json, m0 mode, p089p4.r[] modeReuseCache) {
        this(r.Composer(output, json), json, mode, modeReuseCache);
        kotlin.jvm.internal.E.f(output, "output");
        kotlin.jvm.internal.E.f(json, "json");
        kotlin.jvm.internal.E.f(mode, "mode");
        kotlin.jvm.internal.E.f(modeReuseCache, "modeReuseCache");
    }
}
