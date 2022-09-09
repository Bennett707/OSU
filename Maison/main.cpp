#include <iostream>
using namespace std;

int main() {
    
    int Dollars = 100;
    int TDollars = 0;
    int Quarters = 25;
    int TQuarters = 0;
    int Dimes =  10;
    int TDimes = 0;
    int Nickels = 5;
    int TNickels = 0;
    int Pennies = 1;
    int TPennies = 0;
    int userCoin;
   
    cin >> userCoin;
   
    if (userCoin > 0) {
        while (userCoin >= Dollars) {
            userCoin = userCoin - Dollars;
            TDollars = TDollars + 1;
        }
        while (userCoin >= Quarters) {
            userCoin = userCoin - Quarters;
            TQuarters = TQuarters + 1;
        }
        while (userCoin >= Dimes) {
            userCoin = userCoin - Dimes;
            TDimes = TDimes + 1;
        }
        while (userCoin >= Nickels) {
            userCoin = userCoin - Nickels;
            TNickels = TNickels + 1;
          }
        while (userCoin >= Pennies) {
             userCoin = userCoin - Pennies;
             TPennies = TPennies + 1;
          }
       }
       else {
          cout << "No change" << endl;
       }
       
       if (TDollars > 0) {          // Begining of outputting the final numbers
          if (TDollars == 1) {
             cout << TDollars << " Dollar" << endl;
          }
          else {
             cout << TDollars << " Dollars" << endl;
          }
       }
       if (TQuarters > 0) {
          if (TQuarters == 1) {
             cout << TQuarters << " Quarter" << endl;
          }
          else {
             cout << TQuarters << " Quarters" << endl;
          }
       }
       if (TDimes > 0) {
          if (TDimes == 1) {
             cout << TDimes << " Dime" << endl;
          }
          else {
             cout << TDimes << " Dimes" << endl;
          }
       }
       if (TNickels > 0) {
          if (TNickels == 1) {
             cout << TNickels << " Nickel" << endl;
          }
          else {
             cout << TNickels << " Nickels" << endl;
          }
       }
       if (TPennies > 0) {
          if (TPennies == 1) {
             cout << TPennies << " Penny" << endl;
          }
          else {
             cout << TPennies << " Pennies" << endl;
          }
       }

    return 0;
}
