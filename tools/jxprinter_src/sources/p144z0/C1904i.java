package p144z0;

import L0.c;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p126w0.d;
import p126w0.v;

/* JADX INFO: renamed from: z0.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1904i implements d {
    @Override // p126w0.d
    public boolean encode(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull v vVar) throws Throwable {
        try {
            c.toFile(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                return false;
            }
            Log.d("ByteBufferEncoder", "Failed to write data", e);
            return false;
        }
    }
}
