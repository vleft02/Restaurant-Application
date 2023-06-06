package gr.aueb.softeng.view.Owner.Statistics;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.dao.OwnerDAO;
import gr.aueb.softeng.dao.RestaurantDAO;
import gr.aueb.softeng.domain.Order;
import gr.aueb.softeng.domain.Restaurant;

public class StatisticsPresenter {
    private RestaurantDAO restaurantDAO;
    private OwnerDAO ownerDAO;
    private Restaurant restaurant;

    /**
     * Αρχικοποιεί το owner dao και το restaurant dao για να μπορούμε να αποθηκεύσουμε και ανακτήσουμε απο την
     * στατιστική μας λίστα τα εστιατόρια και τους ιδιοκτήτες
     * @param ownerDAO
     * @param restaurantDAO
     */

    public StatisticsPresenter(OwnerDAO ownerDAO, RestaurantDAO restaurantDAO){
        this.ownerDAO=ownerDAO;
        this.restaurantDAO = restaurantDAO;
    }
    StatisticsView view;

    /**
     * Αρχικοποιεί το view απο το οποίο θα χρησιμοποιήσουμε τις μεθόδους του interface του
     * @param view Instance του view
     */
    public void setView(StatisticsView view)
    {
        this.view = view;
    }

    /**
     * Βρίσκει μέσω του μοναδικού id απο την λίστα με τα εστιατόρια του dao το αντικείμενο του εστιατορίου
     * που ψάχνουμε
     * @param restaurantId το id του εστιατορίου που θέλουμε να εμφανίσουμε τα στοιχεία του
     */
    public void setRestaurant(int restaurantId) {
        restaurant = restaurantDAO.find(restaurantId);
    }
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στην αρχική οθόνη
     */
    public void OnBack(){
        view.goBack();
    }

    /**
     * Υπολογίζει το ετήσιο εισόδημα του εστιατορίου , για το τρέχον έτος
     * το οποίο το παίρνει απο την μεταβλητή 'now'
     * @return επιστρέφει το άθροισμα στην μέθοδο που το καλεί
     */
    public double calcYearlyIncome(){
        double sum=0.0;
        LocalDateTime now = LocalDateTime.now();
        for(Order order:restaurant.getOrders()){
            if(order.getDate().getYear()== now.getYear() && order.getOrderState()== Order.State.COMPLETED){
                sum+=order.getTotalCost();
            }
        }
        return sum;
    }

    /**
     * Υπολογίζει το μέσο μηνιαίο εισόδημα του εστιατορίου , για το τρέχον έτος
     * διαιρεί με τους διαφορετικούς μήνες όπου υπήρξαν παραγγελίες
     * @return επιστρέφει το συνολικό άθροισμα διά τον αριθμό διαφορετικών μηνών όπου ηπήρξε παραγγελία
     * διαφορετικά , ελέγχει εάν είναι 0 ο αριθμός των μηνών και επιστρέφει 0
     */
    public double calcAvgMonthlyIncome(){
        LocalDateTime now = LocalDateTime.now();
        double totalIncome = 0.0;
        Set<Integer> monthsWithOrders = new HashSet<>();

        for (Order order : restaurant.getOrders()) {
            LocalDateTime orderDate = order.getDate();
            if (orderDate.getYear() == now.getYear() && order.getOrderState()== Order.State.COMPLETED) {
                totalIncome += order.getTotalCost();
                int month = orderDate.getMonthValue();
                monthsWithOrders.add(month);
            }
        }
        int totalMonths = monthsWithOrders.size();
        if(totalMonths!=0) {
            return totalIncome / totalMonths;
        }else{
            return 0;
        }
    }

    /**
     * Υπολογίζει τα μέσα έξοδα κάθε παραγγελίας πελάτη , αθροίζοντας όλα τα κόστη των παραγγελιών
     * διά τον αριθμό των παραγγελιών(έχουμε υποθέσει ότι κάθε παραγγελία γίνεται απο έναν μόνο πελάτη
     * και μας ενδιαφέρει το έξοδο κάθε παραγγελίας- που ταυτίζεται με κάθε πελάτη)
     * @return το παραπάνω άθροισμα
     * εάν δεν έχουμε παραγγελίες , επιστρέφει 0
     */

    public double calcAvgOrderExpenses(){
        double cost=0.0;
        LocalDateTime now = LocalDateTime.now();
        for (Order order : restaurant.getOrders()) {
            LocalDateTime orderDate = order.getDate();
            if (orderDate.getYear() == now.getYear() && order.getOrderState()== Order.State.COMPLETED) {
                cost += order.getTotalCost();
            }
        }
        if(restaurant.getOrders().size()!=0){
            return cost/restaurant.getOrders().size();
        }else{
            return 0;
        }
    }

    /**
     * Υπολογίζει το μέσο καθημερινό εισόδημα του εστιατορίου
     * @return επιστρέφει το άθροισμα αυτο δια τον συνολικό αριθμό ημερών που
     * γίνονται οι παραγγελίες
     * Εάν ο αριθμός ημερών ειναι μηδέν , επιστρέφει 0
     */
    public double calcAvgDailyRevenue(){
        double totalIncome = 0.0;
        int totalDays = 0;
        LocalDateTime now = LocalDateTime.now();

        for (int month = 1; month <= 12; month++) {
            for (Order order : restaurant.getOrders()) {
                LocalDateTime orderDate = order.getDate();
                if (orderDate.getYear() == now.getYear() && orderDate.getMonthValue() == month && order.getOrderState()== Order.State.COMPLETED ) {
                    totalIncome += order.getTotalCost();
                    totalDays++;
                }
            }
        }
        if(totalDays!=0) {
            return totalIncome / totalDays;
        }else{
            return 0;
        }

    }

    /**
     * Υπολογίζει το ποσοστό των ακυρωμένων παραγγελιών του εστιατορίου
     * @return επιστρέφει το συγκεκριμένο ποσοστό
     * Εάν δεν υπάρχουν παραγγελίες , επιστρέφει 0
     */
    public double calcCancelRate(){
        LocalDateTime now = LocalDateTime.now();
        int totalOrders = 0;
        int cancelledOrders = 0;

        for (Order order : restaurant.getOrders()) {
            LocalDateTime orderDate = order.getDate();
            if (orderDate.getYear() == now.getYear()) {
                totalOrders++;
                if (order.getOrderState()== Order.State.CANCELLED) {
                    cancelledOrders++;
                }
            }
        }
        if(totalOrders!=0) {
           return((double) cancelledOrders / totalOrders * 100);
        }else{
            return 0;
        }
    }

    /**
     * Η μέθοδος αυτή καλεί τις μεθόδους του view για να περάσει τα αποτελέσματα
     * των στατιστικών υπολογισμών , χρησιμοποιώντας τις παραπάνω
     * συναρτήσεις που περιγράφηκαν
     */
    public void calculateStats(){

        view.setYearlyIncome(String.valueOf(calcYearlyIncome()));


        view.setAVGMonthlyIncome(String.valueOf(calcAvgMonthlyIncome()));

        view.setAvgOrderExpenses(String.valueOf(calcAvgOrderExpenses()));



        view.setAVGDailyRevenue(String.valueOf(calcAvgDailyRevenue()));

        view.setOrderCancellationRate(String.valueOf(calcCancelRate()));
    }
}
