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
import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IconMultiStateFormatting implements Duplicatable, GenericRecord {
    private org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet;
    private byte options;
    private Threshold[] thresholds;
    private static final Logger LOG = LogManager.getLogger((Class<?>) IconMultiStateFormatting.class);
    private static BitField ICON_ONLY = BitFieldFactory.getInstance(1);
    private static BitField REVERSED = BitFieldFactory.getInstance(4);

    public IconMultiStateFormatting() {
        org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.GYR_3_TRAFFIC_LIGHTS;
        this.iconSet = iconSet;
        this.options = (byte) 0;
        this.thresholds = new Threshold[iconSet.num];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Threshold[] lambda$new$0(int i5) {
        return new Threshold[i5];
    }

    public int getDataLength() {
        int dataLength = 6;
        for (Threshold threshold : this.thresholds) {
            dataLength += threshold.getDataLength();
        }
        return dataLength;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: H4.g
            public final /* synthetic */ IconMultiStateFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getIconSet();
                    case 1:
                        return Boolean.valueOf(this.b.isIconOnly());
                    case 2:
                        return Boolean.valueOf(this.b.isReversed());
                    default:
                        return this.b.getThresholds();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: H4.g
            public final /* synthetic */ IconMultiStateFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getIconSet();
                    case 1:
                        return Boolean.valueOf(this.b.isIconOnly());
                    case 2:
                        return Boolean.valueOf(this.b.isReversed());
                    default:
                        return this.b.getThresholds();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: H4.g
            public final /* synthetic */ IconMultiStateFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.getIconSet();
                    case 1:
                        return Boolean.valueOf(this.b.isIconOnly());
                    case 2:
                        return Boolean.valueOf(this.b.isReversed());
                    default:
                        return this.b.getThresholds();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("iconSet", supplier, "iconOnly", supplier2, "reversed", supplier3, "thresholds", new Supplier(this) { // from class: H4.g
            public final /* synthetic */ IconMultiStateFormatting b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.getIconSet();
                    case 1:
                        return Boolean.valueOf(this.b.isIconOnly());
                    case 2:
                        return Boolean.valueOf(this.b.isReversed());
                    default:
                        return this.b.getThresholds();
                }
            }
        });
    }

    public org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet getIconSet() {
        return this.iconSet;
    }

    public Threshold[] getThresholds() {
        return this.thresholds;
    }

    public boolean isIconOnly() {
        return ICON_ONLY.isSet(this.options);
    }

    public boolean isReversed() {
        return REVERSED.isSet(this.options);
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeByte(0);
        littleEndianOutput.writeByte(this.iconSet.num);
        littleEndianOutput.writeByte(this.iconSet.id);
        littleEndianOutput.writeByte(this.options);
        for (Threshold threshold : this.thresholds) {
            threshold.serialize(littleEndianOutput);
        }
    }

    public void setIconOnly(boolean z6) {
        this.options = ICON_ONLY.setByteBoolean(this.options, z6);
    }

    public void setIconSet(org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet) {
        this.iconSet = iconSet;
    }

    public void setReversed(boolean z6) {
        this.options = REVERSED.setByteBoolean(this.options, z6);
    }

    public void setThresholds(Threshold[] thresholdArr) {
        this.thresholds = thresholdArr == null ? null : (Threshold[]) thresholdArr.clone();
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public IconMultiStateFormatting copy() {
        return new IconMultiStateFormatting(this);
    }

    public IconMultiStateFormatting(IconMultiStateFormatting iconMultiStateFormatting) {
        this.iconSet = iconMultiStateFormatting.iconSet;
        this.options = iconMultiStateFormatting.options;
        Threshold[] thresholdArr = iconMultiStateFormatting.thresholds;
        if (thresholdArr != null) {
            this.thresholds = (Threshold[]) Stream.of((Object[]) thresholdArr).map(new b(4)).toArray(new H4.b(2));
        }
    }

    public IconMultiStateFormatting(LittleEndianInput littleEndianInput) {
        littleEndianInput.readShort();
        littleEndianInput.readByte();
        byte b = littleEndianInput.readByte();
        org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSetById = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.byId(littleEndianInput.readByte());
        this.iconSet = iconSetById;
        if (iconSetById.num != b) {
            LOG.atWarn().log("Inconsistent Icon Set definition, found {} but defined as {} entries", this.iconSet, Unbox.box((int) b));
        }
        this.options = littleEndianInput.readByte();
        this.thresholds = new Threshold[this.iconSet.num];
        int i5 = 0;
        while (true) {
            Threshold[] thresholdArr = this.thresholds;
            if (i5 >= thresholdArr.length) {
                return;
            }
            thresholdArr[i5] = new IconMultiStateThreshold(littleEndianInput);
            i5++;
        }
    }
}
