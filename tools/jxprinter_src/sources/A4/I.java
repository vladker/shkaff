package A4;

import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class I extends AbstractC0177u {
    private final RandomAccessFile randomAccessFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(boolean z6, RandomAccessFile randomAccessFile) {
        super(z6);
        kotlin.jvm.internal.E.f(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override // A4.AbstractC0177u
    public final synchronized void protectedClose() {
        this.randomAccessFile.close();
    }

    @Override // A4.AbstractC0177u
    public final synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override // A4.AbstractC0177u
    public synchronized int protectedRead(long j6, byte[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        this.randomAccessFile.seek(j6);
        int i7 = 0;
        while (i7 < i6) {
            int i8 = this.randomAccessFile.read(array, i5, i6 - i7);
            if (i8 == -1) {
                if (i7 != 0) {
                    break;
                }
                return -1;
            }
            i7 += i8;
        }
        return i7;
    }

    @Override // A4.AbstractC0177u
    public final synchronized void protectedResize(long j6) throws Throwable {
        try {
            try {
                long size = size();
                long j7 = j6 - size;
                if (j7 > 0) {
                    int i5 = (int) j7;
                    protectedWrite(size, new byte[i5], 0, i5);
                } else {
                    this.randomAccessFile.setLength(j6);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // A4.AbstractC0177u
    public final synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    @Override // A4.AbstractC0177u
    public synchronized void protectedWrite(long j6, byte[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        this.randomAccessFile.seek(j6);
        this.randomAccessFile.write(array, i5, i6);
    }
}
