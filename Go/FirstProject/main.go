package main
import "fmt"

func main(){

	var conferenceName = "Go conference"
	const totalTickets  = 50
	var ticketRemaining = 50

	fmt.Printf("Welcome to %v booking application \n",conferenceName)
	fmt.Printf("We have %v tickets and %v are still available \n",totalTickets,ticketRemaining)
	fmt.Println("Get your tickets here to attend")
    
}