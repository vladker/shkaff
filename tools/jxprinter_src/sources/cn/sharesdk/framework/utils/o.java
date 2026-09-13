package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class a extends DefaultHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HashMap<String, Object> f2236a = new HashMap<>();
        private HashMap<String, Object> b;

        public HashMap<String, Object> a() {
            return this.f2236a;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i5, int i6) {
            HashMap<String, Object> map;
            String strTrim = String.valueOf(cArr, i5, i6).trim();
            if (TextUtils.isEmpty(strTrim) || (map = this.b) == null) {
                return;
            }
            map.put("value", strTrim);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            this.b = null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (this.b != null) {
                HashMap<String, Object> map = new HashMap<>();
                this.b.put(str2, map);
                this.b = map;
            } else {
                HashMap<String, Object> map2 = new HashMap<>();
                this.b = map2;
                this.f2236a.put(str2, map2);
            }
            int length = attributes.getLength();
            for (int i5 = 0; i5 < length; i5++) {
                this.b.put(attributes.getLocalName(i5), attributes.getValue(i5));
            }
        }
    }

    public HashMap<String, Object> a(String str) throws SAXException {
        a aVar = new a();
        Xml.parse(str, aVar);
        return aVar.a();
    }
}
