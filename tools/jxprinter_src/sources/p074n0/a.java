package p074n0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.appdev.standard.model.AppBannerModel;
import com.zhouwei.mzbanner.holder.MZViewHolder;
import p113u.d;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class a implements MZViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f6212a;
    public final int b;

    public a(Integer num, @DrawableRes int i5) {
        this.b = i5;
    }

    @Override // com.zhouwei.mzbanner.holder.MZViewHolder
    public final View createView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(e.item_banner, (ViewGroup) null);
        this.f6212a = (ImageView) viewInflate.findViewById(d.banner_image);
        return viewInflate;
    }

    @Override // com.zhouwei.mzbanner.holder.MZViewHolder
    public final void onBind(Context context, int i5, Object obj) {
        AppBannerModel appBannerModel = (AppBannerModel) obj;
        p047i2.a.loadPictureFitCenter((appBannerModel == null || appBannerModel.getImgUrl() == null) ? "" : appBannerModel.getImgUrl(), this.f6212a, this.b);
    }
}
