package org.apache.poi.ddf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherRGBProperty extends EscherSimpleProperty {
    public EscherRGBProperty(short s6, int i5) {
        super(s6, i5);
    }

    public byte getBlue() {
        return (byte) ((getRgbColor() >> 16) & 255);
    }

    public byte getGreen() {
        return (byte) ((getRgbColor() >> 8) & 255);
    }

    public byte getRed() {
        return (byte) (getRgbColor() & 255);
    }

    public int getRgbColor() {
        return getPropertyValue();
    }

    public EscherRGBProperty(EscherPropertyTypes escherPropertyTypes, int i5) {
        super(escherPropertyTypes.propNumber, i5);
    }
}
