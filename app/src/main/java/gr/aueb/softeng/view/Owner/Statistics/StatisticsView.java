package gr.aueb.softeng.view.Owner.Statistics;

public interface StatisticsView {
    /**
     * Εμφανίζει ενα μήνυμα τύπου alert με
     * τίτλο title και μήνυμα message.
     * @param title Ο τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    void showErrorMessage(String title, String message);
    /**
     * Καλείται για να επιστρέψουμε στο προηγούμενο Activity
     */
    void goBack();
    /**
     * Εμφανίζει στην οθόνη το μέσο μηνιαίο εισόδημα του εστιατορίου
     * @param monthlyIncome το υπολογισμένο ποσό του μηνιαίου εισοδήματος σε μορφή String
     */
    void setAVGMonthlyIncome(String monthlyIncome);
    /**
     * Εμφανίζει στην οθόνη το ετήσιο εισόδημα του εστιατορίου
     * @param yearlyIncome το υπολογισμένο ετήσιο εισόδημα σε μορφή String
     */
    void setYearlyIncome(String yearlyIncome);
    /**
     * Εμφανίζει στην οθόνη τα μέσα έξοδα ανά παραγγελία πελάτη
     * @param orderExpenses τα υπολογισμένα έξοδα σε μορφή String
     */
    void setAvgOrderExpenses(String orderExpenses) ;
    /**
     * Εμφανίζει στην οθόνη τα μέσα ημερήσια έξοδα
     * @param revenue το υπολογισμένο ποσό των μέσων ημερησίων εξόδων σε μορφή String
     */
    void setAVGDailyRevenue(String revenue);
    /**
     * Εμφανίζει στην οθόνη το ποσοστό των ακυρωμένων παραγγελιών
     * @param canc το υπολογισμένο ποσοστό ακυρωμένων παραγγελιών
     */
    void setOrderCancellationRate(String canc);
}
