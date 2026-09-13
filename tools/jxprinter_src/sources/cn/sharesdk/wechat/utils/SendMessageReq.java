package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SendMessageReq extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WXMediaMessage f2357a;
    public int b;
    public String c;
    public IWXSceneDataObject d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface IWXSceneDataObject {
        boolean checkArgs();

        int getJumpType();

        void serialize(Bundle bundle);

        void unserialize(Bundle bundle);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public int a() {
        return 2;
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void b(Bundle bundle) {
        super.b(bundle);
        bundle.putAll(WXMediaMessage.a.a(this.f2357a));
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.b);
        bundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.f2357a.getType());
        bundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.c);
        IWXSceneDataObject iWXSceneDataObject = this.d;
        if (iWXSceneDataObject != null) {
            bundle.putString("_scene_data_object_identifier", iWXSceneDataObject.getClass().getName());
            this.d.serialize(bundle);
        }
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f2357a = WXMediaMessage.a.a(bundle);
        this.b = bundle.getInt("_wxapi_sendmessagetowx_req_scene");
        this.c = bundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
        if (bundle.getString("_scene_data_object_identifie") != null) {
            try {
                IWXSceneDataObject iWXSceneDataObject = (IWXSceneDataObject) Class.forName(bundle.getString("_scene_data_object_identifie")).newInstance();
                this.d = iWXSceneDataObject;
                iWXSceneDataObject.unserialize(bundle);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            } catch (InstantiationException e7) {
                e7.printStackTrace();
            }
        }
    }

    @Override // cn.sharesdk.wechat.utils.m
    public boolean b() {
        int type = this.f2357a.getType();
        WXMediaMessage wXMediaMessage = this.f2357a;
        if (wXMediaMessage == null) {
            SSDKLog.b().a("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
            return false;
        }
        if (type == 6 && this.b == 2) {
            ((WXFileObject) wXMediaMessage.mediaObject).setContentLengthLimit(26214400);
        }
        int i5 = this.b;
        if (i5 == 3 && this.c == null) {
            SSDKLog.b().a("MicroMsg.SDK.SendMessageToWX.Req", "Send specifiedContact userOpenId can not be null.");
            return false;
        }
        if (i5 == 3 && this.f2414f == null) {
            SSDKLog.b().a("MicroMsg.SDK.SendMessageToWX.Req", "Send specifiedContact openid can not be null.");
            return false;
        }
        if (i5 != 4) {
            return this.f2357a.a();
        }
        if (this.d == null) {
            SSDKLog.b().a("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail, sceneDataObject is null");
            return false;
        }
        if (this.f2357a.getType() == 1) {
            return this.d.checkArgs();
        }
        return this.f2357a.a() && this.d.checkArgs();
    }
}
