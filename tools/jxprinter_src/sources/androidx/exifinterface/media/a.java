package androidx.exifinterface.media;

import android.util.Log;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.billingclient.api.G;
import com.android.billingclient.api.H;
import com.appdev.standard.page.scene.SquareLabelFragment;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static String A(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static /* synthetic */ String B(int i5) {
        switch (i5) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return AbstractC1127c.NULL;
        }
    }

    public static int a(int i5, int i6, String str) {
        return (str.hashCode() + i5) * i6;
    }

    public static int b(int i5, String str) {
        return String.valueOf(str).length() + i5;
    }

    public static H c(int i5, String str) {
        G gNewBuilder = H.newBuilder();
        gNewBuilder.setResponseCode(i5);
        gNewBuilder.setDebugMessage(str);
        return gNewBuilder.build();
    }

    public static Object d(SquareLabelFragment squareLabelFragment, int i5) {
        return squareLabelFragment.adapter.getData().get(i5);
    }

    public static String e(int i5, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i5);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String f(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static String g(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String h(String str, char c) {
        return str + c;
    }

    public static String i(String str, int i5, int i6, StringBuilder sb) {
        sb.append(i5);
        sb.append(str);
        sb.append(i6);
        return sb.toString();
    }

    public static String j(String str, int i5, StringBuilder sb) {
        sb.append(str.substring(i5));
        return sb.toString();
    }

    public static String k(String str, long j6, String str2) {
        return str + j6 + str2;
    }

    public static String l(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String m(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String n(String str, Throwable th) {
        return str + th;
    }

    public static String o(String str, ArrayList arrayList) {
        return str + arrayList;
    }

    public static String p(String str, Object[] objArr) {
        return str + objArr;
    }

    public static String q(StringBuilder sb, String str, int i5) {
        sb.append(str);
        sb.append(i5);
        return sb.toString();
    }

    public static String r(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String s(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String t(Throwable th, StringBuilder sb) {
        sb.append(th.getMessage());
        return sb.toString();
    }

    public static StringBuilder u(int i5, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i5);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static void v(int i5, String str, String str2) {
        Log.d(str2, str + i5);
    }

    public static void w(int i5, List list) {
        list.remove(list.size() - i5);
    }

    public static void x(String str) {
        ARouter.getInstance().build(str).navigation();
    }

    public static void y(StringBuilder sb, int i5, String str, int i6, String str2) {
        sb.append(i5);
        sb.append(str);
        sb.append(i6);
        sb.append(str2);
    }

    public static void z(StringBuilder sb, int i5, String str, String str2, String str3) {
        sb.append(i5);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }
}
