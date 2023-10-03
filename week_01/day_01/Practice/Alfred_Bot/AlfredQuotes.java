import java.util.Date;
import java.text.SimpleDateFormat; // help form web for this 

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greeting = String.format("Hello, %s. Lovely to see you.", name);
        return greeting;
    }
    
    public String dateAnnouncement() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        String formattedDate = dateFormat.format(currentDate);
        return currentDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return "for snarky response return string";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}

