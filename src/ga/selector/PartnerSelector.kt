package ga.selector

import ga.chromosome.Chromosome

abstract class PartnerSelector {
    abstract fun select(population: List<Chromosome>, partner: Chromosome): Chromosome
}