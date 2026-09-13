package p114u0;

import android.widget.LinearLayout;
import com.contrarywind.view.WheelView;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.ProcessIdUtil;
import p091q0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final SimpleDateFormat f8721p = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f8722a;
    public WheelView b;
    public WheelView c;
    public WheelView d;
    public WheelView e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WheelView f8723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WheelView f8724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean[] f8725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8732o;

    public static void a(g gVar, int i5, int i6, int i7, int i8, List list, List list2) {
        int currentItem = gVar.d.getCurrentItem();
        if (list.contains(String.valueOf(i6))) {
            if (i8 > 31) {
                i8 = 31;
            }
            gVar.d.setAdapter(new a(i7, i8));
        } else if (list2.contains(String.valueOf(i6))) {
            if (i8 > 30) {
                i8 = 30;
            }
            gVar.d.setAdapter(new a(i7, i8));
        } else if ((i5 % 4 != 0 || i5 % 100 == 0) && i5 % 400 != 0) {
            if (i8 > 28) {
                i8 = 28;
            }
            gVar.d.setAdapter(new a(i7, i8));
        } else {
            if (i8 > 29) {
                i8 = 29;
            }
            gVar.d.setAdapter(new a(i7, i8));
        }
        if (currentItem > gVar.d.getAdapter().h() - 1) {
            gVar.d.setCurrentItem(gVar.d.getAdapter().h() - 1);
        }
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        if (this.f8732o == this.f8726i) {
            int currentItem = this.c.getCurrentItem();
            int i5 = this.f8728k;
            if (currentItem + i5 == i5) {
                sb.append(this.b.getCurrentItem() + this.f8726i);
                sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                sb.append(this.c.getCurrentItem() + this.f8728k);
                sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                sb.append(this.d.getCurrentItem() + this.f8730m);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                sb.append(this.f8723f.getCurrentItem());
                sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                sb.append(this.f8724g.getCurrentItem());
            } else {
                sb.append(this.b.getCurrentItem() + this.f8726i);
                sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                sb.append(this.c.getCurrentItem() + this.f8728k);
                sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                sb.append(this.d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.e.getCurrentItem());
                sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                sb.append(this.f8723f.getCurrentItem());
                sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                sb.append(this.f8724g.getCurrentItem());
            }
        } else {
            sb.append(this.b.getCurrentItem() + this.f8726i);
            sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
            sb.append(this.c.getCurrentItem() + 1);
            sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
            sb.append(this.d.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.e.getCurrentItem());
            sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            sb.append(this.f8723f.getCurrentItem());
            sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            sb.append(this.f8724g.getCurrentItem());
        }
        return sb.toString();
    }
}
