package by.tms.servlet;

import by.tms.calc.Evaluator;

import javax.naming.OperationNotSupportedException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String op = request.getParameter("op");
        double a = Double.parseDouble(request.getParameter("a")),
        b = Double.parseDouble(request.getParameter("b"));

        try { response.getWriter().println(new Evaluator().evaluate(a, b, op));
        } catch (OperationNotSupportedException e) { e.printStackTrace(); }
    }
}
