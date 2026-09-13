package org.apache.poi.poifs.crypt.dsig.services;

import org.apache.poi.poifs.crypt.dsig.SignatureConfig;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface TimeStampHttpClient {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface TimeStampHttpClientResponse {
        byte[] getResponseBytes();

        int getResponseCode();

        default boolean isOK() {
            return getResponseCode() == 200;
        }
    }

    TimeStampHttpClientResponse get(String str);

    void init(SignatureConfig signatureConfig);

    boolean isFollowRedirects();

    boolean isIgnoreHttpsCertificates();

    TimeStampHttpClientResponse post(String str, byte[] bArr);

    void setBasicAuthentication(String str, String str2);

    void setContentTypeIn(String str);

    void setContentTypeOut(String str);

    void setFollowRedirects(boolean z6);

    void setIgnoreHttpsCertificates(boolean z6);
}
