package p079o;

import androidx.collection.a;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p050j.d;
import p067m.b;
import p067m.g;
import p073n.c;
import p096r.e;
import p096r.j;

/* JADX INFO: renamed from: o.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1292v extends c implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1292v f6421a = new C1292v();

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.c
    public final Object d(b bVar, Type type, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            throw new d("parse error");
        }
        String strG = (String) obj;
        if (strG.length() == 0) {
            return null;
        }
        g gVar = new g(strG);
        try {
            if (gVar.Q(false)) {
                Calendar calendar = gVar.f6097j;
                if (type == Calendar.class) {
                    gVar.close();
                    return calendar;
                }
                Date time = calendar.getTime();
                gVar.close();
                return time;
            }
            gVar.close();
            if (strG.length() == bVar.c.length()) {
                try {
                    return bVar.e().parse(strG);
                } catch (ParseException unused) {
                }
            }
            if (strG.startsWith("/Date(") && strG.endsWith(")/")) {
                strG = a.g(2, 6, strG);
            }
            return new Date(Long.parseLong(strG));
        } catch (Throwable th) {
            gVar.close();
            throw th;
        }
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) throws IOException {
        char[] charArray;
        b0 b0Var = g6.f6325j;
        TimeZone timeZone = g6.f6332q;
        Locale locale = g6.f6333r;
        if (obj == null) {
            b0Var.n();
            return;
        }
        Date dateH = obj instanceof Date ? (Date) obj : j.h(obj);
        if (b0Var.d(c0.WriteDateUseDateFormat)) {
            if (g6.f6329n == null && g6.f6328m != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(g6.f6328m, locale);
                g6.f6329n = simpleDateFormat;
                simpleDateFormat.setTimeZone(timeZone);
            }
            SimpleDateFormat simpleDateFormat2 = g6.f6329n;
            if (simpleDateFormat2 == null) {
                simpleDateFormat2 = new SimpleDateFormat(p050j.a.e, locale);
                simpleDateFormat2.setTimeZone(timeZone);
            }
            b0Var.q(simpleDateFormat2.format(dateH));
            return;
        }
        if (b0Var.d(c0.WriteClassName) && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                b0Var.write("new Date(");
                b0Var.m(((Date) obj).getTime());
                b0Var.write(41);
                return;
            } else {
                b0Var.write(123);
                b0Var.g(p050j.a.c);
                g6.i(obj.getClass().getName());
                b0Var.i(',', "val", ((Date) obj).getTime());
                b0Var.write(125);
                return;
            }
        }
        long time = dateH.getTime();
        if (!b0Var.d(c0.UseISO8601DateFormat)) {
            b0Var.m(time);
            return;
        }
        int i6 = b0Var.d(c0.UseSingleQuotes) ? 39 : 34;
        b0Var.write(i6);
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        calendar.setTimeInMillis(time);
        int i7 = calendar.get(1);
        int i8 = calendar.get(2) + 1;
        int i9 = calendar.get(5);
        int i10 = calendar.get(11);
        int i11 = calendar.get(12);
        int i12 = calendar.get(13);
        int i13 = calendar.get(14);
        if (i13 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            e.b(charArray, i13, 23);
            e.b(charArray, i12, 19);
            e.b(charArray, i11, 16);
            e.b(charArray, i10, 13);
            e.b(charArray, i9, 10);
            e.b(charArray, i8, 7);
            e.b(charArray, i7, 4);
        } else if (i12 == 0 && i11 == 0 && i10 == 0) {
            charArray = "0000-00-00".toCharArray();
            e.b(charArray, i9, 10);
            e.b(charArray, i8, 7);
            e.b(charArray, i7, 4);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            e.b(charArray, i12, 19);
            e.b(charArray, i11, 16);
            e.b(charArray, i10, 13);
            e.b(charArray, i9, 10);
            e.b(charArray, i8, 7);
            e.b(charArray, i7, 4);
        }
        b0Var.write(charArray);
        int rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
        if (rawOffset == 0) {
            b0Var.write(90);
        } else {
            if (rawOffset > 0) {
                b0Var.write(43);
                b0Var.a(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(rawOffset)));
            } else {
                b0Var.write(45);
                b0Var.a(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(-rawOffset)));
            }
            b0Var.a(":00");
        }
        b0Var.write(i6);
    }
}
