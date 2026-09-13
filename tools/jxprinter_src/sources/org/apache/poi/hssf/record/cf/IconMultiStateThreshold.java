package org.apache.poi.hssf.record.cf;

import org.apache.poi.common.Duplicatable;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IconMultiStateThreshold extends Threshold implements Duplicatable {
    public static final byte EQUALS_EXCLUDE = 0;
    public static final byte EQUALS_INCLUDE = 1;
    private byte equals;

    public IconMultiStateThreshold() {
        this.equals = (byte) 1;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public int getDataLength() {
        return super.getDataLength() + 5;
    }

    public byte getEquals() {
        return this.equals;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public void serialize(LittleEndianOutput littleEndianOutput) {
        super.serialize(littleEndianOutput);
        littleEndianOutput.writeByte(this.equals);
        littleEndianOutput.writeInt(0);
    }

    public void setEquals(byte b) {
        this.equals = b;
    }

    public IconMultiStateThreshold(IconMultiStateThreshold iconMultiStateThreshold) {
        super(iconMultiStateThreshold);
        this.equals = iconMultiStateThreshold.equals;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold, org.apache.poi.common.Duplicatable
    public IconMultiStateThreshold copy() {
        return new IconMultiStateThreshold(this);
    }

    public IconMultiStateThreshold(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
        this.equals = littleEndianInput.readByte();
        littleEndianInput.readInt();
    }
}
