package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkbookRecordList {
    private int backuppos;
    private int bspos;
    private int externsheetPos;
    private int fontpos;
    private int namepos;
    private int protpos;
    private int supbookpos;
    private int xfpos;
    private List<Record> records = new ArrayList();
    private int tabpos = -1;
    private int palettepos = -1;

    private void updateRecordPos(int i5, boolean z6) {
        int i6 = z6 ? 1 : -1;
        int protpos = getProtpos();
        if (protpos >= i5) {
            setProtpos(protpos + i6);
        }
        int bspos = getBspos();
        if (bspos >= i5) {
            setBspos(bspos + i6);
        }
        int tabpos = getTabpos();
        if (tabpos >= i5) {
            setTabpos(tabpos + i6);
        }
        int fontpos = getFontpos();
        if (fontpos >= i5) {
            setFontpos(fontpos + i6);
        }
        int xfpos = getXfpos();
        if (xfpos >= i5) {
            setXfpos(xfpos + i6);
        }
        int backuppos = getBackuppos();
        if (backuppos >= i5) {
            setBackuppos(backuppos + i6);
        }
        int namepos = getNamepos();
        if (namepos >= i5) {
            setNamepos(namepos + i6);
        }
        int supbookpos = getSupbookpos();
        if (supbookpos >= i5) {
            setSupbookpos(supbookpos + i6);
        }
        int palettepos = getPalettepos();
        if (palettepos != -1 && palettepos >= i5) {
            setPalettepos(palettepos + i6);
        }
        int externsheetPos = getExternsheetPos();
        if (externsheetPos >= i5) {
            setExternsheetPos(externsheetPos + i6);
        }
    }

    public void add(int i5, Record record) {
        this.records.add(i5, record);
        updateRecordPos(i5, true);
    }

    public Record get(int i5) {
        return this.records.get(i5);
    }

    public int getBackuppos() {
        return this.backuppos;
    }

    public int getBspos() {
        return this.bspos;
    }

    public int getExternsheetPos() {
        return this.externsheetPos;
    }

    public int getFontpos() {
        return this.fontpos;
    }

    public int getNamepos() {
        return this.namepos;
    }

    public int getPalettepos() {
        return this.palettepos;
    }

    public int getProtpos() {
        return this.protpos;
    }

    public List<Record> getRecords() {
        return this.records;
    }

    public int getSupbookpos() {
        return this.supbookpos;
    }

    public int getTabpos() {
        return this.tabpos;
    }

    public int getXfpos() {
        return this.xfpos;
    }

    public void remove(Object obj) {
        Iterator<Record> it = this.records.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next() == obj) {
                remove(i5);
                return;
            }
            i5++;
        }
    }

    public void setBackuppos(int i5) {
        this.backuppos = i5;
    }

    public void setBspos(int i5) {
        this.bspos = i5;
    }

    public void setExternsheetPos(int i5) {
        this.externsheetPos = i5;
    }

    public void setFontpos(int i5) {
        this.fontpos = i5;
    }

    public void setNamepos(int i5) {
        this.namepos = i5;
    }

    public void setPalettepos(int i5) {
        this.palettepos = i5;
    }

    public void setProtpos(int i5) {
        this.protpos = i5;
    }

    public void setRecords(List<Record> list) {
        this.records = list;
    }

    public void setSupbookpos(int i5) {
        this.supbookpos = i5;
    }

    public void setTabpos(int i5) {
        this.tabpos = i5;
    }

    public void setXfpos(int i5) {
        this.xfpos = i5;
    }

    public int size() {
        return this.records.size();
    }

    public void remove(int i5) {
        this.records.remove(i5);
        updateRecordPos(i5, false);
    }
}
