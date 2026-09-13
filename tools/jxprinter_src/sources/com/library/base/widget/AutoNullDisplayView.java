package com.library.base.widget;

import Y1.c;
import Y1.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.library.base.view.refreshlayout.RefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class AutoNullDisplayView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3603a;
    public ViewGroup b;
    public View c;
    public View d;
    public RefreshLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f3604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f3605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f3606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f3607i;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            AutoNullDisplayView autoNullDisplayView = AutoNullDisplayView.this;
            int i13 = autoNullDisplayView.f3603a;
            if (i13 == 18) {
                if (((RecyclerView) autoNullDisplayView.b).getAdapter().getItemCount() > 0) {
                    View view2 = autoNullDisplayView.d;
                    if (view2 == null || autoNullDisplayView.c == null) {
                        return;
                    }
                    view2.setVisibility(0);
                    autoNullDisplayView.c.setVisibility(4);
                    return;
                }
                View view3 = autoNullDisplayView.d;
                if (view3 == null || autoNullDisplayView.c == null) {
                    return;
                }
                view3.setVisibility(4);
                autoNullDisplayView.c.setVisibility(0);
                return;
            }
            if (i13 == 17) {
                if (((ListView) autoNullDisplayView.b).getAdapter().getCount() > 0) {
                    View view4 = autoNullDisplayView.d;
                    if (view4 == null || autoNullDisplayView.c == null) {
                        return;
                    }
                    view4.setVisibility(0);
                    autoNullDisplayView.c.setVisibility(4);
                    return;
                }
                View view5 = autoNullDisplayView.d;
                if (view5 == null || autoNullDisplayView.c == null) {
                    return;
                }
                view5.setVisibility(4);
                autoNullDisplayView.c.setVisibility(0);
            }
        }
    }

    public AutoNullDisplayView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(ViewGroup viewGroup) {
        for (int i5 = 0; i5 <= viewGroup.getChildCount() - 1 && this.f3603a == -1; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            boolean z6 = childAt instanceof ListView;
            a aVar = this.f3607i;
            if (z6) {
                this.f3603a = 17;
                this.b = (ViewGroup) childAt;
                childAt.addOnLayoutChangeListener(aVar);
            } else if (childAt instanceof RecyclerView) {
                this.f3603a = 18;
                this.b = (ViewGroup) childAt;
                childAt.addOnLayoutChangeListener(aVar);
            } else if (childAt instanceof RefreshLayout) {
                this.e = (RefreshLayout) childAt;
                a((ViewGroup) childAt);
            } else if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
            }
        }
    }

    public final void b(int i5) {
        ImageView imageView = this.f3604f;
        if (imageView != null) {
            try {
                imageView.setImageResource(i5);
                this.f3604f.setVisibility(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        a(this);
        this.d = getChildAt(0);
        if (getChildCount() == 1) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(d.layout_auto_null_display_view_empty, (ViewGroup) this, false);
            this.c = viewInflate;
            addView(viewInflate);
        } else {
            this.c = getChildAt(1);
        }
        try {
            Button button = (Button) this.c.findViewById(c.refresh_btn);
            this.f3606h = button;
            if (button != null) {
                button.setOnClickListener(new p082o2.a(this));
            }
            this.f3604f = (ImageView) this.c.findViewById(c.null_dispaly_image);
            this.f3605g = (TextView) this.c.findViewById(c.null_dispaly_content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setButtonWhetherVisible(boolean z6) {
        Button button = this.f3606h;
        if (button != null) {
            if (z6) {
                button.setVisibility(0);
            } else {
                button.setVisibility(8);
            }
        }
    }

    public void setConnect(String str) {
        TextView textView = this.f3605g;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setConnectWhetherVisible(boolean z6) {
        TextView textView = this.f3605g;
        if (textView != null) {
            if (z6) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void setImageWhetherVisible(boolean z6) {
        ImageView imageView = this.f3604f;
        if (imageView != null) {
            if (z6) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setRefreshBtnBackground(int i5) {
        Button button = this.f3606h;
        if (button != null) {
            button.setBackgroundResource(i5);
        }
    }

    public void setRefreshBtnContent(String str) {
        Button button = this.f3606h;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setRefreshBtnWhetherVisible(boolean z6) {
        Button button = this.f3606h;
        if (button != null) {
            if (z6) {
                button.setVisibility(0);
            } else {
                button.setVisibility(8);
            }
        }
    }

    public AutoNullDisplayView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f3603a = -1;
        this.f3607i = new a();
    }
}
