package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class C1138n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5744a;
    public final InterfaceC1147x writer;

    public C1138n(InterfaceC1147x writer) {
        kotlin.jvm.internal.E.f(writer, "writer");
        this.writer = writer;
        this.f5744a = true;
    }

    public void a() {
        this.f5744a = true;
    }

    public void b() {
        this.f5744a = false;
    }

    public void c() {
        this.f5744a = false;
    }

    public void d(byte b) {
        O o6 = (O) this.writer;
        o6.getClass();
        o6.write(String.valueOf(b));
    }

    public final void e(char c) {
        ((O) this.writer).c(c);
    }

    public void f(int i5) {
        O o6 = (O) this.writer;
        o6.getClass();
        o6.write(String.valueOf(i5));
    }

    public void g(long j6) {
        O o6 = (O) this.writer;
        o6.getClass();
        o6.write(String.valueOf(j6));
    }

    public void h(short s6) {
        O o6 = (O) this.writer;
        o6.getClass();
        o6.write(String.valueOf(s6));
    }

    public final void print(String v6) {
        kotlin.jvm.internal.E.f(v6, "v");
        ((O) this.writer).write(v6);
    }

    public void printQuoted(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        ((O) this.writer).writeQuoted(value);
    }

    public void i() {
    }

    public void j() {
    }
}
