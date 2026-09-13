package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExtendedColor implements Duplicatable, GenericRecord {
    public static final int THEME_ACCENT_1 = 4;
    public static final int THEME_ACCENT_2 = 5;
    public static final int THEME_ACCENT_3 = 6;
    public static final int THEME_ACCENT_4 = 7;
    public static final int THEME_ACCENT_5 = 8;
    public static final int THEME_ACCENT_6 = 9;
    public static final int THEME_DARK_1 = 0;
    public static final int THEME_DARK_2 = 2;
    public static final int THEME_FOLLOWED_HYPERLINK = 11;
    public static final int THEME_HYPERLINK = 10;
    public static final int THEME_LIGHT_1 = 1;
    public static final int THEME_LIGHT_2 = 3;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_INDEXED = 1;
    public static final int TYPE_RGB = 2;
    public static final int TYPE_THEMED = 3;
    public static final int TYPE_UNSET = 4;
    private int colorIndex;
    private byte[] rgba;
    private int themeIndex;
    private double tint;
    private int type;

    public ExtendedColor() {
        this.type = 1;
        this.colorIndex = 0;
        this.tint = 0.0d;
    }

    public int getColorIndex() {
        return this.colorIndex;
    }

    public int getDataLength() {
        return 16;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.b
            public final /* synthetic */ ExtendedColor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getType());
                    case 1:
                        return Double.valueOf(this.b.getTint());
                    case 2:
                        return Integer.valueOf(this.b.getColorIndex());
                    case 3:
                        return this.b.getRGBA();
                    default:
                        return Integer.valueOf(this.b.getThemeIndex());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.b
            public final /* synthetic */ ExtendedColor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getType());
                    case 1:
                        return Double.valueOf(this.b.getTint());
                    case 2:
                        return Integer.valueOf(this.b.getColorIndex());
                    case 3:
                        return this.b.getRGBA();
                    default:
                        return Integer.valueOf(this.b.getThemeIndex());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.b
            public final /* synthetic */ ExtendedColor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getType());
                    case 1:
                        return Double.valueOf(this.b.getTint());
                    case 2:
                        return Integer.valueOf(this.b.getColorIndex());
                    case 3:
                        return this.b.getRGBA();
                    default:
                        return Integer.valueOf(this.b.getThemeIndex());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.b
            public final /* synthetic */ ExtendedColor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getType());
                    case 1:
                        return Double.valueOf(this.b.getTint());
                    case 2:
                        return Integer.valueOf(this.b.getColorIndex());
                    case 3:
                        return this.b.getRGBA();
                    default:
                        return Integer.valueOf(this.b.getThemeIndex());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("type", supplier, "tint", supplier2, "colorIndex", supplier3, "rgba", supplier4, "themeIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.common.b
            public final /* synthetic */ ExtendedColor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getType());
                    case 1:
                        return Double.valueOf(this.b.getTint());
                    case 2:
                        return Integer.valueOf(this.b.getColorIndex());
                    case 3:
                        return this.b.getRGBA();
                    default:
                        return Integer.valueOf(this.b.getThemeIndex());
                }
            }
        });
    }

    public byte[] getRGBA() {
        return this.rgba;
    }

    public int getThemeIndex() {
        return this.themeIndex;
    }

    public double getTint() {
        return this.tint;
    }

    public int getType() {
        return this.type;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.type);
        int i5 = this.type;
        if (i5 == 1) {
            littleEndianOutput.writeInt(this.colorIndex);
        } else if (i5 == 2) {
            littleEndianOutput.write(this.rgba);
        } else if (i5 == 3) {
            littleEndianOutput.writeInt(this.themeIndex);
        } else {
            littleEndianOutput.writeInt(0);
        }
        littleEndianOutput.writeDouble(this.tint);
    }

    public void setColorIndex(int i5) {
        this.colorIndex = i5;
    }

    public void setRGBA(byte[] bArr) {
        this.rgba = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setThemeIndex(int i5) {
        this.themeIndex = i5;
    }

    public void setTint(double d) {
        if (d < -1.0d || d > 1.0d) {
            throw new IllegalArgumentException("Tint/Shade must be between -1 and +1");
        }
        this.tint = d;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public ExtendedColor copy() {
        return new ExtendedColor(this);
    }

    public ExtendedColor(ExtendedColor extendedColor) {
        this.type = extendedColor.type;
        this.tint = extendedColor.tint;
        this.colorIndex = extendedColor.colorIndex;
        byte[] bArr = extendedColor.rgba;
        this.rgba = bArr == null ? null : (byte[]) bArr.clone();
        this.themeIndex = extendedColor.themeIndex;
    }

    public ExtendedColor(LittleEndianInput littleEndianInput) {
        int i5 = littleEndianInput.readInt();
        this.type = i5;
        if (i5 == 1) {
            this.colorIndex = littleEndianInput.readInt();
        } else if (i5 == 2) {
            byte[] bArr = new byte[4];
            this.rgba = bArr;
            littleEndianInput.readFully(bArr);
        } else if (i5 == 3) {
            this.themeIndex = littleEndianInput.readInt();
        } else {
            littleEndianInput.readInt();
        }
        this.tint = littleEndianInput.readDouble();
    }
}
