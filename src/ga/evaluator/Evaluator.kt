package ga.evaluator

import ga.chromosome.Chromosome

abstract class Evaluator {
    abstract fun toValue(chromosome: Chromosome): Double
    abstract fun evaluate(chromosome: Chromosome): Double
    abstract fun average(population: List<Chromosome>): Double
    abstract fun min(population: List<Chromosome>): Double
    abstract fun max(population: List<Chromosome>): Double
    abstract fun median(population: List<Chromosome>): Double
}