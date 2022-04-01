public class ArrayEx14 {
    public static void main(String[] args){
        String src = "ABCDE";

        for(int i = 0; i < src.length(); i++){
            char ch = src.charAt(i);
            System.out.println("src.charAt(" + i + "): " + ch);
        }
        //change String to char[]
        char[] chArr = src.toCharArray();
        //print char array
        System.out.println(chArr);
        
    }
}
