package lib.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class StackTraceUtil {

    private static final String packagesToIgnore = StringUtils.join(
            new String[] { "org.testng", "org.openqa", "sun.reflect", "java.lang.reflect", "org.springframework" },
            "|");

    private static final String linesToIgnore = StringUtils.join(new String[] { "\\(Session info:", "\\(Driver info:",
            "Command duration or timeout:", "Build info: version:", "System info: host:", "Driver info:",
            "Capabilities \\{", "Session ID: ", "For documentation on this error" }, "|");

    public static String filter(Throwable throwable) {
        String text = ExceptionUtils.getStackTrace(throwable);

        String result = text.replaceAll("\\s*(" + StackTraceUtil.linesToIgnore + ").*", "");
        result = result.replaceAll("\\s+at (" + StackTraceUtil.packagesToIgnore + ").*", "");
        return result;
    }

    private StackTraceUtil() {
        // static helper class
    }
}
