package gr.aueb.softeng.view.Owner.RestaurantDetails;



public interface RestaurantDetailsView {
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
   * Εμφανίζει το όνομα του εστιατορίου που επιλέχθηκε στην οθόνη
   * @param name το όνομα που θα εμφανιστεί
   */
     void setRestName(String name);
    /**
     *εμφανίζει το id του εστιατορίου που επιλέχθηκε στην οθόνη
     *@param id το id που θα εμφανιστεί
     */

     void setRestId(String id);
    /**
    * Εμφανίζει τον αριθμό των τραπεζιών του εστιατορίου που επιλέχθηκε στην οθόνη
    * @param tables ο αριθμός των τραπεζιών σε μορφή String
    */
     void setRestTables(String tables);
    /**
    * Εμφανίζει το όνομα της οδού του εστιατορίου που επιλέχθηκε στην οθόνη
    * @param street η οδός που θα εμφανιστεί
    */
     void setRestAddressStreet(String street);
    /**
    * Εμφανίζει τον αριθμό της οδού του εστιατορίου που επιλέχθηκε στην οθόνη
    * @param num ο αριθμός που θα εμφανιστεί
    */
     void setRestAddressNumber(String num);
    /**
    * Εμφανίζει τον ταχυδρομικό κώδικα  του εστιατορίου που επιλέχθηκε στην οθόνη
    * @param zip ο ταχυδρομικός κώδικας που θέλουμε να εμφανιστεί
    */
     void setRestZip(String zip);
    /**
     * * Εμφανίζει την πόλη του εστιατορίου που επιλέχθηκε στην οθόνη
     * @param city η πόλη που θέλουμε να εμφανιστεί
     */
     void setRestAddressCity(String city);
    /**
    * Καλείται όταν πατηθεί το κουμπι εξαγωγής στατιστικών και υπολογίζει τα στατιστικά του εστιατορίου
    */
     void extractStats();
    /**
    * Καλείται όταν πατηθεί το κουμπί της εισαγωγής νέου μάγειρα στο εστιατόριο και περνάει το id του εστιατορίου
    */
     void addChef();
}
