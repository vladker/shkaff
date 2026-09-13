package com.appdev.standard.api.dto;

import com.library.base.util.http.JsonResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class InviteRecordDto extends JsonResult {
    private List<DataBean> data;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataBean {
        private String inviteRecordId;
        private String inviteUserName;
        private int status;

        public String getInviteRecordId() {
            return this.inviteRecordId;
        }

        public String getInviteUserName() {
            return this.inviteUserName;
        }

        public int getStatus() {
            return this.status;
        }

        public void setInviteRecordId(String str) {
            this.inviteRecordId = str;
        }

        public void setInviteUserName(String str) {
            this.inviteUserName = str;
        }

        public void setStatus(int i5) {
            this.status = i5;
        }
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }
}
