package cn.fly.mcl;

/* JADX INFO: loaded from: classes.dex */
public abstract class BusinessMessageCallback implements BusinessMessageListener {
    public static final int STATUS_NO_RECEIVED = 0;
    public static final int STATUS_RECEIVED = 1;

    public abstract void messageReceived(int i5, int i6, String str, String str2);

    @Override // cn.fly.mcl.BusinessMessageListener
    public void messageReceived(int i5, String str, String str2) {
    }
}
