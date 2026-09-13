package p084o4;

import A3.I;
import A3.T;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import kotlinx.serialization.json.internal.AbstractC1131g;
import p060k4.m;
import p072m4.r;
import p078n4.h;
import p078n4.k;
import p078n4.l;
import p095q4.g;
import p095q4.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class X0 implements l, h {
    private final ArrayList<Object> tagStack = new ArrayList<>();

    @Override // p078n4.l
    public final void a(short s6) {
        ((AbstractC1131g) this).encodeTaggedShort((String) j(), s6);
    }

    @Override // p078n4.l
    public final void b(boolean z6) {
        ((AbstractC1131g) this).encodeTaggedBoolean((String) j(), z6);
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
    public final void c(int i5) {
        ((AbstractC1131g) this).encodeTaggedInt((String) j(), i5);
    }

    @Override // p078n4.l
    public final void d(long j6) {
        ((AbstractC1131g) this).encodeTaggedLong((String) j(), j6);
    }

    @Override // p078n4.l
    public final void e(char c) {
        ((AbstractC1131g) this).encodeTaggedChar((String) j(), c);
    }

    @Override // p078n4.h
    public final void encodeBooleanElement(r descriptor, int i5, boolean z6) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedBoolean((String) getTag(descriptor, i5), z6);
    }

    @Override // p078n4.h
    public final void encodeByteElement(r descriptor, int i5, byte b) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedByte((String) getTag(descriptor, i5), b);
    }

    @Override // p078n4.h
    public final void encodeCharElement(r descriptor, int i5, char c) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedChar((String) getTag(descriptor, i5), c);
    }

    @Override // p078n4.h
    public final void encodeDoubleElement(r descriptor, int i5, double d) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedDouble((String) getTag(descriptor, i5), d);
    }

    @Override // p078n4.l, p089p4.r
    public final void encodeEnum(r enumDescriptor, int i5) {
        E.f(enumDescriptor, "enumDescriptor");
        encodeTaggedEnum(j(), enumDescriptor, i5);
    }

    @Override // p078n4.h
    public final void encodeFloatElement(r descriptor, int i5, float f6) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedFloat((String) getTag(descriptor, i5), f6);
    }

    @Override // p078n4.l, p089p4.r
    public l encodeInline(r descriptor) {
        E.f(descriptor, "descriptor");
        return encodeTaggedInline(j(), descriptor);
    }

    @Override // p078n4.h
    public final l encodeInlineElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return encodeTaggedInline(getTag(descriptor, i5), descriptor.getElementDescriptor(i5));
    }

    @Override // p078n4.h
    public final void encodeIntElement(r descriptor, int i5, int i6) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedInt((String) getTag(descriptor, i5), i6);
    }

    @Override // p078n4.h
    public final void encodeLongElement(r descriptor, int i5, long j6) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedLong((String) getTag(descriptor, i5), j6);
    }

    public <T> void encodeNullableSerializableElement(r descriptor, int i5, m serializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(serializer, "serializer");
        k(getTag(descriptor, i5));
        encodeNullableSerializableValue(serializer, t6);
    }

    @Override // p078n4.l
    public <T> void encodeNullableSerializableValue(m mVar, T t6) {
        k.encodeNullableSerializableValue(this, mVar, t6);
    }

    @Override // p078n4.h
    public <T> void encodeSerializableElement(r descriptor, int i5, m serializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(serializer, "serializer");
        k(getTag(descriptor, i5));
        encodeSerializableValue(serializer, t6);
    }

    @Override // p078n4.l, p089p4.r
    public <T> void encodeSerializableValue(m mVar, T t6) {
        k.encodeSerializableValue(this, mVar, t6);
    }

    @Override // p078n4.h
    public final void encodeShortElement(r descriptor, int i5, short s6) {
        E.f(descriptor, "descriptor");
        ((AbstractC1131g) this).encodeTaggedShort((String) getTag(descriptor, i5), s6);
    }

    @Override // p078n4.l
    public final void encodeString(String value) {
        E.f(value, "value");
        encodeTaggedString(j(), value);
    }

    @Override // p078n4.h
    public final void encodeStringElement(r descriptor, int i5, String value) {
        E.f(descriptor, "descriptor");
        E.f(value, "value");
        encodeTaggedString(getTag(descriptor, i5), value);
    }

    public void encodeTaggedEnum(Object obj, r enumDescriptor, int i5) {
        E.f(enumDescriptor, "enumDescriptor");
        encodeTaggedValue(obj, Integer.valueOf(i5));
    }

    public l encodeTaggedInline(Object obj, r inlineDescriptor) {
        E.f(inlineDescriptor, "inlineDescriptor");
        k(obj);
        return this;
    }

    public void encodeTaggedString(Object obj, String value) {
        E.f(value, "value");
        encodeTaggedValue(obj, value);
    }

    public void encodeTaggedValue(Object obj, Object value) {
        E.f(value, "value");
        throw new p060k4.l("Non-serializable " + U.a(value.getClass()) + " is not supported by " + U.a(getClass()) + " encoder");
    }

    public void endEncode(r descriptor) {
        E.f(descriptor, "descriptor");
    }

    @Override // p078n4.h, p089p4.r
    public final void endStructure(r descriptor) {
        E.f(descriptor, "descriptor");
        if (!this.tagStack.isEmpty()) {
            j();
        }
        endEncode(descriptor);
    }

    @Override // p078n4.l
    public final void f(byte b) {
        ((AbstractC1131g) this).encodeTaggedByte((String) j(), b);
    }

    @Override // p078n4.l
    public final void g(float f6) {
        ((AbstractC1131g) this).encodeTaggedFloat((String) j(), f6);
    }

    public final Object getCurrentTagOrNull() {
        return T.lastOrNull((List) this.tagStack);
    }

    @Override // p078n4.l, p078n4.h
    public g getSerializersModule() {
        return i.EmptySerializersModule();
    }

    public abstract Object getTag(r rVar, int i5);

    @Override // p078n4.l
    public final void h(double d) {
        ((AbstractC1131g) this).encodeTaggedDouble((String) j(), d);
    }

    public final Object i() {
        return T.last((List) this.tagStack);
    }

    public final Object j() {
        if (this.tagStack.isEmpty()) {
            throw new p060k4.l("No tag in stack for requested element");
        }
        ArrayList<Object> arrayList = this.tagStack;
        return arrayList.remove(I.getLastIndex(arrayList));
    }

    public final void k(Object obj) {
        this.tagStack.add(obj);
    }

    public boolean shouldEncodeElementDefault(r rVar, int i5) {
        return p078n4.g.shouldEncodeElementDefault(this, rVar, i5);
    }
}
