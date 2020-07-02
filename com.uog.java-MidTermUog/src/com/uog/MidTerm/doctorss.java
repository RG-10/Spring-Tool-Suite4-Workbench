package com.uog.MidTerm;

public class doctorss {
	
	         int docid;
	         
	         String specialize;
	        
	         String docname;
		     
	         int docnum;
	         
	      public String getSpecialize() {
	             return specialize;
	      }
	      
	      public void setSpecialize(String specialize) {
	              this.specialize = specialize;
	      }
	      
	      public int getDocid() {
	              return docid;
	      }
	      
	      public void setDocid(int docid) {
	              this.docid = docid;
	      }
	      
	      public String getDocname() {
	               return docname;
	      }
	      
	      public void setDocname(String docname) {
	              this.docname = docname;
	      }
	      
	      public int getDocnum() {
	              return docnum;
	      }
	      
	      public void setDocnum(int docnum) {
	              this.docnum = docnum;
	      }
	     
	public String toString(){
		
	    return docname+" "+docid+" and "+docnum+" he specializes in"+specialize;
	    
	}
}


