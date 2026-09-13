package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptTableDataModel {
    private float lineSize = 0.5f;
    private int rowsNum = 3;
    private int columnsNum = 2;
    private int openFrame = 1;
    private List<List> tableData = new ArrayList();
    private List<Object> mergeData = new ArrayList();

    public JSONObject ObjectToJson() {
        try {
            return new JSONObject(toJson());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public int getColumnsNum() {
        return this.columnsNum;
    }

    public float getLineSize() {
        return this.lineSize;
    }

    public List<Object> getMergeData() {
        return this.mergeData;
    }

    public int getOpenFrame() {
        return this.openFrame;
    }

    public int getRowsNum() {
        return this.rowsNum;
    }

    public List<List> getTableData() {
        return this.tableData;
    }

    public void setColumnsNum(int i5) {
        this.columnsNum = i5;
    }

    public void setLineSize(float f6) {
        this.lineSize = f6;
    }

    public void setMergeData(List<Object> list) {
        this.mergeData = list;
    }

    public void setOpenFrame(int i5) {
        this.openFrame = i5;
    }

    public void setRowsNum(int i5) {
        this.rowsNum = i5;
    }

    public void setTableData(List<List> list) {
        this.tableData = list;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
