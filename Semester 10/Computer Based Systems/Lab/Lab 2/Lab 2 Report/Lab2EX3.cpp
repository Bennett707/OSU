//In this exercise, you will toggle an LED using a button switch.

//Use the digital I/O pins on the Raspberry Pi to read the state
//of the switch, and send the corresponding signal to the LED.

//Thoroughly comment your code and demonstrate to the lab instructor.


//Use g++ -std=c++11 -o Lab2_3 Lab2EX3.cpp -lwiringPi

#include <iostream>
#include <unistd.h>
#include <wiringPi.h>
#include <signal.h>
#include <stdlib.h>
using namespace std;

void stop(int);

int main(){
	//Initialize the wiringPi library.
	signal(SIGINT, stop);
	wiringPiSetup();

	pinMode(4, INPUT); //Sets the Switch connected to GPIO Pin 23 as an Input
	pinMode(1, OUTPUT);
	//Set the state of the digital pins.

	while(true){

		if(digitalRead(4)==1) { //Reads the state of GPIO Pin 23
			digitalWrite(1, 0); // Turns on the LED connected to GPIO Pin 18
		}
		else {
			digitalWrite(1, 1); // Turns off the LED connected to GPIO Pin 18
		}
		//If there is a change in the state of the
		//switch, the state of the LED must also change.
	}
}

void stop(int sig){exit(1);}
