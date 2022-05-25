# Andrew Sprague

from conversions import *

#Shows user the menu.
def menu():
    print("Press a number to select!")
    print("1. Convert yards to meters.")
    print("2. Convert feet to inches.")
    print("3. Convert miles to kilometers")
    print("4. Convert celsius to fahrenheit.")
    print("5. Convert usd to ruble.")
    print("6. Convert usd to euro.")
    print("7. To exit the program.")    

def conversions():
    while True:
        menu()
        user_input = int(input())
        if user_input == 1:
            yards()
            continue
            menu()
        if user_input == 2:
            feet()
            continue
            menu()
        if user_input == 3:
            distance()
            continue
            menu()
        if user_input == 4:
            celsius()
            continue
            menu()
        if user_input == 5:
            ruble()
            continue
            menu()
        if user_input == 6:
            euro()
            continue
            menu()
        if user_input == 7:
            print("GoodBye")
            break

if __name__ == '__main__':
    conversions()