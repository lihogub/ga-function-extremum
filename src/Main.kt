import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import ga.crossingover.OnePointCrossingover
import ga.crossingover.UniversalCrossingover
import ga.mutation.Mutation
import ga.mutation.SimpleMutation

fun main() {
    val c1: Chromosome = ChromosomeImpl()
    val c2: Chromosome = ChromosomeImpl()
    UniversalCrossingover().crossingover(c1, c2)

}