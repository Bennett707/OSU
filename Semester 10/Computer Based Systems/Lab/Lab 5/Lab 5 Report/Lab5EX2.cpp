// Frank
// Lab 5, Exercise 2
// g++ -std=c++14 Lab5EX2.cpp -o Lab5EX2 -lwiringPi

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
#include "lab_util.cpp"
/* Complete the code: include the file lab_util.cpp  */
//#include "lab_util.cpp"

using namespace std::chrono;
using namespace std;


/* Complete the code: Set button pin */
int BUTTON = 26;

// State enum definition
enum State {
	STOPPED,
	RUNNING,
	RESET
};

// Global variables
State state;
high_resolution_clock::time_point begin_time;
unsigned int counter;

/* Complete the code, implement the timer */
void press_button() {

    

    if (state == STOPPED) {
        begin_time = high_resolution_clock::now();
        state = RUNNING;
    } 
    else if (state == RUNNING) {

        high_resolution_clock::time_point hit_time;



        /* increase counter  */
        counter++;

        hit_time = high_resolution_clock::now();


        // Calculate elapsed time, formatted as MM:SS:XXX
        string timestamp = formatTime(begin_time, hit_time);

        if (counter % 10 == 1 && counter != 11) {
            cout << counter << " : " << counter << "st place: " << timestamp << endl;
        }
        else if (counter % 10 == 2 && counter != 12) {
            cout << counter << " : " << counter << "nd place: " << timestamp << endl;
        }
        else if (counter % 10 == 3 && counter != 13) {
            cout << counter << " : " << counter << "rd place: " << timestamp << endl;
        }
        else {
            cout << counter << " : " << counter << "th place: " << timestamp << endl;
        }

        int reset_counter = 0;
        double sleep_duration = 1;

        while (digitalRead(26)) {
            sleep(sleep_duration);
            reset_counter++;
            if (reset_counter > 4 / sleep_duration) {
                state = RESET;
                counter = 0;
                cout << "Reset" << endl;
                
                break;
            }
        }
        if (state == RESET) {
            state = STOPPED;
    
        }

    }

     
}


int main(){

    // Set up WiringPi
    if (wiringPiSetup () == -1) exit (1);

    state = STOPPED;
    counter = 0;
    unsigned int button_time = 0;

    cout << "Holding for long time to reset" << endl;


    /* Complete the code to implement the timer  */
    pinMode(26, INPUT);

    wiringPiISR(26, INT_EDGE_RISING, &press_button);

    while (true) {

    }

    /*
    Tips:
    1) Set digital pins to input, Use pinMode(PIN, MODE)
    2) Use wiringPiISR() to get the interupt
    3) Read the state of pin: digitalRead(PIN)
    4) Use delay() to set a delay
    5) Define the state for the timer
    6) Use the formatTime() in lab_util.cpp
    */


    return 0;
}