package p078n4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p060k4.l;
import p072m4.r;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements j, f {
    @Override // p078n4.j
    public double a() {
        Object objDecodeValue = decodeValue();
        E.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objDecodeValue).doubleValue();
    }

    @Override // p078n4.j
    public abstract byte b();

    @Override // p078n4.j, p089p4.k
    public f beginStructure(r descriptor) {
        E.f(descriptor, "descriptor");
        return this;
    }

    @Override // p078n4.j
    public abstract long c();

    @Override // p078n4.j
    public abstract short d();

    @Override // p078n4.f
    public final boolean decodeBooleanElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return h();
    }

    @Override // p078n4.f
    public final byte decodeByteElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return b();
    }

    @Override // p078n4.f
    public final char decodeCharElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return e();
    }

    @Override // p078n4.f
    public int decodeCollectionSize(r rVar) {
        return e.decodeCollectionSize(this, rVar);
    }

    @Override // p078n4.f
    public final double decodeDoubleElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return a();
    }

    public abstract /* synthetic */ int decodeElementIndex(r rVar);

    @Override // p078n4.j, p089p4.k
    public int decodeEnum(r enumDescriptor) {
        E.f(enumDescriptor, "enumDescriptor");
        Object objDecodeValue = decodeValue();
        E.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // p078n4.f
    public final float decodeFloatElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return g();
    }

    @Override // p078n4.j, p089p4.k
    public j decodeInline(r descriptor) {
        E.f(descriptor, "descriptor");
        return this;
    }

    @Override // p078n4.f
    public j decodeInlineElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return decodeInline(descriptor.getElementDescriptor(i5));
    }

    @Override // p078n4.f
    public final int decodeIntElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return f();
    }

    @Override // p078n4.f
    public final long decodeLongElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return c();
    }

    @Override // p078n4.j, p089p4.k
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // p078n4.j, p089p4.k
    public Void decodeNull() {
        return null;
    }

    @Override // p078n4.f
    public final <T> T decodeNullableSerializableElement(r descriptor, int i5, p060k4.a deserializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().a() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializer, t6) : (T) decodeNull();
    }

    @Override // p078n4.j
    public <T> T decodeNullableSerializableValue(p060k4.a aVar) {
        return (T) i.decodeNullableSerializableValue(this, aVar);
    }

    @Override // p078n4.f
    public boolean decodeSequentially() {
        return e.decodeSequentially(this);
    }

    public <T> T decodeSerializableElement(r descriptor, int i5, p060k4.a deserializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer, t6);
    }

    @Override // p078n4.j, p089p4.k
    public <T> T decodeSerializableValue(p060k4.a aVar) {
        return (T) i.decodeSerializableValue(this, aVar);
    }

    @Override // p078n4.f
    public final short decodeShortElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return d();
    }

    @Override // p078n4.j, p089p4.k
    public String decodeString() {
        Object objDecodeValue = decodeValue();
        E.d(objDecodeValue, "null cannot be cast to non-null type kotlin.String");
        return (String) objDecodeValue;
    }

    @Override // p078n4.f
    public final String decodeStringElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return decodeString();
    }

    public Object decodeValue() {
        throw new l(U.a(getClass()) + " can't retrieve untyped values");
    }

    @Override // p078n4.j
    public char e() {
        Object objDecodeValue = decodeValue();
        E.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objDecodeValue).charValue();
    }

    public void endStructure(r descriptor) {
        E.f(descriptor, "descriptor");
    }

    @Override // p078n4.j
    public abstract int f();

    @Override // p078n4.j
    public float g() {
        Object objDecodeValue = decodeValue();
        E.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objDecodeValue).floatValue();
    }

    @Override // p078n4.j, p078n4.f, p089p4.k
    public abstract /* synthetic */ g getSerializersModule();

    @Override // p078n4.j
    public boolean h() {
        Object objDecodeValue = decodeValue();
        E.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objDecodeValue).booleanValue();
    }

    public <T> T decodeSerializableValue(p060k4.a deserializer, T t6) {
        E.f(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }
}
