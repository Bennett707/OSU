//In this exercise, you will make an LED counter which will
//Count in binary from 0 to 15, or from 0000 to 1111.

//Use the digital I/O pins on the Raspberry Pi to send
//power to the LED. Complete the circuit as listed in
//the lab document.

//Thoroughly comment your code and demonstrate to the lab inststructor.


//Use g++ -std=c++11 -o Lab2_2 Lab2EX2.cpp -lwiringPi

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

	pinMode(1, OUTPUT);
	pinMode(4, OUTPUT);
	pinMode(5, OUTPUT);
	pinMode(6, OUTPUT);
	//Set digital pins to output.
	//Use pinMode(PIN, MODE);
	
	//0
	digitalWrite(1, 1);
	digitalWrite(4, 1);
	digitalWrite(5, 1);
	digitalWrite(6, 1);

	int us = 1000 * 1000;

	usleep(us); //Sets Time Delay to 1 Micro Second

	//1
	digitalWrite(1, 1);
	digitalWrite(4, 1);
	digitalWrite(5, 1);
	digitalWrite(6, 0);

	usleep(us);

	//2
	digitalWrite(1, 1);
	digitalWrite(4, 1);
	digitalWrite(5, 0);
	digitalWrite(6, 1);

	usleep(us);

	//3
	digitalWrite(1, 1);
	digitalWrite(4, 1);
	digitalWrite(5, 0);
	digitalWrite(6, 0);

	usleep(us);

	//4
	digitalWrite(1, 1);
	digitalWrite(4, 0);
	digitalWrite(5, 1);
	digitalWrite(6, 1);

	usleep(us);

	//5
	digitalWrite(1, 1);
	digitalWrite(4, 0);
	digitalWrite(5, 1);
	digitalWrite(6, 0);

	usleep(us);

	//6
	digitalWrite(1, 1);
	digitalWrite(4, 0);
	digitalWrite(5, 0);
	digitalWrite(6, 1);

	usleep(us);

	//7
	digitalWrite(1, 1);
	digitalWrite(4, 0);
	digitalWrite(5, 0);
	digitalWrite(6, 0);

	usleep(us);

	//8
	digitalWrite(1, 0);
	digitalWrite(4, 1);
	digitalWrite(5, 1);
	digitalWrite(6, 1);

	usleep(us);

	//9
	digitalWrite(1, 0);
	digitalWrite(4, 1);
	digitalWrite(5, 1);
	digitalWrite(6, 0);

	usleep(us);

	//10
	digitalWrite(1, 0);
	digitalWrite(4, 1);
	digitalWrite(5, 0);
	digitalWrite(6, 1);

	usleep(us);

	//11
	digitalWrite(1, 0);
	digitalWrite(4, 1);
	digitalWrite(5, 0);
	digitalWrite(6, 0);

	usleep(us);

	//12
	digitalWrite(1, 0);
	digitalWrite(4, 0);
	digitalWrite(5, 1);
	digitalWrite(6, 1);

	usleep(us);

	//13
	digitalWrite(1, 0);
	digitalWrite(4, 1);
	digitalWrite(5, 0);
	digitalWrite(6, 0);

	usleep(us);

	//14
	digitalWrite(1, 0);
	digitalWrite(4, 0);
	digitalWrite(5, 0);
	digitalWrite(6, 1);

	usleep(us);

	//15
	digitalWrite(1, 0);
	digitalWrite(4, 0);
	digitalWrite(5, 0);
	digitalWrite(6, 0);

	usleep(us);
	//Create each sequence and count from 0 to 15.
	//Use digitalWrite(PIN, Value);
	
	//Create a 1 second delay after each sequence.
	//Use usleep(us) for the delay.
}

void stop(int sig){exit(1);}
