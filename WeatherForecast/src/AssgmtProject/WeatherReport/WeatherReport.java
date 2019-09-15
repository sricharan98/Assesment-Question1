package AssgmtProject.WeatherReport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class  WeatherReport
{
	public static Map<String,Object> jsonToMap(String str)
	{
		Map<String,Object> map=new Gson().fromJson(str,new TypeToken<HashMap<String,Object>>() {}.getType());
		return map;
	}
	public static void main(String[] args) 
	{
		
		String urlStr="https://api.openweathermap.org/data/2.5/weather?q=Hyderabad, IN&appid=2cdef6cf56d43434a55596cf822167d1";
		try
		{
			StringBuffer result = new StringBuffer();
			URL url = new URL(urlStr);
			URLConnection conn=url.openConnection();
			BufferedReader rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line=rd.readLine())!=null)
			{
				result.append(line);
			}
			rd.close();
			Map<String, Object> m= WeatherReport.jsonToMap(result.toString());
			Iterator<String> it = m.keySet().iterator();
			while(it.hasNext()) {
				String str = it.next().toString();
				System.out.print(str+" ");
				System.out.println(m.get(str));
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
