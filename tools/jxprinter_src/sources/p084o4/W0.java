package p084o4;

import A3.I;
import A3.T;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import kotlinx.serialization.json.internal.AbstractC1128d;
import p060k4.a;
import p060k4.l;
import p072m4.r;
import p078n4.e;
import p078n4.f;
import p078n4.i;
import p078n4.j;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class W0 implements j, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6458a;
    private final ArrayList<Object> tagStack = new ArrayList<>();

    @Override // p078n4.j
    public final double a() {
        return ((AbstractC1128d) this).decodeTaggedDouble((String) i());
    }

    @Override // p078n4.j
    public final byte b() {
        return ((AbstractC1128d) this).decodeTaggedByte((String) i());
    }

    @Override // p078n4.j, p089p4.k
    public f beginStructure(r descriptor) {
        E.f(descriptor, "descriptor");
        return this;
    }

    @Override // p078n4.j
    public final long c() {
        return ((AbstractC1128d) this).decodeTaggedLong((String) i());
    }

    public final void copyTagsTo(W0 other) {
        E.f(other, "other");
        other.tagStack.addAll(this.tagStack);
    }

    @Override // p078n4.j
    public final short d() {
        return ((AbstractC1128d) this).decodeTaggedShort((String) i());
    }

    @Override // p078n4.f
    public final boolean decodeBooleanElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedBoolean((String) getTag(descriptor, i5));
    }

    @Override // p078n4.f
    public final byte decodeByteElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedByte((String) getTag(descriptor, i5));
    }

    @Override // p078n4.f
    public final char decodeCharElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedChar((String) getTag(descriptor, i5));
    }

    @Override // p078n4.f
    public int decodeCollectionSize(r rVar) {
        return e.decodeCollectionSize(this, rVar);
    }

    @Override // p078n4.f
    public final double decodeDoubleElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedDouble((String) getTag(descriptor, i5));
    }

    public abstract /* synthetic */ int decodeElementIndex(r rVar);

    @Override // p078n4.j, p089p4.k
    public final int decodeEnum(r enumDescriptor) {
        E.f(enumDescriptor, "enumDescriptor");
        return decodeTaggedEnum(i(), enumDescriptor);
    }

    @Override // p078n4.f
    public final float decodeFloatElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedFloat((String) getTag(descriptor, i5));
    }

    @Override // p078n4.j, p089p4.k
    public j decodeInline(r descriptor) {
        E.f(descriptor, "descriptor");
        return decodeTaggedInline(i(), descriptor);
    }

    @Override // p078n4.f
    public final j decodeInlineElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return decodeTaggedInline(getTag(descriptor, i5), descriptor.getElementDescriptor(i5));
    }

    @Override // p078n4.f
    public final int decodeIntElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedInt((String) getTag(descriptor, i5));
    }

    @Override // p078n4.f
    public final long decodeLongElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedLong((String) getTag(descriptor, i5));
    }

    @Override // p078n4.j, p089p4.k
    public final Void decodeNull() {
        return null;
    }

    @Override // p078n4.f
    public final <T> T decodeNullableSerializableElement(r descriptor, int i5, a deserializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(deserializer, "deserializer");
        j(getTag(descriptor, i5));
        T t7 = (deserializer.getDescriptor().a() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializer, t6) : (T) decodeNull();
        if (!this.f6458a) {
            i();
        }
        this.f6458a = false;
        return t7;
    }

    @Override // p078n4.j
    public <T> T decodeNullableSerializableValue(a aVar) {
        return (T) i.decodeNullableSerializableValue(this, aVar);
    }

    @Override // p078n4.f
    public boolean decodeSequentially() {
        return e.decodeSequentially(this);
    }

    @Override // p078n4.f, p089p4.k
    public final <T> T decodeSerializableElement(r descriptor, int i5, a deserializer, T t6) {
        E.f(descriptor, "descriptor");
        E.f(deserializer, "deserializer");
        j(getTag(descriptor, i5));
        T t7 = (T) decodeSerializableValue(deserializer, t6);
        if (!this.f6458a) {
            i();
        }
        this.f6458a = false;
        return t7;
    }

    @Override // p078n4.j, p089p4.k
    public <T> T decodeSerializableValue(a aVar) {
        return (T) i.decodeSerializableValue(this, aVar);
    }

    @Override // p078n4.f
    public final short decodeShortElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return ((AbstractC1128d) this).decodeTaggedShort((String) getTag(descriptor, i5));
    }

    @Override // p078n4.j, p089p4.k
    public final String decodeString() {
        return decodeTaggedString(i());
    }

    @Override // p078n4.f
    public final String decodeStringElement(r descriptor, int i5) {
        E.f(descriptor, "descriptor");
        return decodeTaggedString(getTag(descriptor, i5));
    }

    public int decodeTaggedEnum(Object obj, r enumDescriptor) {
        E.f(enumDescriptor, "enumDescriptor");
        Object objDecodeTaggedValue = decodeTaggedValue(obj);
        E.d(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeTaggedValue).intValue();
    }

    public j decodeTaggedInline(Object obj, r inlineDescriptor) {
        E.f(inlineDescriptor, "inlineDescriptor");
        j(obj);
        return this;
    }

    public Void decodeTaggedNull(Object obj) {
        return null;
    }

    public String decodeTaggedString(Object obj) {
        Object objDecodeTaggedValue = decodeTaggedValue(obj);
        E.d(objDecodeTaggedValue, "null cannot be cast to non-null type kotlin.String");
        return (String) objDecodeTaggedValue;
    }

    public Object decodeTaggedValue(Object obj) {
        throw new l(U.a(getClass()) + " can't retrieve untyped values");
    }

    @Override // p078n4.j
    public final char e() {
        return ((AbstractC1128d) this).decodeTaggedChar((String) i());
    }

    public void endStructure(r descriptor) {
        E.f(descriptor, "descriptor");
    }

    @Override // p078n4.j
    public final int f() {
        return ((AbstractC1128d) this).decodeTaggedInt((String) i());
    }

    @Override // p078n4.j
    public final float g() {
        return ((AbstractC1128d) this).decodeTaggedFloat((String) i());
    }

    public final Object getCurrentTagOrNull() {
        return T.lastOrNull((List) this.tagStack);
    }

    @Override // p078n4.j, p078n4.f, p089p4.k
    public g getSerializersModule() {
        return p095q4.i.EmptySerializersModule();
    }

    public abstract Object getTag(r rVar, int i5);

    public final ArrayList<Object> getTagStack$kotlinx_serialization_core() {
        return this.tagStack;
    }

    @Override // p078n4.j
    public final boolean h() {
        return ((AbstractC1128d) this).decodeTaggedBoolean((String) i());
    }

    public final Object i() {
        ArrayList<Object> arrayList = this.tagStack;
        Object objRemove = arrayList.remove(I.getLastIndex(arrayList));
        this.f6458a = true;
        return objRemove;
    }

    public final void j(Object obj) {
        this.tagStack.add(obj);
    }

    public <T> T decodeSerializableValue(a deserializer, T t6) {
        E.f(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }
}
