package org.apache.xmlbeans.impl.soap;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SOAPFault extends SOAPBodyElement {
    Detail addDetail();

    Detail getDetail();

    String getFaultActor();

    String getFaultCode();

    Name getFaultCodeAsName();

    String getFaultString();

    Locale getFaultStringLocale();

    void setFaultActor(String str);

    void setFaultCode(String str);

    void setFaultCode(Name name);

    void setFaultString(String str);

    void setFaultString(String str, Locale locale);
}
