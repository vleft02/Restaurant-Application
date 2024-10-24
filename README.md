# Restaurant Order Management System


<p align="center">
  <img src="https://github.com/user-attachments/assets/c514d28c-43fd-404b-8bfc-b66ed7ac2be9" alt="app_logo">
</p>

Code and analysis of the operation of the restaurant order management system for the Software Technology course.

## **Introduction**

A restaurant order management system for the waiters to select a table, enter an order with product selection, calculate the total bill, and change the order status. For management, the system offers various statistics on sales and calculations of profit, operating costs, etc.

## Restaurant System Description

<br/>

> **The system to be designed concerns an application for the digital transformation of a restaurant.
> The actors of this system are:**
- **the owner** of the restaurant
- **the chefs** and
- **the customers**

Initially, the owner registers in the system for his restaurant and enters the restaurant's details, the menu, and the available tables.

The application displays a suitable QR code for each table, which can be printed and placed on the respective tables by the restaurant owner.

Additionally, the chefs and customers must register with their details in the system by creating an account. Customers have an account with an electronic wallet, and the chefs have an account with special privileges, as they are added by the owner as employees.

The application allows customers to manage their orders through a page with active orders (orders page) and a page with completed orders (Order History). They can navigate through the store menu with dish options and their corresponding prices after scanning the QR code available in print form on the table with their mobile phones. They can then submit the order from their mobile phones by indicating the quantity of each dish they want from the menu.

Each order submitted by a customer is displayed on the mobile/tablet screen of the chef, who then marks the start and completion of its preparation through the application.

Furthermore, the customer can view their orders and track their progress through the application and cancel them if desired, provided they have not been completed.

Finally, after the chef marks the completion of the order, the money owed is automatically deducted from the customer's electronic wallet, who is notified of the transaction's completion with a notification (we assume that when placing the order, the customer commits to paying, and if there is no cancellation, the transaction is completed automatically). Then the waiter delivers it.

All orders are stored in a file so that the application can later generate reports and statistical data, which the owner can access. Specifically, it calculates monthly and yearly revenues, the average expenses made by each customer, the average daily revenues, and the percentage of canceled orders.

## System Requirements

> ### The system we are implementing has various requirements that need to be considered. Among these are the existence of a registration process for the restaurant owner, the ability for each owner to enter the restaurant's details, the menu, and the tables, and the generation of different QR codes for each table. Also, registration for chefs and customers is deemed necessary. Furthermore, it is important for customers to be able to view the menu through the QR code they scan, to be able to select the desired quantity and dish. Moreover, they should be able to place their order through the application provided they have the necessary balance in their electronic wallet, to monitor the information and progress of it, or even cancel it. Chefs should be able to view user orders and update the status of each order. Finally, the system should provide the ability to store all orders and their details (cost, time, bill, table) per order so that the necessary statistical data can be generated and accessed by restaurant owners.

<br/>



<details>
  <summary>Greek</summary>
  # Σύστημα διαχείρισης παραγγελιών εστιατορίου

Κώδικας και ανάλυση της λειτουργίας του συστήματος διαχείρισης παραγγελιών εστιατορίου για την εργασία του μαθήματος Τεχνολογία Λογισμικού.

##  **Εισαγωγή**

Ένα σύστημα λήψης παραγγελιών για εστιατόριο που προσφέρει στους
σερβιτόρους επιλογή τραπεζιού, καταχώρηση παραγγελίας με επιλογή προϊόντων, υπολογισμός
συνολικού κόστους λογαριασμού, αλλαγή κατάσταση παραγγελίας. Ενώ για την
διοίκηση το σύστημα προσφέρει διάφορα στατιστικά για της πωλήσεις και υπολογισμούς
κέρδους, κόστους λειτουργίας κλπ.
    

## Περιγραφή Συστήματος Εστιατορίου

<br/>

> **Το σύστημα προς σχεδίαση αφορά μία εφαρμογή ψηφιακού μετασχηματισμού ενός εστιατορίου.
> Οι actors αυτού του συστήματος είναι:**
- **ο ιδιοκτήτης** (owner) του εστιατορίου
-  **οι μάγειρες** (chefs) και
-   **οι πελάτες** (customers)

  
  Αρχικά, ο ιδιοκτήτης κάνει εγγραφή στο σύστημα για το εστιατόριό του και καταχωρεί τα στοιχεία του εστιατορίου, το μενού καθώς και τα διαθέσιμα τραπέζια.
  
  Η εφαρμογή εμφανίζει ένα κατάλληλο QR code για κάθε τραπέζι, το οποίο μπορεί να εκτυπωθεί και να τοποθετηθεί στα αντίστοιχα τραπέζια από τον ιδιοκτήτη του εστιατορίου.
  
  Επιπλέον, οι μάγειρες και οι πελάτες πρέπει να εγγραφούν με τα στοιχεία τους στο σύστημα δημιουργώντας λογαριασμό.
