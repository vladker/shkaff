package com.hjq.permissions;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import java.io.IOException;

/* JADX INFO: renamed from: com.hjq.permissions.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0554g {
    @NonNull
    private static C0548a parseActivityFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        C0548a c0548a = new C0548a();
        xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        c0548a.f3547a = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "supportsPictureInPicture", false);
        return c0548a;
    }

    @NonNull
    public static C0553f parseAndroidManifest(@NonNull Context context, int i5) throws IOException {
        C0553f c0553f = new C0553f();
        XmlResourceParser xmlResourceParserOpenXmlResourceParser = context.getAssets().openXmlResourceParser(i5, "AndroidManifest.xml");
        do {
            try {
                if (xmlResourceParserOpenXmlResourceParser.getEventType() == 2) {
                    String name = xmlResourceParserOpenXmlResourceParser.getName();
                    if (TextUtils.equals("manifest", name)) {
                        c0553f.f3551a = xmlResourceParserOpenXmlResourceParser.getAttributeValue(null, "package");
                    }
                    if (TextUtils.equals("uses-sdk", name)) {
                        c0553f.usesSdkInfo = parseUsesSdkFromXml(xmlResourceParserOpenXmlResourceParser);
                    }
                    if (TextUtils.equals("uses-permission", name) || TextUtils.equals("uses-permission-sdk-23", name) || TextUtils.equals("uses-permission-sdk-m", name)) {
                        c0553f.permissionInfoList.add(parsePermissionFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                    if (TextUtils.equals("application", name)) {
                        c0553f.applicationInfo = parseApplicationFromXml(xmlResourceParserOpenXmlResourceParser);
                    }
                    if (TextUtils.equals("activity", name) || TextUtils.equals("activity-alias", name)) {
                        c0553f.activityInfoList.add(parseActivityFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                    if (TextUtils.equals(NotificationCompat.CATEGORY_SERVICE, name)) {
                        c0553f.serviceInfoList.add(parseServerFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlResourceParserOpenXmlResourceParser != null) {
                        try {
                            xmlResourceParserOpenXmlResourceParser.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } while (xmlResourceParserOpenXmlResourceParser.next() != 1);
        xmlResourceParserOpenXmlResourceParser.close();
        return c0553f;
    }

    @NonNull
    private static C0549b parseApplicationFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        C0549b c0549b = new C0549b();
        xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        c0549b.f3548a = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "requestLegacyExternalStorage", false);
        return c0549b;
    }

    @NonNull
    private static C0550c parsePermissionFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        C0550c c0550c = new C0550c();
        c0550c.f3549a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        c0550c.b = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxSdkVersion", Integer.MAX_VALUE);
        c0550c.c = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "usesPermissionFlags", 0);
        return c0550c;
    }

    @NonNull
    private static C0551d parseServerFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        C0551d c0551d = new C0551d();
        c0551d.f3550a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        c0551d.b = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "permission");
        return c0551d;
    }

    @NonNull
    private static C0552e parseUsesSdkFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        C0552e c0552e = new C0552e();
        xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minSdkVersion", 0);
        return c0552e;
    }
}
