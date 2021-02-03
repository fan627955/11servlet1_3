package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BMIServlet",urlPatterns = "/bmi")
public class BMIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取参数
       String height=request.getParameter("h");
       String weight=request.getParameter("w");
       System.out.println(height+":"+weight);
       //将字符串类型转成浮点数
       float h=Float.parseFloat(height);
       float w=Float.parseFloat(weight);
       float bmi=w/(h*h);
       String info=null;
       if(bmi<18.5){
           info="兄弟你瘦了";
       }else if(bmi<24){
           info="体重正常";
       }else if(bmi<28){
           info="偏胖";
       }else{
           info="兄弟该少吃点儿了!";
       }
       response.setContentType("text/html;charset=utf-8");
       PrintWriter pw=response.getWriter();
       pw.print(info);
       pw.close();
    }
}
