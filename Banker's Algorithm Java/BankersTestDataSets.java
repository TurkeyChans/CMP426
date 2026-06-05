public class BankersTestDataSets {

    public static class TestSet {
        public final int numProcesses;
        public final int numResources;
        public final int[][] max;
        public final int[][] allocation;
        public final int[] available;
        public final int[][] requests;        // safe/likely grantable
        public final int[][] unsafeRequests;  // unsafe requests

        public TestSet(int[][] max, int[][] allocation, int[] available,
                       int[][] requests, int[][] unsafeRequests) {
            this.numProcesses = max.length;
            this.numResources = max[0].length;
            this.max = max;
            this.allocation = allocation;
            this.available = available;
            this.requests = requests;
            this.unsafeRequests = unsafeRequests;
        }
    }

    // Example test sets
    public static final TestSet set1 = new TestSet(
        new int[][] { {7,5,3}, {3,2,2}, {9,0,2}, {2,2,2}, {4,3,3} },
        new int[][] { {0,1,0}, {2,0,0}, {3,0,2}, {2,1,1}, {0,0,2} },
        new int[] {3,3,2},
        new int[][] { {1,0,2}, {0,2,0}, {3,0,0}, {0,1,1}, {1,1,0} },
        new int[][] { {4,4,2}, {3,3,3}, {5,0,2}, {2,2,2}, {4,3,3} }
    );

    public static final TestSet set2 = new TestSet(
        new int[][] { {3,2,2}, {6,1,3}, {3,1,4}, {4,2,2} },
        new int[][] { {1,0,1}, {2,1,1}, {2,0,2}, {0,1,0} },
        new int[] {2,1,3},
        new int[][] { {0,1,1}, {2,0,1}, {1,0,2}, {0,1,0} },
        new int[][] { {3,2,2}, {5,1,3}, {3,1,4}, {4,2,2} }
    );

    public static final TestSet set3 = new TestSet(
        new int[][] { {5,3,2}, {1,2,2}, {4,3,3} },
        new int[][] { {4,2,1}, {0,1,0}, {2,1,1} },
        new int[] {1,0,2},
        new int[][] { {1,0,1}, {0,1,0}, {2,1,1} },
        new int[][] { {2,1,1}, {1,2,1}, {3,2,2} }
    );

    // Add more sets as needed
    // You can copy the pattern from your previous sets (set4 .. set13)
    
    // All test sets array for easy looping
    public static final TestSet[] allSets = { set1, set2, set3 };
}
