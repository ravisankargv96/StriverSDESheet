'''

    Time Complexity: O(N * (2 ^ (N - 1)))
    Space Complexity: O(N* (2 ^ (N - 1))
    
    Where N is the length of the string S.
'''


def wordBreakHelper(s, idx, dictSet, size):

    # Base Condition
    if (idx == size):
        return [""]

    subPart, completePart = [], []
    word = ""

    '''
        Start exploring the sentence from the index until we wouldn't find 'j' 
        such that substring [index,j] exists in the dictionary as a word.
    '''
    for j in range(idx, size):

        word += s[j]
        if (word not in dictSet):
            continue

        #  Get the answer for rest of sentence from 'j' to len(s).
        subPart = wordBreakHelper(s, j + 1, dictSet, size)

        #  Append "word" with all the answer that we got.
        for i in range(len(subPart)):

            if (len(subPart[i]) != 0):
                subPart[i] = word + " " + subPart[i]

            else:
                subPart[i] = word

        for i in range(len(subPart)):
            completePart.append(subPart[i])

    return completePart


def wordBreak(s, dictionary):

    #  Set to check the whether any word exists in the dictionary or not.
    dictSet = set()

    for i in range(len(dictionary)):
        dictSet.add(dictionary[i])

    return wordBreakHelper(s, 0, dictSet, len(s))
