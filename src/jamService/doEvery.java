package jamService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface doEvery{
	abstract void doWhatever(HttpServletRequest req,HttpServletResponse resp)throws IOException;
	}
