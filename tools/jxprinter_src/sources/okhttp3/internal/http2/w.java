package okhttp3.internal.http2;

import A4.C0173p;
import A4.InterfaceC0171n;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class w implements Closeable {
    public static final Logger e = Logger.getLogger(AbstractC1363g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0171n f6648a;
    public final u b;
    public final boolean c;
    public final C1360d d;

    public w(InterfaceC0171n interfaceC0171n, boolean z6) {
        this.f6648a = interfaceC0171n;
        this.c = z6;
        u uVar = new u(interfaceC0171n);
        this.b = uVar;
        this.d = new C1360d(uVar);
    }

    public static int lengthWithoutPadding(int i5, byte b, short s6) throws IOException {
        if ((b & 8) != 0) {
            i5--;
        }
        if (s6 <= i5) {
            return (short) (i5 - s6);
        }
        throw AbstractC1363g.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s6), Integer.valueOf(i5));
    }

    private void readData(v vVar, int i5, byte b, int i6) throws IOException {
        if (i6 == 0) {
            throw AbstractC1363g.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z6 = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw AbstractC1363g.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        int i7 = b & 8;
        InterfaceC0171n interfaceC0171n = this.f6648a;
        short s6 = i7 != 0 ? (short) (interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE) : (short) 0;
        ((r) vVar).data(z6, i6, interfaceC0171n, lengthWithoutPadding(i5, b, s6));
        interfaceC0171n.skip(s6);
    }

    private void readGoAway(v vVar, int i5, byte b, int i6) throws IOException {
        EnumC1358b enumC1358b;
        A[] aArr;
        if (i5 < 8) {
            throw AbstractC1363g.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i5));
        }
        if (i6 != 0) {
            throw AbstractC1363g.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i7 = this.f6648a.readInt();
        int i8 = this.f6648a.readInt();
        int i9 = i5 - 8;
        EnumC1358b[] enumC1358bArrValues = EnumC1358b.values();
        int length = enumC1358bArrValues.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                enumC1358b = null;
                break;
            }
            enumC1358b = enumC1358bArrValues[i10];
            if (enumC1358b.f6599a == i8) {
                break;
            } else {
                i10++;
            }
        }
        if (enumC1358b == null) {
            throw AbstractC1363g.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i8));
        }
        C0173p byteString = C0173p.EMPTY;
        if (i9 > 0) {
            byteString = this.f6648a.readByteString(i9);
        }
        r rVar = (r) vVar;
        rVar.getClass();
        byteString.size();
        synchronized (rVar.c) {
            aArr = (A[]) rVar.c.c.values().toArray(new A[rVar.c.c.size()]);
            rVar.c.f6623g = true;
        }
        for (A a6 : aArr) {
            if (a6.c > i7 && a6.c()) {
                EnumC1358b enumC1358b2 = EnumC1358b.REFUSED_STREAM;
                synchronized (a6) {
                    if (a6.errorCode == null) {
                        a6.errorCode = enumC1358b2;
                        a6.notifyAll();
                    }
                }
                rVar.c.e(a6.c);
            }
        }
    }

    private List<C1359c> readHeaderBlock(int i5, short s6, byte b, int i6) {
        u uVar = this.b;
        uVar.e = i5;
        uVar.b = i5;
        uVar.f6647f = s6;
        uVar.c = b;
        uVar.d = i6;
        C1360d c1360d = this.d;
        c1360d.readHeaders();
        ArrayList arrayList = c1360d.f6605a;
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList.clear();
        return arrayList2;
    }

    private void readHeaders(v vVar, int i5, byte b, int i6) throws IOException {
        if (i6 == 0) {
            throw AbstractC1363g.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z6 = (b & 1) != 0;
        short s6 = (b & 8) != 0 ? (short) (this.f6648a.readByte() & UnsignedBytes.MAX_VALUE) : (short) 0;
        if ((b & 32) != 0) {
            readPriority(vVar, i6);
            i5 -= 5;
        }
        List<C1359c> headerBlock = readHeaderBlock(lengthWithoutPadding(i5, b, s6), s6, b, i6);
        r rVar = (r) vVar;
        s sVar = rVar.c;
        if (i6 != 0 && (i6 & 1) == 0) {
            try {
                sVar.d(new j(sVar, new Object[]{sVar.d, Integer.valueOf(i6)}, i6, headerBlock, z6));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (sVar) {
            try {
                A aB = rVar.c.b(i6);
                if (aB != null) {
                    aB.e(p107s4.d.p(headerBlock), z6);
                    return;
                }
                s sVar2 = rVar.c;
                if (sVar2.f6623g) {
                    return;
                }
                if (i6 <= sVar2.e) {
                    return;
                }
                if (i6 % 2 == sVar2.f6622f % 2) {
                    return;
                }
                A a6 = new A(i6, rVar.c, false, z6, p107s4.d.p(headerBlock));
                s sVar3 = rVar.c;
                sVar3.e = i6;
                sVar3.c.put(Integer.valueOf(i6), a6);
                s.f6620z.execute(new q(rVar, new Object[]{rVar.c.d, Integer.valueOf(i6)}, a6));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int readMedium(InterfaceC0171n interfaceC0171n) {
        return (interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE) | ((interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE) << 8);
    }

    private void readPing(v vVar, int i5, byte b, int i6) throws IOException {
        if (i5 != 8) {
            throw AbstractC1363g.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i5));
        }
        if (i6 != 0) {
            throw AbstractC1363g.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        int i7 = this.f6648a.readInt();
        int i8 = this.f6648a.readInt();
        boolean z6 = (b & 1) != 0;
        r rVar = (r) vVar;
        rVar.getClass();
        if (!z6) {
            try {
                s sVar = rVar.c;
                sVar.f6624h.execute(new p(sVar, i7, i8));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (rVar.c) {
            try {
                if (i7 == 1) {
                    rVar.c.f6628l++;
                } else if (i7 == 2) {
                    rVar.c.f6630n++;
                } else if (i7 == 3) {
                    s sVar2 = rVar.c;
                    sVar2.f6632p++;
                    sVar2.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void readPriority(v vVar, int i5, byte b, int i6) throws IOException {
        if (i5 != 5) {
            throw AbstractC1363g.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i5));
        }
        if (i6 == 0) {
            throw AbstractC1363g.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(vVar, i6);
    }

    private void readPushPromise(v vVar, int i5, byte b, int i6) throws IOException {
        if (i6 == 0) {
            throw AbstractC1363g.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        int i7 = b & 8;
        InterfaceC0171n interfaceC0171n = this.f6648a;
        short s6 = i7 != 0 ? (short) (interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE) : (short) 0;
        ((r) vVar).pushPromise(i6, interfaceC0171n.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i5 - 4, b, s6), s6, b, i6));
    }

    private void readRstStream(v vVar, int i5, byte b, int i6) throws IOException {
        EnumC1358b enumC1358b;
        if (i5 != 4) {
            throw AbstractC1363g.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i5));
        }
        int i7 = 0;
        if (i6 == 0) {
            throw AbstractC1363g.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i8 = this.f6648a.readInt();
        EnumC1358b[] enumC1358bArrValues = EnumC1358b.values();
        int length = enumC1358bArrValues.length;
        while (true) {
            if (i7 >= length) {
                enumC1358b = null;
                break;
            }
            enumC1358b = enumC1358bArrValues[i7];
            if (enumC1358b.f6599a == i8) {
                break;
            } else {
                i7++;
            }
        }
        if (enumC1358b == null) {
            throw AbstractC1363g.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i8));
        }
        s sVar = ((r) vVar).c;
        if (i6 != 0 && (i6 & 1) == 0) {
            sVar.d(new l(sVar, new Object[]{sVar.d, Integer.valueOf(i6)}, i6, enumC1358b));
            return;
        }
        A aE = sVar.e(i6);
        if (aE != null) {
            synchronized (aE) {
                if (aE.errorCode == null) {
                    aE.errorCode = enumC1358b;
                    aE.notifyAll();
                }
            }
        }
    }

    private void readSettings(v vVar, int i5, byte b, int i6) throws IOException {
        if (i6 != 0) {
            throw AbstractC1363g.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i5 != 0) {
                throw AbstractC1363g.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            vVar.getClass();
            return;
        }
        if (i5 % 6 != 0) {
            throw AbstractC1363g.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i5));
        }
        F f6 = new F();
        for (int i7 = 0; i7 < i5; i7 += 6) {
            InterfaceC0171n interfaceC0171n = this.f6648a;
            int i8 = interfaceC0171n.readShort() & 65535;
            int i9 = interfaceC0171n.readInt();
            if (i8 == 2) {
                if (i9 != 0 && i9 != 1) {
                    throw AbstractC1363g.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i8 == 3) {
                i8 = 4;
            } else if (i8 != 4) {
                if (i8 == 5 && (i9 < 16384 || i9 > 16777215)) {
                    throw AbstractC1363g.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i9));
                }
            } else {
                if (i9 < 0) {
                    throw AbstractC1363g.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i8 = 7;
            }
            f6.b(i8, i9);
        }
        r rVar = (r) vVar;
        rVar.getClass();
        try {
            s sVar = rVar.c;
            sVar.f6624h.execute(new q(rVar, new Object[]{sVar.d}, f6));
        } catch (RejectedExecutionException unused) {
        }
    }

    private void readWindowUpdate(v vVar, int i5, byte b, int i6) throws IOException {
        if (i5 != 4) {
            throw AbstractC1363g.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i5));
        }
        long j6 = ((long) this.f6648a.readInt()) & 2147483647L;
        if (j6 == 0) {
            throw AbstractC1363g.ioException("windowSizeIncrement was 0", Long.valueOf(j6));
        }
        r rVar = (r) vVar;
        if (i6 == 0) {
            synchronized (rVar.c) {
                s sVar = rVar.c;
                sVar.f6635s += j6;
                sVar.notifyAll();
            }
            return;
        }
        A aB = rVar.c.b(i6);
        if (aB != null) {
            synchronized (aB) {
                aB.b += j6;
                if (j6 > 0) {
                    aB.notifyAll();
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6648a.close();
    }

    public boolean nextFrame(boolean z6, v vVar) throws IOException {
        InterfaceC0171n interfaceC0171n = this.f6648a;
        try {
            interfaceC0171n.require(9L);
            int medium = readMedium(interfaceC0171n);
            if (medium < 0 || medium > 16384) {
                throw AbstractC1363g.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(medium));
            }
            byte b = (byte) (interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE);
            if (z6 && b != 4) {
                throw AbstractC1363g.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(b));
            }
            byte b6 = (byte) (interfaceC0171n.readByte() & UnsignedBytes.MAX_VALUE);
            int i5 = interfaceC0171n.readInt() & Integer.MAX_VALUE;
            Level level = Level.FINE;
            Logger logger = e;
            if (logger.isLoggable(level)) {
                logger.fine(AbstractC1363g.a(true, i5, medium, b, b6));
            }
            switch (b) {
                case 0:
                    readData(vVar, medium, b6, i5);
                    return true;
                case 1:
                    readHeaders(vVar, medium, b6, i5);
                    return true;
                case 2:
                    readPriority(vVar, medium, b6, i5);
                    return true;
                case 3:
                    readRstStream(vVar, medium, b6, i5);
                    return true;
                case 4:
                    readSettings(vVar, medium, b6, i5);
                    return true;
                case 5:
                    readPushPromise(vVar, medium, b6, i5);
                    return true;
                case 6:
                    readPing(vVar, medium, b6, i5);
                    return true;
                case 7:
                    readGoAway(vVar, medium, b6, i5);
                    return true;
                case 8:
                    readWindowUpdate(vVar, medium, b6, i5);
                    return true;
                default:
                    interfaceC0171n.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public void readConnectionPreface(v vVar) throws IOException {
        if (this.c) {
            if (!nextFrame(true, vVar)) {
                throw AbstractC1363g.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        C0173p c0173p = AbstractC1363g.f6614a;
        C0173p byteString = this.f6648a.readByteString(c0173p.size());
        Level level = Level.FINE;
        Logger logger = e;
        if (logger.isLoggable(level)) {
            String strHex = byteString.hex();
            byte[] bArr = p107s4.d.f8235a;
            Locale locale = Locale.US;
            logger.fine("<< CONNECTION " + strHex);
        }
        if (!c0173p.equals(byteString)) {
            throw AbstractC1363g.ioException("Expected a connection header but was %s", byteString.utf8());
        }
    }

    private void readPriority(v vVar, int i5) {
        InterfaceC0171n interfaceC0171n = this.f6648a;
        interfaceC0171n.readInt();
        interfaceC0171n.readByte();
        vVar.getClass();
    }
}
