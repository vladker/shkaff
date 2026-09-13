package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class FormatRun implements Comparable<FormatRun>, GenericRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final short _character;
    short _fontIndex;

    public FormatRun(short s6, short s7) {
        this._character = s6;
        this._fontIndex = s7;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FormatRun)) {
            return false;
        }
        FormatRun formatRun = (FormatRun) obj;
        return this._character == formatRun._character && this._fontIndex == formatRun._fontIndex;
    }

    public short getCharacterPos() {
        return this._character;
    }

    public short getFontIndex() {
        return this._fontIndex;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("characterPos", new Supplier(this) { // from class: org.apache.poi.hssf.record.common.d
            public final /* synthetic */ FormatRun b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short characterPos;
                switch (i5) {
                    case 0:
                        characterPos = this.b.getCharacterPos();
                        break;
                    default:
                        characterPos = this.b.getFontIndex();
                        break;
                }
                return Short.valueOf(characterPos);
            }
        }, "fontIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.common.d
            public final /* synthetic */ FormatRun b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short characterPos;
                switch (i6) {
                    case 0:
                        characterPos = this.b.getCharacterPos();
                        break;
                    default:
                        characterPos = this.b.getFontIndex();
                        break;
                }
                return Short.valueOf(characterPos);
            }
        });
    }

    public int hashCode() {
        return 42;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._character);
        littleEndianOutput.writeShort(this._fontIndex);
    }

    public String toString() {
        return "character=" + ((int) this._character) + ",fontIndex=" + ((int) this._fontIndex);
    }

    @Override // java.lang.Comparable
    public int compareTo(FormatRun formatRun) {
        short s6 = this._character;
        short s7 = formatRun._character;
        if (s6 == s7 && this._fontIndex == formatRun._fontIndex) {
            return 0;
        }
        return s6 == s7 ? this._fontIndex - formatRun._fontIndex : s6 - s7;
    }

    public FormatRun(FormatRun formatRun) {
        this._character = formatRun._character;
        this._fontIndex = formatRun._fontIndex;
    }

    public FormatRun(LittleEndianInput littleEndianInput) {
        this(littleEndianInput.readShort(), littleEndianInput.readShort());
    }
}
