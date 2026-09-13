package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class WXEmojiObject implements WXMediaMessage.IMediaObject {
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        byte[] bArr = this.emojiData;
        if ((bArr == null || bArr.length == 0) && TextUtils.isEmpty(this.emojiPath)) {
            SSDKLog.b().a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
            return false;
        }
        byte[] bArr2 = this.emojiData;
        if (bArr2 != null && bArr2.length > 10485760) {
            SSDKLog.b().a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
            return false;
        }
        if (this.emojiPath == null) {
            return true;
        }
        try {
            File file = new File(this.emojiPath);
            if (!file.exists()) {
                SSDKLog.b().a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiPath not found");
                return false;
            }
            if (file.length() <= 10485760) {
                return true;
            }
            SSDKLog.b().a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
            return false;
        } catch (Throwable th) {
            SSDKLog.b().a("ShareSDk", androidx.exifinterface.media.a.n(" WXEmojiObject catch don't worry will be two style ", th));
            int iA = n.a().a(this.emojiPath);
            return iA == 0 || iA <= 10485760;
        }
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 8;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
    }

    public WXEmojiObject(String str) {
        this.emojiPath = str;
    }
}
