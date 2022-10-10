fun main() {
    // put your code here
    val alphabet = mutableListOf<Char>(
        'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z'
    )

    val word = readln().lowercase()

    for (i in 0..alphabet.size - 1) {
        for (j in 0..word.length - 1) {
            if (alphabet[i] == word[j]) {
                break
            } else if (j == word.length - 1) {
                print(alphabet[i])
            }
        }
    }
}