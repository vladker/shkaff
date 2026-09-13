package K3;

import S3.f;
import U3.q;
import X3.C0254u;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends J3.b {
    @Override // I3.b
    public f defaultPlatformRandom() {
        Integer num = a.sdkVersion;
        return (num == null || num.intValue() >= 34) ? new T3.a() : super.defaultPlatformRandom();
    }

    @Override // I3.b
    public C0254u getMatchResultNamedGroup(MatchResult matchResult, String name) {
        E.f(matchResult, "matchResult");
        E.f(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        q qVar = new q(matcher.start(name), matcher.end(name) - 1, 1);
        if (qVar.getStart().intValue() < 0) {
            return null;
        }
        String strGroup = matcher.group(name);
        E.e(strGroup, "group(...)");
        return new C0254u(strGroup, qVar);
    }
}
