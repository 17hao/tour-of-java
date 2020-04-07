package xyz.shiqihao.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    private String msg;

    @Override
    public void init() {
        msg = "hello, world";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        writer.print(msg);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
