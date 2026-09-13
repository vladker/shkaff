package org.apache.poi.hssf.record.common;

import java.util.Objects;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class PhRun {
    final int phoneticTextFirstCharacterOffset;
    final int realTextFirstCharacterOffset;
    final int realTextLength;

    public PhRun(PhRun phRun) {
        this.phoneticTextFirstCharacterOffset = phRun.phoneticTextFirstCharacterOffset;
        this.realTextFirstCharacterOffset = phRun.realTextFirstCharacterOffset;
        this.realTextLength = phRun.realTextLength;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PhRun phRun = (PhRun) obj;
            if (this.phoneticTextFirstCharacterOffset == phRun.phoneticTextFirstCharacterOffset && this.realTextFirstCharacterOffset == phRun.realTextFirstCharacterOffset && this.realTextLength == phRun.realTextLength) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.phoneticTextFirstCharacterOffset), Integer.valueOf(this.realTextFirstCharacterOffset), Integer.valueOf(this.realTextLength));
    }

    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeContinueIfRequired(6);
        continuableRecordOutput.writeShort(this.phoneticTextFirstCharacterOffset);
        continuableRecordOutput.writeShort(this.realTextFirstCharacterOffset);
        continuableRecordOutput.writeShort(this.realTextLength);
    }

    public PhRun(int i5, int i6, int i7) {
        this.phoneticTextFirstCharacterOffset = i5;
        this.realTextFirstCharacterOffset = i6;
        this.realTextLength = i7;
    }

    public PhRun(LittleEndianInput littleEndianInput) {
        this.phoneticTextFirstCharacterOffset = littleEndianInput.readUShort();
        this.realTextFirstCharacterOffset = littleEndianInput.readUShort();
        this.realTextLength = littleEndianInput.readUShort();
    }
}
