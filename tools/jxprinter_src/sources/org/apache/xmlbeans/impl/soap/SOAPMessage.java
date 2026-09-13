package org.apache.xmlbeans.impl.soap;

import java.io.OutputStream;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class SOAPMessage {
    public static final String CHARACTER_SET_ENCODING = "javax.xml.soap.character-set-encoding";
    public static final String WRITE_XML_DECLARATION = "javax.xml.soap.write-xml-declaration";

    public abstract void addAttachmentPart(AttachmentPart attachmentPart);

    public abstract int countAttachments();

    public abstract AttachmentPart createAttachmentPart();

    public AttachmentPart createAttachmentPart(Object obj, String str) {
        AttachmentPart attachmentPartCreateAttachmentPart = createAttachmentPart();
        attachmentPartCreateAttachmentPart.setContent(obj, str);
        return attachmentPartCreateAttachmentPart;
    }

    public abstract Iterator<AttachmentPart> getAttachments();

    public abstract Iterator<AttachmentPart> getAttachments(MimeHeaders mimeHeaders);

    public abstract String getContentDescription();

    public abstract MimeHeaders getMimeHeaders();

    public abstract Object getProperty(String str);

    public abstract SOAPBody getSOAPBody();

    public abstract SOAPHeader getSOAPHeader();

    public abstract SOAPPart getSOAPPart();

    public abstract void removeAllAttachments();

    public abstract void saveChanges();

    public abstract boolean saveRequired();

    public abstract void setContentDescription(String str);

    public abstract void setProperty(String str, Object obj);

    public abstract void writeTo(OutputStream outputStream);
}
