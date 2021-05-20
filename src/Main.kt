import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import ga.mutation.MutationOperator
import ga.mutation.SimpleMutationOperator

fun main() {
    var c: Chromosome = ChromosomeImpl()
    val smo: MutationOperator = SimpleMutationOperator(0.5)
    for (i in 0..10000) {
        c = smo.mutate(c)
        println(c)
    }

}