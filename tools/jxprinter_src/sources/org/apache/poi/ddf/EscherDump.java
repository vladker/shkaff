package org.apache.poi.ddf;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherDump {
    public void dump(byte[] bArr, int i5, int i6, PrintStream printStream) {
        EscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory();
        int i7 = i5;
        while (i7 < i5 + i6) {
            EscherRecord escherRecordCreateRecord = defaultEscherRecordFactory.createRecord(bArr, i7);
            int iFillFields = escherRecordCreateRecord.fillFields(bArr, i7, defaultEscherRecordFactory);
            printStream.println(escherRecordCreateRecord);
            i7 += iFillFields;
        }
    }

    public void dump(int i5, byte[] bArr, PrintStream printStream) {
        dump(bArr, 0, i5, printStream);
    }
}
