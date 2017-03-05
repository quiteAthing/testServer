package jamService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/checkAcc")
public class checkAcc extends HttpServlet implements doEvery {

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
		resp.setContentType("application/json");
		int lng=req.getContentLength();
		char[] msg=new char[lng];
		BufferedReader bfr= req.getReader();
		PrintWriter pw=resp.getWriter();
		bfr.read(msg);
		String json=String.valueOf(msg);
		JsonParser js=new JsonParser();
		JsonObject jso=js.parse(json).getAsJsonObject();
		Gson gs =new Gson();
		String acc=jso.get("acc").getAsString();
		System.out.println("check  ACC :  "+acc);
		JsonObject ret=new JsonObject();
		ret.addProperty("accExt", false);
		pw.write(gs.toJson(ret));
		pw.flush();
		
		
		
		
		
	}

}
