import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringUtil{
	/**
		@Descriptor 
		通过正则表达式reg匹配字符串str截取token值
		g表示匹配第几个子模式组
		matcher.group(g)表示匹配第g个子模式组返回的值
		matcher.groupCount()表示正则表达式总共有多少个子模式组,如果为0表示只有一个匹配模式
	*/
	public static String getToken(String regex,String str,int g){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()&&matcher.groupCount()>=g){
			return matcher.group(g);
		}else{
			return null;
		}
	}
	public static String getToken(String regex,String str){
		String data = getToken(regex,str,0);
		return data.substring(data.indexOf(':') + 2, data.lastIndexOf('"'));	 
	}
	public static void main(String[] args){
		String data = "{\"isFirstLogin\":1,\"resultCode\":0,\"userType\":0,\"userName\":\"admin1\",\"token\":\"0518285a066b21200acfca9acd6b544c\",\"canDatebook\":0}";
		String regex = "\"token\":(\"\\w*\")";
		System.out.println(StringUtil.getToken(regex,data));
	}
}