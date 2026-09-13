package p035f5;

import A3.AbstractC0157z;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import com.appdev.standard.model.LocalFileModel;
import com.bumptech.glide.h;
import com.orhanobut.hawk.Hawk;
import com.sandu.JxPrinter.config.MainApp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Y;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.litepal.LitePalApplication;
import p024d5.d;
import w5.a;
import w5.e;
import w5.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f3974a;
    public static MainApp b;
    public static a c;

    public static void a(String str, String str2) {
        List list = (List) Hawk.get(g(), new ArrayList());
        list.add(0, new LocalFileModel(str2, str, h.a(System.currentTimeMillis(), "yyyy-MM-dd")));
        Hawk.put(g(), list);
    }

    public static e b() {
        p029e5.a aVarB = p029e5.a.b();
        if (TextUtils.isEmpty(aVarB.c)) {
            p029e5.a.c();
            if (TextUtils.isEmpty(aVarB.c)) {
                throw new d("dbname is empty or not defined in litepal.xml file, or your litepal.xml file is missing.");
            }
        }
        if (!aVarB.c.endsWith(".db")) {
            aVarB.c = AbstractC0157z.s(new StringBuilder(), aVarB.c, ".db");
        }
        int i5 = aVarB.b;
        if (i5 < 1) {
            throw new d("the version of database can not be less than 1");
        }
        SharedPreferences sharedPreferences = LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0);
        if (!TextUtils.isEmpty(null)) {
            throw null;
        }
        if (i5 < sharedPreferences.getInt("litepal_version", 0)) {
            throw new d("the version in litepal.xml is earlier than the current version");
        }
        if (TextUtils.isEmpty(aVarB.d)) {
            aVarB.d = "lower";
        } else if (!aVarB.d.equals("upper") && !aVarB.d.equals("lower") && !aVarB.d.equals("keep")) {
            throw new d(AbstractC0157z.s(new StringBuilder(), aVarB.d, " is an invalid value for <cases></cases>"));
        }
        if (f3974a == null) {
            String strO = aVarB.c;
            if ("external".equalsIgnoreCase(aVarB.e)) {
                strO = LitePalApplication.getContext().getExternalFilesDir("") + "/databases/" + strO;
            } else if (!"internal".equalsIgnoreCase(aVarB.e) && !TextUtils.isEmpty(aVarB.e)) {
                String strReplace = (Environment.getExternalStorageDirectory().getPath() + PackagingURIHelper.FORWARD_SLASH_STRING + aVarB.e).replace("//", PackagingURIHelper.FORWARD_SLASH_STRING);
                File file = new File(strReplace);
                if (!file.exists()) {
                    file.mkdirs();
                }
                strO = androidx.collection.a.o(strReplace, PackagingURIHelper.FORWARD_SLASH_STRING, strO);
            }
            f3974a = new e(LitePalApplication.getContext(), strO, null, aVarB.b);
        }
        return f3974a;
    }

    public static T1.a c(double d, double d6) {
        T1.a aVar = new T1.a();
        aVar.f701a = new double[]{d, d6};
        return aVar;
    }

    public static int d(float f6) {
        return (int) ((f6 * b.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static a e() {
        if (c == null) {
            if (Y.d("MIUI")) {
                c = new e();
            } else if (Y.d("FLYME")) {
                c = new w5.d();
            } else if (Y.d("OPPO")) {
                c = new f();
            } else {
                c = new w5.b();
            }
        }
        return c;
    }

    public static SQLiteDatabase f() {
        SQLiteDatabase writableDatabase;
        synchronized (b.class) {
            writableDatabase = b().getWritableDatabase();
        }
        return writableDatabase;
    }

    public static String g() {
        StringBuilder sb = new StringBuilder("localFileDataList:");
        p032f2.a aVar = (p032f2.a) p042h2.e.f4031a.b;
        sb.append(aVar == null ? null : aVar.c);
        return sb.toString();
    }
}
