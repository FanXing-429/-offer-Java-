public class Main2 {
   /*
   请实现一个函数，将一个字符串中的每个空格替换成“%20”。
   例如，当字符串为We Are Happy.
   则经过替换之后的字符串为We%20Are%20Happy
   */

   /* 可以直接用String的一个工具方法 */
    public String replaceSpace(StringBuffer str) {
        //参数时 StringBuffer，可以动态扩展字符串的长度，要用 String 的方法应该先 toString
        return str.toString().replace(" ", "%20");
    }

    /* 我们可以遍历字符串的所有字符 */
    public String replaceSpace1(StringBuffer str) {
        int length = str.length();
        //创建一个新的Buffer字符串
        StringBuffer strNew = new StringBuffer();
        String s = "%20";
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == ' '){
                //如果为空格就在后面追加"%20"
                strNew.append(s);
            }else {
                //不是空格就将原来的字符追加上去
                strNew.append(c);
            }
        }
        //最后遍历完将 StringBuffer 转化为 String
        String string = strNew.toString();
        return string;
    }
}
