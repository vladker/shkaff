package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    public String entranceMiniProgramPath;
    public String entranceMiniProgramUsername;
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public WXImageObject() {
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        String str2;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && (((str = this.imagePath) == null || str.length() == 0) && ((str2 = this.imageUrl) == null || str2.length() == 0))) {
            SSDKLog.b().a("checkArgs fail, all arguments are null", new Object[0]);
            return false;
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 != null && bArr2.length > 26214400) {
            SSDKLog.b().a("checkArgs fail, content is too large", new Object[0]);
            return false;
        }
        String str3 = this.imagePath;
        if (str3 != null && str3.length() > 10240) {
            SSDKLog.b().a("checkArgs fail, path is invalid", new Object[0]);
            return false;
        }
        if (this.imagePath != null) {
            try {
                if (n.a().a(this.imagePath) > 26214400) {
                    SSDKLog.b().a("checkArgs fail, image content is too large", new Object[0]);
                    return false;
                }
            } catch (Throwable th) {
                SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, androidx.exifinterface.media.a.n(" WXImageObject catch don't worry will betwo style ", th));
                int iA = n.a().a(this.imagePath);
                if (iA != 0 && iA > 10485760) {
                    return false;
                }
            }
        }
        String str4 = this.imageUrl;
        if (str4 == null || str4.length() <= 10240) {
            return true;
        }
        SSDKLog.b().a("checkArgs fail, url is invalid", new Object[0]);
        return false;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        bundle.putString("_wximageobject_entranceMiniProgramUsername", this.entranceMiniProgramUsername);
        bundle.putString("_wximageobject_entranceMiniProgramPath", this.entranceMiniProgramPath);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        this.entranceMiniProgramUsername = bundle.getString("_wximageobject_entranceMiniProgramUsername");
        this.entranceMiniProgramPath = bundle.getString("_wximageobject_entranceMiniProgramPath");
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            SSDKLog.b().a(e);
        }
    }
}
