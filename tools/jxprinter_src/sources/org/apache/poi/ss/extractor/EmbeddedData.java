package org.apache.poi.ss.extractor;

import org.apache.poi.ss.usermodel.Shape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EmbeddedData {
    private String contentType = "binary/octet-stream";
    private byte[] embeddedData;
    private String filename;
    private Shape shape;

    public EmbeddedData(String str, byte[] bArr, String str2) {
        setFilename(str);
        setEmbeddedData(bArr);
        setContentType(str2);
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte[] getEmbeddedData() {
        return this.embeddedData;
    }

    public String getFilename() {
        return this.filename;
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setEmbeddedData(byte[] bArr) {
        this.embeddedData = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setFilename(String str) {
        if (str == null) {
            this.filename = "unknown.bin";
        } else {
            this.filename = str.replaceAll("[^/\\\\]*[/\\\\]", "").trim();
        }
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
