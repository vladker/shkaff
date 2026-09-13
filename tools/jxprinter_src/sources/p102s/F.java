package p102s;

import A3.I;
import android.content.Intent;
import android.net.Uri;
import com.appdev.standard.page.MainActivity;
import com.idlefish.flutterboost.FlutterBoost;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.E;
import p051j0.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class F {
    public final void addExcelToCloud(String file) {
        E.f(file, "file");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("files", I.arrayListOf(file));
        if (getAddFileToCloudId() != null) {
            FlutterBoost.instance().sendEventToFlutter(getAddFileToCloudId(), linkedHashMap);
        }
    }

    public final void addFiletoCloud(String file) {
        E.f(file, "file");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("files", I.arrayListOf(file));
        if (getAddFileToCloudId() != null) {
            FlutterBoost.instance().sendEventToFlutter(getAddFileToCloudId(), linkedHashMap);
        }
    }

    public final String getAddFileToCloudId() {
        return G.addFileToCloudId;
    }

    public final MainActivity getMainActivity() {
        return G.mainActivity;
    }

    public final Map<Integer, String> getRequestCache() {
        return G.requestCache;
    }

    public final void init(MainActivity context) {
        E.f(context, "context");
        setMainActivity(context);
    }

    public final void onActivityResult(int i5, int i6, Intent intent) {
        if (!getRequestCache().containsKey(Integer.valueOf(i5)) || i6 != -1 || intent == null || getMainActivity() == null) {
            return;
        }
        Uri data = intent.getData();
        MainActivity mainActivity = getMainActivity();
        E.c(mainActivity);
        String strC = i.c(mainActivity, data);
        if (strC == null) {
            return;
        }
        MainActivity mainActivity2 = getMainActivity();
        E.c(mainActivity2);
        File externalCacheDir = mainActivity2.getExternalCacheDir();
        if (externalCacheDir == null) {
            MainActivity mainActivity3 = getMainActivity();
            E.c(mainActivity3);
            externalCacheDir = mainActivity3.getCacheDir();
        }
        String absolutePath = externalCacheDir.getAbsolutePath();
        String str = File.separator;
        File file = new File(absolutePath + str + "open_cache" + str + strC);
        MainActivity mainActivity4 = getMainActivity();
        E.c(mainActivity4);
        i.l(mainActivity4, data, file);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(file.getAbsolutePath());
        linkedHashMap.put("files", arrayList);
        FlutterBoost.instance().sendEventToFlutter(getRequestCache().get(Integer.valueOf(i5)), linkedHashMap);
    }

    public final void setAddFileToCloudId(String str) {
        G.addFileToCloudId = str;
    }

    public final void setMainActivity(MainActivity mainActivity) {
        G.mainActivity = mainActivity;
    }

    public final void setRequestCache(Map<Integer, String> map) {
        E.f(map, "<set-?>");
        G.requestCache = map;
    }
}
