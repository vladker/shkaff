package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FontUnderline {
    SINGLE(1),
    DOUBLE(2),
    SINGLE_ACCOUNTING(3),
    DOUBLE_ACCOUNTING(4),
    NONE(5);

    private static FontUnderline[] _table = new FontUnderline[6];
    private int value;

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.FontUnderline$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline;

        static {
            int[] iArr = new int[FontUnderline.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline = iArr;
            try {
                iArr[FontUnderline.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.DOUBLE_ACCOUNTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.SINGLE_ACCOUNTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.SINGLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        for (FontUnderline fontUnderline : values()) {
            _table[fontUnderline.getValue()] = fontUnderline;
        }
    }

    FontUnderline(int i5) {
        this.value = i5;
    }

    public byte getByteValue() {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[ordinal()];
        if (i5 == 1) {
            return (byte) 2;
        }
        if (i5 == 2) {
            return (byte) 34;
        }
        if (i5 != 3) {
            return i5 != 4 ? (byte) 1 : (byte) 0;
        }
        return (byte) 33;
    }

    public int getValue() {
        return this.value;
    }

    public static FontUnderline valueOf(int i5) {
        return _table[i5];
    }

    public static FontUnderline valueOf(byte b) {
        if (b == 1) {
            return SINGLE;
        }
        if (b == 2) {
            return DOUBLE;
        }
        if (b == 33) {
            return SINGLE_ACCOUNTING;
        }
        if (b != 34) {
            return NONE;
        }
        return DOUBLE_ACCOUNTING;
    }
}
