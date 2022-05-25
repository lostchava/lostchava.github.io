# Andrew Sprague

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
# converts yards into meters
def yards():
    yards = float(input("Enter the distance in yards: "))
    meter = yards / 1.094
    print("Distance in meters : ", meter)

# converts USD to Russian Ruble
def ruble():
    ruble = float(input("Enter the Dollar value:"))
    usd = ruble * 137.5
    print("The dollar value is $%.2f in rubles" % usd)


# USD to Euro
def euro():
    usd = float(input("Enter the dollar value:"))
    euro = usd * 0.92
    print("The dollar value is $%.2f in Euros" % euro)


# feet to inches
def feet():
    feet = float(input("Enter Feet:"))
    d_inches = feet * 12

    print("The distance is %i  in inches." % d_inches)


# celsius to fahrenheit
def celsius():
    celsius = float(input("Enter Celsius:"))

    fahrenheit = (celsius * 1.8) + 32
    print('%0.1f degree Celsius is equal to %0.1f degree Fahrenheit' % (celsius, fahrenheit))


# Miles to Kilometers
def distance():
    miles = float(input("Enter the Miles = "))

    kilometers = miles * 1.6093435

    print("%.2f Miles equals %.2f Kilometers " % (miles, kilometers))




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