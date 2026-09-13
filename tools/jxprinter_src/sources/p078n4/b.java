package p078n4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p060k4.l;
import p060k4.m;
import p072m4.r;
import p084o4.C1337u0;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements l, h {
    @Override // p078n4.l
    public void a(short s6) {
        encodeValue(Short.valueOf(s6));
    }

    @Override // p078n4.l
    public void b(boolean z6) {
        encodeValue(Boolean.valueOf(z6));
    }

    @Override // p078n4.l
    public h beginCollection(r rVar, int i5) {
        return k.beginCollection(this, rVar, i5);
    }

    @Override // p078n4.l, p089p4.r
    public h beginStructure(r descriptor) {
        E.f(descriptor, "descriptor");
        return this;
    }

    @Override // p078n4.l
    public void c(int i5) {
        encodeValue(Integer.valueOf(i5));
    }

    @Override // p078n4.l
    public void d(long j6) {
        encodeValue(Long.valueOf(j6));
    }

    @Override // p078n4.l
    public void e(char c) {
        encodeValue(Character.valueOf(c));
    }

    @Override // p078n4.h
    public final void encodeBooleanElement(r descriptor, int i5, boolean z6) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            b(z6);
        }
    }

    @Override // p078n4.h
    public final void encodeByteElement(r descriptor, int i5, byte b) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            f(b);
        }
    }

    @Override // p078n4.h
    public final void encodeCharElement(r descriptor, int i5, char c) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            e(c);
        }
    }

    @Override // p078n4.h
    public final void encodeDoubleElement(r descriptor, int i5, double d) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            h(d);
        }
    }

    public boolean encodeElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return true;
    }

    @Override // p078n4.l, p089p4.r
    public void encodeEnum(r enumDescriptor, int i5) {
        E.f(enumDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(i5));
    }

    @Override // p078n4.h
    public final void encodeFloatElement(r descriptor, int i5, float f6) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            g(f6);
        }
    }

    @Override // p078n4.l, p089p4.r
    public l encodeInline(r descriptor) {
        E.f(descriptor, "descriptor");
        return this;
    }

    @Override // p078n4.h
    public final l encodeInlineElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return encodeElement(descriptor, i5) ? encodeInline(descriptor.getElementDescriptor(i5)) : C1337u0.INSTANCE;
    }

    @Override // p078n4.h
    public final void encodeIntElement(r descriptor, int i5, int i6) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            c(i6);
        }
    }

    @Override // p078n4.h
    public final void encodeLongElement(r descriptor, int i5, long j6) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            d(j6);
        }
    }

    @Override // p078n4.l, p089p4.r
    public void encodeNotNullMark() {
        k.encodeNotNullMark(this);
    }

    @Override // p078n4.l, p089p4.r
    public void encodeNull() {
        throw new l("'null' is not supported by default");
    }

    public <T> void encodeNullableSerializableElement(r descriptor, int i5, m serializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(serializer, "serializer");
        if (encodeElement(descriptor, i5)) {
            encodeNullableSerializableValue(serializer, t6);
        }
    }

    @Override // p078n4.l
    public <T> void encodeNullableSerializableValue(m mVar, T t6) {
        k.encodeNullableSerializableValue(this, mVar, t6);
    }

    @Override // p078n4.h
    public <T> void encodeSerializableElement(r descriptor, int i5, m serializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(serializer, "serializer");
        if (encodeElement(descriptor, i5)) {
            encodeSerializableValue(serializer, t6);
        }
    }

    @Override // p078n4.l, p089p4.r
    public <T> void encodeSerializableValue(m mVar, T t6) {
        k.encodeSerializableValue(this, mVar, t6);
    }

    @Override // p078n4.h
    public final void encodeShortElement(r descriptor, int i5, short s6) {
        E.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i5)) {
            a(s6);
        }
    }

    @Override // p078n4.l
    public void encodeString(String value) {
        E.f(value, "value");
        encodeValue(value);
    }

    @Override // p078n4.h
    public final void encodeStringElement(r descriptor, int i5, String value) {
        E.f(descriptor, "descriptor");
        E.f(value, "value");
        if (encodeElement(descriptor, i5)) {
            encodeString(value);
        }
    }

    public void encodeValue(Object value) {
        E.f(value, "value");
        throw new l("Non-serializable " + U.a(value.getClass()) + " is not supported by " + U.a(getClass()) + " encoder");
    }

    public void endStructure(r descriptor) {
        E.f(descriptor, "descriptor");
    }

    @Override // p078n4.l
    public void f(byte b) {
        encodeValue(Byte.valueOf(b));
    }

    @Override // p078n4.l
    public void g(float f6) {
        encodeValue(Float.valueOf(f6));
    }

    @Override // p078n4.l, p078n4.h
    public abstract /* synthetic */ g getSerializersModule();

    @Override // p078n4.l
    public void h(double d) {
        encodeValue(Double.valueOf(d));
    }

    public boolean shouldEncodeElementDefault(r rVar, int i5) {
        return g.shouldEncodeElementDefault(this, rVar, i5);
    }
}
