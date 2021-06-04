package ga.logger

import ga.chromosome.Chromosome
import ga.evaluator.Evaluator
import java.io.File

class Logger(val evaluator: Evaluator) {
    private val history = mutableListOf<MutableList<Double>>()
    fun log(population: List<Chromosome>) {
        history.add(mutableListOf<Double>(
            evaluator.min(population),
            evaluator.max(population),
            evaluator.average(population),
            evaluator.median(population)
        ))
    }
    fun printRaw() {
        for (i in history) {
            println(i)
        }
    }
    fun saveCSV() {
        File("ga.csv").printWriter().use { out ->
            history.forEach {
                out.println(it.joinToString(separator = ";"))
            }
        }
    }
}