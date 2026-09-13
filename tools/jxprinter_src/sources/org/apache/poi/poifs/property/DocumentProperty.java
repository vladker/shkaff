package org.apache.poi.poifs.property;

import org.apache.poi.poifs.filesystem.POIFSDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DocumentProperty extends Property {
    private POIFSDocument _document;

    public DocumentProperty(String str, int i5) {
        this._document = null;
        setName(str);
        setSize(i5);
        setNodeColor((byte) 1);
        setPropertyType((byte) 2);
    }

    public POIFSDocument getDocument() {
        return this._document;
    }

    @Override // org.apache.poi.poifs.property.Property
    public boolean isDirectory() {
        return false;
    }

    public void setDocument(POIFSDocument pOIFSDocument) {
        this._document = pOIFSDocument;
    }

    @Override // org.apache.poi.poifs.property.Property
    public boolean shouldUseSmallBlocks() {
        return super.shouldUseSmallBlocks();
    }

    public void updateSize(int i5) {
        setSize(i5);
    }

    public DocumentProperty(int i5, byte[] bArr, int i6) {
        super(i5, bArr, i6);
        this._document = null;
    }

    @Override // org.apache.poi.poifs.property.Property
    public void preWrite() {
    }
}
