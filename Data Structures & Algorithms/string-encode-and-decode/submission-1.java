class Solution {

    public String encode(List<String> strs) {

        // 인코딩을 해야됨.
        // 길이정보 포함해서 인코딩.
        // ex) 5#Hello5#World

        // StringBuilder Version
        StringBuilder encoded = new StringBuilder();
        for (String str : strs){
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<>();

        // ex) str 은 5#hello4#nice

        int i = 0;
        
        while (i < str.length()){
            int j = i;

            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));

            // j+1 부터 j + 1 + len 까지 가져와야함 
            decoded.add(str.substring(j+1, j + 1 + len));


            // 다음 단위로 포인터 이동
            i = j + 1 + len;
        }
        return decoded;
    }
}