Οι πελάτες έχουν λογαριασμό με ηλεκτρονικό πορτοφόλι και οι μάγειρες έχουν λογαριασμό με ειδικά δικαιώματα αφού αυτοί προστεθούν από τον ιδιοκτήτη ως υπάλληλοι.
  
  Η εφαρμογή επιτρέπει στους πελάτες να διαχειρίζονται τις παραγγελίες τους μέσω μιας σελίδας με ενεργές παραγγελίες (σελίδα παραγγελιών) και μίας σελίδας με ολοκληρωμένες παραγγελίες (Ιστορικό παραγγελιών).
Μπορούν δηλαδή να πλοηγηθούν στο μενού του καταστήματος με τις επιλογές πιάτων και τις αντίστοιχες τιμές τους αφού σκανάρουν το QR code που θα είναι διαθέσιμο σε έντυπη μορφή στο τραπέζι με το κινητό τους τηλέφωνο. Έτσι μπορούν να υποβάλλουν την παραγγελία από το κινητό τους δηλώνοντας την ποσότητα του κάθε πιάτου που θέλουν από το μενού.
  
  Κάθε παραγγελία που υποβάλλεται από πελάτη εμφανίζεται στην οθόνη του κινητού / tablet του μάγειρα και ο ίδιος επισημαίνει την έναρξη και την ολοκλήρωση της προετοιμασίας της μέσω της εφαρμογής.
  
  Ακόμη, ο πελάτης μπορεί να δει τις παραγγελίες του και να παρακολουθεί την πορεία τους μέσω της εφαρμογής αλλά και να τις ακυρώσει σε περίπτωση που το επιθυμεί εφόσον αυτές δεν έχουν ολοκληρωθεί.
  
  Τέλος, αφού ο μάγειρας σημάνει την ολοκλήρωση της παραγγελίας τα χρήματα που της αναλογούν αφαιρούνται αυτόματα απο το ηλεκτρονικό πορτοφόλι του πελάτη, ο οποίος ενημερώνεται για την ολοκλήρωση της συναλλαγής με ειδοποίηση (θεωρούμε πως κατά την υποβολή της παραγγελίας ο πελάτης δεσμέυεται οτι θα πληρώσει και έφοσον δεν υπάρξει ακύρωση η συναλλαγή ολοκληρώνεται αυτόματα). Έπειτα ο σερβιτόρος την παραδίδει.
  
  Όλες οι παραγγελίες αποθηκεύονται σε αρχείο ετσι ώστε να μπορεί αργοτερα η εφαρμογή να παράγει αναφορές και στατιστικά στοιχεία τις οποίες μπορεί να προσπελάσει ο ιδιοκτήτης. Συγκεκριμένα, υπολογίζει τα μηνιαία και τα ετήσια έσοδα, τον μέσο όρο εξόδων που κάνει κάθε πελάτης, τον μέσο όρο ημερησίων εσόδων και το ποσοστό ακυρωμένων παραγγελιών.

## Απαιτήσεις Συστήματος

> ### Το σύστημα που υλοποιούμε έχει διάφορες απαιτήσεις οι οποίες θα πρέπει να ληφθούν υπόψη. Ανάμεσα σε αυτές είναι η ύπαρξη μίας διαδικασίας εγγραφής για τον ιδιοκτήτη του εστιατορίου, η δυνατότητα για κάθε ιδιοκτήτη να μπορεί να εισάγει τα στοιχεία του εστιατορίου, το μενού και τα τραπέζια και η παραγωγή διαφορετικών QR codes για κάθε τραπέζι. Επίσης, κρίνεται αναγκαία η εγγραφή για μάγειρες και πελάτες. Επιπλέον, είναι σημαντικό να μπορούν οι πελάτες να βλέπουν το μενού μέσω του QR code που σκανάρουν, να έχουν την δυνατότητα να επιλέξουν την επιθυμητή ποσότητα και το πιάτο που θέλουν. Ακόμη, θα πρέπει να μπορούν να δηλώσουν την παραγγελία τους μέσω της εφαρμογής εφόσον έχουν το απαραίτητο χρηματικό υπόλοιπο στο ηλεκτρονικό τους πορτοφόλι, να παρακολουθήσουν τις πληροφορίες και την πορεία της ή και να την ακυρώσουν. Οι μάγειρες πρέπει να μπορούν να βλέπουν τις παραγγελίες των χρηστών και να είναι σε θέση να ενημερώνουν την κατάσταση της κάθε παραγγελίας. Τέλος, το σύστημα θα πρέπει να παρέχει την δυνατότητα αποθήκευσης όλων των παραγγελιών και των στοιχείων τους (κόστος, ώρα, λογαριασμός, τραπέζι) ανά παραγγελία ώστε να μπορούν να παραχθούν τα απαραίτητα στατιστικά στοιχεία και να έχουν πρόσβαση σε αυτά οι ιδιοκτήτες των εστιατορίων.

<br/>
</details>



## [ ***Use case diagram for restaurant***](docs/uml/requirements/use_case.png)

## [***.uxf file***](docs/markdown/uml/requirements/restaurant_use_case.uxf)

<br/>

![](docs/uml/requirements/use_case.png)


