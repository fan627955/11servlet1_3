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

@WebServlet(name = "RegServlet",urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        //获取参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+":"+password);
        //获取连接
        try(Connection conn=DBUtils.getConn()){
            String sql="insert into user values(null,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            //替换?
            ps.setString(1,username);
            ps.setString(2,password);
            //执行SQL语句
            ps.executeUpdate();
            System.out.println("注册成功!");
            //给客户端返回提示信息
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pw=response.getWriter();
            pw.print("注册成功");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
