package org.apache.xmlbeans.impl.soap;

import com.google.common.net.HttpHeaders;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AttachmentPart {
    public abstract void addMimeHeader(String str, String str2);

    public abstract void clearContent();

    public abstract Iterator<MimeHeader> getAllMimeHeaders();

    public abstract Object getContent();

    public String getContentId() {
        String[] mimeHeader = getMimeHeader("Content-Id");
        if (mimeHeader == null || mimeHeader.length <= 0) {
            return null;
        }
        return mimeHeader[0];
    }

    public String getContentLocation() {
        String[] mimeHeader = getMimeHeader(HttpHeaders.CONTENT_LOCATION);
        if (mimeHeader == null || mimeHeader.length <= 0) {
            return null;
        }
        return mimeHeader[0];
    }

    public String getContentType() {
        String[] mimeHeader = getMimeHeader(HttpHeaders.CONTENT_TYPE);
        if (mimeHeader == null || mimeHeader.length <= 0) {
            return null;
        }
        return mimeHeader[0];
    }

    public abstract Iterator<MimeHeader> getMatchingMimeHeaders(String[] strArr);

    public abstract String[] getMimeHeader(String str);

    public abstract Iterator<MimeHeader> getNonMatchingMimeHeaders(String[] strArr);

    public abstract int getSize();

    public abstract void removeAllMimeHeaders();

    public abstract void removeMimeHeader(String str);

    public abstract void setContent(Object obj, String str);

    public void setContentId(String str) {
        setMimeHeader("Content-Id", str);
    }

    public void setContentLocation(String str) {
        setMimeHeader(HttpHeaders.CONTENT_LOCATION, str);
    }

    public void setContentType(String str) {
        setMimeHeader(HttpHeaders.CONTENT_TYPE, str);
    }

    public abstract void setMimeHeader(String str, String str2);
}
