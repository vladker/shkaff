package org.apache.poi.hssf.record.cf;

import H4.d;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ColorGradientThreshold extends Threshold implements Duplicatable, GenericRecord {
    private double position;

    public ColorGradientThreshold() {
        this.position = 0.0d;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public int getDataLength() {
        return super.getDataLength() + 8;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("position", new d(this, 0));
    }

    public double getPosition() {
        return this.position;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold
    public void serialize(LittleEndianOutput littleEndianOutput) {
        super.serialize(littleEndianOutput);
        littleEndianOutput.writeDouble(this.position);
    }

    public void setPosition(double d) {
        this.position = d;
    }

    public ColorGradientThreshold(ColorGradientThreshold colorGradientThreshold) {
        super(colorGradientThreshold);
        this.position = colorGradientThreshold.position;
    }

    @Override // org.apache.poi.hssf.record.cf.Threshold, org.apache.poi.common.Duplicatable
    public ColorGradientThreshold copy() {
        return new ColorGradientThreshold(this);
    }

    public ColorGradientThreshold(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
        this.position = littleEndianInput.readDouble();
    }
}
