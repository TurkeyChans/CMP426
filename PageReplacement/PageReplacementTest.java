public class PageReplacementTest {
    public static void main(String[] args) {
        PageReplacement pr = new PageReplacement();

        // Reference string
        int[] refString = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6};
        pr.setReferenceString(refString);

        // Test frame sizes
        int[] frameSizes = {1, 3, 5, 6, 7};

        for(int frames : frameSizes) {
            pr.setFrameNumbers(frames);
            System.out.println("\n--- Frames: " + frames + " ---");
            System.out.println("LRU page faults: " + pr.computePageFault("LRU"));
            System.out.println("FIFO page faults: " + pr.computePageFault("FIFO"));
            System.out.println("OPT page faults: " + pr.computePageFault("OPT"));
        }
    }
}
