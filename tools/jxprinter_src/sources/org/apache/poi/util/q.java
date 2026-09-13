package org.apache.poi.util;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class q implements XMLHelper.SecurityFeature, XMLHelper.SecurityProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransformerFactory f7259a;

    public /* synthetic */ q(TransformerFactory transformerFactory) {
        this.f7259a = transformerFactory;
    }

    @Override // org.apache.poi.util.XMLHelper.SecurityProperty
    public void accept(String str, Object obj) {
        this.f7259a.setAttribute(str, obj);
    }

    @Override // org.apache.poi.util.XMLHelper.SecurityFeature
    public void accept(String str, boolean z6) throws TransformerConfigurationException {
        this.f7259a.setFeature(str, z6);
    }
}
