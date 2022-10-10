package connectfour

class Player {
    var name: String = ""
    var score: Int = 0
    var didLastStep = false
}

fun initBoard(board: MutableList<MutableList<String>>, dimensionX: Int, dimensionY: Int) {
    board.clear()
    for (i in 0 until dimensionX) {
        board.add(mutableListOf<String>())
        for (j in 0 until dimensionY) {
            board[i].add(j, " ")
        }
    }
}

fun printBoard(rows: Int = 6, columns: Int = 7, board: MutableList<MutableList<String>>) {
    for (i in 1..columns) {
        print(" ${i}")
    }
    println("")

    val verticaLine: Char = '\u2551'
    val horizontalLine: Char = '\u2550'
    val doubleUpLine: Char = '\u2569'
    val leftCorner = '\u255A'
    val rightCorner = '\u255D'

    for (i in 0..rows - 1) {
//        print("${i} ")
        for (j in 0..columns - 1) {
            print(verticaLine + board[i][j])
        }
        println("${verticaLine}")
    }
    print(leftCorner)
    for (i in 1..columns) {
        if (i != columns) {
            print("${horizontalLine}${doubleUpLine}")
        } else {
            println("${horizontalLine}${rightCorner}")
        }
    }
}

fun checkingWinningByHorizontal(board: MutableList<MutableList<String>>, gamer: Player, position: MutableList<Int>, disc: String): Boolean {
    var discCounter = 0
    var row = position[0]
    var column = position[1]

    // horizontal to right
    for (i in column + 1 until board[row].size) {
        if (board[row][i] == disc) {
            discCounter++
        } else break
    }
    if (discCounter >= 3) {
        println("Player ${gamer.name} won")
        gamer.score += 2
        return true
    } else {
        // horizontal to left
        for (i in column - 1 downTo 0) {
            if (board[row][i] == disc) {
                discCounter++
            } else break
        }
        if (discCounter >= 3) {
            println("Player ${gamer.name} won")
            gamer.score += 2
            return true
        }
    }
    return false
}

fun checkingWinningByVertical(board: MutableList<MutableList<String>>, gamer: Player, position: MutableList<Int>, disc: String): Boolean {
    var discCounter = 0
    var row = position[0]
    var column = position[1]

    // to up
    for (i in row - 1 downTo 0) {
        if (board[i][column] == disc) {
            discCounter++
        } else break
    }
    if (discCounter >= 3) {
        println("Player ${gamer.name} won")
        return true
    } else {
        for (i in row + 1 until board.size) {
            if (i < board.size) {
                if (board[i][column] == disc) {
                    discCounter++
                } else break
            }
        }
        if (discCounter >= 3) {
            println("Player ${gamer.name} won")
            gamer.score += 2
            return true
        }
    }
    return false
}

fun checkingWinningByDiagonalFromBottomLeftToTopRight(board: MutableList<MutableList<String>>, gamer: Player, position: MutableList<Int>, disc: String): Boolean {
    var discCounter = 0
    var row = position[0]
    var column = position[1]
    var shift = 1

    for (i in row - 1 downTo 0) {
        if (column + shift <= board.size - 1) {
            if (board[i][column + shift] == disc) {
                discCounter++
                shift++
            } else {
                shift = 1
                break
            }
        }
    }
    if (discCounter >= 3) {
        println("Player ${gamer.name} won")
        gamer.score += 2
        return true
    } else {
        for (i in row + 1 until board.size) {
            if (i <= board.size - 1 && column - shift >= 0) {
                if (board[i][column-shift] == disc) {
                    discCounter++
                    shift++
                } else break
            }
        }
        if (discCounter >= 3) {
            println("Player ${gamer.name} won")
            gamer.score += 2
            return true
        }
    }
    return false
}

fun checkingWinningByDiagonalFromTopLeftToBottomRight(board: MutableList<MutableList<String>>, gamer: Player, position: MutableList<Int>, disc: String): Boolean {
    var discCounter = 0
    var row = position[0]
    var column = position[1]
    var shift = 1

    for (i in row - 1 downTo 0) {
        if (column - shift >= 0) {
            if (board[i][column - shift] == disc) {
                discCounter++
                shift++
            } else {
                shift = 1
                break
            }
        }
    }
    if (discCounter >= 3) {
        println("Player ${gamer.name} won")
        gamer.score += 2
        return true
    } else {
        for (i in row + 1 until board.size) {
            if (i <= board.size - 1 && column + shift <= board.size - 1) {
                if (board[i][column + shift] == disc) {
                    discCounter++
                    shift++
                } else break
            }
        }
        if (discCounter >= 3) {
            println("Player ${gamer.name} won")
            gamer.score += 2
            return true
        }
    }
    return false
}

