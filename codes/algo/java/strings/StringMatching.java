package codes.algo.java.strings;

/**
 * <b>找出字符串中第一个匹配项的下标</b>
 *
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回 -1 。
 * </p>
 */
public class StringMatching {

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int a = i, b = 0;
            while (b < m && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StringMatching matching = new StringMatching();
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = matching.strStr(haystack, needle);
        System.out.printf(String.valueOf(result));
    }
}
