package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FeatProtection implements SharedFeature {
    public static final long HAS_SELF_RELATIVE_SECURITY_FEATURE = 1;
    public static final long NO_SELF_RELATIVE_SECURITY_FEATURE = 0;
    private int fSD;
    private int passwordVerifier;
    private byte[] securityDescriptor;
    private String title;

    public FeatProtection() {
        this.securityDescriptor = new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this.securityDescriptor;
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return StringUtil.getEncodedSize(this.title) + 8 + this.securityDescriptor.length;
    }

    public int getFSD() {
        return this.fSD;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.c
            public final /* synthetic */ FeatProtection b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getFSD());
                    case 1:
                        return Integer.valueOf(this.b.getPasswordVerifier());
                    case 2:
                        return this.b.getTitle();
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.c
            public final /* synthetic */ FeatProtection b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getFSD());
                    case 1:
                        return Integer.valueOf(this.b.getPasswordVerifier());
                    case 2:
                        return this.b.getTitle();
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.c
            public final /* synthetic */ FeatProtection b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getFSD());
                    case 1:
                        return Integer.valueOf(this.b.getPasswordVerifier());
                    case 2:
                        return this.b.getTitle();
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("FSD", supplier, "passwordVerifier", supplier2, "title", supplier3, "securityDescriptor", new Supplier(this) { // from class: org.apache.poi.hssf.record.common.c
            public final /* synthetic */ FeatProtection b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getFSD());
                    case 1:
                        return Integer.valueOf(this.b.getPasswordVerifier());
                    case 2:
                        return this.b.getTitle();
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        });
    }

    public int getPasswordVerifier() {
        return this.passwordVerifier;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.fSD);
        littleEndianOutput.writeInt(this.passwordVerifier);
        StringUtil.writeUnicodeString(littleEndianOutput, this.title);
        littleEndianOutput.write(this.securityDescriptor);
    }

    public void setPasswordVerifier(int i5) {
        this.passwordVerifier = i5;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public FeatProtection copy() {
        return new FeatProtection(this);
    }

    public FeatProtection(FeatProtection featProtection) {
        this.fSD = featProtection.fSD;
        this.passwordVerifier = featProtection.passwordVerifier;
        this.title = featProtection.title;
        byte[] bArr = featProtection.securityDescriptor;
        this.securityDescriptor = bArr == null ? null : (byte[]) bArr.clone();
    }

    public FeatProtection(RecordInputStream recordInputStream) {
        this.fSD = recordInputStream.readInt();
        this.passwordVerifier = recordInputStream.readInt();
        this.title = StringUtil.readUnicodeString(recordInputStream);
        this.securityDescriptor = recordInputStream.readRemainder();
    }
}
