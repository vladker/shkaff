package com.appdev.standard.model;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementSelectedResult {
    private BaseControlView controlView;
    private int count;
    private List<JSONObject> jsonObjectList;

    public ElementSelectedResult(BaseControlView baseControlView, int i5) {
        this.controlView = baseControlView;
        this.count = i5;
    }

    public BaseControlView getControlView() {
        return this.controlView;
    }

    public int getCount() {
        return this.count;
    }

    public List<JSONObject> getJsonObjectList() {
        return this.jsonObjectList;
    }

    public void setControlView(BaseControlView baseControlView) {
        this.controlView = baseControlView;
    }

    public void setCount(int i5) {
        this.count = i5;
    }

    public void setJsonObjectList(List<JSONObject> list) {
        this.jsonObjectList = list;
    }

    public ElementSelectedResult(List<JSONObject> list, int i5) {
        this.jsonObjectList = list;
        this.count = i5;
    }
}
