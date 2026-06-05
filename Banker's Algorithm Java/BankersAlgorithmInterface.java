
public interface BankersAlgorithmInterface {

    int[] getAvailable();

    boolean[] getFinish();

    int[][] getNeed();

    boolean isSafeState();

    boolean isSafeToGrant(int[] request, int requestingProcess) throws IllegalArgumentException;

    void setAll(int numProcesses, int numResources, int[][] max, int[][] allocation) throws IllegalArgumentException;

    void setAvailable(int[] available);

}
