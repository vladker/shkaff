package K0;

import L0.s;
import android.content.Context;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements q {
    public final int b;
    public final q c;

    public a(int i5, q qVar) {
        this.b = i5;
        this.c = qVar;
    }

    @NonNull
    public static q obtain(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.obtain(context));
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.b == aVar.b && this.c.equals(aVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return s.hashCode(this.c, this.b);
    }

    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.c.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }
}
