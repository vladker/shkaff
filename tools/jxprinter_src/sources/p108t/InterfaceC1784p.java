package p108t;

import O3.l;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: t.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1784p {
    public static final C1783o Companion = C1783o.f8533a;

    Object get(String str, Object obj);

    String getCachePath();

    String getLanguage();

    String getLanguageMode();

    String getSystemLanguage();

    void getWifiSsid(l lVar);

    void needBlueToothPermission(String str, l lVar);

    void needCameraPermission(String str, l lVar);

    void needPermission(List<String> list, String str, l lVar);

    void needStoragePermission(String str, l lVar);

    void selectImage(l lVar);

    void set(String str, Object obj);

    void setLanguage(String str);

    void showBottomDialog(String str, long j6, Map<String, ? extends Object> map, l lVar);

    void showDialog(String str, Map<String, ? extends Object> map, l lVar);

    void showPromptDialog(String str, String str2, l lVar);
}
