package jamService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import jamLazy.gdjson;

public class mailbox extends HttpServlet implements doEvery {

	@Override
	public void doWhatever(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			JsonObject jso=gdjson.getJsonObject(req.getReader()).getAsJsonObject();
			String type=jso.get("servType").getAsString();
			switch(type){
				case "newMsg":break;
				case "getMsg":break;
			}
		
	}
	
	private void sendRespNewMsg(HttpServletResponse resp){
		int amt=Math.round((float)(Math.random()*10));
		JsonObject jso=new JsonObject();
		if(amt==0){
			amt=-1;
		}
		jso.addProperty("result", amt);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			pw.write(gdjson.gson.toJson(jso));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

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

}
