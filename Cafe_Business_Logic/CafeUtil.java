import java.util.ArrayList;
import java.util.Arrays;
public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        //write a method that sums together every consecutive integer from 1 to 10 and return the sum..i.e sum = 1 + 2 + 3 so on...
        int sum = 0;
        for(int i = 0; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for(int i = 0; i < prices.length; i++) {
            sum += prices[i];
            // System.out.println(sum); //making sure it added properly
        }
        return sum;
    }

    public String displayMenu(ArrayList<String> menu) {
        String itemName = menu.get(0);
        String menuItems = 0 + " " + itemName + "\n";
        for(int i = 1; i < menu.size(); i++) {
            itemName = menu.get(i);
            menuItems += i + " " + itemName + "\n";
        }
        // System.out.println(menuItems);
        return menuItems;
    }

    public String addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s", userName);
        customers.add(userName);
        System.out.printf("\n There are %d people in front of you", (customers.size() - 1));
        System.out.println("\n" + customers);
        return null;
    }
}