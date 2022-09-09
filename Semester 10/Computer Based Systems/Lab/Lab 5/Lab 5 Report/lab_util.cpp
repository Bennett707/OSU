// Frank
// Lab 5, lab_util.h

#include <stdio.h>
#include <string.h>
#include <chrono>
#include <ratio>
#include <ctime>
#include <iostream>
#include <sstream>
#include <iomanip>
#include <unistd.h>

using namespace std::chrono;
using namespace std;

std::string formatTime(high_resolution_clock::time_point t_begin, high_resolution_clock::time_point t_end);

/* Complete the code: return the difference of t_begin and t_end in the "MM:SS:XXX" format */
std::string formatTime(high_resolution_clock::time_point t_begin, high_resolution_clock::time_point t_end) {


	duration<double> time_span = duration_cast<duration<double>>(t_end - t_begin);


	double t_total = time_span.count();
	int min = int(t_total) / 60;
	int sec = int(t_total) % 60;
	int millisec = (t_total - min * 60 - sec) * 1000;

	char str[10];
	sprintf(str, "%02d:%02d:%03d", min, sec, millisec);

	return str;
	/* Tips:
	   1) Get the time difference of t_begin and t_end
	   2) Convert the time difference to 3 parts: MM, SS, XXX
	   3) Use sprintf() to generate the format time and return it
	*/

}
