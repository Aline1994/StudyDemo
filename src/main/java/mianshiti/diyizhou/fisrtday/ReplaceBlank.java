package mianshiti.diyizhou.fisrtday;
/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.
 * �򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author zhuxiu
 *	ռ���ڴ�9456K
 */
public class ReplaceBlank {
	 public static String replaceSpace(StringBuffer str) {
		 	StringBuffer str1 = new StringBuffer();
	    	for(int i=0;i<str.length();i++){
	            if(str.charAt(i)==' '){
	                str1.append("%20");
	            }else{
	                str1.append(str.charAt(i));
	            }
	        }
	        return str1.toString();
	    }
	    public static void main(String args[]){
	        StringBuffer sb = new StringBuffer("We Are Happy");
	        String c = replaceSpace(sb);
	        System.out.println(c);
	    }
}
