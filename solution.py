def substitutionCipher(text, cipherAlphabet):
    standardAlphabet = 'abcdefghijklmnopqrstuvwxyz'
    lookup = {}

    # Check if cipherAlphabet has exactly 26 letters
    # and also check if cipher alphabet has duplicate characters
    charSet = set()
    for char in cipherAlphabet:
        if char in charSet:
            return ''
        charSet.add(char)
    if len(charSet) != 26:
        return ''

    # Create a mapping between the standard alphabet and the cipher alphabet.
    for i in range(len(standardAlphabet)):
        lookup[standardAlphabet[i]] = cipherAlphabet[i]

    result = ''
    for char in text:
        if char not in lookup: # if the character is not in the lookup table (like a number or special character)
            return ''
        result += lookup[char]

    return result

plainText = 'hello9world'
cipherAlphabet = 'bjosxcqukmrhgeynazldwfpvti'

print(substitutionCipher(plainText, cipherAlphabet))  # Outputs: ""

plainText = 'helloworld'
cipherAlphabet = 'mpgzkeyrsxfwIvjbcnuidhoqat'

print(substitutionCipher(plainText, cipherAlphabet))  # Outputs: rkwwjojnwz
