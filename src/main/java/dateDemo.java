import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateDemo {

    public dateDemo() {
        System.out.println("Constructor Called first");
    }

    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.toString());

        SimpleDateFormat  sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(sdf.format(d));
        dateDemo demo = new dateDemo();
        demo.calendar();

    }

    public void calendar() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(sdf.format(cal.getTime()));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(cal.get(Calendar.AM_PM));
    }
}
