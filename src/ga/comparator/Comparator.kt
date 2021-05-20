package ga.comparator

import ga.chromosome.Chromosome

abstract class Comparator {
    abstract fun compare(chromosomeA: Chromosome, chromosomeB: Chromosome): Int
}