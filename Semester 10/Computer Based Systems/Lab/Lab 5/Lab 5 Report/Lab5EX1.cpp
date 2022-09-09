// Frank
// Lab 5, Exercise 1
// g++ -std=c++14 Lab5EX1.cpp -o Lab5EX1 

#include <stdio.h>
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


// Global variables
high_resolution_clock::time_point begin_time;
unsigned int counter;

int main() {

    begin_time = high_resolution_clock::now();

    // Get hit time, increment counter
    high_resolution_clock::time_point hit_time; 

    for (int i = 0; i < 30; i++) {

        /* Complete the code: delay 1 second */
        sleep(1);


        /* Complete the code: increase counter  */
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
        /* Complete the code: use if statement or switch statement to print the placement of counter, 
           Notice: 1 : 1st place: MM:SS:XXX
                   2 : 2nd place: MM:SS:XXX
                   3 : 3rd place: MM:SS:XXX
                   4 : 4th place: MM:SS:XXX
           */


        /* Complete the code: display the time on monitor */

        /*
        Tips:
        1) Complete the code in lab_util.cpp, Use sprintf() or  std::setfill(‘0’), std::setw(2) to get the time format
        2) Include the file lab_util.cpp in the Lab5Ex1.cpp
        3) Use formatTime() in lab_util.cpp to get the time difference, using hit_time and begin_time
        4) Use switch statement to format and print the placement of the time
         */

    }

    return 0;
}

