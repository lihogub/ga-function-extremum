package ga.chromosome

import ga.gene.Gene
import ga.gene.BinaryGene
import kotlin.random.Random

class ChromosomeImpl() : Chromosome() {
    private val genomeLength: Int = 32
    private var genome = MutableList<Gene>(genomeLength) { BinaryGene(Random.nextBoolean()) }

    constructor(value: Int): this() {
        var tmpValue = value
        for (i in 0..31) {
            this.setGene(i, BinaryGene(tmpValue % 2 == 1))
            tmpValue /= 2;
        }
    }

    constructor(chromosome: Chromosome) : this() { this.setGenome(chromosome.getGenome()) }

    override fun getLength(): Int = this.genomeLength

    override fun getGenome(): List<Gene> = this.genome.toList()

    override fun setGenome(genome: List<Gene>) { this.genome = genome.toMutableList() }

    override fun getGene(index: Int): Gene = BinaryGene(this.genome[index])

    override fun setGene(index: Int, gene: Gene) { this.genome[index] = BinaryGene(gene) }

    override fun toString(): String = "Chromosome #${this.hashCode().toString(16)} ${this.getGenome()}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChromosomeImpl
        if (genomeLength != other.genomeLength) return false
        genome.zip(other.genome).forEach{p->if (p.first != p.second) return false}
        return true
    }

    override fun hashCode(): Int {
        var result = genomeLength
        result = 31 * result + genome.hashCode()
        return result
    }


}