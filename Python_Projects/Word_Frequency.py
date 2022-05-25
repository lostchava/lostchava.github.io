#Andrew Sprague

def total_word_count(string):
    '''This function counts how many words are in the string given to it. To use it call the function with an arguement that is a string of words.'''
    total = (len(string.split(" ")))
    return(total)


def unique_word_count_ignore_case(text):
    '''This function counts the unique words ignoring case. To use it call the function with an arguement that is a string of words.'''
    unique_words = text.lower().split(' ')
    unique_words2 = []
    for word in unique_words:
         new_word = word.strip('.,!;?')
         unique_words2.append(new_word)
        
    unique =[]
    for word in unique_words2:
        if word not in unique:
            unique.append(word)
    
    return(len(unique))


def word_frequency_ignore_case(text):
    '''This function counts word frequency and puts it into a dictionary. To use it call the function with an arguement that is a string of words.'''
    unique_words = text.lower().split(' ')
    unique_words2 = []
    for word in unique_words:
         new_word = word.strip('.,!;?')
         unique_words2.append(new_word)
        
    
    unique ={}
    for word in unique_words2:
        if word not in unique:
            unique[word] = 1
        else:
            unique[word] += 1
    return (unique)

def print_frequencies(new_dict, x):
    '''This function takes in a dictionary and a value. Outputs words with frequencies greater than the value given. Then sorts them into two collums. '''
    print("Word frequencies greater than {}:".format(x))
    for key, value in new_dict.items():
        if value > x:       
            print("%-15s %-15s" %(key, value))
    


def top_level():
    '''Top-level module that runs the script and calls upon the functions above.'''
    words = "The governing wisdom about writing sentences says not to repeat. Repetition is bad. Repetition is sloppy. Writers are encouraged to consult a thesaurus and change up that pesky offending word. But is this really true? Literature is full of repetition. Literary writers constantly use the literary device of repeated words. I think the only type of repetition which is bad is sloppy repetition. Repetition which is unintentional, which sounds awkward. If you repeat on purpose, repetition is gorgeous. I mean, think about music. Music is all about repetition and patterns. If you didn’t have repetition in music, it would all just be noise."
    print("Total word count:", total_word_count(words))
    print("Unique word count:", unique_word_count_ignore_case(words))
    print_frequencies(word_frequency_ignore_case(words), 1)

 

if __name__ == '__main__':
    top_level()
    
