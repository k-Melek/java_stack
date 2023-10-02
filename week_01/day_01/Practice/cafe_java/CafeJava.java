public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 3.9;
        double lattePrice = 4.2;
        double cappuccino = 4.5;

    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Noah";
        String customer3 = "Sam";
        String customer4 = "Jimmy";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        // System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

        if(isReadyOrder1){  // Cindhuri
          System.out.println(customer1 + readyMessage);
          System.out.println(displayTotalMessage + mochaPrice);
        }else{
          System.out.println( customer1 + pendingMessage );
        }

        if(isReadyOrder2){  // Noah
          System.out.println(customer2 + readyMessage);
          System.out.println(displayTotalMessage + cappuccino);
        }else{
          System.out.println(customer2 + pendingMessage);
        }

        // Sam 
        System.out.println(generalGreeting + customer3);
        double twoLatteTotal = lattePrice * 2;
        if(isReadyOrder3){
          System.out.println(customer3 + readyMessage);
          System.out.println(displayTotalMessage + twoLatteTotal);
        }else{
          System.out.println(customer3 + pendingMessage);
        }
        
    }
}
