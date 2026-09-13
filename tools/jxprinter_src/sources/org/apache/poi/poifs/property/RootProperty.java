package org.apache.poi.poifs.property;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RootProperty extends DirectoryProperty {
    private static final String NAME = "Root Entry";

    public RootProperty() {
        super(NAME);
        setNodeColor((byte) 1);
        setPropertyType((byte) 5);
        setStartBlock(-2);
    }

    @Override // org.apache.poi.poifs.property.Property
    public String getName() {
        return NAME;
    }

    @Override // org.apache.poi.poifs.property.Property
    public void setSize(int i5) {
        super.setSize(Math.multiplyExact(i5, 64));
    }

    public RootProperty(int i5, byte[] bArr, int i6) {
        super(i5, bArr, i6);
    }
}
