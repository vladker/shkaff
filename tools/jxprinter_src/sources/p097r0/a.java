package p097r0;

import Z0.c;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.contrarywind.view.WheelView;
import p086p0.b;
import p114u0.d;
import p114u0.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p103s0.a f7931a;

    public a(Context context, p109t0.a aVar) {
        p103s0.a aVar2 = new p103s0.a(1);
        this.f7931a = aVar2;
        aVar2.f8187h = context;
        aVar2.f8184a = aVar;
    }

    public final d a() {
        p103s0.a aVar = this.f7931a;
        Context context = aVar.f8187h;
        d dVar = new d(context, 0);
        dVar.d = aVar;
        Context context2 = aVar.f8187h;
        dVar.b();
        dVar.f8713g = AnimationUtils.loadAnimation(context, p086p0.a.pickerview_slide_in_bottom);
        dVar.f8712f = AnimationUtils.loadAnimation(context, p086p0.a.pickerview_slide_out_bottom);
        dVar.d.getClass();
        LayoutInflater.from(context2).inflate(dVar.d.f8185f, dVar.b);
        TextView textView = (TextView) dVar.b.findViewById(b.tvTitle);
        RelativeLayout relativeLayout = (RelativeLayout) dVar.b.findViewById(b.rv_topbar);
        Button button = (Button) dVar.b.findViewById(b.btnSubmit);
        Button button2 = (Button) dVar.b.findViewById(b.btnCancel);
        button.setTag("submit");
        button2.setTag("cancel");
        button.setOnClickListener(dVar);
        button2.setOnClickListener(dVar);
        button.setText(TextUtils.isEmpty(dVar.d.f8188i) ? context2.getResources().getString(p086p0.d.pickerview_submit) : dVar.d.f8188i);
        button2.setText(TextUtils.isEmpty(dVar.d.f8189j) ? context2.getResources().getString(p086p0.d.pickerview_cancel) : dVar.d.f8189j);
        textView.setText(TextUtils.isEmpty(dVar.d.f8190k) ? "" : dVar.d.f8190k);
        dVar.d.getClass();
        button.setTextColor(-16417281);
        dVar.d.getClass();
        button2.setTextColor(-16417281);
        dVar.d.getClass();
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        dVar.d.getClass();
        relativeLayout.setBackgroundColor(-657931);
        button.setTextSize(dVar.d.f8191l);
        button2.setTextSize(dVar.d.f8191l);
        textView.setTextSize(dVar.d.f8192m);
        LinearLayout linearLayout = (LinearLayout) dVar.b.findViewById(b.optionspicker);
        dVar.d.getClass();
        linearLayout.setBackgroundColor(-1);
        dVar.d.getClass();
        e eVar = new e();
        eVar.e = true;
        eVar.f8719a = (WheelView) linearLayout.findViewById(b.options1);
        eVar.b = (WheelView) linearLayout.findViewById(b.options2);
        eVar.c = (WheelView) linearLayout.findViewById(b.options3);
        dVar.f8718l = eVar;
        dVar.d.getClass();
        e eVar2 = (e) dVar.f8718l;
        dVar.d.getClass();
        float f6 = 18;
        eVar2.f8719a.setTextSize(f6);
        eVar2.b.setTextSize(f6);
        eVar2.c.setTextSize(f6);
        e eVar3 = (e) dVar.f8718l;
        int i5 = dVar.d.f8199t;
        eVar3.f8719a.setItemsVisibleCount(i5);
        eVar3.b.setItemsVisibleCount(i5);
        eVar3.c.setItemsVisibleCount(i5);
        e eVar4 = (e) dVar.f8718l;
        dVar.d.getClass();
        eVar4.f8719a.setAlphaGradient(false);
        eVar4.b.setAlphaGradient(false);
        eVar4.c.setAlphaGradient(false);
        e eVar5 = (e) dVar.f8718l;
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        eVar5.getClass();
        e eVar6 = (e) dVar.f8718l;
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        eVar6.f8719a.setTextXOffset(0);
        eVar6.b.setTextXOffset(0);
        eVar6.c.setTextXOffset(0);
        e eVar7 = (e) dVar.f8718l;
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        eVar7.f8719a.setCyclic(false);
        eVar7.b.setCyclic(false);
        eVar7.c.setCyclic(false);
        e eVar8 = (e) dVar.f8718l;
        Typeface typeface = dVar.d.f8197r;
        eVar8.f8719a.setTypeface(typeface);
        eVar8.b.setTypeface(typeface);
        eVar8.c.setTypeface(typeface);
        dVar.d.getClass();
        ViewGroup viewGroup = dVar.c;
        if (viewGroup != null) {
            viewGroup.findViewById(b.outmost_container).setOnTouchListener(dVar.f8716j);
        }
        e eVar9 = (e) dVar.f8718l;
        int i6 = dVar.d.f8195p;
        eVar9.f8719a.setDividerColor(i6);
        eVar9.b.setDividerColor(i6);
        eVar9.c.setDividerColor(i6);
        e eVar10 = (e) dVar.f8718l;
        c cVar = dVar.d.f8198s;
        eVar10.f8719a.setDividerType(cVar);
        eVar10.b.setDividerType(cVar);
        eVar10.c.setDividerType(cVar);
        e eVar11 = (e) dVar.f8718l;
        dVar.d.getClass();
        eVar11.f8719a.setLineSpacingMultiplier(1.6f);
        eVar11.b.setLineSpacingMultiplier(1.6f);
        eVar11.c.setLineSpacingMultiplier(1.6f);
        e eVar12 = (e) dVar.f8718l;
        int i7 = dVar.d.f8193n;
        eVar12.f8719a.setTextColorOut(i7);
        eVar12.b.setTextColorOut(i7);
        eVar12.c.setTextColorOut(i7);
        e eVar13 = (e) dVar.f8718l;
        int i8 = dVar.d.f8194o;
        eVar13.f8719a.setTextColorCenter(i8);
        eVar13.b.setTextColorCenter(i8);
        eVar13.c.setTextColorCenter(i8);
        e eVar14 = (e) dVar.f8718l;
        dVar.d.getClass();
        eVar14.f8719a.f3225g = false;
        eVar14.b.f3225g = false;
        eVar14.c.f3225g = false;
        return dVar;
    }

    @Deprecated
    public a setBackgroundId(int i5) {
        this.f7931a.f8196q = i5;
        return this;
    }

    public a setDividerColor(@ColorInt int i5) {
        this.f7931a.f8195p = i5;
        return this;
    }

    public a setTextColorOut(@ColorInt int i5) {
        this.f7931a.f8193n = i5;
        return this;
    }
}
