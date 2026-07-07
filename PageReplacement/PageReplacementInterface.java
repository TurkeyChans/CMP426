/**
 * In this assignment, You will a Java program call PageReplacement that implements this given interface.
 * Please note that you are not required to modify this given interface. You must implement it as it is.
 *
 * The program will  simulate the FIFO LRU, and optimal (OPT) page-replacement algorithms as discussed in class to compute page faults.
 * as part of demand paging.
 *
 * With the concept of Virtual Memory, in order to execute some process, only a part of the process needs to be present in the main memory.
 * This means that only a few pages can be present in the main memory at any time.
 * Demand Paging suggests keeping all pages of the frames in the secondary memory until they are required. A page is not loaded into memory until it is required.
 *
 * We covered these algorithms in class but if you still have difficulties understanding them, please read chapter 10 - Virtual Memory.
 *
 *
 * @author Steven Fulakeza.
 *
 */
public interface PageReplacementInterface{
	
	
	/**
     * This method is used to set the number of frames assigned to a process.
     * The number of frames has to be greater than 0. If the parameter provided, is not a positive number, just set the frame size to 3.
     *  @param frameNumbers This is the number of frames. 
     *       
     */
    public void setFrameNumbers(int frameNumbers);
   
   
    
    
    
    /**
     * This method returns the number of frames.
     * @return frame numbers
     */
    public int getFrameNumbers();

    /**
     * This method is used to set a reference string.
     * @param referenceString  the reference string
     */
    public void setReferenceString(int [] referenceString);

    /**
     * This method returns a pageReferenceString
     * @return reference String
     */
    public int [] getReferenceString();
   
   
    /**
     * This method takes a algorithm type name such as FIFO for First in First Out, OPT for Optimal,LRU for Least Recent Used,to compute and return the page faults based on the algorithm type.
     *
     * If the parameter is FIFO, the method will use the given referenceString and pageSize to compute and return the page faults of the given referenceString with the given page size for the first come First in First Out algorithm.
     * If the parameter is LRU, the method will compute and return the page faults of the given referenceString with the given page size for the least recently used algorithm.
     * If the parameter is OPT, the method will compute and return the page faults of the given referenceString with the given page size for the optimal algorithm.
     * If the parameter is not FIFO, LTU, or OPT, the method should return a -1.
     * @param algoType the name of the algorithm to execute
     * @return page faults count based on the algorithm type
     */
   
    public int computePageFault(String algoType);

}
