package Z1;

import I0.j;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.c;
import com.library.base.view.photoview.PhotoView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f897a;
    public final AppCompatActivity b;
    public final int c;

    public b(AppCompatActivity appCompatActivity, String[] strArr, int i5) {
        this.b = appCompatActivity;
        this.f897a = strArr;
        this.c = i5;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i5, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        String[] strArr = this.f897a;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i5) {
        PhotoView photoView = new PhotoView(viewGroup.getContext(), null);
        c.with((Context) this.b).load(this.f897a[i5]).apply(new j().placeholder(this.c)).into(photoView);
        viewGroup.addView(photoView, -1, -1);
        photoView.setOnViewTapListener(new a(this));
        return photoView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
