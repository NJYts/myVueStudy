package controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class BaseController {
	
	public HttpServletResponse getResponse() {
		return response;
	}
	@ResponseBody
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse response;
	
	public HttpServletRequest request;
	
	public void getObjectMapper(Object obj, HttpServletResponse response,HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            mapper.getSerializationConfig().setDateFormat(sf);
            mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
            mapper.writeValue(response.getWriter(),obj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
