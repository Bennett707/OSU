
//Use g++ -std=c++11 -o Lab3EX2 Lab3EX2.cpp -lwiringPi
//Differential, 4.096

#include <iostream>
#include <iomanip>
#include <unistd.h>
#include <wiringPi.h>
#include <wiringPiI2C.h>
#include <signal.h>
#include <stdlib.h>
using namespace std;


int adcVal();
int adc;
void stop(int);
double Volts;
double milliVolts;

int main(){
	//Initialize the wiringPi Library.
	wiringPiSetup();

	while(true){
		signal(SIGINT, stop);
		
		Volts = adcVal(); //Read value from ADC
		
		cout << "The Analog input Voltage is " << Volts << endl; //Print value to screen.

		milliVolts = (Volts / 2047) * 4096; //Convert data to milliVolts.

		cout << "The Analog input Voltage in mV is " << milliVolts << endl; // Print milliVolt Value

		delay (100); //Slow the script speed down to gain better measurements.

		
	}
}



//This function is used to read data from ADC1015
int adcVal(){

	uint16_t low, high, value;
    // Refer to the supplemental documents to find the parameters.
	adc = wiringPiI2CSetup(0x48);

	wiringPiI2CWriteReg16(adc, 0x01, 0xc583);
	usleep(1000);
    uint16_t data = wiringPiI2CReadReg16(adc, 0x00);

	// Similarly, we reversed the high 8-bit and low 8-bit of the output data.
    low = (data & 0xFF00) >> 8;
    high = (data & 0x00FF) << 8;
    value = (high | low)>>4;
	if (value > 0x07FF)
        {
            value |= 0xF000;
        }
	return (int16_t) value;
}


void stop(int sig){exit(1);}