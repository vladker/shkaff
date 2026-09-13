package okhttp3.internal.http2;

import A4.C0169l;
import A4.InterfaceC0170m;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class B implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f6589g = Logger.getLogger(AbstractC1363g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0170m f6590a;
    public final boolean b;
    public final C0169l c;
    public int d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1361e f6591f;

    public B(InterfaceC0170m interfaceC0170m, boolean z6) {
        this.f6590a = interfaceC0170m;
        this.b = z6;
        C0169l c0169l = new C0169l();
        this.c = c0169l;
        this.f6591f = new C1361e(c0169l);
        this.d = 16384;
    }

    private void writeContinuationFrames(int i5, long j6) {
        while (j6 > 0) {
            int iMin = (int) Math.min(this.d, j6);
            long j7 = iMin;
            j6 -= j7;
            frameHeader(i5, iMin, (byte) 9, j6 == 0 ? (byte) 4 : (byte) 0);
            this.f6590a.write(this.c, j7);
        }
    }

    private static void writeMedium(InterfaceC0170m interfaceC0170m, int i5) {
        interfaceC0170m.writeByte((i5 >>> 16) & 255);
        interfaceC0170m.writeByte((i5 >>> 8) & 255);
        interfaceC0170m.writeByte(i5 & 255);
    }

    public synchronized void applyAndAckSettings(F f6) {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            int i5 = this.d;
            int i6 = f6.f6594a;
            if ((i6 & 32) != 0) {
                i5 = f6.b[5];
            }
            this.d = i5;
            if (((i6 & 2) != 0 ? f6.b[1] : -1) != -1) {
                C1361e c1361e = this.f6591f;
                int iMin = Math.min((i6 & 2) != 0 ? f6.b[1] : -1, 16384);
                int i7 = c1361e.d;
                if (i7 != iMin) {
                    if (iMin < i7) {
                        c1361e.b = Math.min(c1361e.b, iMin);
                    }
                    c1361e.c = true;
                    c1361e.d = iMin;
                    int i8 = c1361e.f6612h;
                    if (iMin < i8) {
                        if (iMin == 0) {
                            Arrays.fill(c1361e.e, (Object) null);
                            c1361e.f6610f = c1361e.e.length - 1;
                            c1361e.f6611g = 0;
                            c1361e.f6612h = 0;
                        } else {
                            c1361e.a(i8 - iMin);
                        }
                    }
                }
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.f6590a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.e = true;
        this.f6590a.close();
    }

    public synchronized void connectionPreface() {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            if (this.b) {
                Logger logger = f6589g;
                if (logger.isLoggable(Level.FINE)) {
                    String strHex = AbstractC1363g.f6614a.hex();
                    byte[] bArr = p107s4.d.f8235a;
                    Locale locale = Locale.US;
                    logger.fine(">> CONNECTION " + strHex);
                }
                this.f6590a.write(AbstractC1363g.f6614a.toByteArray());
                this.f6590a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void data(boolean z6, int i5, C0169l c0169l, int i6) {
        if (this.e) {
            throw new IOException("closed");
        }
        dataFrame(i5, z6 ? (byte) 1 : (byte) 0, c0169l, i6);
    }

    public void dataFrame(int i5, byte b, C0169l c0169l, int i6) {
        frameHeader(i5, i6, (byte) 0, b);
        if (i6 > 0) {
            this.f6590a.write(c0169l, i6);
        }
    }

    public synchronized void flush() {
        if (this.e) {
            throw new IOException("closed");
        }
        this.f6590a.flush();
    }

    public void frameHeader(int i5, int i6, byte b, byte b6) {
        Level level = Level.FINE;
        Logger logger = f6589g;
        if (logger.isLoggable(level)) {
            logger.fine(AbstractC1363g.a(false, i5, i6, b, b6));
        }
        int i7 = this.d;
        if (i6 > i7) {
            AbstractC1363g.b("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i7), Integer.valueOf(i6));
            throw null;
        }
        if ((Integer.MIN_VALUE & i5) != 0) {
            AbstractC1363g.b("reserved bit set: %s", Integer.valueOf(i5));
            throw null;
        }
        InterfaceC0170m interfaceC0170m = this.f6590a;
        writeMedium(interfaceC0170m, i6);
        interfaceC0170m.writeByte(b & UnsignedBytes.MAX_VALUE);
        interfaceC0170m.writeByte(b6 & UnsignedBytes.MAX_VALUE);
        interfaceC0170m.writeInt(i5 & Integer.MAX_VALUE);
    }

    public synchronized void goAway(int i5, EnumC1358b enumC1358b, byte[] bArr) {
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            if (enumC1358b.f6599a == -1) {
                AbstractC1363g.b("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f6590a.writeInt(i5);
            this.f6590a.writeInt(enumC1358b.f6599a);
            if (bArr.length > 0) {
                this.f6590a.write(bArr);
            }
            this.f6590a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void headers(boolean z6, int i5, List<C1359c> list) {
        if (this.e) {
            throw new IOException("closed");
        }
        this.f6591f.writeHeaders(list);
        long size = this.c.size();
        int iMin = (int) Math.min(this.d, size);
        long j6 = iMin;
        byte b = size == j6 ? (byte) 4 : (byte) 0;
        if (z6) {
            b = (byte) (b | 1);
        }
        frameHeader(i5, iMin, (byte) 1, b);
        this.f6590a.write(this.c, j6);
        if (size > j6) {
            writeContinuationFrames(i5, size - j6);
        }
    }

    public synchronized void ping(boolean z6, int i5, int i6) {
        if (this.e) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z6 ? (byte) 1 : (byte) 0);
        this.f6590a.writeInt(i5);
        this.f6590a.writeInt(i6);
        this.f6590a.flush();
    }

    public synchronized void pushPromise(int i5, int i6, List<C1359c> list) {
        if (this.e) {
            throw new IOException("closed");
        }
        this.f6591f.writeHeaders(list);
        long size = this.c.size();
        int iMin = (int) Math.min(this.d - 4, size);
        long j6 = iMin;
        frameHeader(i5, iMin + 4, (byte) 5, size == j6 ? (byte) 4 : (byte) 0);
        this.f6590a.writeInt(i6 & Integer.MAX_VALUE);
        this.f6590a.write(this.c, j6);
        if (size > j6) {
            writeContinuationFrames(i5, size - j6);
        }
    }

    public synchronized void rstStream(int i5, EnumC1358b enumC1358b) {
        if (this.e) {
            throw new IOException("closed");
        }
        if (enumC1358b.f6599a == -1) {
            throw new IllegalArgumentException();
        }
        frameHeader(i5, 4, (byte) 3, (byte) 0);
        this.f6590a.writeInt(enumC1358b.f6599a);
        this.f6590a.flush();
    }

    public synchronized void settings(F f6) {
        int i5;
        try {
            if (this.e) {
                throw new IOException("closed");
            }
            frameHeader(0, Integer.bitCount(f6.f6594a) * 6, (byte) 4, (byte) 0);
            int i6 = 0;
            while (i6 < 10) {
                boolean z6 = true;
                if (((1 << i6) & f6.f6594a) == 0) {
                    z6 = false;
                }
                if (z6) {
                    if (i6 == 4) {
                        i5 = 3;
                    } else {
                        i5 = i6 == 7 ? 4 : i6;
                    }
                    this.f6590a.writeShort(i5);
                    this.f6590a.writeInt(f6.b[i6]);
                }
                i6++;
            }
            this.f6590a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void windowUpdate(int i5, long j6) {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j6 == 0 || j6 > 2147483647L) {
            AbstractC1363g.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j6));
            throw null;
        }
        frameHeader(i5, 4, (byte) 8, (byte) 0);
        this.f6590a.writeInt((int) j6);
        this.f6590a.flush();
    }
}
