package cn.fly.tools.network;

import cn.fly.tools.proguard.PublicMemberKeeper;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface HttpConnection extends PublicMemberKeeper {
    InputStream getErrorStream();

    Map<String, List<String>> getHeaderFields();

    InputStream getInputStream();

    int getResponseCode();
}
