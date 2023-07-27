fun main() {
    var plainText = "hello9world"
    var cipherAlphabet = "bjosxcqukmrhgeynazldwfpvti"
    println(substitutionCipher(plainText, cipherAlphabet))  // Outputs: ""
    
    plainText = "helloworld"
    cipherAlphabet = "mpgzkeyrsxfwIvjbcnuidhoqat"
    println(substitutionCipher(plainText, cipherAlphabet))  // Outputs: rkwwjojnwz
}

fun substitutionCipher(text: String, cipherAlphabet: String): String {
    val standardAlphabet = "abcdefghijklmnopqrstuvwxyz"
    val lookup = mutableMapOf<Char, Char>()

    // Check if cipherAlphabet has exactly 26 letters
    // and also check if cipher alphabet has duplicate characters
    val charSet = mutableSetOf<Char>()
    for (c in cipherAlphabet) {
        if (charSet.contains(c)) {
            return ""
        }
        charSet.add(c)
    }
    if (charSet.size != 26) {
        return ""
    }

    // Create a mapping between the standard alphabet and the cipher alphabet.
    for (i in standardAlphabet.indices) {
        lookup[standardAlphabet[i]] = cipherAlphabet[i]
    }

    val result = StringBuilder()
    for (c in text) {
        if (!lookup.containsKey(c)) { // if the character is not in the lookup table (like a number or special character)
            return ""
        }
        result.append(lookup[c])
    }

    return result.toString()
}
