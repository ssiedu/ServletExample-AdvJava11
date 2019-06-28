import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxCalculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //reading-the-data coming from client
            String s1=request.getParameter("t1");
            String s2=request.getParameter("t2");
        //process-the data (calculate the income tax)
            int income=Integer.parseInt(s1);
            int age=Integer.parseInt(s2);
            int tax=0,rebate=0,nettax=0;
            if(income>=500000){
                tax=income*20/100;
            }else{
                tax=income*10/100;
            }
            if(age>=60){
                rebate=(tax*25)/100;
            }
            nettax=tax-rebate;
        //provide-the-response
            //to-send-text-response-use-PrintWriter
            PrintWriter out=response.getWriter();
            out.println("Thanks For Visiting Us.");
            out.println("Your Income Is  : "+income);
            out.println("Your Tax Is : "+tax);
            out.println("Your Rebate Is : "+rebate);
            out.println("NetTax Is  : "+nettax);
            out.println("Pay Your Taxes On Time To Avoid Panelties");
            out.close();//closing the stream
    }
}
