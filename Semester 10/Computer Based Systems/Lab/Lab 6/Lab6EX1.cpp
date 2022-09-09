
#include <wiringPi.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;



// g++ -std=c++14 Lab6EX1.cpp -o Lab6EX1 -lwiringPi

int main(void){
    
    wiringPiSetup();

    pinMode(2, OUTPUT);
    pinMode(3, OUTPUT);
    pinMode(26, PWM_OUTPUT);
    /* 1. set mode for the three pins, the pin mode of the PWM pin should be PWM_OUTPUT */
    


	/* 2. write HIGH or LOW to the two I/O pins to control the rotation direction */
    digitalWrite(2, LOW);
    digitalWrite(3, HIGH);

    

    
    /* 3. use function pwmWrite to control the motor speed. Refer to document pwm.pdf for more information. */
    pwmWrite(26, 700);

    while (true){

    }
    //tips:	run the code using sudo ./Lab6EX1

    return 0;
}

