package org.apache.poi.hssf.record.chart;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ChartTitleFormatRecord extends StandardRecord {
    public static final short sid = 4176;
    private final CTFormat[] _formats;

    public ChartTitleFormatRecord(ChartTitleFormatRecord chartTitleFormatRecord) {
        super(chartTitleFormatRecord);
        int i5 = 1;
        this._formats = (CTFormat[]) Stream.of((Object[]) chartTitleFormatRecord._formats).map(new l(i5)).toArray(new m(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this._formats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CTFormat[] lambda$new$0(int i5) {
        return new CTFormat[i5];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._formats.length * 4) + 2;
    }

    public int getFormatCount() {
        return this._formats.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("formats", new C1387c(this, 2));
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public void modifyFormatRun(short s6, short s7) {
        int i5 = 0;
        int offset = 0;
        while (true) {
            CTFormat[] cTFormatArr = this._formats;
            if (i5 >= cTFormatArr.length) {
                return;
            }
            CTFormat cTFormat = cTFormatArr[i5];
            if (offset != 0) {
                cTFormat.setOffset(cTFormat.getOffset() + offset);
            } else if (s6 == cTFormat.getOffset()) {
                CTFormat[] cTFormatArr2 = this._formats;
                if (i5 < cTFormatArr2.length - 1) {
                    offset = s7 - (cTFormatArr2[i5 + 1].getOffset() - cTFormat.getOffset());
                }
            }
            i5++;
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._formats.length);
        for (CTFormat cTFormat : this._formats) {
            cTFormat.serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_TITLE_FORMAT;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CTFormat implements GenericRecord {
        public static final int ENCODED_SIZE = 4;
        private int _fontIndex;
        private int _offset;

        public CTFormat(CTFormat cTFormat) {
            this._offset = cTFormat._offset;
            this._fontIndex = cTFormat._fontIndex;
        }

        public int getFontIndex() {
            return this._fontIndex;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            final int i6 = 1;
            return GenericRecordUtil.getGenericProperties(TypedValues.CycleType.S_WAVE_OFFSET, new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.s
                public final /* synthetic */ ChartTitleFormatRecord.CTFormat b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int offset;
                    switch (i5) {
                        case 0:
                            offset = this.b.getOffset();
                            break;
                        default:
                            offset = this.b.getFontIndex();
                            break;
                    }
                    return Integer.valueOf(offset);
                }
            }, "fontIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.s
                public final /* synthetic */ ChartTitleFormatRecord.CTFormat b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int offset;
                    switch (i6) {
                        case 0:
                            offset = this.b.getOffset();
                            break;
                        default:
                            offset = this.b.getFontIndex();
                            break;
                    }
                    return Integer.valueOf(offset);
                }
            });
        }

        public int getOffset() {
            return this._offset;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._offset);
            littleEndianOutput.writeShort(this._fontIndex);
        }

        public void setOffset(int i5) {
            this._offset = i5;
        }

        public CTFormat(RecordInputStream recordInputStream) {
            this._offset = recordInputStream.readShort();
            this._fontIndex = recordInputStream.readShort();
        }
    }

    public ChartTitleFormatRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        this._formats = new CTFormat[uShort];
        for (int i5 = 0; i5 < uShort; i5++) {
            this._formats[i5] = new CTFormat(recordInputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ChartTitleFormatRecord copy() {
        return new ChartTitleFormatRecord(this);
    }
}
