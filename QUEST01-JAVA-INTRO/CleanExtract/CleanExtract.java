public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");

        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            int firstDot = part.indexOf('.');
            String extracted = getString(part, firstDot);
            if (!extracted.isEmpty()) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(extracted);
            }
        }
        return result.toString();
    }

    private static String getString(String part, int firstDot) {
        int lastDot = part.lastIndexOf('.');

        String extracted;
        if (firstDot == -1) {
            extracted = part.trim();
        } else if (firstDot == lastDot) {
            extracted = part.substring(firstDot + 1).trim();
        } else {
            extracted = part.substring(firstDot + 1, lastDot).trim();
        }
        return extracted;
    }
}
