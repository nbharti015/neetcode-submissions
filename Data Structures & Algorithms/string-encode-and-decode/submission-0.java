class Solution {

    public String encode(List<String> strs) {
         if (strs == null) return null; 
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            if (s == null) {
                sb.append("-1").append('#');
            } else {
                int len = s.length();
                sb.append(len).append('#').append(s);
            }
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        if (str == null) return null; // matches encode's null handling
        
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = str.length();
        
        while (i < n) {
            int j = i;
            while (j < n && str.charAt(j) != '#') {
                j++;
            }
            if (j >= n) {
                throw new IllegalArgumentException("Invalid encoded string: missing '#' separator.");
            }
            String lenStr = str.substring(i, j);
         int len;
            try {
                len = Integer.parseInt(lenStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid length value in encoded string: '" + lenStr + "'");
            }
            i = j + 1;
            
            if (len == -1) {
                result.add(null);
            } else {
                if (len < 0) {
                    throw new IllegalArgumentException("Invalid length < 0 (except -1 for null): " + len);
                }
                  if (i + len > n) {
                    throw new IllegalArgumentException("Invalid encoded string: not enough characters for declared length.");
                }
                String s = str.substring(i, i + len);
                result.add(s);
                i += len;
            }
        }
        return result;
    }
}
