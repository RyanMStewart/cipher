package main

import (
	"fmt"
	"strings"
)

func substitutionCipher(text, cipherAlphabet string) string {
	const standardAlphabet = "abcdefghijklmnopqrstuvwxyz"
	lookup := make(map[rune]rune)

	// Check if cipherAlphabet has exactly 26 letters
	// and also check if cipher alphabet has duplicate characters
	charSet := make(map[rune]bool)
	for _, char := range cipherAlphabet {
		if _, ok := charSet[char]; ok {
			return ""
		}
		charSet[char] = true
	}
	if len(charSet) != 26 {
		return ""
	}

	// Create a mapping between the standard alphabet and the cipher alphabet.
	for i, char := range standardAlphabet {
		lookup[char] = rune(cipherAlphabet[i])
	}

	result := ""
	for _, char := range text {
		if val, ok := lookup[char]; !ok { // if the character is not in the lookup table (like a number or special character)
			return ""
		} else {
			result += string(val)
		}
	}

	return result
}

func main() {
	plainText := "hello9world"
	cipherAlphabet := "bjosxcqukmrhgeynazldwfpvti"

	fmt.Println(substitutionCipher(plainText, cipherAlphabet))  // Outputs: ""
}
