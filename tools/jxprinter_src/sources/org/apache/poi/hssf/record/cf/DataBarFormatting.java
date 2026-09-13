package org.apache.poi.hssf.record.cf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cf.DataBarFormatting;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DataBarFormatting implements Duplicatable, GenericRecord {
    private ExtendedColor color;
    private byte options;
    private byte percentMax;
    private byte percentMin;
    private DataBarThreshold thresholdMax;
    private DataBarThreshold thresholdMin;
    private static final Logger LOG = LogManager.getLogger((Class<?>) DataBarFormatting.class);
    private static final BitField ICON_ONLY = BitFieldFactory.getInstance(1);
    private static final BitField REVERSED = BitFieldFactory.getInstance(4);

    public DataBarFormatting() {
        this.options = (byte) 2;
    }

    private boolean getOptionFlag(BitField bitField) {
        return bitField.getValue(this.options) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$0() {
        return Byte.valueOf(this.options);
    }

    private void setOptionFlag(boolean z6, BitField bitField) {
        this.options = bitField.setByteBoolean(this.options, z6);
    }

    public ExtendedColor getColor() {
        return this.color;
    }

    public int getDataLength() {
        return this.thresholdMax.getDataLength() + this.thresholdMin.getDataLength() + this.color.getDataLength() + 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: H4.e
            public final /* synthetic */ DataBarFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getColor();
                    case 2:
                        return Byte.valueOf(this.b.getPercentMin());
                    case 3:
                        return Byte.valueOf(this.b.getPercentMax());
                    case 4:
                        return this.b.getThresholdMin();
                    default:
                        return this.b.getThresholdMax();
                }
            }
        }, new BitField[]{ICON_ONLY, REVERSED}, new String[]{"ICON_ONLY", "REVERSED"});
        final int i6 = 1;
        Supplier supplier = new Supplier(this) { // from class: H4.e
            public final /* synthetic */ DataBarFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getColor();
                    case 2:
                        return Byte.valueOf(this.b.getPercentMin());
                    case 3:
                        return Byte.valueOf(this.b.getPercentMax());
                    case 4:
                        return this.b.getThresholdMin();
                    default:
                        return this.b.getThresholdMax();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier2 = new Supplier(this) { // from class: H4.e
            public final /* synthetic */ DataBarFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getColor();
                    case 2:
                        return Byte.valueOf(this.b.getPercentMin());
                    case 3:
                        return Byte.valueOf(this.b.getPercentMax());
                    case 4:
                        return this.b.getThresholdMin();
                    default:
                        return this.b.getThresholdMax();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier3 = new Supplier(this) { // from class: H4.e
            public final /* synthetic */ DataBarFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getColor();
                    case 2:
                        return Byte.valueOf(this.b.getPercentMin());
                    case 3:
                        return Byte.valueOf(this.b.getPercentMax());
                    case 4:
                        return this.b.getThresholdMin();
                    default:
                        return this.b.getThresholdMax();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier4 = new Supplier(this) { // from class: H4.e
            public final /* synthetic */ DataBarFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getColor();
                    case 2:
                        return Byte.valueOf(this.b.getPercentMin());
                    case 3:
                        return Byte.valueOf(this.b.getPercentMax());
                    case 4:
                        return this.b.getThresholdMin();
                    default:
                        return this.b.getThresholdMax();
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("options", bitsAsString, TypedValues.Custom.S_COLOR, supplier, "percentMin", supplier2, "percentMax", supplier3, "thresholdMin", supplier4, "thresholdMax", new Supplier(this) { // from class: H4.e
            public final /* synthetic */ DataBarFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getColor();
                    case 2:
                        return Byte.valueOf(this.b.getPercentMin());
                    case 3:
                        return Byte.valueOf(this.b.getPercentMax());
                    case 4:
                        return this.b.getThresholdMin();
                    default:
                        return this.b.getThresholdMax();
                }
            }
        });
    }

    public byte getPercentMax() {
        return this.percentMax;
    }

    public byte getPercentMin() {
        return this.percentMin;
    }

    public DataBarThreshold getThresholdMax() {
        return this.thresholdMax;
    }

    public DataBarThreshold getThresholdMin() {
        return this.thresholdMin;
    }

    public boolean isIconOnly() {
        return getOptionFlag(ICON_ONLY);
    }

    public boolean isReversed() {
        return getOptionFlag(REVERSED);
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeByte(0);
        littleEndianOutput.writeByte(this.options);
        littleEndianOutput.writeByte(this.percentMin);
        littleEndianOutput.writeByte(this.percentMax);
        this.color.serialize(littleEndianOutput);
        this.thresholdMin.serialize(littleEndianOutput);
        this.thresholdMax.serialize(littleEndianOutput);
    }

    public void setColor(ExtendedColor extendedColor) {
        this.color = extendedColor;
    }

    public void setIconOnly(boolean z6) {
        setOptionFlag(z6, ICON_ONLY);
    }

    public void setPercentMax(byte b) {
        this.percentMax = b;
    }

    public void setPercentMin(byte b) {
        this.percentMin = b;
    }

    public void setReversed(boolean z6) {
        setOptionFlag(z6, REVERSED);
    }

    public void setThresholdMax(DataBarThreshold dataBarThreshold) {
        this.thresholdMax = dataBarThreshold;
    }

    public void setThresholdMin(DataBarThreshold dataBarThreshold) {
        this.thresholdMin = dataBarThreshold;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public DataBarFormatting copy() {
        return new DataBarFormatting(this);
    }

    public DataBarFormatting(DataBarFormatting dataBarFormatting) {
        this.options = dataBarFormatting.options;
        this.percentMin = dataBarFormatting.percentMin;
        this.percentMax = dataBarFormatting.percentMax;
        ExtendedColor extendedColor = dataBarFormatting.color;
        this.color = extendedColor == null ? null : extendedColor.copy();
        DataBarThreshold dataBarThreshold = dataBarFormatting.thresholdMin;
        this.thresholdMin = dataBarThreshold == null ? null : dataBarThreshold.copy();
        DataBarThreshold dataBarThreshold2 = dataBarFormatting.thresholdMax;
        this.thresholdMax = dataBarThreshold2 != null ? dataBarThreshold2.copy() : null;
    }

    public DataBarFormatting(LittleEndianInput littleEndianInput) {
        littleEndianInput.readShort();
        littleEndianInput.readByte();
        this.options = littleEndianInput.readByte();
        this.percentMin = littleEndianInput.readByte();
        this.percentMax = littleEndianInput.readByte();
        byte b = this.percentMin;
        if (b < 0 || b > 100) {
            LOG.atWarn().log("Inconsistent Minimum Percentage found {}", Unbox.box(this.percentMin));
        }
        byte b6 = this.percentMax;
        if (b6 < 0 || b6 > 100) {
            LOG.atWarn().log("Inconsistent Maximum Percentage found {}", Unbox.box(this.percentMax));
        }
        this.color = new ExtendedColor(littleEndianInput);
        this.thresholdMin = new DataBarThreshold(littleEndianInput);
        this.thresholdMax = new DataBarThreshold(littleEndianInput);
    }
}
