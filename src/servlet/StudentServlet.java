package servlet;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/12/26/026.
 */
@WebServlet("*.do")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID=1L;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*  /useradd.do*/
        String path=req.getServletPath();
        String name=path.substring( 5,path.length()-3 );
        //使用反射来让他调用对应的方法
        try {
            Method method = this.getClass().getDeclaredMethod(name,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke( this,req,resp );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void update2(HttpServletRequest request,
                         HttpServletResponse response){
        System.out.println("update2");
    }

    private void queryById(HttpServletRequest request,
                           HttpServletResponse response){
        System.out.println("queryById");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("update");
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("query");
    }


    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("delete");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("add");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet( req,resp );
    }
}
