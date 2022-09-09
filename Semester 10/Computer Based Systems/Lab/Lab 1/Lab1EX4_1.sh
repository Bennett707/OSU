#!/bin/bash
#  Please refer to the book "Exploring Raspberry Pi" chapter 6

# XX is the pin number, you need to replace it.

# Complete Code: Exports pin to userspace
echo XX > /sys/class/gpio/export

# Complete Code: Set pin as an output
echo "XXXX" > /sys/class/gpio/gpioXX/direction
while [ : ]; do
    # Complete Code: turn on the LED
    echo X > /sys/class/gpio/gpioXX/value

    # Complete Code: delay for 100 ms

    # Complete Code: turn off the LED
    echo X > /sys/class/gpio/gpioXX/value

    # Complete Code: delay for 100 ms

done

# Complete Code: Unexports pin to userspace
echo XX > /sys/class/gpio/unexport
