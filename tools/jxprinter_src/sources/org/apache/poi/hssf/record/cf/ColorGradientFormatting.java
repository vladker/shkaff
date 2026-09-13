package org.apache.poi.hssf.record.cf;

import E4.b;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ColorGradientFormatting implements Duplicatable, GenericRecord {
    private ExtendedColor[] colors;
    private final byte options;
    private ColorGradientThreshold[] thresholds;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) ColorGradientFormatting.class);
    private static final BitField clamp = BitFieldFactory.getInstance(1);
    private static final BitField background = BitFieldFactory.getInstance(2);

    public ColorGradientFormatting() {
        this.options = (byte) 3;
        this.thresholds = new ColorGradientThreshold[3];
        this.colors = new ExtendedColor[3];
    }

    private boolean getOptionFlag(BitField bitField) {
        return bitField.isSet(this.options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ColorGradientThreshold[] lambda$new$0(int i5) {
        return new ColorGradientThreshold[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ExtendedColor[] lambda$new$1(int i5) {
        return new ExtendedColor[i5];
    }

    private void updateThresholdPositions() {
        double length = 1.0d / ((double) (this.thresholds.length - 1));
        int i5 = 0;
        while (true) {
            ColorGradientThreshold[] colorGradientThresholdArr = this.thresholds;
            if (i5 >= colorGradientThresholdArr.length) {
                return;
            }
            colorGradientThresholdArr[i5].setPosition(((double) i5) * length);
            i5++;
        }
    }

    public ExtendedColor[] getColors() {
        return this.colors;
    }

    public int getDataLength() {
        int dataLength = 6;
        for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
            dataLength += colorGradientThreshold.getDataLength();
        }
        for (ExtendedColor extendedColor : this.colors) {
            dataLength = extendedColor.getDataLength() + dataLength + 8;
        }
        return dataLength;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: H4.c
            public final /* synthetic */ ColorGradientFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Boolean.valueOf(this.b.isClampToCurve());
                    case 1:
                        return Boolean.valueOf(this.b.isAppliesToBackground());
                    case 2:
                        return this.b.getThresholds();
                    default:
                        return this.b.getColors();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: H4.c
            public final /* synthetic */ ColorGradientFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Boolean.valueOf(this.b.isClampToCurve());
                    case 1:
                        return Boolean.valueOf(this.b.isAppliesToBackground());
                    case 2:
                        return this.b.getThresholds();
                    default:
                        return this.b.getColors();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: H4.c
            public final /* synthetic */ ColorGradientFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Boolean.valueOf(this.b.isClampToCurve());
                    case 1:
                        return Boolean.valueOf(this.b.isAppliesToBackground());
                    case 2:
                        return this.b.getThresholds();
                    default:
                        return this.b.getColors();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("clampToCurve", supplier, "background", supplier2, "thresholds", supplier3, "colors", new Supplier(this) { // from class: H4.c
            public final /* synthetic */ ColorGradientFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Boolean.valueOf(this.b.isClampToCurve());
                    case 1:
                        return Boolean.valueOf(this.b.isAppliesToBackground());
                    case 2:
                        return this.b.getThresholds();
                    default:
                        return this.b.getColors();
                }
            }
        });
    }

    public int getNumControlPoints() {
        return this.thresholds.length;
    }

    public ColorGradientThreshold[] getThresholds() {
        return this.thresholds;
    }

    public boolean isAppliesToBackground() {
        return getOptionFlag(background);
    }

    public boolean isClampToCurve() {
        return getOptionFlag(clamp);
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeByte(0);
        littleEndianOutput.writeByte(this.thresholds.length);
        littleEndianOutput.writeByte(this.thresholds.length);
        littleEndianOutput.writeByte(this.options);
        for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
            colorGradientThreshold.serialize(littleEndianOutput);
        }
        double length = 1.0d / ((double) (this.colors.length - 1));
        for (int i5 = 0; i5 < this.colors.length; i5++) {
            littleEndianOutput.writeDouble(((double) i5) * length);
            this.colors[i5].serialize(littleEndianOutput);
        }
    }

    public void setColors(ExtendedColor[] extendedColorArr) {
        this.colors = extendedColorArr == null ? null : (ExtendedColor[]) extendedColorArr.clone();
    }

    public void setNumControlPoints(int i5) {
        ColorGradientThreshold[] colorGradientThresholdArr = this.thresholds;
        if (i5 != colorGradientThresholdArr.length) {
            ColorGradientThreshold[] colorGradientThresholdArr2 = new ColorGradientThreshold[i5];
            ExtendedColor[] extendedColorArr = new ExtendedColor[i5];
            int iMin = Math.min(colorGradientThresholdArr.length, i5);
            System.arraycopy(this.thresholds, 0, colorGradientThresholdArr2, 0, iMin);
            System.arraycopy(this.colors, 0, extendedColorArr, 0, iMin);
            this.thresholds = colorGradientThresholdArr2;
            this.colors = extendedColorArr;
            updateThresholdPositions();
        }
    }

    public void setThresholds(ColorGradientThreshold[] colorGradientThresholdArr) {
        this.thresholds = colorGradientThresholdArr == null ? null : (ColorGradientThreshold[]) colorGradientThresholdArr.clone();
        updateThresholdPositions();
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public ColorGradientFormatting copy() {
        return new ColorGradientFormatting(this);
    }

    public ColorGradientFormatting(ColorGradientFormatting colorGradientFormatting) {
        this.options = colorGradientFormatting.options;
        ColorGradientThreshold[] colorGradientThresholdArr = colorGradientFormatting.thresholds;
        if (colorGradientThresholdArr != null) {
            this.thresholds = (ColorGradientThreshold[]) Stream.of((Object[]) colorGradientThresholdArr).map(new b(2)).toArray(new H4.b(0));
        }
        ExtendedColor[] extendedColorArr = colorGradientFormatting.colors;
        if (extendedColorArr != null) {
            this.colors = (ExtendedColor[]) Stream.of((Object[]) extendedColorArr).map(new b(3)).toArray(new H4.b(1));
        }
    }

    public ColorGradientFormatting(LittleEndianInput littleEndianInput) {
        littleEndianInput.readShort();
        littleEndianInput.readByte();
        int i5 = littleEndianInput.readByte();
        int i6 = littleEndianInput.readByte();
        if (i5 != i6) {
            LOGGER.atWarn().log("Inconsistent Color Gradient definition, found {} vs {} entries", Unbox.box(i5), Unbox.box(i6));
        }
        this.options = littleEndianInput.readByte();
        this.thresholds = new ColorGradientThreshold[i5];
        int i7 = 0;
        while (true) {
            ColorGradientThreshold[] colorGradientThresholdArr = this.thresholds;
            if (i7 >= colorGradientThresholdArr.length) {
                break;
            }
            colorGradientThresholdArr[i7] = new ColorGradientThreshold(littleEndianInput);
            i7++;
        }
        this.colors = new ExtendedColor[i6];
        for (int i8 = 0; i8 < this.colors.length; i8++) {
            littleEndianInput.readDouble();
            this.colors[i8] = new ExtendedColor(littleEndianInput);
        }
    }
}
