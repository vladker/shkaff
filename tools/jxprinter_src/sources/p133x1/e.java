package p133x1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.E;
import p145z1.f;
import p145z1.g;
import p145z1.h;
import p145z1.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private final i mergeOption;

    public e(i mergeOption) {
        E.f(mergeOption, "mergeOption");
        this.mergeOption = mergeOption;
    }

    public final byte[] process() {
        i iVar = this.mergeOption;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iVar.f9108a, iVar.b, Bitmap.Config.ARGB_8888);
        E.e(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        for (h hVar : this.mergeOption.getImages()) {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(hVar.getByteArray(), 0, hVar.getByteArray().length);
            g position = hVar.getPosition();
            int i5 = position.f9107a;
            int i6 = position.b;
            canvas.drawBitmap(bitmapDecodeByteArray, (Rect) null, new Rect(i5, i6, position.c + i5, position.d + i6), (Paint) null);
        }
        f formatOption = this.mergeOption.getFormatOption();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(formatOption.f9106a == 1 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, formatOption.b, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
