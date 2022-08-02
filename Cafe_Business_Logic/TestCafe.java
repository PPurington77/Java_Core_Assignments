import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        //Create instance of CafeUtil class//

        CafeUtil appTest = new CafeUtil();

        //------App test cases below----------------//



        System.out.println("\n------ Streak Goal Test -------");
        int numWeeks = 10; //this number can be changed, and it will be reflected in the printout below
        System.out.printf("Purchases needed by week %d: %s \n\n", numWeeks, appTest.getStreakGoal(numWeeks));

        System.out.println("---------------Order Total Test-----------");
        double[] lineItems = {3, 5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n", appTest.getOrderTotal(lineItems));

        System.out.println("-------------Display Menu Test-------------");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        // appTest.displayMenu(menu);
        System.out.println(appTest.displayMenu(menu));

        System.out.println("\n--------- Add Customer Test --------------");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 Times ----
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }
    }
}