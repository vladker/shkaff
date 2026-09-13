package A4;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: A4.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface InterfaceC0171n extends h0, ReadableByteChannel {
    C0169l buffer();

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
    /* synthetic */ void close();

    boolean exhausted();

    C0169l getBuffer();

    long indexOf(byte b);

    long indexOf(byte b, long j6);

    long indexOf(byte b, long j6, long j7);

    long indexOf(C0173p c0173p);

    long indexOf(C0173p c0173p, long j6);

    long indexOfElement(C0173p c0173p);

    long indexOfElement(C0173p c0173p, long j6);

    InputStream inputStream();

    InterfaceC0171n peek();

    boolean rangeEquals(long j6, C0173p c0173p);

    boolean rangeEquals(long j6, C0173p c0173p, int i5, int i6);

    int read(byte[] bArr);

    int read(byte[] bArr, int i5, int i6);

    @Override // A4.h0
    /* synthetic */ long read(C0169l c0169l, long j6);

    long readAll(f0 f0Var);

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long j6);

    C0173p readByteString();

    C0173p readByteString(long j6);

    long readDecimalLong();

    void readFully(C0169l c0169l, long j6);

    void readFully(byte[] bArr);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readString(long j6, Charset charset);

    String readString(Charset charset);

    String readUtf8();

    String readUtf8(long j6);

    int readUtf8CodePoint();

    String readUtf8Line();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j6);

    boolean request(long j6);

    void require(long j6);

    int select(S s6);

    void skip(long j6);

    @Override // A4.h0
    /* synthetic */ k0 timeout();
}
