package main
import "fmt"

func main(){
     
	var conferenceName  string= "Go Conference";
	const totalTickets int = 50;
	var ticketRemaining uint = 50;
    
	fmt.Printf("conferenceTickets is %T,total tickets is %T ,remaining tickets is %T",conferenceName,totalTickets,ticketRemaining);
	fmt.Printf("Welcome to %v booking application \n",conferenceName);
	fmt.Printf("We have %v tickets and %v are still available \n",totalTickets,ticketRemaining);
	fmt.Println("Get your tickets here to attend");
    
	

	var firstname string
	var lastName string
	var email string
	var userTickets int
	//ask user for their name

	fmt.Println("Enter your first name ");
	fmt.Scan(&firstname)

	fmt.Println("Enter your last name ");
	fmt.Scan(&lastName)

	fmt.Println("Enter your email ");
	fmt.Scan(&email)

	fmt.Println("Enter no of tickets to book ")
	fmt.Scan(&userTickets)


	fmt.Printf("Thank you %v %v for booking %v tickets .You will your confirmation email at %v \n",firstname,lastName,userTickets,email);
    
}
