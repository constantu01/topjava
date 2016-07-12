package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by комп on 06.07.2016.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG=getLogger(MealServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("getAll");

//        request.getRequestDispatcher("/MEAL_LIST.jsp").forward(request, response);
//        response.sendRedirect("MEAL_LIST.jsp");
        List<UserMealWithExceed> userMealWithExceedList= UserMealsUtil.getWithExceeded(UserMealsUtil.MEAL_LIST, 2000);
        request.setAttribute("mealList", userMealWithExceedList);
        request.getRequestDispatcher("/mealList.jsp").forward(request,response);

    }
}
