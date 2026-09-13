package org.apache.xmlbeans.impl.soap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SOAPEnvelope extends SOAPElement {
    SOAPBody addBody();

    SOAPHeader addHeader();

    Name createName(String str);

    Name createName(String str, String str2, String str3);

    SOAPBody getBody();

    SOAPHeader getHeader();
}
