package p073n;

import androidx.collection.a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import p050j.d;
import p067m.b;
import p067m.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends c {
    public static final s b;
    public static final s c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6211a;

    static {
        s sVar = new s();
        sVar.f6211a = false;
        b = sVar;
        s sVar2 = new s();
        sVar2.f6211a = true;
        c = sVar2;
    }

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.c
    public final Object d(b bVar, Type type, Object obj) {
        long timeInMillis;
        long timeInMillis2;
        if (this.f6211a) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Date) {
                return new Timestamp(((Date) obj).getTime());
            }
            if (obj instanceof Number) {
                return new Timestamp(((Number) obj).longValue());
            }
            if (!(obj instanceof String)) {
                throw new d("parse error");
            }
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            g gVar = new g(str);
            try {
                if (gVar.Q(true)) {
                    timeInMillis2 = gVar.f6097j.getTimeInMillis();
                } else {
                    try {
                        Timestamp timestamp = new Timestamp(bVar.e().parse(str).getTime());
                        gVar.close();
                        return timestamp;
                    } catch (ParseException unused) {
                        timeInMillis2 = Long.parseLong(str);
                    }
                }
                gVar.close();
                return new Timestamp(timeInMillis2);
            } catch (Throwable th) {
                gVar.close();
                throw th;
            }
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Number) {
            return new java.sql.Date(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            throw new d(a.l(obj, "parse error : "));
        }
        String str2 = (String) obj;
        if (str2.length() == 0) {
            return null;
        }
        g gVar2 = new g(str2);
        try {
            if (gVar2.Q(true)) {
                timeInMillis = gVar2.f6097j.getTimeInMillis();
            } else {
                try {
                    java.sql.Date date = new java.sql.Date(bVar.e().parse(str2).getTime());
                    gVar2.close();
                    return date;
                } catch (ParseException unused2) {
                    timeInMillis = Long.parseLong(str2);
                }
            }
            gVar2.close();
            return new java.sql.Date(timeInMillis);
        } catch (Throwable th2) {
            gVar2.close();
            throw th2;
        }
    }
}
