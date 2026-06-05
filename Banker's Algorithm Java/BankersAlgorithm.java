

public class BankersAlgorithm implements BankersAlgorithmInterface {
    //where the private class is.
    private int numProcesses;
    private int numResources;
    private int[][] max;
    private int[][] allocation;
    private int[] Available;
    private boolean[] dones;
    //stops here
    public void helpprint() {
        //this is for printing the allocation array and max array
        
        System.out.println("allocation");
        System.out.println("");
        for(int i = 0; i < allocation.length; ++i) {
            for(int j = 0; j < allocation[i].length; ++j) {
                System.out.print(allocation[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("max");
        System.out.println("");
        for(int i = 0; i < max.length; ++i) {
            for(int j = 0; j < max[i].length; ++j) {
                System.out.print(max[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Need");
        System.out.println("");
        for(int i = 0; i < max.length; ++i) {
            for(int j = 0; j < max[i].length; ++j) {
                System.out.print(getNeed()[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Finish");
        System.out.println("");
        for(int i = 0; i < max.length; ++i) {
            System.out.print(dones[i] + " ");
        }        
        int[] as = getAvailable();
        System.out.println("");
        System.out.println("ava");
        for (int i = 0; i < as.length; i++) {
            System.out.print(as[i]);    
        }
    }
    public BankersAlgorithm(int numProcesses, int numResources, int[][] max, int[][] allocation) {
        setAll(numProcesses,numResources,max,allocation);
        this.dones = new boolean[numProcesses];
        this.Available = new int[numResources];
        //helpprint();
        
    }
    @Override
    public int[] getAvailable(){
        return Available;
    }
    @Override
    public boolean[] getFinish() {
        return dones;
    }
    @Override
    public int[][] getNeed() {
        int maths = 0;
        int[][] n = new int[numProcesses][numResources];
        for(int i = 0; i < max.length; ++i) {
            for(int j = 0; j < max[i].length; ++j){
                
                maths = max[i][j] - allocation[i][j];
                n[i][j] = maths;
            }
        }
        return n;
        
    }
    @Override
    public boolean isSafeState() {
        helpprint();

        int[][] needing = getNeed();
        int[] w = new int[numResources];
        for(int i = 0; i < dones.length; ++i) {
            dones[i] = false;
        }
        for(int i = 0; i < w.length; ++i) {
            w[i] = Available[i];
        }
        boolean pass = true;
        int count = 0;
        boolean a = false;
        //System.out.println("helpssssss?");
        while(count < numProcesses) {
            a = false;
            //for(int i = 0; i < getNeed().length; ++i) {
                //for(int j = 0; j < getNeed()[i].length; ++j) {
                    //needing[i][j] = getNeed()[i][j];
                //}
            //}
            for(int i = 0; i < needing.length; ++i) {
                if(!dones[i]) {
                pass = true;
                           
                for(int j = 0; j < needing[i].length; ++j) {
                    if(needing[i][j] > w[j]) {
                        pass = false;
                    }
                }
                if(pass) {
                    for(int k = 0; k < needing[i].length; ++k) {
                            w[k] += allocation[i][k];
                        }
                    getFinish()[i] = true;
                    count++;
                    a = true;
                }
            }
            }
            System.out.println("STOP");
            helpprint();
            System.out.println("");
            if(!a) {
                System.out.println("BAD");
                return false;
            }
        }

        
        return true;
    }
    @Override
    public boolean isSafeToGrant(int[] requests, int requestingProcess) throws IllegalArgumentException{
        return false;
    }
    @Override
    public void setAll(int numProcesses, int numResources, int[][] max, int[][] allocation) throws IllegalArgumentException {
        if(numProcesses > 0) {
            this.numProcesses = numProcesses;
        }
        else {
            throw new IllegalArgumentException("The number of processes is 0 or less");
        }
        if(numResources > 0) {
            this.numResources = numResources;
        }
        else {
            throw new IllegalArgumentException("The number of Resources is 0 or less");
        }
        for(int i = 0; i < allocation.length; ++i) {
            for(int j = 0; j < allocation[i].length; ++j) {
                if(allocation[i][j] > max[i][j]) {
                    throw new IllegalArgumentException("Allocation ["+ i + "][" + j + "]" + " is bigger then max[" + i +"][" + j + "]");
                }
            }
        }
        this.allocation = allocation;
        this.max = max;
        
    }
    @Override
    public void setAvailable(int[] available) {
        this.Available = available;
        //if(available.length != numResources) {
            //throw new IllegalArgumentException("this was the problem the whole time");
        //}
        
    }
    /*public static void main(String[] args) {
        int[][] max = {
            {5,3,3},
            {8,5,1},
            {0,1,2}
        };
        int[][] app = {
            {2,0,0},
            {1,2,0},
            {0,1,0}
        };
        int[] avai = {2,2,1};
        BankersAlgorithm test = new BankersAlgorithm(3,3,max,app);
        test.setAvailable(avai);
        test.helpprint();
        test.isSafeState();
        
    }*/
    public static void main(String[] args) {
    int numTests = 100; // number of random tests
    int maxProcesses = 10; // max processes for random tests
    int maxResources = 10; // max resource types for random tests
    int maxUnits = 9;    // max units per resource

    for (int t = 1; t <= numTests; t++) {
        System.out.println("=== RANDOM TEST SET " + t + " ===");

        int numProcesses = 1 + (int)(Math.random() * maxProcesses);
        int numResources = 1 + (int)(Math.random() * maxResources);

        int[][] max = new int[numProcesses][numResources];
        int[][] allocation = new int[numProcesses][numResources];
        int[] available = new int[numResources];

        // Generate max matrix and allocation matrix
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) {
                max[i][j] = 1 + (int)(Math.random() * maxUnits);
                allocation[i][j] = (int)(Math.random() * (max[i][j] + 1));
            }
        }

        // Generate available array
        for (int j = 0; j < numResources; j++) {
            int sumAllocated = 0;
            for (int i = 0; i < numProcesses; i++) {
                sumAllocated += allocation[i][j];
            }
            available[j] = (int)(Math.random() * (maxUnits - sumAllocated + 1));
        }

        // Create BankersAlgorithm instance
        BankersAlgorithm bankers = new BankersAlgorithm(numProcesses, numResources, max, allocation);
        bankers.setAvailable(available);

        // Print matrices
        System.out.println("Max Matrix:");
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) System.out.print(max[i][j] + " ");
            System.out.println();
        }

        System.out.println("Allocation Matrix:");
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) System.out.print(allocation[i][j] + " ");
            System.out.println();
        }

        System.out.println("Available Array:");
        for (int j = 0; j < numResources; j++) System.out.print(available[j] + " ");
        System.out.println();

        // Check safe state
        boolean safe = bankers.isSafeState();
        System.out.println("Is the system in a safe state? " + safe);

        System.out.println("\n----------------------------\n");
    }
}



    
}