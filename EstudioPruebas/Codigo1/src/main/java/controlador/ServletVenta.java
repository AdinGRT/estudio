package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Reporte;
import dao.VentaDao;

/**
 *
 * @author adingrt
 */

@WebServlet("/ServletVenta")
public class ServletVenta extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("venta.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    
}
