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

@WebServlet("/register")
public class register extends HttpServlet implements doEvery {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWhatever(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWhatever(req,resp);
	}

	@Override
	public void doWhatever(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Request-Method", "POST");
		int lng=req.getContentLength();
		BufferedReader bfr=req.getReader();
		char[] msge=new char[lng];
		PrintWriter pw=resp.getWriter();
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
		rep.put("regSuccess",true);
		Gson gs=new Gson();
		pw.write(gs.toJson(rep));
		pw.flush();
	
		
	}

}
