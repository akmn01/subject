package com.sitech.prm.subject.jmockit;

public class OfferPostAction {  
	  
    WinportUrlServiceImpl winportUrlService ;  
  
    public boolean hasWinport(String memberId) {  
        return winportUrlService.hasWinport(memberId);  
    }  
      
    public String getWinportUrlThrowException(String memberId){  
        return winportUrlService.getWinportUrlThrowException(memberId);  
    }  
      
    public long getPostedOfferCounts(String memberId){  
        return winportUrlService.getPostedOfferCounts(memberId);  
    }  
    
    public  long getPostedOfferCounts(WinportUrlServiceImpl winportUrlService,String memberId){  
        return winportUrlService.getPostedOfferCounts(memberId);  
    } 
    
    long privateMethod(WinportUrlServiceImpl winportUrlService,String memberId){  
        return winportUrlService.getPostedOfferCounts(memberId);  
    }
}  