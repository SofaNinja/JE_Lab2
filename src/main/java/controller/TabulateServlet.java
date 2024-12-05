package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SeriesCalculator;

import java.io.IOException;

@WebServlet("/tabulate")
public class TabulateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            double h = Double.parseDouble(request.getParameter("h"));

            SeriesCalculator mathUtils = new SeriesCalculator();

            StringBuilder table = new StringBuilder("<table class='table table-bordered'><thead><tr><th>x</th><th>y</th></tr></thead><tbody>");
            for (double x = a; x <= b; x += h) {
                double y = mathUtils.calculateExact(x);
                table.append("<tr><td>").append(x).append("</td><td>").append(y).append("</td></tr>");
            }
            table.append("</tbody></table>");

            request.setAttribute("table", table.toString());
            request.getRequestDispatcher("tabulationResult.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Invalid input: " + ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
