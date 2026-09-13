package A1;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface i {
    Point convertMapToOffset(Map<?, ?> map);

    int getColor(String str);

    Map<?, ?> getMap();

    Point getOffset(String str);

    Rect getRect(String str);
}
