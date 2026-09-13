package org.apache.poi.hssf.record.pivottable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewDefinitionRecord extends StandardRecord {
    public static final short sid = 176;
    private int cCol;
    private int cDim;
    private int cDimCol;
    private int cDimData;
    private int cDimPg;
    private int cDimRw;
    private int cRw;
    private int colFirst;
    private int colFirstData;
    private int colLast;
    private String dataField;
    private int grbit;
    private int iCache;
    private int ipos4Data;
    private int itblAutoFmt;
    private String name;
    private int reserved;
    private int rwFirst;
    private int rwFirstData;
    private int rwFirstHead;
    private int rwLast;
    private int sxaxis4Data;

    public ViewDefinitionRecord(ViewDefinitionRecord viewDefinitionRecord) {
        super(viewDefinitionRecord);
        this.rwFirst = viewDefinitionRecord.rwFirst;
        this.rwLast = viewDefinitionRecord.rwLast;
        this.colFirst = viewDefinitionRecord.colFirst;
        this.colLast = viewDefinitionRecord.colLast;
        this.rwFirstHead = viewDefinitionRecord.rwFirstHead;
        this.rwFirstData = viewDefinitionRecord.rwFirstData;
        this.colFirstData = viewDefinitionRecord.colFirstData;
        this.iCache = viewDefinitionRecord.iCache;
        this.reserved = viewDefinitionRecord.reserved;
        this.sxaxis4Data = viewDefinitionRecord.sxaxis4Data;
        this.ipos4Data = viewDefinitionRecord.ipos4Data;
        this.cDim = viewDefinitionRecord.cDim;
        this.cDimRw = viewDefinitionRecord.cDimRw;
        this.cDimCol = viewDefinitionRecord.cDimCol;
        this.cDimPg = viewDefinitionRecord.cDimPg;
        this.cDimData = viewDefinitionRecord.cDimData;
        this.cRw = viewDefinitionRecord.cRw;
        this.cCol = viewDefinitionRecord.cCol;
        this.grbit = viewDefinitionRecord.grbit;
        this.itblAutoFmt = viewDefinitionRecord.itblAutoFmt;
        this.name = viewDefinitionRecord.name;
        this.dataField = viewDefinitionRecord.dataField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.rwFirst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.rwLast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$10() {
        return Integer.valueOf(this.ipos4Data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$11() {
        return Integer.valueOf(this.cDim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$12() {
        return Integer.valueOf(this.cDimRw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$13() {
        return Integer.valueOf(this.cDimCol);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$14() {
        return Integer.valueOf(this.cDimPg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$15() {
        return Integer.valueOf(this.cDimData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$16() {
        return Integer.valueOf(this.cRw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$17() {
        return Integer.valueOf(this.cCol);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$18() {
        return Integer.valueOf(this.grbit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$19() {
        return Integer.valueOf(this.itblAutoFmt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Integer.valueOf(this.colFirst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$20() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$21() {
        return this.dataField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Integer.valueOf(this.colLast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return Integer.valueOf(this.rwFirstHead);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$5() {
        return Integer.valueOf(this.rwFirstData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$6() {
        return Integer.valueOf(this.colFirstData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$7() {
        return Integer.valueOf(this.iCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$8() {
        return Integer.valueOf(this.reserved);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$9() {
        return Integer.valueOf(this.sxaxis4Data);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return StringUtil.getEncodedSize(this.dataField) + StringUtil.getEncodedSize(this.name) + 40;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("rwFirst", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i6 = 2;
        linkedHashMap.put("rwLast", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i7 = 5;
        linkedHashMap.put("colFirst", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i8 = 6;
        linkedHashMap.put("colLast", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i9 = 7;
        linkedHashMap.put("rwFirstHead", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i10 = 8;
        linkedHashMap.put("rwFirstData", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i11 = 9;
        linkedHashMap.put("colFirstData", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i12 = 10;
        linkedHashMap.put("iCache", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i13 = 12;
        linkedHashMap.put("reserved", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i14 = 13;
        linkedHashMap.put("sxaxis4Data", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i15 = 11;
        linkedHashMap.put("ipos4Data", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i16 = 14;
        linkedHashMap.put("cDim", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i16) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i17 = 15;
        linkedHashMap.put("cDimRw", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i17) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i18 = 16;
        linkedHashMap.put("cDimCol", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i18) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i19 = 17;
        linkedHashMap.put("cDimPg", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i19) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i20 = 18;
        linkedHashMap.put("cDimData", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i20) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i21 = 19;
        linkedHashMap.put("cRw", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i21) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i22 = 20;
        linkedHashMap.put("cCol", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i22) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i23 = 21;
        linkedHashMap.put("grbit", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i23) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i24 = 1;
        linkedHashMap.put("itblAutoFmt", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i24) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i25 = 3;
        linkedHashMap.put("name", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i25) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        final int i26 = 4;
        linkedHashMap.put("dataField", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.g
            public final /* synthetic */ ViewDefinitionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i26) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$19();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    case 3:
                        return this.b.lambda$getGenericProperties$20();
                    case 4:
                        return this.b.lambda$getGenericProperties$21();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return this.b.lambda$getGenericProperties$3();
                    case 7:
                        return this.b.lambda$getGenericProperties$4();
                    case 8:
                        return this.b.lambda$getGenericProperties$5();
                    case 9:
                        return this.b.lambda$getGenericProperties$6();
                    case 10:
                        return this.b.lambda$getGenericProperties$7();
                    case 11:
                        return this.b.lambda$getGenericProperties$10();
                    case 12:
                        return this.b.lambda$getGenericProperties$8();
                    case 13:
                        return this.b.lambda$getGenericProperties$9();
                    case 14:
                        return this.b.lambda$getGenericProperties$11();
                    case 15:
                        return this.b.lambda$getGenericProperties$12();
                    case 16:
                        return this.b.lambda$getGenericProperties$13();
                    case 17:
                        return this.b.lambda$getGenericProperties$14();
                    case 18:
                        return this.b.lambda$getGenericProperties$15();
                    case 19:
                        return this.b.lambda$getGenericProperties$16();
                    case 20:
                        return this.b.lambda$getGenericProperties$17();
                    default:
                        return this.b.lambda$getGenericProperties$18();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 176;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rwFirst);
        littleEndianOutput.writeShort(this.rwLast);
        littleEndianOutput.writeShort(this.colFirst);
        littleEndianOutput.writeShort(this.colLast);
        littleEndianOutput.writeShort(this.rwFirstHead);
        littleEndianOutput.writeShort(this.rwFirstData);
        littleEndianOutput.writeShort(this.colFirstData);
        littleEndianOutput.writeShort(this.iCache);
        littleEndianOutput.writeShort(this.reserved);
        littleEndianOutput.writeShort(this.sxaxis4Data);
        littleEndianOutput.writeShort(this.ipos4Data);
        littleEndianOutput.writeShort(this.cDim);
        littleEndianOutput.writeShort(this.cDimRw);
        littleEndianOutput.writeShort(this.cDimCol);
        littleEndianOutput.writeShort(this.cDimPg);
        littleEndianOutput.writeShort(this.cDimData);
        littleEndianOutput.writeShort(this.cRw);
        littleEndianOutput.writeShort(this.cCol);
        littleEndianOutput.writeShort(this.grbit);
        littleEndianOutput.writeShort(this.itblAutoFmt);
        littleEndianOutput.writeShort(this.name.length());
        littleEndianOutput.writeShort(this.dataField.length());
        StringUtil.writeUnicodeStringFlagAndData(littleEndianOutput, this.name);
        StringUtil.writeUnicodeStringFlagAndData(littleEndianOutput, this.dataField);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.VIEW_DEFINITION;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ViewDefinitionRecord copy() {
        return new ViewDefinitionRecord(this);
    }

    public ViewDefinitionRecord(RecordInputStream recordInputStream) {
        this.rwFirst = recordInputStream.readUShort();
        this.rwLast = recordInputStream.readUShort();
        this.colFirst = recordInputStream.readUShort();
        this.colLast = recordInputStream.readUShort();
        this.rwFirstHead = recordInputStream.readUShort();
        this.rwFirstData = recordInputStream.readUShort();
        this.colFirstData = recordInputStream.readUShort();
        this.iCache = recordInputStream.readUShort();
        this.reserved = recordInputStream.readUShort();
        this.sxaxis4Data = recordInputStream.readUShort();
        this.ipos4Data = recordInputStream.readUShort();
        this.cDim = recordInputStream.readUShort();
        this.cDimRw = recordInputStream.readUShort();
        this.cDimCol = recordInputStream.readUShort();
        this.cDimPg = recordInputStream.readUShort();
        this.cDimData = recordInputStream.readUShort();
        this.cRw = recordInputStream.readUShort();
        this.cCol = recordInputStream.readUShort();
        this.grbit = recordInputStream.readUShort();
        this.itblAutoFmt = recordInputStream.readUShort();
        int uShort = recordInputStream.readUShort();
        int uShort2 = recordInputStream.readUShort();
        this.name = StringUtil.readUnicodeString(recordInputStream, uShort);
        this.dataField = StringUtil.readUnicodeString(recordInputStream, uShort2);
    }
}
