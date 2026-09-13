package p029e5;

import android.content.res.AssetManager;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.litepal.LitePalApplication;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p024d5.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f3951a;

    public static a a() {
        if (f3951a == null) {
            f3951a = new b();
        }
        b bVar = f3951a;
        bVar.getClass();
        try {
            a aVar = new a(1);
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(bVar.getConfigInputStream(), "UTF-8");
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                String name = xmlPullParserNewPullParser.getName();
                if (eventType == 2) {
                    if ("dbname".equals(name)) {
                        aVar.c = xmlPullParserNewPullParser.getAttributeValue("", "value");
                    } else if ("version".equals(name)) {
                        aVar.b = Integer.parseInt(xmlPullParserNewPullParser.getAttributeValue("", "value"));
                    } else if ("mapping".equals(name)) {
                        ((ArrayList) aVar.a()).add(xmlPullParserNewPullParser.getAttributeValue("", Constants.CLASS));
                    } else if ("cases".equals(name)) {
                        aVar.d = xmlPullParserNewPullParser.getAttributeValue("", "value");
                    } else if ("storage".equals(name)) {
                        aVar.e = xmlPullParserNewPullParser.getAttributeValue("", "value");
                    }
                }
            }
            return aVar;
        } catch (IOException unused) {
            throw new f("IO exception happened");
        } catch (XmlPullParserException unused2) {
            throw new f("can not parse the litepal.xml, check if it's in correct format");
        }
    }

    private InputStream getConfigInputStream() throws IOException {
        AssetManager assets = LitePalApplication.getContext().getAssets();
        String[] list = assets.list("");
        if (list != null && list.length > 0) {
            for (String str : list) {
                if ("litepal.xml".equalsIgnoreCase(str)) {
                    return assets.open(str, 3);
                }
            }
        }
        throw new f("litepal.xml file is missing. Please ensure it under assets folder.");
    }
}
