package p146z2;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import java.io.InputStream;
import kotlin.jvm.internal.E;
import p134x2.O;
import p147z3.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends InputStream {
    public static final l Companion = new l();
    private static final String TAG = "UsbInputStream";
    private final UsbDeviceConnection connection;
    private final UsbEndpoint inEndpoint;

    public m(UsbDeviceConnection connection, UsbEndpoint inEndpoint) {
        E.f(connection, "connection");
        E.f(inEndpoint, "inEndpoint");
        this.connection = connection;
        this.inEndpoint = inEndpoint;
    }

    @Override // java.io.InputStream
    public final int read() {
        throw new r("An operation is not implemented: Not yet implemented");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        long jCurrentTimeMillis;
        bArr.getClass();
        do {
            jCurrentTimeMillis = System.currentTimeMillis();
            int iBulkTransfer = this.connection.bulkTransfer(this.inEndpoint, bArr, bArr.length, 2000);
            O.INSTANCE.i(TAG, "read length:" + iBulkTransfer);
            if (iBulkTransfer >= 0) {
                return iBulkTransfer;
            }
        } while (Math.abs((System.currentTimeMillis() - jCurrentTimeMillis) - ((long) 2000)) < 200);
        return -1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
