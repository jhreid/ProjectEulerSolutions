import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val triangle = Path("triangle2.txt").readLines().map { line -> line.split(" ").map { num -> num.toInt() }.toList() }.toList()
    val start = mapOf(Node(0, 0) to triangle[0][0])

    println(dijkstra(triangle, start, 1))
}

//data class Node(val row: Int, val col: Int)


//fun dijkstra(triangle: List<List<Int>>, thisRow: Map<Node, Int>, rowNum: Int): Int {
//    val nextRow = mutableMapOf<Node, Int>()
//
//    if (rowNum == triangle.size) {
//        return thisRow.values.max()
//    }
//
//    thisRow.forEach { node, value ->
//        val left = nextRow.getOrDefault(Node(node.row + 1, node.col), value + 0)
//        val right = nextRow.getOrDefault(Node(node.row + 1, node.col + 1), value + 0)
//
//        if (triangle[node.row + 1][node.col] + value > left) {
//            nextRow.put(Node(node.row + 1, node.col), triangle[node.row + 1][node.col] + value)
//        }
//        if (triangle[node.row + 1][node.col + 1] + value > right) {
//            nextRow.put(Node(node.row + 1, node.col + 1), triangle[node.row + 1][node.col + 1] + value)
//        }
//    }
//
//    return dijkstra(triangle, nextRow, rowNum + 1)
//}