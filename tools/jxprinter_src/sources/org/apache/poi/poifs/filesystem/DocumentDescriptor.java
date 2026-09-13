package org.apache.poi.poifs.filesystem;

import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DocumentDescriptor {
    private int hashcode;
    private String name;
    private POIFSDocumentPath path;

    public DocumentDescriptor(POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (pOIFSDocumentPath == null) {
            throw new NullPointerException("path must not be null");
        }
        if (str == null) {
            throw new NullPointerException("name must not be null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        this.path = pOIFSDocumentPath;
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            DocumentDescriptor documentDescriptor = (DocumentDescriptor) obj;
            if (this.path.equals(documentDescriptor.path) && this.name.equals(documentDescriptor.name)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.hashcode == 0) {
            this.hashcode = this.path.hashCode() ^ this.name.hashCode();
        }
        return this.hashcode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.path.length() + 1) * 40);
        for (int i5 = 0; i5 < this.path.length(); i5++) {
            sb.append(this.path.getComponent(i5));
            sb.append(PackagingURIHelper.FORWARD_SLASH_STRING);
        }
        sb.append(this.name);
        return sb.toString();
    }
}
