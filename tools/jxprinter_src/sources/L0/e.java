package L0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f401a;
    public int b;

    private e(@NonNull InputStream inputStream, long j6) {
        super(inputStream);
        this.f401a = j6;
    }

    private int checkReadSoFarOrThrow(int i5) throws IOException {
        if (i5 >= 0) {
            this.b += i5;
            return i5;
        }
        long j6 = this.b;
        long j7 = this.f401a;
        if (j7 - j6 <= 0) {
            return i5;
        }
        throw new IOException("Failed to read all expected data, expected: " + j7 + ", but read: " + this.b);
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, @Nullable String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    private static int parseContentLength(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (!Log.isLoggable("ContentLengthStream", 3)) {
                return -1;
            }
            Log.d("ContentLengthStream", "failed to parse content length header: " + str, e);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f401a - ((long) this.b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i5;
        i5 = super.read();
        checkReadSoFarOrThrow(i5 >= 0 ? 1 : -1);
        return i5;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, long j6) {
        return new e(inputStream, j6);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i5, int i6) {
        return checkReadSoFarOrThrow(super.read(bArr, i5, i6));
    }
}
