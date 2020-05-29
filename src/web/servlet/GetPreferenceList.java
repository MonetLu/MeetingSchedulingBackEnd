package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.domian.Preference;
import main.service.PreferenceService;
import main.service.impl.PreferenceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getPreferenceList")
public class GetPreferenceList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreferenceService preferenceService = new PreferenceServiceImpl();
        String email = request.getParameter("email");
        List<Preference> preferenceList = preferenceService.getPreferenceList(email);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(preferenceList);
        PrintWriter out = response.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
