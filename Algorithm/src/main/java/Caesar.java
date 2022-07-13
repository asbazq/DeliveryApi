public class Caesar {
    //class Solution {
        public String solution(String s, int n) {
            String answer = "";

            for (int i =0; i < s.length(); i++) {
                char chr = s.charAt(i);

                if (Character.isLowerCase(chr)) {
                    chr = (char) ((chr - 'a' + n) % 26 + 'a');

                } else if (Character.isUpperCase(chr)) {
                    chr = (char) ((chr - 'A' + n) % 26 + 'A');
                }
                answer += chr;
            }
            return answer;
        }
        public static void main(String[] args) {
            Caesar method = new Caesar();
            String alpha = "ab";
            int num = 1;
            System.out.println(method.solution(alpha,num));
        }
    }

