package jamService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/login")
public class login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doWhatever(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doWhatever(req, resp);
	}
	
	
	private void doWhatever(HttpServletRequest req,HttpServletResponse resp)throws IOException{
		PrintWriter pw=resp.getWriter();
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Request-Method", "POST");
			BufferedReader bfr=req.getReader();
			int lng=req.getContentLength();
			char[] msge=new char[lng];
			bfr.read(msge, 0, lng);
			JsonParser jp=new JsonParser();
			String json=String.valueOf(msge);
			JsonObject jso=jp.parse(json).getAsJsonObject();
			String fbid=jso.get("fbUID").getAsString();
			if(fbid!=null){
				System.out.println("fbid   "+fbid);	
			}
			System.out.println("=======================================================================");
			System.out.println("acc  "+jso.get("acc").getAsString());
			System.out.println("pw   "+jso.get("pw").getAsString());
			System.out.println("=======================================================================");
			
		
			HashMap<String,Object>rep=new HashMap<>();
			rep.put("loginSuccess",true);
			Gson gs=new Gson();
			pw.write(gs.toJson(rep));
			pw.flush();
		
			
			
		
		
		
		
	}

}
