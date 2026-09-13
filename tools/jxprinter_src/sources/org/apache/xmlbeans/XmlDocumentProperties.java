package org.apache.xmlbeans;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class XmlDocumentProperties {
    public static final Object SOURCE_NAME = new Object();
    public static final Object ENCODING = new Object();
    public static final Object VERSION = new Object();
    public static final Object STANDALONE = new Object();
    public static final Object DOCTYPE_NAME = new Object();
    public static final Object DOCTYPE_PUBLIC_ID = new Object();
    public static final Object DOCTYPE_SYSTEM_ID = new Object();
    public static final Object MESSAGE_DIGEST = new Object();

    public abstract Object get(Object obj);

    public String getDoctypeName() {
        return (String) get(DOCTYPE_NAME);
    }

    public String getDoctypePublicId() {
        return (String) get(DOCTYPE_PUBLIC_ID);
    }

    public String getDoctypeSystemId() {
        return (String) get(DOCTYPE_SYSTEM_ID);
    }

    public String getEncoding() {
        return (String) get(ENCODING);
    }

    public byte[] getMessageDigest() {
        return (byte[]) get(MESSAGE_DIGEST);
    }

    public String getSourceName() {
        return (String) get(SOURCE_NAME);
    }

    public boolean getStandalone() {
        Object obj = get(STANDALONE);
        return obj != null && obj.toString().equalsIgnoreCase("true");
    }

    public String getVersion() {
        return (String) get(VERSION);
    }

    public abstract Object put(Object obj, Object obj2);

    public abstract Object remove(Object obj);

    public void setDoctypeName(String str) {
        put(DOCTYPE_NAME, str);
    }

    public void setDoctypePublicId(String str) {
        put(DOCTYPE_PUBLIC_ID, str);
    }

    public void setDoctypeSystemId(String str) {
        put(DOCTYPE_SYSTEM_ID, str);
    }

    public void setEncoding(String str) {
        put(ENCODING, str);
    }

    public void setMessageDigest(byte[] bArr) {
        put(MESSAGE_DIGEST, bArr);
    }

    public void setSourceName(String str) {
        put(SOURCE_NAME, str);
    }

    public void setStandalone(boolean z6) {
        put(STANDALONE, z6 ? "true" : null);
    }

    public void setVersion(String str) {
        put(VERSION, str);
    }
}
