package cn.fly.commons.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class i extends h {
    private a c;
    private BroadcastReceiver d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1364a;
        private long b;
        private String c;

        public a(String str) {
            this.f1364a = str;
        }

        public void a(long j6) {
            this.b = j6;
        }

        public void a(String str) {
            this.c = str;
        }

        public boolean a() {
            return this.b > System.currentTimeMillis();
        }
    }

    public i(Context context) {
        super(context);
        this.c = new a(cn.fly.commons.o.a("004:dk4dRdidc"));
    }

    private void e() {
        try {
            if (this.d == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(cn.fly.commons.o.a("044c%dkdfdldfLfVdigddgdlef=g*ecdf;f*dldk<jfe+didcdlfdedfceeghegdhghglgiegdheefldhedfkfdegidgi"));
                this.d = new BroadcastReceiver() { // from class: cn.fly.commons.c.i.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        String stringExtra;
                        ArrayList<String> stringArrayListExtra;
                        if (context == null || intent == null) {
                            return;
                        }
                        try {
                            boolean zContains = false;
                            if (intent.getIntExtra(cn.fly.commons.o.a("0168dk>jfe5eedcegdk>i[diefecgc=gd,ej"), 0) == 2 && (stringArrayListExtra = intent.getStringArrayListExtra(cn.fly.commons.o.a("017Ddk3jfeUeedcglBdcReh0dQej8f<fedifiNi"))) != null) {
                                zContains = stringArrayListExtra.contains(context.getPackageName());
                            }
                            if (zContains && (stringExtra = intent.getStringExtra(cn.fly.commons.o.a("0107dk*jfe(eedcfcecAjf"))) != null && stringExtra.equals(cn.fly.commons.o.a("0048dkXdQdidc"))) {
                                i.this.c.a(0L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                };
                if (DH.SyncMtd.getOSVersionIntForFly() < 33) {
                    this.f1360a.registerReceiver(this.d, intentFilter, cn.fly.commons.o.a("048c!dkdfdldfSf)digddgdlef6gJecdfGfFdldk3jfe.didcdl6jf@djdfdififididk4e6dlghglgiegdheefldhedfkfdegidgi"), null);
                } else {
                    this.f1360a.registerReceiver(this.d, intentFilter, cn.fly.commons.o.a("048c!dkdfdldf(f5digddgdlefPgUecdf%f9dldk=jfeBdidcdl2jf_djdfdififididk^e=dlghglgiegdheefldhedfkfdegidgi"), null, 4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.fly.commons.c.h
    public synchronized String d() {
        Context context = this.f1360a;
        if (context == null) {
            return null;
        }
        return a(context.getApplicationContext(), this.c, false);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x007d A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r9
  0x007d: PHI (r9v3 android.database.Cursor) = (r9v2 android.database.Cursor), (r9v5 android.database.Cursor) binds: [B:36:0x008b, B:30:0x007b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    private String a(Context context, a aVar, boolean z6) {
        Throwable th;
        Cursor cursorQuery;
        String string;
        if (aVar == null) {
            return null;
        }
        if (!z6 && aVar.a()) {
            return aVar.c;
        }
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse(cn.fly.commons.o.a("036cSdkQeifeikllc=dkdfdldf-f3digddgdlefRgWecdfUfZdldk>jfe+didcfidceh*l")), null, null, new String[]{aVar.f1364a}, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                }
                return null;
            }
            try {
                cursorQuery.moveToFirst();
                int columnIndex = cursorQuery.getColumnIndex(cn.fly.commons.o.a("005+dd;dgHdg@f"));
                if (columnIndex >= 0) {
                    string = cursorQuery.getString(columnIndex);
                    aVar.a(string);
                } else {
                    string = null;
                }
                if (!z6) {
                    int columnIndex2 = cursorQuery.getColumnIndex(cn.fly.commons.o.a("007fXeiMj3didjYfRdc"));
                    if (columnIndex2 >= 0) {
                        aVar.a(cursorQuery.getLong(columnIndex2));
                    }
                    int columnIndex3 = cursorQuery.getColumnIndex(cn.fly.commons.o.a("004c=dkdc f"));
                    if (columnIndex3 >= 0 && cursorQuery.getInt(columnIndex3) != 1000) {
                        e();
                    }
                }
                try {
                    cursorQuery.close();
                } catch (Throwable unused) {
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
                try {
                    FlyLog.getInstance().d(th);
                    return null;
                } finally {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }
}
