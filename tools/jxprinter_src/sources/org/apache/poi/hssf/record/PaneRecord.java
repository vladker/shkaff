package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PaneRecord extends StandardRecord {
    public static final short ACTIVE_PANE_LOWER_LEFT = 2;
    public static final short ACTIVE_PANE_LOWER_RIGHT = 0;
    public static final short ACTIVE_PANE_UPPER_LEFT = 3;
    public static final short ACTIVE_PANE_UPPER_RIGHT = 1;
    public static final short sid = 65;
    private short field_1_x;
    private short field_2_y;
    private short field_3_topRow;
    private short field_4_leftColumn;
    private short field_5_activePane;

    public PaneRecord() {
    }

    public short getActivePane() {
        return this.field_5_activePane;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 10;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.z0
            public final /* synthetic */ PaneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short x6;
                switch (i5) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getTopRow();
                        break;
                    case 3:
                        x6 = this.b.getLeftColumn();
                        break;
                    default:
                        x6 = this.b.getActivePane();
                        break;
                }
                return Short.valueOf(x6);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.z0
            public final /* synthetic */ PaneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short x6;
                switch (i6) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getTopRow();
                        break;
                    case 3:
                        x6 = this.b.getLeftColumn();
                        break;
                    default:
                        x6 = this.b.getActivePane();
                        break;
                }
                return Short.valueOf(x6);
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.z0
            public final /* synthetic */ PaneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short x6;
                switch (i7) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getTopRow();
                        break;
                    case 3:
                        x6 = this.b.getLeftColumn();
                        break;
                    default:
                        x6 = this.b.getActivePane();
                        break;
                }
                return Short.valueOf(x6);
            }
        };
        final int i8 = 3;
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("x", supplier, "y", supplier2, "topRow", supplier3, "leftColumn", new Supplier(this) { // from class: org.apache.poi.hssf.record.z0
            public final /* synthetic */ PaneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short x6;
                switch (i8) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getTopRow();
                        break;
                    case 3:
                        x6 = this.b.getLeftColumn();
                        break;
                    default:
                        x6 = this.b.getActivePane();
                        break;
                }
                return Short.valueOf(x6);
            }
        }, "activePane", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.z0
            public final /* synthetic */ PaneRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short x6;
                switch (i9) {
                    case 0:
                        x6 = this.b.getX();
                        break;
                    case 1:
                        x6 = this.b.getY();
                        break;
                    case 2:
                        x6 = this.b.getTopRow();
                        break;
                    case 3:
                        x6 = this.b.getLeftColumn();
                        break;
                    default:
                        x6 = this.b.getActivePane();
                        break;
                }
                return Short.valueOf(x6);
            }
        }, new int[]{0, 1, 2, 3}, new String[]{"LOWER_RIGHT", "UPPER_RIGHT", "LOWER_LEFT", "UPPER_LEFT"}));
    }

    public short getLeftColumn() {
        return this.field_4_leftColumn;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 65;
    }

    public short getTopRow() {
        return this.field_3_topRow;
    }

    public short getX() {
        return this.field_1_x;
    }

    public short getY() {
        return this.field_2_y;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_x);
        littleEndianOutput.writeShort(this.field_2_y);
        littleEndianOutput.writeShort(this.field_3_topRow);
        littleEndianOutput.writeShort(this.field_4_leftColumn);
        littleEndianOutput.writeShort(this.field_5_activePane);
    }

    public void setActivePane(short s6) {
        this.field_5_activePane = s6;
    }

    public void setLeftColumn(short s6) {
        this.field_4_leftColumn = s6;
    }

    public void setTopRow(short s6) {
        this.field_3_topRow = s6;
    }

    public void setX(short s6) {
        this.field_1_x = s6;
    }

    public void setY(short s6) {
        this.field_2_y = s6;
    }

    public PaneRecord(PaneRecord paneRecord) {
        super(paneRecord);
        this.field_1_x = paneRecord.field_1_x;
        this.field_2_y = paneRecord.field_2_y;
        this.field_3_topRow = paneRecord.field_3_topRow;
        this.field_4_leftColumn = paneRecord.field_4_leftColumn;
        this.field_5_activePane = paneRecord.field_5_activePane;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PANE;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public PaneRecord copy() {
        return new PaneRecord(this);
    }

    public PaneRecord(RecordInputStream recordInputStream) {
        this.field_1_x = recordInputStream.readShort();
        this.field_2_y = recordInputStream.readShort();
        this.field_3_topRow = recordInputStream.readShort();
        this.field_4_leftColumn = recordInputStream.readShort();
        this.field_5_activePane = recordInputStream.readShort();
    }
}
