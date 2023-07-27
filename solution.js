function substitutionCipher(text, cipherAlphabet) {
    const standardAlphabet = 'abcdefghijklmnopqrstuvwxyz';
    let lookup = {};

    // Check if cipherAlphabet has exactly 26 letters
    // and also check if cipher alphabet has duplicate characters
    let charSet = new Set();
    for (let char of cipherAlphabet) {
        if (charSet.has(char)) {
            return '';
        }
        charSet.add(char);
    }
    if (charSet.size != 26) {
        return '';
    }

    // Create a mapping between the standard alphabet and the cipher alphabet.
    for (let i = 0; i < standardAlphabet.length; i++) {
        lookup[standardAlphabet[i]] = cipherAlphabet[i];
    }

    let result = '';
    for (let char of text) {
        if(!lookup[char]) { // if the character is not in the lookup table (like a number or special character)
            return '';
        }
        result += lookup[char];
    }

    return result;
}

let plainText = 'hello9world';
let cipherAlphabet = 'bjosxcqukmrhgeynazldwfpvti';

console.log(substitutionCipher(plainText, cipherAlphabet));  // Outputs: ""

plainText = 'helloworld';
cipherAlphabet = 'mpgzkeyrsxfwIvjbcnuidhoqat';

console.log(substitutionCipher(plainText, cipherAlphabet));  // Outputs: rkwwjojnwz