fun isBoardFilled(board: MutableList<MutableList<String>>): Boolean {
    for (i in 0..board.size - 1) {
        for (j in 0..board[i].size - 1) {
            if (board[i][j] == " ") {
                return false
            }
        }
    }
    return true
}

fun fillBoard(dimensionX: Int, dimensionY: Int, board: MutableList<MutableList<String>>, gamers: MutableList<Player>): Boolean {
    var gamerIndex = 0

    if (gamers[0].score > gamers[1].score) {
        gamerIndex = 1
    } else if (gamers[0].score < gamers[1].score) {
        gamerIndex = 0
    } else if (gamers[0].score == gamers[1].score && gamers[0].didLastStep) {
        gamerIndex = 1
    } else gamerIndex = 0

    var isEnd = false
    var isStop = false
    var isColumnFull = false
    var position: String = ""

    do {
        if (gamerIndex > 1) {
            gamerIndex = 0
        } else {
            print("${gamers[gamerIndex].name}'s turn: ")
            position = readln()
            if (position.lowercase() == "end") {
                isEnd = true
                return true
            } else try {
                if (position.toInt() > 0 && position.toInt() <= dimensionY) {
                    if (board[0][position.toInt() - 1] == " ") {
                        isColumnFull = false
                    } else {
                        isColumnFull = true
                    }
                    if (isColumnFull == true) {
                        println("Column ${position.toInt()} is full")
                    } else {
                        try {
                            if (position.toInt() > dimensionY) {
                                println("The column number is out of range (1 - ${dimensionY})")
                            } else {
                                isStop = false
                                for (i in dimensionX - 1 downTo 0) {
                                    if (board[i][position.toInt() - 1] == " " && isStop == false) {
                                        if (gamerIndex == 0) {
                                            board[i][position.toInt() - 1] = "o"
                                            printBoard(dimensionX.toInt(), dimensionY.toInt(), board)
                                            isEnd = checkingWinningByHorizontal(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "o")
                                            if (isEnd == false) {
                                                isEnd = checkingWinningByVertical(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "o")
                                                if (isEnd == false) {
                                                    isEnd = checkingWinningByDiagonalFromBottomLeftToTopRight(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "o")
                                                    if (isEnd == false) {
                                                        isEnd = checkingWinningByDiagonalFromTopLeftToBottomRight(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "o")
                                                    }
                                                    if (isEnd == false) {
                                                        if (isBoardFilled(board) == true){
                                                            println("It is a draw")
                                                            gamers[0].didLastStep = true
                                                            gamers[1].didLastStep = false
                                                            gamers[0].score += 1
                                                            gamers[1].score += 1
                                                            isEnd = true
                                                            //println("Game Over!")
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            board[i][position.toInt() - 1] = "*"
                                            printBoard(dimensionX.toInt(), dimensionY.toInt(), board)
                                            isEnd = checkingWinningByHorizontal(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "*")
                                            if (isEnd == false) {
                                                isEnd = checkingWinningByVertical(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "*")
                                                if (isEnd == false) {
                                                    isEnd = checkingWinningByDiagonalFromBottomLeftToTopRight(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "*")
                                                    if (isEnd == false) {
                                                        isEnd = checkingWinningByDiagonalFromTopLeftToBottomRight(board, gamers[gamerIndex], mutableListOf<Int>(i, position.toInt() - 1), "*")
                                                    }
                                                    if (isEnd == false) {
                                                        if (isBoardFilled(board) == true){
                                                            println("It is a draw")
                                                            gamers[1].didLastStep = true
                                                            gamers[0].didLastStep = false
                                                            gamers[0].score += 1
                                                            gamers[1].score += 1
                                                            isEnd = true
                                                            //println("Game Over!")
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        isStop = true
                                    }
                                }
                                gamerIndex++
                            }
                        } catch (e: NumberFormatException) {
                            println("Incorrect column number")
                        } catch (e: ArrayIndexOutOfBoundsException) {
                            println("Incorrect column number")
                        }
                    }
                } else {
                    println("The column number is out of range (1 - ${dimensionY})")
                }
            } catch (e: NumberFormatException) {
                println("Incorrect column number")
            }
        }
    } while (!isEnd)

    return false
}

fun setNumberOfGames(): String {
    var number = ""
    var isStop = false

    while (!isStop){
        println("Do you want to play single or multiple games?\nFor a single game, input 1 or press Enter\nInput a number of games:")
        number = readln()
        try {
            if (number.isBlank() || number.toInt() == 1) {
                return "1"
            } else if (!number.all { char -> char.isDigit() } || number.toInt() <= 0){
                println("Invalid input")
            } else {
                return number
            }
        } catch (ex: NumberFormatException) {
            println("Invalid input")
        }
    }

    return number
}

fun main() {
    val gamers = mutableListOf<Player>()
    var rows: Int
    var columns: Int
    var boardDimension: String
    var isStopSignal: Boolean = false
    var board = mutableListOf<MutableList<String>>()
    var numberOfGames = 0

    println("Connect Four")

    print("First player's name: ")
    val first_player = Player()
    first_player.name = readln()

    print("Second player's name: ")
    val second_player = Player()
    second_player.name = readln()

    gamers.add(0, first_player)
    gamers.add(1, second_player)

    while (isStopSignal == false) {
        println("Set the board dimensions (Rows x Columns)")
        println("Press Enter for default (6 x 7)")
        boardDimension = readln()
        boardDimension = boardDimension.replace("\\s".toRegex(), "").uppercase()
        var dimensionX = boardDimension.substringBefore("X")
        var dimensionY = boardDimension.substringAfter("X")
        var isCorrectFormat = boardDimension.contains("^\\d+X\\d+$".toRegex())

        if (boardDimension.isEmpty()) {
            numberOfGames = setNumberOfGames().toInt()
            println("${first_player.name} VS ${second_player.name}")
            println("6 X 7 board")
            if (numberOfGames == 1) {
                println("Single game")
                initBoard(board, 6, 7)
                printBoard(6, 7, board)
                isStopSignal = fillBoard(6, 7, board, gamers)
                if (isStopSignal == true) {
                    println("Game over!")
                    break
                }
                isStopSignal = true
            } else {
                println("Total $numberOfGames games")
                var gamesCounter = 1
                while (numberOfGames > 0) {
                    println("Game #$gamesCounter")
                    initBoard(board, 6, 7)
                    printBoard(6, 7, board)
                    isStopSignal = fillBoard(6, 7, board, gamers)
                    if (isStopSignal == true) {
                        break
                    }
                    println("Score\n${gamers[0].name}: ${gamers[0].score} ${gamers[1].name}: ${gamers[1].score}")
                    numberOfGames--
                    gamesCounter++
                }
                println("Game over!")
                isStopSignal = true
            }
        } else if (isCorrectFormat == false) {
            println("Invalid input")
        } else if (dimensionX.isEmpty() || dimensionY.isEmpty()) {
            if (dimensionX.isEmpty()) {
                println("Board rows should be from 5 to 9")
            } else {
                println("Board columns should be from 5 to 9")
            }
        } else {
            rows = dimensionX.toInt()
            columns = dimensionY.toInt()
            if ((rows in 5..9) && (columns in 5..9)) {
                numberOfGames = setNumberOfGames().toInt()
                println("${first_player.name} VS ${second_player.name}")
                println("${rows} X ${columns} board")
                if (numberOfGames == 1) {
                    println("Single game")
                    initBoard(board, rows, columns)
                    printBoard(rows, columns, board)
                    isStopSignal = fillBoard(rows, columns, board, gamers)
                    if (isStopSignal == true) {
                        println("Game over!")
                        break
                    }
                } else {
                    println("Total $numberOfGames games")
                    var gamesCounter = 1
                    while (numberOfGames > 0) {
                        println("Game #$gamesCounter")
                        initBoard(board, rows, columns)
                        printBoard(rows, columns, board)
                        isStopSignal = fillBoard(rows, columns, board, gamers)
                        if (isStopSignal == true) {
                            break
                        }
                        println("Score")
                        println("${gamers[0].name}: ${gamers[0].score} ${gamers[1].name}: ${gamers[1].score}")
                        numberOfGames--
                        gamesCounter++
                    }
                    println("Game over!")
                    isStopSignal = true
                }
            } else if (rows !in 5..9) {
                println("Board rows should be from 5 to 9")
            } else if (columns !in 5..9) {
                println("Board columns should be from 5 to 9")
            }
        }
    }
}