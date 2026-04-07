class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        int n = str.length();

        while (i < n) {
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, j));

            strs.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return strs;
    }
}
