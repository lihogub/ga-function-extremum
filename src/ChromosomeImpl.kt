import java.util.BitSet

class ChromosomeImpl(private val genomeLength: Int = 32) : Chromosome {
    private val genome = BitSet(genomeLength)

    override fun getLength(): Int = this.genome.length()

    override fun getGene(index: Int): Boolean = this.genome.get(index)

    override fun setGene(index: Int, state: Boolean) = this.genome.set(index, state)

}