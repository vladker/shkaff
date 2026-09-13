package p146z2;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.E;
import p134x2.O;
import p147z3.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends OutputStream {
    public static final n Companion = new n();
    private static final String TAG = "UsbOutputStream";
    private final UsbDeviceConnection connection;
    private final UsbEndpoint outEndpoint;

    public o(UsbDeviceConnection connection, UsbEndpoint outEndpoint) {
        E.f(connection, "connection");
        E.f(outEndpoint, "outEndpoint");
        this.connection = connection;
        this.outEndpoint = outEndpoint;
    }

    @Override // java.io.OutputStream
    public final void write(int i5) {
        throw new r("An operation is not implemented: Not yet implemented");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        int iBulkTransfer;
        bArr.getClass();
        if (bArr.length < 64) {
            iBulkTransfer = this.connection.bulkTransfer(this.outEndpoint, bArr, bArr.length, 3000);
        } else {
            byte[] bArr2 = new byte[64];
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i6 < bArr.length) {
                int length = bArr.length - i6 > 64 ? 64 : bArr.length - i6;
                System.arraycopy(bArr, i6, bArr2, 0, length);
                int iBulkTransfer2 = this.connection.bulkTransfer(this.outEndpoint, bArr2, length, 3000);
                if (iBulkTransfer2 < 0) {
                    throw new IOException("USB transfer error: " + this);
                }
                if (iBulkTransfer2 == 0) {
                    if (i7 >= 3) {
                        throw new IOException("USB transfer timeout");
                    }
                    i7++;
                }
                i5 += iBulkTransfer2;
                i6 += iBulkTransfer2;
            }
            iBulkTransfer = i5;
        }
        O.INSTANCE.i(TAG, "write length:" + iBulkTransfer);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }
}
