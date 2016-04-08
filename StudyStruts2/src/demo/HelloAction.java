package demo;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction  extends ActionSupport{
  public String execute() throws Exception{
	  System.out.println("访问到action，正在处理请求");
	  System.out.println("调用service");
	  return  "success";
  }
}
