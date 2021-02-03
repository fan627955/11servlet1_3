package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+":"+password);
        //获取连接
        try(Connection conn=DBUtils.getConn()){
            String sql="select id from user where username=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            String info=null;
            //判断是否查询到数据 查询到说明登录成功，否则登录失败
            if(rs.next()){
                info="恭喜你登录成功!";
            }else{info="用户名或密码错误!";}
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pw=response.getWriter();
            pw.print(info);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
