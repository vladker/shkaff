package cn.fly.commons.c;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;

/* JADX INFO: loaded from: classes.dex */
public class p extends h {
    private a c;
    private String d;

    public static class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1366a;
        private p b;

        public a(p pVar, int i5) {
            super(null);
            this.f1366a = i5;
            this.b = pVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z6) {
            p pVar = this.b;
            if (pVar != null) {
                pVar.a(z6, this.f1366a);
            }
        }
    }

    public p(Context context) {
        super(context);
        this.c = null;
        this.d = "100215079";
        if (!TextUtils.isEmpty(x.f1508l)) {
            this.d = x.f1508l;
        }
        FlyLog.getInstance().d("oamt vivo appid: " + this.d, new Object[0]);
    }

    private void c(int i5) {
        if (i5 == 0 && this.c == null) {
            this.c = new a(this, 0);
            this.f1360a.getContentResolver().registerContentObserver(Uri.parse(b(0)), true, this.c);
        }
    }

    @Override // cn.fly.commons.c.h
    public h.b b() {
        h.b bVar = new h.b();
        bVar.f1362a = a(0);
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x003b A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r2
  0x003b: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:22:0x004b, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public String a(int i5) {
        Cursor cursorQuery;
        String strB = b(i5);
        if (strB == null) {
            return null;
        }
        try {
            cursorQuery = this.f1360a.getContentResolver().query(Uri.parse(strB), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(cn.fly.commons.m.a("005*ffMfiFfiHh")));
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            c(i5);
                        } catch (Throwable unused2) {
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        FlyLog.getInstance().d(th);
                    } finally {
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        try {
                            c(i5);
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
            if (cursorQuery != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        return null;
    }

    private String b(int i5) {
        if (i5 == 0) {
            return cn.fly.commons.m.a("051e3fmIgkhgkmnne4fmfhfnfffkfffmfnfffhhkfnggfeinflfmfffkfe(h;fl7nDggfeWhgkKfkghfkLh>flggfe+n^ijhfgghn");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z6, int i5) {
        try {
            String strA = a(i5);
            if (i5 == 0) {
                a(strA);
            }
        } catch (Throwable unused) {
        }
    }
}
