package ga.evaluator

import ga.chromosome.Chromosome

abstract class Evaluator {
    abstract fun evaluate(chromosome: Chromosome): Double
}