package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SeriesCalculator;

import java.io.IOException;

@WebServlet("/series")
public class SeriesServlet extends HttpServlet {

    private final SeriesCalculator calculator = new SeriesCalculator();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String xParam = request.getParameter("x");
            String nParam = request.getParameter("n");
            String e1Param = request.getParameter("e1");
            String e2Param = request.getParameter("e2");

            if (xParam == null || nParam == null || e1Param == null || e2Param == null) {
                throw new IllegalArgumentException("All fields are required.");
            }

            double x = Double.parseDouble(xParam);
            int n = Integer.parseInt(nParam);
            double e1 = Double.parseDouble(e1Param);
            double e2 = Double.parseDouble(e2Param);

            if (x < -1 || x > 1) throw new IllegalArgumentException("x must be in the range (-1, 1).");
            if (n <= 0) throw new IllegalArgumentException("Number of terms (n) must be positive.");
            if (e1 <= 0 || e2 <= 0) throw new IllegalArgumentException("Error thresholds (e1 and e2) must be positive.");

            double exact = calculator.calculateExact(x);
            double sumN = calculator.calculateSumOfTerms(x, n);

            int[] termCountE1 = new int[1];
            int[] termCountE2 = new int[1];
            double sumAboveE1 = calculator.calculateSumAboveE(x, e1, termCountE1);
            double sumAboveE2 = calculator.calculateSumAboveE(x, e2, termCountE2);

            request.setAttribute("x", x);
            request.setAttribute("n", n);
            request.setAttribute("exact", exact);
            request.setAttribute("sumN", sumN);
            request.setAttribute("sumAboveE1", sumAboveE1);
            request.setAttribute("sumAboveE2", sumAboveE2);
            request.setAttribute("termCountE1", termCountE1[0]);
            request.setAttribute("termCountE2", termCountE2[0]);

            request.getRequestDispatcher("seriesResult.jsp").forward(request, response);

        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Invalid input. Please enter numeric values.");
            request.getRequestDispatcher("series.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("series.jsp").forward(request, response);
        }
    }
}


