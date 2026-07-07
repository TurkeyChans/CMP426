public class PageReplacement implements PageReplacementInterface {
    private int[] referene;
    private int frameNum;
    
    public int computePageFault(java.lang.String algoType) {
        int fault = 0;
        int Math = 0;
        boolean hit = false;
        int[] n = new int[frameNum];
        int[] array = new int[frameNum];
        int save = 0;
        
        if(algoType.equals("LRU")) {
            int finders = 0;
            for(int j = 0; j < frameNum; ++j) {
                array[j] = -1;
                n[j] = 0;
            }
            for(int i = 0; i < referene.length; ++i) {
                hit = false;
                for(int j = 0; j < array.length; ++j) {
                    if(array[j] == referene[i]) {
                        hit = true;
                        n[j] = 0;
                    }
                    else if(array[j] != -1) {
                        n[j]++;
                    }
                    
                }

                if(!hit){
                    fault++;
                    int a = -1;
                    for(int j = 0; j < frameNum; ++j) {
                        if(array[j] == -1) {
                            a = j;
                            break;
                        }
                    }
                    if(a == -1 && finders == 0) {
                        a = 0;
                        finders = 0;
                        for(int j = 1; j < frameNum; ++j) {
                        if(n[j] > n[a]) {
                            a = j;
                        }
                        
                        }
                    }
                    
                    array[a] = referene[i];
                    n[a] = 0;

                }    
                
                
            }
                
            
            return fault;
        }
        if(algoType.equals("FIFO")) {
            for(int j = 0; j < frameNum; ++j) {
                array[j] = -1;
            }
            for(int i = 0; i < referene.length; ++i) {
                hit = false;
                for(int j = 0; j < array.length; ++j) {
                    if(array[j] != -1 && array[j] == referene[i]) {
                        hit = true;
                        break;
                    }
                    
                    }
                    
                
                if(!hit){
                    fault++;
                        array[save] = referene[i];
                        save++;
                        
                        if(save >= frameNum) {
                           save = 0;

                        }
                }
            }
                
            
            return fault;
        }
        
        
    
    if(algoType.equals("OPT")) {
            int as = -1;
            int asa = -1;
            for(int j = 0; j < frameNum; ++j) {
                array[j] = -1;
            }
            for(int i = 0; i < referene.length; ++i) {
                hit = false;
                for(int j = 0; j < array.length; ++j) {
                    if(array[j] != -1 && array[j] == referene[i]) {
                        hit = true;
                        break;
                    }
                    
                    }
                    
                
                if(!hit){
                    int math = i + 1;
                    fault++;
                        int a = -1;
                        for(int j = 0; j < frameNum; ++j) {
                            if(array[j] == -1) {
                                a = j;
                                break;
                            }
                        }
                        if(a == -1) {
                            as = -1;
                            for(int j = 0; j < array.length; ++j) {
                                asa = referene.length;
                                for(int k = math; k < referene.length; ++k) {
                                    if(referene[k] == array[j]) {
                                        asa = k;
                                        break;
                                    }
                                }
                                if(asa > as) {
                                    as = asa;
                                    a = j;
                                }
                            }
                        }
                    array[a] = referene[i];
                }
            }
                
            
            return fault;
        }
    return -1;
    }

    public int getFrameNumbers() {
        return frameNum;
    }
    public int[] getReferenceString() {
        return referene;
    }
    public void setFrameNumbers(int frameNumbers) {
        if(frameNumbers > 0) {
            frameNum = frameNumbers;
        }
        else {
            frameNum = 3;
        }
        
    }
    public void setReferenceString(int[] referenceString) {
        referene = referenceString;
    }
}
