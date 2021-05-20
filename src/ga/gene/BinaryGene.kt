package ga.gene

class BinaryGene(private var state: Boolean = false) : Gene() {
    constructor(gene: Gene) : this() { this.state = gene.getState() }

    override fun getState(): Boolean = this.state

    override fun setState(state: Boolean) { this.state = state }

    override fun invert() { this.state = !this.state }

    override fun toString(): String = String.format("%s", this.state.compareTo(false))
}