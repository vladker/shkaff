package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int PATH_LENGTH_LIMIT = 10240;
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    private int getFileSize(String str) {
        return n.a().a(str);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        byte[] bArr;
        String str2 = this.extInfo;
        if ((str2 == null || str2.length() == 0) && (((str = this.filePath) == null || str.length() == 0) && ((bArr = this.fileData) == null || bArr.length == 0))) {
            SSDKLog.b().a("checkArgs fail, all arguments is null", new Object[0]);
            return false;
        }
        String str3 = this.extInfo;
        if (str3 != null && str3.length() > 2048) {
            SSDKLog.b().a("checkArgs fail, extInfo is invalid", new Object[0]);
            return false;
        }
        String str4 = this.filePath;
        if (str4 != null && str4.length() > 10240) {
            SSDKLog.b().a("checkArgs fail, filePath is invalid", new Object[0]);
            return false;
        }
        String str5 = this.filePath;
        if (str5 != null && getFileSize(str5) > CONTENT_LENGTH_LIMIT) {
            SSDKLog.b().a("checkArgs fail, fileSize is too large", new Object[0]);
            return false;
        }
        byte[] bArr2 = this.fileData;
        if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
            return true;
        }
        SSDKLog.b().a("checkArgs fail, fileData is too large", new Object[0]);
        return false;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
    }

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }
}
