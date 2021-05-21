package ga.mutation

import ga.chromosome.Chromosome

abstract class Mutation {
    abstract fun mutate(chromosome: Chromosome): Chromosome
}