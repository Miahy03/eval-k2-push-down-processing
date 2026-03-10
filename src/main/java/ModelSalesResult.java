public class ModelSalesResult {
    private int getzTotal;
    private int prideTotal;
    private int lacettiTotal;

    @Override
    public String toString() {
        return "ModelSalesResult{" +
                "getzTotal=" + getzTotal +
                ", prideTotal=" + prideTotal +
                ", lacettiTotal=" + lacettiTotal +
                '}';
    }

    public ModelSalesResult(int getzTotal, int prideTotal, int lacettiTotal) {
        this.getzTotal = getzTotal;
        this.prideTotal = prideTotal;
        this.lacettiTotal = lacettiTotal;
    }

    public ModelSalesResult() {
    }

    public int getGetzTotal() {
        return getzTotal;
    }

    public void setGetzTotal(int getzTotal) {
        this.getzTotal = getzTotal;
    }

    public int getPrideTotal() {
        return prideTotal;
    }

    public void setPrideTotal(int prideTotal) {
        this.prideTotal = prideTotal;
    }

    public int getLacettiTotal() {
        return lacettiTotal;
    }

    public void setLacettiTotal(int lacettiTotal) {
        this.lacettiTotal = lacettiTotal;
    }
}
