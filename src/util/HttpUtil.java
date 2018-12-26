import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.Map;

public class HttpUtil{
	public static URLConnection getConnection(String url,Map<String,String> headers){
		try{
			URL root = new URL(url);
			return root.openConnection();
		}catch(MalformedURLException e){
			return null;
		}catch(IOException e){
			return null;
		}		
	}
}