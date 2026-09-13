package p079o;

import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.logging.log4j.util.ProcessIdUtil;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.e;

/* JADX INFO: renamed from: o.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1286o implements Q, p {
    public static final C1286o b = new C1286o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DatatypeFactory f6417a;

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Object objC = C1292v.f6421a.c(bVar, type, obj, null);
        if (objC instanceof Calendar) {
            return objC;
        }
        Date date = (Date) objC;
        if (date == null) {
            return null;
        }
        g gVar = bVar.e;
        Calendar calendar = Calendar.getInstance(gVar.f6098k, gVar.f6099l);
        calendar.setTime(date);
        return type == XMLGregorianCalendar.class ? c((GregorianCalendar) calendar) : calendar;
    }

    public final XMLGregorianCalendar c(Calendar calendar) {
        if (this.f6417a == null) {
            try {
                this.f6417a = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e);
            }
        }
        return this.f6417a.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) throws IOException {
        char[] charArray;
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.n();
            return;
        }
        Calendar gregorianCalendar = obj instanceof XMLGregorianCalendar ? ((XMLGregorianCalendar) obj).toGregorianCalendar() : (Calendar) obj;
        if (!b0Var.d(c0.UseISO8601DateFormat)) {
            g6.h(gregorianCalendar.getTime());
            return;
        }
        int i6 = b0Var.d(c0.UseSingleQuotes) ? 39 : 34;
        b0Var.write(i6);
        int i7 = gregorianCalendar.get(1);
        int i8 = gregorianCalendar.get(2) + 1;
        int i9 = gregorianCalendar.get(5);
        int i10 = gregorianCalendar.get(11);
        int i11 = gregorianCalendar.get(12);
        int i12 = gregorianCalendar.get(13);
        int i13 = gregorianCalendar.get(14);
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
        int rawOffset = gregorianCalendar.getTimeZone().getRawOffset() / 3600000;
        if (rawOffset == 0) {
            b0Var.a("Z");
        } else if (rawOffset > 0) {
            b0Var.a("+");
            b0Var.a(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(rawOffset)));
            b0Var.a(":00");
        } else {
            b0Var.a(ProcessIdUtil.DEFAULT_PROCESSID);
            b0Var.a(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(-rawOffset)));
            b0Var.a(":00");
        }
        b0Var.write(i6);
    }
}
