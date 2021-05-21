import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import ga.mutation.Mutation
import ga.mutation.SimpleMutation

fun main() {
    var c: Chromosome = ChromosomeImpl()
    val smo: Mutation = SimpleMutation(0.5)
    for (i in 0..10000) {
        c = smo.mutate(c)
        println(c)
    }

}