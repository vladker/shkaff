package p119v;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f8749a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i5, @NonNull Object obj) {
        viewGroup.removeView((View) this.f8749a.get(i5));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f8749a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i5) {
        View view = (View) this.f8749a.get(i5);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
