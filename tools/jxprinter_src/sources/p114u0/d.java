package p114u0;

import S4.h;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.contrarywind.view.WheelView;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import p086p0.b;
import p086p0.c;
import p103s0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8711a;
    public ViewGroup b;
    public ViewGroup c;
    public a d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animation f8712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animation f8713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f8715i = new b(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f8716j = new c(this);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f8717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f8718l;

    public d(Context context, int i5) {
        this.f8717k = i5;
        this.f8711a = context;
    }

    public final void a() {
        c();
        if (this.e) {
            return;
        }
        this.f8712f.setAnimationListener(new a(this));
        this.b.startAnimation(this.f8712f);
        this.e = true;
    }

    public final void b() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        Context context = this.f8711a;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        c();
        a aVar = this.d;
        if (aVar.f8186g == null) {
            aVar.f8186g = (ViewGroup) ((Activity) context).getWindow().getDecorView();
        }
        ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(c.layout_basepickerview, this.d.f8186g, false);
        this.c = viewGroup;
        viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        int i5 = this.d.f8196q;
        if (i5 != -1) {
            this.c.setBackgroundColor(i5);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.c.findViewById(b.content_container);
        this.b = viewGroup2;
        viewGroup2.setLayoutParams(layoutParams);
        c();
        ViewGroup viewGroup3 = this.c;
        viewGroup3.setFocusable(true);
        viewGroup3.setFocusableInTouchMode(true);
        viewGroup3.setOnKeyListener(this.f8715i);
    }

    public final void c() {
        switch (this.f8717k) {
            case 0:
                this.d.getClass();
                break;
            default:
                this.d.getClass();
                break;
        }
    }

    public void d() {
        e eVar = (e) this.f8718l;
        if (eVar != null) {
            a aVar = this.d;
            int i5 = aVar.c;
            int i6 = aVar.d;
            WheelView wheelView = eVar.f8719a;
            WheelView wheelView2 = eVar.b;
            WheelView wheelView3 = eVar.c;
            if (eVar.e) {
                if (eVar.d != null) {
                    wheelView.setCurrentItem(i5);
                }
            } else {
                wheelView.setCurrentItem(i5);
                wheelView2.setCurrentItem(i6);
                wheelView3.setCurrentItem(0);
            }
        }
    }

    public void e(ArrayList arrayList, ArrayList arrayList2) {
        e eVar = (e) this.f8718l;
        eVar.e = false;
        WheelView wheelView = eVar.c;
        WheelView wheelView2 = eVar.b;
        WheelView wheelView3 = eVar.f8719a;
        wheelView3.setAdapter(new p075n1.a(arrayList, 14));
        wheelView3.setCurrentItem(0);
        if (arrayList2 != null) {
            wheelView2.setAdapter(new p075n1.a(arrayList2, 14));
        }
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        wheelView3.setIsOptions(true);
        wheelView2.setIsOptions(true);
        wheelView.setIsOptions(true);
        if (arrayList2 == null) {
            wheelView2.setVisibility(8);
        } else {
            wheelView2.setVisibility(0);
        }
        wheelView.setVisibility(8);
        d();
    }

    public void f(List list) {
        e eVar = (e) this.f8718l;
        WheelView wheelView = eVar.c;
        WheelView wheelView2 = eVar.b;
        eVar.d = list;
        WheelView wheelView3 = eVar.f8719a;
        wheelView3.setAdapter(new p075n1.a(list, 14));
        wheelView3.setCurrentItem(0);
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        wheelView3.setIsOptions(true);
        wheelView2.setIsOptions(true);
        wheelView.setIsOptions(true);
        wheelView2.setVisibility(8);
        wheelView.setVisibility(8);
        h hVar = new h(eVar, 16);
        new p075n1.a(eVar, 16);
        if (list != null && eVar.e) {
            wheelView3.setOnItemSelectedListener(hVar);
        }
        d();
    }

    public void g(int i5) {
        this.d.c = i5;
        d();
    }

    public final void h() {
        c();
        c();
        if (this.c.getParent() != null || this.f8714h) {
            return;
        }
        this.f8714h = true;
        this.d.f8186g.addView(this.c);
        this.b.startAnimation(this.f8713g);
        this.c.requestFocus();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f8717k) {
            case 0:
                String str = (String) view.getTag();
                if (str.equals("submit")) {
                    if (this.d.f8184a != null) {
                        e eVar = (e) this.f8718l;
                        WheelView wheelView = eVar.c;
                        WheelView wheelView2 = eVar.b;
                        int currentItem = wheelView.getCurrentItem();
                        int[] iArr = {eVar.f8719a.getCurrentItem(), wheelView2.getCurrentItem(), currentItem};
                        this.d.f8184a.onOptionsSelect(iArr[0], iArr[1], currentItem, null);
                    }
                } else if (str.equals("cancel")) {
                    this.d.getClass();
                }
                a();
                break;
            default:
                String str2 = (String) view.getTag();
                if (str2.equals("submit")) {
                    if (this.d.b != null) {
                        try {
                            this.d.b.onTimeSelect(g.f8721p.parse(((g) this.f8718l).b()), null);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (str2.equals("cancel")) {
                    this.d.getClass();
                }
                a();
                break;
        }
    }
}
