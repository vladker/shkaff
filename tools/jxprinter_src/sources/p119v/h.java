package p119v;

import J0.d;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appdev.standard.model.ReceiptPictureDataModel;
import com.bumptech.glide.request.target.c;
import p056k0.q;
import p113u.g;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReceiptPictureDataModel f8754a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ String c;
    public final /* synthetic */ j d;

    public h(j jVar, ReceiptPictureDataModel receiptPictureDataModel, ImageView imageView, String str) {
        this.d = jVar;
        this.f8754a = receiptPictureDataModel;
        this.b = imageView;
        this.c = str;
    }

    @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
    @SuppressLint({"ClickableViewAccessibility"})
    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable d dVar) {
        String str = this.c;
        ImageView imageView = this.b;
        j jVar = this.d;
        ReceiptPictureDataModel receiptPictureDataModel = this.f8754a;
        q qVar = new q();
        try {
            Bitmap bitmapC = q.c(receiptPictureDataModel.getDisplayMode() == 1 ? qVar.scaleBitmapByTile(bitmap, C1849c.mm2px(receiptPictureDataModel.getW()), C1849c.mm2px(receiptPictureDataModel.getH())) : qVar.scaleBitmapByEqualRatio(bitmap, C1849c.mm2px(receiptPictureDataModel.getW()), C1849c.mm2px(receiptPictureDataModel.getH())));
            imageView.setImageBitmap(bitmapC);
            jVar.f8756a.put(str, bitmapC);
        } catch (Exception unused) {
            jVar.b.add(str);
            imageView.setImageDrawable(null);
            if (jVar.c) {
                return;
            }
            jVar.c = true;
            p042h2.d.show(g.toast_receipt_picture_removed);
        }
    }

    @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
    public void onLoadCleared(@Nullable Drawable drawable) {
    }
}
