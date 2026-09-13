package org.apache.xmlbeans.impl.soap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class SOAPFactory {
    private static final String DEFAULT_SF = "org.apache.axis.soap.SOAPFactoryImpl";
    private static final String SF_PROPERTY = "javax.xml.soap.SOAPFactory";

    public static SOAPFactory newInstance() throws SOAPException {
        try {
            return (SOAPFactory) FactoryFinder.find(SF_PROPERTY, DEFAULT_SF);
        } catch (Exception e) {
            throw new SOAPException("Unable to create SOAP Factory: " + e.getMessage());
        }
    }

    public abstract Detail createDetail();

    public abstract SOAPElement createElement(String str);

    public abstract SOAPElement createElement(String str, String str2, String str3);

    public abstract SOAPElement createElement(Name name);

    public abstract Name createName(String str);

    public abstract Name createName(String str, String str2, String str3);
}
