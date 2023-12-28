import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val matrix = Path("matrix.txt").readLines().map { it.split(",").map { num -> num.toInt() } }.toList()

    println( walkMatrix(matrix, Node(0, 0), Node(matrix.size - 1, matrix[0].size - 1)))
}

fun walkMatrix(matrix: List<List<Int>>, start: Node, end: Node): Int {
    val queue = mutableListOf<Node>()
    val visited = mutableMapOf<Node, Int>()
    queue.add(start)
    visited[start] = 0

    while (queue.isNotEmpty()) {
        val node = queue.first()
        queue.removeAt(0)

        val pathValue = visited[node]!!
        val nodeValue = matrix[node.row][node.col]

        if (node.col + 1 < matrix[0].size) {
            val right = Node(node.row, node.col + 1)
            if (visited.containsKey(right)) {
                if (visited[right]!! > pathValue + nodeValue) visited[right] = pathValue + nodeValue
            } else {
                visited[right] = pathValue + nodeValue
                queue.add(right)
            }
        }
        if (node.row + 1 < matrix.size) {
            val down = Node(node.row + 1, node.col)
            if (visited.containsKey(down)) {
                if (visited[down]!! > pathValue + nodeValue) visited[down] = pathValue + nodeValue
            } else {
                visited[down] = pathValue + nodeValue
                queue.add(down)
            }
        }
    }

    return visited[end]!! + matrix[end.row][end.col]
}