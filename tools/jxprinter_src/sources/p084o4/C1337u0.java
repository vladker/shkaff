package p084o4;

import kotlin.jvm.internal.E;
import p072m4.r;
import p078n4.b;
import p095q4.g;
import p095q4.i;

/* JADX INFO: renamed from: o4.u0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1337u0 extends b {
    public static final C1337u0 INSTANCE = new C1337u0();
    private static final g serializersModule = i.EmptySerializersModule();

    @Override // p078n4.b, p078n4.l, p089p4.r
    public void encodeEnum(r enumDescriptor, int i5) {
        E.f(enumDescriptor, "enumDescriptor");
    }

    @Override // p078n4.b, p078n4.l
    public void encodeString(String value) {
        E.f(value, "value");
    }

    @Override // p078n4.b
    public void encodeValue(Object value) {
        E.f(value, "value");
    }

    @Override // p078n4.b, p078n4.l, p078n4.h
    public g getSerializersModule() {
        return serializersModule;
    }

    @Override // p078n4.b, p078n4.l, p089p4.r
    public final void encodeNull() {
    }

    @Override // p078n4.b, p078n4.l
    public final void a(short s6) {
    }

    @Override // p078n4.b, p078n4.l
    public final void b(boolean z6) {
    }

    @Override // p078n4.b, p078n4.l
    public final void c(int i5) {
    }

    @Override // p078n4.b, p078n4.l
    public final void d(long j6) {
    }

    @Override // p078n4.b, p078n4.l
    public final void e(char c) {
    }

    @Override // p078n4.b, p078n4.l
    public final void f(byte b) {
    }

    @Override // p078n4.b, p078n4.l
    public final void g(float f6) {
    }

    @Override // p078n4.b, p078n4.l
    public final void h(double d) {
    }
}
