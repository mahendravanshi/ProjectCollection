package main

import (
   "fmt"
   "strings"
)

func main() {

	var conferenceName string = "Go Conference"
	const totalTickets int = 50
	var ticketRemaining uint = 50
	var bookings []string

	fmt.Printf("conferenceTickets is %T,total tickets is %T ,remaining tickets is %T", conferenceName, totalTickets, ticketRemaining)
	fmt.Printf("Welcome to %v booking application \n", conferenceName)
	fmt.Printf("We have %v tickets and %v are still available \n", totalTickets, ticketRemaining)
	fmt.Println("Get your tickets here to attend")

	for {

		var firstname string
		var lastName string
		var email string
		var userTickets uint
		//ask user for their name

		fmt.Println("Enter your first name ")
		fmt.Scan(&firstname)

		fmt.Println("Enter your last name ")
		fmt.Scan(&lastName)

		fmt.Println("Enter your email ")
		fmt.Scan(&email)

		fmt.Println("Enter no of tickets to book ")
		fmt.Scan(&userTickets)

		if userTickets > ticketRemaining {
			fmt.Printf("We have %v tickets remaining .So you can't book %v tickets \n",ticketRemaining,userTickets);
			continue;
		}
		ticketRemaining = ticketRemaining - userTickets

		bookings = append(bookings, firstname+" "+lastName)

		fmt.Printf("The whole Slice is %v\n", bookings)
		fmt.Printf("The first value is %v\n", bookings[0])
		fmt.Printf("Slice type is %T\n", bookings)
		fmt.Printf("Slice length is %v\n", len(bookings))
		fmt.Printf("Thank you %v %v for booking %v tickets .You will your confirmation email at %v \n", firstname, lastName, userTickets, email)

		fmt.Printf("%v tickets are remaining for our %v \n", ticketRemaining, conferenceName)

		firstnames := []string{}
		for _,booking := range bookings{
               var names = strings.Fields(booking)
			   firstnames = append(firstnames,names[0])
		}
		fmt.Printf("These first names of bookings are : %v \n",firstnames)
        
		if ticketRemaining == 0 {
			//end the program
			fmt.Println("Our conference is booked out. Please come next year");
			break;
		} 
	}
    

}
