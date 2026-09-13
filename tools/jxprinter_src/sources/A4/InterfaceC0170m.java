package A4;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: A4.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface InterfaceC0170m extends f0, WritableByteChannel {
    C0169l buffer();

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    /* synthetic */ void close();

    InterfaceC0170m emit();

    InterfaceC0170m emitCompleteSegments();

    @Override // A4.f0, java.io.Flushable
    void flush();

    C0169l getBuffer();

    OutputStream outputStream();

    @Override // A4.f0
    /* synthetic */ k0 timeout();

    InterfaceC0170m write(h0 h0Var, long j6);

    InterfaceC0170m write(C0173p c0173p);

    InterfaceC0170m write(C0173p c0173p, int i5, int i6);

    InterfaceC0170m write(byte[] bArr);

    InterfaceC0170m write(byte[] bArr, int i5, int i6);

    @Override // A4.f0
    /* synthetic */ void write(C0169l c0169l, long j6);

    long writeAll(h0 h0Var);

    InterfaceC0170m writeByte(int i5);

    InterfaceC0170m writeDecimalLong(long j6);

    InterfaceC0170m writeHexadecimalUnsignedLong(long j6);

    InterfaceC0170m writeInt(int i5);

    InterfaceC0170m writeIntLe(int i5);

    InterfaceC0170m writeLong(long j6);

    InterfaceC0170m writeLongLe(long j6);

    InterfaceC0170m writeShort(int i5);

    InterfaceC0170m writeShortLe(int i5);

    InterfaceC0170m writeString(String str, int i5, int i6, Charset charset);

    InterfaceC0170m writeString(String str, Charset charset);

    InterfaceC0170m writeUtf8(String str);

    InterfaceC0170m writeUtf8(String str, int i5, int i6);

    InterfaceC0170m writeUtf8CodePoint(int i5);
}
