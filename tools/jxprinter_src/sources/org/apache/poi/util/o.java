package org.apache.poi.util;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class o implements XMLHelper.SecurityFeature, XMLHelper.SecurityProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMLReader f7257a;

    public /* synthetic */ o(XMLReader xMLReader) {
        this.f7257a = xMLReader;
    }

    @Override // org.apache.poi.util.XMLHelper.SecurityProperty
    public void accept(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.f7257a.setProperty(str, obj);
    }

    @Override // org.apache.poi.util.XMLHelper.SecurityFeature
    public void accept(String str, boolean z6) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.f7257a.setFeature(str, z6);
    }
}
