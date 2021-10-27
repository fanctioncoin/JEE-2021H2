package by.academy.web.app;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class Dispatcher extends HttpServlet {

    protected void forward(String address, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    protected <T> T toPerson(Class<T> clazz, HttpServletRequest req) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining());
        ObjectMapper mapper = new ObjectMapper();
        T person = mapper.readValue(body, clazz);
        return person;
    }
}

