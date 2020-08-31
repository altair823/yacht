/*
Latest update: 20-08-31 09:53

Contributor: altair823

Description:
    Date for brute force point-checking algorithm.
    Compare with current dice which player rolled, and if there be the same dice numbers,
    system knows player has point which is matched with current dice.
 */

package algorithm

//checking four of a kind with brute force is unable
val bruteForceDataFK1 = listOf(1, 1, 1, 1)
val bruteForceDataFK2 = listOf(2, 2, 2, 2)
val bruteForceDataFK3 = listOf(3, 3, 3, 3)
val bruteForceDataFK4 = listOf(4, 4, 4, 4)
val bruteForceDataFK5 = listOf(5, 5, 5, 5)
val bruteForceDataFK6 = listOf(6, 6, 6, 6)
val bruteForceDataFK = listOf<List<Int>>(
        bruteForceDataFK1, bruteForceDataFK2, bruteForceDataFK3,
        bruteForceDataFK4, bruteForceDataFK5, bruteForceDataFK6
)


val bruteForceDataFH11 = listOf(1, 1, 1, 2, 2)
val bruteForceDataFH12 = listOf(1, 1, 1, 3, 3)
val bruteForceDataFH13 = listOf(1, 1, 1, 4, 4)
val bruteForceDataFH14 = listOf(1, 1, 1, 5, 5)
val bruteForceDataFH15 = listOf(1, 1, 1, 6, 6)

val bruteForceDataFH21 = listOf(2, 2, 2, 1, 1)
val bruteForceDataFH22 = listOf(2, 2, 2, 3, 3)
val bruteForceDataFH23 = listOf(2, 2, 2, 4, 4)
val bruteForceDataFH24 = listOf(2, 2, 2, 5, 5)
val bruteForceDataFH25 = listOf(2, 2, 2, 6, 6)

val bruteForceDataFH31 = listOf(3, 3, 3, 1, 1)
val bruteForceDataFH32 = listOf(3, 3, 3, 2, 2)
val bruteForceDataFH33 = listOf(3, 3, 3, 4, 4)
val bruteForceDataFH34 = listOf(3, 3, 3, 5, 5)
val bruteForceDataFH35 = listOf(3, 3, 3, 6, 6)

val bruteForceDataFH41 = listOf(4, 4, 4, 1, 1)
val bruteForceDataFH42 = listOf(4, 4, 4, 2, 2)
val bruteForceDataFH43 = listOf(4, 4, 4, 3, 3)
val bruteForceDataFH44 = listOf(4, 4, 4, 5, 5)
val bruteForceDataFH45 = listOf(4, 4, 4, 6, 6)

val bruteForceDataFH51 = listOf(5, 5, 5, 1, 1)
val bruteForceDataFH52 = listOf(5, 5, 5, 2, 2)
val bruteForceDataFH53 = listOf(5, 5, 5, 3, 3)
val bruteForceDataFH54 = listOf(5, 5, 5, 4, 4)
val bruteForceDataFH55 = listOf(5, 5, 5, 6, 6)

val bruteForceDataFH61 = listOf(6, 6, 6, 1, 1)
val bruteForceDataFH62 = listOf(6, 6, 6, 2, 2)
val bruteForceDataFH63 = listOf(6, 6, 6, 3, 3)
val bruteForceDataFH64 = listOf(6, 6, 6, 4, 4)
val bruteForceDataFH65 = listOf(6, 6, 6, 5, 5)
val bruteForceDateFH = listOf<List<Int>>(
        bruteForceDataFH11, bruteForceDataFH12, bruteForceDataFH13, bruteForceDataFH14, bruteForceDataFH15,
        bruteForceDataFH21, bruteForceDataFH22, bruteForceDataFH23, bruteForceDataFH24, bruteForceDataFH25,
        bruteForceDataFH31, bruteForceDataFH32, bruteForceDataFH33, bruteForceDataFH34, bruteForceDataFH35,
        bruteForceDataFH41, bruteForceDataFH42, bruteForceDataFH43, bruteForceDataFH44, bruteForceDataFH45,
        bruteForceDataFH51, bruteForceDataFH52, bruteForceDataFH53, bruteForceDataFH54, bruteForceDataFH55,
        bruteForceDataFH61, bruteForceDataFH62, bruteForceDataFH63, bruteForceDataFH64, bruteForceDataFH65
)

val bruteForceDataSS1 = listOf<Int>(1, 2, 3, 4)
val bruteForceDataSS2 = listOf<Int>(2, 3, 4, 5)
val bruteForceDataSS3 = listOf<Int>(3, 4, 5, 6)
val bruteForceDataSS = listOf<List<Int>>(
        bruteForceDataSS1, bruteForceDataSS2, bruteForceDataSS3
)

val bruteForceDataLS1 = listOf<Int>(1, 2, 3, 4, 5)
val bruteForceDateLS2 = listOf<Int>(2, 3, 4, 5, 6)
val bruteForceDataLS = listOf<List<Int>>(
        bruteForceDataLS1, bruteForceDateLS2
)

val bruteForceDataY1 = listOf<Int>(1, 1, 1, 1, 1)
val bruteForceDataY2 = listOf<Int>(2, 2, 2, 2, 2)
val bruteForceDataY3 = listOf<Int>(3, 3, 3, 3, 3)
val bruteForceDataY4 = listOf<Int>(4, 4, 4, 4, 4)
val bruteForceDataY5 = listOf<Int>(5, 5, 5, 5, 5)
val bruteForceDataY6 = listOf<Int>(6, 6, 6, 6, 6)
val bruteForceDataY = listOf<List<Int>>(
        bruteForceDataY1, bruteForceDataY2, bruteForceDataY3,
        bruteForceDataY4, bruteForceDataY5, bruteForceDataY6
)