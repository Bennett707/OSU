
#include <stdio.h>
#include <wiringPi.h>
#include <wiringPiI2C.h>
#include <string.h>
#include <chrono>
#include <ratio>
#include <ctime>
#include <iostream>
#include <sstream>
#include <iomanip>
#include <unistd.h>
using namespace std;


// g++ -std=c++14 Lab6EX2.cpp -o Lab6EX2 -lwiringPi

    int status = 0;
void Press_on_off() {

    usleep(100000);
    if(!digitalRead(1)) return;
    if (status == 0) {
        digitalWrite(2, HIGH);
        digitalWrite(3, LOW);
        status = 1;
    }
    else {
        digitalWrite(2, LOW);
        digitalWrite(3, LOW);
        status = 0;
    }
    
}

    int press= 0;
void Press_speed(){

    usleep(100000);
    if(!digitalRead(4)) return;
    if (digitalRead(4) == 1 && press == 0) {
        pwmWrite(26, 500);
        press++;
    }
    else if (digitalRead(4) == 1 && press == 1) {
        pwmWrite(26, 700);
        press++;
    }
    else if (digitalRead(4) == 1 && press == 2) {
        pwmWrite(26, 1000);
        press = 0;
    }
}


int main(void){
    
    wiringPiSetup();
    /* 1. set mode for the three I/O pins, the pin mode of the PWM pin should be PWM_OUTPUT */
    pinMode(1, INPUT);
    pinMode(4, INPUT);
    pinMode(2, OUTPUT);
    pinMode(3, OUTPUT);
    pinMode(26, PWM_OUTPUT);

    wiringPiISR(1, INT_EDGE_RISING, &Press_on_off);
    wiringPiISR(4, INT_EDGE_RISING, &Press_speed);

    while(1){
       
    // control the motor using two buttons 

    }
    return 0;
}

