package org.apache.poi.xssf.binary;

import V2.f;
import androidx.collection.a;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public abstract class XSSFBParser {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 1000000;
    private static int MAX_RECORD_LENGTH = 1000000;
    private final LittleEndianInputStream is;
    private final f records;

    public XSSFBParser(InputStream inputStream) {
        this.is = new LittleEndianInputStream(inputStream);
        this.records = null;
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void readNext(byte b) {
        int i5 = (b >> 7) & 1;
        int i6 = b;
        if (i5 == 1) {
            i6 = ((byte) (b & Ascii.DEL)) + (((byte) (this.is.readByte() & Ascii.DEL)) << 7);
        }
        long j6 = 0;
        int i7 = 0;
        boolean z6 = false;
        while (i7 < 4 && !z6) {
            byte b6 = this.is.readByte();
            boolean z7 = ((b6 >> 7) & 1) == 0;
            j6 += ((long) ((byte) (b6 & Ascii.DEL))) << (i7 * 7);
            i7++;
            z6 = z7;
        }
        f fVar = this.records;
        if (fVar == null || fVar.f(i6)) {
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(j6, MAX_RECORD_LENGTH);
            this.is.readFully(bArrSafelyAllocate);
            handleRecord(i6, bArrSafelyAllocate);
        } else {
            long jSkipFully = IOUtils.skipFully(this.is, j6);
            if (jSkipFully == j6) {
                return;
            }
            StringBuilder sbT = a.t("End of file reached before expected.\tTried to skip ", j6, ", but only skipped ");
            sbT.append(jSkipFully);
            throw new XSSFBParseException(sbT.toString());
        }
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public abstract void handleRecord(int i5, byte[] bArr);

    public void parse() throws IOException {
        while (true) {
            int i5 = this.is.read();
            if (i5 == -1) {
                return;
            } else {
                readNext((byte) i5);
            }
        }
    }

    public XSSFBParser(InputStream inputStream, f fVar) {
        this.is = new LittleEndianInputStream(inputStream);
        this.records = fVar;
    }
}
