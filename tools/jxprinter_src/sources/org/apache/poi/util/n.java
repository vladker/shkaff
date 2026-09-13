package org.apache.poi.util;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class n implements XMLHelper.SecurityFeature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7256a;
    public final /* synthetic */ Object b;

    public /* synthetic */ n(Object obj, int i5) {
        this.f7256a = i5;
        this.b = obj;
    }

    private final void a(String str, boolean z6) {
        ((XMLInputFactory) this.b).setProperty(str, Boolean.valueOf(z6));
    }

    private final void b(String str, boolean z6) {
        ((XMLOutputFactory) this.b).setProperty(str, Boolean.valueOf(z6));
    }

    @Override // org.apache.poi.util.XMLHelper.SecurityFeature
    public final void accept(String str, boolean z6) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
        switch (this.f7256a) {
            case 0:
                a(str, z6);
                break;
            case 1:
                b(str, z6);
                break;
            default:
                ((SAXParserFactory) this.b).setFeature(str, z6);
                break;
        }
    }
}
