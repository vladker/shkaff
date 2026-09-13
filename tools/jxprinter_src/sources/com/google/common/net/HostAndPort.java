package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@Immutable
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String str, int i5, boolean z6) {
        this.host = str;
        this.port = i5;
        this.hasBracketlessColons = z6;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort hostAndPortFromString = fromString(str);
        Preconditions.checkArgument(!hostAndPortFromString.hasPort(), "Host has a port: %s", str);
        return hostAndPortFromString;
    }

    public static HostAndPort fromParts(String str, int i5) {
        Preconditions.checkArgument(isValidPort(i5), "Port out of range: %s", i5);
        HostAndPort hostAndPortFromString = fromString(str);
        Preconditions.checkArgument(!hostAndPortFromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(hostAndPortFromString.host, i5, hostAndPortFromString.hasBracketlessColons);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:19:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    @CanIgnoreReturnValue
    public static HostAndPort fromString(String str) {
        boolean z6;
        String strSubstring;
        String str2;
        String strSubstring2;
        Preconditions.checkNotNull(str);
        int i5 = -1;
        if (!str.startsWith("[")) {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf >= 0) {
                int i6 = iIndexOf + 1;
                if (str.indexOf(58, i6) == -1) {
                    strSubstring2 = str.substring(0, iIndexOf);
                    strSubstring = str.substring(i6);
                }
                if (!Strings.isNullOrEmpty(strSubstring)) {
                    Preconditions.checkArgument(strSubstring.startsWith("+") && CharMatcher.ascii().matchesAllOf(strSubstring), "Unparseable port number: %s", str);
                    try {
                        i5 = Integer.parseInt(strSubstring);
                        Preconditions.checkArgument(isValidPort(i5), "Port number out of range: %s", str);
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException(str.length() != 0 ? "Unparseable port number: ".concat(str) : new String("Unparseable port number: "));
                    }
                }
                return new HostAndPort(str2, i5, z6);
            }
            z6 = iIndexOf >= 0;
            strSubstring = null;
            str2 = str;
            if (!Strings.isNullOrEmpty(strSubstring)) {
                Preconditions.checkArgument(strSubstring.startsWith("+") && CharMatcher.ascii().matchesAllOf(strSubstring), "Unparseable port number: %s", str);
                i5 = Integer.parseInt(strSubstring);
                Preconditions.checkArgument(isValidPort(i5), "Port number out of range: %s", str);
            }
            return new HostAndPort(str2, i5, z6);
        }
        String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
        strSubstring2 = hostAndPortFromBracketedHost[0];
        strSubstring = hostAndPortFromBracketedHost[1];
        str2 = strSubstring2;
        z6 = false;
        if (!Strings.isNullOrEmpty(strSubstring)) {
            Preconditions.checkArgument(strSubstring.startsWith("+") && CharMatcher.ascii().matchesAllOf(strSubstring), "Unparseable port number: %s", str);
            i5 = Integer.parseInt(strSubstring);
            Preconditions.checkArgument(isValidPort(i5), "Port number out of range: %s", str);
        }
        return new HostAndPort(str2, i5, z6);
    }

    private static String[] getHostAndPortFromBracketedHost(String str) {
        Preconditions.checkArgument(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int iIndexOf = str.indexOf(58);
        int iLastIndexOf = str.lastIndexOf(93);
        Preconditions.checkArgument(iIndexOf > -1 && iLastIndexOf > iIndexOf, "Invalid bracketed host/port: %s", str);
        String strSubstring = str.substring(1, iLastIndexOf);
        int i5 = iLastIndexOf + 1;
        if (i5 == str.length()) {
            return new String[]{strSubstring, ""};
        }
        Preconditions.checkArgument(str.charAt(i5) == ':', "Only a colon may follow a close bracket: %s", str);
        int i6 = iLastIndexOf + 2;
        for (int i7 = i6; i7 < str.length(); i7++) {
            Preconditions.checkArgument(Character.isDigit(str.charAt(i7)), "Port must be numeric: %s", str);
        }
        return new String[]{strSubstring, str.substring(i6)};
    }

    private static boolean isValidPort(int i5) {
        return i5 >= 0 && i5 <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostAndPort) {
            HostAndPort hostAndPort = (HostAndPort) obj;
            if (Objects.equal(this.host, hostAndPort.host) && this.port == hostAndPort.port) {
                return true;
            }
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i5) {
        return hasPort() ? this.port : i5;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return Objects.hashCode(this.host, Integer.valueOf(this.port));
    }

    @CanIgnoreReturnValue
    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.host);
            sb.append(']');
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(NameUtil.COLON);
            sb.append(this.port);
        }
        return sb.toString();
    }

    public HostAndPort withDefaultPort(int i5) {
        Preconditions.checkArgument(isValidPort(i5));
        return hasPort() ? this : new HostAndPort(this.host, i5, this.hasBracketlessColons);
    }
}
