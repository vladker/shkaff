package okhttp3;

import A3.AbstractC0157z;
import java.text.DateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: okhttp3.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1375v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6676a = new ArrayList(20);

    public final void a(String str, String str2) {
        C1376w.a(str);
        C1376w.b(str2, str);
        b(str, str2);
    }

    @IgnoreJRERequirement
    public C1375v add(String str, Instant instant) {
        if (instant == null) {
            throw new NullPointerException(AbstractC0157z.o("value for name ", str, " == null"));
        }
        a(str, ((DateFormat) p118u4.d.f8736a.get()).format(new Date(instant.toEpochMilli())));
        return this;
    }

    public final void b(String str, String str2) {
        ArrayList arrayList = this.f6676a;
        arrayList.add(str);
        arrayList.add(str2.trim());
    }

    public final void c(String str) {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f6676a;
            if (i5 >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i5))) {
                arrayList.remove(i5);
                arrayList.remove(i5);
                i5 -= 2;
            }
            i5 += 2;
        }
    }

    public final void d(String str, String str2) {
        C1376w.a(str);
        C1376w.b(str2, str);
        c(str);
        b(str, str2);
    }

    public String get(String str) {
        ArrayList arrayList = this.f6676a;
        for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase((String) arrayList.get(size))) {
                return (String) arrayList.get(size + 1);
            }
        }
        return null;
    }

    @IgnoreJRERequirement
    public C1375v set(String str, Instant instant) {
        if (instant == null) {
            throw new NullPointerException(AbstractC0157z.o("value for name ", str, " == null"));
        }
        d(str, ((DateFormat) p118u4.d.f8736a.get()).format(new Date(instant.toEpochMilli())));
        return this;
    }
}
