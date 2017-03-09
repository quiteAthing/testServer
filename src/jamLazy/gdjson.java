package jamLazy;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class gdjson {
	BufferedReader bfr;
	public static Gson gson=new Gson(); 
	public static JsonParser jp=new JsonParser();

	public static JsonObject getJsonObject(BufferedReader src) throws IOException{
		JsonObject jo = jp.parse(src).getAsJsonObject();
		return jo;
	}
	
	
	

}
