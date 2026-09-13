package org.apache.poi.hssf.record;

import androidx.core.view.MotionEventCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PaletteRecord extends StandardRecord {
    private static final int[] DEFAULT_COLORS = {0, 16777215, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, 16776960, 16711935, 65535, 8388608, 32768, 128, 8421376, 8388736, 32896, 12632256, 8421504, 10066431, 10040166, 16777164, 13434879, 6684774, 16744576, 26316, 13421823, 128, 16711935, 16776960, 65535, 8388736, 8388608, 32896, 255, 52479, 13434879, 13434828, 16777113, 10079487, 16751052, 13408767, 16764057, 3368703, 3394764, 10079232, 16763904, 16750848, 16737792, 6710937, 9868950, 13158, 3381606, 13056, 3355392, 10040064, 10040166, 3355545, 3355443};
    public static final short FIRST_COLOR_INDEX = 8;
    public static final byte STANDARD_PALETTE_SIZE = 56;
    public static final short sid = 146;
    private final ArrayList<PColor> _colors;

    public PaletteRecord() {
        ArrayList<PColor> arrayList = new ArrayList<>(100);
        this._colors = arrayList;
        Arrays.stream(DEFAULT_COLORS).mapToObj(new C1434x0(0)).forEach(new H(arrayList, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this._colors;
    }

    public byte[] getColor(int i5) {
        int i6 = i5 - 8;
        if (i6 < 0 || i6 >= this._colors.size()) {
            return null;
        }
        return this._colors.get(i6).getTriplet();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._colors.size() * 4) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("colors", new C1381b(this, 29));
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 146;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._colors.size());
        ArrayList<PColor> arrayList = this._colors;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            PColor pColor = arrayList.get(i5);
            i5++;
            pColor.serialize(littleEndianOutput);
        }
    }

    public void setColor(short s6, byte b, byte b6, byte b7) {
        int i5 = s6 - 8;
        if (i5 < 0 || i5 >= 56) {
            return;
        }
        while (this._colors.size() <= i5) {
            this._colors.add(new PColor(0, 0, 0));
        }
        this._colors.set(i5, new PColor(b, b6, b7));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PALETTE;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PColor implements GenericRecord {
        public static final short ENCODED_SIZE = 4;
        private final int _blue;
        private final int _green;
        private final int _red;

        public PColor(int i5) {
            this._red = (i5 >>> 16) & 255;
            this._green = (i5 >>> 8) & 255;
            this._blue = i5 & 255;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$0() {
            return Integer.valueOf(this._red & 255);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$1() {
            return Integer.valueOf(this._green & 255);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$2() {
            return Integer.valueOf(this._blue & 255);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.y0
                public final /* synthetic */ PaletteRecord.PColor b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i5) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        default:
                            return this.b.lambda$getGenericProperties$2();
                    }
                }
            };
            final int i6 = 1;
            Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.y0
                public final /* synthetic */ PaletteRecord.PColor b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i6) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        default:
                            return this.b.lambda$getGenericProperties$2();
                    }
                }
            };
            final int i7 = 2;
            return GenericRecordUtil.getGenericProperties("red", supplier, "green", supplier2, "blue", new Supplier(this) { // from class: org.apache.poi.hssf.record.y0
                public final /* synthetic */ PaletteRecord.PColor b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i7) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        default:
                            return this.b.lambda$getGenericProperties$2();
                    }
                }
            });
        }

        public byte[] getTriplet() {
            return new byte[]{(byte) this._red, (byte) this._green, (byte) this._blue};
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeByte(this._red);
            littleEndianOutput.writeByte(this._green);
            littleEndianOutput.writeByte(this._blue);
            littleEndianOutput.writeByte(0);
        }

        public PColor(int i5, int i6, int i7) {
            this._red = i5;
            this._green = i6;
            this._blue = i7;
        }

        public PColor(PColor pColor) {
            this._red = pColor._red;
            this._green = pColor._green;
            this._blue = pColor._blue;
        }

        public PColor(RecordInputStream recordInputStream) {
            this._red = recordInputStream.readByte();
            this._green = recordInputStream.readByte();
            this._blue = recordInputStream.readByte();
            recordInputStream.readByte();
        }
    }

    public PaletteRecord(PaletteRecord paletteRecord) {
        super(paletteRecord);
        ArrayList<PColor> arrayList = new ArrayList<>(100);
        this._colors = arrayList;
        arrayList.ensureCapacity(paletteRecord._colors.size());
        paletteRecord._colors.stream().map(new G(1)).forEach(new H(arrayList, 1));
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public PaletteRecord copy() {
        return new PaletteRecord(this);
    }

    public PaletteRecord(RecordInputStream recordInputStream) {
        ArrayList<PColor> arrayList = new ArrayList<>(100);
        this._colors = arrayList;
        short s6 = recordInputStream.readShort();
        arrayList.ensureCapacity(s6);
        for (int i5 = 0; i5 < s6; i5++) {
            this._colors.add(new PColor(recordInputStream));
        }
    }
}
