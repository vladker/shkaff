package p042h2;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.sandu.JxPrinter.config.MainApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f4028f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4029a;
    public MainApp b;
    public HashMap c;
    public SimpleDateFormat d;
    public String e;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        HashMap map = this.c;
        String str = this.e;
        if (th != null) {
            MainApp mainApp = this.b;
            try {
                PackageInfo packageInfo = mainApp.getPackageManager().getPackageInfo(mainApp.getPackageName(), 1);
                if (packageInfo != null) {
                    String str2 = packageInfo.versionName;
                    if (str2 == null) {
                        str2 = AbstractC1127c.NULL;
                    }
                    String str3 = packageInfo.versionCode + "";
                    map.put("versionName", str2);
                    map.put("versionCode", str3);
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(str, "an error occured when collect package info", e);
            }
            for (Field field : Build.class.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    map.put(field.getName(), field.get(null).toString());
                } catch (Exception e6) {
                    Log.e(str, "an error occured when collect crash info", e6);
                }
            }
            new a(this).start();
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry entry : map.entrySet()) {
                stringBuffer.append(((String) entry.getKey()) + "=" + ((String) entry.getValue()) + "\n");
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            stringBuffer.append(stringWriter.toString());
            try {
                String str4 = "crash-" + this.d.format(new Date()) + ProcessIdUtil.DEFAULT_PROCESSID + System.currentTimeMillis() + ".log";
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String str5 = this.b.getExternalCacheDir().getAbsolutePath() + "/crash/";
                    File file = new File(str5);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(str5 + str4);
                    fileOutputStream.write(stringBuffer.toString().getBytes());
                    fileOutputStream.close();
                }
            } catch (Exception e7) {
                Log.e(str, "an error occured while writing file...", e7);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4029a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e8) {
            Log.e(str, "error : ", e8);
        }
    }
}
