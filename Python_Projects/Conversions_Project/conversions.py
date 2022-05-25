# Andrew Sprague


#Imports to top-level module

# converts yards into meters
def yards():
    yards = float(input("Enter the distance in yards: "))
    meter = yards / 1.094
    print("Distance in meters %0.2f" % meter)

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

    print("The distance is %i in inches." % d_inches)


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



#Conversion tests
    
def test():
    print("Testing conversion module")
# converts yards into meters

    yards = 1
    meter = yards / 1.094
    print("One yard is equal to %0.2f meters." % meter)

# converts USD to Russian Ruble

    ruble = 1
    usd = ruble * 137.5
    print("One dollar is $%.2f in rubles." % usd)


# USD to Euro

    usd = 1
    euro = usd * 0.92
    print("One dollar is $%.2f in Euros." % euro)


# feet to inches

    feet = 1
    d_inches = feet * 12

    print("One foot is %i inches." % d_inches)
