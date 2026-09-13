package com.appdev.standard.model;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TemplateEditBean {
    private BaseControlView baseControlView;
    private JSONObject newObject;
    private JSONObject oldObject;
    private int type;

    public TemplateEditBean(int i5, BaseControlView baseControlView) {
        this.oldObject = null;
        this.newObject = null;
        this.type = i5;
        this.baseControlView = baseControlView;
    }

    public BaseControlView getBaseControlView() {
        return this.baseControlView;
    }

    public JSONObject getNewObject() {
        return this.newObject;
    }

    public JSONObject getOldObject() {
        return this.oldObject;
    }

    public int getType() {
        return this.type;
    }

    public void setBaseControlView(BaseControlView baseControlView) {
        this.baseControlView = baseControlView;
    }

    public void setNewObject(JSONObject jSONObject) {
        this.newObject = jSONObject;
    }

    public void setOldObject(JSONObject jSONObject) {
        this.oldObject = jSONObject;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    public TemplateEditBean(int i5, BaseControlView baseControlView, JSONObject jSONObject, JSONObject jSONObject2) {
        this.type = i5;
        this.baseControlView = baseControlView;
        this.oldObject = jSONObject;
        this.newObject = jSONObject2;
    }
}
