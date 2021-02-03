package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MethodServlet",urlPatterns = "/method")
public class MethodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post请求中如果参数里面有中文  需要设置字符集 此代码需要写在获取参数之前
        request.setCharacterEncoding("UTF-8");
        System.out.println("接收到了post请求");
        String info=request.getParameter("info");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.print("服务器接收到了:"+info);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到了get请求");
        //获取参数 request请求相关的内容都在这个对象中
        String info=request.getParameter("info");
        //给客户端返回数据
        //设置响应类型
        response.setContentType("text/html;charset=utf-8");
        //输出对象
        PrintWriter pw=response.getWriter();
        pw.print("服务器接收到了:"+info);//输出数据
        pw.close();
    }
}
