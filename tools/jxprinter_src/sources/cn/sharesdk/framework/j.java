package cn.sharesdk.framework;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class j extends cn.sharesdk.framework.utils.f {
    private a b;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2216k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2215j = true;
    private HashMap<String, HashMap<String, String>> c = new HashMap<>();
    private ArrayList<Platform> d = new ArrayList<>();
    private HashMap<String, Integer> e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<Integer, String> f2211f = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<Integer, CustomPlatform> f2212g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HashMap<Integer, HashMap<String, Object>> f2213h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HashMap<Integer, Service> f2214i = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum a {
        INITIALIZING,
        READY
    }

    private void h() {
        InputStream inputStreamOpen;
        synchronized (this.c) {
            this.c.clear();
            try {
                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                try {
                    inputStreamOpen = MobSDK.getContext().getAssets().open("ShareSDK.xml");
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                    inputStreamOpen = null;
                }
                xmlPullParserNewPullParser.setInput(inputStreamOpen, "utf-8");
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        HashMap<String, String> map = new HashMap<>();
                        int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                        for (int i5 = 0; i5 < attributeCount; i5++) {
                            map.put(xmlPullParserNewPullParser.getAttributeName(i5), xmlPullParserNewPullParser.getAttributeValue(i5).trim());
                        }
                        this.c.put(name, map);
                    }
                }
                inputStreamOpen.close();
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    public void b(Message message) {
    }

    @Override // cn.sharesdk.framework.utils.f
    public void c() {
        this.b = a.INITIALIZING;
        SSDKLog.a();
        EventRecorder.prepare();
        h();
        super.c();
    }

    public void d(Class<? extends CustomPlatform> cls) {
        synchronized (this.f2212g) {
            if (this.f2212g.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                CustomPlatform customPlatformNewInstance = cls.newInstance();
                this.f2212g.put(Integer.valueOf(cls.hashCode()), customPlatformNewInstance);
                if (customPlatformNewInstance != null && customPlatformNewInstance.b()) {
                    this.f2211f.put(Integer.valueOf(customPlatformNewInstance.getPlatformId()), customPlatformNewInstance.getName());
                    this.e.put(customPlatformNewInstance.getName(), Integer.valueOf(customPlatformNewInstance.getPlatformId()));
                }
            } catch (Throwable th) {
                SSDKLog.b().b(th);
            }
        }
    }

    public void e(Class<? extends CustomPlatform> cls) {
        int iHashCode = cls.hashCode();
        synchronized (this.f2212g) {
            this.f2212g.remove(Integer.valueOf(iHashCode));
        }
    }

    public boolean f() {
        synchronized (this.f2213h) {
            try {
                HashMap<Integer, HashMap<String, Object>> map = this.f2213h;
                return map != null && map.size() > 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g() {
        try {
            ResHelper.clearCache(MobSDK.getContext());
        } catch (Throwable th) {
            SSDKLog.b().b(th);
        }
    }

    public boolean b() {
        return i.c();
    }

    public void b(Class<? extends Service> cls) {
        synchronized (this.f2214i) {
            try {
                int iHashCode = cls.hashCode();
                if (this.f2214i.containsKey(Integer.valueOf(iHashCode))) {
                    this.f2214i.get(Integer.valueOf(iHashCode)).onUnbind();
                    this.f2214i.remove(Integer.valueOf(iHashCode));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Activity activity) {
        i.a(activity);
    }

    public Activity a() {
        return i.b();
    }

    public boolean e() {
        return this.f2216k;
    }

    public void a(boolean z6) {
        i.a(z6);
    }

    public <T extends Service> T c(Class<T> cls) {
        T tCast;
        synchronized (this.f2214i) {
            if (this.b == a.INITIALIZING) {
                try {
                    this.f2214i.wait();
                } catch (Throwable th) {
                    SSDKLog.b().b(th);
                }
                try {
                    tCast = cls.cast(this.f2214i.get(Integer.valueOf(cls.hashCode())));
                } catch (Throwable th2) {
                    SSDKLog.b().b(th2);
                    return null;
                }
            } else {
                tCast = cls.cast(this.f2214i.get(Integer.valueOf(cls.hashCode())));
            }
            throw th;
        }
        return tCast;
    }

    @Override // cn.sharesdk.framework.utils.f
    public void a(Message message) {
        synchronized (this.f2214i) {
            synchronized (this.d) {
                try {
                    try {
                        String strCheckRecord = EventRecorder.checkRecord(ShareSDK.SDK_TAG);
                        if (!TextUtils.isEmpty(strCheckRecord)) {
                            cn.sharesdk.framework.a.a.a().a((HashMap<String, Object>) null);
                            SSDKLog.b().a("EventRecorder checkRecord result ==" + strCheckRecord);
                            g();
                        }
                        EventRecorder.clear();
                    } catch (Throwable th) {
                        SSDKLog.b().b(th);
                    }
                    this.d.clear();
                    ArrayList<Platform> arrayListA = i.a();
                    if (arrayListA != null) {
                        this.d.addAll(arrayListA);
                    }
                    ArrayList<Platform> arrayList = this.d;
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Platform platform = arrayList.get(i5);
                        i5++;
                        Platform platform2 = platform;
                        this.f2211f.put(Integer.valueOf(platform2.getPlatformId()), platform2.getName());
                        this.e.put(platform2.getName(), Integer.valueOf(platform2.getPlatformId()));
                    }
                    i.a(this.f2230a);
                    a aVar = a.READY;
                    this.b = aVar;
                    new Thread() { // from class: cn.sharesdk.framework.j.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            j.this.a((ShareSDKCallback<Boolean>) null);
                        }
                    }.start();
                    this.b = aVar;
                    this.d.notify();
                } catch (Throwable th2) {
                    try {
                        SSDKLog.b().b(th2);
                        this.b = a.READY;
                        this.d.notify();
                    } catch (Throwable th3) {
                        this.b = a.READY;
                        this.d.notify();
                        this.f2214i.notify();
                        throw th3;
                    }
                }
                this.f2214i.notify();
            }
        }
    }

    public void b(int i5) {
        NetworkHelper.readTimout = i5;
    }

    public void b(boolean z6) {
        this.f2216k = z6;
    }

    public Platform[] d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.d) {
            try {
                if (this.b == a.INITIALIZING) {
                    try {
                        this.d.wait();
                    } catch (Throwable th) {
                        SSDKLog.b().b(th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Platform> arrayList2 = this.d;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Platform platform = arrayList2.get(i5);
            i5++;
            Platform platform2 = platform;
            if (platform2 != null && platform2.b()) {
                platform2.a();
                arrayList.add(platform2);
            }
        }
        i.a((ArrayList<Platform>) arrayList);
        Iterator<Map.Entry<Integer, CustomPlatform>> it = this.f2212g.entrySet().iterator();
        while (it.hasNext()) {
            CustomPlatform value = it.next().getValue();
            if (value != null && value.b()) {
                arrayList.add(value);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int size2 = arrayList.size();
        Platform[] platformArr = new Platform[size2];
        for (int i6 = 0; i6 < size2; i6++) {
            platformArr[i6] = (Platform) arrayList.get(i6);
        }
        SSDKLog.b().c("sort list use time: %s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        return platformArr;
    }

    public int b(String str) {
        synchronized (this.d) {
            synchronized (this.f2212g) {
                if (!this.e.containsKey(str)) {
                    return 0;
                }
                return this.e.get(str).intValue();
            }
        }
    }

    public String c(int i5) {
        String str;
        synchronized (this.d) {
            synchronized (this.f2212g) {
                str = this.f2211f.get(Integer.valueOf(i5));
            }
        }
        return str;
    }

    public String b(String str, String str2) {
        synchronized (this.c) {
            try {
                HashMap<String, String> map = this.c.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Class<? extends Service> cls) {
        synchronized (this.f2214i) {
            if (this.f2214i.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                Service serviceNewInstance = cls.newInstance();
                this.f2214i.put(Integer.valueOf(cls.hashCode()), serviceNewInstance);
                serviceNewInstance.onBind();
            } catch (Throwable th) {
                SSDKLog.b().b(th);
            }
        }
    }

    public Platform a(String str) {
        Platform[] platformArrD;
        if (str == null || (platformArrD = d()) == null) {
            return null;
        }
        for (Platform platform : platformArrD) {
            if (str.equals(platform.getName())) {
                return platform;
            }
        }
        return null;
    }

    public void a(int i5) {
        NetworkHelper.connectionTimeout = i5;
    }

    public void a(int i5, Platform platform) {
        i.a(i5, platform);
    }

    public void a(String str, int i5) {
        i.a(str, i5);
    }

    public void a(String str, HashMap<String, Object> map) {
        synchronized (this.c) {
            try {
                HashMap<String, String> map2 = this.c.get(str);
                if (map2 == null) {
                    map2 = new HashMap<>();
                }
                synchronized (map2) {
                    try {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value != null) {
                                map2.put(key, String.valueOf(value));
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.c.put(str, map2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (this.d) {
            try {
                if (this.b == a.INITIALIZING) {
                    try {
                        this.d.wait();
                    } catch (Throwable th3) {
                        SSDKLog.b().b(th3);
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        ArrayList<Platform> arrayList = this.d;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Platform platform = arrayList.get(i5);
            i5++;
            Platform platform2 = platform;
            if (platform2 != null && platform2.getName().equals(str)) {
                platform2.a();
                return;
            }
        }
    }

    public void a(List<HashMap<String, Object>> list) {
        synchronized (this.c) {
            try {
                for (HashMap<String, Object> map : list) {
                    HashMap<String, String> map2 = new HashMap<>();
                    String strValueOf = null;
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (key.equals("platformName")) {
                            strValueOf = String.valueOf(entry.getValue());
                        }
                        if (value != null) {
                            map2.put(key, String.valueOf(value));
                        }
                    }
                    this.c.put(strValueOf, map2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.d) {
            try {
                if (this.b == a.INITIALIZING) {
                    try {
                        this.d.wait();
                    } catch (Throwable th2) {
                        SSDKLog.b().b(th2);
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.c) {
            this.c.put(str2, this.c.get(str));
        }
    }

    public void a(int i5, int i6) {
        synchronized (this.f2213h) {
            this.f2213h.put(Integer.valueOf(i6), this.f2213h.get(Integer.valueOf(i5)));
        }
    }

    public String a(int i5, String str) {
        synchronized (this.f2213h) {
            try {
                HashMap<String, Object> map = this.f2213h.get(Integer.valueOf(i5));
                String strValueOf = null;
                if (map == null) {
                    return null;
                }
                Object obj = map.get(str);
                if (obj != null) {
                    strValueOf = String.valueOf(obj);
                }
                return strValueOf;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        try {
            if (a.READY != this.b) {
                SSDKLog.b().a("Statistics module unopened", new Object[0]);
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                    return;
                }
                return;
            }
            DH.requester(MobSDK.getContext()).getDeviceKey().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.j.2
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        final String deviceKey = dHResponse.getDeviceKey();
                        boolean zA = false;
                        if (TextUtils.isEmpty(deviceKey)) {
                            SSDKLog.b().a("dk null", new Object[0]);
                            ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                            if (shareSDKCallback2 != null) {
                                shareSDKCallback2.onCallback(Boolean.FALSE);
                                return;
                            }
                            return;
                        }
                        final cn.sharesdk.framework.a.a aVarA = cn.sharesdk.framework.a.a.a();
                        HashMap mapA = j.this.a(aVarA, aVarA.c(), deviceKey);
                        if (mapA != null && mapA.size() > 0) {
                            zA = j.this.a((HashMap<String, Object>) mapA);
                        }
                        if (zA) {
                            k.a(new k.a() { // from class: cn.sharesdk.framework.j.2.1
                                @Override // cn.sharesdk.framework.utils.k.a
                                public void a() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    j.this.a(aVarA, (ShareSDKCallback<Boolean>) shareSDKCallback, deviceKey);
                                }
                            });
                        } else {
                            j.this.a(aVarA, (ShareSDKCallback<Boolean>) shareSDKCallback, deviceKey);
                        }
                    } catch (Throwable th) {
                        SSDKLog.b().a(th);
                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                        if (shareSDKCallback3 != null) {
                            shareSDKCallback3.onCallback(Boolean.FALSE);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cn.sharesdk.framework.a.a aVar, ShareSDKCallback<Boolean> shareSDKCallback, String str) {
        try {
            HashMap<String, Object> mapB = aVar.b(str);
            HashMap<String, Object> mapA = a(aVar, mapB, str);
            if (mapA != null && mapA.size() > 0) {
                if (a(mapA)) {
                    aVar.a(mapB);
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                return;
            }
            SSDKLog.b().a("d i n");
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        } catch (Throwable th) {
            SSDKLog.b().b(th);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(cn.sharesdk.framework.a.a aVar, HashMap<String, Object> map, String str) {
        try {
            if (map.containsKey("error")) {
                SSDKLog.b().c("ShareSDK parse sns config ==>>", new Hashon().fromHashMap(map));
                return null;
            }
            if (!map.containsKey("res")) {
                SSDKLog.b().a("ShareSDK platform config result ==>>", "SNS configuration is empty");
                return null;
            }
            String str2 = (String) map.get("res");
            if (str2 == null) {
                return null;
            }
            return aVar.a(str2, str);
        } catch (Throwable th) {
            SSDKLog.b().b(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map) {
        synchronized (this.f2213h) {
            try {
                HashMap<Integer, HashMap<String, Object>> mapA = i.a(map);
                if (mapA == null || mapA.size() <= 0) {
                    return false;
                }
                this.f2213h.clear();
                this.f2213h = mapA;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str, boolean z6, int i5, String str2, ShareSDKCallback<String> shareSDKCallback) {
        if (a.READY == this.b) {
            cn.sharesdk.framework.a.a.a().a(str, i5, z6, str2, shareSDKCallback);
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(str);
        }
    }
}
