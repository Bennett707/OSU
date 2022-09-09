#!/bin/bash
#Complete the code in Lab1EX4_2.sh so that it scans the state of the 
#button to control the LED. When the button is pressed, the terminal 
#will display “The button is pressed” and the LED will turn on. 
#If not, the terminal will display “The button is not pressed” and the LED will turn off.



# Complete Code: Exports the LED and switch pins to userspace 
echo XX > /sys/class/gpio/export
echo XX > /sys/class/gpio/export



# Complete Code: Sets the two pins as an input and output
echo "XXXX" > /sys/class/gpio/gpioXX/direction
echo "XXXX" > /sys/class/gpio/gpioXX/direction


while [ : ]; do

    # Complete Code: read the button status, and assign /sys/class/gpio/gpioXX/value to a variable
    vari=$(cat /sys/class/gpio/gpioXX/value)
    if [ $vari -eq 1 ]
    then 
        # Complete Code: turn on the led
        # Display “The button is pressed” on the terminal

    else
        # Complete Code: turn off the led
        # Display “The button is not pressed” on the terminal
        
    fi

done

# Complete Code: Unexports the pins 
echo XX > /sys/class/gpio/unexport
echo XX > /sys/class/gpio/unexport
