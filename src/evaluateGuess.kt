package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0; var wrongPosition = 0
    val rightIndices = mutableSetOf<Int>()
    val wrongIndices = mutableSetOf<Int>()

    for (i in secret.indices)
        if (guess[i] == secret[i]) {
            rightPosition++
            rightIndices.add(i)
        }

    for (i in secret.indices )
        if (i !in rightIndices)
            for (j in guess.indices)
                if (j !in rightIndices && j !in wrongIndices && guess[i] == secret[j]) {
                    wrongPosition++
                    wrongIndices.add(j)
                    break
                }

    return Evaluation(rightPosition, wrongPosition)
}
