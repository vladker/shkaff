package cn.sharesdk.loopshare.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static String a() {
        return "moblink.sdk.link";
    }

    private static String b(String str) {
        try {
            return Base64.encodeToString(Data.AES128Encode(a(), str), 2);
        } catch (Throwable th) {
            MobLinkLog.getInstance().d(th, MobLinkLog.FORMAT, "Encrypt failed");
            return null;
        }
    }

    public static SceneData.Res a(Intent intent) {
        if (intent.getData() == null) {
            return null;
        }
        return a(intent.getData());
    }

    public static SceneData.Res a(Uri uri) {
        String path;
        HashMap mapFromJson;
        String queryParameter = uri.getQueryParameter("params");
        Hashon hashon = new Hashon();
        if (!TextUtils.isEmpty(queryParameter)) {
            queryParameter = a(queryParameter);
        }
        HashMap mapFromJson2 = !TextUtils.isEmpty(queryParameter) ? hashon.fromJson(queryParameter) : null;
        if (mapFromJson2 == null) {
            mapFromJson2 = new HashMap();
        }
        HashMap map = (HashMap) mapFromJson2.get("params");
        if (map == null) {
            map = new HashMap();
            mapFromJson2.put("params", map);
        }
        String queryParameter2 = uri.getQueryParameter("data");
        if (!TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = new String(Base64.decode(queryParameter2.replace(Chars.SPACE, '+'), 2));
        }
        if (!TextUtils.isEmpty(queryParameter2) && (mapFromJson = hashon.fromJson(queryParameter2)) != null && mapFromJson.size() > 0) {
            a(map, mapFromJson);
        }
        SceneData.Res res = (SceneData.Res) hashon.fromJson(hashon.fromHashMap(mapFromJson2), SceneData.Res.class);
        if (res != null && ((path = res.getPath()) == null || path.length() < 1)) {
            res.setPath(c.a(uri));
        }
        return res;
    }

    public static String a(SceneData.Res res) {
        return b(new Hashon().fromObject(res));
    }

    private static String a(String str) {
        if (str != null) {
            str = str.replace(Chars.SPACE, '+');
        }
        try {
            return Data.AES128Decode(a(), Base64.decode(str, 2));
        } catch (Throwable th) {
            MobLinkLog.getInstance().d(th, MobLinkLog.FORMAT, "Decrypt failed");
            return null;
        }
    }

    private static void a(Map<String, Object> map, Map<String, Object> map2) {
        map.putAll(map2);
    }
}
