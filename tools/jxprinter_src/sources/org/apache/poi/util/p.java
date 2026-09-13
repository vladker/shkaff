package org.apache.poi.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class p implements XMLHelper.SecurityFeature, XMLHelper.SecurityProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7258a;
    public final /* synthetic */ DocumentBuilderFactory b;

    public /* synthetic */ p(DocumentBuilderFactory documentBuilderFactory, int i5) {
        this.f7258a = i5;
        this.b = documentBuilderFactory;
    }

    @Override // org.apache.poi.util.XMLHelper.SecurityProperty
    public void accept(String str, Object obj) {
        this.b.setAttribute(str, obj);
    }

    @Override // org.apache.poi.util.XMLHelper.SecurityFeature
    public void accept(String str, boolean z6) throws ParserConfigurationException {
        switch (this.f7258a) {
            case 0:
                this.b.setFeature(str, z6);
                break;
            default:
                this.b.setXIncludeAware(z6);
                break;
        }
    }
}
