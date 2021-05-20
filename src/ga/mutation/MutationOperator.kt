package ga.mutation

import ga.chromosome.Chromosome

abstract class MutationOperator {
    abstract fun mutate(chromosome: Chromosome): Chromosome
}