package cn.sharesdk.framework.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import cn.sharesdk.framework.utils.SSDKLog;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static synchronized long a(String str, long j6) {
        if (str != null) {
            if (str.trim() != "") {
                b bVarA = b.a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("post_time", Long.valueOf(j6));
                contentValues.put("message_data", str.toString());
                return bVarA.a(Constants.MESSAGE, contentValues);
            }
        }
        return -1L;
    }

    public static synchronized long a(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return 0L;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                sb.append("'");
                sb.append(arrayList.get(i5));
                sb.append("'");
                sb.append(",");
            }
            String strSubstring = sb.toString().substring(0, sb.length() - 1);
            int iA = b.a().a(Constants.MESSAGE, "_id in ( " + strSubstring + " )", null);
            SSDKLog.b().c("delete COUNT == %s", Integer.valueOf(iA));
            return iA;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized ArrayList<c> a(String str, String[] strArr) {
        ArrayList<c> arrayList;
        try {
            arrayList = new ArrayList<>();
            c cVar = new c();
            StringBuilder sb = new StringBuilder();
            Cursor cursorA = b.a().a(Constants.MESSAGE, new String[]{"_id", "post_time", "message_data"}, str, strArr, null);
            while (cursorA != null && cursorA.moveToNext()) {
                cVar.b.add(cursorA.getString(0));
                if (cVar.b.size() == 100) {
                    sb.append(cursorA.getString(2));
                    cVar.f2130a = sb.toString();
                    arrayList.add(cVar);
                    cVar = new c();
                    sb = new StringBuilder();
                } else {
                    sb.append(cursorA.getString(2) + "\n");
                }
            }
            cursorA.close();
            if (cVar.b.size() != 0) {
                cVar.f2130a = sb.toString().substring(0, sb.length() - 1);
                arrayList.add(cVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public static synchronized ArrayList<c> a() {
        if (b.a().a(Constants.MESSAGE) > 0) {
            return a((String) null, (String[]) null);
        }
        return new ArrayList<>();
    }
}
