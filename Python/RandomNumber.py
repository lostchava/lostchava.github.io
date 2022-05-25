#Generates a random number that the user must guess
# Andrew Sprague

#defines basic variables and imports random
import random
guess_right = False

def game():
    #while loop that will keep game running
    while True:
        #whenever the game is played, the number of guesses and correct number is reset
        correct_num = random.randint(1, 100)
        guess_count = 5
        print("I'm thinking of a number between 1 and 100, try and guess it!")

        #Keeps the game running until they get it correct or run out of answers
        while True :

            #tells the user the number of guessses they have remaining and asks for input
            if guess_count == 5:
                guess = int(input("You have {} guesses remaining, give it a shot! Enter number here:".format(guess_count)))
                guess_count -= 1

            #checks if guess is correct and if so ends game
            if guess == correct_num:
                print('You WON!')
                break
            #checks if they have run out of guesses, if so ends game
            elif guess_count == 0:
                print("That wasn't it, the number was {}".format(correct_num))
                break
            #Lets the user know if too high or low, and reduces guess count, continues game
            else:
                if (guess > correct_num):
                    guess = int(input("Too High. Try Again. You have {} guesses remaining:".format(guess_count)))
                elif (guess < correct_num):
                    guess = int(input("Too Low. Try Again. You have {} guesses remaining:".format(guess_count)))
                guess_count = guess_count - 1
                continue

    #checks whether user wants to play again
        check = input("Do you want to quit or start again? enter Y to restart or another key to end: ")
        if check.upper() == "Y":
            continue
        print("Thanks for playing!")
        break
if __name__=='__main__':
    game()