package ga.selector

import ga.chromosome.Chromosome

abstract class Selector {
    abstract fun select(population: List<Chromosome>): Chromosome
}