package p097r0;

import android.content.Context;
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
import androidx.exifinterface.media.ExifInterface;
import com.contrarywind.view.WheelView;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.opencv.videoio.Videoio;
import p086p0.c;
import p103s0.a;
import p114u0.d;
import p114u0.f;
import p114u0.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7932a;

    public b(Context context, p109t0.b bVar) {
        a aVar = new a(2);
        this.f7932a = aVar;
        aVar.f8187h = context;
        aVar.b = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x048c  */
    /* JADX WARN: Code duplicated, block: B:113:0x0496  */
    /* JADX WARN: Code duplicated, block: B:114:0x0498  */
    /* JADX WARN: Code duplicated, block: B:117:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:118:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:121:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:122:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:125:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:126:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:129:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:130:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:133:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:136:0x0611  */
    /* JADX WARN: Code duplicated, block: B:139:0x0729  */
    /* JADX WARN: Instruction removed from duplicated block: B:111:0x048c, please report this as an issue */
    public final d a() {
        boolean z6;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ViewGroup viewGroup;
        a aVar = this.f7932a;
        Context context = aVar.f8187h;
        d dVar = new d(context, 1);
        dVar.d = aVar;
        Context context2 = aVar.f8187h;
        dVar.b();
        dVar.f8713g = AnimationUtils.loadAnimation(context, p086p0.a.pickerview_slide_in_bottom);
        dVar.f8712f = AnimationUtils.loadAnimation(context, p086p0.a.pickerview_slide_out_bottom);
        dVar.d.getClass();
        LayoutInflater.from(context2).inflate(c.pickerview_time, dVar.b);
        TextView textView = (TextView) dVar.b.findViewById(p086p0.b.tvTitle);
        RelativeLayout relativeLayout = (RelativeLayout) dVar.b.findViewById(p086p0.b.rv_topbar);
        Button button = (Button) dVar.b.findViewById(p086p0.b.btnSubmit);
        Button button2 = (Button) dVar.b.findViewById(p086p0.b.btnCancel);
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
        LinearLayout linearLayout = (LinearLayout) dVar.b.findViewById(p086p0.b.timepicker);
        dVar.d.getClass();
        linearLayout.setBackgroundColor(-1);
        boolean[] zArr = dVar.d.e;
        g gVar = new g();
        gVar.f8726i = Videoio.CAP_FFMPEG;
        gVar.f8727j = Videoio.CAP_ARAVIS;
        gVar.f8728k = 1;
        gVar.f8729l = 12;
        gVar.f8730m = 1;
        gVar.f8731n = 31;
        gVar.f8722a = linearLayout;
        gVar.f8725h = zArr;
        dVar.f8718l = gVar;
        dVar.d.getClass();
        g gVar2 = (g) dVar.f8718l;
        dVar.d.getClass();
        dVar.d.getClass();
        gVar2.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        Calendar calendar = Calendar.getInstance();
        dVar.d.getClass();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i13 = calendar.get(1);
        int i14 = calendar.get(2);
        int i15 = calendar.get(5);
        int i16 = calendar.get(11);
        int i17 = calendar.get(12);
        int i18 = calendar.get(13);
        g gVar3 = (g) dVar.f8718l;
        LinearLayout linearLayout2 = gVar3.f8722a;
        boolean[] zArr2 = gVar3.f8725h;
        List listAsList = Arrays.asList("1", ExifInterface.GPS_MEASUREMENT_3D, "5", "7", "8", "10", "12");
        List listAsList2 = Arrays.asList("4", "6", "9", "11");
        gVar3.f8732o = i13;
        WheelView wheelView = (WheelView) linearLayout2.findViewById(p086p0.b.year);
        gVar3.b = wheelView;
        wheelView.setAdapter(new p091q0.a(gVar3.f8726i, gVar3.f8727j));
        gVar3.b.setCurrentItem(i13 - gVar3.f8726i);
        gVar3.b.setGravity(17);
        WheelView wheelView2 = (WheelView) linearLayout2.findViewById(p086p0.b.month);
        gVar3.c = wheelView2;
        int i19 = gVar3.f8726i;
        int i20 = gVar3.f8727j;
        if (i19 == i20) {
            wheelView2.setAdapter(new p091q0.a(gVar3.f8728k, gVar3.f8729l));
            gVar3.c.setCurrentItem((i14 + 1) - gVar3.f8728k);
        } else if (i13 == i19) {
            wheelView2.setAdapter(new p091q0.a(gVar3.f8728k, 12));
            gVar3.c.setCurrentItem((i14 + 1) - gVar3.f8728k);
        } else if (i13 == i20) {
            wheelView2.setAdapter(new p091q0.a(1, gVar3.f8729l));
            gVar3.c.setCurrentItem(i14);
        } else {
            wheelView2.setAdapter(new p091q0.a(1, 12));
            gVar3.c.setCurrentItem(i14);
        }
        gVar3.c.setGravity(17);
        gVar3.d = (WheelView) linearLayout2.findViewById(p086p0.b.day);
        boolean z7 = (i13 % 4 == 0 && i13 % 100 != 0) || i13 % 400 == 0;
        int i21 = gVar3.f8726i;
        int i22 = gVar3.f8727j;
        if (i21 == i22) {
            z6 = z7;
            if (gVar3.f8728k == gVar3.f8729l) {
                int i23 = i14 + 1;
                if (listAsList.contains(String.valueOf(i23))) {
                    if (gVar3.f8731n > 31) {
                        gVar3.f8731n = 31;
                    }
                    gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, gVar3.f8731n));
                } else if (listAsList2.contains(String.valueOf(i23))) {
                    if (gVar3.f8731n > 30) {
                        gVar3.f8731n = 30;
                    }
                    gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, gVar3.f8731n));
                } else if (z6) {
                    if (gVar3.f8731n > 29) {
                        gVar3.f8731n = 29;
                    }
                    gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, gVar3.f8731n));
                } else {
                    if (gVar3.f8731n > 28) {
                        gVar3.f8731n = 28;
                    }
                    gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, gVar3.f8731n));
                }
                gVar3.d.setCurrentItem(i15 - gVar3.f8730m);
            }
            gVar3.d.setGravity(17);
            WheelView wheelView3 = (WheelView) linearLayout2.findViewById(p086p0.b.hour);
            gVar3.e = wheelView3;
            wheelView3.setAdapter(new p091q0.a(0, 23));
            gVar3.e.setCurrentItem(i16);
            gVar3.e.setGravity(17);
            WheelView wheelView4 = (WheelView) linearLayout2.findViewById(p086p0.b.min);
            gVar3.f8723f = wheelView4;
            wheelView4.setAdapter(new p091q0.a(0, 59));
            gVar3.f8723f.setCurrentItem(i17);
            gVar3.f8723f.setGravity(17);
            WheelView wheelView5 = (WheelView) linearLayout2.findViewById(p086p0.b.second);
            gVar3.f8724g = wheelView5;
            wheelView5.setAdapter(new p091q0.a(0, 59));
            gVar3.f8724g.setCurrentItem(i18);
            gVar3.f8724g.setGravity(17);
            gVar3.b.setOnItemSelectedListener(new f(gVar3, listAsList, listAsList2, 0));
            gVar3.c.setOnItemSelectedListener(new f(gVar3, listAsList, listAsList2, 1));
            if (zArr2.length == 6) {
                throw new IllegalArgumentException("type[] length is not 6");
            }
            WheelView wheelView6 = gVar3.b;
            if (zArr2[0]) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            wheelView6.setVisibility(i8);
            WheelView wheelView7 = gVar3.c;
            if (zArr2[1]) {
                i9 = 0;
            } else {
                i9 = 8;
            }
            wheelView7.setVisibility(i9);
            WheelView wheelView8 = gVar3.d;
            if (zArr2[2]) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            wheelView8.setVisibility(i10);
            WheelView wheelView9 = gVar3.e;
            if (zArr2[3]) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            wheelView9.setVisibility(i11);
            WheelView wheelView10 = gVar3.f8723f;
            if (zArr2[4]) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            wheelView10.setVisibility(i12);
            gVar3.f8724g.setVisibility(zArr2[5] ? 0 : 8);
            float f6 = 18;
            gVar3.d.setTextSize(f6);
            gVar3.c.setTextSize(f6);
            gVar3.b.setTextSize(f6);
            gVar3.e.setTextSize(f6);
            gVar3.f8723f.setTextSize(f6);
            gVar3.f8724g.setTextSize(f6);
            g gVar4 = (g) dVar.f8718l;
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            LinearLayout linearLayout3 = gVar4.f8722a;
            gVar4.b.setLabel(linearLayout3.getContext().getString(p086p0.d.pickerview_year));
            gVar4.c.setLabel(linearLayout3.getContext().getString(p086p0.d.pickerview_month));
            gVar4.d.setLabel(linearLayout3.getContext().getString(p086p0.d.pickerview_day));
            gVar4.e.setLabel(linearLayout3.getContext().getString(p086p0.d.pickerview_hours));
            gVar4.f8723f.setLabel(linearLayout3.getContext().getString(p086p0.d.pickerview_minutes));
            gVar4.f8724g.setLabel(linearLayout3.getContext().getString(p086p0.d.pickerview_seconds));
            g gVar5 = (g) dVar.f8718l;
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            dVar.d.getClass();
            gVar5.b.setTextXOffset(0);
            gVar5.c.setTextXOffset(0);
            gVar5.d.setTextXOffset(0);
            gVar5.e.setTextXOffset(0);
            gVar5.f8723f.setTextXOffset(0);
            gVar5.f8724g.setTextXOffset(0);
            g gVar6 = (g) dVar.f8718l;
            int i24 = dVar.d.f8199t;
            gVar6.d.setItemsVisibleCount(i24);
            gVar6.c.setItemsVisibleCount(i24);
            gVar6.b.setItemsVisibleCount(i24);
            gVar6.e.setItemsVisibleCount(i24);
            gVar6.f8723f.setItemsVisibleCount(i24);
            gVar6.f8724g.setItemsVisibleCount(i24);
            g gVar7 = (g) dVar.f8718l;
            dVar.d.getClass();
            gVar7.d.setAlphaGradient(false);
            gVar7.c.setAlphaGradient(false);
            gVar7.b.setAlphaGradient(false);
            gVar7.e.setAlphaGradient(false);
            gVar7.f8723f.setAlphaGradient(false);
            gVar7.f8724g.setAlphaGradient(false);
            dVar.d.getClass();
            viewGroup = dVar.c;
            if (viewGroup != null) {
                viewGroup.findViewById(p086p0.b.outmost_container).setOnTouchListener(dVar.f8716j);
            }
            g gVar8 = (g) dVar.f8718l;
            dVar.d.getClass();
            gVar8.b.setCyclic(false);
            gVar8.c.setCyclic(false);
            gVar8.d.setCyclic(false);
            gVar8.e.setCyclic(false);
            gVar8.f8723f.setCyclic(false);
            gVar8.f8724g.setCyclic(false);
            g gVar9 = (g) dVar.f8718l;
            int i25 = dVar.d.f8195p;
            gVar9.d.setDividerColor(i25);
            gVar9.c.setDividerColor(i25);
            gVar9.b.setDividerColor(i25);
            gVar9.e.setDividerColor(i25);
            gVar9.f8723f.setDividerColor(i25);
            gVar9.f8724g.setDividerColor(i25);
            g gVar10 = (g) dVar.f8718l;
            Z0.c cVar = dVar.d.f8198s;
            gVar10.d.setDividerType(cVar);
            gVar10.c.setDividerType(cVar);
            gVar10.b.setDividerType(cVar);
            gVar10.e.setDividerType(cVar);
            gVar10.f8723f.setDividerType(cVar);
            gVar10.f8724g.setDividerType(cVar);
            g gVar11 = (g) dVar.f8718l;
            dVar.d.getClass();
            gVar11.d.setLineSpacingMultiplier(1.6f);
            gVar11.c.setLineSpacingMultiplier(1.6f);
            gVar11.b.setLineSpacingMultiplier(1.6f);
            gVar11.e.setLineSpacingMultiplier(1.6f);
            gVar11.f8723f.setLineSpacingMultiplier(1.6f);
            gVar11.f8724g.setLineSpacingMultiplier(1.6f);
            g gVar12 = (g) dVar.f8718l;
            int i26 = dVar.d.f8193n;
            gVar12.d.setTextColorOut(i26);
            gVar12.c.setTextColorOut(i26);
            gVar12.b.setTextColorOut(i26);
            gVar12.e.setTextColorOut(i26);
            gVar12.f8723f.setTextColorOut(i26);
            gVar12.f8724g.setTextColorOut(i26);
            g gVar13 = (g) dVar.f8718l;
            int i27 = dVar.d.f8194o;
            gVar13.d.setTextColorCenter(i27);
            gVar13.c.setTextColorCenter(i27);
            gVar13.b.setTextColorCenter(i27);
            gVar13.e.setTextColorCenter(i27);
            gVar13.f8723f.setTextColorCenter(i27);
            gVar13.f8724g.setTextColorCenter(i27);
            g gVar14 = (g) dVar.f8718l;
            dVar.d.getClass();
            gVar14.d.f3225g = false;
            gVar14.c.f3225g = false;
            gVar14.b.f3225g = false;
            gVar14.e.f3225g = false;
            gVar14.f8723f.f3225g = false;
            gVar14.f8724g.f3225g = false;
            return dVar;
        }
        z6 = z7;
        if (i13 == i21 && (i7 = i14 + 1) == gVar3.f8728k) {
            if (listAsList.contains(String.valueOf(i7))) {
                gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, 31));
            } else if (listAsList2.contains(String.valueOf(i7))) {
                gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, 30));
            } else {
                gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, z6 ? 29 : 28));
            }
            gVar3.d.setCurrentItem(i15 - gVar3.f8730m);
        } else if (i13 == i22 && (i5 = i14 + 1) == gVar3.f8729l) {
            if (listAsList.contains(String.valueOf(i5))) {
                if (gVar3.f8731n > 31) {
                    gVar3.f8731n = 31;
                }
                gVar3.d.setAdapter(new p091q0.a(1, gVar3.f8731n));
            } else {
                if (listAsList2.contains(String.valueOf(i5))) {
                    if (gVar3.f8731n > 30) {
                        gVar3.f8731n = 30;
                    }
                    gVar3.d.setAdapter(new p091q0.a(1, gVar3.f8731n));
                } else if (z6) {
                    if (gVar3.f8731n > 29) {
                        gVar3.f8731n = 29;
                    }
                    i6 = 1;
                    gVar3.d.setAdapter(new p091q0.a(1, gVar3.f8731n));
                } else {
                    i6 = 1;
                    if (gVar3.f8731n > 28) {
                        gVar3.f8731n = 28;
                    }
                    gVar3.d.setAdapter(new p091q0.a(1, gVar3.f8731n));
                }
                gVar3.d.setCurrentItem(i15 - i6);
            }
            i6 = 1;
            gVar3.d.setCurrentItem(i15 - i6);
        } else {
            int i28 = i14 + 1;
            if (listAsList.contains(String.valueOf(i28))) {
                gVar3.d.setAdapter(new p091q0.a(1, 31));
            } else if (listAsList2.contains(String.valueOf(i28))) {
                gVar3.d.setAdapter(new p091q0.a(1, 30));
            } else {
                gVar3.d.setAdapter(new p091q0.a(gVar3.f8730m, z6 ? 29 : 28));
            }
            gVar3.d.setCurrentItem(i15 - 1);
        }
        gVar3.d.setGravity(17);
        WheelView wheelView11 = (WheelView) linearLayout2.findViewById(p086p0.b.hour);
        gVar3.e = wheelView11;
        wheelView11.setAdapter(new p091q0.a(0, 23));
        gVar3.e.setCurrentItem(i16);
        gVar3.e.setGravity(17);
        WheelView wheelView12 = (WheelView) linearLayout2.findViewById(p086p0.b.min);
        gVar3.f8723f = wheelView12;
        wheelView12.setAdapter(new p091q0.a(0, 59));
        gVar3.f8723f.setCurrentItem(i17);
        gVar3.f8723f.setGravity(17);
        WheelView wheelView13 = (WheelView) linearLayout2.findViewById(p086p0.b.second);
        gVar3.f8724g = wheelView13;
        wheelView13.setAdapter(new p091q0.a(0, 59));
        gVar3.f8724g.setCurrentItem(i18);
        gVar3.f8724g.setGravity(17);
        gVar3.b.setOnItemSelectedListener(new f(gVar3, listAsList, listAsList2, 0));
        gVar3.c.setOnItemSelectedListener(new f(gVar3, listAsList, listAsList2, 1));
        if (zArr2.length == 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        WheelView wheelView14 = gVar3.b;
        if (zArr2[0]) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        wheelView14.setVisibility(i8);
        WheelView wheelView15 = gVar3.c;
        if (zArr2[1]) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        wheelView15.setVisibility(i9);
        WheelView wheelView16 = gVar3.d;
        if (zArr2[2]) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        wheelView16.setVisibility(i10);
        WheelView wheelView17 = gVar3.e;
        if (zArr2[3]) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        wheelView17.setVisibility(i11);
        WheelView wheelView18 = gVar3.f8723f;
        if (zArr2[4]) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        wheelView18.setVisibility(i12);
        gVar3.f8724g.setVisibility(zArr2[5] ? 0 : 8);
        float f7 = 18;
        gVar3.d.setTextSize(f7);
        gVar3.c.setTextSize(f7);
        gVar3.b.setTextSize(f7);
        gVar3.e.setTextSize(f7);
        gVar3.f8723f.setTextSize(f7);
        gVar3.f8724g.setTextSize(f7);
        g gVar15 = (g) dVar.f8718l;
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        LinearLayout linearLayout4 = gVar15.f8722a;
        gVar15.b.setLabel(linearLayout4.getContext().getString(p086p0.d.pickerview_year));
        gVar15.c.setLabel(linearLayout4.getContext().getString(p086p0.d.pickerview_month));
        gVar15.d.setLabel(linearLayout4.getContext().getString(p086p0.d.pickerview_day));
        gVar15.e.setLabel(linearLayout4.getContext().getString(p086p0.d.pickerview_hours));
        gVar15.f8723f.setLabel(linearLayout4.getContext().getString(p086p0.d.pickerview_minutes));
        gVar15.f8724g.setLabel(linearLayout4.getContext().getString(p086p0.d.pickerview_seconds));
        g gVar16 = (g) dVar.f8718l;
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        dVar.d.getClass();
        gVar16.b.setTextXOffset(0);
        gVar16.c.setTextXOffset(0);
        gVar16.d.setTextXOffset(0);
        gVar16.e.setTextXOffset(0);
        gVar16.f8723f.setTextXOffset(0);
        gVar16.f8724g.setTextXOffset(0);
        g gVar17 = (g) dVar.f8718l;
        int i29 = dVar.d.f8199t;
        gVar17.d.setItemsVisibleCount(i29);
        gVar17.c.setItemsVisibleCount(i29);
        gVar17.b.setItemsVisibleCount(i29);
        gVar17.e.setItemsVisibleCount(i29);
        gVar17.f8723f.setItemsVisibleCount(i29);
        gVar17.f8724g.setItemsVisibleCount(i29);
        g gVar18 = (g) dVar.f8718l;
        dVar.d.getClass();
        gVar18.d.setAlphaGradient(false);
        gVar18.c.setAlphaGradient(false);
        gVar18.b.setAlphaGradient(false);
        gVar18.e.setAlphaGradient(false);
        gVar18.f8723f.setAlphaGradient(false);
        gVar18.f8724g.setAlphaGradient(false);
        dVar.d.getClass();
        viewGroup = dVar.c;
        if (viewGroup != null) {
            viewGroup.findViewById(p086p0.b.outmost_container).setOnTouchListener(dVar.f8716j);
        }
        g gVar19 = (g) dVar.f8718l;
        dVar.d.getClass();
        gVar19.b.setCyclic(false);
        gVar19.c.setCyclic(false);
        gVar19.d.setCyclic(false);
        gVar19.e.setCyclic(false);
        gVar19.f8723f.setCyclic(false);
        gVar19.f8724g.setCyclic(false);
        g gVar20 = (g) dVar.f8718l;
        int i210 = dVar.d.f8195p;
        gVar20.d.setDividerColor(i210);
        gVar20.c.setDividerColor(i210);
        gVar20.b.setDividerColor(i210);
        gVar20.e.setDividerColor(i210);
        gVar20.f8723f.setDividerColor(i210);
        gVar20.f8724g.setDividerColor(i210);
        g gVar110 = (g) dVar.f8718l;
        Z0.c cVar2 = dVar.d.f8198s;
        gVar110.d.setDividerType(cVar2);
        gVar110.c.setDividerType(cVar2);
        gVar110.b.setDividerType(cVar2);
        gVar110.e.setDividerType(cVar2);
        gVar110.f8723f.setDividerType(cVar2);
        gVar110.f8724g.setDividerType(cVar2);
        g gVar111 = (g) dVar.f8718l;
        dVar.d.getClass();
        gVar111.d.setLineSpacingMultiplier(1.6f);
        gVar111.c.setLineSpacingMultiplier(1.6f);
        gVar111.b.setLineSpacingMultiplier(1.6f);
        gVar111.e.setLineSpacingMultiplier(1.6f);
        gVar111.f8723f.setLineSpacingMultiplier(1.6f);
        gVar111.f8724g.setLineSpacingMultiplier(1.6f);
        g gVar112 = (g) dVar.f8718l;
        int i211 = dVar.d.f8193n;
        gVar112.d.setTextColorOut(i211);
        gVar112.c.setTextColorOut(i211);
        gVar112.b.setTextColorOut(i211);
        gVar112.e.setTextColorOut(i211);
        gVar112.f8723f.setTextColorOut(i211);
        gVar112.f8724g.setTextColorOut(i211);
        g gVar113 = (g) dVar.f8718l;
        int i212 = dVar.d.f8194o;
        gVar113.d.setTextColorCenter(i212);
        gVar113.c.setTextColorCenter(i212);
        gVar113.b.setTextColorCenter(i212);
        gVar113.e.setTextColorCenter(i212);
        gVar113.f8723f.setTextColorCenter(i212);
        gVar113.f8724g.setTextColorCenter(i212);
        g gVar114 = (g) dVar.f8718l;
        dVar.d.getClass();
        gVar114.d.f3225g = false;
        gVar114.c.f3225g = false;
        gVar114.b.f3225g = false;
        gVar114.e.f3225g = false;
        gVar114.f8723f.f3225g = false;
        gVar114.f8724g.f3225g = false;
        return dVar;
    }

    @Deprecated
    public b setBackgroundId(int i5) {
        this.f7932a.f8196q = i5;
        return this;
    }

    public b setDividerColor(@ColorInt int i5) {
        this.f7932a.f8195p = i5;
        return this;
    }

    public b setOutSideColor(@ColorInt int i5) {
        this.f7932a.f8196q = i5;
        return this;
    }

    public b setTextColorCenter(@ColorInt int i5) {
        this.f7932a.f8194o = i5;
        return this;
    }

    public b setTextColorOut(@ColorInt int i5) {
        this.f7932a.f8193n = i5;
        return this;
    }
}
