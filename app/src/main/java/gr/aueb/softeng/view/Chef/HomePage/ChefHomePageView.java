package gr.aueb.softeng.view.Chef.HomePage;

public interface ChefHomePageView {
    /**
     * Ελέγχει εάν η λίστα με τις παραγγελίες που εμφανίζεται στο recycler view είναι άδεια ή οχι
     * Εάν είναι άδεια , βγάζει απο την οθόνη το Recycler View και κάνει visible το κέιμενο που ενημερώνει ότι η λίστα είναι άδεια
     * Διαφορετικά , εμφανίζει το Recycler View  , σετάρει τον adapter και βγάζει απο την οθόνη το κείμενο που αναφέρθηκε παραπάνω
     */
    void changeLayout();
    /**
     * Καλείται όταν θέλουμε να επιστρέψουμε στο προηγούμενο Activity , δηλαδή στο login Page στην περίπτωσή μας(αυτό καλεί το activity μας)
     */
    void goBack();
}
