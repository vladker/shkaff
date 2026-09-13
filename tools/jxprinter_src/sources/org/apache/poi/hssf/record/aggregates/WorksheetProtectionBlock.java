package org.apache.poi.hssf.record.aggregates;

import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.ObjectProtectRecord;
import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.ScenarioProtectRecord;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorksheetProtectionBlock extends RecordAggregate {
    private ObjectProtectRecord _objectProtectRecord;
    private PasswordRecord _passwordRecord;
    private ProtectRecord _protectRecord;
    private ScenarioProtectRecord _scenarioProtectRecord;

    private void checkNotPresent(Record record) {
        if (record == null) {
            return;
        }
        throw new RecordFormatException("Duplicate PageSettingsBlock record (sid=0x" + Integer.toHexString(record.getSid()) + ")");
    }

    private static ObjectProtectRecord createObjectProtect() {
        ObjectProtectRecord objectProtectRecord = new ObjectProtectRecord();
        objectProtectRecord.setProtect(false);
        return objectProtectRecord;
    }

    private static PasswordRecord createPassword() {
        return new PasswordRecord(0);
    }

    private static ScenarioProtectRecord createScenarioProtect() {
        ScenarioProtectRecord scenarioProtectRecord = new ScenarioProtectRecord();
        scenarioProtectRecord.setProtect(false);
        return scenarioProtectRecord;
    }

    private PasswordRecord getPassword() {
        if (this._passwordRecord == null) {
            this._passwordRecord = createPassword();
        }
        return this._passwordRecord;
    }

    private ProtectRecord getProtect() {
        if (this._protectRecord == null) {
            this._protectRecord = new ProtectRecord(false);
        }
        return this._protectRecord;
    }

    public static boolean isComponentRecord(int i5) {
        return i5 == 18 || i5 == 19 || i5 == 99 || i5 == 221;
    }

    private boolean readARecord(RecordStream recordStream) {
        int iPeekNextSid = recordStream.peekNextSid();
        if (iPeekNextSid == 18) {
            checkNotPresent(this._protectRecord);
            this._protectRecord = (ProtectRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 19) {
            checkNotPresent(this._passwordRecord);
            this._passwordRecord = (PasswordRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid == 99) {
            checkNotPresent(this._objectProtectRecord);
            this._objectProtectRecord = (ObjectProtectRecord) recordStream.getNext();
            return true;
        }
        if (iPeekNextSid != 221) {
            return false;
        }
        checkNotPresent(this._scenarioProtectRecord);
        this._scenarioProtectRecord = (ScenarioProtectRecord) recordStream.getNext();
        return true;
    }

    private static void visitIfPresent(Record record, RecordAggregate.RecordVisitor recordVisitor) {
        if (record != null) {
            recordVisitor.visitRecord(record);
        }
    }

    public void addRecords(RecordStream recordStream) {
        while (readARecord(recordStream)) {
        }
    }

    public ScenarioProtectRecord getHCenter() {
        return this._scenarioProtectRecord;
    }

    public int getPasswordHash() {
        PasswordRecord passwordRecord = this._passwordRecord;
        if (passwordRecord == null) {
            return 0;
        }
        return passwordRecord.getPassword();
    }

    public PasswordRecord getPasswordRecord() {
        return this._passwordRecord;
    }

    public boolean isObjectProtected() {
        ObjectProtectRecord objectProtectRecord = this._objectProtectRecord;
        return objectProtectRecord != null && objectProtectRecord.getProtect();
    }

    public boolean isScenarioProtected() {
        ScenarioProtectRecord scenarioProtectRecord = this._scenarioProtectRecord;
        return scenarioProtectRecord != null && scenarioProtectRecord.getProtect();
    }

    public boolean isSheetProtected() {
        ProtectRecord protectRecord = this._protectRecord;
        return protectRecord != null && protectRecord.getProtect();
    }

    public void protectSheet(String str, boolean z6, boolean z7) {
        if (str == null) {
            this._passwordRecord = null;
            this._protectRecord = null;
            this._objectProtectRecord = null;
            this._scenarioProtectRecord = null;
            return;
        }
        ProtectRecord protect = getProtect();
        PasswordRecord password = getPassword();
        protect.setProtect(true);
        password.setPassword((short) CryptoFunctions.createXorVerifier1(str));
        if (this._objectProtectRecord == null && z6) {
            ObjectProtectRecord objectProtectRecordCreateObjectProtect = createObjectProtect();
            objectProtectRecordCreateObjectProtect.setProtect(true);
            this._objectProtectRecord = objectProtectRecordCreateObjectProtect;
        }
        if (this._scenarioProtectRecord == null && z7) {
            ScenarioProtectRecord scenarioProtectRecordCreateScenarioProtect = createScenarioProtect();
            scenarioProtectRecordCreateScenarioProtect.setProtect(true);
            this._scenarioProtectRecord = scenarioProtectRecordCreateScenarioProtect;
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        visitIfPresent(this._protectRecord, recordVisitor);
        visitIfPresent(this._objectProtectRecord, recordVisitor);
        visitIfPresent(this._scenarioProtectRecord, recordVisitor);
        visitIfPresent(this._passwordRecord, recordVisitor);
    }
}
