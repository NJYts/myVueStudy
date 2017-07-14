package test;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		//calendar.setTimeInMillis(1480586214L*1000);
		//System.out.println(calendar.getTime());
		/*最前面的/和最后面的/表示正则表达式的开始和结束，没实际意义，所以正则表达式为^[^\?]+\??
			第一个^表示匹配文本的开头，[]表示匹配满足内部条件的字符，[]里面的^\?表示除了？以外的任意字符，
			[]后面的+表示匹配的次数为1次或大于1次，一直到?才匹配结束，\?表示?字符，最后一个?表示匹配一次或0次*/
		String str  = "ja<dhfghk>DH>S?G";
		str = str.replaceAll("<[^>]+>","成功么" );
		str = str.replaceAll("^[^\\?]+\\??","成功么" );
		//System.out.println(str);
		String input="教师10(0010)教师11(0011)教师9(009)教师12(0012)教师13(0013)教师14(0014)"; 
		Pattern pattern = Pattern.compile("(?<=\\()(.+?)(?=\\))"); 
		Matcher matcher=pattern.matcher(input); 
		while(matcher.find()){ 
		System.out.println(matcher.group()); 
		} 
		
	}

}
